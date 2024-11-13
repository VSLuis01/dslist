package br.com.luisedu.dslist.controllers;

import br.com.luisedu.dslist.dto.GameListDTO;
import br.com.luisedu.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameService;

    @Autowired
    public GameListController(GameListService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameService.findAll();
    }
}
