package com.sly.hial.business.blog.model;

import java.io.Serializable;

/**
 * 文章实体类
 * 
 * @author sly
 * @time 2019年5月5日
 */
public class Content implements Serializable {

	private static final long serialVersionUID = -9189154488231125004L;

	/** varchar(32) NOT NULL文章id uuid */
	private String contentId;
	/** varchar(64) NULL文章标题 */
	private String title;
	/** text NULL文章内容 */
	private String content;
	/** tinyint(4) NULL文章类型code */
	private Integer contentTypeCode;
	/** varchar(32) NULL文章类型名称 */
	private String contentTypeName;
	/** char(1) NULL是否公开:Y.是 N.否 */
	private String isPublish;
	/** json NULL文章标签 */
	private String tags;
	/** int(11) NULL点击数 */
	private Integer hit;
	/** varchar(24) NULL创建时间 */
	private String createTime;
	/** varchar(24) NULL修改时间 */
	private String updateTime;
	/** varchar(24) NULL删除时间 */
	private String deleteTime;
	/** varchar(32) NULL创建用户ID */
	private String userId;
	/** varchar(32) NULL创建用户名称 */
	private String username;
	/** char(1) NULL逻辑删除:Y.删除 N.未删除 */
	private String logicDel;

	protected String getContentId() {
		return contentId;
	}

	protected void setContentId(String contentId) {
		this.contentId = contentId;
	}

	protected String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
	}

	protected Integer getContentTypeCode() {
		return contentTypeCode;
	}

	protected void setContentTypeCode(Integer contentTypeCode) {
		this.contentTypeCode = contentTypeCode;
	}

	protected String getContentTypeName() {
		return contentTypeName;
	}

	protected void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}

	protected String getIsPublish() {
		return isPublish;
	}

	protected void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

	protected String getTags() {
		return tags;
	}

	protected void setTags(String tags) {
		this.tags = tags;
	}

	protected Integer getHit() {
		return hit;
	}

	protected void setHit(Integer hit) {
		this.hit = hit;
	}

	protected String getCreateTime() {
		return createTime;
	}

	protected void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	protected String getUpdateTime() {
		return updateTime;
	}

	protected void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
