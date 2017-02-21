/*
    This is Golden generation test for the given assignment program. 
    My Float.java program gives same results as this file gives.
    I have calculated power function using bruit force and in this program 
      power is calculated using Math library function Math.pow(x, (n-1)).
    Golden Generation test verified.
*/


package pkgfloat;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

public class GoldenGeneration {
    
    public static void main(String[] args) throws IOException {
        
        double power = 1;
        int N = 0;
                
        File file = new File("test10.txt");
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);        
        String line = b.readLine();       
        double x = Double.valueOf(line);
            System.out.println(" X = "+x);
            if ((x < 1.00001) || (x > 1.1)) //checking the range of x
             {
                throw new IllegalArgumentException(" Value is Out Range ");
             } 
             else 
             {
                while (power < Double.MAX_VALUE) //overflow condition
                  {
                    power = x * power;
                    N++;
                  }
                System.out.println("Largest value of N :" + (N-1));
                System.out.format("\t Power x^N : %-20e \n\n",Math.pow(x, (N-1)));
             }
    }
    
}
