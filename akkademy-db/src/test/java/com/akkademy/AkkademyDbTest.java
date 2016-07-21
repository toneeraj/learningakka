package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.akkademy.messages.SetRequest;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * The TestActorRef does two things:
 * it makes the actor's API synchronous so we don't need to think about concurrency in our tests,
 * and it gives us access to the underlying Actor object.
 * Created by neeraj on 7/20/2016.
 */
public class AkkademyDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals(akkademyDb.map.get("key"), "value");
    }
}
