package com.toy.robot.simulator.impl;

import com.toy.robot.simulator.RobotPosition;
import com.toy.robot.simulator.TableTop;

public class TableTopImpl implements TableTop {

    int tableRows;
    int tableColumns;

    public TableTopImpl(int rows, int columns) {
        this.tableRows = rows;
        this.tableColumns = columns;
    }
    
    /**
     * Validates position of robot on table
     *
     * @param position Robot position
     * @return true if placed successfully, otherwise false
     */
    public boolean isValidTablePosition(RobotPosition position) {
        return (position.getXValue() >= 0 && position.getXValue() <= this.tableColumns
                &&  position.getYValue() >=0 &&  position.getYValue() <= this.tableRows);
    }
}
