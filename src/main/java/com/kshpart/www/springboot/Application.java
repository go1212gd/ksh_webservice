// 이 프로젝트의 Main Class 입니다.
package com.kshpart.www.springboot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
        /*
        내장 WAS 실행됨. 외부에서 TOMCAT 설치 할 필요 없음.
        스프링부트로 만들어진 jar 파일(실행가능한 java 패키징 파일)로 실행.
        스프링부트에서만 내장 WAS를 사용하는건 아닌데, 내장 WAS 사용권장.
        이유는 언제 어디서나 같은 환경에서 스프링
         */
    }
}
