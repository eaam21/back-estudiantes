package edu.cibertec.model.dto;

public record EstudianteInputDTO(
	    String apellidoPaterno,
	    String apellidoMaterno,
	    String nombres,
	    String numeroDocumento,
	    String carrera,
	    String telefono,
	    String correo,
	    Integer tipoDocumento
		) {}