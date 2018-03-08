package com.example.grzesiek.database;


public class information {
    //private variables
    int _id;
    String _name;
    int _height;
    double _weight;
    double _targetWeight;
    int _age;
    int _year;


    //empty constructor
    public information() {
    }

    //constructors
    //all main information
    public information(int id, String name, int height, double weight, double targetWeight, int age, int year) {
        this._id = id;
        this._name = name;
        this._height = height;
        this._weight = weight;
        this._targetWeight = targetWeight;
        this._age = age;
        this._year = year;

    }
    //main information
    public information(String name, int height, double weight, double targetWeight, int age, int year) {
        this._name = name;
        this._height = height;
        this._weight = weight;
        this._targetWeight = targetWeight;
        this._age = age;
        this._year = year;

    }
    //weight information
    public information(int year){
        this._year = year;
    }




    //getters and setters
    //id
    public int getId() {
        return this._id;
    }

    public void setId(int id) {
        this._id = id;
    }

    //name
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    //height
    public int getHeight() {
        return this._height;
    }

    public void setHeight(int height) {
        this._height = height;
    }

    //weight
    public double getWeight() {
        return this._weight;
    }

    public void setWeight(double weight) {
        this._weight = weight;
    }

    //targetWeight
    public double getTargetWeight() {
        return this._targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this._targetWeight = targetWeight;
    }

    //age
    public int getAge() {
        return this._age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    //year
    public int getYear() {
        return this._year;
    }

    public void setYear(int year) {
        this._year = year;
    }
}
