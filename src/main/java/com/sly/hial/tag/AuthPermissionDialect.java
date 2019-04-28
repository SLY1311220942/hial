package com.sly.hial.tag;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.dialect.IProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

/**
 * _声明方言
 * @author sly
 * @time 2019年1月24日
 */
@Component
public class AuthPermissionDialect extends AbstractProcessorDialect implements IProcessorDialect {

	private static final String PREFIX = "mt";

	public AuthPermissionDialect() {
		super("My tag", PREFIX, StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new AuthPermissionProcessor(PREFIX));
		return processors;
	}

}
