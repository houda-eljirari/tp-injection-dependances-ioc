package ma.enset.presentation;

import ma.enset.dao.DaoImpl;
import ma.enset.metier.MetierImpl;

public class PresentationV1 {

    public static void main(String[] args) {

        // Création manuelle des objets (instanciation statique)
        DaoImpl dao = new DaoImpl();

        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); // Injection via setter

        System.out.println("Résultat = " + metier.calcul());
    }
}