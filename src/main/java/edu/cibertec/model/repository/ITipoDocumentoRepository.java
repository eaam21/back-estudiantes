package edu.cibertec.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.model.entity.TipoDocumento;

public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
	TipoDocumento findTipoDocumentoByIdDocumento(Integer id);
}
