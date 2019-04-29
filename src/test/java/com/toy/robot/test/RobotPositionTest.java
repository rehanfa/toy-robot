package com.toy.robot.test;
import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.simulator.RobotDirectionEnum;
import com.toy.robot.simulator.RobotPosition;
import com.toy.robot.simulator.impl.RobotPositionImpl;

public class RobotPositionTest {

    @Test
    public void testGetNextPosition_1() throws Exception {
        RobotPosition position = new RobotPositionImpl(0, 0, RobotDirectionEnum.EAST);

        RobotPosition newPosition = position.getRobotNextPosition();
        Assert.assertEquals(newPosition.getXValue(), 1);
        Assert.assertNotEquals(newPosition.getYValue(), 1);
        Assert.assertEquals(newPosition.getRobotDirection(), RobotDirectionEnum.EAST);

    }
    
    @Test
    public void testGetNextPosition_2() throws Exception{
    	
    	RobotPosition position = new RobotPositionImpl(1, 1, RobotDirectionEnum.EAST);
    	RobotPosition newPosition = position.getRobotNextPosition();
        Assert.assertEquals(newPosition.getXValue(), 2);
        Assert.assertEquals(newPosition.getYValue(), 1);
        Assert.assertEquals(newPosition.getRobotDirection(), RobotDirectionEnum.EAST);
        
    }
    
    @Test
    public void testGetNextPosition_3() throws Exception {
    	RobotPosition position = new RobotPositionImpl(0, 1, RobotDirectionEnum.EAST);
    	
    	RobotPosition newPosition = position.getRobotNextPosition();
        Assert.assertNotEquals(newPosition.getXValue(), 0);
        Assert.assertEquals(newPosition.getYValue(), 1);
        Assert.assertEquals(newPosition.getRobotDirection(), RobotDirectionEnum.EAST);
        
    }
}
