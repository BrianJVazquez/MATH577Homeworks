/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math577homeworks;

import java.util.ArrayList;

/**
 *
 * @author Brian
 */
public class MATH577Homeworks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double a,b;
        double h = 0.25;
        a = 0;
        b = 1;

        HomeworkTwo values = new HomeworkTwo(a, b, h, 1, h + 1);
        values.calculate_ODE_Exact();
        values.calculate_ODE_Discrete();
        ArrayList<Double> error_1 = values.calculateError();
        //error_1.get(error_1.size() - 1);
        System.out.println();

        System.out.println("For n = 1 ");
        h = 0.1;
        HomeworkTwo values2 = new HomeworkTwo(a, b, h, 1, h + 1);
        values2.calculate_ODE_Exact();
        values2.calculate_ODE_Discrete();
        ArrayList<Double> error_2 = values2.calculateError();
        //error_2.get(error_2.size() - 1);
        System.out.println();

        h = 0.01;
        System.out.println("For n = 2 ");
        HomeworkTwo values3 = new HomeworkTwo(a, b, h, 1, h + 1);
        values3.calculate_ODE_Exact();
        values3.calculate_ODE_Discrete();
        ArrayList<Double> error_3 = values3.calculateError();
        //error_3.get(error_3.size() -  1);
        System.out.println();

        System.out.println("For n = 3 ");
        h = 0.001;
        HomeworkTwo values4 = new HomeworkTwo(a, b, h, 1, h + 1);
        values4.calculate_ODE_Exact();
        values4.calculate_ODE_Discrete();
        ArrayList<Double> error_4 = values4.calculateError();
        System.out.println("Log(" + error_1.get(error_1.size()-1) + "/" 
                + error_4.get(error_4.size()-1) + ")/ Log(" + error_4.size() + ") = p");
        
        double p = Math.log10(error_1.get(error_1.size() - 1)/error_4.get(error_4.size() - 1))
                /Math.log10(error_4.size());
        
        System.out.println("p = " + p);
    }
}
