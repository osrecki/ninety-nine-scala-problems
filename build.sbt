name := "ninety-nine-scala-problems"

version := "1.0"

scalaVersion := "2.12.2"

scalacOptions ++= Seq(
  // Emit warning for usages of deprecated APIs
  "-deprecation",
  // Emit warning for usages of features that should be imported explicitly
  "-feature",
  // Enable additional warnings where generated code depends on assumptions
  "-unchecked"
)

libraryDependencies ++= Seq(
  Dependencies.Test.Scalatest
)

Scalariform.settings

Scalariform.formatting
