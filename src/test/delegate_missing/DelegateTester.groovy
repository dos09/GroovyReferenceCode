package test.delegate_missing

import groovy.transform.ToString

class DelegateTester {
	@ToString(includeNames=true)
	static class Orc {
		def name = "Unknown orc"
		def hp = 100
	}

	@ToString(includeNames=true)
	static class Undead {
		def name = "Unknown undead"
		def hp = 100
	}

	static void test() {
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
}
