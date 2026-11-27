import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Personne {

    private int id = -1;
    private String nom;
    private String prenom;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    private Personne(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public static Personne findById(int id) throws SQLException {
        Connection connect = DBConnection.getConnection();
        String sql = "SELECT id, nom, prenom FROM Personne WHERE id = ?;";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Personne(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom")
                    );
                }
            }

        }

        return null;
    }

    public static ArrayList<Personne> findByName(String nom) throws SQLException {
        Connection connect = DBConnection.getConnection();
        ArrayList<Personne> liste = new ArrayList<>();
        String sql = "SELECT id, nom, prenom FROM Personne WHERE nom = ?;";

        try(PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, nom);
            try (ResultSet rs = ps.executeQuery()) {
                while  (rs.next()) {
                    liste.add(new Personne(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("prenom")

                    ));

                }
            }
        }

        return liste;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
