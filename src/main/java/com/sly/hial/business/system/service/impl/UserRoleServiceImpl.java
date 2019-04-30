package com.sly.hial.business.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sly.hial.business.system.service.UserRoleService;

/**
 * 用户角色关系service实现
 * @author sly
 * @time 2019年4月30日
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserRoleServiceImpl implements UserRoleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleServiceImpl.class);
}

