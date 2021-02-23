package com.github.inuradz.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.inuradz.core.BotAdmin;
import com.github.inuradz.core.ConfigFile;
import com.github.inuradz.core.ServerLifecycleHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.DiscordRegexPattern;

import java.io.File;
import java.io.IOException;

public class Main {

    static ConfigFile getConfigFile(String location) throws IOException {
        var mapper = new ObjectMapper(new YAMLFactory());
        mapper.findAndRegisterModules();
        return mapper.readValue(new File(location), ConfigFile.class);
    }

    public static void main(String[] args) throws IOException {
        Router r = new Router();
        var config = getConfigFile("BotConfig.yml");
        DiscordApi api = new DiscordApiBuilder().setToken(config.getDiscordToken()).login().join();

        var serverLifeCycle = new ServerLifecycleHandler();
        api.addServerJoinListener(serverLifeCycle);

        var botAdmin = new BotAdmin(config.getBotAdminChannel());
        api.addMessageCreateListener(botAdmin);

        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            System.out.println(event.getMessage().getContent());
            System.out.println(event.getMessageContent());
            if (event.getMessageContent().equalsIgnoreCase("!ping")) {
                System.out.println(event.getServer().equals(event.getApi().getServerById(249362561995112449L).get()));
                System.out.println(event.getServer().get().getId());
                System.out.println(DiscordRegexPattern.USER_MENTION.pattern());
                event.getChannel().sendMessage("Pong! <@!130296472901124096> <@!391929888896057347> <#249362561995112449>");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}
