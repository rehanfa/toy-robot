package com.toy.robot;

import com.toy.robot.exception.InvalidActionException;
import com.toy.robot.simulator.TableTop;
import com.toy.robot.simulator.impl.RobotImpl;
import com.toy.robot.simulator.impl.TableTopImpl;

import java.io.Console;

public class Main {

    public static void main(String[] args) {
    	int maxX = 4, maxY = 4;
    	String heading = "Robot Simulator";
    	String title = "Please enter a command, examples are:";
    	String helpStr = "\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT";
    	StringBuilder stringBuilder= new StringBuilder(heading);
    	stringBuilder.append("\n" + title);
    	stringBuilder.append("\n" + helpStr);
        Console console = System.console();

        if(console != null) {
	        TableTop tableTop = new TableTopImpl(maxX, maxY);
	        RobotImpl robot = new RobotImpl(null);
	        RobotSimulator robotSimulator = new RobotSimulator(tableTop, robot);
	        System.out.println(stringBuilder.toString());
	        boolean flag = true;
	        while (flag) {
	            String inputString = console.readLine(": ");
	            if ("EXIT".equals(inputString)) {
	                flag = false;
	            } else {
	                try {
	                    String outPutStr = robotSimulator.execute(inputString);
	                    System.out.println(outPutStr);
	                } catch (InvalidActionException e) {
	                    System.out.println(e.getMessage());
	                }
	            }
	        }
        } else {
            System.err.println("console is not available");
            System.exit(1);
      
        }
    }
}