/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hledani.min;

import java.awt.Point;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author ondre
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button btRefresh;
    @FXML
    private AnchorPane paneMenu;
    @FXML
    private AnchorPane paneGameField;
    
    pole[][] poleMin;
    Rectangle[][] rectPole;
    boolean prohra = false;
    boolean vyhra = false;
    int pocetVykliklich;
    @FXML
    private AnchorPane form1;
    @FXML
    private SplitPane paneSplite;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btRefresh.setPrefSize(paneMenu.getHeight()/4*3, paneMenu.getHeight()/4*3);
        
        btRefresh.setTranslateY((paneMenu.getHeight()/2) - (btRefresh.getHeight()/ 2));
        btRefresh.setTranslateX((paneMenu.getWidth()/2) - (btRefresh.getWidth()/ 2));
    }    

    @FXML
    private void btRefreshClick(ActionEvent event) {
        double x = (15*40) + 20;
        double y = x / 90;
        y *= 100;
        form1.getScene().getWindow().setWidth(x);
        form1.getScene().getWindow().setHeight(y + 32);
        System.out.println(form1.getScene().getWindow().getHeight()+ " " + form1.getScene().getWindow().getWidth());
        paneSplite.setDividerPositions(0.1f);
        System.out.println(paneMenu.getHeight() + " " + paneMenu.getWidth()+ "\n" + paneGameField.getHeight() + " " + paneGameField.getWidth());
        btRefresh.setPrefSize(((y-16) /100 * 10)/4*3, ((y-16) /100 * 10)/4*3);
        
        btRefresh.setTranslateY((paneMenu.getHeight()/2) - (btRefresh.getPrefHeight()/ 2));
        btRefresh.setTranslateX((x / 2) - (btRefresh.getPrefWidth()/ 2));
        generuj(10, 12);
    }
    
    public void generuj(int pocetXYdlazdic, int pocetMin){
        poleMin = new pole[pocetXYdlazdic][pocetXYdlazdic];
        rectPole = new Rectangle[pocetXYdlazdic][pocetXYdlazdic];
        Random random = new Random();
        pocetVykliklich = 0;
        prohra = false;
        vyhra = false;
        
        for (int i = 0; i < pocetXYdlazdic; i++) {
            for (int j = 0; j < pocetXYdlazdic; j++) {
                poleMin[i][j] = new pole(new Point(i,j),false);
            }
        }
        
        for (int i = 0; i < pocetMin; i++) {
            int x = random.nextInt(pocetXYdlazdic);
            int y = random.nextInt(pocetXYdlazdic);
            if (!poleMin[x][y].jeMina) {
                    poleMin[x][y].setJeMina(true);
                System.out.println("Mina je na souřadnicích: " + "[" + x + "," + y + "]");

                if (x == 0) {
                    poleMin[x+1][y].pocetMinVOkoli++;
                    if (y==0) {
                        poleMin[x+1][y+1].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                    }
                    else if (y==pocetXYdlazdic-1) {
                        poleMin[x+1][y-1].pocetMinVOkoli++;
                        poleMin[x][y-1].pocetMinVOkoli++;
                    }
                    else{
                        poleMin[x+1][y-1].pocetMinVOkoli++;
                        poleMin[x][y-1].pocetMinVOkoli++;
                        poleMin[x+1][y+1].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                    }
                }
                else if (x == pocetXYdlazdic-1) {
                    poleMin[x-1][y].pocetMinVOkoli++;
                    if (y==0) {
                        poleMin[x-1][y+1].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                    }
                    else if (y==pocetXYdlazdic-1) {
                        poleMin[x-1][y-1].pocetMinVOkoli++;
                        poleMin[x][y-1].pocetMinVOkoli++;
                    }
                    else{
                        poleMin[x-1][y-1].pocetMinVOkoli++;
                        poleMin[x][y-1].pocetMinVOkoli++;
                        poleMin[x-1][y+1].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                    }
                }
                else{
                    if (y==0) {
                        poleMin[x+1][y].pocetMinVOkoli++;
                        poleMin[x-1][y].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                        poleMin[x+1][y+1].pocetMinVOkoli++;
                        poleMin[x-1][y+1].pocetMinVOkoli++;
                    }
                    else if (y==pocetXYdlazdic-1) {
                        poleMin[x+1][y].pocetMinVOkoli++;
                        poleMin[x-1][y].pocetMinVOkoli++;
                        poleMin[x][y-1].pocetMinVOkoli++;
                        poleMin[x+1][y-1].pocetMinVOkoli++;
                        poleMin[x-1][y-1].pocetMinVOkoli++;
                    }
                    else{
                        poleMin[x][y-1].pocetMinVOkoli++;
                        poleMin[x][y+1].pocetMinVOkoli++;
                        poleMin[x+1][y+1].pocetMinVOkoli++;
                        poleMin[x+1][y-1].pocetMinVOkoli++;
                        poleMin[x-1][y-1].pocetMinVOkoli++;
                        poleMin[x-1][y+1].pocetMinVOkoli++;
                        poleMin[x+1][y].pocetMinVOkoli++;
                        poleMin[x-1][y].pocetMinVOkoli++;
                    }
                }
            }
            else{
                i--;
            }
        }
        
        for (int i = 0; i < pocetXYdlazdic; i++) {
            for (int j = 0; j < pocetXYdlazdic; j++) {
                Rectangle rect = new Rectangle((40 * i), (40 * j), 40, 40);
                rect.setFill(poleMin[i][j].getBarva());
                rect.setStroke(Color.BLACK);
                rect.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent e){
                        System.out.println("\nVýber Pole");
                        int x = (int)rect.getX()/40;
                        int y = (int)rect.getY()/40;
                        
                        if (!poleMin[x][y].jePoKliknuti && !prohra && !vyhra) {
                            System.out.println("Souřadnice: " + "[" + x + "," + y + "]");
                            if (e.isPrimaryButtonDown()) {
                                poleMin[x][y].setJePoKliknuti(true);
                                pocetVykliklich++;
                                if (poleMin[x][y].jeMina) {
                                    poleMin[x][y].setBarva(Color.RED);
                                    rect.setFill(poleMin[x][y].getBarva());
                                    System.out.println("Je mina");
                                    prohra = true;
                                    System.out.println("Prohra");

                                }
                                else{
                                    poleMin[x][y].setBarva(Color.GRAY);
                                    rect.setFill(poleMin[x][y].getBarva());
                                    System.out.println("Není mina");
                                    System.out.println("Pocet min v okolí: " + poleMin[x][y].getPocetMinVOkoli());

                                    if (poleMin[x][y].getPocetMinVOkoli() > 0) {
                                        Text text = new Text(String.valueOf(poleMin[x][y].getPocetMinVOkoli()));
                                        text.setX(rect.getX());
                                        text.setY(rect.getY()+40);
                                        text.setFont(new Font(40));
                                        paneGameField.getChildren().add(text);
                                    }
                                    else{
                                        ZjistiANastavOkolni(x, y);
                                    }
                                }
                            }
                            else if (e.isSecondaryButtonDown()) {
                                System.out.println("Secondary");
                            }

                            if (pocetVykliklich + pocetMin == pocetXYdlazdic * pocetXYdlazdic) {
                                vyhra = true;
                                System.out.println("Vyhra");
                            }
                        }
                    }
                });
                rectPole[i][j] = rect;
                paneGameField.getChildren().add(rect);
            }
        }
    }
    public void Uprava(int x, int y){
        Rectangle rect = rectPole[x][y];
        if (!poleMin[x][y].jePoKliknuti && !poleMin[x][y].jeMina) {
            poleMin[x][y].setJePoKliknuti(true);
            pocetVykliklich++;
            if (poleMin[x][y].getPocetMinVOkoli() == 0) {
                poleMin[x][y].setBarva(Color.GRAY);
                rect.setFill(poleMin[x][y].getBarva());
                ZjistiANastavOkolni(x, y);
            }
            else{
                poleMin[x][y].setBarva(Color.GRAY);
                rect.setFill(poleMin[x][y].getBarva());
                Text text = new Text(String.valueOf(poleMin[x][y].getPocetMinVOkoli()));
                text.setX(rect.getX());
                text.setY(rect.getY()+40);
                text.setFont(new Font(40));
                paneGameField.getChildren().add(text);
            }
        }

    }
    public void ZjistiANastavOkolni(int x, int y){
                if (x == 0) {
                    Uprava(x+1, y);
                    if (y==0) {
                        Uprava(x+1, y+1);
                        Uprava(x, y+1);
                    }
                    else if (y == poleMin.length-1) {
                        Uprava(x+1, y-1);
                        Uprava(x, y-1);
                    }
                    else{
                        Uprava(x+1, y-1);
                        Uprava(x, y-1);
                        Uprava(x+1, y+1);
                        Uprava(x, y+1);
                    }
                }
                else if (x == poleMin.length-1) {
                    Uprava(x-1, y);
                    if (y==0) {
                        Uprava(x-1, y+1);
                        Uprava(x, y+1);
                    }
                    else if (y==poleMin.length-1) {
                        Uprava(x-1, y-1);
                        Uprava(x, y-1);
                    }
                    else{
                        Uprava(x-1, y-1);
                        Uprava(x, y-1);
                        Uprava(x-1, y+1);
                        Uprava(x, y+1);
                    }
                }
                else{
                    if (y==0) {
                        Uprava(x+1, y);
                        Uprava(x-1, y);
                        Uprava(x, y+1);
                        Uprava(x+1, y+1);
                        Uprava(x-1, y+1);
                    }
                    else if (y==poleMin.length-1) {
                        Uprava(x+1, y);
                        Uprava(x-1, y);
                        Uprava(x, y-1);
                        Uprava(x+1, y-1);
                        Uprava(x-1, y-1);
                    }
                    else{
                        Uprava(x, y-1);
                        Uprava(x, y+1);
                        Uprava(x+1, y+1);
                        Uprava(x+1, y-1);
                        Uprava(x-1, y-1);
                        Uprava(x-1, y+1);
                        Uprava(x+1, y);
                        Uprava(x-1, y);
                    }
                }
    }
}