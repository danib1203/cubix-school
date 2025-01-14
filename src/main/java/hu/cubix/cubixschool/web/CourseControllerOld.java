package hu.cubix.cubixschool.web;


import hu.cubix.cubixschool.mapper.CourseMapper;
import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.HistoryData;
import hu.cubix.cubixschool.service.CourseService;
import hu.webuni.cubixschool.api.model.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
// @RestController
// @RequestMapping("/api/course")
public class CourseControllerOld {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping
    public List<CourseDto> findAll() {
        return courseMapper.entitiesToDtos(courseService.findAllWithRelationships());
    }

    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable final int id) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return courseMapper.entitySummaryToDto(course);
    }

    @PostMapping("/search")
    public List<CourseDto> search(@RequestBody CourseDto exampleCourse,
                                  @RequestParam Optional<Integer> semesterFrom,
                                  @RequestParam Optional<Integer> semesterTo,
                                  @RequestParam Optional<Boolean> full,
                                  @SortDefault("id") Pageable pageable) {
        boolean isFull = full.orElse(false);
        List<Course> courses = courseService.findCoursesByExample(courseMapper.dtoToEntity(exampleCourse), semesterFrom, semesterTo, pageable);

        return isFull
                ? courseMapper.entitiesToDtos(courses)
                : courseMapper.entitySummariesToDtos(courses);
    }

//  @GetMapping("/{id}/history")
//  public List<HistoryData<CourseDto>> getHistoryById(@PathVariable long id) {
//      List<HistoryData<Course>> courseHistory = courseService.getCourseHistory(id);

//      List<HistoryData<CourseDto>> courseDtosWithHistory = new ArrayList<>();
//      courseHistory.forEach(hd ->
//              courseDtosWithHistory.add(new HistoryData<>(
//                      courseMapper.entityToDto(hd.getData()),
//                      hd.getRevisionType(),
//                      hd.getRevision(),
//                      hd.getDate())));
//      return courseDtosWithHistory;
//  }

    @GetMapping("/{courseId}/revision/{revision}")
    public CourseDto getRevisionOfHistory(@PathVariable int courseId, @PathVariable int revision) {
        Course courseHistory = courseService.getCourseAtGivenRevision(courseId, revision);

        return courseMapper.entityToDto(courseHistory);
    }
}
