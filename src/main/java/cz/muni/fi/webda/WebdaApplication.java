package cz.muni.fi.webda;

import cz.muni.fi.webda.impl.UBVccd;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdaApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UBVCCDRepository repository) {

        UBVccd test1 = new UBVccd(3, 1, 555, 17.920, 1.02, 0.55);
        UBVccd test2 = new UBVccd(3, 2, 555, 13.290, 1.430, 1.140);
        UBVccd test3 = new UBVccd(3, 3, 555, 17.650, 0.960, 0.590);

        return args -> {
            repository.save(test1);
            repository.save(test2);
            repository.save(test3);
            repository.findAll().forEach(System.out::println);
        };
    }

}
