package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private BasicDao dao;

    public BasicDao getDao() {
        return dao;
    }

    public void setDao(BasicDao dao) {
        this.dao = dao;
    }

    private void validAccount(Account account) {
        if(account.getId()==null) throw new ValidException("The id is null");
    }

    @Override
    public Long createAccount(Account account) {
        validAccount(account);
        return dao.insert(account);
    }

    @Override
    public void modifyAccount(Account account) {
        validAccount(account);
        account.setUpdateTime(DateUtils.getNow());
        dao.update(account);
    }

    @Override
    public void removeAccount(Long id) {
        dao.delete(id, Account.class);
    }

    @Override
    public Account getAccount(Long id) {
        return dao.load(id, Account.class);
    }

    @Override
    public Double topUp(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%] or amount[%] is null", id, amount);
        Account account = getAccount(id);
        if(account==null)
            throw new ValidException("The account[%] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }

    @Override
    public Double payoff(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%] or amount[%] is null", id, amount);
        Account account = getAccount(id);
        if(account==null)
            throw new ValidException("The account[%] isn't available", id);
        if(account.getBalance() < amount)
            throw new ValidException("The account[%] has no enough money[%]", id, account.getBalance());
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }

    @Override
    public Double refund(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%] or amount[%] is null", id, amount);
        Account account = getAccount(id);
        if(account==null)
            throw new ValidException("The account[%] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }
}
