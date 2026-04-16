package com.eficiencia.eficiencia.Controller;

import com.eficiencia.eficiencia.DTO.Empresa.EmpresaCreateDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaResponseDto;
import com.eficiencia.eficiencia.DTO.Empresa.EmpresaUpdateDto;
import com.eficiencia.eficiencia.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaResponseDto> create(@RequestBody EmpresaCreateDto dto) {
        EmpresaResponseDto response = empresaService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponseDto>> findAll() {
        List<EmpresaResponseDto> response = empresaService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> findById(@PathVariable Long id) {
        EmpresaResponseDto response = empresaService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponseDto> update(@PathVariable Long id, @RequestBody EmpresaUpdateDto dto) {
        EmpresaResponseDto response = empresaService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}