package com.jfxy.test;

import org.junit.Test;
//import org.springframework.data.redis.connection.jedis.JedisConnection;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

public class Test3 {
	/**
	@Test
	public void test1(){
		JedisConnectionFactory connectionFactory=new JedisConnectionFactory(); ;
		connectionFactory.setHostName("127.0.0.1");
		connectionFactory.setPort(6379);
		
		//JedisConnection conn= connectionFactory.getConnection();
		
		//Jedis jedis=conn.getNativeConnection();
		//System.out.println("name="+conn.get("name".getBytes()));
	}
	@Test
	public void test2(){
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("aa", "aa");
		System.out.println(jedis.get("aa"));
	}
	
	public static void main(String[] args) {
		JedisConnectionFactory connectionFactory=new JedisConnectionFactory(); ;
		connectionFactory.setHostName("127.0.0.1");
		connectionFactory.setPort(6379);
		
		connectionFactory.afterPropertiesSet();
		//JedisConnection conn= connectionFactory.getConnection();
		
	}
	**/

}
