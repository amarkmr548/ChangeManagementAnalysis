package com.vz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vz.bo.OrderBO;
import com.vz.bo.UserBO;
import com.vz.dao.OrderRefDAOIface;

public class CMController extends MultiActionController{
	
	private OrderRefDAOIface orderrefdao;
	
	public OrderRefDAOIface getOrderrefdao() {
		return orderrefdao;
	}

	public void setOrderrefdao(OrderRefDAOIface orderrefdao) {
		this.orderrefdao = orderrefdao;
	}

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("login");
		String loginfail = (String)request.getAttribute("login");
		if(null != loginfail){
			view.addObject("failure","Credentials are not valid");
		}
		
		return view;
	}
	
	public ModelAndView userDetails(HttpServletRequest request, HttpServletResponse response){
		
		String user_id = request.getParameter("user_id");
		
		UserBO userBO = orderrefdao.getUserbyUserId(user_id);
		validateLogin(request,response,userBO);
		String view_mode = request.getParameter("roleselect");
		List<OrderBO> orderBOList;
		ModelAndView view = new ModelAndView("userview");
		//querying for the user_name
		if(null == view_mode || "user".equalsIgnoreCase(view_mode)){
			//querying for change orders placed by user
			orderBOList = orderrefdao.getOrderDetailsByUserId(user_id);
			//create view with the data avaiable
			view = new ModelAndView("userview");
			
			view.addObject("orderbolist", orderBOList);
		}
		else if("manager".equalsIgnoreCase(view_mode)){
			//querying for change orders placed by users under the manager
			orderBOList = orderrefdao.getOrderDetailsByManagerId(user_id);
			//create view with the data avaiable
			view = new ModelAndView("managerview");
			
			view.addObject("orderbolist", orderBOList);
		}
		
		view.addObject("user_id",user_id);
		
		return view;
	}

	private void validateLogin(HttpServletRequest request,HttpServletResponse response, UserBO userBO) {
		
		if(null == userBO){
			request.getSession(false).invalidate();
			try{
				request.setAttribute("login", "fail");
				request.getRequestDispatcher("login.htm").forward(request, response);
			}
			catch(Exception e){
				
			}
		}
	}
	
	
}
