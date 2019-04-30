package com.sly.hial.plugins.ik;

import org.apache.lucene.analysis.Analyzer;

/**
 * 分析器
 * 
 * @author sly
 * @time 2019年4月18日
 */
public class IkAnalyzerLucene7 extends Analyzer {
	private boolean useSmart = false;

	public IkAnalyzerLucene7() {
		this(false);
	}

	public IkAnalyzerLucene7(boolean useSmart) {
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
		IkTokenizerLucene7 tk = new IkTokenizerLucene7(this.useSmart);
		return new TokenStreamComponents(tk);
	}

}
