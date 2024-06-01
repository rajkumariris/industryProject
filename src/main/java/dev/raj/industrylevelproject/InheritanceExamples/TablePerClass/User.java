//package dev.raj.industrylevelproject.InheritanceExamples.TablePerClass;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity(name="tpc_user")// tpc_user is the table name
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //spring doesnot know how to represent in db so we say user in parent of all //inherite it to all child class
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_id_seq")
//    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
//    private Long id;
//    private String email;
//    private String password;
//}
//
//// table per class create seperate table for each class
//// single class create only one table for all the attributes
//// joined table it inherits common attribute from parent class along with create table with it own attribues acced via foreigh  key(
//  // -> parent one table and child another
//// mappedsuper class it is used to create common attributes in parent class and it is not used to create table for parent class only
//// only crate table for its child class ( only table for child class)