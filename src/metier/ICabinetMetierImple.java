package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ICabinetMetierImple implements ICabinetMetier{
    private Connection con;

    public ICabinetMetierImple(){
        con = ConnectionDB.getConnection();
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patientList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                Patient p = new Patient();
                p.setIdP(rs.getInt("id_patient"));
                p.setNomP(rs.getString("nom_patient"));
                p.setPrenomP(rs.getString("prenom_patient"));
                p.setDate_naissance(rs.getDate("date_naissance"));

                patientList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientList;
    }

    @Override
    public List<Patient> getPatientByMc(String mc) {
        List<Patient> patientList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE nom_patient LIKE ?");
            ps.setString(1,"%"+mc+"%");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                Patient p = new Patient();
                p.setNomP(rs.getString("nom_patient"));
                p.setPrenomP(rs.getString("prenom_patient"));
                p.setDate_naissance(rs.getDate("date_naissance"));
                patientList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientList;
    }

    @Override
    public void ajouterPatient(Patient p) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO patients (nom_patient,prenom_patient,date_naissance) VALUES (?,?,?)");
            ps.setString(1,p.getNomP());
            ps.setString(2,p.getPrenomP());
            ps.setDate(3,p.getDate_naissance());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerPatient(Patient p) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM patients WHERE nom_patient = ?");
            ps.setString(1,p.getNomP());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> getAllPatientConsultation(Patient p) {

        List<Consultation> consultationList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT id_consultation,date_consultation FROM consultations WHERE consultations.id_patient = ?");
            ps.setInt(1,p.getIdP());
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                Consultation c = new Consultation();
                c.setIdC(rs.getInt("id_consultation"));
                c.setDate_consultation(rs.getDate("date_consultation"));

                consultationList.add(c);
            }
            p.setP_consultations(consultationList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p.getP_consultations();
    }

    @Override
    public void ajouterMededcin(Medecin m) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO medecins (nom_medecin,prenom_medecin) VALUES (?,?)");
            ps.setString(1,m.getNomM());
            ps.setString(2,m.getPrenomM());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medecin> getAllMedecin() {
        List<Medecin> medecinList = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM medecins");
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();

            while(rs.next()){
                Medecin m = new Medecin();
                m.setNomM(rs.getString(""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void supprimerMedecin(Medecin m) {

    }

    @Override
    public List<Consultation> getAllMedecinConsultation(Medecin m) {
        return null;
    }

    @Override
    public void ajouterConsultation(Consultation c) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO consultations (id_consultation,date_consultation,id_patient,id_medecin) VALUES (?,?,?,?)");
            ps.setInt(1,c.getIdC());
            ps.setDate(2,c.getDate_consultation());
            ps.setInt(3,c.getIdP_con());
            ps.setInt(4,c.getIdM_con());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Consultation> getALllConsultations() {
        return null;
    }

    @Override
    public void supprimerConsultation(Consultation c) {

    }
}
