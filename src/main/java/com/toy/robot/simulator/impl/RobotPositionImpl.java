package com.toy.robot.simulator.impl;

import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.RobotDirectionEnum;
import com.toy.robot.simulator.RobotPosition;

public class RobotPositionImpl implements RobotPosition {
    int xValue;
    int yValue;
    RobotDirectionEnum robotDirection;

    public RobotPositionImpl(RobotPosition position) {
        this.xValue = position.getXValue();
        this.yValue = position.getYValue();
        this.robotDirection = position.getRobotDirection();
    }

    public RobotPositionImpl(int xParam, int yParam, RobotDirectionEnum robotDirection) {
        this.xValue = xParam;
        this.yValue = yParam;
        this.robotDirection = robotDirection;
    }
    
    /**
     * Returns X value of Robot's current position
     *
     * @return integer
     */
    public int getXValue() {
        return this.xValue;
    }

    /**
     * Returns Y value of Robot's current position
     *
     * @return integer
     */
    public int getYValue() {
        return this.yValue;
    }

    /**
     * Returns current Direction of Robot
     *
     * @return Direction
     */
    public RobotDirectionEnum getRobotDirection() {
        return this.robotDirection;
    }

    /**
     * Set current Direction of Robot
     * @param RobotDirectionEnum
     */
    public void setRobotDirection(RobotDirectionEnum direction) {
        this.robotDirection = direction;
    }

    /**
     * Sets X,Y for Robot 
     * @param x
     * @param y
     */
    public void changeRobotCoordinates(int x, int y) {
        this.xValue = this.xValue + x;
        this.yValue = this.yValue + y;
    }

    /**
     * Returns next Position of Robot
     *
     * @return Position
     * @throws InvalidActionException
     */
    public RobotPosition getRobotNextPosition() throws InvalidActionException {
        if (this.robotDirection == null)
            throw new InvalidActionException("Invalid robot direction");

        RobotPosition newPosition = new RobotPositionImpl(this);
        switch (this.robotDirection) {
            case NORTH:
                newPosition.changeRobotCoordinates(0, 1);
                break;
            case EAST:
                newPosition.changeRobotCoordinates(1, 0);
                break;
            case SOUTH:
                newPosition.changeRobotCoordinates(0, -1);
                break;
            case WEST:
                newPosition.changeRobotCoordinates(-1, 0);
                break;
        }
        return newPosition;
    }
}
