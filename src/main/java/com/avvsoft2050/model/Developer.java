package com.avvsoft2050.model;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private int developerId;
    private String name;
    private String specialty;
    private int salary;
    private ArrayList<String> languagesThatDeveloperSpeaks = null;
    private StringBuilder languages;

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<String> getLanguagesThatDeveloperSpeaks() {
        return languagesThatDeveloperSpeaks;
    }

    public void setLanguagesThatDeveloperSpeaks(ArrayList<String> languagesThatDeveloperSpeaks) {
        this.languagesThatDeveloperSpeaks = languagesThatDeveloperSpeaks;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "developerId=" + developerId +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", salary=" + salary +
                ", languagesThatDeveloperSpeaks=" + languagesThatDeveloperSpeaks +
                '}';
    }
}
