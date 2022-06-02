package com.example.demo.mapper;

import com.example.demo.collections.Dato;
import com.example.demo.dto.DatoDTO;

import java.util.function.Function;

public class MapperUtils {
    public Function<DatoDTO, Dato> mapperToDato(String id){
        return updateDato -> {
            var dato = new Dato();
            dato.setId(id);
            dato.setInformacion(updateDato.getInformacion());
            return dato;
        };
    }
    public Function<Dato, DatoDTO> mapDatoToDTO(){
        return entity -> new DatoDTO(entity.getId(), entity.getInformacion());
    }
}
