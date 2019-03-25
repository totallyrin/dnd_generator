package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import com.github.javafaker.Faker;

import javax.swing.*;
import javax.swing.border.Border;

public class Character extends Person {

    private String Class = "N/A";
    private String proficiencies = "N/A";

    private Faker faker = new Faker();
    private Random random = new Random();

    protected String[] races = {"Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human", "Tiefling", "Aarakocra", "Genasi", "Goliath", "Aasimar",
            "Bugbear", "Firbolg", "Goblin", "Hobgoblin", "Kenku", "Kobold", "Lizardfolk", "Orc", "Tabaxi", "Triton", "Yuan-ti", "Tortle"};
    private String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
    protected String[] genders = {"Male", "Female", "Other"};
    protected String[] languages = {"Common", "Dwarvish", "Elvish", "Giant", "Gnomish", "Goblin", "Halfling", "Orc", "Merfolk", "Abyssal", "Celestial", "Draconic",
            "Deep Speech", "Infernal", "Primordial", "Sylvan", "Undercommon", "Aarakocra"}; //, "Druidic", "Theives' Cant"
    protected String[] traits = {"Shy", "Arrogant", "Assertive", "Loud", "Annoying", "Studious", "Smart", "Stupid", "Nice", "Rude", "Respectful", "Looks like they need a slap"};
    protected String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
    protected String[] theproficiencies = {"Light Armour", "Medium Armour", "Heavy Armour", "Ranged Weapons", "Melee Weapons", "Simple Melee Weapons", "Martial Weapons", "Simple Weapons",
            "Martial Melee Weapons", "Simple Ranged Weapons", "Martial Ranged Weapons"};

    Character(){}

    public void setClass(String aClass) {
        Class = aClass;
    }

    public void setProficiencies(String proficiencies) {
        this.proficiencies = proficiencies;
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

    public static JPanel buildCharacterGeneratorUI(JFrame window, JPanel parent) {

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Generate Character");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel note = new JLabel();
        note.setFont(new Font(Common.font, 0, 12));
        note.setForeground(new Color(255, 255, 255));
        note.setText("Leave a field empty to randomise it");
        note.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        //<editor-fold desc="fields">
        //<editor-fold desc="name field">
        JLabel Name = new JLabel();
        Name.setFont(new Font(Common.font, 0, 12));
        Name.setForeground(Color.white);
        Name.setText("Name: ");
        Name.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tname = new JTextField(15);
        tname.setMaximumSize(tname.getPreferredSize());
        tname.setHorizontalAlignment(JTextField.CENTER);

        JPanel pname = new JPanel();
        pname.setLayout(new BoxLayout(pname, BoxLayout.Y_AXIS));
        pname.setBackground(Common.def);
        pname.add(Name);
        pname.add(Box.createRigidArea(new Dimension(0, 2)));
        pname.add(tname);
        //</editor-fold>

        //<editor-fold desc="age field">
        JLabel Age = new JLabel();
        Age.setFont(new Font(Common.font, 0, 12));
        Age.setForeground(Color.white);
        Age.setText("Age: ");
        Age.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tage = new JTextField(5);
        tage.setMaximumSize(tage.getPreferredSize());
        tage.setHorizontalAlignment(JTextField.CENTER);

        JPanel page = new JPanel();
        page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));
        page.setBackground(Common.def);
        page.add(Age);
        page.add(Box.createRigidArea(new Dimension(0, 2)));
        page.add(tage);
        //</editor-fold>

        //<editor-fold desc="race field">
        JLabel Race = new JLabel();
        Race.setFont(new Font(Common.font, 0, 12));
        Race.setForeground(Color.white);
        Race.setText("Race: ");
        Race.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField trace = new JTextField(10);
        trace.setMaximumSize(trace.getPreferredSize());
        trace.setHorizontalAlignment(JTextField.CENTER);

        JPanel prace = new JPanel();
        prace.setLayout(new BoxLayout(prace, BoxLayout.Y_AXIS));
        prace.setBackground(Common.def);
        prace.add(Race);
        prace.add(Box.createRigidArea(new Dimension(0, 2)));
        prace.add(trace);
        //</editor-fold>

        //<editor-fold desc="gender field">
        JLabel Gender = new JLabel();
        Gender.setFont(new Font(Common.font, 0, 12));
        Gender.setForeground(Color.white);
        Gender.setText("Gender: ");
        Gender.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tgender = new JTextField(8);
        tgender.setMaximumSize(tgender.getPreferredSize());
        tgender.setHorizontalAlignment(JTextField.CENTER);

        JPanel pgender = new JPanel();
        pgender.setLayout(new BoxLayout(pgender, BoxLayout.Y_AXIS));
        pgender.setBackground(Common.def);
        pgender.add(Gender);
        pgender.add(Box.createRigidArea(new Dimension(0, 2)));
        pgender.add(tgender);
        //</editor-fold>

        //<editor-fold desc="alignment field">
        JLabel Alignment = new JLabel();
        Alignment.setFont(new Font(Common.font, 0, 12));
        Alignment.setForeground(Color.white);
        Alignment.setText("Alignment: ");
        Alignment.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField talignment = new JTextField(10);
        talignment.setMaximumSize(talignment.getPreferredSize());
        talignment.setHorizontalAlignment(JTextField.CENTER);

        JPanel palignment = new JPanel();
        palignment.setLayout(new BoxLayout(palignment, BoxLayout.Y_AXIS));
        palignment.setBackground(Common.def);
        palignment.add(Alignment);
        palignment.add(Box.createRigidArea(new Dimension(0, 2)));
        palignment.add(talignment);
        //</editor-fold>

        //<editor-fold desc="class field">
        JLabel Class = new JLabel();
        Class.setFont(new Font(Common.font, 0, 12));
        Class.setForeground(Color.white);
        Class.setText("Class: ");
        Class.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tclass = new JTextField(8);
        tclass.setMaximumSize(tclass.getPreferredSize());
        tclass.setHorizontalAlignment(JTextField.CENTER);

        JPanel pclass = new JPanel();
        pclass.setLayout(new BoxLayout(pclass, BoxLayout.Y_AXIS));
        pclass.setBackground(Common.def);
        pclass.add(Class);
        pclass.add(Box.createRigidArea(new Dimension(0, 2)));
        pclass.add(tclass);
        //</editor-fold>

        //<editor-fold desc="language field">
        JLabel Language = new JLabel();
        Language.setFont(new Font(Common.font, 0, 12));
        Language.setForeground(Color.white);
        Language.setText("Languages: ");
        Language.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tlanguage = new JTextField(20);
        tlanguage.setMaximumSize(tlanguage.getPreferredSize());
        tlanguage.setHorizontalAlignment(JTextField.CENTER);

        JPanel planguage = new JPanel();
        planguage.setLayout(new BoxLayout(planguage, BoxLayout.Y_AXIS));
        planguage.setBackground(Common.def);
        planguage.add(Language);
        planguage.add(Box.createRigidArea(new Dimension(0, 2)));
        planguage.add(tlanguage);
        //</editor-fold>

        //<editor-fold desc="proficient field">
        JLabel Proficient = new JLabel();
        Proficient.setFont(new Font(Common.font, 0, 12));
        Proficient.setForeground(Color.white);
        Proficient.setText("Proficiencies: ");
        Proficient.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tproficient = new JTextField(20);
        tproficient.setMaximumSize(tproficient.getPreferredSize());
        tproficient.setHorizontalAlignment(JTextField.CENTER);

        JPanel pproficient = new JPanel();
        pproficient.setLayout(new BoxLayout(pproficient, BoxLayout.Y_AXIS));
        pproficient.setBackground(Common.def);
        pproficient.add(Proficient);
        pproficient.add(Box.createRigidArea(new Dimension(0, 2)));
        pproficient.add(tproficient);
        //</editor-fold>

        //<editor-fold desc="trait field">
        JLabel Trait = new JLabel();
        Trait.setFont(new Font(Common.font, 0, 12));
        Trait.setForeground(Color.white);
        Trait.setText("Traits: ");
        Trait.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField ttrait = new JTextField(20);
        ttrait.setMaximumSize(ttrait.getPreferredSize());
        ttrait.setHorizontalAlignment(JTextField.CENTER);

        JPanel ptrait = new JPanel();
        ptrait.setLayout(new BoxLayout(ptrait, BoxLayout.Y_AXIS));
        ptrait.setBackground(Common.def);
        ptrait.add(Trait);
        ptrait.add(Box.createRigidArea(new Dimension(0, 2)));
        ptrait.add(ttrait);
        //</editor-fold>

        //<editor-fold desc="scores panel 1">
        JLabel str = new JLabel();
        str.setFont(new Font(Common.font, 0, 12));
        str.setForeground(Color.white);
        str.setText("STR: ");
        str.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tSTR = new JTextField(2);
        tSTR.setMaximumSize(tSTR.getPreferredSize());
        tSTR.setHorizontalAlignment(JTextField.CENTER);

        JLabel dex = new JLabel();
        dex.setFont(new Font(Common.font, 0, 12));
        dex.setForeground(Color.white);
        dex.setText("DEX: ");
        dex.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tDEX = new JTextField(2);
        tDEX.setMaximumSize(tDEX.getPreferredSize());
        tDEX.setHorizontalAlignment(JTextField.CENTER);

        JLabel con = new JLabel();
        con.setFont(new Font(Common.font, 0, 12));
        con.setForeground(Color.white);
        con.setText("CON: ");
        con.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tCON = new JTextField(2);
        tCON.setMaximumSize(tCON.getPreferredSize());
        tCON.setHorizontalAlignment(JTextField.CENTER);

        JPanel scores1 = new JPanel();
        scores1.setLayout(new BoxLayout(scores1, BoxLayout.X_AXIS));
        scores1.setBackground(Common.def);
        scores1.add(str);
        scores1.add(tSTR);
        scores1.add(Box.createRigidArea(new Dimension(5, 0)));
        scores1.add(dex);
        scores1.add(tDEX);
        scores1.add(Box.createRigidArea(new Dimension(5, 0)));
        scores1.add(con);
        scores1.add(tCON);
        //</editor-fold>

        //<editor-fold desc="scores panel 2">
        JLabel ing = new JLabel();
        ing.setFont(new Font(Common.font, 0, 12));
        ing.setForeground(Color.white);
        ing.setText("INT: ");
        ing.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tINT = new JTextField(2);
        tINT.setMaximumSize(tINT.getPreferredSize());
        tINT.setHorizontalAlignment(JTextField.CENTER);

        JLabel wis = new JLabel();
        wis.setFont(new Font(Common.font, 0, 12));
        wis.setForeground(Color.white);
        wis.setText("WIS: ");
        wis.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tWIS = new JTextField(2);
        tWIS.setMaximumSize(tWIS.getPreferredSize());
        tWIS.setHorizontalAlignment(JTextField.CENTER);

        JLabel cha = new JLabel();
        cha.setFont(new Font(Common.font, 0, 12));
        cha.setForeground(Color.white);
        cha.setText("CHA: ");
        cha.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tCHA = new JTextField(2);
        tCHA.setMaximumSize(tCHA.getPreferredSize());
        tCHA.setHorizontalAlignment(JTextField.CENTER);

        JPanel scores2 = new JPanel();
        scores2.setLayout(new BoxLayout(scores2, BoxLayout.X_AXIS));
        scores2.setBackground(Common.def);
        scores2.add(ing);
        scores2.add(tINT);
        scores2.add(Box.createRigidArea(new Dimension(5, 0)));
        scores2.add(wis);
        scores2.add(tWIS);
        scores2.add(Box.createRigidArea(new Dimension(5, 0)));
        scores2.add(cha);
        scores2.add(tCHA);
        //</editor-fold>
        //</editor-fold>

        JPanel buttons = new JPanel();

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                parent.setVisible(true);
            }
        });
        back.setAlignmentX(JButton.CENTER_ALIGNMENT);

        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //<editor-fold desc="get text">
                String name = tname.getText();
                String age = tage.getText();
                String race = trace.getText();
                String gender = tgender.getText();
                String alignment = talignment.getText();
                String aClass = tclass.getText();
                String language = tlanguage.getText();
                String proficient = tproficient.getText();
                String trait = ttrait.getText();
                String STR = tSTR.getText();
                String DEX = tDEX.getText();
                String CON = tCON.getText();
                String INT = tINT.getText();
                String WIS = tWIS.getText();
                String CHA = tCHA.getText();
                //</editor-fold>
                JPanel character = generatedCharacterUI(frame, name, age, race, gender, alignment, aClass, language, proficient, trait, STR, DEX, CON, INT, WIS, CHA);
                character.setVisible(false);
                window.add(character);
                frame.setVisible(false);
                character.setVisible(true);
            }
        });
        back.setAlignmentX(JButton.CENTER_ALIGNMENT);

        buttons.add(back);
        buttons.add(confirm);
        buttons.setBackground(Common.def);

        //<editor-fold desc="add to panel">
        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 3)));
        frame.add(note);
        frame.add(Box.createRigidArea(new Dimension(0, 15)));
        frame.add(pname);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(page);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(prace);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(pgender);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(palignment);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(pclass);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(planguage);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(pproficient);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(ptrait);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(scores1);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(scores2);
        //</editor-fold>

        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

    public static JPanel generatedCharacterUI(JPanel parent, String name, String age, String race, String gender, String alignment, String cclass, String langs, String profs,
                                              String traits, String str, String dex, String con, String ing, String wis, String cha){

        Character character = new Character().generateRandomCharacter();

        //<editor-fold desc="setters">
        if (!name.equals(""))
            character.setName(name);
        if (!age.equals(""))
            character.setAge(age);
        if (!race.equals(""))
            character.setRace(race);
        if (!gender.equals(""))
            character.setGender(gender);
        if (!alignment.equals(""))
            character.setAlignment(alignment);
        if (!cclass.equals(""))
            character.setClass(cclass);
        if (!langs.equals(""))
            character.setLanguages(langs);
        if (!profs.equals(""))
            character.setProficiencies(profs);
        if (!traits.equals(""))
            character.setTraits(traits);

        String[] stats = character.getStats();

        if (!str.equals(""))
            stats[0] = str;
        if (!dex.equals(""))
            stats[1] = dex;
        if (!con.equals(""))
            stats[2] = con;
        if (!ing.equals(""))
            stats[3] = ing;
        if (!wis.equals(""))
            stats[4] = wis;
        if (!cha.equals(""))
            stats[5] = cha;

        character.setStats(stats);
        //</editor-fold>

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText(character.getName());
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setFont(new Font(Common.font, 0, 16));
        text.setForeground(new Color(255, 255, 255));
        text.setText("<html>" + character.returnInfo().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        JButton rand = new JButton("Randomise");
        rand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Character character = new Character().generateRandomCharacter();
                //<editor-fold desc="setters">
                if (!name.equals(""))
                    character.setName(name);
                if (!age.equals(""))
                    character.setAge(age);
                if (!race.equals(""))
                    character.setRace(race);
                if (!gender.equals(""))
                    character.setGender(gender);
                if (!alignment.equals(""))
                    character.setAlignment(alignment);
                if (!cclass.equals(""))
                    character.setClass(cclass);
                if (!langs.equals(""))
                    character.setLanguages(langs);
                if (!profs.equals(""))
                    character.setProficiencies(profs);
                if (!traits.equals(""))
                    character.setTraits(traits);

                String[] stats = character.getStats();

                if (!str.equals(""))
                    stats[0] = str;
                if (!dex.equals(""))
                    stats[1] = dex;
                if (!con.equals(""))
                    stats[2] = con;
                if (!ing.equals(""))
                    stats[3] = ing;
                if (!wis.equals(""))
                    stats[4] = wis;
                if (!cha.equals(""))
                    stats[5] = cha;

                character.setStats(stats);
                //</editor-fold>
                title.setText(character.getName());
                text.setText("<html>" + character.returnInfo().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
            }
        });
        rand.setAlignmentX(JButton.CENTER_ALIGNMENT);

        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                parent.setVisible(true);
            }
        });
        back.setAlignmentX(JButton.CENTER_ALIGNMENT);
        buttons.add(back);
        buttons.add(rand);
        buttons.setBackground(Common.def);

        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(text);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

}
