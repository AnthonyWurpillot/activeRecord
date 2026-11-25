import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {

    public static void main(String[] args) {

        try {
            // test 1 vérifier singleton

            DBConnection.setNomDB("testpersonne");
            Connection connect1 = DBConnection.getConnection();
            Connection connect2 = DBConnection.getConnection();

            System.out.println("Test 1 : SINGLETON");

            if (connect1 == connect2) {
                System.out.println("Ok les 2 connection on le même objet");
            } else {
                System.out.println("Erreur pas le même objet !!!!");
            }

            System.out.println("Type : " + connect1.getClass().getName());

            // TEST 2 CHANGER BASE DE DONNER

            System.out.println("\nTEST 2 : Changement de base");

            DBConnection.setNomDB("application");
            Connection connect3 = DBConnection.getConnection();

            if ("application".equals(connect3.getCatalog())) {
                System.out.println("OK La base à bien été changéé");
            } else {
                System.out.println("Erreur base inchangé !!!!");
            }

            if (connect3 != connect1) {
                System.out.println("La connection à bien changé !");
            } else {
                System.out.println("Erreur la connection n'a pas changé");
            }
            connect3.close();
        } catch (SQLException e){
            System.out.println("Erreur SQL");
            e.printStackTrace();
        }
    }
}