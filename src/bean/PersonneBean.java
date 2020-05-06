package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entity.Personne;
import service.PersonneService;

/**
 *
 * @author hassen-zammeli
 */
@ManagedBean
@SessionScoped
public class PersonneBean implements Serializable {

    private Personne personne;
    private StringBuffer loisir;
    private PersonneService sp;
    private List<Personne> presonnes;
    private String[] los;

    /**
     * Creates a new instance of PersonneBean
     */
    public PersonneBean() {
        personne = new Personne();
        sp = new PersonneService();
        presonnes = new ArrayList<>();
    }

    public PersonneBean(Personne personne, StringBuffer loisir, PersonneService sp) {
        this.personne = personne;
        this.loisir = loisir;
        this.sp = sp;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public StringBuffer getLoisir() {
        return loisir;
    }

    public void setLoisir(StringBuffer loisir) {
        this.loisir = loisir;
    }

    public PersonneService getSp() {
        return sp;
    }

    public void setSp(PersonneService sp) {
        this.sp = sp;
    }

    public String[] getLos() {
        return los;
    }

    public void setLos(String[] los) {
        this.los = los;
    }

    public void setPresonnes(List<Personne> personnes) {
        this.presonnes = personnes;
    }

    public List<Personne> getPresonnes() {
        if (presonnes != null) {
            presonnes = sp.getAll();
        }
        return presonnes;
    }

    public String onSave() {
        sp.create(personne);
        return "ListePrs";

    }

    public String onDelete(int id) {
        sp.delete(sp.getById(id));
        return "ListePrs";
    }

    public String onUpdate() {
        loisir = new StringBuffer();
        for (String s : los) {

            loisir.append(s).append(",");
        }
        personne.setLoisir(loisir.toString());
        sp.update(personne);
        return "ListePrs";
    }

    public String onSelect(int id) {
        personne = sp.getById(id);
        return "update";
    }

    public String onCreate() {
        personne.setNom(personne.getNom().toUpperCase());
        personne.setPrenom(personne.getPrenom().substring(0, 1).toUpperCase() + "" + personne.getPrenom().substring(1).toLowerCase());
        loisir = new StringBuffer();
        for (String s : los) {

            loisir.append(s).append(",");
        }
        personne.setLoisir(loisir.toString());
        return "validate";
    }
}
