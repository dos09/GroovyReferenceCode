package test.delegate_missing

import groovy.transform.ToString

class GradleUsedDelegateAndMIssingTester {
	
	static void testAll() {
		testDelegate()
		testMissingMethodProperty() //and some stuff used in gradle
	}
	
	static void testDelegate() {
		Orc orc = new Orc(name : "Mogka")
		Undead undead = new Undead()
		def c1 = {
			println "This closure's delegate = $delegate"
			println "delegate.name = $delegate.name"
		}
		c1.setDelegate(orc)
		c1()
		c1.setDelegate(undead)
		c1()
	}

	static void testMissingMethodProperty() {
		Orc orc = new Orc();
		orc.no = 4
		orc.such
		orc.thing("exists")
		orc.say("Ole")
		orc.callClosure {
			//This is the principle used in Gradle
			say "At last"
			say (what1 : "111", what2 : "222")
			fake "one"
			sayMap "a" : "AAAA", "b":"BBBB", c : "CCCC"
		}
	}
}

@ToString(includeNames=true)
class Orc {
	def name = "Unknown orc"
	def hp = 100

	void callClosure(closure) {
		//this principle is used in Gradle
		closure.setDelegate(this)
		closure()
	}

	void sayMap(map) {
		println "sayMap:"
		map.each({ entry -> println "[$entry.key $entry.value]" })
		println map["a"] + " " + map[noSuchThing]
	}

	void say(what) {
		println "The orc said: $what"
	}

	def methodMissing (String name, args){
		println "Missing method '$name', called with args = '$args'"
	}

	//missing setter
	def propertyMissing(String name, value) {
		println "Trying to set missing property '$name' with value = '$value'"
	}

	//missing getter
	def propertyMissing(String name) {
		println "Trying to get missing property '$name'"
	}
}

@ToString(includeNames=true)
class Undead {
	def name = "Unknown undead"
	def hp = 100
}