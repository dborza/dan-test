package com.dan.test.reactor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: dan
 * Date: 12/19/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(final String[] args) {

        /**
         * Number of producers that concurrently produce messages for our queue
         */
        final int producerNumber = 5;

        /**
         * Number of messages produced by each producer.
         */
        final int messageNumber = 10;

        /**
         * The queue that will contain all the messages. Will add elements in it concurrently, will read from it
         * synchronously. Offers blocking take() method.
         */
        final LinkedBlockingQueue<Message> messageQueue = new LinkedBlockingQueue<Message>();

        /**
         * Used for concurrent message producing. Multiple producer produce messages to the same queue.
         */
        final ExecutorService executorService = Executors.newFixedThreadPool(producerNumber);

        //  Each producer produces a number of messages in the queue.
        for (int i = 0; i < producerNumber; i ++) {
            final int currentProducer = i;
            executorService.submit(new Runnable() {
                public void run() {
                    for (int j = 0; j < messageNumber; j ++) {
                        final Message message = new Message();
                        message.content = "Producer " + currentProducer + ", message #" + j;
                        message.messageType = MessageType.T2;
                        messageQueue.add(message);
                        try {
                            //  Sleeping until this producer prepares next message.
                            //  We do this in order to intertwine messages in the queue
                            //  The sleep time ought to simulate some sort of randomness for the message producing
                            final Random random = new Random();
                            Thread.sleep(random.nextInt(10)* 100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        //  Consumer thread - read messages sequentially
        new Thread(new Runnable() {
            public void run() {
                System.out.println(">>> Starting consumer thread...");
                Message message = null;
                try {
                    while (true) {
                        //  blocking wait - might throw InterruptedException
                        message = messageQueue.take();
                        System.out.println("Handling message " + message.content);
                    }
                } catch (InterruptedException e) {
                    //  Exception not handled
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
