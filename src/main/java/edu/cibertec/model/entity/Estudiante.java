package edu.cibertec.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tb_estudiante")
@Data
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private int idEstudiante;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="numero_documento")
	private String numeroDocumento;
	
	@Column(name="carrera")
	private String carrera;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@ManyToOne
	@JoinColumn(name="id_documento")
	private TipoDocumento tipoDocumento;
}
