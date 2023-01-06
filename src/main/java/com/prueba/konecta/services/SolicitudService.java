package com.prueba.konecta.services;


import com.prueba.konecta.models.Solicitud;
import com.prueba.konecta.models.Empleado;

import java.util.List;
public interface SolicitudService {

    public Solicitud save(Solicitud solicitud);
    public List<Solicitud> getAll();

    public Solicitud findById(int id);
}