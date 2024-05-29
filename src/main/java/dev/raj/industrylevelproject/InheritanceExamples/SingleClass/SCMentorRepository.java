package dev.raj.industrylevelproject.InheritanceExamples.SingleClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SCMentorRepository extends JpaRepository<Mentor,Long> {

     Mentor save(Mentor mentor);

    Mentor findMentorById(Long id);
}
