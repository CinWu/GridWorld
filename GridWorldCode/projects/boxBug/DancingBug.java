import info.gridworld.actor.Bug;


public class DancingBug extends Bug
{
    private int[] dance;
    private int index = 0;
    private int turnCtr = 0;

    public DancingBug(int[] degTurn)
    {
	dance = degTurn;
    }

    public void act()
    {
	if ( index < dance.length ) {
	    if ( turnCtr < dance[index] ) {
		turnCtr++;
		turn();
	    }
	    else {
		move();
		turnCtr = 0;
		index++;
	    }
	}
	else 
	    index = 0;
    }
}
