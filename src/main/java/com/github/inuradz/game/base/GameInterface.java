package com.github.inuradz.game.base;

import org.javacord.api.event.message.MessageCreateEvent;


/**
 * This is
 */
public interface GameInterface extends Runnable {

    /**
     * This is to handle messages
     * @param message This is the message that is passed in from the server
     */
    public void processMessage(String message);

    /**
     * These callback will be called when the game has finished. The order of the clean up will be a queue
     * @param cleanUp The callback function to be called when the game is done
     */
    public void addDoneCallback(Runnable cleanUp);

    /**
     * This is used to actually run the game, it runs in a separate thread
     */
    public void run();
}
