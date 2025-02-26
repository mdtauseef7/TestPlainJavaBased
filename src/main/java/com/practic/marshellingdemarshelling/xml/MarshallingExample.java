package com.practic.marshellingdemarshelling.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class MarshallingExample {
    public static void main(String[] args) {
        try {
            Student student = new Student("Alice", 101, "Mathematics");

            // Create JAXB context
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();

            // To format the XML output
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Convert Java object to XML
            StringWriter sw = new StringWriter();
            marshaller.marshal(student, sw);
            String xmlContent = sw.toString();

            System.out.println(xmlContent);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

