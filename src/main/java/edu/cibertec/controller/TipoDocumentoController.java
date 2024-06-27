package edu.cibertec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cibertec.model.entity.TipoDocumento;
import edu.cibertec.model.repository.ITipoDocumentoRepository;

@RestController
@RequestMapping("api/tipoDocumento")
@CrossOrigin
public class TipoDocumentoController {
	
	@Autowired
	ITipoDocumentoRepository tipoDocumentoRepository;

	@GetMapping("/listar")
	public List<TipoDocumento> listar() {
		return tipoDocumentoRepository.findAll();
	}
	
	@PostMapping("/registrar")
	public String registrar(@RequestBody TipoDocumento tipoDocumento) {
		if(tipoDocumentoRepository.save(tipoDocumento)!=null) {
			return "Registro exitoso";
		}else {
			return "Error en el registro";
		}
	}
	
}
