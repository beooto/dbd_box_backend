package myapp.dbd_box;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("myapp.dbd_box.dao")
public class DbdBoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbdBoxApplication.class, args);
    }

}
