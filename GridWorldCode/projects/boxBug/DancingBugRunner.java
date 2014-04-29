import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;


public class DancingBugRunner
{
    public static void main(String[] args)
    {
	int[] testDance = {0,1,5,3,9,10,5};
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(testDance);
        alice.setColor(Color.ORANGE);
        DancingBug bob = new DancingBug(testDance);
        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}
