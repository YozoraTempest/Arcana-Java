package fun.yozora.arcana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fun.yozora.arcana.mapper")
public class ArcanaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArcanaApplication.class, args);
    }

}
