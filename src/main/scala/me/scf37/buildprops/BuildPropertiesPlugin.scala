package me.scf37.buildprops

import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Properties
import java.util.TimeZone

import sbt.Keys._
import sbt._

import scala.language.postfixOps
import scala.util.Try

object BuildPropertiesPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val buildProperties = taskKey[Seq[File]]("Generate build.properties")
    val buildPropertiesSource = taskKey[Map[String, Any]]("Map to put to build.properties")
    val buildPropertiesTarget = settingKey[File]("File name to write properties")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    buildProperties := {
      val f = BuildProperties(buildPropertiesSource.value, buildPropertiesTarget.value)
      streams.value.log.info("Writing " + f.getName)
      Seq(f)
    },
    buildPropertiesTarget := resourceManaged.value / "build.properties",
    buildPropertiesSource := {
      Map(
        "name" -> name.value,
        "version" -> version.value,
        "build_timestamp" -> BuildProperties.now,
        "build_revision" -> Try(("git rev-parse HEAD" !!).trim).getOrElse("NONE"),
        "scm_repository" -> Try(("git config --get remote.origin.url" !!).trim).getOrElse("NONE"),
        "build_last_few_commits" -> Try(Seq("git", "log", "-n", "5", "--pretty=%h %ad %an %s") !!).getOrElse("NONE"))
    }
  )
}

object BuildProperties {

  def apply(props: Map[String, Any], file: File): File = {
    val propString = {
      val p = new Properties()
      props.foreach { case (k, v) =>
        p.setProperty(k, Option(v).map(_.toString).getOrElse(""))
      }
      val sw = new StringWriter()
      p.store(sw, "")
      sw.toString
    }

    IO.write(file, propString.getBytes("UTF-8"))

    file
  }

  def now: String = {
    val tz = TimeZone.getTimeZone("UTC")
    val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    df.setTimeZone(tz)
    df.format(new Date())
  }
}