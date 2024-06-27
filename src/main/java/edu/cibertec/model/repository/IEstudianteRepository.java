package edu.cibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.model.entity.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {
	Estudiante findEstudianteByIdEstudiante(Integer id);
}
