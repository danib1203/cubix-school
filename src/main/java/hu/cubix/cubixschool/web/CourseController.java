package hu.cubix.cubixschool.web;

import hu.cubix.cubixschool.mapper.CourseMapper;
import hu.cubix.cubixschool.mapper.HistoryDataMapper;
import hu.cubix.cubixschool.model.Course;
import hu.cubix.cubixschool.model.HistoryData;
import hu.cubix.cubixschool.service.CourseService;
import hu.webuni.cubixschool.api.CourseControllerApi;
import hu.webuni.cubixschool.api.model.CourseDto;
import hu.webuni.cubixschool.api.model.HistoryDataCourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CourseController implements CourseControllerApi {

    private final NativeWebRequest nativeWebRequest;
    private final CourseService courseService;
    private final CourseMapper courseMapper;
    private final HistoryDataMapper historyDataMapper;
    private final PageableHandlerMethodArgumentResolver pageableResolver;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.of(nativeWebRequest);
    }

    @Override
    public ResponseEntity<List<CourseDto>> findAll2() {
        return ResponseEntity.ok(courseMapper.entitiesToDtos(courseService.findAllWithRelationships()));
    }

    @Override
    public ResponseEntity<CourseDto> findById2(Integer id) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(courseMapper.entitySummaryToDto(course));
    }

    @Override
    public ResponseEntity<List<HistoryDataCourseDto>> getHistoryById(Long id) {
        List<HistoryData<Course>> courseHistory = courseService.getCourseHistory(id);

        List<HistoryDataCourseDto> courseDtosWithHistory = new ArrayList<>();
        courseHistory.forEach(hd ->
                courseDtosWithHistory.add(historyDataMapper.courseHistoryDataToDto(hd)));
        return ResponseEntity.ok(courseDtosWithHistory);
    }

    @Override
    public ResponseEntity<CourseDto> getRevisionOfHistory(Integer courseId, Integer revision) {
        Course courseHistory = courseService.getCourseAtGivenRevision(courseId, revision);

        return ResponseEntity.ok(courseMapper.entityToDto(courseHistory));
    }

//  @Override
//  public ResponseEntity<List<CourseDto>> search(Integer semesterFrom, Integer semesterTo, Boolean full, Integer page, Integer size, String sort, CourseDto courseDto) {
//      boolean isFull = full == null ? false : full;

//      Pageable pageable = createPageable("configPageable");

//      List<Course> courses = courseService.findCoursesByExample(courseMapper.dtoToEntity(courseDto), Optional.ofNullable(semesterFrom), Optional.ofNullable(semesterTo), pageable);

//      return ResponseEntity.ok(isFull
//              ? courseMapper.entitiesToDtos(courses)
//              : courseMapper.entitySummariesToDtos(courses));
//  }

    @Override
    public ResponseEntity<List<CourseDto>> search(CourseDto courseDto, Integer semesterFrom, Integer semesterTo, Boolean full, Integer page, Integer size, String sort) {
        boolean isFull = full == null ? false : full;

        Pageable pageable = createPageable("configPageable");

        List<Course> courses = courseService.findCoursesByExample(courseMapper.dtoToEntity(courseDto), Optional.ofNullable(semesterFrom), Optional.ofNullable(semesterTo), pageable);

        return ResponseEntity.ok(isFull
                ? courseMapper.entitiesToDtos(courses)
                : courseMapper.entitySummariesToDtos(courses));
    }

    private Pageable createPageable(String pageableConfigurerMethodName) {
        Method method;
        try {
            method = this.getClass().getMethod(pageableConfigurerMethodName, Pageable.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        MethodParameter methodParameter = new MethodParameter(method, 0);
        ModelAndViewContainer mavContainer = null;
        WebDataBinderFactory binderFactory = null;
        return pageableResolver.resolveArgument(methodParameter, mavContainer, nativeWebRequest, binderFactory);
    }

    public void configPageable(@SortDefault("id") Pageable pageable) {
    }
}
