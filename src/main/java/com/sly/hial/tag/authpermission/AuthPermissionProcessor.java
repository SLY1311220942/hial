package com.sly.hial.tag.authpermission;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * _处理器
 * @author sly
 * @time 2019年1月24日
 */
public class AuthPermissionProcessor extends AbstractElementTagProcessor {
	private static final int PRECEDENCE = 10000;
	private static final String TAG_NAME = "auth";
	
	public AuthPermissionProcessor(String dialectPrefix) {
		super(
				// 此处理器将仅应用于HTML模式
				TemplateMode.HTML,
				// 要应用于名称的匹配前缀
				dialectPrefix,
				// 标签名称：匹配此名称的特定标签
				TAG_NAME,
				// 没有要应用于标签名称的前缀
				true,
				// true有属性名称：将通过标签名称和属性名称匹配，false无属性名称：将通过标签名称匹配
				null,
				// 没有要应用于属性名称的前缀
				false,
				// 优先(内部方言自己的优先)
				PRECEDENCE);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		//获取元素名称
		System.out.println(tag.getElementCompleteName());
		
		IAttribute url = tag.getAttribute("url");
		System.out.println("匹配上:" + url.getValue());
		if (url.getValue().equals("/haha")) {
			structureHandler.removeElement();
		} else {
			structureHandler.removeTags();
		}
		
	}

}
