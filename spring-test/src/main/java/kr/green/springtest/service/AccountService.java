package kr.green.springtest.service;

import kr.green.springtest.vo.AccountVo;

public interface AccountService {

	public AccountVo signIn(AccountVo loginInfo);

	public boolean signUp(AccountVo userInfo);

	public boolean isDuplicated(String id);

}
