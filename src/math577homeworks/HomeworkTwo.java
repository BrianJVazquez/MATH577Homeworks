/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package math577homeworks;

import java.util.ArrayList;

public class HomeworkTwo {
	
    double h;
    double a,b;
    //DATA Values
    double initialValue;
    double initialValuePrime;

    ArrayList<Double> valueArrays_Discrete;
    ArrayList<Double> valueArray_exact;

    public HomeworkTwo(double a, double b, double h, double initial, double initialPrime){

        this.a = a;
        this.b = b;
        this.h = h;
        this.initialValue = initial;
        this.initialValuePrime = initialPrime;

        this.valueArray_exact = new ArrayList<>();
        this.valueArrays_Discrete = new ArrayList<>();

        valueArrays_Discrete.add(initialValue);
        valueArrays_Discrete.add(initialValuePrime);
    }

    public ArrayList<Double> calculateError(){
 
        ArrayList<Double> error = new ArrayList<>();
        for(int i = 0; i < valueArrays_Discrete.size(); i++)
            error.add(Math.abs(valueArray_exact.get(i) - valueArrays_Discrete.get(i)));
        
        System.out.println("Error: ");
        System.out.println(error.toString());
        return error;
    }

    public void calculate_ODE_Exact(){
        double interval = this.a;
        while(interval <= (b-a)){
            valueArray_exact.add(u(interval));
            interval = interval + h;
        }
        System.out.println("Continuous size = " + valueArray_exact.size());
        System.out.println(valueArray_exact.toString());
    }

    private double u(double t){
        //Solution to u''(t) + u(t) = t; u(0) = u'(0) = 1
        return Math.cos(t) + t;
    }

    public void calculate_ODE_Discrete(){
        double interval = 2*h;
        int n = 0;
        while(interval <= (b - a)){

            double ode_value = -1 * valueArrays_Discrete.get(n) * Math.pow(h, 2) 
                            - valueArrays_Discrete.get(n) + (n*Math.pow(h, 3)) 
                            + 2 * valueArrays_Discrete.get(n + 1);

            valueArrays_Discrete.add(ode_value);
            n++;
            interval = interval + h;
        }

        System.out.println("Discrete size = " + valueArrays_Discrete.size());
        System.out.println(valueArrays_Discrete.toString());
    }
}

