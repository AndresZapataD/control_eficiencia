package com.eficiencia.eficiencia.Service;

import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoCreateDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoResponseDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoUpdateDto;
import com.eficiencia.eficiencia.Mapper.Empleado.EmpleadoMapper;
import com.eficiencia.eficiencia.Model.EmpleadoModel;
import com.eficiencia.eficiencia.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoResponseDto create(EmpleadoCreateDto dto) {
        EmpleadoModel model = EmpleadoMapper.toModel(dto);
        EmpleadoModel saved = empleadoRepository.save(model);
        return EmpleadoMapper.toResponseDto(saved);
    }

    public List<EmpleadoResponseDto> findAll() {
        return empleadoRepository.findAll().stream()
                .map(EmpleadoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public List<EmpleadoResponseDto> findByEmpresaId(Long empresaId) {
        return empleadoRepository.findByEmpresaId(empresaId).stream()
                .map(EmpleadoMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    public EmpleadoResponseDto findById(Long id) {
        EmpleadoModel model = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado not found"));
        return EmpleadoMapper.toResponseDto(model);
    }

    public EmpleadoResponseDto update(Long id, EmpleadoUpdateDto dto) {
        EmpleadoModel existing = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado not found"));
        EmpleadoModel updated = EmpleadoMapper.toModel(dto, existing);
        EmpleadoModel saved = empleadoRepository.save(updated);
        return EmpleadoMapper.toResponseDto(saved);
    }

    public void delete(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new RuntimeException("Empleado not found");
        }
        empleadoRepository.deleteById(id);
    }
}
