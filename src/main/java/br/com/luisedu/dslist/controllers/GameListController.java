package br.com.luisedu.dslist.controllers;

import br.com.luisedu.dslist.dto.GameListDTO;
import br.com.luisedu.dslist.dto.GameMinDTO;
import br.com.luisedu.dslist.services.GameListService;
import br.com.luisedu.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListServiceService;
    private final GameService gameService;

    @Autowired
    public GameListController(GameListService gameService, GameService gameListService) {
        this.gameListServiceService = gameService;
        this.gameService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListServiceService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }
}
