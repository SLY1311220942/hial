package com.sly.hial.business.blog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.hial.business.blog.service.CommentService;
import com.sly.hial.business.system.service.impl.DicCodeServiceImpl;

/**
 * 评论service实现类
 * @author sly
 * @time 2019年5月5日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DicCodeServiceImpl.class);
}
