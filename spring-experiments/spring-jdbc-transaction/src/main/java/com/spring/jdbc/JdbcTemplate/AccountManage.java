package com.spring.jdbc.JdbcTemplate;

import java.util.List;

public interface AccountManage {
    void addAccount(Account account);

    void updateAccount(Account account);

    Account queryAccountById(Integer id);

    List<Account> queryAllAccount();

    void deleteAccount(Integer id);

    void transfer(Integer outId, Integer inId, Double money);
}
