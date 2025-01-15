package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
public class AdminContoller {

    private final CourseService courseService;

    @Async
    @RequestMapping("/api/admin/average/{courseId}")
    public CompletableFuture<OptionalDouble> averageSemesterForCourse(@PathVariable int courseId) {
        System.out.println("Controller method averageSemesterForCourse called on Thread: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(courseService.getAverageSemesterByCourse(courseId));
    }
}
