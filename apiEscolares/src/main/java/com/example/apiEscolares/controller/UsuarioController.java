package com.example.apiEscolares.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.apiEscolares.model.Usuario;
import com.example.apiEscolares.model.Roles;
import com.example.apiEscolares.repository.UsuarioRepository;
import com.example.apiEscolares.repository.RolesRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        // Asumimos que el rol viene en el cuerpo de la solicitud
        // Si no se proporciona un rol, asignamos el rol "Alumno" por defecto
        if (usuario.getRoles() == null) {
            Optional<Roles> rolAlumno = rolesRepository.findByNombre("Alumno");
            if (rolAlumno.isPresent()) {
                usuario.setRoles(rolAlumno.get()); // Asignamos el rol "Alumno" por defecto
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Rol 'Alumno' no encontrado en la base de datos.");
            }
        }

        // Si el rol es "Admin", se verifica si existe en la base de datos
        if (usuario.getRoles().getNombre().equals("Admin")) {
            Optional<Roles> rolAdmin = rolesRepository.findByNombre("Admin");
            if (rolAdmin.isPresent()) {
                usuario.setRoles(rolAdmin.get());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Rol 'Admin' no encontrado en la base de datos.");
            }
        }

        // Guardamos el nuevo usuario
        try {
            Usuario nuevoUsuario = usuarioRepository.save(usuario);
            return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el usuario: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/rol")
    public ResponseEntity<?> actualizarRolUsuario(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        String nuevoRolNombre = request.get("rol");

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado.");
        }

        Optional<Roles> rolOpt = rolesRepository.findByNombre(nuevoRolNombre);
        if (rolOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Rol no válido: " + nuevoRolNombre);
        }

        Usuario usuario = usuarioOpt.get();
        usuario.setRoles(rolOpt.get());
        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Rol actualizado a: " + nuevoRolNombre);
    }
}
