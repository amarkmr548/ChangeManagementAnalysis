package com.vz.dao;

import java.util.List;

import com.vz.bo.OrderBO;
import com.vz.bo.UserBO;

public interface OrderRefDAOIface {
	public List<OrderBO> getOrderDetailsByUserId(String user_id);
	public List<OrderBO> getOrderDetailsByManagerId(String user_id);
	public List<UserBO> getUsersbyManagerId(String manager_id);
	public UserBO getUserbyUserId(String user_id);
}
