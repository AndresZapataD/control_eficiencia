package com.eficiencia.eficiencia.Service;

import com.eficiencia.eficiencia.DTO.Empresa.EmpresaCreateDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaResponseDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaUpdateDto;
import com.eficiencia.eficiencia.Mapper.Empresa.EmpresaMapper;
import com.eficiencia.eficiencia.Model.EmpresaModel;
import com.eficiencia.eficiencia.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

   public EmpresaResponseDto create(EmpresaCreateDto dto) {

    // 1. DTO → Model
    EmpresaModel model = EmpresaMapper.toModel(dto);

    // 2. Lógica de negocio (SaaS)
    model.setActivo(true); // por defecto activa al crearse

    // 3. Auditoría (si NO la maneja JPA automáticamente)
    LocalDateTime now = LocalDateTime.now();

    model.setCreatedAt(now);
    model.setUpdatedAt(now);

    // 4. Guardar en BD
    EmpresaModel saved = empresaRepository.save(model);

    // 5. Model → Response DTO
    return EmpresaMapper.toResponseDto(saved);
}

    public List<EmpresaResponseDto> findAll() {
        return empresaRepository.findAll().stream()
                .map(EmpresaMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public EmpresaResponseDto findById(Long id) {
        EmpresaModel model = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa not found"));
        return EmpresaMapper.toResponseDto(model);
    }

    public EmpresaResponseDto update(Long id, EmpresaUpdateDto dto) {
        EmpresaModel existing = empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa not found"));
        EmpresaModel updated = EmpresaMapper.toModel(dto, existing);
        // updatedAt will be set by JPA
        EmpresaModel saved = empresaRepository.save(updated);
        return EmpresaMapper.toResponseDto(saved);
    }

    public void delete(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new RuntimeException("Empresa not found");
        }
        empresaRepository.deleteById(id);
    }
}