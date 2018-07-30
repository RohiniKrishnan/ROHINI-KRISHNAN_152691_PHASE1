
package com.cg.paymentwallet.service;

import com.cg.paymentwallet.dao.PaymentDaoImpl;
import com.cg.paymentwallet.dto.AccountDto;
import com.cg.paymentwallet.exception.IValidateException;
import com.cg.paymentwallet.exception.ValidateException;

public class AccountServiceImpl implements  IAccountService{
	
	AccountDto dto=new AccountDto();
	PaymentDaoImpl dao=new PaymentDaoImpl();
		
	public boolean validate(AccountDto dto) throws ValidateException {
		boolean result=false;
		String namePattern="[A-Z a-z]+";
		String noPattern="[0-9]{10}";
		String emailPattern="[a-z]{1}[a-z 0-9_]+@gmail.com";
		if(dto.getName().matches(namePattern)) {
			if(dto.getPhNum().matches(noPattern)) {
				if(dto.getEmail().matches(emailPattern)) {
					result=true;
				}else throw new ValidateException(IValidateException.Error3);
			}else throw new ValidateException(IValidateException.Error2);
		}else throw new ValidateException(IValidateException.Error1);
		return result;
	}
		public void creatAccount(AccountDto dto) {
				
		dao.creatAccount(dto);
	}
		public AccountDto getLogin(String userid, String pass) throws ValidateException {
			return dao.getLogin(userid, pass);
		}
		
	
		public double showBalance(String userid) {
		 return dao.showBalance(userid);
	}
		public boolean depositAmount(String userId,double amount) {
			boolean result= false;
					if(amount>0) {
						dao.depositAmount(userId, amount);
						result=true;
					}
		return result;
	}
	
	public boolean withDrawAmount(String userId, double amount) {
		boolean result=false;
		if(amount>0) {
			dao.withDrawAmount(userId, amount);
			result=true;
		}
		return result;
	}
	public boolean fundTransfer(String senderUserId,String receiverUserId,double amount) throws ValidateException {
		boolean result=false;
		if(dao.showBalance(senderUserId)>=amount) {
			if(dao.fundTransfer(senderUserId, receiverUserId, amount)) {
				result=true;
			}
		}
		return result;
	}
	public String printTransaction(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
