# PlayYard

Test project using Play and Scala. Requires play 2.0.2



To run the test cases 

	C:\Projects\PlayYard>play
	[PlayYard] $ test
	
To run the Rest API cases 

	C:\Projects\PlayYard>play
	[PlayYard] $ run
	
and use a REST client to send below requests

1. Create a item with date as timestamp - Not working as expected, To be tested with TimestampDateStrategy in custom salat context (refer util.salat_context ). Records gets saved but the return JSON has negative timestamp. 

	POST http://localhost:9000/item
	with data: {"name":"Test Item","date":1347721297674}	

2. Create a item with regular date - Working without any 

	POST http://localhost:9000/item. Tested with default Timestamp strategy and works
	with data: {"name":"Test Item","date":"2012-09-15T15:46:27Z"}

3. To get an item

	GET http://localhost:9000/item/:id
	

