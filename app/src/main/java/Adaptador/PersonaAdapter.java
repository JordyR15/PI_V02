package Adaptador;

import Modelos.Persona;
import Utiles.ErrorLog;

public class PersonaAdapter {

    String consulta;
    ErrorLog perror;

    public String Consulta(Persona persona){
        consulta = "Nombre = " + persona.getNombre() + " Altura" + persona.getAltura();
        perror.setLabel(consulta);
        return consulta;
    }
}
