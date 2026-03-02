package ma.enset.metier;

import ma.enset.dao.DaoImpl;
import ma.enset.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    @Autowired
    private IDao dao;

    @Override
    public double calcul() {
        return dao.getData() * 10;
    }

    public void setDao(DaoImpl dao) {
    }
}