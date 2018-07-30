package com.cg.paymentwallet.service;

import java.time.LocalDateTime;

import com.cg.paymentwallet.dto.AccountDto;
import com.cg.paymentwallet.exception.ValidateException;
public interface IAccountService {
	public void creatAccount(AccountDto dto) throws ValidateException;
	public AccountDto getLogin(String userid, String pass) throws ValidateException;
	public double showBalance(String userid);
	public boolean depositAmount(String userId,double amount);
	public boolean withDrawAmount(String userId, double amount);
	public boolean fundTransfer(String senderNumber,String receiverNumber,double amount) throws ValidateException;
	public String printTransaction(String phnNumber);
	public boolean validate(AccountDto accountdto) throws ValidateException;
}
