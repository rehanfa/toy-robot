package com.toy.robot.test;
import org.junit.Assert;
import org.junit.Test;

import com.toy.robot.simulator.TableTop;
import com.toy.robot.simulator.impl.RobotPositionImpl;
import com.toy.robot.simulator.impl.TableTopImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableTopTest {

    @Test
    public void testIsValidPosition() throws Exception {
        RobotPositionImpl mockPosition = mock(RobotPositionImpl.class);
        when(mockPosition.getXValue()).thenReturn(7);
        when(mockPosition.getYValue()).thenReturn(8);

        TableTop tableTop = new TableTopImpl(5, 5);
        Assert.assertFalse(tableTop.isValidTablePosition(mockPosition));
        
        when(mockPosition.getXValue()).thenReturn(10);
        when(mockPosition.getYValue()).thenReturn(10);
        Assert.assertFalse(tableTop.isValidTablePosition(mockPosition));
        
        when(mockPosition.getXValue()).thenReturn(-1);
        when(mockPosition.getYValue()).thenReturn(-1);
        Assert.assertFalse(tableTop.isValidTablePosition(mockPosition));

        when(mockPosition.getXValue()).thenReturn(1);
        when(mockPosition.getYValue()).thenReturn(1);
        Assert.assertTrue(tableTop.isValidTablePosition(mockPosition));

       
    }

}
