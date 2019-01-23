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
		if(user != null && passwordEncoder.matches(loginInfo.getPw(), user.getPw()))
			return user;
		return null;
	}

	@Override
	public boolean signUp(AccountVo userInfo) {
		if(accountDao.getAccount(userInfo.getId()) != null)
			return false;//이미 있으니까 실패
		String encPw = passwordEncoder.encode(userInfo.getPw());//비밀번호 암호화
		userInfo.setPw(encPw);//암호화 한 비밀번호 set
		accountDao.setAccount(userInfo);//set 된 비밀번호를 포함한 Vo를 가져옴
		return true;//null이면 성공
	}

	@Override
	public boolean isDuplicated(String id) {
		if(accountDao.getAccount(id)!=null)//이미 있으면 중복이니까 참
			return true;
		return false;//없으면 거짓 반환
	}

}
