package com.eficiencia.eficiencia.Controller;

import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoCreateDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoResponseDto;
import com.eficiencia.eficiencia.DTO.Empleado.EmpleadoUpdateDto;
import com.eficiencia.eficiencia.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<EmpleadoResponseDto> create(@RequestBody EmpleadoCreateDto dto) {
        EmpleadoResponseDto response = empleadoService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDto>> findAll() {
        List<EmpleadoResponseDto> response = empleadoService.findAll();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity<List<EmpleadoResponseDto>> findByEmpresaId(@PathVariable Long empresaId) {
        List<EmpleadoResponseDto> response = empleadoService.findByEmpresaId(empresaId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> findById(@PathVariable Long id) {
        EmpleadoResponseDto response = empleadoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDto> update(@PathVariable Long id, @RequestBody EmpleadoUpdateDto dto) {
        EmpleadoResponseDto response = empleadoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
