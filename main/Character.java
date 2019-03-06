package main;

import java.util.*;
import com.github.javafaker.Faker;

public class Character extends Person {

    private String Class = "N/A";
    private String proficiencies = "N/A";

    private Faker faker = new Faker();
    private Random random = new Random();

    private String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling", "Aarakocra", "Genasi", "Goliath", "Aasimar",
            "Bugbear", "Firbolg", "Goblin", "Hobgoblin", "Kenku", "Kobold", "Lizardfolk", "Orc", "Tabaxi", "Triton", "Yuan-ti", "Tortle"};
    private String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    private String[] genders = {"Male", "Female", "Other"};
    private String[] languages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc", "Merfolk", "Abyssal", "Celestial", "Draconic",
            "Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon", "Aarakocra"}; //, "Druidic", "Theives' Cant"
    private String[] traits = {"Shy", "Arrogant", "Assertive", "Loud", "Annoying", "Studious", "Smart", "Stupid", "Nice", "Rude", "Respectful", "Looks like they need a slap"};
    private String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
    private String[] theproficiencies = {"Light Armour", "Medium Armour", "Heavy Armour", "Ranged Weapons", "Melee Weapons", "Simple Melee Weapons", "Martial Weapons", "Simple Weapons",
            "Martial Melee Weapons", "Simple Ranged Weapons", "Martial Ranged Weapons"};

    Character(){}

    Character(String name, String age){
        super(name, age);
    }

    Character(String name, String age, String race, String gender){
        super(name, age, race, gender);
    }

    Character(String name, String age, String race, String gender, String Class){
        super(name, age, race, gender);
        this.Class = Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
    }
    public String getaClass() {
        return Class;
    }

    public void setProficiencies(String proficiencies) {
        this.proficiencies = proficiencies;
    }
    public String getProficiencies() {
        return this.proficiencies;
    }

    @Override
    public String returnInfo(){
        return String.format(
                  "Name       : %s" +
                "\nAge        : %s" +
                "\nRace       : %s" +
                "\nGender     : %s" +
                "\nAlignment  : %s" +
                "\nClass      : %s" +
                "\nLanguages  : %s" +
                "\nProficient : %s" +
                "\nTraits     : %s" +
                "\n\nSTR : %s" +
                "\nDEX : %s" +
                "\nCON : %s" +
                "\nINT : %s" +
                "\nWIS : %s" +
                "\nCHA : %s" , super.getName(), super.getAge(), super.getRace(), super.getGender(), super.getAlignment(), this.Class, super.getLanguages(), this.proficiencies,
                                super.getTraits(), super.getStats()[0], super.getStats()[1], super.getStats()[2], super.getStats()[3], super.getStats()[4], super.getStats()[5]);
    }
    @Override
    public void printInfo(){
        System.out.println(String.format(
                  "Name       : %s" +
                "\nAge        : %s" +
                "\nRace       : %s" +
                "\nGender     : %s" +
                "\nAlignment  : %s" +
                "\nClass      : %s" +
                "\nLanguages  : %s" +
                "\nProficient : %s" +
                "\nTraits     : %s" +
                "\n\nSTR : %s" +
                "\nDEX : %s" +
                "\nCON : %s" +
                "\nINT : %s" +
                "\nWIS : %s" +
                "\nCHA : %s" , super.getName(), super.getAge(), super.getRace(), super.getGender(), super.getAlignment(), this.Class, super.getLanguages(), this.proficiencies,
                super.getTraits(), super.getStats()[0], super.getStats()[1], super.getStats()[2], super.getStats()[3], super.getStats()[4], super.getStats()[5]));
    }

    public Character generateRandomCharacter(){
        Character character = new Character();
        character.setName(faker.name().firstName() + " " + faker.name().lastName());
        character.setAge(Integer.toString(random.nextInt(53) + 16));
        character.setRace(races[random.nextInt(races.length)]);
        character.setGender(genders[random.nextInt(genders.length)]);
        character.setAlignment(alignments[random.nextInt(alignments.length)]);
        character.setClass(classes[random.nextInt(classes.length)]);
        int lang = random.nextInt(5) + 1;
        java.util.List langs = new ArrayList();
        langs.add("Common");
        if (character.getRace().equals("Dragonborn")) { langs.add("Draconic"); }
        else if (character.getRace().equals("Dwarf")) { langs.add("Dwarvish"); }
        else if (character.getRace().equals("Elf")) { langs.add("Elvish"); }
        else if (character.getRace().equals("Gnome")) { langs.add("Gnomish"); }
        else if (character.getRace().equals("Halfling")) { langs.add("Halfling"); }
        else if (character.getRace().equals("Half-Orc") | character.getRace().equals("Orc")) { langs.add("Orc"); }
        else if (character.getRace().equals("Tiefling")) { langs.add("Infernal"); }
        else if (character.getRace().equals("Aarakocra")) { langs.add("Aarakocra"); }
        else if (character.getRace().equals("Goblin")) { langs.add("Goblin"); }
        for (int i = 0; i < lang; i++) {
            String temp = languages[random.nextInt(languages.length)];
            if (!langs.contains(temp))
                langs.add(temp);
        }
        character.setLanguages(Arrays.toString(langs.toArray()));
        int prof = random.nextInt(3) + 1;
        java.util.List profs = new ArrayList();
        for (int i = 0; i < prof; i++) {
            String temp = theproficiencies[random.nextInt(theproficiencies.length)];
            if (!profs.contains(temp))
                profs.add(temp);
        }
        character.setProficiencies(Arrays.toString(profs.toArray()));
        character.setTraits(traits[random.nextInt(traits.length)]);
        String[] stats = new String[6];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = Integer.toString(random.nextInt(16) + 5);
        }
        character.setStats(stats);
        return character;
    }


}
