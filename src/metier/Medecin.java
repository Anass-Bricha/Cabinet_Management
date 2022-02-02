package metier;

import java.io.Serializable;
import java.util.List;

public class Medecin implements Serializable {
    private int idM;
    private String nomM;
    private String prenomM;
    private List<Consultation> M_consultations;

    public Medecin() {
    }

    public Medecin(String nomM, String prenomM) {
        this.nomM = nomM;
        this.prenomM = prenomM;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public List<Consultation> getM_consultations() {
        return M_consultations;
    }

    public void setM_consultations(List<Consultation> m_consultations) {
        M_consultations = m_consultations;
    }
}
