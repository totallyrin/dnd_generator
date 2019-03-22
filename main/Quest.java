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
            case "fetchQuest": return new FetchQuest().generateQuest(); break;
            case "killQuest": return new KillQuest().generateQuest(); break;
            case "targetQuest": return new TargetQuest().generateQuest(); break;
            case "deliverQuest": return new DeliverQuest().generateQuest(); break;
            case "escortQuest": return new EscortQuest().generateQuest(); break;
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

}

class FetchQuest extends Quest {

    String[] objects = {"sword", "book", "scroll", "chest", "set of armour", "helmet", "shield", "axe", "hammer", "banner", "crown"};
    String[] adjectives = {"ancient", "cursed", "magical", "personal", "expensive", "shoddy", "giant", "legendary", "enchanted", "forbidden"};
    String[] locations = {"cave", "mine", "forest", "museum", "library", "mansion", "castle", "fort", "town", "village", "city", "mountain"};
    String[] adj2 = {"creepy", "haunted", "famous", "infamous", "huge", "hidden", "secret", "magical", "cursed", "legendary", "abandoned"};

    FetchQuest() {}

    public String generateQuest() {
        reward = (random.nextInt(71) + 30) + "g";
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
        reward = random.nextInt((131) + 20) + "g";
        if (enemy.equals("dragon") || enemy.equals("beholder")) {
            num = "a";
            reward = (random.nextInt(751) + 250) + "g";
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
        int rwrd = random.nextInt(151) + 50;
        reward = rwrd + "g";
        return String.format("%s wants the party to kill someone named %s who is in %s, and will pay %s.", super.npc.getName(), target.getName(), locations[num], reward);
    }

}

class DeliverQuest extends Quest {

}

class EscortQuest extends Quest {

}