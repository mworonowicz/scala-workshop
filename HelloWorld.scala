package scalaworkshop

object HelloWorld extends App {

	val greeting = "Hello "
	var recipient  = "world"


	val initNow = {
		println("init now")
	}

	lazy val initLater =  {   
		println("initialized")
 
	}

	def setGreetingRecipient(recipient: String = "world") : Unit = {
		this.recipient =  recipient
	}


	def callByName(block: => Unit ) = {
		println("There will be a greeting")
		block
		println("I've told you")
	}


	def createGreeting(printGreeting: String => Unit)(recipient: String) = {
		printGreeting(recipient)
	}

	setGreetingRecipient("guys")
	println(s"${greeting} ${recipient}")

	setGreetingRecipient()
	println(recipient)
	initLater

	callByName({
		 setGreetingRecipient("everyone");println(s"""${greeting} for "${recipient}" """)
	})

	createGreeting { 
	 p =>	println(s"'${greeting}"+ p +"'")
	}("and goodbye")

	val formattedGreeting =  createGreeting {  p:String =>	println(s"'${greeting}"+ p +"'") } _

	formattedGreeting("last time")

    def  createImplicitGreeting(recipient:String)(implicit printGreeting: String => Unit) = printGreeting(recipient)

	implicit val implicitFormatter =  { p:String => println(s"*${p}*") }

	createImplicitGreeting("I'm seek and tired of saying hello")

}