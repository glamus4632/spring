package kr.green.springtest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.springtest.vo.AccountVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(//컨트롤러로 가기 전 인터셉트
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    AccountVo user = (AccountVo)modelMap.get("user");
	    //AccountVo user = (AccountVo)modelAndView.getModelMap().get("user");
	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        //request.getSession().setAttribute("user", user);
	    }
	}
}
