/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Health_System;

/**
 *
 * @author Harshit
 */
public class Person {
    
    private String personName;
    private int age;
    private Patient patient;
    private House house;
    private Community community;
    private City city;
    private CommunityDirectory communityDirectory;
    private PersonDirectory personDirectory;

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }
    
    public Person(){
        communityDirectory = new CommunityDirectory();
        personDirectory = new PersonDirectory();
    }
    
    public CommunityDirectory getCommunityDirectory() {
        return communityDirectory;
    }

    public void setCommunityDirectory(CommunityDirectory communityDirectory) {
        this.communityDirectory = communityDirectory;
    }
    
    
    
    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    
    
    public String getPersonName() {
        return personName;
    }
    
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    @Override
    public String toString()
    {
        return this.personName;
    }
    
}
