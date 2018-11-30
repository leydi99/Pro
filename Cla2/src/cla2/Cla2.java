/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cla2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pricila Romero
 */
public class Cla2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         int op;
        int uni;
        run ss=new run();
        Scanner leerr= new Scanner(System.in);
        
        do{
       menu.Menu();//menu de opciones
        op=leerr.nextInt();
        //opciones
        switch(op){
            case 1://caso uno rungr kuta
                   ss.seth();
                   ss.setxi();
                   ss.setxf();
                   ss.sety1();
                   ss.calcular(ss.h, ss.xi, ss.xf, ss.y1);
                  ss.mostrar();
                break;
            case 2://caso 2 newton
                newtonn ecu=new newtonn();
                ecu.Newtooo();
                break;
            case 3:
               //abrir txt con datos de registro
                    ss.abrir("Datos.txt");
                
                 
                
                break;
            } 
        }while(op!=4);
    }
    
    }
    

