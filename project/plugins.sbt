// A S S E M B L Y
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")

// B U I L D  I N F O
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.9.0")

// J A V A  A G E N T
addSbtPlugin("com.lightbend.sbt" % "sbt-javaagent" % "0.1.5")

// D E P E N D E N C Y  U P D A T E
addSbtPlugin("org.jmotor.sbt" % "sbt-dependency-updates" % "1.2.2")

// D E P E N D E N C Y  G R A P H
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.2")

// G I T
addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "1.0.0")

// N A T I V E  P A C K A G E R
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.5")

// R E V O L V E R
addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

// S C O V E R A G E
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.1")

// M D O C
addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.2.9")

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

// S C A L A J S
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.1.1")

// S C A L A J S  B U N D L E R
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.18.0")

// S C A L A B L Y  T Y P E D  C O N V E R T E R
resolvers += Resolver.bintrayRepo("oyvindberg", "converter")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta23")
