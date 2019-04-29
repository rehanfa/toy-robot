package com.toy.robot.simulator;

import com.toy.robot.exception.InvalidActionException;

public interface Robot {
	
	 /**
     * Sets position of Robot
     *
     * @param robotPositionParam Robot position
     */
	boolean setRobotPosition(RobotPosition position);
	
	/**
     * moves robot to 90 degrees right
     * @return true for successful rotation
     */
	boolean rotateRobotRight();
	
	 /**
     * moves robot  to 90 degrees let
     * @return true for successful rotation
     */
	boolean rotateRobotLeft();
	
	/**
     * Next position move
     * @return true for successful move
     * @throws InvalidActionException
     */
	boolean moveRobot() throws InvalidActionException;
	
	/**
     * move robot by one unit
     *
     * @return true for successful move
     */
	boolean moveRobot(RobotPosition newPosition);
	
	/**
     * Returns the current Position of Robot
     *
     * @return Position
     */
	RobotPosition getCurrentRobotPosition();
	
	
	
	

}
