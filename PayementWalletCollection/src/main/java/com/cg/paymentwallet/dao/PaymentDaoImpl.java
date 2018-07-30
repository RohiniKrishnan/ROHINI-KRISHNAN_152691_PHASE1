package com.cg.paymentwallet.dao;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.paymentwallet.dto.AccountDto;
import com.cg.paymentwallet.exception.IValidateException;
import com.cg.paymentwallet.exception.ValidateException;

public class PaymentDaoImpl implements IPaymentDao {

	private static HashMap<String, AccountDto> hashmap = new HashMap<String, AccountDto>();
	
	public void creatAccount(AccountDto dto) {
		
		hashmap.put(dto.getUserId(), dto);
	}

	public AccountDto getLogin(String userid, String pass) throws ValidateException {

		AccountDto account = null;
		if ((hashmap.containsKey(userid)) && (hashmap.get(userid).getPassWord().equals(pass))) {
			account = hashmap.get(userid);
		} else
			throw new ValidateException(IValidateException.Error4);
		return account;

	}

	public double showBalance(String userid) {
		return hashmap.get(userid).getBalance();
	}

	public void depositAmount(String userId, double amount) {
		hashmap.get(userId).setBalance(hashmap.get(userId).getBalance() + amount);
		LocalDateTime date=LocalDateTime.now();
		hashmap.get(userId).setTransaction("Rupees"+amount+"Deposit at"+date);

	}

	public void withDrawAmount(String userId, double amount) {
		hashmap.get(userId).setBalance(hashmap.get(userId).getBalance() - amount);
		LocalDateTime date=LocalDateTime.now();
		hashmap.get(userId).setTransaction("Rupees"+amount+"WithDraw at"+date);

	}

	public boolean fundTransfer(String senderUserId, String receiverUserId, double amount) throws ValidateException {
		boolean result = false;
		if (hashmap.containsKey(receiverUserId)) {
			hashmap.get(senderUserId).setBalance(hashmap.get(senderUserId).getBalance() - amount);
			hashmap.get(receiverUserId).setBalance(hashmap.get(receiverUserId).getBalance() + amount);
			hashmap.get(senderUserId).setTransaction("Rupees " + amount + " Transfered to " + receiverUserId);
			hashmap.get(receiverUserId).setTransaction("Rupees " + amount + " Received from " + senderUserId);
			result = true;
		}
		else throw new ValidateException(IValidateException.Error5);
			return result;
	}
	public String printTransaction(String userId) {
		return null;
		
	}

}
