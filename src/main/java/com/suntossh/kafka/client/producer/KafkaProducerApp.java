package com.suntossh.kafka.client.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerApp {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
		
		try {
			for(int i = 0; i<=150; i++) {
				producer.send(new ProducerRecord<String, String>("mera-topic", String.valueOf(i), "Y My Message: "+String.valueOf(i)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			producer.close();
		}
	}

}
