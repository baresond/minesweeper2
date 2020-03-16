/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekce;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author micha
 * @param <E>
 */
public abstract class AbstrDoubleList<E> implements DoubleList<Object>{
    public AbstrDoubleList()
    {
    
    }
    public AbstrDoubleList(Prvek<E> prvni)
    {
        this.prvni = prvni;
        pocet++;
    }
    private boolean isNext()
    {
        return aktualni.dalsi != null;
    }
    private boolean isFirst()
    {
        return prvni != null;
    }
    private boolean isLast()
    {
        return posledni != null;
    }
    private static class Prvek<E>
    {
        Prvek dalsi;
        Prvek predchozi;
        E data;
        
        public Prvek(Prvek dalsi, Prvek predchozi, E data)
        {
            this.dalsi = dalsi;
            this.predchozi = predchozi;
            this.data = data;
        }
        
        public Prvek(E data)
        {
            this(null, null, data);
        }
    }
    
    Prvek<E> prvni, posledni, aktualni;
    int velikost = 0, pocet = 0;
    @Override
    public void zrus() {
        prvni = null;
        pocet = 0;
    }

    @Override
    public boolean jePrazdny() {
        return prvni == null;
    }

    @Override
    public int getMohutnost() {
        return pocet;
    }

    @Override
    public void vlozPrvni(Object data) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vlozPosledni(Object data) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vlozNaslednika(Object data) throws NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vlozPredchudce(Object data) throws KolekceException, NullPointerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object zpristupniAktualni() throws NoSuchElementException, KolekceException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
    }

    @Override
    public Object zpristupniPrvni() throws NoSuchElementException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (pocet > 0) {
            aktualni = prvni;
            return aktualni;
        }
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object zpristupniPosledni() throws NoSuchElementException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (pocet > 0 && posledni != null) 
        {
            aktualni = posledni;
            return aktualni;
        }
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object zpristupniNaslednika() throws NoSuchElementException, KolekceException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (pocet > 0) 
        {
            if (aktualni != posledni) 
            {
                aktualni = aktualni.dalsi;
            }
            return aktualni;
        }
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object zpristupniPredchudce() throws NoSuchElementException, KolekceException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (pocet > 0) 
        {
            if (aktualni != prvni) 
            {
                aktualni = aktualni.predchozi;
            }
            return aktualni;
        }
        
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object odeberAktualni() throws KolekceException, NoSuchElementException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (aktualni == prvni) 
        {
            return odeberPrvni();
        }
        else if (aktualni == posledni) 
        {
            return odeberPosledni();
        }
        else if (aktualni != null) 
        {
            E data = aktualni.data;
            aktualni = aktualni.dalsi;
            pocet--;
            return data;
        }
        
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object odeberPrvni() throws KolekceException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (prvni.dalsi != null) {
            aktualni = prvni.dalsi;
        }
        E data = prvni.data;
        pocet--;
        return data;
    }

    @Override
    public Object odeberPosledni() throws KolekceException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (posledni.predchozi != null) {
            aktualni = posledni.predchozi;
        }
        E data = posledni.data;
        pocet--;
        return data;
    }

    @Override
    public Object odeberNaslednika() throws KolekceException, NoSuchElementException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (aktualni.dalsi != null) {
            E data = (E)aktualni.dalsi.data;
            pocet--;
            return data;
        }
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Object odeberPredchudce() throws KolekceException, NoSuchElementException {
        if (jePrazdny()) 
        {
            throw new NoSuchElementException("Prazdny seznam");
        }
        if (aktualni.predchozi != null) {
            E data = (E)aktualni.predchozi.data;
            pocet--;
            return data;
        }
        throw new KolekceException("Aktualni prvek není nastaven!");
    }

    @Override
    public Iterator<Object> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
