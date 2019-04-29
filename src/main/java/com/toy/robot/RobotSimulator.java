package com.toy.robot;

import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.*;
import com.toy.robot.simulator.impl.RobotPositionImpl;

public class RobotSimulator {

	TableTop tableTop;
	Robot robot;

	public RobotSimulator(TableTop tableTopParam, Robot robotParam) {
		this.tableTop = tableTopParam;
		this.robot = robotParam;
	}

	/**
	 * executes a command.
	 *
	 * @param inputStringParam command
	 * @return output of the command
	 * @throws InvalidActionException if invalid command
	 *
	 */
	public String execute(String inputStringParam) throws InvalidActionException {
		String retVal = null;
		String[] commArgs = inputStringParam.split(" ");
		int x = 0;
		int y = 0;
		RobotDirectionEnum commDirection = null;
		CommandEnum commEnum;
		RobotPosition positionResult = validateInput(inputStringParam);
		if(positionResult != null) {
			x = positionResult.getXValue();
			y = positionResult.getYValue();
			commDirection = positionResult.getRobotDirection();
			try {
				commEnum = CommandEnum.valueOf(commArgs[0]);
			} catch (IllegalArgumentException e) {
				throw new InvalidActionException("Command is not valid");
			}
			boolean flag= false;
			switch (commEnum) {
			case RIGHT:
				flag = robot.rotateRobotRight();
				break;
			case LEFT:
				flag = robot.rotateRobotLeft();
				break;
			case PLACE:
				RobotPosition placedPosition = new RobotPositionImpl(x, y, commDirection);
				flag = place(placedPosition);
				break;
			
			case MOVE:
				RobotPosition movedPosition = robot.getCurrentRobotPosition().getRobotNextPosition();
				if (!tableTop.isValidTablePosition(movedPosition))
					flag = false;
				else
					flag = robot.moveRobot(movedPosition);
				break;
			case REPORT:
				retVal = report();
				break;
			default:
				throw new InvalidActionException("Command is not valid");
			}
			
			if (retVal == null) {
				retVal = String.valueOf(flag);
			}
		}

		return retVal;
	}
	
	/**
	 * place robot on the table
	 * @param positionParam Robot position
	 * @return false for invalid position, otherwise true
	 * @throws InvalidActionException
	 */
	public boolean place(RobotPosition positionParam) throws InvalidActionException {

		if (tableTop == null)
			throw new InvalidActionException("tableTop is invalid");

		if (positionParam == null)
			throw new InvalidActionException("position is invalid");

		if (positionParam.getRobotDirection() == null)
			throw new InvalidActionException("direction is invalid");

		if (!tableTop.isValidTablePosition(positionParam))
			return false;

		robot.setRobotPosition(positionParam);
		return true;
	}

	/**
	 * Returns String value for position of robot
	 */
	public String report() {
		String retVal = null;
		if (robot.getCurrentRobotPosition() != null) {
			retVal = buildReport();
		}
		return retVal;
	}

	private String buildReport() {
		String retVal = null;
		retVal = robot.getCurrentRobotPosition().getXValue() + "," + robot.getCurrentRobotPosition().getYValue() + ","
				+ robot.getCurrentRobotPosition().getRobotDirection().toString();
		return retVal;
	}
	
	private RobotPosition validateInput(String inputStringParam) throws InvalidActionException{
		RobotPosition retVal = null;
		RobotDirectionEnum commDirection = null;
		String[] parameters;
		String[] arguments = inputStringParam.split(" ");
		CommandEnum commEnum = null;
		int xValue = 0;
		int yValue = 0;
		
		try {
			commEnum = CommandEnum.valueOf(arguments[0]);
		} catch (IllegalArgumentException e) {
			throw new InvalidActionException("Command is not valid");
		}
		if (arguments != null && arguments.length < 2
				&& CommandEnum.PLACE.equals(commEnum)) {
			throw new InvalidActionException("Command is not valid");
		}
		
		if (CommandEnum.PLACE.equals(commEnum)) {
			parameters = arguments[1].split(",");
			try {
				xValue = getIntValue(parameters[0]);
				yValue = getIntValue(parameters[1]);
				commDirection = RobotDirectionEnum.valueOf(parameters[2]);
			} catch (Exception e) {
				throw new InvalidActionException("Command not valid");
			}
		}
		retVal = new RobotPositionImpl(xValue, yValue, commDirection);
		return retVal;
	}
	
	private int getIntValue(String strParam) {
		return Integer.parseInt(strParam);
	}
}
