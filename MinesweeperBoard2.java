/**
 * Write a description of class Minesweeper2 here.
 *
 * @author Oliver Tanjoco   
 * @version 1/9/18
 */

import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class MinesweeperBoard2{
    Cell[][] board;
    int rows;
    int columns;
    public MinesweeperBoard2(int row, int column){
        //Put the constructor here.
        this.rows = row;
        this.columns = column;
        board = new Cell[rows][columns];
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
    
    public void addBombs(int bombs){ //throws Exception{
        for (int i = 0; i < bombs ; i++){
            int x = (int)(Math.random() * (rows));
            int y = (int)(Math.random() * (columns));
            while (board[x][y].isBomb() == true){
                x = (int)(Math.random() * (rows));
                y = (int)(Math.random() * (columns)); 
            }
            board[x][y].setBomb(); 
        }
    }
    
    public void addNums(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(board[i][j].isBomb()){
                    if(i-1 >= 0 && !board[i-1][j].isBomb()){
                      board[i-1][j].addNum();  
                    }
                }
            }
        }            
    }

    

    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
    */
    public void printBoard(){
        for (int i = 0; i < (rows); i++){
            for(int j = 0; j < (columns); j++){             
                if(board[i][j].getValue() == -1){
                    System.out.print("X ");
                }else{
                    System.out.print(board[i][j].getValue() + " ");            
                }
            }
            System.out.println();
            
        }
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
            for(int j = 0; j< rows*columns; j++){
                board[i][j] = new Cell();
                panel.add(board[i][j].getButton());
            }
        }
        return panel;
    }
}
 

