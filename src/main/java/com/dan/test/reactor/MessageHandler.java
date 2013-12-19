package com.dan.test.reactor;

/**
 * Handle the incoming message
 */
public interface MessageHandler {

    void handleMessage(Message message);

}
