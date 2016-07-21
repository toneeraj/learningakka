package com.akkademy;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

import static akka.japi.pf.ReceiveBuilder.match;

/**
 * An actor which does following two things when it receives a message
 * <p>
 * Log the message.
 * Store the contents of any Set message for later retrieval.
 *
 * Created by Neeraj on 7/20/2016.
 */
public class AkkademyDb extends AbstractActor {

    //to log the message
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

    //to store the message which this actor receives
    protected final Map<String, Object> map = new HashMap<>();

    private AkkademyDb() {
        /* provide the behaviour of the actor here. What the actor should do when it receives a SetRequest message
        * */
        receive(match(SetRequest.class, message -> {
                    log.info("Received set request – key: {} value: {}", message.getKey(), message.getValue());
                    map.put(message.getKey(), message.getValue());
                }).matchAny(o -> log.info("received unknown message {}", o)).build()
        );
    }
}
