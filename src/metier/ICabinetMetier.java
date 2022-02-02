package metier;

import java.util.List;

public interface ICabinetMetier {

    //all the methods for patient
    List<Patient> getAllPatients();
    List<Patient> getPatientByMc(String mc);
    void ajouterPatient(Patient p);
    void supprimerPatient(Patient p);
    List<Consultation> getAllPatientConsultation(Patient p);

    //methods for medecin
    void ajouterMededcin(Medecin m);
    List<Medecin> getAllMedecin();
    void supprimerMedecin(Medecin m);
    List<Consultation> getAllMedecinConsultation(Medecin m);

    //methods for consultation
    void ajouterConsultation(Consultation c);
    List<Consultation> getALllConsultations();
    void supprimerConsultation(Consultation c);
}
