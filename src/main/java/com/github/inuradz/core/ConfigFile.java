package com.github.inuradz.core;

/**
 * This is the base file which all the
 */
public class ConfigFile {
    private String discordToken;
    private Long botAdminChannel;

    public String getDiscordToken() {
        return discordToken;
    }

    public void setDiscordToken(String discordToken) {
        this.discordToken = discordToken;
    }

    public Long getBotAdminChannel() {
        return botAdminChannel;
    }

    public void setBotAdminChannel(Long botAdminChannel) {
        this.botAdminChannel = botAdminChannel;
    }
}
