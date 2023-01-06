package com.prueba.konecta.controllers;
import com.prueba.konecta.models.Empleado;
import com.prueba.konecta.services.EmpleadoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmpleadoController {


    @Autowired
    private EmpleadoService service;

    @PostMapping("insertar")
    public ResponseEntity<?> insertar(@RequestBody Empleado empleado){
        Empleado empleadoNuevo = null;
        Map<String,Object> response = new HashMap<>();
        try{
            empleadoNuevo = service.save(empleado);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El empleado ha sido creado con exito");
        response.put("empleado", empleadoNuevo);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @GetMapping("empleado")
    public List<Empleado> listar() {
        return service.getAll();

    }
    @GetMapping("empleado/{id}")
    public ResponseEntity<?> getId(@PathVariable int id){
        Empleado empleado = null;
        Map<String,Object> response = new HashMap<>();

        try{
            empleado = service.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert en la base de datos");
            response.put("error",e.getMessage());
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (empleado == null){
            response.put("mensaje", "el cliente con ID ".concat(" ").concat("No existe"));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
    }
}