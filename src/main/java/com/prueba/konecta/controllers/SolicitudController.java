package com.prueba.konecta.controllers;
import com.prueba.konecta.models.Empleado;
import com.prueba.konecta.models.Solicitud;
import com.prueba.konecta.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService service;

    @PostMapping("crearSolicitud")
    public ResponseEntity<?> insertar(@RequestBody Solicitud solicitud){
        Solicitud solicitudNueva = null;
        Map<String,Object> response = new HashMap<>();
        try{
            solicitudNueva = service.save(solicitud);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El empleado ha sido creado con exito");
        response.put("empleado", solicitudNueva);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }
    @GetMapping("solicitud")
    public List<Solicitud> listar() {
        return service.getAll();

    }
    @GetMapping("solicitud/{id}")
    public ResponseEntity<?> getId(@PathVariable int id){
        Solicitud solicitud = null;
        Map<String,Object> response = new HashMap<>();

        try{
            solicitud = service.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (solicitud == null){
            response.put("mensaje", "el cliente con ID ".concat(" ").concat("No existe"));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Solicitud>(solicitud,HttpStatus.OK);
    }
}
