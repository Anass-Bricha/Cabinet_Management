package metier;

import java.io.Serializable;
import java.sql.Date;

public class Consultation implements Serializable {
    private int idC;
    private Date date_consultation;
    private int idP_con;
    private int idM_con;

    public Consultation() {
    }


    public Consultation(Date date_consultation, int idP_con, int idM_con) {
        this.date_consultation = date_consultation;
        this.idP_con = idP_con;
        this.idM_con = idM_con;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }

    public int getIdP_con() {
        return idP_con;
    }

    public void setIdP_con(int idP_con) {
        this.idP_con = idP_con;
    }

    public int getIdM_con() {
        return idM_con;
    }

    public void setIdM_con(int idM_con) {
        this.idM_con = idM_con;
    }
}
