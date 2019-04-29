package com.toy.robot.simulator;

import java.util.HashMap;
import java.util.Map;

public enum RobotDirectionEnum {

	NORTH(0), EAST(1), SOUTH(2), WEST(3);
	private static Map<Integer, RobotDirectionEnum> map = new HashMap<Integer, RobotDirectionEnum>();

	static {
		for (RobotDirectionEnum directionEnum : RobotDirectionEnum.values()) {
			map.put(directionEnum.directionIndex, directionEnum);
		}
	}

	private int directionIndex;

	private RobotDirectionEnum(int index) {
		this.directionIndex = index;
	}

	/**
	 * Returns Direction
	 * 
	 * @param directionNum
	 * @return Direction
	 */
	public static RobotDirectionEnum valueOf(int index) {
		return map.get(index);
	}

	/**
	 * Returns Left Direction of Robot
	 *
	 * @return Direction
	 */
	public RobotDirectionEnum getLeftDirection() {
		return rotate(-1);
	}

	/**
	 * Returns Right Direction of Robot
	 *
	 * @return Direction
	 */
	public RobotDirectionEnum getRightDirection() {
		return rotate(1);
	}

	/**
	 * Rotates Robot
	 *
	 * @return Direction
	 */
	private RobotDirectionEnum rotate(int step) {

		int newIndex = (this.directionIndex + step) < 0 ? map.size() - 1 : (this.directionIndex + step) % map.size();

		return RobotDirectionEnum.valueOf(newIndex);
	}

}
