package dev.raj.industrylevelproject.InheritanceExamples.TablePerClass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TPTARepository extends JpaRepository<TA,Long> {
    TA save(TA ta);
    TA findTAById(Long id);
}
