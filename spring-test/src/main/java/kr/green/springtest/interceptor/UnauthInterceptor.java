package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//권한이 있는 유저만 접근 가능하게 하는 인터셉터 (회원//로그인 한)
//로그인 했으면 글쓰기 접근 가능
public class UnauthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		//AccountVo user = (AvvountVo)session.getAttribute("user");
		if(user != null) {
			response.sendRedirect(request.getContextPath() + "/bbs/list");
			return false;
		}
		return true;
	}
	
}
