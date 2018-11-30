/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cla2;

import java.util.Scanner;

/**
 *
 * @author Pricila Romero
 */
public class run extends metorunge {
Scanner le=new Scanner(System.in);
    public void setxi() {
                        System.out.println("Escriba el valor de x1");
                        this.xi=le.nextFloat();
                    }

                    @Override
                    public void setxf() {
                        System.out.println("Escriba el valor de xf");
                        this.xf=le.nextFloat();
                    }

                    @Override
                    public void seth() {
                        System.out.println("Escriba valor de h");
                        this.h=le.nextFloat();
                    }

                    @Override
                    public void sety1() {
                        System.out.println("Escriba el valor de Y1");
                        this.y1=le.nextFloat();
                    }

                    @Override
                    public float getxi(float x) {
                       return this.xi;
                    }

                    @Override
                    public float getxf(float x2) {
                       return this.xf;
                    }

                    @Override
                    public float geth(float hr) {
                      return this.h;
                    }

                    @Override
                    public float gety1(float y) {
                     return this.y1;
                    }
    
}
