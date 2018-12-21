package com.insat.bibliotheque.repository;

import com.insat.bibliotheque.domain.Livre;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface LivreRepository extends JpaRepository<Livre, Long>, JpaSpecificationExecutor<Livre> {


    @Query(value="select p from Livre p where p.genre = :genre")
    List<Livre> findByGenree(@Param("genre") String genre);

    @Query(value="select distinct p.genre from Livre p")
    List<String> findAllGenre();

    @Query(value="select p from Livre p where p.titre LIKE CONCAT(:alphabet,'%') ")
    List<Livre> findByAlphabet(@Param("alphabet") String alphabet);


}
