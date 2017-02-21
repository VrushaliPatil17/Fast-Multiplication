
package pkgfloat;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
public class Float {
    public static void main(String[] args) throws IOException
    {
        double power = 1;
        double power1=1;
        int N = 0;
        
        String file = args[1];
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);        
        String line = b.readLine();       
        double x = Double.valueOf(line);
            System.out.println(" X = "+x);
            if ((x < 1.00001) || (x > 1.1)) 
             {
                throw new IllegalArgumentException(" Value is Out Range ");
             } 
             else 
             {
                while (power < Double.MAX_VALUE) 
                  {
                    power = x * power;
                    N++;
                    if(power<Double.POSITIVE_INFINITY)
                    {
                        power1=power;
                    }
                    else
                    {
                        break;
                    }     
                  }
                System.out.println("Largest value of N :" + (N-1));
                System.out.format("\t Power x^N : %-20e \n\n",power1);
             }
        while((line = b.readLine())!= null)
        {
            int N1 = Integer.valueOf(line);
            if(N1 > N)
            {
                System.out.println("\t"+N1+" <- This value of N causes Overflow for x^N \n");
            }
            else
            {
              System.out.print(" From file N : "+N1+" = ");
              Factor(N1);  
            }
        }  
       
    }
        
    public static void Factor(int i)
    {
        TreeMap<Integer, Integer> factors = new TreeMap<Integer, Integer>();
        for(int j=2; j<= i/j && j<=7; j++)
        {
            int count = 0;
            while(i%j == 0)
            {
                i /= j;  
                count++;
            }
            if(count > 0)
                factors.put(j,count);
        }
        if(i>1)
            factors.put(i, 1);
        for(Integer factor : factors.keySet())
        {
            System.out.print(factor+"^"+factors.get(factor)+"*");
        }
        System.out.print("1\n");
    } 
}