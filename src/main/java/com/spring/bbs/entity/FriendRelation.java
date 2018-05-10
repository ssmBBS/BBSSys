package com.spring.bbs.entity;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/5/11 0011.
 */
public class FriendRelation {
    private Integer account1id;
    private Integer account2id;

    public FriendRelation(Integer account1id, Integer account2id) {
        this.account1id = account1id;
        this.account2id = account2id;
    }

    public Integer getAccount1id() {
        return account1id;
    }

    public void setAccount1id(Integer account1id) {
        this.account1id = account1id;
    }

    public Integer getAccount2id() {
        return account2id;
    }

    public void setAccount2id(Integer account2id) {
        this.account2id = account2id;
    }
}
