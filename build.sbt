lazy val buildprops = (project in file("."))
    .settings(

    name := "sbt-build-properties",
    organization := "me.scf37",

    sbtPlugin := true,

    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),

    Compile / resourceGenerators += buildProperties,
    publishSettings
)

lazy val publishSettings = Seq(
      organization := "me.scf37",
      description := "Build properties plugin for sbt",
      Compile / doc / sources := Seq.empty,
      scmInfo := Some(
            ScmInfo(
                  url("https://github.com/scf37/sbt-build-properties"),
                  "git@github.com:scf37/sbt-build-properties.git"
            )
      ),
      licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
      homepage := Some(url("https://github.com/scf37/sbt-build-properties")),
      developers := List(
            Developer("scf37", "Sergey Alaev", "scf370@gmail.com", url("https://github.com/scf37")),
      )
)



