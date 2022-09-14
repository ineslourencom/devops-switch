package com.greglturnquist.payroll;


import org.junit.jupiter.api.Test;


import java.time.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @Test
    void getJobYears() {
        Employee emp1 = new Employee("John", "Doe", "description", LocalDate.of(2020, 3, 1), "john@isep.ipp.pt");

        LocalDate startDate = LocalDate.of(2020, 3, 1);
        LocalDate now =  LocalDate.now();
        Period workingPeriod = Period.between(startDate, now);
        int expected = workingPeriod.getYears();

        int result = emp1.getJobYears();

        assertEquals(expected, result);

    }

    //using layered tests to check for valid and faulty input

    @Test
    void objectInputFirstNameIsInvalid(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee(" ", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt"),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));
    }

    @Test
    void objectInputLastNameIsInvalid(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee("firstName", "  ", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt"),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));
    }


    @Test
    void objectInputDescriptionIsInvalid(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee("firstName", "lastName", "   ", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt"),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));
    }


    @Test
    void objectInputDataIsInvalid(){

        LocalDate today = LocalDate.now();
        //adding days to the localdate
        LocalDate tomorrow = today.plusDays(1);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee("firstName", "lastName", "description", tomorrow, "john@isep.ipp.pt"),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));
    }


    @Test
    void objectInputEmailIsInvalid_null(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "   "),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));
    }




    @Test
    void objectInputEmailIsInvalid_NullIsepMail(){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), " "),
                "Please verify input values"
        );
        assertTrue(thrown.getMessage().contains("Please verify input values"));

    }




    @Test
    void objectIsSuccessfullyCreated(){

        Employee emp1 = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        assertDoesNotThrow(() -> emp1);

    }


    //-------- Testing Equals --------

    /**
     * ensures equals is true when compares an object with itself
     */
    @Test
    void testEqualsSameObject() {
        Employee example = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");

        assertEquals(example, example);
    }

    /**
     * ensures equals is true when compares diferent instances that have the same name and description and code
     */
    @Test
    void testEqualsEqualObject() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");

        assertEquals(exampleOne, exampleOne);
        assertEquals(exampleOne.hashCode(),exampleOne.hashCode());
    }


    /**
     * ensure equals is false when compares diferent instanceswith diferent first names
     */
    @Test
    void testEqualsDifferentObjectWithDifferentFirstNames() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Employee exampleTwo = new Employee("firstNameTwo", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");


        assertNotEquals(exampleOne, exampleTwo);
    }


    /**
     * ensure equals is false when compares diferent instanceswith diferent last names
     */
    @Test
    void testEqualsDifferentObjectWithDifferentLastNames() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Employee exampleTwo = new Employee("firstName", "lastNameTwo", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");

        assertNotEquals(exampleOne, exampleTwo);
    }



    /**
     * ensure equals is false when compares diferent instances with diferent descriptions
     */
    @Test
    void testEqualsDifferentObjectWithDifferentDescription() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Employee exampleTwo = new Employee("firstName", "lastName", "descriptionTwo", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");

        assertNotEquals(exampleOne, exampleTwo);
    }


    /**
     * ensure equals is false when compares diferent instanceswith diferent start Dates
     */
    @Test
    void testEqualsDifferentObjectWithDifferentNames() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Employee exampleTwo = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 2), "john@isep.ipp.pt");

        assertNotEquals(exampleOne, exampleTwo);
    }



    /**
     * ensure equals is false when compares diferent instanceswith diferent email
     */
    @Test
    void testEqualsDifferentObjectWithDifferentEmail() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Employee exampleTwo = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "mary@isep.ipp.pt");

        assertNotEquals(exampleOne, exampleTwo);
    }



    /**
     * ensure equals is false when compares differentes types of Objects
     */
    @Test
    void testEqualsDifferentTypesOfObject() {
        Employee exampleOne = new Employee("firstName", "lastName", "description", LocalDate.of(2020, 1, 1), "john@isep.ipp.pt");
        Object exampleTwo = new Object();

        assertNotEquals(exampleTwo, exampleOne);
    }

    /**
     * ensure equals is false when compares with null
     */
    @Test
    void testEqualsNull() {
        Employee exampleOne = new Employee();

        assertNotEquals(null, exampleOne);
    }


 
}