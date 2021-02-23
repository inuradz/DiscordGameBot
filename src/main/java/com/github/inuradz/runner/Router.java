package com.github.inuradz.runner;

import com.github.inuradz.game.base.GameFactory;
import com.github.inuradz.game.base.GameInterface;
import com.github.inuradz.game.ping.PingFactory;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Router implements MessageCreateListener {

    List<GameFactory> gameFactories;
    ConcurrentMap<Server, GameInterface> gameInstance;

    Router() {
        gameFactories = new LinkedList<>();
        gameFactories.add(new PingFactory());

        gameInstance = new ConcurrentHashMap<>();
    }

    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        event.getServer().ifPresent(server ->
                {
                    var existingGame = gameInstance.get(server);
                    if (existingGame != null) {
                        existingGame.processMessage(event);
                    } else {
                        for (var gameFactory : gameFactories) {
                            gameFactory
                                    .createGame(event.getMessageContent())
                                    .ifPresent(game -> {
                                        gameInstance.put(server, game);
                                        game.start();
                                    });
                        }
                    }
                }
        );

    }
}
