package cn.bingoogolapple.sbn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "cn.bingoogolapple.sbn.repository")
@SpringBootApplication
public class SbnApp {

    public static void main(String[] args) {
        SpringApplication.run(SbnApp.class, args);
    }
}