package test

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import play.api.test.FakeApplication
import play.api.test.Helpers._
import org.bson.types.ObjectId
import model.TestItem
import org.specs2.mutable.Tags
//import com.novus.salat.global._
import java.util.Date
import org.bson.BSON
import com.novus.salat._
import com.novus.salat.json.JSONConfig
import com.novus.salat.json.StringObjectIdStrategy
import org.scala_tools.time.Imports.DateTime
import com.novus.salat.json.TimestampDateStrategy

class TestSpec extends Specification with Tags{

  trait TestScope extends Scope {
	/*implicit val ctx = { 
			val context = new Context {
			val name = "CustomCtx"
			override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary, typeHint = "_t")
			override val jsonConfig =  JSONConfig(objectIdStrategy = StringObjectIdStrategy
							,dateStrategy = TimestampDateStrategy()
						)
			}
	}*/
  }
  
  object FakeApp extends FakeApplication()
  
  "Test Item" should {
    "be converted to Json " in new TestScope  {
      running (FakeApp) {
    	  
    	 // val decHooks = BSON.getDecodingHooks(classOf[java.util.Date])
    	 // println(decHooks.get(0).toString())
    	   	
    	  var testItem = TestItem(name="Test Item1",date=Some(new Date())) 
    	  //var testItem = TestItem(name="Test Item",date=Some(DateTime.now))
	      val jsonStr:String = TestItem.toCompactJson(testItem)  
	      println(jsonStr)
	      val newItem = TestItem.fromJSON(jsonStr) 
	      println("Date objectis "+newItem.date.get.getDate())
	      newItem must not be null
      }
    } tag("testItem") 
    
     "be converted from Json " in new  TestScope {
      running (FakeApp) {
    	  
    	  //Please note that this string was generated from a TestItem class with java.util.Date
    	  //val jsonStr = "{\"_id\":{\"$oid\":\"5054a2d3ba5218730ec6c18c\"},\"name\":\"Test Item\",\"date\":\"2012-09-15T15:46:27Z\"}"
    	  //val jsonStr = "{\"name\":\"Test Item\",\"date\":\"2012-09-15T15:46:27Z\"}"
    	  val jsonStr = "{\"name\":\"Test Item\",\"date\":1347736384920}" 
    	   
    	    
    	  var testItem = TestItem.fromJSON(jsonStr)
	      val newJsonStr= TestItem.toCompactJson(testItem) 
	      println(newJsonStr)

	      newJsonStr  must not be null
      }
    } tag("testItem") 
    
  }
  
  
  
}