package dev.raj.industrylevelproject.InheritanceExamples.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPInstructorRepository extends JpaRepository<Instructor,Long> {
    Instructor save(Instructor instructor);
}
