package alklid.algorithm.study.dynamicprogramming;

import alklid.structure.GridPoint;

import java.util.ArrayList;

/**
 * 그리드안에 좌측상단에 로보트를 이동하여 목적지까지 가는 이동 경로 구하기.
 * 로보트는 오른쪽과 아래 두 방향으로만 움직일 수 있음.
 * 그리드 내에는 off limit 라는 이동할 수 없는 칸들이 있음.
 *
 * Solution
 * 목적지에서부터 로보트까지의 경로를 구하는 재귀함수를 구현하고
 * 로보트에서부터 재귀함수를 돌아하면서 경로를 반환.
 * 목적지에서부터 로보트까지는 반대로 왼쪽과 위쪽 두 방향으로만 움질일 수 있음.
 * 항상 한쪽 방향을 먼저 시도하고 이동하지 못하면 다른 쪽 방향을 시도.
 *
 * [R][ ][ ][ ]
 * [*][*][*][X]
 * [X][X][*][ ]
 * [ ][ ][*][G]
 * 00 -> 10 -> 11 -> 12 -> 22 -> 32 -> 33
 */
public class RobotInGrid {
    private ArrayList<GridPoint> findPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) return null;

        // 이동 경로를 보관할 리스트
        ArrayList<GridPoint> path = new ArrayList<>();

        // 목적지에서부터 시작하는 재귀함수 호출
        if (findPath(grid, grid.length-1, grid[0].length-1, path)) {
            return path;
        }
        else {
            return null;
        }
    }

    /**
     * @param grid : Grid 정보
     * @param row : 현재 위치
     * @param col : 현재 위치
     * @param path : 재귀함수에서 돌아오면서 저장할 이동 경로
     * @return : true(이동한 경로에서 로보트를 만남) / false(로보트를 만나지 못함)
     */
    private boolean findPath(boolean[][] grid, int row, int col, ArrayList<GridPoint> path) {
        // grid 를 벗어났거나, 이동하지 못하는 칸(true)일 경우 false 반환
        if (!isInRange(grid, row, col) || grid[row][col]) return false;

        // 왼쪽(col-1)으로 이동과 위쪽(row-1)으로 이동을 OR 연산자를 통해, 먼저 한쪽만 계속 이동해보도록 함.
        if ( (row == 0 && col == 0) // 로보토의 위치에 도달
                || findPath(grid, row, col-1, path) // 왼쪽으로 이동
                || findPath(grid, row-1, col, path) // 위쪽으로 이동
        ) {
            GridPoint p = new GridPoint(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    // grid 내에 정의된 위치인지 확인
    private boolean isInRange(boolean[][] grid, int row, int col) {
        return row >= 0 && row <= grid.length -1
                && col >= 0 && col <= grid[row].length - 1;
    }


    public static void main(String[] args) {
        // Grid 정보 : true(이동할 수 없는 칸), false(이동 가능한 칸)
        boolean[][] grid = {
            {false, false, false, false},
            {false, false, false, true},
            {true, true, false, false},
            {false, false, false, false}
        };

        RobotInGrid robot = new RobotInGrid();
        ArrayList<GridPoint> path = robot.findPath(grid);
        if (path != null) {
            for(GridPoint p : path) {
                System.out.print(p.getRow() + "" + p.getCol() + " ");
            }
        }
    }
}
