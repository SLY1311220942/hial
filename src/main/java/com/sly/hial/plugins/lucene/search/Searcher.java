package com.sly.hial.plugins.lucene.search;

import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.sly.hial.plugins.ik.IkAnalyzerLucene7;

/**
 * 查询文件
 * 
 * @author sly
 * @time 2019年4月18日
 */
public class Searcher {

	public static void search(String indexDir, String queryStr) throws Exception {
		// 得到读取索引文件的路径
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		// 通过dir得到的路径下的所有的文件
		IndexReader reader = DirectoryReader.open(dir);
		// 建立索引查询器
		IndexSearcher is = new IndexSearcher(reader);
		// 实例化分析器
		IkAnalyzerLucene7 analyzer = new IkAnalyzerLucene7();
		// Analyzer analyzer = new IKAnalyzer(true);
		// Analyzer analyzer = new StandardAnalyzer();
		// 建立查询解析器:第一个参数是要查询的字段;第二个参数是分析器Analyzer
		QueryParser parser = new QueryParser("contents", analyzer);
		// 根据传进来的p查找
		Query query = parser.parse(queryStr);
		// 计算索引开始时间
		long start = System.currentTimeMillis();
		// 开始查询:第一个参数是通过传过来的参数来查找得到的query; 第二个参数是要出查询的行数
		TopDocs hits = is.search(query, 10);
		// 计算索引结束时间
		long end = System.currentTimeMillis();
		System.out.println("匹配 " + queryStr + " ，总共花费" + (end - start) + "毫秒" + "查询到" + hits.totalHits + "个记录");

		// 遍历hits.scoreDocs，得到scoreDoc:ScoreDoc:得分文档,即得到文档 scoreDocs:代表的是topDocs这个文档数组
		for (ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = is.doc(scoreDoc.doc);
			System.out.println(doc.get("fileName") + ":" + doc.get("fullPath"));
		}

		// 关闭reader
		reader.close();

	}
}
