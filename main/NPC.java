package main;

import java.util.*;
import com.github.javafaker.Faker;

public class NPC extends Person {

    private Faker faker = new Faker();
    private Random random = new Random();

    private String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling", "Aarakocra", "Genasi", "Goliath", "Aasimar",
            "Bugbear", "Firbolg", "Goblin", "Hobgoblin", "Kenku", "Kobold", "Lizardfolk", "Orc", "Tabaxi", "Triton", "Yuan-ti", "Tortle"};
    private String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    private String[] genders = {"Male", "Female", "Other"};
    private String[] languages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc", "Merfolk", "Abyssal", "Celestial", "Draconic",
            "Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon", "Aarakocra"}; //, "Druidic", "Theives' Cant"
    private String[] traits = {"Shy", "Arrogant", "Assertive", "Loud", "Annoying", "Studious", "Smart", "Stupid", "Nice", "Rude", "Respectful", "Looks like they need a slap"};

    NPC() {
    }

    NPC(String name, String age) {
        super(name, age);
    }

    NPC(String name, String age, String race, String gender) {
        super(name, age, race, gender);
    }

    @Override
    public String returnInfo() {
        return super.returnInfo();
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }

    public NPC generateRandomNPC() {
        NPC npc = new NPC();
        npc.setName(faker.name().firstName() + " " + faker.name().lastName());
        npc.setAge(Integer.toString(random.nextInt(53) + 16));
        npc.setRace(races[random.nextInt(races.length)]);
        npc.setGender(genders[random.nextInt(genders.length)]);
        npc.setAlignment(alignments[random.nextInt(alignments.length)]);
        int lang = random.nextInt(5) + 1;
        java.util.List langs = new ArrayList();
        langs.add("Common");
        if (npc.getRace().equals("Dragonborn")) { langs.add("Draconic"); }
        else if (npc.getRace().equals("Dwarf")) { langs.add("Dwarvish"); }
        else if (npc.getRace().equals("Elf")) { langs.add("Elvish"); }
        else if (npc.getRace().equals("Gnome")) { langs.add("Gnomish"); }
        else if (npc.getRace().equals("Halfling")) { langs.add("Halfling"); }
        else if (npc.getRace().equals("Half-Orc") | npc.getRace().equals("Orc")) { langs.add("Orc"); }
        else if (npc.getRace().equals("Tiefling")) { langs.add("Infernal"); }
        else if (npc.getRace().equals("Aarakocra")) { langs.add("Aarakocra"); }
        else if (npc.getRace().equals("Goblin")) { langs.add("Goblin"); }
        for (int i = 0; i < lang; i++) {
            String temp = languages[random.nextInt(languages.length)];
            if (!langs.contains(temp))
                langs.add(temp);
        }
        npc.setLanguages(Arrays.toString(langs.toArray()));
        npc.setTraits(traits[random.nextInt(traits.length)]);
        String[] stats = new String[6];
        for (int i = 0; i < stats.length; i++) {
            stats[i] = Integer.toString(random.nextInt(16) + 5);
        }
        npc.setStats(stats);
        return npc;
    }
}