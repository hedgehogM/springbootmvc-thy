package com.hlm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hlm.command.UsersCommand;


@Controller
public class UsersController {

	/**
	 * 登首页
     * @return
     */
	@RequestMapping("/index")
	public String index(){
		return "index.html";
	}
	
	/**
     * 到跳转页    
     * @param req
     * @return
     */
	@RequestMapping("/index2")
	public String index2(){
		return "index2";
	}
	
	/**
     * 到跳转页    
     * @param req
     * @return
     */
	@RequestMapping("/index3")
	public ModelAndView sigup(HttpServletRequest req){
		
		ModelAndView mv = new ModelAndView();

		UsersCommand cmd = new UsersCommand("小明",0,"admin@hlm.com",1,"123456");

		req.getSession().setAttribute("user", cmd);
		mv.addObject("password", cmd.getPassword());
		mv.addObject("userName", cmd.getUserName());
		mv.setViewName("/index3/index3");
		return mv;
		
	}
}