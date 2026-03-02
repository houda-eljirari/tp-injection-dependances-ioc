package ma.enset.presentation;

import ma.enset.dao.IDao;
import ma.enset.metier.IMetier;

import java.io.InputStream;
import java.util.Scanner;

public class PresentationV2 {

    public static void main(String[] args) throws Exception {

        // Lire le fichier depuis resources
        InputStream inputStream =
                PresentationV2.class.getClassLoader().getResourceAsStream("config.txt");

        Scanner scanner = new Scanner(inputStream);

        String daoClassName = scanner.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getDeclaredConstructor().newInstance();

        String metierClassName = scanner.nextLine();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();

        // Injection via Reflection
        cMetier.getMethod("setDao", IDao.class).invoke(metier, dao);

        System.out.println("Résultat = " + metier.calcul());
    }
}