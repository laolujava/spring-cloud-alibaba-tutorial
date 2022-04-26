package com.lutong.account.repository;

import com.lutong.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lutong
 */
public interface AccountDao extends JpaRepository<Account,Long> {

    //根据用户id查询账户余额
    Account findByUserId(String userId);

}
