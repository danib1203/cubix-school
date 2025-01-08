package hu.cubix.cubixschool;

import hu.cubix.cubixschool.service.InitDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@RequiredArgsConstructor
@SpringBootApplication
@EnableCaching
public class CubixSchoolApplication implements CommandLineRunner {

    private final InitDbService initDbService;

    public static void main(String[] args) {
        SpringApplication.run(CubixSchoolApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDbService.clearDb();
        initDbService.deleteAudTables();
        initDbService.initDb();
        initDbService.makeHistory();

    }
}
