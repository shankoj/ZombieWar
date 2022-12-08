
package zombiWar;
import java.util.Random;
/**
 *
 * @author jimmashanko
 */
public class ZombieWar {
    private static final int MAX = 10;
    private static final Random random = new Random();

    // Instanciate variables
    private Character[] survivors;
    private Character[] zombies;
    private int childNumb;
    private int teacherNumb;
    private int soldierNumb;
    private int commonInfectedNumb;
    private int tankNumb;

 
    public ZombieWar() {
        // the following random method is used to get the random number of 
        // of childnubm, teacherNumb, soldierNumb, commonInfectedNubm and tankNumb
        childNumb = random.nextInt(MAX);

        teacherNumb = random.nextInt(MAX);
        
        soldierNumb = random.nextInt(MAX);

        commonInfectedNumb = random.nextInt(MAX);

        tankNumb = random.nextInt(MAX);

        //the method below create an array of childNumb,teacherNumb,and soldierNumb of Survivor
        getSurvivor();

        // the method below create an array of commonInfectedNumb and tankNumb of Zombie
        getZombie();

        // the method below print number of survivors and zombies
        print();
    }
    /**
    * This method creates a Survivor array consisting of childNum number of
    * Child, teacherNum number of Teacher and soldierNum number of Soldier
    */
    private void getSurvivor() {
        survivors = new Survivor[childNumb + teacherNumb + soldierNumb];
        int i = 0;

        // Add Child objects
        for (i = 0; i < childNumb; i++)
            survivors[i] = new Child();

            // Add Teacher objects
        for (; i < childNumb + teacherNumb; i++)
            survivors[i] = new Teacher();

            // Add Soldier objects
        for (; i < childNumb + teacherNumb + soldierNumb; i++)
            survivors[i] = new Soldier();
    }

    /**
    * This method creates a Zombie array consisting of cInfectedNum number of
    * CommonInfected and tankNum number of Tank
    */
    private void getZombie() {
        zombies = new Zombie[commonInfectedNumb + tankNumb];
        int i = 0;

        // Add CommonInfected objects
        for (i = 0; i < commonInfectedNumb; i++)
            zombies[i] = new CommonInfected();

            // Add Tank objects
        for (; i < commonInfectedNumb + tankNumb; i++)
            zombies[i] = new Tank();
    }

    /**
    * This method prints the initial number of survivors and zombies
    */
    private void print() {
        // Printing the number of survivors and zombies
        System.out.println("We have " + survivors.length + " survivors trying to make it to safety (" + childNumb
        + " children, " + teacherNumb + " teachers, " + soldierNumb + " soldiers)");
        System.out.println("But there are " + zombies.length + " zombies waiting for them (" + commonInfectedNumb
        + " common infected, " + tankNumb + " tanks)");
    }

    private int getCharacterIndex(Character c, int index) {
        if (c instanceof CommonInfected)
            return (index % commonInfectedNumb);
        else if (c instanceof Tank)
            return (index % tankNumb);
        else if (c instanceof Child)
            return (index % childNumb);
        else if (c instanceof Teacher)
            return (index % teacherNumb);
        else if (c instanceof Soldier)
            return (index % soldierNumb);
        else
            return -1;
        }

   
        private static int safeCount(Character[] characters) {
            int safe = 0;
            for (Character c : characters) {
            // Check if c is not dead
                if (!c.isDead())
                    safe += 1;
            }

            // the following eturn number of characters that are not dead
            return safe;
        }
}
