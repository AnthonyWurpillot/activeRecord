import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonne {
    @Test
    public void testFindByIdExistant() throws SQLException {
        Personne p = Personne.findById(2);
        assertNotNull(p);
        assertEquals(2, p.getId());
        assertEquals("Scott", p.getNom());
        assertEquals("Ridley", p.getPrenom());
    }

    @Test
    public void testFindByIdInexistant() throws SQLException {
        Personne p = Personne.findById(999);
        assertNull(p);
    }

    @Test
    public void testFindByNameExistant() throws SQLException {
        ArrayList<Personne> liste = Personne.findByName("Kubrick");
        assertNotNull(liste);
        assertEquals(1, liste.size());
        assertEquals(3, liste.get(0).getId());
        assertEquals("Stanley", liste.get(0).getPrenom());
    }

    @Test
    public void testFindByNameInexistant() throws SQLException {
        ArrayList<Personne> liste = Personne.findByName("Inconnu");
        assertNotNull(liste);
        assertTrue(liste.isEmpty());
    }

}