package com.github.inuradz.game.ping;

import com.github.inuradz.game.base.GameInterface;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import org.javacord.api.event.message.MessageCreateEvent;


/**
 * What is ping game? A game where you call a command to ping the bot, or a game where you ping the bot for fun to see who will win
 */
public class PingGame implements GameInterface {

    public PingGame(){

    }

    public void getLeaderboard() {

    }

    /**
     * This is to handle messages
     *
     * @param message This is the message that is passed in from the server
     */
    @Override
    public void processMessage(String message) {

    }

    /**
     * These callback will be called when the game has finished. The order of the clean up will be a queue
     *
     * @param cleanUp The callback function to be called when the game is done
     */
    @Override
    public void addDoneCallback(Runnable cleanUp) {

    }

    @Override
    public void run() {

    }
}
