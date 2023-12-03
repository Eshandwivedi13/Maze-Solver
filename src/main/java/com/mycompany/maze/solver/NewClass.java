/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze.solver;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Santa
 */
public class NewClass extends JFrame{//we have to extend Jframe because we need specifically in this project
     private int[][] maze = {// 9 is destination point, 0 is from where we can pass(can make path), 1 is blocked rasta(obstacle)
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,}
    };
     public List<Integer> path = new ArrayList<>();//for storing the coordinates of the path which will lead to destination
    public NewClass(){//New Class is a constructor here, as soon as jframe gets created these lines will execute by default
        setTitle("Maze solver");//title of window
        setSize(500,580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//as soon as i click on exit, it will get exited and operation will be closed
        DepthFirst.searchPath(maze,1,1,path);//for searching more coordinates/path/direction, 
        System.out.println(path);
    }
    @Override
    public void paint(Graphics g){//predefined class, passing Graphics g as an object(Anything related to graphics will be done with this)
        g.translate(50,80);//it will put the origin of graphics from 50,50
        for(int i=0; i<maze.length; i++){//iterating on the maze
            for(int j=0; j<maze[0].length; j++){
                Color color;//creating color object, can change color with this
                switch(maze[i][j]){
                    case 1:
                        color = Color.black;//if maze value is 1, its obstacle(black color)
                        break;
                    case 9:
                        color = Color.red;//if maze value is 9, its destination(color red)
                        break;
                    default:
                        color = Color.white;//if maze value is 0, its a path, can traverse(color white)
                        break;
                }
                g.setColor(color);//now we are setting the color for that particular grid that we encountered
                g.fillRect(30*j,30*i,30,30);//now filling the rectangle
                g.setColor(Color.red);//setting & putting red color boundary to that rectangle
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0; i<path.size(); i+=2){//creating a path from starting to ending point, x+=2(cuz we added both coordinates so incr by 2 for 2nd x coordinate)
            int pathx = path.get(i);//ith is xcordinates
            int pathy = path.get(i+1);// i+1 is yth coordinate
            System.out.println("X Co=ordinates " + pathx);
            System.out.println("Y Co=ordinates " + pathy);
            g.setColor(Color.green);//set the color of the coordinate to green
            g.fillRect(30*pathx,30*pathy,26,26);//and fill the rectangles, decreased the width and size so that we can see through which rectangle it is passing
        }
    }
     public static void main(String[] args) {
        NewClass nc = new NewClass();
        nc.setVisible(true);
    }
}



