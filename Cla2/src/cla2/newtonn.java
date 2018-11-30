/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cla2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Pricila Romero
 */
public class newtonn {
    Scanner tec=new Scanner(System.in);
     public void Newtooo() throws IOException
    { 
        //extnesion las funcion abstrata y definir su ecuacion y su deribada
        Funcioni f= new Funcioni() {
                    @Override
                    //se predofina 
                    public double eval(double x) {
                    return x*x-2;   
                        }
                    };
        //derivada
                Funcioni df= new Funcioni() {
                    @Override
                    public double eval(double x) {
                    return 2*x;
                    }
                };
               //toma de los valores en los set de newton rapshon
                neww lo=new neww();
                
                System.out.println("valor de x incial");
                lo.setD(tec.nextDouble());
                
                System.out.println("numero de ciclo maximo");
                lo.setVal(tec.nextInt());
                //se crea una variable del la clase newtonRap
                Newrap nr = new Newrap();
                //se uestra en pantalla ya el resultado 
                System.out.println(nr.raiz(f, df, lo.getD(), 1e-6, lo.getVal()));
                
                //creacion de archivos poara newton raphson
                File fichero=new File("Datos.txt");
                String espacio="*****************";
                String me="Metodo de Newton";
                FileWriter fw=new FileWriter(fichero, true);
                BufferedWriter bw=new BufferedWriter(fw);
                PrintWriter escribef=new PrintWriter(bw);
                escribef.println(me);
                escribef.println(lo.getD());
                escribef.println(1e-6);
                escribef.println(lo.getVal());
                escribef.println(espacio);
                escribef.close();
    }
}
