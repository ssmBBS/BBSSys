package com.spring.bbs.web;

import com.spring.bbs.dto.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/5/11 0011.
 */
public class relationController {
    @RequestMapping(value = "addFriends")
    @ResponseBody
    Object addFriends(@RequestParam("friendName")String friendName, HttpSession session){
        return new ResultInfo();
    }
}
