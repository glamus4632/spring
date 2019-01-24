package kr.green.springtest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Controller
//@RequestMapping(value = "/bbs")//리다이렉트로 bbs로 들어오는 애는 여기로 와라
public class boardController {
	@Autowired
	BoardService boardService;
	
	//로그아웃 리퀘스트
	@RequestMapping(value="/signout")
	public String signout(Model model, HttpServletRequest request) {//감출것이 없어서 따로 get,post를 정하지 않음
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}
	//게시판 리스트 리퀘스트
	@RequestMapping(value="/bbs/list")
	public String list(Model model) {//감출것이 없어서 따로 get,post를 정하지 않음
		List<BoardVo> list = boardService.getBoards();
		model.addAttribute("list",list);
		return "bbs/list";
	}
	
	//글쓰기 리퀘스트
	@RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	public String registerGet(Model model) {
		return "bbs/register";
	}
	@RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	public String registerPost(BoardVo boardVo) {
		boardService.registerBoard(boardVo);
		return "redirect:/bbs/list";
	}
	
	//글 보기 리퀘스트
	@RequestMapping(value="/bbs/detail", method=RequestMethod.GET)
	public String detail(Model model, Integer id) {
		BoardVo board = boardService.getDetail(id);
				if(board == null)	//게시글이 없으면 목록으로
			return "redirect:/bbs/list";
		model.addAttribute("detail",board);

		return "bbs/detail";
	}
	
	//글삭제 리퀘스트
	@RequestMapping(value="/bbs/delete")
	public String deleteGet(Integer id, Model model, HttpServletRequest request) {
		//request = 리퀘스트에서 세션정보를 가져와 session에 저장된 유저 정보를 가져옴
		HttpSession session = request.getSession();//세션정보를 session에 전달
		AccountVo user = (AccountVo) session.getAttribute("user");//현재 접속한 유저정보를 user에 저장
		//삭제권한이 없는 유저의 접근을 막기위해 게시판id와 현재 로그인한 유저의 정보를 전달한다
		boardService.delBoard(id, user);
		return "redirect:/bbs/list";
	}
	
	//글 업데이트 리퀘스트
	@RequestMapping(value="/bbs/modify", method=RequestMethod.GET)
	public String modifyGet(Model model, Integer id) {
		BoardVo board = boardService.getDetail(id);
		if(board == null)	//게시글이 없으면 목록으로
			return "redirect:/bbs/list";
		model.addAttribute("detail",board);
		return "bbs/modify";
	}
	@RequestMapping(value="/bbs/modify", method=RequestMethod.POST)
	public String modifyPost(BoardVo board, Model model, HttpServletRequest request) {
		//권한이 있는 사람만 수정 가능하게 하기 위해서
		System.out.println(board.getId());
		HttpSession session = request.getSession();//세션정보를 session에 전달
		AccountVo user = (AccountVo) session.getAttribute("user");//현재 접속한 유저정보를 user에 저장
		//리턴된 값이 false면 게시판으로 이동(계정이 작성자가 아니거나 db에 저장된게 없거나)
		if(!boardService.modifyBoard(board, user))
			return "redirect:/bbs/list";
		
		model.addAttribute("id",board.getId());
		return "redirect:/bbs/detail";
	}
}
