package br.com.aluraflix.videos_api.model.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Page<Categoria> findAllByAtivoTrue(Pageable pageable);
}
