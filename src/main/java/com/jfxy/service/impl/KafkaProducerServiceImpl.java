package com.jfxy.service.impl;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jfxy.listener.MemoryListener;
import com.jfxy.pojo.Mem;
import com.jfxy.service.KafkaProducerService;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService{
	Producer<Integer, String> producer = null;
	
	public KafkaProducerServiceImpl(){
		//init();
	}

	public void init() {
		Properties properties = new Properties();
		properties.put("zookeeper.connect", "localhost:2181");// 声明zk
		properties.put("serializer.class", StringEncoder.class.getName());
		properties.put("metadata.broker.list", "localhost:9092");// 声明kafka
																		// broker
		producer = new Producer<Integer, String>(new ProducerConfig(properties));
		
	}
	
	public void sendMem(Mem mem){
		
		String memJson=JSONObject.toJSONString(mem);
		
		KeyedMessage<Integer,String> keyedMessage=new KeyedMessage<Integer,String>(MemoryListener.topic, memJson);
		
		
		producer.send(keyedMessage); 
	}

}
