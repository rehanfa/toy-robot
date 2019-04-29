package com.toy.robot.test;
import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.RobotDirectionEnum;
import com.toy.robot.simulator.RobotPosition;
import com.toy.robot.simulator.impl.RobotPositionImpl;
import com.toy.robot.simulator.impl.RobotImpl;
import org.junit.Assert;
import org.junit.Test;

public class RobotTest {


    @Test
    public void testMovement_1() throws InvalidActionException {
    	RobotPosition position = new RobotPositionImpl(0, 0, RobotDirectionEnum.NORTH);

        RobotImpl robot = new RobotImpl(position);

        Assert.assertTrue(robot.moveRobot());
        Assert.assertEquals(0, robot.getCurrentRobotPosition().getXValue());
        Assert.assertEquals(1, robot.getCurrentRobotPosition().getYValue());
        Assert.assertEquals(RobotDirectionEnum.NORTH, robot.getCurrentRobotPosition().getRobotDirection());
        
    }
    
    @Test
    public void testMovement_2() throws InvalidActionException {

        RobotPosition position = new RobotPositionImpl(0, 0, RobotDirectionEnum.NORTH);
        RobotImpl robot = new RobotImpl(position);
        position = new RobotPositionImpl(0, 0, RobotDirectionEnum.NORTH);
        robot.rotateRobotRight();
        Assert.assertEquals(RobotDirectionEnum.EAST, robot.getCurrentRobotPosition().getRobotDirection());
        robot.rotateRobotRight();
        Assert.assertEquals(RobotDirectionEnum.SOUTH, robot.getCurrentRobotPosition().getRobotDirection());
        robot.rotateRobotRight();
        Assert.assertEquals(RobotDirectionEnum.WEST, robot.getCurrentRobotPosition().getRobotDirection());
        robot.rotateRobotRight();
        Assert.assertEquals(RobotDirectionEnum.NORTH, robot.getCurrentRobotPosition().getRobotDirection());
        robot.rotateRobotRight();
        Assert.assertEquals(RobotDirectionEnum.EAST, robot.getCurrentRobotPosition().getRobotDirection());
        
    }
    
    @Test
    public void testMovement_3() throws InvalidActionException {
    

        RobotPosition position = new RobotPositionImpl(1, 2, RobotDirectionEnum.EAST);
        RobotImpl robot = new RobotImpl(position);
        robot.moveRobot();
        robot.moveRobot();
        robot.rotateRobotLeft();
        robot.moveRobot();
        Assert.assertEquals(3, robot.getCurrentRobotPosition().getXValue());
        Assert.assertEquals(3, robot.getCurrentRobotPosition().getYValue());
        Assert.assertEquals(RobotDirectionEnum.NORTH, robot.getCurrentRobotPosition().getRobotDirection());

        
    }

}