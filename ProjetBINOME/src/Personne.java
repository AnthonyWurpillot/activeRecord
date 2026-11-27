import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class Personne {

    private int id;
    private String nom;
    private String prenom;

    public Personne (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = -1;
    }


    public Personne findAll(id i){

        System.out.println("***** AFFICHE TOUTES PERSONNES ***** ");
        SQLPrep = "SELECT * FROM Personne;";
        PreparedStatement prep1 = connect.prepareStatement(SQLPrep);
        prep1.execute();
        ResultSet rs = prep1.getResultSet();

    }
}
