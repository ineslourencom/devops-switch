package com.greglturnquist.payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {



    @Test
    void getFirstName() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");

        String result = emp1.getFirstName();
        assertEquals("firstName", result);
    }

    @Test
    void setFirstName() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");
        emp1.setFirstName("test");
        String result = emp1.getFirstName();
        assertEquals("test", result);
    }

    @Test
    void getLastName() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");

        String result = emp1.getLastName();
        assertEquals("lastName", result);

    }

    @Test
    void setLastName() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");
        emp1.setLastName("test");
        String result = emp1.getLastName();
        assertEquals("test", result);
    }

    @Test
    void getDescription() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");
        String result = emp1.getDescription();
        assertEquals("descr", result);
    }

    @Test
    void setDescription() {
        Employee emp1 = new Employee("firstName", "lastName", "descr");
        emp1.setDescription("test");
        String result = emp1.getDescription();
        assertEquals("test", result);
    }
}