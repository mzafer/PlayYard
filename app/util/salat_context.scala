package util

import com.novus.salat._
import com.novus.salat.json.JSONConfig
import com.novus.salat.json.StringObjectIdStrategy
import play.api._
import play.api.Play.current
import com.novus.salat.json.TimestampDateStrategy

package object salat_context {
  
  
  implicit val ctx = { 
    val context = new Context {
      val name = "CustomCtx"
      override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary, typeHint = "_t")
      override val jsonConfig =  JSONConfig(objectIdStrategy = StringObjectIdStrategy
          ,dateStrategy = TimestampDateStrategy()
          )
    }
    //context.registerGlobalKeyOverride(remapThis = "id", toThisInstead = "_id1")
    context.registerClassLoader(Play.classloader)
    context
  }
   
}