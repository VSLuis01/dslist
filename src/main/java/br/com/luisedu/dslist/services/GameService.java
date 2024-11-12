package br.com.luisedu.dslist.services;

import br.com.luisedu.dslist.dto.GameMinDTO;
import br.com.luisedu.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
//        List<GameMinDTO> gameMinDTOS = new ArrayList<>();
//        gameMinDTOS = gameRepository.findAll().stream().map(game -> new GameMinDTO(game)).toList();

        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }
}
