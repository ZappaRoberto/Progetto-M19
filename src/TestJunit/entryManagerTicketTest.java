package TestJunit;
import main.Manager.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class entryManagerTicketTest {

    Manager m = new Manager();
    EntryManager em = new EntryManager(m);
   splitString split = new splitString();

    @Test
    // test targa non valida
    public void entryTicketTest(){
        m.makeFloors(1,200);
        m.setSpacesSubdivision(100);
        assertEquals("entryNo--Targa non valida.",em.entryTicket("000000000"));
    }

    @Test
    //targa valida
    public void invalidCarID(){
        String s="", st;
        m.makeFloors(1,200);
        m.setSpacesSubdivision(100);
        // sono costretto a far lo split della stringa che mi conferma l'ingresso perchè i millisecondi della data non
        // davano la possibilita di convalidare il tes
        s = split.split(em.entryTicket("00000000"));
        assertEquals("entryOk", s);
    }
    @Test
    //posti finiti
    public void finishedticketSpace(){
        m.makeFloors(1,1);
        m.setSpacesSubdivision(0);
        //creo un ingresso valido
        em.entryTicket("00000000");
        //secondo ingresso che genera errore
        assertEquals("entryNo--Posti ticket finiti.", em.entryTicket("11111111"));
    }

    @Test
    //targa in ingresso uguale
    public void sameCarID(){
        m.makeFloors(1,200);
        m.setSpacesSubdivision(100);
        //creo un ingresso valido
        em.entryTicket("00000000");
        //secondo ingresso con stessa targa
        assertEquals("entryNo--Ingresso fallito: targa: 00000000 già presente all'interno del parcheggio.",
                em.entryTicket("00000000"));
    }



}
