package kr.green.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value = "/bbs")//리다이렉트로 bbs로 들어오는 애는 여기로 와라
public class boardController {
	@RequestMapping(value="/bbs/list")
	public String list() {//감출것이 없어서 따로 get,post를 정하지 않음
		return "bbs/list";
	}
	
}
