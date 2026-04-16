package com.eficiencia.eficiencia.Controller;

import com.eficiencia.eficiencia.DTO.Rol.RolCreateDto;
import com.eficiencia.eficiencia.DTO.Rol.RolResponseDto;
import com.eficiencia.eficiencia.DTO.Rol.RolUpdateDto;
import com.eficiencia.eficiencia.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public ResponseEntity<RolResponseDto> create(@RequestBody RolCreateDto dto) {
        RolResponseDto response = rolService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<RolResponseDto>> findAll() {
        List<RolResponseDto> response = rolService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponseDto> findById(@PathVariable Integer id) {
        RolResponseDto response = rolService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolResponseDto> update(@PathVariable Integer id, @RequestBody RolUpdateDto dto) {
        RolResponseDto response = rolService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
