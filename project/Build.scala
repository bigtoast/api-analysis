
import sbt._
import Keys._
import sbtavro.SbtAvro
// avroSettings : _*
import sbtprotobuf.ProtobufPlugin
// protobufSettings :_ *
import atd.sbtthrift.ThriftPlugin
// thriftSettings
import com.github.bigtoast.sbtmsgpack.MsgPackPlugin

object ApiAnalysis extends Build {

  val typesafe = "typesafe repo" at "http://repo.typesafe.com/typesafe/releases"
  
  val thrift  = "org.apache.thrift" % "libthrift" % "0.7.0"
  val netty   = "org.jboss.netty" % "netty" % "3.2.7.Final"
  val akka    = "com.typesafe.akka" % "akka-actor" % "2.0.1"
  val msgpack = "org.msgpack" % "msgpack" % "0.6.5"
  
  
  lazy val all = Project( id = "all", base = file(".") ) aggregate( types )

  lazy val types = Project( 
       id = "types", 
 
       base = file("types"), 

       settings = 
       	Defaults.defaultSettings        ++
	    ThriftPlugin.thriftSettings     ++
        ProtobufPlugin.protobufSettings ++
 	    SbtAvro.avroSettings            ++
 	    MsgPackPlugin.msgpackSettings   ++
 	    Seq(
 	      libraryDependencies ++= List( thrift, netty, akka, msgpack ),
 	      resolvers += typesafe
 	    )
 	    

  )

}