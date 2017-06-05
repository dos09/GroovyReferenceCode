package test.trait

import groovy.transform.ToString

//Trait Chaining

class TraitTester02 {
	
	static void printer() {
		println "Finishing the chain"
	}
	
	static void test() {
		def orc = new Orc()
		orc.printer()
		Greeter greeter = { "Alice" } // the closure "becomes" the implementation of the getName single abstract method
		println greeter.greet()
	}
	
	@ToString(includeNames = true)
	static class Orc implements C, B, A, Greeter {
		String name
		def hp
	}
	
	trait Greeter {
		String greet() {
			"Hello $name" //calls getName()
		}
		abstract String getName()
	}
	
	trait A {
		void printer() {
			println "AAA"
			super.printer()
		}
	}
	trait B {
		void printer() {
			println "BBB"
			super.printer() 
		}
	}
	trait C {
		void printer() {
			println "CCC"
			//if a class implements multiple traits and a call to an unqualified super is found, then:
			//- if the class implements another trait, the call delegates to the next trait in the chain
			//- if there isn’t any trait left in the chain, super refers to the super class of the implementing class (this)
			super.printer() 
		}
	}
}
