package com.vz.dao;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.vz.bo.OrderBO;
import com.vz.bo.UserBO;

public class OrderRefDAO extends AbstractJdbcDAO implements OrderRefDAOIface {
	public List<OrderBO> getOrderDetailsByUserId(String user_id){
		String query = "select * from common_ref.order_ref where edited_user_id = ?";
		
		List<OrderBO> orderbolist = this.getJdbcTemplate().query(query, new Object[]{user_id},new BeanPropertyRowMapper(OrderBO.class));
		return orderbolist;
	}
	
	public List<OrderBO> getOrderDetailsByManagerId(String user_id){
		String query = "select order_id,reason_code,comments,review,edited_user_id,review_comments from common_ref.order_ref o, common_ref.user_ref u where u.manager_id = ? and u.user_id = o.edited_user_id";
		
		List<OrderBO> orderbolist = this.getJdbcTemplate().query(query, new Object[]{user_id},new BeanPropertyRowMapper(OrderBO.class));
		return orderbolist;
	}
	
	public List<UserBO> getUsersbyManagerId(String manager_id){
		String query = "";
		
		List<UserBO> userbolist = this.getJdbcTemplate().query(query,new Object[]{manager_id}, new BeanPropertyRowMapper(UserBO.class));
		
		return userbolist;
	}
	
	public UserBO getUserbyUserId(String user_id){
		String query = "select * from common_ref.user_ref where user_id = ?";
		
		List<UserBO> userbolist = this.getJdbcTemplate().query(query, new Object[]{user_id},new BeanPropertyRowMapper(UserBO.class));
		if(!userbolist.isEmpty()){
			return userbolist.get(0);
		}
		else{
			
			return null;
		}
		
	}
}
