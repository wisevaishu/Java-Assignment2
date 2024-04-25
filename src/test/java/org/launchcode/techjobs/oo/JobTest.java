package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job j1 = new Job();
        Job j2 = new Job();
        assertNotEquals(j1, j2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Assert that each field is not null
        assertTrue(job instanceof Job);
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        // Assert that each field has the expected value
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job j1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job j2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(j1.equals(j2));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Product tester" +System.lineSeparator() +
                "Employer: ACME" +System.lineSeparator() +
                "Location: Desert" +System.lineSeparator() +
                "Position Type: Quality control" +System.lineSeparator() +
                "Core Competency: Persistence"+System.lineSeparator() ;

        assertEquals(expected, job.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Product tester" +System.lineSeparator() +
                "Employer: ACME" +System.lineSeparator() +
                "Location: Desert" +System.lineSeparator() +
                "Position Type: Quality control" +System.lineSeparator() +
                "Core Competency: Persistence"+System.lineSeparator() ;

        assertTrue(expected.startsWith(System.lineSeparator()));
        assertTrue(expected.endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = System.lineSeparator() +
                "ID: " + job.getId() + System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();

        assertEquals(expected, job.toString());
    }
}
