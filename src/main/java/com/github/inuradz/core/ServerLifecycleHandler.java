package com.github.inuradz.core;

import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.event.server.ServerJoinEvent;
import org.javacord.api.listener.server.ServerJoinListener;

import java.util.concurrent.ConcurrentHashMap;

public class ServerLifecycleHandler implements ServerJoinListener {

    ConcurrentHashMap<Long,ServerContext> serverContextMap;


    public ServerLifecycleHandler(){
        serverContextMap = new ConcurrentHashMap<>();
    }


    /**
     * This is used to add a new server to the bot
     * @param serverId The id of the server that is joining
     * @return A new server context bot
     */
    public ServerContext createNewServerContext(Long serverId){
        return new ServerContext();
    }


    /**
     * This is used to set up all of information needed when a user joins the Server
     *
     * @param event The event.
     */
    @Override
    public void onServerJoin(ServerJoinEvent event) {
        serverContextMap.computeIfAbsent(event.getServer().getId(),this::createNewServerContext);
    }
}
