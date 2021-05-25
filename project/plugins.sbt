addSbtPlugin("com.geirsson" % "sbt-ci-release" % "1.5.7")

// This project is its own plugin :)
unmanagedSourceDirectories in Compile += baseDirectory.value.getParentFile / "src" / "main" / "scala"
