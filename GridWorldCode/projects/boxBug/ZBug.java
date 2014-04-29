import info.gridworld.actor.Bug;


public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private boolean top = false;
    private boolean slant = false;
    private boolean bottom = false;

    public ZBug(int length)
    {
	setDirection(90);
        steps = 0;
        sideLength = length;
    }

    public void act()
    {
	if ( !canMove() || bottom ) { }

        else if (steps < sideLength)
        {
            move();
            steps++;
        }
        else
        {
	    if ( !top ) {
		top = true;
		turn();
		turn();
		turn();
		steps = 0;
	    }
	    else if ( !slant ) {
		slant = true;
		turn();
		turn();
		turn();
		turn();
		turn();
		steps = 0;
	    }
	    else 
		bottom = true;
        }
    }
}
