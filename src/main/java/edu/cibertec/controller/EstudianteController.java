package edu.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.model.dto.EstudianteInputDTO;
import edu.cibertec.model.entity.Estudiante;
import edu.cibertec.model.entity.TipoDocumento;
import edu.cibertec.model.repository.IEstudianteRepository;
import edu.cibertec.model.repository.ITipoDocumentoRepository;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin
public class EstudianteController {
	
	@Autowired
	IEstudianteRepository estudianteRepository;
	
	@Autowired
	ITipoDocumentoRepository documentoRepository;
	
	@GetMapping("/listar")
	public List<Estudiante> listar(){
		return estudianteRepository.findAll();
	}

	@GetMapping("/obtener/{id}")
	public Estudiante obtener(@PathVariable("id") Integer id){
		return estudianteRepository.findEstudianteByIdEstudiante(id);
	}

	@PostMapping("/registrar")
	public ResponseEntity<?>registrar(@RequestBody EstudianteInputDTO inputEstudiante){
		Estudiante estudiante = new Estudiante();
		estudiante.setApellidoPaterno(inputEstudiante.apellidoPaterno());
		estudiante.setApellidoMaterno(inputEstudiante.apellidoMaterno());
		estudiante.setNombres(inputEstudiante.nombres());
		TipoDocumento tipoDocumento = documentoRepository.findTipoDocumentoByIdDocumento(inputEstudiante.tipoDocumento());
		estudiante.setTipoDocumento(tipoDocumento);
		estudiante.setNumeroDocumento(inputEstudiante.numeroDocumento());
		estudiante.setCarrera(inputEstudiante.carrera());
		estudiante.setTelefono(inputEstudiante.telefono());
		estudiante.setCorreo(inputEstudiante.correo());
		
		Map<String, Object> res = new HashMap<String, Object>();
		String mensaje=null;
		Boolean estado=null;
		Estudiante objEstudiante = estudianteRepository.save(estudiante);
		if(objEstudiante!=null) {
			mensaje = "Registro exitoso";
			estado=true;
		}else {
			mensaje = "Registro fallido";
			estado=false;
		}
		res.put("mensaje", mensaje);
		res.put("estado", estado);
		res.put("data", objEstudiante);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> actualizar(@PathVariable("id") Integer id, @RequestBody EstudianteInputDTO inputEstudiante) {
		Estudiante estudiante = estudianteRepository.findEstudianteByIdEstudiante(id);
		TipoDocumento tipoDocumento = documentoRepository.findTipoDocumentoByIdDocumento(inputEstudiante.tipoDocumento());
		estudiante.setApellidoPaterno(inputEstudiante.apellidoPaterno());
		estudiante.setApellidoMaterno(inputEstudiante.apellidoMaterno());
		estudiante.setNombres(inputEstudiante.nombres());
		estudiante.setTipoDocumento(tipoDocumento);
		estudiante.setCarrera(inputEstudiante.carrera());
		estudiante.setTelefono(inputEstudiante.telefono());
		estudiante.setCorreo(inputEstudiante.correo());
		estudianteRepository.save(estudiante);

		Map<String, Object> res= new HashMap<String, Object>();
		String mensaje="Actualizado con éxito";
		Boolean estado=true;
		res.put("mensaje", mensaje);
		res.put("estado", estado);
		res.put("data", estudiante);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
