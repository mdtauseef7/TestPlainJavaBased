package com.practic.marshellingdemarshelling.json;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class JsonToJava {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = "{  \n" +
                "    \"employee\": {  \n" +
                "        \"name\":       \"sonoo\",   \n" +
                "        \"salary\":      56000,   \n" +
                "        \"married\":     true  \n" +
                "    }  \n" +
                "} ";

        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeWrapper employeeWrapper = objectMapper.readValue(jsonString, EmployeeWrapper.class);
        System.out.println(employeeWrapper);
    }
}


@Getter
@Setter
@NoArgsConstructor
@ToString
class Employee {
    private String name;
    private int salary;
    private boolean married;
}

@Getter
@Setter
@NoArgsConstructor
@ToString
class EmployeeWrapper{
    private Employee employee;
}
