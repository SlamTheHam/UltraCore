package com.slamtheham.ultracore.listener;

import org.bukkit.event.Listener;

@FunctionalInterface
public interface ListenerConsumer {

    public abstract Listener get();

}