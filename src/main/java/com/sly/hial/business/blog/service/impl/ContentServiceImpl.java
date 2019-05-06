package com.sly.hial.business.blog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.hial.business.blog.service.ContentService;
import com.sly.hial.business.system.service.impl.DicCodeServiceImpl;

/**
 * 文章service实现类
 * @author sly
 * @time 2019年5月5日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ContentServiceImpl implements ContentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DicCodeServiceImpl.class);
}
