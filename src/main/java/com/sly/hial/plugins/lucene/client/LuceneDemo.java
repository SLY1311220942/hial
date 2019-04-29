package com.sly.hial.plugins.lucene.client;

import java.io.IOException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import com.sly.hial.plugins.ik.IKAnalyzerLucene7;
import com.sly.hial.plugins.lucene.index.Indexer;
import com.sly.hial.plugins.lucene.search.Searcher;

/**
 * demo测试类
 * 
 * @author sly
 * @time 2019年4月18日
 */
public class LuceneDemo {
	
	public static void main(String[] args) {
		
	}

	/**
	 * 测试索引
	 * 
	 * @author sly
	 * @time 2019年4月18日
	 */
	
	public static void indexTest() {
		// 索引指定的文档路径
		String indexDir = "D:/test/lucene/dataindex";
		// 被索引数据的路径
		String dataDir = "D:/test/lucene/data";
		Indexer indexer = null;
		int numIndexed = 0;
		// 索引开始时间
		long start = System.currentTimeMillis();
		try {
			indexer = new Indexer(indexDir);
			numIndexed = indexer.index(dataDir);
		} catch (Exception e) {
			ExceptionUtils.getStackTrace(e);
		} finally {
			if (indexer != null) {
				try {
					indexer.close();
				} catch (Exception e) {
					ExceptionUtils.getStackTrace(e);
				}
			}
		}

		// 索引结束时间
		long end = System.currentTimeMillis();
		System.out.println("索引：" + numIndexed + " 个文件 花费了" + (end - start) + " 毫秒");

	}

	/**
	 * 测试查询
	 * 
	 * @author sly
	 * @time 2019年4月18日
	 */
	public static void searchTest() {
		String indexDir = "D:/test/lucene/dataindex";
		// 我们要搜索的内容
		String q = "后得到的";
		try {
			Searcher.search(indexDir, q);
		} catch (Exception e) {
			ExceptionUtils.getStackTrace(e);
		}
	}

	/**
	 * 测试分词器
	 * 
	 * @throws IOException
	 * @author sly
	 * @time 2019年4月18日
	 */
	public static void analyzerTest() throws IOException {
		Analyzer analyzer = new IKAnalyzerLucene7(true);
		// Analyzer analyzer = new StandardAnalyzer();

		TokenStream tokenStream = analyzer.tokenStream("content", "后得到的");
		tokenStream.reset();
		CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
		while (tokenStream.incrementToken()) {
			System.out.println(charTermAttribute.toString());
		}
		analyzer.close();
	}

}
