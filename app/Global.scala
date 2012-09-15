import play.api._
import com.mongodb.casbah.Imports._

object Global extends GlobalSettings {
	
  override def onStart(app: Application) {
    //com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers()
    
    Logger.info("Application has started with JodaTime registered")
  }
}