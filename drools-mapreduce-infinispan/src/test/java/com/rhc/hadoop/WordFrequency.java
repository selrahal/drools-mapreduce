package com.rhc.hadoop;

import java.util.Map;

import org.drools.mapreduce.infinispan.map.InfinispanDroolsMapper;
import org.drools.mapreduce.infinispan.reduce.InfinispanDroolsReducer;
import org.infinispan.Cache;
import org.infinispan.distexec.mapreduce.MapReduceTask;


public class WordFrequency {
	 
	   /**
	    * In this example replace c1 and c2 with
	    * real Cache references
	    *
	    * @param args
	    */
	   public static void main(String[] args) {
		  JavaCacheProvider cacheProvider = new JavaCacheProvider();
	      Cache<String, String> c1 = cacheProvider.getCache();
	 
	      c1.put("1", "Hello world here I am");
	      c1.put("3", "JUDCon is in Boston");
	      c1.put("12","JBoss Application Server");
	      c1.put("14", "Infinispan community");
	      c1.put("111", "Infinispan open source");
	      c1.put("113", "Toronto is a capital of Ontario");
	      c1.put("211", "JBoss World is awesome");
	      c1.put("213", "JBoss division of RedHat ");
	 
	      MapReduceTask<String, String, String, String> t =
	         new MapReduceTask<String, String, String, String>(c1);
	      t.mappedWith(new InfinispanDroolsMapper())
	         .reducedWith(new InfinispanDroolsReducer());
	      Map<String, String> wordCountMap = t.execute();
	      System.out.println(wordCountMap);
	   }
	}