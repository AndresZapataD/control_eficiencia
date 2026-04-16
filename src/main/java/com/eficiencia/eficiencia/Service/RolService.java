package com.eficiencia.eficiencia.Service;

import com.eficiencia.eficiencia.DTO.Rol.RolCreateDto;
import com.eficiencia.eficiencia.DTO.Rol.RolResponseDto;
import com.eficiencia.eficiencia.DTO.Rol.RolUpdateDto;
import com.eficiencia.eficiencia.Mapper.Rol.RolMapper;
import com.eficiencia.eficiencia.Model.RolUsuarioModel;
import com.eficiencia.eficiencia.Repository.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolUsuarioRepository rolRepository;

    public RolResponseDto create(RolCreateDto dto) {
        RolUsuarioModel model = RolMapper.toModel(dto);
        RolUsuarioModel saved = rolRepository.save(model);
        return RolMapper.toResponseDto(saved);
    }

    public List<RolResponseDto> findAll() {
        return rolRepository.findAll().stream()
                .map(RolMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public RolResponseDto findById(Integer id) {
        RolUsuarioModel model = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol not found"));
        return RolMapper.toResponseDto(model);
    }

    public RolResponseDto update(Integer id, RolUpdateDto dto) {
        RolUsuarioModel existing = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol not found"));
        RolUsuarioModel updated = RolMapper.toModel(dto, existing);
        RolUsuarioModel saved = rolRepository.save(updated);
        return RolMapper.toResponseDto(saved);
    }

    public void delete(Integer id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol not found");
        }
        rolRepository.deleteById(id);
    }
}
