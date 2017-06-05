package test.common

import groovy.transform.ToString

class OperatorOverloading {

	@ToString(includeNames=true)
	static class Warrior {
		def name
		def hp
		//override the + operator
		Warrior plus(other) {
			if(other == null) {
				new Warrior(hp : this.hp)
			} else {
				new Warrior(hp : this.hp + other.hp)
			}
		}

		//override the - operator
		Warrior minus(other) {
			if(other == null) {
				new Warrior(hp : this.hp)
			} else {
				new Warrior(hp : this.hp - other.hp)
			}
		}
	}

	static void test() {
		for(num in 1..3) {
			print num + " "
		}
		for(symbol in 'a'..'d') {
			print symbol + " "
		}
		print "\n"
		Warrior war1 = new Warrior(hp : 20)
		Warrior war2 = new Warrior(hp : 30)
		println war1
		println war2
		println war1 + war2
		println war1 + null
		def str, bStr, abcStr
		str = "abcdabcdABCD"
		bStr = "b"
		abcStr = "abc"
		println "original string is: " + str
		println str - bStr
		println str - abcStr
		println str + bStr
		println str << bStr
	}
}