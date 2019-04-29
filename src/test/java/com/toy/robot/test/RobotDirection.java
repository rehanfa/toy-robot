package com.toy.robot.test;
import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.simulator.RobotDirectionEnum;


public class RobotDirection {

    @Test
    public void testRotate() throws Exception {
        RobotDirectionEnum robotDirectionEnum = RobotDirectionEnum.SOUTH;

        robotDirectionEnum = robotDirectionEnum.getLeftDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.EAST);

        robotDirectionEnum = robotDirectionEnum.getLeftDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.NORTH);

        robotDirectionEnum = robotDirectionEnum.getRightDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.EAST);

        robotDirectionEnum = robotDirectionEnum.getRightDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.SOUTH);

        robotDirectionEnum = robotDirectionEnum.getRightDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.WEST);

        robotDirectionEnum = robotDirectionEnum.getRightDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.NORTH);

        robotDirectionEnum = robotDirectionEnum.getRightDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.EAST);
        
        robotDirectionEnum = robotDirectionEnum.getLeftDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.NORTH);

        robotDirectionEnum = robotDirectionEnum.getLeftDirection();
        Assert.assertEquals(robotDirectionEnum, RobotDirectionEnum.WEST);
    }
}
