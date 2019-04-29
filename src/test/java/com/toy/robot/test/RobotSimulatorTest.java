package com.toy.robot.test;
import com.toy.robot.RobotSimulator;
import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.RobotDirectionEnum;
import com.toy.robot.simulator.TableTop;
import com.toy.robot.simulator.impl.RobotPositionImpl;
import com.toy.robot.simulator.impl.RobotImpl;
import com.toy.robot.simulator.impl.TableTopImpl;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RobotSimulatorTest {

    final int TABLE_ROWS = 5;
    final int TABLE_COLUMNS = 5;
    @Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPlacing() throws InvalidActionException {

        TableTopImpl board = new TableTopImpl(TABLE_COLUMNS, TABLE_ROWS);
        RobotImpl robot = new RobotImpl(null);
        RobotSimulator game = new RobotSimulator(board, robot);

        Assert.assertTrue(game.place(new RobotPositionImpl(0, 1, RobotDirectionEnum.NORTH)));
        Assert.assertTrue(game.place(new RobotPositionImpl(2, 2, RobotDirectionEnum.SOUTH)));
        Assert.assertFalse(game.place(new RobotPositionImpl(6, 6, RobotDirectionEnum.WEST)));
        Assert.assertFalse(game.place(new RobotPositionImpl(-1, 5, RobotDirectionEnum.EAST)));
    }

    @Test
    public void testPlacingExceptions() throws InvalidActionException {

        TableTop tableTop = new TableTopImpl(TABLE_COLUMNS, TABLE_ROWS);
        RobotImpl robot = new RobotImpl(null);
        RobotSimulator game = new RobotSimulator(tableTop, robot);

        thrown.expect(InvalidActionException.class);
        game.place(null);
        thrown.expect(InvalidActionException.class);
        game.place(new RobotPositionImpl(0, 1, null));
    }

    @Test
    public void testExecute() throws InvalidActionException {

        TableTop tableTop = new TableTopImpl(TABLE_COLUMNS, TABLE_ROWS);
        RobotImpl robot = new RobotImpl(null);
        RobotSimulator game = new RobotSimulator(tableTop, robot);

        game.execute("PLACE 0,0,NORTH");
        Assert.assertEquals("0,0,NORTH", game.execute("REPORT"));

        game.execute("MOVE");
        game.execute("RIGHT");
        game.execute("MOVE");
        Assert.assertEquals("1,1,EAST", game.execute("REPORT"));

        // if it goes out of the board it ignores the command
        for (int i = 0; i < 10; i++)
            game.execute("MOVE");
        Assert.assertEquals("5,1,EAST", game.execute("REPORT"));

        //rotate on itself
        for (int i = 0; i < 4; i++)
            game.execute("LEFT");
        Assert.assertEquals("5,1,EAST", game.execute("REPORT"));

        // invalid commands
        thrown.expect(InvalidActionException.class);
        Assert.assertEquals("Invalid command", game.execute("PLACE12NORTH"));
        thrown.expect(InvalidActionException.class);
        Assert.assertEquals("Invalid command", game.execute("LEFFT"));
        thrown.expect(InvalidActionException.class);
        Assert.assertEquals("Invalid command", game.execute("RIGHTT"));
    }
}
