package br.com.aluraflix.videos_api.model.categoria;

import br.com.aluraflix.videos_api.model.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    Page<Categoria> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select v from Video v
            WHERE
            v.categoriaid.id = :id
            """)
    List<Video> buscarVideoPorCategoriaId(Long id);
}
