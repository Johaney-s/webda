package cz.muni.fi.webda;

import cz.muni.fi.webda.impl.UBVCCD;
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

//                be002 ubv.ccd data
//                No	Ref	  V	   BV	UB
//                0010  555 17.920  1.020   0.550,
//                0011	555	13.290	1.430	1.140
//                0012	555	17.650	0.960	0.590
//                0013	555	18.110	1.040	0.980
//                0014	555	17.960	1.000	0.360
//                0015	555	18.350	1.050	0.550

        UBVCCD test1 = new UBVCCD(3, 1, 555, 17.920, 1.02, 0.55);
        UBVCCD test2 = new UBVCCD(3, 2, 555, 13.290, 1.430, 1.140);
        UBVCCD test3 = new UBVCCD(3, 3, 555, 17.650, 0.960, 0.590);

        return args -> {
            repository.save(test1);
            repository.save(test2);
            repository.save(test3);
            repository.findAll().forEach(System.out::println);
        };
    }

}
