package scalaworkshop

object HelloWorld extends App {

   // mutable vs immutable
   
	val greeting = "Hello "
	var recipient  = "world"

	def setGreetingRecipient(recipient: String = "world") : Unit = {
		this.recipient =  recipient
	}


	setGreetingRecipient("guys")
	println(s"${greeting} ${recipient}")

	setGreetingRecipient()
	println(recipient)


    // lazy init

	lazy val initLater =  {   
		println("initialized")
 
	}

    val initNow = {
		println("init now")
	}

	initLater


	// call by name

	def callByName(block: => Unit ) = {
		println("There will be a greeting")
		block
		println("I've told you")
	}


	callByName({
		 setGreetingRecipient("everyone");println(s"""${greeting} for "${recipient}" """)
	})

   // currying

	def createGreeting(printGreeting: String => Unit)(recipient: String) = {
		printGreeting(recipient)
	}

	
	createGreeting { 
	 p =>	println(s"'${greeting}"+ p +"'")
	}("and goodbye")

	val formattedGreeting =  createGreeting {  p:String =>	println(s"'${greeting}"+ p +"'") } _

	formattedGreeting("last time")


	// implicit


    def  createImplicitGreeting(recipient:String)(implicit printGreeting: String => Unit) = printGreeting(recipient)

	implicit val implicitFormatter =  { p:String => println(s"*${p}*") }

	createImplicitGreeting("I'm seek and tired of saying hello")
 


   // closure

	val greetingFormatter :  String => String = p =>  s"""$p $recipient !"""

    println(greetingFormatter("Hi"))

}