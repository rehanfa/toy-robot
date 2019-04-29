package com.toy.robot.simulator.impl;

import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.RobotPosition;
import com.toy.robot.simulator.Robot;

public class RobotImpl implements Robot {

    private RobotPosition robotPosition;

  
    public RobotImpl(RobotPosition robotPositionParam) {
        this.robotPosition = robotPositionParam;
    }
    
    /**
     * Sets position of Robot
     *
     * @param robotPositionParam Robot position
     */

    public boolean setRobotPosition(RobotPosition robotPositionParam) {
        boolean retVal = false;
        if (robotPositionParam != null) {
	        this.robotPosition = robotPositionParam;
	        retVal = true;
        }
        return retVal;
    }
    
    /**
     * moves robot to 90 degrees right
     * @return true for successful rotation
     */
    public boolean rotateRobotRight() {
    	boolean retVal = false;
        if (this.robotPosition.getRobotDirection() != null) {
        	this.robotPosition.setRobotDirection(this.robotPosition.getRobotDirection().getRightDirection());
        	retVal = true;
        }
        return retVal;
    }
    
    /**
     * moves robot  to 90 degrees let
     * @return true for successful rotation
     */
    public boolean rotateRobotLeft() {
    	boolean retVal = false;
        if (this.robotPosition.getRobotDirection() != null) {
        	this.robotPosition.setRobotDirection(this.robotPosition.getRobotDirection().getLeftDirection());
        	retVal = true;
        }
        return retVal;
    }
    
    /**
     * Next position move
     * @return true for successful move
     * @throws InvalidActionException
     */

    public boolean moveRobot() throws InvalidActionException {
        return moveRobot(robotPosition.getRobotNextPosition());
    }

    /**
     * move robot by one unit
     *
     * @return true for successful move
     */
    public boolean moveRobot(RobotPosition newPosition) {
        if (newPosition == null)
            return false;

        this.robotPosition = newPosition;
        return true;
    }
    
    
	/**
	 * Returns the current Position of Robot
	 *
	 * @return Position
	 */
    public RobotPosition getCurrentRobotPosition() {
    	RobotPosition retVal = null;
    	if (this.robotPosition != null) {
    		retVal = this.robotPosition;
    	}
        return retVal;
    }

   
}
