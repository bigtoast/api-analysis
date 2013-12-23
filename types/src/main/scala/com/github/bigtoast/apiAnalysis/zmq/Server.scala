package com.github.bigtoast.apiAnalysis.zmq

//import akka.zeromq._
import akka.actor._

object Server {
  
  val system = ActorSystem()
  
  //val handler = system.actorOf( Props[Handler] )
  /*
  val router = system.newRouterSocket( Listener( handler ), Connect("tcp://*:1234"), HighWatermark( 10000 ) )
  val dealer = system.newDealerSocket( Listener( handler ), Connect("tcp://*:1235") )
  
  class Handler() extends Actor {
    
    def receive :Receive = {
      case Connecting =>
      case m :ZMQMessage =>
      case _ =>
    }
  }
  */
}
