package test.common

import groovy.transform.ToString

class Each_Times_Upto_DownTo_Tester {
	@ToString(includeNames=true)
	static class Warrior {
		def name
		def hp
	}

	static void test() {
		testTheEachMethod()
		numberSpecials()
	}
	
	static void testTheEachMethod() {
		println "TEST each()"
		def list = [1, 2, 3, 4]
		def map = [one:1, two:2]
		list.each { e -> print e + " " }
		print "\n"
		map.each { entry -> print "[$entry.key $entry.value] "}
		print "\n"
		(1..10).each { print it + " " }
	}
	
	static void numberSpecials() {
		5.times {print "Times + $it "}
		println ""
		1.upto(3) {print "Up + $it "}
		println ""
		4.downto(1) {print "Down + $it "}
	}
}