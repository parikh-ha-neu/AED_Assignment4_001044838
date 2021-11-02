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
public class CommunityDirectory {
    private ArrayList<House> houseList;
    private ArrayList<Community> communityList;
    private ArrayList<City> cityList; 
    public CommunityDirectory(){
        houseList = new ArrayList<House>();
        communityList = new ArrayList<Community>();
        cityList = new ArrayList<City>();
       
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
    
    
    public ArrayList<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(ArrayList<House> houseList) {
        this.houseList = houseList;
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
    
//    @Override
//    public String toString() {
//        return this.community;
//    }
        
}
