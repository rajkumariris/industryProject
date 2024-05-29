package dev.raj.industrylevelproject.InheritanceExamples.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SCTAInstructorRepository extends JpaRepository<TA, Long> {

    TA save(TA ta);

    TA findTAById(Long id);
}
