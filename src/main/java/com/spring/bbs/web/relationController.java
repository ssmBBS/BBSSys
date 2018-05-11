package com.spring.bbs.web;

import com.spring.bbs.dao.FriendDao;
import com.spring.bbs.dto.ResultInfo;
import com.spring.bbs.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/5/11 0011.
 */
public class relationController {
    @Autowired
    FriendDao friendDao;
    @RequestMapping(value = "addFriends")
    @ResponseBody
    Object addFriends(@RequestParam("friendName")String friendName, HttpSession session){
        ResultInfo resultInfo=new ResultInfo();
        Account account= (Account) session.getAttribute("account");
        friendDao.insertByName(account.getAccountName(),friendName);
        resultInfo.setResult(true);
        return new ResultInfo();
    }
}
