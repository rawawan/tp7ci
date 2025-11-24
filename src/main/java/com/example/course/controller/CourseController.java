package com.example.course.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.model.Course;
import com.example.course.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() { 
        return courseService.getAllCourses(); 
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) { 
        return courseService.getCourseById(id); 
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) { 
        return courseService.saveCourse(course); 
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        course.setId(id);
        return courseService.saveCourse(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) { 
        courseService.deleteCourse(id); 
    }

    @GetMapping("/search")
    public List<Course> searchCourses(@RequestParam(required = false) String name,
                                      @RequestParam(required = false) String instructor,
                                      @RequestParam(required = false) String category) {
        if (name != null) return courseService.searchByName(name);
        if (instructor != null) return courseService.searchByInstructor(instructor);
        if (category != null) return courseService.searchByCategory(category);
        return courseService.getAllCourses();
    }
}
