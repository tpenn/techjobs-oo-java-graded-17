package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product tester", testJob.getName());

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    // Task 5
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = testJob.toString();
        String lineSeparator = System.lineSeparator();
        int lineSeparatorLength = lineSeparator.length();
        int jobStringLength = jobString.length();

        assertTrue(jobStringLength >= lineSeparatorLength * 2);
        assertEquals(lineSeparator, jobString.substring(0, lineSeparatorLength));
        assertEquals(lineSeparator, jobString.substring(jobStringLength - lineSeparatorLength));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = testJob.toString();
        String LS = System.lineSeparator();
        String expectedOutput = LS + "ID: " + testJob.getId() + LS +
                "Name: Product tester" + LS +
                "Employer: ACME" + LS +
                "Location: Desert" + LS +
                "Position Type: Quality control" + LS +
                "Core Competency: Persistence" + LS;

        assertEquals(expectedOutput, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String jobString = testJob.toString();
        String LS = System.lineSeparator();
        String expectedOutput = LS + "ID: " + testJob.getId() + LS +
                "Name: Product tester" + LS +
                "Employer: ACME" + LS +
                "Location: Data not available" + LS +
                "Position Type: Quality control" + LS +
                "Core Competency: Persistence" + LS;

        assertEquals(expectedOutput, jobString);
    }

    @Test
    public void testToStringHandlesNonExistentJob() {
        Job testJob = new Job();
        String LS = System.lineSeparator();

        assertEquals("OOPS! This job does not seem to exist.", testJob.toString());
    }
}
