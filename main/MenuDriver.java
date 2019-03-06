package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MenuDriver {

    public static Color def = Color.darkGray; //sets a default bg and border colour
    public static String font = "Segoe UI";

    public static void main(String[] args) {
        buildGUI();
    }

    public static void buildGUI() {
        Border empty;
        empty = BorderFactory.createLineBorder(def, 30); //creates a border
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("D&D Character Generator"); //creating main frame for gui, must have
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set it to close on "x"
        frame.getContentPane().setBackground(def); //sets bg colour to dark gray
        frame.setSize(500, 750); //manually sets default size
        frame.setIconImage(new ImageIcon("src\\main\\images\\icon.png").getImage()); //sets icon
        frame.getRootPane().setBorder(empty); //adds border

        BoxLayout bx = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JPanel mainMenu = new JPanel();
        mainMenu.setBackground(def);

        BoxLayout bp = new BoxLayout(mainMenu, BoxLayout.Y_AXIS);
        mainMenu.setLayout(bp);

        JLabel title = new JLabel();
        title.setFont(new Font(font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("D&D Character Generator");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        mainMenu.add(title);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton character = new JButton("Generate Character");
        character.setAlignmentX(JButton.CENTER_ALIGNMENT);
        character.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel characterPanel = buildCharacterGeneratorUI(frame, mainMenu);
                characterPanel.setVisible(false);
                frame.add(characterPanel);
                mainMenu.setVisible(false);
                characterPanel.setVisible(true);
            }
        });

        JButton npc = new JButton("Generate NPC");
        npc.setAlignmentX(JButton.CENTER_ALIGNMENT);
        npc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel npcPanel = npcGeneratorUI(frame, mainMenu);
                npcPanel.setVisible(false);
                frame.add(npcPanel);
                mainMenu.setVisible(false);
                npcPanel.setVisible(true);
            }
        });

        mainMenu.add(character);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(npc);

        frame.add(mainMenu);
        frame.setVisible(true); //allows frame/gui to appear, must have
    }

    public static JPanel buildCharacterGeneratorUI(JFrame window, JPanel parent) {

        Border empty;
        empty = BorderFactory.createLineBorder(def, 30); //creates a border

        JPanel frame = new JPanel();
        frame.setBackground(def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Generate Character");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel note = new JLabel();
        note.setFont(new Font(font, 0, 12));
        note.setForeground(new Color(255, 255, 255));
        note.setText("Leave a field empty to randomise it");
        note.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        //<editor-fold desc="fields">
        //<editor-fold desc="name field">
        JLabel Name = new JLabel();
        Name.setFont(new Font(font, 0, 12));
        Name.setForeground(Color.white);
        Name.setText("Name: ");
        Name.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tname = new JTextField(15);
        tname.setMaximumSize(tname.getPreferredSize());
        tname.setHorizontalAlignment(JTextField.CENTER);

        JPanel pname = new JPanel();
        pname.setLayout(new BoxLayout(pname, BoxLayout.Y_AXIS));
        pname.setBackground(def);
        pname.add(Name);
        pname.add(Box.createRigidArea(new Dimension(0, 2)));
        pname.add(tname);
        //</editor-fold>

        //<editor-fold desc="age field">
        JLabel Age = new JLabel();
        Age.setFont(new Font(font, 0, 12));
        Age.setForeground(Color.white);
        Age.setText("Age: ");
        Age.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tage = new JTextField(5);
        tage.setMaximumSize(tage.getPreferredSize());
        tage.setHorizontalAlignment(JTextField.CENTER);

        JPanel page = new JPanel();
        page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));
        page.setBackground(def);
        page.add(Age);
        page.add(Box.createRigidArea(new Dimension(0, 2)));
        page.add(tage);
        //</editor-fold>

        //<editor-fold desc="race field">
        JLabel Race = new JLabel();
        Race.setFont(new Font(font, 0, 12));
        Race.setForeground(Color.white);
        Race.setText("Race: ");
        Race.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField trace = new JTextField(10);
        trace.setMaximumSize(trace.getPreferredSize());
        trace.setHorizontalAlignment(JTextField.CENTER);

        JPanel prace = new JPanel();
        prace.setLayout(new BoxLayout(prace, BoxLayout.Y_AXIS));
        prace.setBackground(def);
        prace.add(Race);
        prace.add(Box.createRigidArea(new Dimension(0, 2)));
        prace.add(trace);
        //</editor-fold>

        //<editor-fold desc="gender field">
        JLabel Gender = new JLabel();
        Gender.setFont(new Font(font, 0, 12));
        Gender.setForeground(Color.white);
        Gender.setText("Gender: ");
        Gender.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tgender = new JTextField(8);
        tgender.setMaximumSize(tgender.getPreferredSize());
        tgender.setHorizontalAlignment(JTextField.CENTER);

        JPanel pgender = new JPanel();
        pgender.setLayout(new BoxLayout(pgender, BoxLayout.Y_AXIS));
        pgender.setBackground(def);
        pgender.add(Gender);
        pgender.add(Box.createRigidArea(new Dimension(0, 2)));
        pgender.add(tgender);
        //</editor-fold>

        //<editor-fold desc="alignment field">
        JLabel Alignment = new JLabel();
        Alignment.setFont(new Font(font, 0, 12));
        Alignment.setForeground(Color.white);
        Alignment.setText("Alignment: ");
        Alignment.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField talignment = new JTextField(10);
        talignment.setMaximumSize(talignment.getPreferredSize());
        talignment.setHorizontalAlignment(JTextField.CENTER);

        JPanel palignment = new JPanel();
        palignment.setLayout(new BoxLayout(palignment, BoxLayout.Y_AXIS));
        palignment.setBackground(def);
        palignment.add(Alignment);
        palignment.add(Box.createRigidArea(new Dimension(0, 2)));
        palignment.add(talignment);
        //</editor-fold>

        //<editor-fold desc="class field">
        JLabel Class = new JLabel();
        Class.setFont(new Font(font, 0, 12));
        Class.setForeground(Color.white);
        Class.setText("Class: ");
        Class.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tclass = new JTextField(8);
        tclass.setMaximumSize(tclass.getPreferredSize());
        tclass.setHorizontalAlignment(JTextField.CENTER);

        JPanel pclass = new JPanel();
        pclass.setLayout(new BoxLayout(pclass, BoxLayout.Y_AXIS));
        pclass.setBackground(def);
        pclass.add(Class);
        pclass.add(Box.createRigidArea(new Dimension(0, 2)));
        pclass.add(tclass);
        //</editor-fold>

        //<editor-fold desc="language field">
        JLabel Language = new JLabel();
        Language.setFont(new Font(font, 0, 12));
        Language.setForeground(Color.white);
        Language.setText("Languages: ");
        Language.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tlanguage = new JTextField(20);
        tlanguage.setMaximumSize(tlanguage.getPreferredSize());
        tlanguage.setHorizontalAlignment(JTextField.CENTER);

        JPanel planguage = new JPanel();
        planguage.setLayout(new BoxLayout(planguage, BoxLayout.Y_AXIS));
        planguage.setBackground(def);
        planguage.add(Language);
        planguage.add(Box.createRigidArea(new Dimension(0, 2)));
        planguage.add(tlanguage);
        //</editor-fold>

        //<editor-fold desc="proficient field">
        JLabel Proficient = new JLabel();
        Proficient.setFont(new Font(font, 0, 12));
        Proficient.setForeground(Color.white);
        Proficient.setText("Proficiencies: ");
        Proficient.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tproficient = new JTextField(20);
        tproficient.setMaximumSize(tproficient.getPreferredSize());
        tproficient.setHorizontalAlignment(JTextField.CENTER);

        JPanel pproficient = new JPanel();
        pproficient.setLayout(new BoxLayout(pproficient, BoxLayout.Y_AXIS));
        pproficient.setBackground(def);
        pproficient.add(Proficient);
        pproficient.add(Box.createRigidArea(new Dimension(0, 2)));
        pproficient.add(tproficient);
        //</editor-fold>

        //<editor-fold desc="trait field">
        JLabel Trait = new JLabel();
        Trait.setFont(new Font(font, 0, 12));
        Trait.setForeground(Color.white);
        Trait.setText("Traits: ");
        Trait.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField ttrait = new JTextField(20);
        ttrait.setMaximumSize(ttrait.getPreferredSize());
        ttrait.setHorizontalAlignment(JTextField.CENTER);

        JPanel ptrait = new JPanel();
        ptrait.setLayout(new BoxLayout(ptrait, BoxLayout.Y_AXIS));
        ptrait.setBackground(def);
        ptrait.add(Trait);
        ptrait.add(Box.createRigidArea(new Dimension(0, 2)));
        ptrait.add(ttrait);
        //</editor-fold>

        //<editor-fold desc="scores panel 1">
        JLabel str = new JLabel();
        str.setFont(new Font(font, 0, 12));
        str.setForeground(Color.white);
        str.setText("STR: ");
        str.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tSTR = new JTextField(2);
        tSTR.setMaximumSize(tSTR.getPreferredSize());
        tSTR.setHorizontalAlignment(JTextField.CENTER);

        JLabel dex = new JLabel();
        dex.setFont(new Font(font, 0, 12));
        dex.setForeground(Color.white);
        dex.setText("DEX: ");
        dex.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tDEX = new JTextField(2);
        tDEX.setMaximumSize(tDEX.getPreferredSize());
        tDEX.setHorizontalAlignment(JTextField.CENTER);

        JLabel con = new JLabel();
        con.setFont(new Font(font, 0, 12));
        con.setForeground(Color.white);
        con.setText("CON: ");
        con.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tCON = new JTextField(2);
        tCON.setMaximumSize(tCON.getPreferredSize());
        tCON.setHorizontalAlignment(JTextField.CENTER);

        JPanel scores1 = new JPanel();
        scores1.setLayout(new BoxLayout(scores1, BoxLayout.X_AXIS));
        scores1.setBackground(def);
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
        ing.setFont(new Font(font, 0, 12));
        ing.setForeground(Color.white);
        ing.setText("INT: ");
        ing.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tINT = new JTextField(2);
        tINT.setMaximumSize(tINT.getPreferredSize());
        tINT.setHorizontalAlignment(JTextField.CENTER);

        JLabel wis = new JLabel();
        wis.setFont(new Font(font, 0, 12));
        wis.setForeground(Color.white);
        wis.setText("WIS: ");
        wis.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tWIS = new JTextField(2);
        tWIS.setMaximumSize(tWIS.getPreferredSize());
        tWIS.setHorizontalAlignment(JTextField.CENTER);

        JLabel cha = new JLabel();
        cha.setFont(new Font(font, 0, 12));
        cha.setForeground(Color.white);
        cha.setText("CHA: ");
        cha.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JTextField tCHA = new JTextField(2);
        tCHA.setMaximumSize(tCHA.getPreferredSize());
        tCHA.setHorizontalAlignment(JTextField.CENTER);

        JPanel scores2 = new JPanel();
        scores2.setLayout(new BoxLayout(scores2, BoxLayout.X_AXIS));
        scores2.setBackground(def);
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
                JPanel character = generatedCharacterUI(window, frame, name, age, race, gender, alignment, aClass, language, proficient, trait, STR, DEX, CON, INT, WIS, CHA);
                character.setVisible(false);
                window.add(character);
                frame.setVisible(false);
                character.setVisible(true);
            }
        });
        back.setAlignmentX(JButton.CENTER_ALIGNMENT);

        buttons.add(back);
        buttons.add(confirm);
        buttons.setBackground(def);

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

    public static JPanel generatedCharacterUI(JFrame window, JPanel parent, String name, String age, String race, String gender, String alignment, String cclass, String langs, String profs,
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

        Border empty;
        empty = BorderFactory.createLineBorder(def, 30); //creates a border

        JPanel frame = new JPanel();
        frame.setBackground(def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText(character.getName());
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setFont(new Font(font, 0, 16));
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
        buttons.setBackground(def);

        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(text);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

    public static JPanel npcGeneratorUI(JFrame window, JPanel parent) {

        NPC npc = new NPC().generateRandomNPC();

        Border empty;
        empty = BorderFactory.createLineBorder(def, 30); //creates a border

        JPanel frame = new JPanel();
        frame.setBackground(def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText(npc.getName());
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setFont(new Font(font, 0, 16));
        text.setForeground(new Color(255, 255, 255));
        text.setText("<html>" + npc.returnInfo().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        JButton rand = new JButton("Randomise");
        rand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NPC npc = new NPC().generateRandomNPC();
                title.setText(npc.getName());
                text.setText("<html>" + npc.returnInfo().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
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
        buttons.setBackground(def);

        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 20)));
        frame.add(text);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

}
