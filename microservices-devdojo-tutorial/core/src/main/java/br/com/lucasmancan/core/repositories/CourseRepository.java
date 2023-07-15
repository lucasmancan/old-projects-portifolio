package br.com.lucasmancan.core.repositories;


import br.com.lucasmancan.core.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
