/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.solver;

import java.util.List;

/**
 *
 * @author Santa
 */
public class DepthFirst {//will help to find coordinates for reaching ending point from starting point
    public static boolean searchPath(int [][] maze, int x, int y, List <Integer> path){//x,y represents indexes in 2d array, List path contains coordinates
        //base case
        if(maze[y][x] == 9){//if it reaches the destination, add it into list
            path.add(x);
            path.add(y);
            return true;//return true, its the endPoint
        }
        if(maze[y][x] == 0){//preventing to traversing in any blockers or going in any abrupt direction also from visited node
            maze[y][x] = 2;//putting another value to mark it as visited
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x+dx, y+dy, path)){//checking if there's something in upward direction which is accessable(returning true)
                path.add(x);//if dirxn is valid add the value in arraylist
                path.add(y);
                return true;//this value is accessable so return true
            }
            dx = 1;
            dy = 0;
             if(searchPath(maze, x+dx, y+dy, path)){//checking if downward direction is accesable or not
                path.add(x);//if dirxn is valid add the value in arraylist
                path.add(y);
                return true;//this value is accessable so return true
             }
             dx = 0;
             dy = -1;
             if(searchPath(maze, x+dx, y+dy, path)){//checking if left direction is accesable or not
                path.add(x);//if dirxn is valid add the value in arraylist
                path.add(y);
                return true;//this value is accessable so return true
             }
             dy = 1;
             dx = 0;
             if(searchPath(maze, x+dx, y+dy, path)){//checking if right direction is accesable or not
                path.add(x);//if dirxn is valid add the value in arraylist
                path.add(y);
                return true;//this value is accessable so return true
             }
        }
        return false;//if no direction is accesable, or if its a blocker
    }
}
