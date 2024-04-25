package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by LaunchCode
 */
public class TestTaskFive extends AbstractTest {

    @Mocked Job job;

    @Test
    public void testTestToStringStartsAndEndsWithNewLineExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringStartsAndEndsWithNewLineMethod = null;

        try {
            testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringStartsAndEndsWithNewLine method");
        }
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
//        String firstChar = String.valueOf(job.toString().charAt(0));
//        String lastChar = String.valueOf(job.toString().charAt(job.toString().length()-1));
//        assertEquals(firstChar, lineSeparator());
//        assertEquals(lastChar, lineSeparator());

//        assertEquals(firstChar, lineSeparator());
//        assertEquals(lastChar, lineSeparator());


        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Web Developer" +System.lineSeparator() +
                "Employer: LaunchCode" +System.lineSeparator() +
                "Location: StL" +System.lineSeparator() +
                "Position Type: Back-end developer" +System.lineSeparator() +
                "Core Competency: Java"+System.lineSeparator() ;

        assertTrue(expected.startsWith(System.lineSeparator()));
        assertTrue(expected.endsWith(System.lineSeparator()));
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringContainsCorrectLabelsAndDataMethod = null;

        try {
            testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringContainsCorrectLabelsAndData method");
        }
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

    @Test
    public void testTestToStringHandlesEmptyFieldExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringHandlesEmptyField = null;

        try {
            testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringHandlesEmptyField method");
        }
    }

    @Test
    public void testToStringHandlesEmptyField() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "", "StL",
                "", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

}
