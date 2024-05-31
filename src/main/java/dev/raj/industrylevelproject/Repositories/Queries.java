package dev.raj.industrylevelproject.Repositories;

public interface Queries {

    String IVVU_PRODUCTS = "select title from product p where p.id = :id";
}
