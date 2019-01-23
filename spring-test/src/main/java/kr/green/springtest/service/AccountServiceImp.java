package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.AccountDao;
import kr.green.springtest.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountDao accountDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//회원가입 서비스
	@Override
	public AccountVo signIn(AccountVo loginInfo) {
		//AccountVo id = loginInfo;
		//AccountVo user = accountDao.getAccount(id.getId());
		AccountVo user = accountDao.getAccount(loginInfo.getId());//비밀번호는 암호화 되어 있으니까 필요가 없다.
		if(passwordEncoder.matches(loginInfo.getPw(), user.getPw())) return user;
		return null;
	}

}
