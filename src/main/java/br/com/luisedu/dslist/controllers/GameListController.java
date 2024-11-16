package br.com.luisedu.dslist.controllers;

import br.com.luisedu.dslist.dto.GameListDTO;
import br.com.luisedu.dslist.dto.GameMinDTO;
import br.com.luisedu.dslist.dto.ReplacementDTO;
import br.com.luisedu.dslist.services.GameListService;
import br.com.luisedu.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    @Autowired
    public GameListController(GameListService gameService, GameService gameListService) {
        this.gameListService = gameService;
        this.gameService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
