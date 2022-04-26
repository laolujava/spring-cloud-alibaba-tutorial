package com.lutong.account.service;

import com.lutong.account.entity.Account;
import com.lutong.account.repository.AccountDao;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@Service
public class AccoutService {
    @Autowired
    private AccountDao accountDao;

    public void debit(String userId, BigDecimal money) {
        Account account = accountDao.findByUserId(userId);
        account.setMoney(account.getMoney().subtract(money));
        accountDao.save(account);
    }
}
