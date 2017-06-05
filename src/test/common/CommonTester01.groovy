package test.common

import groovy.transform.ToString

class CommonTester01 {

	@ToString(includeNames=true)
	static class Person {
		String name
		int age
		def description
	}

	static void test() {
		Person p = new Person()
		def num = 123
		List<Person> list = []
		list[0] = p
		list[1] = 242 //by default generic types are not enforced
		println list[0]
		//println list[0].name.class //null pointer exception because 'name' is null
		println list[0].name?.class //null safe operator is used
		println list[1]
		println new Person(name : "Asen") //named parameter constructor
		// Strings enclosed in "" (double quotes) are Groovy Strings and can reference
		// variables like "$var" or execute Groovy code inside them
		2.times { println "Executed several times $num" }
		// Strings enclosed in '' (single quotes) are Java Strings
		2.times { println 'Executed several times $num' }
	}
}