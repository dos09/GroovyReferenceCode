package test.common;

import groovy.transform.ToString

class ListTester {
	@ToString(includeNames=true)
	static class Warrior {
		def name
		def hp
	}

	static void test() {
		List list = [];
		list[0] = new Warrior(hp : 100)
		list[list.size()] = new Warrior(hp : 200)
		list.add(new Warrior(hp : 300))
		println list
		println list.hp
		def hps = list.hp
		def joined = hps.join("___")
		println joined
		println joined.class
		//The spread dot operator (spread-dot operator) *. is used to invoke a method on
		//all members of a Collection. The result of this operation is another Collection object.
		List numbers = [1, 2, 34]
		println numbers
		def otherList = numbers*.plus(10)
		println otherList
	}
}