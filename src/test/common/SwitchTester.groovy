package test.common;

import groovy.transform.ToString

class SwitchTester {
	@ToString(includeNames=true)
	static class Warrior {
		def name
		def hp
	}

	static void test() {
		assert 'Object equals' == testingSwitch(51)
		assert 'Pattern match' == testingSwitch("Regular pattern matching")
		assert 'Range contains' == testingSwitch(13)
		assert 'List contains' == testingSwitch('Ubuntu')
		assert 'Closure boolean' == testingSwitch(9)
		assert 'Class isInstance' == testingSwitch('This is an instance of String')
		assert 'Default' == testingSwitch(200)
		def war1, war2
		war1 = new Warrior(name : "Olo", hp : 200)
		war2 = new Warrior(name : "Mogka", hp :300)
		println war1
		println war2
		
		def warriors = [war1, war2]
		println warriors
		println war1 in warriors
	}
	
	//To use your custom class in a switch statement implement the isCase method
	static testingSwitch(input) {
		def result
		switch (input) {
			case 51:
				result = 'Object equals'
				break
			case ~/^Regular.*matching/:
				result = 'Pattern match'
				break
			case 10..50:
				result = 'Range contains'
				break
			case ["Ubuntu", 'Android', 5, 9.12]:
				result = 'List contains'
				break
			case { it instanceof Integer && it < 50 }:
				result = 'Closure boolean'
				break
			case String:
				result = 'Class isInstance'
				break
			default:
				result = 'Default'
				break
		}
		result
	}
}