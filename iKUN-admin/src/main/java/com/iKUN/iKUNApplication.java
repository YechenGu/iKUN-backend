package com.iKUN;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author iKUN
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class iKUNApplication
{
    public static void main(String[] args)
    {
        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(iKUNApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  实习管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
