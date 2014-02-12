name := "FindMeServer"

version := "1.0"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.typesafe.slick" %% "slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)

play.Project.playScalaSettings


