package edu.cibertec.model.dto;

public record EstudianteDTO(
	    String apellidoPaterno,
	    String apellidoMaterno,
	    String nombres,
	    String numeroDocumento,
	    String carrera,
	    String telefono,
	    String correo,
	    Integer tipoDocumento
		) {}