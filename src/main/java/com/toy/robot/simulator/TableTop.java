package com.toy.robot.simulator;


public interface TableTop {

	/**
     * Validates Robot Position
     *
     * @param position Robot position
     * @return true if placed successfully, otherwise false
     */
    public boolean isValidTablePosition(RobotPosition position);

}