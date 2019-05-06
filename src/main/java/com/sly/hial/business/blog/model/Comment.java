package com.sly.hial.business.blog.model;

import java.io.Serializable;

/**
 * 评论实体类
 * 
 * @author sly
 * @time 2019年5月5日
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = 6240344988550119435L;

	/** varchar(32) NOT NULL评论id uuid */
	private String commentId;
	/** text NULL评论内容 */
	private String comment;
	/** varchar(32) NULL评论所属文章id */
	private String contentId;
	/** tinyint(1) NULL回复对象类型:1.文章 2.回复 */
	private Integer repeatType;
	/** varchar(32) NULL回复对象Id */
	private String repeatUserId;
	/** varchar(32) NULL回复对象名称 */
	private String repeatUsername;
	/** varchar(24) NULL创建时间 */
	private String createTime;
	/** varchar(24) NULL删除时间 */
	private String deleteTime;
	/** varchar(32) NULL创建用户id */
	private String userId;
	/** varchar(32) NULL创建用户名称 */
	private String username;
	/** char(1) NULL逻辑删除:Y.删除 N.未删除 */
	private String logicDel;

	protected String getCommentId() {
		return commentId;
	}

	protected void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	protected String getComment() {
		return comment;
	}

	protected void setComment(String comment) {
		this.comment = comment;
	}

	protected String getContentId() {
		return contentId;
	}

	protected void setContentId(String contentId) {
		this.contentId = contentId;
	}

	protected Integer getRepeatType() {
		return repeatType;
	}

	protected void setRepeatType(Integer repeatType) {
		this.repeatType = repeatType;
	}

	protected String getRepeatUserId() {
		return repeatUserId;
	}

	protected void setRepeatUserId(String repeatUserId) {
		this.repeatUserId = repeatUserId;
	}

	protected String getRepeatUsername() {
		return repeatUsername;
	}

	protected void setRepeatUsername(String repeatUsername) {
		this.repeatUsername = repeatUsername;
	}

	protected String getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	protected String getDeleteTime() {
		return deleteTime;
	}

	protected void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	protected String getUserId() {
		return userId;
	}

	protected void setUserId(String userId) {
		this.userId = userId;
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected String getLogicDel() {
		return logicDel;
	}

	protected void setLogicDel(String logicDel) {
		this.logicDel = logicDel;
	}

}
