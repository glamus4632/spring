package kr.green.springtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVo;

@Controller
//@RequestMapping(value = "/bbs")//리다이렉트로 bbs로 들어오는 애는 여기로 와라
public class boardController {
	@Autowired
	BoardService boardService;
	//게시판 리스트 리퀘스트
	@RequestMapping(value="/bbs/list")
	public String list(Model model) {//감출것이 없어서 따로 get,post를 정하지 않음
		List<BoardVo> list = boardService.getBoards();
		model.addAttribute("list",list);
		return "bbs/list";
	}
	
	//글쓰기 리퀘스트
	@RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	public String registerGet(Model model) {//감출것이 없어서 따로 get,post를 정하지 않음
		return "bbs/register";
	}
	@RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	public String registerPost(Model model) {//감출것이 없어서 따로 get,post를 정하지 않음
		return "bbs/register";
	}
	
}
