package com.toy.robot.simulator;

import com.toy.robot.exception.InvalidActionException;

public interface RobotPosition {
	/**
     * Returns X value of Robot's current position
     *
     * @return integer
     */
	int getXValue();
	
	/**
     * Returns Y value of Robot's current position
     *
     * @return integer
     */
	int getYValue();
	
	/**
     * Returns current Direction of Robot
     *
     * @return Direction
     */
	RobotDirectionEnum getRobotDirection();
	
	/**
     * Set current Direction of Robot
     * @param RobotDirectionEnum
     */
	void setRobotDirection(RobotDirectionEnum direction);
	
	/**
     * Sets X,Y for Robot 
     * @param x
     * @param y
     */
	void changeRobotCoordinates(int x, int y);
	
	/**
     * Returns next Position of Robot
     *
     * @return Position
     * @throws InvalidActionException
     */
	RobotPosition getRobotNextPosition() throws InvalidActionException;

}
