package com.prueba.konecta.services;
import com.prueba.konecta.models.Empleado;
import com.prueba.konecta.repositories.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    EmpleadoRepository repository;
    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    public Empleado findById(int id) {
        return repository.findById(id).orElse(null);
    }
}

