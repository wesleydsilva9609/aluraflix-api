package br.com.aluraflix.videos_api.model.video;

import br.com.aluraflix.videos_api.model.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
    Page<Video> findAllByAtivoTrue(Pageable pageable);


    Video findByTituloContainingIgnoreCase(String titulo);
}
