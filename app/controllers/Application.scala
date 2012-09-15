package controllers

import play.api._
import play.api.mvc._
import org.bson.types.ObjectId
import model.TestItem

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
 
    def getItem (id: String)= Action {
        val oid = new ObjectId(id);
        val testItem = TestItem.findOneById(oid)
        Logger.debug("Date is "+testItem.get.date)
        Ok(TestItem.toCompactJson(testItem.get))
    }
    
    def newItem = Action(parse.tolerantText) {request =>
		 val jsonStr = request.body
		 Logger.debug("Input Json :"+jsonStr)
		 val testItem = TestItem.fromJSON(jsonStr)
		 TestItem.insert(testItem)
		 Logger.debug("Saved TestItem :"+TestItem.toCompactJson(testItem))
		 Ok(TestItem.toCompactJson(testItem))
	}
    
    def updateItem(id :String) = Action(parse.tolerantText) { request =>
	     val jsonStr = request.body
		 Logger.debug("Input Json for update TestItem:"+jsonStr)
		 val testItem = TestItem.fromJSON(jsonStr)
		 TestItem.save(testItem)
		 Logger.debug("Updated TestItem :"+TestItem.toCompactJson(testItem))
		 Ok(TestItem.toCompactJson(testItem))
    }
}