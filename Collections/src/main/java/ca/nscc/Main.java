package ca.nscc;

import javax.print.attribute.HashAttributeSet;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        ArrayList<String> townsfolk = new ArrayList<>();

        townsfolk.add("Penny");
        townsfolk.add("Gunther");
        townsfolk.add("Willy");
        townsfolk.add("Lewis");
        townsfolk.add("Gus");

        System.out.println(townsfolk);
        townsfolk.addFirst("Linus");
        System.out.println(townsfolk);

        HashSet<String> hSet = new HashSet<>();
        hSet.add("Dog");
        hSet.add("Cat");
        hSet.add("Cow");
        hSet.add("Roger");
        hSet.add("Roger");
        hSet.add("BLAH");
        System.out.println(hSet);

        hSet.add(townsfolk.get(0));
        System.out.println(hSet);

        HashMap<String, Float> animalSpeedMap = new HashMap<>(); // only two key values.
        animalSpeedMap.put("cheetah", 112f);
        animalSpeedMap.put("peetah", 1f);
        animalSpeedMap.put("chicken", 993f);
        animalSpeedMap.put("elk", 400f);

        System.out.println(animalSpeedMap.get("chicken") + 4); // you can add with the returned values.

        // kind of like a dictionary, you can have key value pairs.
        // you can also have hash lists as the secondary key value.
        // ie: animal: dog, attributes (as a hash list): fur: brown, eyes: blue...

        Logger logger = new Logger();
        logger.log(LogLevel.INFO, "Hey");
        logger.log(LogLevel.WARNING, "Joe Biden has escaped the underworld.");

    }
}