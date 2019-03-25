package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Creature {

    private String[][] races = {{"Kobold", "Bandit", "Goblin", "Skeleton", "Wolf", "Zombie", "Gnoll", "Hobgoblin", "Orc", "Bugbear"}, //CR <= 1
                                {"Cultist", "Giant Boar", "Gelatinous Cube", "Basilisk", "Hell Hound", "Owlbear", "Manticore", "Winter Wolf", "Elemental", "Golem", "Troll"},
                                {"Dragon", "Vampire", "Balor", "Marilith", "Lich"}}; //easy[], medium[], hard[]
    private String[] difficulties = {"easy", "med", "hard"};
    private String race = "N/A";
    String pl = "";

    Random random = new Random();

    public String generateEncounter(String difficulty){
        int i;
        String num;
        switch (difficulty) {
            case "easy": race = races[0][random.nextInt(races[0].length)]; i = (random.nextInt(10) + 1); num = getNum(i, race); race = getPlural(i, race);
                return String.format("The party encounters %s %s!", num, race);
            case "med": race = races[1][random.nextInt(races[1].length)]; i = (random.nextInt(5) + 1); num = getNum(i, race); race = getPlural(i, race);
                return String.format("The party encounters %s %s!", num, race);
            case "hard": race = races[2][random.nextInt(races[2].length)]; i = (random.nextInt(2) + 1); num = getNum(i, race); race = getPlural(i, race);
                return String.format("The party encounters %s %s!", num, race);
            default: String rand = Integer.toString(random.nextInt(difficulties.length)); return generateEncounter(rand);
        }
    }

    public String getNum(int i, String race){
        String num;
        if (i == 1)
            num = Common.getArticle(race);
        else
            num = Integer.toString(i);
        return num;
    }

    public String getPlural(int num, String race) {
        if (race.charAt(race.length() - 1) == 'f' && num > 1)
            race = race.replace("f", "ves");
        else if (num > 1)
            race = race + "s";
        return race;
    }

    public static JPanel encounterGeneratorUI(JFrame window, JPanel parent){

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Generate Encounter");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel chooseDiff = new JPanel();
        chooseDiff.setLayout(new BoxLayout(chooseDiff, BoxLayout.Y_AXIS));
        chooseDiff.setBackground(Common.def);

        JLabel text = new JLabel();
        text.setFont(new Font(Common.font, 0, 12));
        text.setForeground(new Color(255, 255, 255));
        text.setText("Choose Difficulty");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JButton easy = new JButton("Easy");
        JButton med = new JButton("Medium");
        JButton hard = new JButton("Hard");

        easy.setAlignmentX(JButton.CENTER_ALIGNMENT);
        med.setAlignmentX(JButton.CENTER_ALIGNMENT);
        hard.setAlignmentX(JButton.CENTER_ALIGNMENT);

        chooseDiff.add(text);
        chooseDiff.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseDiff.add(easy);
        chooseDiff.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseDiff.add(med);
        chooseDiff.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseDiff.add(hard);

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel encounter = generatedEncounterUI(frame, "easy");
                encounter.setVisible(false);
                window.add(encounter);
                frame.setVisible(false);
                encounter.setVisible(true);
            }
        });

        med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel encounter = generatedEncounterUI(frame, "med");
                encounter.setVisible(false);
                window.add(encounter);
                frame.setVisible(false);
                encounter.setVisible(true);
            }
        });

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel encounter = generatedEncounterUI(frame, "hard");
                encounter.setVisible(false);
                window.add(encounter);
                frame.setVisible(false);
                encounter.setVisible(true);
            }
        });

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

        buttons.add(back);
        buttons.setBackground(Common.def);

        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(chooseDiff);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

    public static JPanel generatedEncounterUI(JPanel parent, String difficulty){

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Generate Encounter");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setFont(new Font(Common.font, 0, 16));
        text.setForeground(new Color(255, 255, 255));
        text.setText(new Creature().generateEncounter(difficulty));
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        JButton randomise = new JButton("Randomise");
        randomise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                text.setText(new Creature().generateEncounter(difficulty));
            }
        });
        randomise.setAlignmentX(JButton.CENTER_ALIGNMENT);

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
        buttons.add(randomise);
        buttons.setBackground(Common.def);

        frame.add(title);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(text);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

}
