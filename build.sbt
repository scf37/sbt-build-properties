lazy val buildprops = (project in file("."))
    .settings(

    name := "sbt-build-properties",
    organization := "me.scf37.buildprops",
    sbtPlugin := true,

    releaseTagComment := s"[ci skip]Releasing ${(version in ThisBuild).value}",
    releaseCommitMessage := s"[ci skip]Setting version to ${(version in ThisBuild).value}",

    bintrayOmitLicense := true,

    bintrayVcsUrl := Some("git@github.com:scf37/sbt-build-properties.git")
)

sbtPlugin := true

