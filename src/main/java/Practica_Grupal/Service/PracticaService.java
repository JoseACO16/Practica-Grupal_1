package Practica_Grupal.Service;


import Practica_Grupal.Domain.Practica;
import java.util.List;

public interface PracticaService {
    
    //Se declara un metodo para obtener un ArrayList de Objetos Practica
    //Los objetos vienen de la tabla practica...
    //Son todos los registros o solo los activos
    public List<Practica> getPracticas(boolean activos);
    
    //Abajo se colocaran los metodos para un CRUD de practicas... en s6
    // Se obtiene un Practica, a partir del id de un practica
    public Practica getPractica(Practica practica);
    
    // Se inserta un nuevo practica si el id del practica esta vacío
    // Se actualiza un practica si el id del practica NO esta vacío
    public void save(Practica practica);
    
    // Se elimina el practica que tiene el id pasado por parámetro
    public void delete(Practica practica);
}
