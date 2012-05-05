

resolvers += "gseitz@github" at "http://gseitz.github.com/maven/"

addSbtPlugin("com.github.gseitz" % "sbt-protobuf" % "0.2.2")

resolvers += "cavorite" at "http://files.cavorite.com/maven/"

addSbtPlugin("com.cavorite" % "sbt-avro" % "0.1")

resolvers += "bigtoast-github" at "http://bigtoast.github.com/repo/"

addSbtPlugin("atd" % "sbt-thrift" % "0.4")

addSbtPlugin("com.github.bigtoast" % "sbt-msgpack" % "0.4" )

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.0.0")