package org.infospray.runx.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;


@ComponentScan("org.infospray.runx")
@EnableAutoConfiguration
@PropertySource("classpath:query.properties")
public class Runner {

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
	
	
	@Bean
	MesgBroadcaster mesgBroadcaster()
	{
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		
		return mesgBroadcaster;
	}

}
