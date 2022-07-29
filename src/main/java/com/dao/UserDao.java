package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	
	@Autowired 
	JdbcTemplate stmt;
	
	public void saveAllUser(UserBean user) {
		 stmt.update("insert into users_table(firstname, lastname, gender, email, password, usertype) values (?,?,?,?,?,?)", user.getFirstName() ,user.getLastName(), user.getGender(), user.getEmail(), user.getPassword(), user.getUserType());
		
	}

	public List<UserBean> getAllUser() {
		return stmt.query("select * from users_table", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

}
