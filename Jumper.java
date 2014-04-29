package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * A <code>Jumper</code> is an actor that can move and turn. <br />
 */
public class Jumper extends Actor
{
    /**
     * Constructs a green bug.
     */
    public Jumper()
    {
        setColor(Color.GREEN);
    }

    /**
     * Constructs a bug of a given color.
     * @param bugColor the color for this bug
     */
    public Jumper(Color bugColor)
    {
        setColor(bugColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove())
            move();
        else
            turn();
    }

    /**
     * Turns the bug 90 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }

    /**
     * Moves the bug forward.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation().getAdjacentLocation(getDirection());
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    /**
     * Tests whether this bug can move forward into a location that is empty
     * @return true if this jumper can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation().getAdjacentLocation(getDirection());
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor nextneighbor = gr.get(next);
        return (nextneighbor == null);
        // not ok to move onto any actor
    }
}
