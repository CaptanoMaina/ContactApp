package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import daos.IDisplayable;

/**
 *
 * @author Margaret
 */
public class IDisplayableTest implements IDisplayable{
    public static void main(String args[]){
    
        IDisplayableTest t = new IDisplayableTest();
        t.display();
        
    }

    @Override
    public void display() {
       System.out.println("The display function works!");
    }
}
