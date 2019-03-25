package main;

import java.util.*;

public class Quest {

    Random random = new Random();
    NPC npc = new NPC().generateRandomNPC();
    String name = npc.getName();
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

    public String getArticle(String word){

        char letter = word.charAt(0);

        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
            return "an";
        else
            return "a";

    }

    public int round(int num) {
        int temp = num%5;
        if (temp<3)
            return num-temp;
        else
            return num+5-temp;
    }

}

class FetchQuest extends Quest {

    String[] objects = {"sword", "book", "scroll", "chest", "set of armour", "helmet", "shield", "axe", "hammer", "banner", "crown"};
    String[] adjectives = {"ancient", "cursed", "magical", "personal", "expensive", "shoddy", "giant", "legendary", "enchanted", "forbidden"};
    String[] locations = {"cave", "mine", "forest", "museum", "library", "mansion", "castle", "fort", "town", "village", "city", "mountain"};
    String[] adj2 = {"creepy", "haunted", "famous", "infamous", "huge", "hidden", "secret", "magical", "cursed", "legendary", "abandoned"};

    FetchQuest() {}

    public String generateQuest() {
        reward = round((random.nextInt(71) + 30)) + " GP";
        String object = adjectives[random.nextInt(adjectives.length)] + objects[random.nextInt(objects.length)];
        String location = adj2[random.nextInt(adj2.length)] + locations[random.nextInt(locations.length)];
        return String.format("%s wants the party to get %s %s from %s %s to the %s, and will pay %s.", super.npc.getName(), getArticle(object), object, getArticle(location), location, direction, reward);
    }

}

class KillQuest extends Quest {

    String[] enemies = {"goblins", "orcs", "swarms of rats", "gnolls", "owlbears", "black puddings", "beholder", "dragon", "gelatinous cubes", "wraiths", "trolls", "wolves", "bugbears"};
    String[] locations = {"cave", "mountain", "mine", "castle", "fort", "forest", "swamp", "marsh"};

    public String generateQuest() {
        String enemy = enemies[random.nextInt(enemies.length)];
        String location = locations[random.nextInt(locations.length)];
        String num = Integer.toString(random.nextInt(13) + 3);
        reward = round(random.nextInt((131) + 20)) + " GP";
        if (enemy.equals("dragon") || enemy.equals("beholder")) {
            num = "a";
            reward = round((random.nextInt(751) + 250)) + " GP";
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
        reward = round((random.nextInt(151) + 50)) + " GP";
        return String.format("%s wants the party to kill someone named %s who is in %s, and will pay %s.", super.npc.getName(), target.getName(), locations[num], reward);
    }

}

class DeliverQuest extends Quest {

    String[] objects = {"sword", "book", "scroll", "letter", "set of armour", "helmet", "shield", "axe", "hammer", "animal", "package"};
    String[] destinations = {"town", "city", "village", "fort", "castle", "cave", "college"};
    NPC recipient = new NPC().generateRandomNPC();

    DeliverQuest() {}

    public String generateQuest() {
        reward = round((random.nextInt(36) + 15)) + " GP";
        String object = objects[random.nextInt(objects.length)];
        String destination = destinations[random.nextInt(destinations.length)];
        return String.format("%s wants the party to deliver %s %s to %s, who is in a %s to the %s, and will pay %s.", super.npc.getName(), getArticle(object), object, recipient.getName(), destination, direction, reward);
    }

}

class EscortQuest extends Quest {

    String[] destinations = {"town", "city", "village", "fort", "castle", "cave", "college"};

    EscortQuest() {}

    public String generateQuest() {
        reward = round((random.nextInt(36) + 15)) + " GP";
        String destination = destinations[random.nextInt(destinations.length)];
        return String.format("%s wants the party to escort them to a %s to the %s, and will pay %s.", super.npc.getName(), destination, direction, reward);

    }



}