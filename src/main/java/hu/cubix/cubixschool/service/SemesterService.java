package hu.cubix.cubixschool.service;

import hu.cubix.cubixschool.aspect.Retry;
import hu.cubix.cubixschool.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SemesterService {

    private final StudentRepository studentRepository;
    Random random = new Random();

    @Retry
    public int usedFreeSemesters(int centralIdentification) {
        System.out.println("usedFreeSemesters called");
        if (random.nextBoolean()){
            System.out.println("Error reached");
            throw new RuntimeException("Random error occurred!");
        }
        System.out.println("Method end reached");
        return random.nextInt(1, 9);
    }
}
