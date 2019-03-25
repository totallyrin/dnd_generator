package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Quest {

    Random random = new Random();
    NPC npc = new NPC().generateRandomNPC();
    String reward = "nothing";
    String[] questTypes = {"fetchQuest", "killQuest", "targetQuest", "deliverQuest", "escortQuest"};
    String[] directions = {"north", "south", "east", "west", "northeast", "northwest", "southeast", "southwest"};
    String direction = directions[random.nextInt(directions.length)];

    Quest() {}

    public String getQuest(String questType){

        int questnum = random.nextInt(questTypes.length);

        switch (questType){
            case "fetchQuest": return new FetchQuest().generateQuest();
            case "killQuest": return new KillQuest().generateQuest();
            case "targetQuest": return new TargetQuest().generateQuest();
            case "deliverQuest": return new DeliverQuest().generateQuest();
            case "escortQuest": return new EscortQuest().generateQuest();
            default: return getQuest(questTypes[questnum]);

        }
    }

    public static JPanel questGeneratorUI(JFrame window, JPanel parent){

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setForeground(new Color(255, 255, 255));
        title.setText("Generate Quest");
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel text = new JLabel();
        text.setFont(new Font(Common.font, 0, 12));
        text.setForeground(new Color(255, 255, 255));
        text.setText("Choose Difficulty");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel chooseQuest = new JPanel();
        chooseQuest.setLayout(new BoxLayout(chooseQuest, BoxLayout.Y_AXIS));

        //<editor-fold desc="quest type buttons">
        JButton qfetch = new JButton("Fetch");
        JButton qkill = new JButton("Kill");
        JButton qtarget = new JButton("Target");
        JButton qdeliver = new JButton("Deliver");
        JButton qescort = new JButton("Escort");
        JButton qrandom = new JButton("Random");

        qfetch.setAlignmentX(JButton.CENTER_ALIGNMENT);
        qkill.setAlignmentX(JButton.CENTER_ALIGNMENT);
        qtarget.setAlignmentX(JButton.CENTER_ALIGNMENT);
        qdeliver.setAlignmentX(JButton.CENTER_ALIGNMENT);
        qescort.setAlignmentX(JButton.CENTER_ALIGNMENT);
        qrandom.setAlignmentX(JButton.CENTER_ALIGNMENT);

        chooseQuest.add(qfetch);
        chooseQuest.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseQuest.add(qkill);
        chooseQuest.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseQuest.add(qtarget);
        chooseQuest.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseQuest.add(qdeliver);
        chooseQuest.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseQuest.add(qescort);
        chooseQuest.add(Box.createRigidArea(new Dimension(0, 10)));
        chooseQuest.add(qrandom);
        chooseQuest.setBackground(Common.def);
        //</editor-fold>

        qfetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "fetchQuest");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        qkill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "killQuest");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        qtarget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "targetQuest");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        qdeliver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "deliverQuest");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        qescort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "escortQuest");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        qrandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JPanel questPanel = generatedQuestUI(window, frame, "N/A");
                questPanel.setVisible(false);
                window.add(questPanel);
                frame.setVisible(false);
                questPanel.setVisible(true);
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
        frame.add(text);
        frame.add(Box.createRigidArea(new Dimension(0, 10)));
        frame.add(chooseQuest);
        frame.add(Box.createRigidArea(new Dimension(0, 30)));
        frame.add(buttons);

        return frame;

    }

    public static JPanel generatedQuestUI(JFrame window, JPanel parent, String questType){

        JPanel frame = new JPanel();
        frame.setBackground(Common.def);

        BoxLayout bx = new BoxLayout(frame, BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
        title.setText("default");
        title.setForeground(new Color(255, 255, 255));
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        switch (questType){
            case "fetchQuest": title.setText("Fetch Quest"); break;
            case "killQuest": title.setText("Kill Quest"); break;
            case "targetQuest": title.setText("Target Quest"); break;
            case "deliverQuest": title.setText("Deliver Quest"); break;
            case "escortQuest": title.setText("Escort Quest"); break;
            default: title.setText("Random Quest"); break;
        }

        JLabel text = new JLabel();
        text.setFont(new Font(Common.font, 0, 16));
        text.setForeground(new Color(255, 255, 255));
        text.setText("<html><div style='text-align: center;'>" + new Quest().getQuest(questType) + "</div></html>");
        text.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        JButton rand = new JButton("Randomise");
        rand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("<html><div style='text-align: center;'>" + new Quest().getQuest(questType) + "</div></html>");
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

class FetchQuest extends Quest {

    String[] objects = {"sword", "book", "scroll", "chest", "set of armour", "helmet", "shield", "axe", "hammer", "banner", "crown"};
    String[] adjectives = {"ancient", "cursed", "magical", "personal", "expensive", "shoddy", "giant", "legendary", "enchanted", "forbidden"};
    String[] locations = {"cave", "mine", "forest", "museum", "library", "mansion", "castle", "fort", "town", "village", "city", "mountain"};
    String[] adj2 = {"creepy", "haunted", "famous", "infamous", "huge", "hidden", "secret", "magical", "cursed", "legendary", "abandoned"};

    FetchQuest() {}

    public String generateQuest() {
        reward = Common.round((random.nextInt(71) + 30)) + " GP";
        String object = adjectives[random.nextInt(adjectives.length)] + " " + objects[random.nextInt(objects.length)];
        String location = adj2[random.nextInt(adj2.length)] + " " + locations[random.nextInt(locations.length)];
        return String.format("%s wants the party to get %s %s from %s %s to the %s, and will pay %s.", super.npc.getName(), Common.getArticle(object), object, Common.getArticle(location), location, direction, reward);
    }

}

class KillQuest extends Quest {

    String[] enemies = {"goblins", "orcs", "swarms of rats", "gnolls", "owlbears", "black puddings", "beholder", "dragon", "gelatinous cubes", "wraiths", "trolls", "wolves", "bugbears"};
    String[] locations = {"cave", "mountain", "mine", "castle", "fort", "forest", "swamp", "marsh"};

    public String generateQuest() {
        String enemy = enemies[random.nextInt(enemies.length)];
        String location = locations[random.nextInt(locations.length)];
        String num = Integer.toString(random.nextInt(13) + 3);
        reward = Common.round(random.nextInt((131) + 20)) + " GP";
        if (enemy.equals("dragon") || enemy.equals("beholder")) {
            num = "a";
            reward = Common.round((random.nextInt(751) + 250)) + " GP";
        }
        return String.format("%s wants the party to kill %s %s at the %s to the %s, and will pay %s.", super.npc.getName(), num, enemy, location, direction, reward);
    }

}

class TargetQuest extends KillQuest {

    NPC target = new NPC().generateRandomNPC();
    String[] locations = {"the tavern", "the market", "the cemetery", "the forest", "the town hall", "the next town", "their home"};

    @Override
    public String generateQuest() {
        int num = random.nextInt(locations.length);
        reward = Common.round((random.nextInt(151) + 50)) + " GP";
        return String.format("%s wants the party to kill someone named %s who is in %s, and will pay %s.", super.npc.getName(), target.getName(), locations[num], reward);
    }

}

class DeliverQuest extends Quest {

    String[] objects = {"sword", "book", "scroll", "letter", "set of armour", "helmet", "shield", "axe", "hammer", "animal", "package"};
    String[] destinations = {"town", "city", "village", "fort", "castle", "cave", "college"};
    NPC recipient = new NPC().generateRandomNPC();

    DeliverQuest() {}

    public String generateQuest() {
        reward = Common.round((random.nextInt(36) + 15)) + " GP";
        String object = objects[random.nextInt(objects.length)];
        String destination = destinations[random.nextInt(destinations.length)];
        return String.format("%s wants the party to deliver %s %s to %s, who is in a %s to the %s, and will pay %s.", super.npc.getName(), Common.getArticle(object), object, recipient.getName(), destination, direction, reward);
    }

}

class EscortQuest extends Quest {

    String[] destinations = {"town", "city", "village", "fort", "castle", "cave", "college"};

    EscortQuest() {}

    public String generateQuest() {
        reward = Common.round((random.nextInt(36) + 15)) + " GP";
        String destination = destinations[random.nextInt(destinations.length)];
        return String.format("%s wants the party to escort them to a %s to the %s, and will pay %s.", super.npc.getName(), destination, direction, reward);

    }



}