package com.spring.jdbc.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("accountManage")
public class AccountManageImpl implements AccountManage {

    @Autowired
    private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAccount(Account account) {
        String sql = "INSERT INTO account(userName, balance) VALUES(?, ?)";
        jdbcTemplate.update(sql, account.getUserName(), account.getBalance());
        System.out.println("添加成功");
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "UPDATE account SET userName=?, balance=? WHERE id=?";
        jdbcTemplate.update(sql, account.getUserName(), account.getBalance(), account.getId());
        System.out.println("更新成功");
    }

    @Override
    public Account queryAccountById(Integer id) {
        String sql = "SELECT * FROM account WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), id);
    }

    @Override
    public List<Account> queryAllAccount() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public void deleteAccount(Integer id) {
        String sql = "DELETE FROM account WHERE id=?";
        jdbcTemplate.update(sql, id);
        System.out.println("删除成功");
    }

    @Override
    @Transactional
    public void transfer(Integer outId, Integer inId, Double money) {
        String sqlOut = "UPDATE account SET balance = balance - ? WHERE id = ?";
        jdbcTemplate.update(sqlOut, money, outId);

        String sqlIn = "UPDATE account SET balance = balance + ? WHERE id = ?";
        jdbcTemplate.update(sqlIn, money, inId);

        System.out.println("转账成功！");
    }
}
