package com.sly.hial.business.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.hial.business.blog.service.CommentService;

/**
 * 评论service实现类
 * @author sly
 * @time 2019年5月5日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CommentServiceImpl implements CommentService {

}
