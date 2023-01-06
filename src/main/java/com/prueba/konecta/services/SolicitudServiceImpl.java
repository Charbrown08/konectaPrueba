package com.prueba.konecta.services;
import com.prueba.konecta.models.Empleado;
import com.prueba.konecta.models.Solicitud;
import com.prueba.konecta.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    SolicitudRepository repository;
    @Override
    public Solicitud save(Solicitud solicitud) {
        return repository.save(solicitud);
    }

    @Override
    public List<Solicitud> getAll() {
        return repository.findAll();
    }

    @Override
    public Solicitud findById(int id) {
        return repository.findById(id).get();
    }
}
