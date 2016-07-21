**About the program**

Demonstrates a very simple actor which receives a message. Once the message is received by the actor, it logs the message and store it in a map.

To test the application, we have a simple test which sends a message to the actor and verifies by inspecting the message saved by the actor (i.e. value in the map) if it matches with the value which was sent as message.


**How to run**
You should have activator or sbt installed.

activator test
