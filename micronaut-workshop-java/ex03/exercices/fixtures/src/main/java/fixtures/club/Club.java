package fixtures.club;

import javax.validation.constraints.NotNull;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */

public class Club {


    private String nom;

    private String stade;

    public Club(@NotNull String nom, String stade) {
        this.nom = nom;
        this.stade = stade;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStade() {
        return stade;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }
}
