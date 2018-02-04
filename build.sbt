lazy val buildprops = (project in file("."))
    .settings(

    name := "sbt-build-properties",
    organization := "me.scf37.buildprops",

    crossSbtVersions := Vector("0.13.17", "1.1.0"),
    sbtPlugin := true,

    releaseTagComment := s"[ci skip]Releasing ${(version in ThisBuild).value}",
    releaseCommitMessage := s"[ci skip]Setting version to ${(version in ThisBuild).value}",

//    bintrayOmitLicense := true,
    bintrayVcsUrl := Some("git@github.com:scf37/sbt-build-properties.git"),
    bintrayRepository := "sbt-plugins",
    publishMavenStyle := false,
    bintrayOrganization := None,
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),

    resourceGenerators in Compile += buildProperties

)



