package ma.enset.metier;

import ma.enset.dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;  // Couplage faible (interface)

    // Injection via Setter
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double data = dao.getData();
        return data * 10;
    }
}