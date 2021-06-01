ThisBuild / name := "akka-action"
ThisBuild / scalaVersion := "2.13.6"

val akkaV         = "2.6.4"
val akkaHttpV     = "10.1.11"
val circeV        = "0.13.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka"           %% "akka-actor"             % akkaV,
  "com.typesafe.akka"           %% "akka-actor-typed"       % akkaV,
  "com.typesafe.akka"           %% "akka-http-core"         % akkaHttpV,
  "com.typesafe.akka"           %% "akka-http"              % akkaHttpV,
  "com.typesafe.akka"           %% "akka-http2-support"     % akkaHttpV,
  "com.typesafe.akka"           %% "akka-http-spray-json"   % akkaHttpV,
  "ch.qos.logback"              %  "logback-classic"        % "1.2.3",
  "com.typesafe.scala-logging"  %% "scala-logging"          % "3.9.2",
  "io.circe"                    %% "circe-core"             % circeV,
  "io.circe"                    %% "circe-generic"          % circeV,
  "io.circe"                    %% "circe-parser"           % circeV,
  "io.circe"                    %% "circe-generic-extras"   % circeV,
  "org.slf4j"                   %  "slf4j-nop"              % "1.7.26",
  "com.typesafe.akka"           %% "akka-slf4j"             % akkaV,
  "com.typesafe.scala-logging"  %% "scala-logging"          % "3.9.2",
  "com.typesafe.akka"           %% "akka-stream"            % akkaV,
  "com.github.pureconfig"       %% "pureconfig"             % "0.12.1",
  "com.typesafe"                %  "config"                 % "1.4.0",
  "com.typesafe.akka"           %% "akka-testkit"           % akkaV   % "test",
  "junit"                       %  "junit"                  % "4.11"  % "test",
  "com.novocode"                %  "junit-interface"        % "0.10"  % "test",
  "org.scalatest"               %% "scalatest"              % "3.0.8"
)