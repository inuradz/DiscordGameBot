package com.github.inuradz.game.base;

import java.util.Optional;

public interface GameFactory {

    public Optional<GameInterface> createGame(String command);

    public String getInfo(String commandRename);

    public String getHelpString(String commandRename);


}
