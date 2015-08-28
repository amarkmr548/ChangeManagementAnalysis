package com.vz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vz.bo.OrderBO;
import com.vz.bo.UserBO;
import com.vz.dao.OrderRefDAO;

public class CMController extends MultiActionController{

	private OrderRefDAO orderRefDAO;
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("login");
		
		return view;
	}
	
	public ModelAndView userDetails(HttpServletRequest request, HttpServletResponse response){
		
		String user_id = request.getParameter("user_id");
		
		UserBO userBO = orderRefDAO.getUserbyUserId(user_id);
		validateLogin(request,response,userBO);
		String view_mode = request.getParameter("mode");
		List<OrderBO> userBOList;
		ModelAndView view = new ModelAndView("userview");;
		//querying for the user_name
		if(null == view_mode || "User".equalsIgnoreCase(view_mode)){
			//querying for change orders placed by user
			userBOList = orderRefDAO.getOrderDetailsByUserId(user_id);
			//create view with the data avaiable
			view = new ModelAndView("userview");
			
			view.addObject("userbolist", userBOList);
		}
		else if("manager".equalsIgnoreCase(view_mode)){
			//querying for change orders placed by users under the manager
			userBOList = orderRefDAO.getOrderDetailsByManagerId(user_id);
			//create view with the data avaiable
			view = new ModelAndView("managerview");
			view.addObject("userbolist", userBOList);
		}
		
		 
		
		return view;
	}

	private void validateLogin(HttpServletRequest request,HttpServletResponse response, UserBO userBO) {
		
		if(null == userBO){
			request.getSession(false).invalidate();
			try{
				request.getRequestDispatcher("login.htm").forward(request, response);
			}
			catch(Exception e){
				
			}
		}
	}
	
	
}
