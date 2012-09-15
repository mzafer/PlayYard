package test

import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import play.api.test.FakeApplication
import play.api.test.Helpers._
import org.bson.types.ObjectId
import model.TestItem
import org.specs2.mutable.Tags
import com.novus.salat.global._
import java.util.Date
import org.bson.BSON

import org.scala_tools.time.Imports.DateTime

class TestSpec extends Specification with Tags{

  object FakeApp extends FakeApplication()
  
  "Test Item" should {
    "be converted to Json " in {
      running (FakeApp) {
        
    	 // val decHooks = BSON.getDecodingHooks(classOf[java.util.Date])
    	 // println(decHooks.get(0).toString())
    	   	
    	  var testItem = TestItem(name="Test Item",date=Some(new Date()))
    	  //var testItem = TestItem(name="Test Item",date=Some(DateTime.now))
	      val jsonStr:String = TestItem.toCompactJson(testItem)  
	      println(jsonStr)
	      val newItem = TestItem.fromJSON(jsonStr) 
	      newItem must not be null
      }
    } tag("testItem") 
    
     "be converted from Json " in {
      running (FakeApp) {
    	  
    	  //Please note that this string was generated from a TestItem class with java.util.Date
    	  val jsonStr = "{\"_id\":{\"$oid\":\"5054a2d3ba5218730ec6c18c\"},\"name\":\"Test Item\",\"date\":\"2012-09-15T15:46:27Z\"}"
   	  
    	  var testItem = TestItem.fromJSON(jsonStr)
	      val newJsonStr= TestItem.toCompactJson(testItem) 
	      println(newJsonStr)

	      newJsonStr  must not be null
      }
    } tag("testItem") 
    
  }
  
  
  
}