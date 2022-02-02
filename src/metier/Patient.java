package metier;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Patient implements Serializable {
    private int idP;
    private String nomP;
    private String prenomP;
    private Date date_naissance;
    private List<Consultation> P_consultations;

    public Patient() {
    }

    public Patient(String nomP, String prenomP , Date date_naissance) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.date_naissance = date_naissance;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public List<Consultation> getP_consultations() {
        return P_consultations;
    }

    public void setP_consultations(List<Consultation> p_consultations) {
        P_consultations = p_consultations;
    }
}
