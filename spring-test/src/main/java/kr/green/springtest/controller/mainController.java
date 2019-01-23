package kr.green.springtest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.springtest.service.AccountService;
import kr.green.springtest.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class mainController {
	@Autowired
	AccountService accountService;
	//로그인 리퀘스트
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model,AccountVo loginInfo) {
		AccountVo user = accountService.signIn(loginInfo);
		model.addAttribute("user",user);
		return "redirect:/";
	}
	
	//회원가입 리퀘스트
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model) {
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model,AccountVo userInfo) {
		boolean isUser = accountService.signUp(userInfo);//id중복검사를 위해 boolean 타입
		if(isUser)
			return "redirect:/";
		return "redirect:/signup";
	}
	@RequestMapping(value="/signup/dup")
	@ResponseBody//응답할때 정보를 전달
	public Map<Object, Object>idcheck(@RequestBody String id){//요청을 요구한 쪽에 데이터를 전달
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean dup = accountService.isDuplicated(id);
		map.put("dup",dup);
		return map;
	}
	
}
