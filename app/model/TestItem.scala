package model


import play.api.Play.current
//import util.salat_context._

import se.radley.plugin.salat._
import com.novus.salat.dao._
import com.novus.salat.annotations._

import com.mongodb.casbah.Imports._
import org.scala_tools.time.Imports.DateTime
import java.util.Date


// Use this for default context
import com.novus.salat.global._

case class TestItem(
		@Key("_id") id: ObjectId = new ObjectId, 
        name:String,
        //date:Option[DateTime] = None
        date:Option[Date] = None 
       ) 

object TestItem extends ModelCompanion[TestItem,ObjectId] {
  val collection = mongoCollection("TestItem")
  val dao = new SalatDAO[TestItem,ObjectId](collection = collection) {}
}	