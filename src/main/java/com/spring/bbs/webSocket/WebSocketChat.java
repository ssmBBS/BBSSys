package com.spring.bbs.webSocket;

import com.spring.bbs.entity.Account;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/9 0009.
 */
@ServerEndpoint("/Chat")
public class WebSocketChat {
    private static Set<WebSocketChat>connections=new HashSet<WebSocketChat>();
        private Account account=new Account();
    private Session session;
    @OnOpen
    public void start(Session session){
        this.session=session;
        int id=Integer.parseInt(session.getId());
        System.out.println(id);
        account.setId(id);
        //将该WebSocket端点加入Set集合
        connections.add(this);
    }
    @OnMessage
    public void incoming(String message){
        broadcast(message);
    }
    @OnClose
    public void end(){
        connections.remove(this);
    }
    /*使用群发的方式将此信息传给所有人*/
    private static void broadcast(String msg){
        for (WebSocketChat client:connections){
            try {
                client.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
                //删除集合中这个点
                connections.remove(client);
                try {
                    client.clone();
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
