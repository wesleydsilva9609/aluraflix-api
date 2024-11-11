ALTER TABLE videos
ADD FOREIGN KEY (categoria_id) REFERENCES categorias(id);
