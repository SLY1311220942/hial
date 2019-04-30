package com.sly.hial.plugins.ik;

import java.io.IOException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * 重写的分词器 这个类必须加final,不然会报错
 * 
 * @author sly
 * @time 2019年4月18日
 */
public final class IkTokenizerLucene7 extends Tokenizer {

	/** IK分词器实现 */
	private IKSegmenter iKImplement;
	/** 词元文本属性 */
	private final CharTermAttribute termAtt;
	/** 词元位移属性 */
	private final OffsetAttribute offsetAtt;
	/** 词元分类属性（该属性分类参考org.wltea.analyzer.core.Lexeme中的分类常量） */
	private final TypeAttribute typeAtt;
	/** 记录最后一个词元的结束位置 */
	private int endPosition;

	/**
	 * 
	 * @param useSmart
	 * @author sly
	 * @time 2019年4月18日
	 */
	public IkTokenizerLucene7(boolean useSmart) {
		super();
		offsetAtt = addAttribute(OffsetAttribute.class);
		termAtt = addAttribute(CharTermAttribute.class);
		typeAtt = addAttribute(TypeAttribute.class);
		iKImplement = new IKSegmenter(input, useSmart);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 * @author sly
	 * @time 2019年4月18日
	 */
	@Override
	public boolean incrementToken() throws IOException {
		// 清除所有的词元属性
		clearAttributes();
		Lexeme nextLexeme = iKImplement.next();
		if (nextLexeme != null) {
			// 将Lexeme转成Attributes
			// 设置词元文本
			termAtt.append(nextLexeme.getLexemeText());
			// 设置词元长度
			termAtt.setLength(nextLexeme.getLength());
			// 设置词元位移
			offsetAtt.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());
			// 记录分词的最后位置
			endPosition = nextLexeme.getEndPosition();
			// 记录词元分类
			typeAtt.setType(nextLexeme.getLexemeTypeString());
			// 返会true告知还有下个词元
			return true;
		}
		// 返会false告知词元输出完毕
		return false;
	}

	/**
	 * 
	 * @throws IOException
	 * @author sly
	 * @time 2019年4月18日
	 */
	@Override
	public void reset() throws IOException {
		super.reset();
		iKImplement.reset(input);
	}

	/**
	 * 
	 * 
	 * @author sly
	 * @time 2019年4月18日
	 */
	@Override
	public final void end() {
		// set final offset
		int finalOffset = correctOffset(this.endPosition);
		offsetAtt.setOffset(finalOffset, finalOffset);
	}

}
