/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cla2;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pricila Romero
 */
public abstract class metorunge {
    float h;
    float xi;
    float xf;
    float y1;
    ArrayList <Float> Xs = new ArrayList<Float>();
    ArrayList <Float> Ys = new ArrayList<Float>();
    ArrayList <Float> Ks = new ArrayList<Float>();
    //funcion para calcular en metodo de rungakutta de 4 orden
    public  void calcular(float h,float xi,float xf,float y1) throws IOException{
        this.Ys.clear();
        this.Ks.clear();
        this.Xs.clear();
        int It = Math.round(xf/h);
        //creacion de vectores
        float[] y = new float[It+2];
        
        y[0] = y1;
        float[] k = new float[4];
        
        float[] x = new float[It+2];
        x[0]=xi;
        
        int acum,ac;
        float a;float b;float t;
        
        for(acum=0;acum<(It+1);acum++){
        
                Xs.add(x[acum]);
                Ys.add(y[acum]);
                a =x[acum];
                b = y[acum];
                k[0] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a = x[acum]+(float)(0.5)*h;
                b= y[acum]+(float)(0.5)*k[0]*h;
        
                k[1] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                b= y[acum]+(float)(0.5)*k[1]*h;
                k[2] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                a=x[acum]+h;
                b=y[acum]+k[2]*h;
                k[3] = (b*(float)Math.pow(a,2))-(float)1.2*(b);
                t = (float)(k[0]+2*k[1]+2*k[2]+k[3])/6;
                y[acum+1] = y[acum]+(t)*h;
                
           for(int j=0;j<4;j++){
                    Ks.add(k[j]);
  
                     if(j==3){
    
                     }
                 }
           x[acum+1]=x[acum]+h;
           
        }
        //varibales que se utilizan para cambiar los arraylista a strin para ingresar a archivo
        String cs,ps,ls;
        cs=Ys.toString();
        ps=Ks.toString();
        ls=Xs.toString();
        String e="************************";
        String m="Metodo Runge Kuta";
        File fichero=new File("Datos.txt");
        FileWriter fw=new FileWriter(fichero, true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter escribef=new PrintWriter(bw);
        escribef.println(m);
        escribef.println(cs);
        escribef.println(ls);
        escribef.println(ps);
        escribef.println(e);
        escribef.close();
    }
    //metodos abtractos
    public abstract void setxi();
    public abstract void setxf();
    public abstract void seth();
    public abstract void sety1();
    
    public abstract float getxi(float x);
    public abstract float getxf(float x2);
    public abstract float geth(float hr);
    public abstract float gety1(float y);
    
    //funcion para mostrar en pantalla el resultado de runga kutta
    public void mostrar(){
        int ac = 0;
        int kc = 0;
        
        System.out.println("i   |"+"x   |"+"y   |"+"k1  |"+"k2  |"+"k3  |"+"k4  |");
        //posiciones en que los va mostrar
        for(float i : Ys){
            System.out.print((ac+1)+" |");
            System.out.print(Xs.get(ac)+"   |");
            System.out.print(i+"|");
            for(int j=kc;j<kc+4;j++){
                System.out.print(Ks.get(j)+"|");
                if(j==(kc+3)){
                    System.out.println(" ");
                }
            }
            kc +=4;
        }
    }
    //funcion para abrir el archivo txt y mostar en bloc de nota 
    public void abrir(String archivo){
    File objetofile=new File(archivo);
        try {
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex) {
            Logger.getLogger(metorunge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
