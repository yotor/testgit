package com.epay.fcc.fses.cins.front;

import com.epay.ts.piss.basic.springboot.GracefulShutdownTomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 入口类
 * When you see here, I can only wish you happiness, don't ask me why.
 * @author lijian
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Slf4j
public class FccFsesCInsApplication {
	
	public static void main(String[] args) {
		try {
			SpringApplication.run(FccFsesCInsApplication.class, args);
		} catch (Exception e) {
			log.error("spring boot is error, error reason==>{}", e);
		}
	}

    @Resource
    private GracefulShutdownTomcat gracefulShutdownTomcat;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdownTomcat);
        return tomcat;
    }
}
