package dev.raj.industrylevelproject.InheritanceExamples.MappedSuperClass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MSMentorRepository extends JpaRepository<Mentor,Long> {

   Mentor save(Mentor mentor);

    Mentor findMentorById(Long id);
}
