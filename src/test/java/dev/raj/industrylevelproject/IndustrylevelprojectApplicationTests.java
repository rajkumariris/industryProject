package dev.raj.industrylevelproject;

import dev.raj.industrylevelproject.InheritanceExamples.SingleClass.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndustrylevelprojectApplicationTests {

    @Autowired
    SCUserRepository userRepository;
    @Autowired
    SCMentorRepository mentorRepository;
    @Autowired
    SCTAInstructorRepository taRepository;
    @Autowired
    SCInstructorRepository instructorRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testAllInheritances(){

//            // Create and save User
//            User user = new User();
//            user.setEmail("user@example.com");
//            user.setPassword("password");
//            userRepository.save(user);
//
//            // Create and save Mentor
//            Mentor mentor = new Mentor();
////            mentor.setEmail("mentor@example.com");
////            mentor.setPassword("password");
//            mentor.setNoOfSessions(10);
//            mentor.setNoOfMentees(5);
//            mentorRepository.save(mentor);
//
//            // Create and save TA
////            TA ta = new TA();
////            ta.setEmail("ta@example.com");
////            ta.setPassword("password");
////            ta.setAverageRating(3.7); // replace with actual TA property
////            taRepository.save(ta);
////
////            // Create and save Instructor
////            Instructor instructor = new Instructor();
////            instructor.setEmail("instructor@example.com");
////            instructor.setPassword("password");
////            instructor.setSomeInstructorProperty("someValue"); // replace with actual Instructor property
////            instructorRepository.save(instructor);
//     //   }
//
//
//


    }
}
