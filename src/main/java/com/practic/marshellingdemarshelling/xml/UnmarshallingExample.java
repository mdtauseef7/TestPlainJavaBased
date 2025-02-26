package com.practic.marshellingdemarshelling.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class UnmarshallingExample {
    public static void main(String[] args) {
        try {
            String xmlContent = "<student>"
                    + "<name>Bob</name>"
                    + "<id>102</id>"
                    + "<subject>Physics</subject>"
                    + "</student>";

            // Create JAXB context
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Convert XML to Java object
            StringReader sr = new StringReader(xmlContent);
            Student student = (Student) unmarshaller.unmarshal(sr);

            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Subject: " + student.getSubject());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

