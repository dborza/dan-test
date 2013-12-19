package com.dan.test.reactor;

/**
 * Produce a {@link Message} object.
 */
public interface MessageProducer {

    Message produce(Object content);
}
