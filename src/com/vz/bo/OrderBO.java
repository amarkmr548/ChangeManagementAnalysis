package com.vz.bo;

public class OrderBO {
	private String order_id;
	private String reason_code;
	
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getReason_code() {
		return reason_code;
	}
	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public char getReview() {
		return review;
	}
	public void setReview(char review) {
		this.review = review;
	}
	private String comments;
	public String getReview_comments() {
		return review_comments;
	}
	public void setReview_comments(String review_comments) {
		this.review_comments = review_comments;
	}
	private char review;
	private String review_comments;
	
	public String getEdited_user_id() {
		return edited_user_id;
	}
	public void setEdited_user_id(String edited_user_id) {
		this.edited_user_id = edited_user_id;
	}
	private String edited_user_id;
	
	
	
}
