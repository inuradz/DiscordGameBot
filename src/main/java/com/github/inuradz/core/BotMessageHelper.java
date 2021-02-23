package com.github.inuradz.core;

import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.user.User;

public class BotMessageHelper {

    public static Boolean skipBotCommands(User bot, User commandUser){
        return !bot.equals(commandUser);
    }

    public static Boolean onlyAllowedChannel(Channel channel, Long allowed){
        return channel.getId() == allowed;
    }

}
