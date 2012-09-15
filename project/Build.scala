import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "PlayYard"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
      "se.radley" %% "play-plugins-salat" % "1.0.9"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
     resolvers += "Sonatype Snapshot repo" at "http://oss.sonatype.org/content/repositories/snapshots",
     routesImport += "se.radley.plugin.salat.Binders._",
     templatesImport += "org.bson.types.ObjectId"
    )

}
