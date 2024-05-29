package dev.raj.industrylevelproject.InheritanceExamples.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCInstructorRepository extends JpaRepository<Instructor,Long> {

        Instructor save(Instructor instructor);

        Instructor findInstructorById(Long id);
}
