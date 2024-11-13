package br.com.luisedu.dslist.services;

import br.com.luisedu.dslist.dto.GameDTO;
import br.com.luisedu.dslist.dto.GameMinDTO;
import br.com.luisedu.dslist.entities.Game;
import br.com.luisedu.dslist.projections.GameMinProjection;
import br.com.luisedu.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
//        List<GameMinDTO> gameMinDTOS = new ArrayList<>();
//        gameMinDTOS = gameRepository.findAll().stream().map(game -> new GameMinDTO(game)).toList();

        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();

        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId).stream().map(GameMinDTO::new).toList();
    }
}
