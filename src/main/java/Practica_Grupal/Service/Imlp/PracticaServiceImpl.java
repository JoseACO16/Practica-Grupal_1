package Practica_Grupal.Service.Imlp;

import Practica_Grupal.Dao.PracticaDao;
import Practica_Grupal.Domain.Practica;
import Practica_Grupal.Service.PracticaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PracticaServiceImpl implements PracticaService {

    //La anotacion Autowired crea un unico objeto mientras se ejecuta el app
    @Autowired
    private PracticaDao practicaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Practica> getPracticas(boolean activos) {
        var lista = practicaDao.findAll();
        if (activos) { //Se deben eliminar los que no estan activos...
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Practica getPractica(Practica practica) {
        return practicaDao.findById(practica.getIdPractica()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Practica practica) {
        practicaDao.save(practica);
    }

    @Override
    @Transactional
    public void delete(Practica practica) {
        practicaDao.delete(practica);
    }
}
