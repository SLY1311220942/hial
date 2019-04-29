package com.sly.hial.plugins.ik;

import org.apache.lucene.analysis.Analyzer;

/**
 * 分析器
 * 
 * @author sly
 * @time 2019年4月18日
 */
public class IKAnalyzerLucene7 extends Analyzer {
	private boolean useSmart = false;

	public IKAnalyzerLucene7() {
		this(false);
	}

	public IKAnalyzerLucene7(boolean useSmart) {
		super();
		this.useSmart = useSmart;
	}

	public boolean isUseSmart() {
		return useSmart;
	}

	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {
		IKTokenizerLucene7 tk = new IKTokenizerLucene7(this.useSmart);
		return new TokenStreamComponents(tk);
	}

}
