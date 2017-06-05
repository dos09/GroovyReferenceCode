package test.common

class MetaClassTester {
	static class Animal {
	}
	static void test() {
		//add properties/methods to class
		Animal.metaClass.name = "Dog"
		Animal.metaClass.bark = { println "Barking animal" }
		Animal a = new Animal();
		println a.name
		a.bark();
	}

}