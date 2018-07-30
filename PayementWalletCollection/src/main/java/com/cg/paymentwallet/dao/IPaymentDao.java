package com.cg.paymentwallet.dao;

import com.cg.paymentwallet.dto.AccountDto;
import com.cg.paymentwallet.exception.ValidateException;

public interface IPaymentDao  {
	public void creatAccount(AccountDto dto);
	public AccountDto getLogin(String userid, String pass) throws ValidateException;
	public double showBalance(String userid);
	public void depositAmount(String userId,double amount);
	public void withDrawAmount(String userId, double amount);
	public boolean fundTransfer(String senderUserId,String receiverUserId,double amount) throws ValidateException;
	public String printTransaction(String userId);
}
