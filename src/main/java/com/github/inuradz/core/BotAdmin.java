package com.github.inuradz.core;

import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class BotAdmin implements MessageCreateListener {

    private Long botAdminChannel;
    private User bot;

    public BotAdmin(Long botAdminChannel){
        this.botAdminChannel = botAdminChannel;
    }


    /**
     * This method is called every time a message is created.
     *
     * @param event The event.
     */
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if((event.getChannel().getId() == this.botAdminChannel) && !event.getMessageAuthor().isBotUser()){
            switch(event.getMessage().getContent()){
                case "?shutdown":
                    event.getChannel().sendMessage("Shutdown the server");
                    event.getApi().disconnect();
                    return;
            }
        }
    }
}
