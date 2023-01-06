package com.prueba.konecta.services;
import com.prueba.konecta.models.Empleado;
import java.util.List;

public interface EmpleadoService {

    public Empleado save(Empleado empleado);
    public List<Empleado> getAll();

    public Empleado findById(int id);
}
