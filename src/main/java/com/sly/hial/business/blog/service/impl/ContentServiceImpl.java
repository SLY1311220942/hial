package com.sly.hial.business.blog.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.hial.business.blog.service.ContentService;

/**
 * 文章service实现类
 * @author sly
 * @time 2019年5月5日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ContentServiceImpl implements ContentService {

}
