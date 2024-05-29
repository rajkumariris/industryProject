package dev.raj.industrylevelproject.InheritanceExamples.JoinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTUserRepository extends JpaRepository<User, Long>{

    User save(User user);

    User findUserById(Long id);
}
