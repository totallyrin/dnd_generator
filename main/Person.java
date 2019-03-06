package main;

import java.util.*;
import com.github.javafaker.Faker;

public abstract class Person {

    private String name = "N/A";
    private String age = "N/A";
    private String race = "N/A";
    private String gender = "N/A";
    private String alignment = "N/A";
    private String languages = "N/A";
    private String[] stats = {"10", "10", "10", "10", "10", "10"};
    private String traits = "N/A";

    Person(){}

    Person(String name, String age){
        this.name = name;
        this.age = age;
    }

    Person(String name, String age, String race, String gender){
        this.name = name;
        this.age = age;
        this.race = race;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge(){
        return this.age;
    }

    public void setRace(String race) {
        this.race = race;
    }
    public String getRace(){
        return this.race;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
    public String getAlignment() {
        return alignment;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public String getLanguages(){
        return languages;
    }

    public void setStats(String[] stats) {
        for (int i = 0; i < stats.length; i++) {
            this.stats[i] = stats[i];
        }
    }
    public String[] getStats(){
        return this.stats;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }
    public String getTraits(){
        return this.traits;
    }

    public String returnInfo() {
        return String.format(
                  "Name      : %s" +
                "\nAge       : %s" +
                "\nRace      : %s" +
                "\nGender    : %s" +
                "\nAlignment : %s" +
                "\nLanguages : %s" +
                "\nTraits    : %s" +
                "\n\nSTR : %s" +
                "\nDEX : %s" +
                "\nCON : %s" +
                "\nINT : %s" +
                "\nWIS : %s" +
                "\nCHA : %s" , this.name, this.age, this.race, this.gender, this.alignment, this.languages, this.traits, this.stats[0], this.stats[1], this.stats[2], this.stats[3], this.stats[4], this.stats[5]);
    }
    public void printInfo(){
        System.out.println(String.format(
                "Name : %s" +
                        "\nAge       : %s" +
                        "\nRace      : %s" +
                        "\nGender    : %s" +
                        "\nAlignment : %s" +
                        "\nLanguages : %s" +
                        "\nTraits    : %s" +
                        "\n\nSTR : %s" +
                        "\nDEX : %s" +
                        "\nCON : %s" +
                        "\nINT : %s" +
                        "\nWIS : %s" +
                        "\nCHA : %s" , this.name, this.age, this.race, this.gender, this.alignment, this.languages, this.traits, this.stats[0], this.stats[1], this.stats[2], this.stats[3], this.stats[4], this.stats[5]));
    }

}
