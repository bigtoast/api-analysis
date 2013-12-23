
import sbt._
import Keys._
import sbtavro.SbtAvro
// avroSettings : _*
import sbtprotobuf.ProtobufPlugin
// protobufSettings :_ *
import com.github.bigtoast.sbtthrift.ThriftPlugin
import ThriftPlugin._
// thriftSettings
//import com.github.bigtoast.sbtmsgpack.MsgPackPlugin

object ApiAnalysis extends Build {

  val typesafe = "typesafe repo" at "http://repo.typesafe.com/typesafe/releases"
  
  val thrift     = "org.apache.thrift" % "libthrift" % "0.7.0"
  val avro_ipc   = "org.apache.avro" % "avro-ipc" % "1.6.3"
  val netty      = "org.jboss.netty" % "netty" % "3.2.7.Final"
  val akka       = "com.typesafe.akka" % "akka-actor" % "2.0.1"
  val akka_zmq   = "com.typesafe.akka" % "akka-zeromq" % "2.0.1"
  val msgpack    = "org.msgpack" % "msgpack" % "0.6.0"
  val scala_test = "org.scalatest" %% "scalatest" % "1.6.1" % "it,test"
  
  
  lazy val all = Project( id = "all", base = file(".") ) aggregate( types )

  lazy val types = Project( 
       id = "types", 
 
       base = file("types"), 

       settings = 
       	Defaults.defaultSettings        ++
	    ThriftPlugin.thriftSettings     ++
	    ProtobufPlugin.protobufSettings ++
 	    SbtAvro.avroSettings            ++
 	    Seq(
 	      libraryDependencies ++= List( thrift, netty, akka, msgpack, akka_zmq, avro_ipc, scala_test ),
 	      resolvers += typesafe,
	      thriftRubyEnabled in Thrift := true,
	      thriftPythonEnabled in Thrift := true
 	    )
 	    
  ).configs( IntegrationTest )
   .settings( Defaults.itSettings : _*)
   .settings( parallelExecution in IntegrationTest := false )

}
