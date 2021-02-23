package com.github.inuradz.game.ping;

import com.github.inuradz.game.base.GameFactory;
import com.github.inuradz.game.base.GameInterface;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

import java.util.Optional;

public class PingFactory implements GameFactory {

    private ArgumentParser argumentParser;

    public PingFactory(){
        this.argumentParser = ArgumentParsers.newFor("?ping").addHelp(true).build();
    }

    @Override
    public Optional<GameInterface> createGame(String command) {
        //Check to see if it is even trying to be called
        if (command.startsWith("?ping")){
            try {
                var arg = argumentParser.parseArgs(command.split(" "));
                return Optional.of(new PingGame());
            } catch (ArgumentParserException e) {
                //(e.toString());
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String getInfo(String commandRename) {
        return "I am a ping challenge";
    }

    @Override
    public String getHelpString(String commandRename) {
        return "This is a ping challenge. Every time you ping me, you get a fun message back and I count how many times you have called me";
    }
}
