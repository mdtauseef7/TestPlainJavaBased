package com.practic.designpattern.builder;

public class BuilderDesign {
    public static void main(String[] args) {

       /* Student student = new Student.Builder()
                .name("tauseef")
                .rollNo(2)
                .built();*/

        //System.out.println(student);

        Post post = new Post.Builder("Java Builder Pattern")
                .text("Explaining how to implement the Builder Pattern in Java")
                .category("Programming")
                .build();

        System.out.println(post);

    }

}

