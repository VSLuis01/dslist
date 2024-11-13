package br.com.luisedu.dslist.repositories;

import br.com.luisedu.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
