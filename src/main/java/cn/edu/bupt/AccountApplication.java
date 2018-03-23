package cn.edu.bupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
/**
 * Created by CZX on 2018/3/23.
 */
@SpringBootConfiguration
@SpringBootApplication
@ComponentScan({"cn.edu.bupt"})
@ServletComponentScan
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
