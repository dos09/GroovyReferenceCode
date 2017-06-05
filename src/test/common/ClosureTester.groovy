package test.common

class ClosureTester {

	static void test() {
		testClosure()
	}

	static void testClosure() {
		println "TEST OF CLOSURES"
		def c1 = { println "Closure 1" }
		c1()
		def c2 = { int a, int b ->
			println "$a + $b = " + (a + b)
		}
		c2(4, 5)
		def c3 = { a -> println a }
		c3("Something")
		def c4 = { println it //same as above, but shortened
		}
		c4("Else")
		def c5 = { data, closure -> closure(data) }
		c5("Some String", { data -> println "printed from c5: " + data })
		println c5("Another String", { data -> data.toUpperCase() })
		println c5("Another String", { it.toUpperCase() })
		println c5("Another String") { it.toUpperCase() } //same as above, another syntax used
		( { println "Self-invoked closure" } )()
		def inc = ({
			def counter = 0
			return { return ++counter }
		})()
		println inc() + " " + inc() + " " + inc()
		//same as inc() closure but shorter
		def incShorter = ({
			def counter = 0
			//implicit return is for expressions only, closure is not an expression,
			//so here have to use the return keyword
			return { ++counter }
		})()
		println incShorter() + " " + incShorter() + " " + incShorter()
	}
}