/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledani.min;

import java.awt.Point;
import javafx.scene.paint.Color;

/**
 *
 * @author ondre
 */
public class Pole {//jeden ctverec v minovém poly
    private boolean jeMina;
    private boolean jePoKliknuti = false;
    private boolean jePraporek = false;
    private Color barva = Color.WHITE;//DefaultBarva je bílá, po kliknuti s minou červená a bez šedá
    private Point pozice;
    private int pocetMinVOkoli = 0;//Pocitase jen když nemama minu

    public Pole(Point pozice) {
        this.pozice = pozice;
    }
    public Pole(Point pozice, boolean jeMina) {
        this.pozice = pozice;
        this.jeMina = jeMina;
    }
    public Pole(Point pozice, boolean jeMina, boolean jePoKliknuti) {
        this.pozice = pozice;
        this.jeMina = jeMina;
        this.jePoKliknuti = jePoKliknuti;
    }
    public Pole(int x, int y){
        this.pozice = new Point(x,y);
    }
    public Pole(int x, int y, boolean jeMina) {
        this.pozice = new Point(x,y);
        this.jeMina = jeMina;
    }
    public Pole(int x, int y, boolean jeMina, boolean jePoKliknuti) {
        this.pozice = new Point(x,y);
        this.jeMina = jeMina;
        this.jePoKliknuti = this.jePoKliknuti;
    }
    public boolean isJeMina() {
        return jeMina;
    }

    public void setJeMina(boolean jeMina) {
        this.jeMina = jeMina;
    }

    public boolean isJePoKliknuti() {
        return jePoKliknuti;
    }

    public void setJePoKliknuti(boolean jePoKliknuti) {
        this.jePoKliknuti = jePoKliknuti;
    }

    public Color getBarva() {
        return barva;
    }

    public void setBarva(Color barva) {
        this.barva = barva;
    }

    public Point getPozice() {
        return pozice;
    }

    public void setPozice(Point pozice) {
        this.pozice = pozice;
    }
    
    public int getPocetMinVOkoli() {
        return pocetMinVOkoli;
    }

    public void setPocetMinVOkoli(int pocetMinVOkoli) {
        this.pocetMinVOkoli = pocetMinVOkoli;
    }
    public void setPocetMinVOkoli(String str){
        if (str == "++") {
            this.pocetMinVOkoli++;
        }
        else if (str == "--") {
            this.pocetMinVOkoli--;
        }
    }
    public boolean isJePraporek() {
        return jePraporek;
    }

    public void setJePraporek(boolean jePraporek) {
        this.jePraporek = jePraporek;
    }
    
}
