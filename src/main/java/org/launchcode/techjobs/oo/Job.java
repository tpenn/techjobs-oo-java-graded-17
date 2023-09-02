package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private final int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String LS = System.lineSeparator();
        boolean nameEmpty = name == null || name.isBlank();
        boolean employerEmpty = employer == null || employer.toString().isBlank();
        boolean locationEmpty = location == null || location.toString().isBlank();
        boolean positionEmpty = positionType == null || positionType.toString().isBlank();
        boolean ccEmpty = coreCompetency == null || coreCompetency.toString().isBlank();

        if (nameEmpty && employerEmpty && locationEmpty && positionEmpty && ccEmpty) {
            return "OOPS! This job does not seem to exist.";
        }

        return LS + "ID: " + id + LS +
                "Name: " + (nameEmpty ? "Data not available" : name) + LS +
                "Employer: " + (employerEmpty ? "Data not available" : employer) + LS +
                "Location: " + (locationEmpty ? "Data not available" : location) + LS +
                "Position Type: " + (positionEmpty ? "Data not available" : positionType) + LS +
                "Core Competency: " + (ccEmpty ? "Data not available" : coreCompetency) + LS;
    }
// TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
