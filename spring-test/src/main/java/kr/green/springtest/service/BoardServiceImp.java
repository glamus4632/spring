package kr.green.springtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDao;
import kr.green.springtest.vo.AccountVo;
import kr.green.springtest.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}

	@Override
	public void registerBoard(BoardVo boardVo) {
		boardDao.setBoard(boardVo);
		
	}
	//글쓰기 서비스
	@Override
	public BoardVo getDetail(Integer id) {
		if(id == null)
			return null;
		return (BoardVo) boardDao.getBoard(id);
	}
	//글 삭제 서비스
	@Override
	public void delBoard(Integer id, AccountVo user) {
		BoardVo board = boardDao.getBoard(id);
		/*
		 * 1. 해당 id를 가진 게시글이 없거나 이미 삭제('D')이면 바로 종료
		 * 2. 로그인한 유저가 게시판 작성자가 아닌경우 바로 종료
		 * */
		if(board == null || !board.getWriter().equals(user.getId()))
			return ;
		board.setState("D");//boardVo의 state를 D로 
		boardDao.updateBoard(board);
		/* 업데이트보드는 게시판 삭제와 수정에 모두 쓰일 수 있기 때문에 del을 따로 만들지 않는다
		 * */
	}
	//글 수정 서비스

	@Override
	public boolean modifyBoard(BoardVo board, AccountVo user) {
		BoardVo oriBoard = boardDao.getBoard(board.getId());
		System.out.println(oriBoard.getWriter().equals(user.getId()));
		if(oriBoard == null || !oriBoard.getWriter().equals(user.getId()))
			return false;
		board.setRegisterd_date(oriBoard.getRegisterd_date());
		board.setState(oriBoard.getState());
		boardDao.updateBoard(board);
		return true;
	}





}
