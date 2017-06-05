package test.common;

import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.transform.ToString

class MetaClassAndJSONTester {
	
	static void test() {
		testJson()
		testAddMethodToClass()
	}
	
	@ToString(includeNames = true)
	static class Warrior {
		def name
		def hp
	}

	static void testJson() {
		println "Test JSON"
		def war = new Warrior(name : "Mogka", hp : 1300)
		JsonBuilder b = new JsonBuilder(war)
		println war
		println b.toString() + "\n"
		println b.toPrettyString() + "\n"
		println JsonOutput.prettyPrint(b.toString()) + "\n"

		def jsonSlurper = new JsonSlurper();
		def obj = jsonSlurper.parseText(b.toString())
		println obj
		println obj.name
	}

	static void testAddMethodToClass() {
		//the "->" without parameters on the left side will not allow the closure to be called
		//with arguments
		//{ -> some code... }

		//https://stackoverflow.com/questions/8120949/what-does-delegate-mean-in-groovy
		String.metaClass.appendToString = { -> appendToString(delegate) }

		println '12345'.appendToString()

		String.metaClass.anotherAppend = { -> delegate << "444" }
		println "seven".anotherAppend()
	}

	static def appendToString(String s){
		s<<"AAAAAAAAAA"
	}
}