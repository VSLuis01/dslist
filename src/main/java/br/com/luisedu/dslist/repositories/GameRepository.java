package br.com.luisedu.dslist.repositories;

import br.com.luisedu.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
