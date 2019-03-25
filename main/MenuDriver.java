package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MenuDriver {

    public static void main(String[] args) {
        buildGUI();
    }

    public static void buildGUI() {

        Border empty;
        empty = BorderFactory.createLineBorder(Common.def, 30); //creates a border
       // Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("D&D Character Generator"); //creating main frame for gui, must have
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //set it to close on "x"
        frame.getContentPane().setBackground(Common.def); //sets bg colour to dark gray
        frame.setSize(500, 750); //manually sets default size
        frame.setIconImage(new ImageIcon("src\\main\\images\\icon.png").getImage()); //sets icon
        frame.getRootPane().setBorder(empty); //adds border

        BoxLayout bx = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(bx);

        JPanel mainMenu = new JPanel();
        mainMenu.setBackground(Common.def);

        BoxLayout bp = new BoxLayout(mainMenu, BoxLayout.Y_AXIS);
        mainMenu.setLayout(bp);

        JLabel title = new JLabel();
        title.setFont(new Font(Common.font, 0, 25));
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
                JPanel characterPanel = Character.buildCharacterGeneratorUI(frame, mainMenu);
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
                JPanel npcPanel = NPC.npcGeneratorUI(mainMenu);
                npcPanel.setVisible(false);
                frame.add(npcPanel);
                mainMenu.setVisible(false);
                npcPanel.setVisible(true);
            }
        });

        JButton quest = new JButton("Generate Quest");
        quest.setAlignmentX(JButton.CENTER_ALIGNMENT);
        quest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel questPanel = Quest.questGeneratorUI(frame, mainMenu);
                questPanel.setVisible(false);
                frame.add(questPanel);
                mainMenu.setVisible(false);
                questPanel.setVisible(true);
            }
        });

        JButton encounter = new JButton("Generate Encounter");
        encounter.setAlignmentX(JButton.CENTER_ALIGNMENT);
        encounter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel encounterPanel = Creature.encounterGeneratorUI(frame, mainMenu);
                encounterPanel.setVisible(false);
                frame.add(encounterPanel);
                mainMenu.setVisible(false);
                encounterPanel.setVisible(true);
            }
        });

        mainMenu.add(character);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(npc);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(quest);
        mainMenu.add(Box.createRigidArea(new Dimension(0, 10)));
        mainMenu.add(encounter);

        frame.add(mainMenu);
        frame.setVisible(true); //allows window/gui to appear, must have

    }

}
