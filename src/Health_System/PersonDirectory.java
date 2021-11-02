/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Health_System;

import java.util.ArrayList;

/**
 *
 * @author Harshit
 */
public class PersonDirectory {
    private ArrayList<Person> personDirectory;
    private ArrayList<VitalSign> vitalSignList;
    private ArrayList<House> houseList;
    private ArrayList<Community> communityList;
    private ArrayList<City> cityList;

    public ArrayList<VitalSign> getVitalSignList() {
        return vitalSignList;
    }

    public void setVitalSignList(ArrayList<VitalSign> vitalSignList) {
        this.vitalSignList = vitalSignList;
    }
    

    public ArrayList<Person> getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(ArrayList<Person> personDirectory) {
        this.personDirectory = personDirectory;
    }

    public ArrayList<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(ArrayList<House> houseList) {
        this.houseList = houseList;
    }

    public ArrayList<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(ArrayList<Community> communityList) {
        this.communityList = communityList;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }
    
    public PersonDirectory() {
        personDirectory = new ArrayList<>();
        houseList = new ArrayList<House>();
        communityList = new ArrayList<Community>();
        cityList = new ArrayList<City>();
    }
    
    public ArrayList<House> getHouseHistory(){
        return houseList;
    }
    
    public ArrayList<Community> getCommunityHistory(){
        return communityList;
    }
    
    public ArrayList<City> getCityHistory(){
        return cityList;
    }
    
    public ArrayList<Person> getPersonHistory() {
        return personDirectory;
    }
    
    public void setPersonHistory(ArrayList<Person> personHistory) {
        this.personDirectory = personHistory;
    }
    
    public Person createAndAddPerson() {
        Person person = new Person();
        personDirectory.add(person);
        return person;
    }
    
    public void deletePerson(Person person) {
        personDirectory.remove(person);
    }
    
    public ArrayList<Person> searchPatient(String key)
    {
        ArrayList<Person> searchPatientDirectory = new ArrayList();
        for(Person person: personDirectory)
        {
            if(person.getPersonName().toLowerCase().startsWith(key.toLowerCase()))
            {
                if(person.getPatient()!=null)
                {
                    searchPatientDirectory.add(person);
                }
            }
        }
        return searchPatientDirectory;
    }
    
    public ArrayList<Person> searchPerson(String key)
    {
        ArrayList<Person> searchPersonDirectory = new ArrayList();
        for(Person person: personDirectory)
        {
            if(person.getPersonName().toLowerCase().startsWith(key.toLowerCase()))
            {
                searchPersonDirectory.add(person);
            }
        }
        return searchPersonDirectory;
    }
    
     public House createAndAddHouse(){
        House house = new House();
        houseList.add(house);
        return house;
    }
    
    public Community createAndAddCommunity(){
        Community community = new Community();
        communityList.add(community);
        return community;
    }
    
    public City createAndAddCity(){
        City city = new City();
        cityList.add(city);
        return city;
    }
}
