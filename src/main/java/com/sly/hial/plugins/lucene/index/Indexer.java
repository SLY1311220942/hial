package com.sly.hial.plugins.lucene.index;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.sly.hial.plugins.ik.IkAnalyzerLucene7;

/**
 * 索引文件
 * 
 * @author sly
 * @time 2019年4月18日
 */
public class Indexer {
	/** 写索引实例 */
	private IndexWriter indexWriter;

	/**
	 * 索引构造方法
	 * 
	 * @param indexDir
	 * @throws IOException
	 * @author sly
	 * @time 2019年4月18日
	 */
	public Indexer(String indexDir) throws IOException {
		// 得到索引所在目录的路径
		Directory directory = FSDirectory.open(Paths.get(indexDir));
		// ik分词器
		IkAnalyzerLucene7 analyzer = new IkAnalyzerLucene7();
		// Analyzer analyzer = new IKAnalyzer();
		// 保存用于创建IndexWriter的所有配置。
		IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
		// 实例化IndexWriter
		this.indexWriter = new IndexWriter(directory, iwConfig);
	}

	/**
	 * 关闭写索引
	 * 
	 * @throws IOException
	 * @author sly
	 * @time 2019年4月18日
	 */
	public void close() throws IOException {
		indexWriter.close();
	}

	/**
	 * 索引
	 * 
	 * @param dataDir
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年4月18日
	 */
	public int index(String dataDir) throws Exception {
		File[] files = new File(dataDir).listFiles();
		for (File file : files) {
			// 索引指定文件
			indexFile(file);
		}
		// 返回索引了多少个文件
		return indexWriter.getDocStats().numDocs;
	}

	/**
	 * 指定索引文件
	 * 
	 * @param file
	 * @throws Exception
	 * @author sly
	 * @time 2019年4月18日
	 */
	private void indexFile(File file) throws Exception {
		// 输出索引文件的路径
		System.out.println("索引文件：" + file.getCanonicalPath());
		// 获取文档，文档里再设置每个字段
		Document doc = getDocument(file);
		// 开始写入,就是把文档写进了索引文件里去了；
		indexWriter.addDocument(doc);
	}

	/**
	 * 获取文档
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 * @author sly
	 * @time 2019年4月18日
	 */
	private Document getDocument(File file) throws Exception {
		Document doc = new Document();
		// 把设置好的索引加到Document里，以便在确定被索引文档
		doc.add(new TextField("contents", new FileReader(file)));
		// Field.Store.YES：把文件名存索引文件里，为NO就说明不需要加到索引文件里去
		doc.add(new TextField("fileName", file.getName(), Field.Store.YES));
		// 把完整路径存在索引文件里
		doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES));
		return doc;
	}

}
