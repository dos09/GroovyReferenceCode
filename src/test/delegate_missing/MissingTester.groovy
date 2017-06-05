package test.delegate_missing

class MissingTester {
	static void test() {
		def test = new AnyMethodExecutor ();
		// you can call any method you like on this class
		assert "This method is just fake" == test.hall();
		assert "This method is just fake" == test.tralala();
		assert "Still a fake method but 'hello' back to you." == test.helloMethod();

		// setting is basically ignored
		test.test= 35;
		test.superDuperCool= 100

		// all properties return 5
		assert test.superDuperCool == 5
		assert test.value == 5;

		test.printValue()
		test.value = 34343
		test.printValue()
	}
}
class AnyMethodExecutor{
	// Should get ignored
	String value ="Lars"

	// always return 5 no matter which property is called
	Object getProperty (String property){
		println "Trying to get property $property"
		return 5;
	}

	void setProperty (String property, Object o ){
		println "Trying to set property $property with value $o"
		// ignore setting
	}

	def methodMissing (String name, args){
		println "Missing method: $name, args =  $args"
		def s = name.toLowerCase();
		if (!s.contains("hello")) {
			return "This method is just fake"
		} else {
			return "Still a fake method but 'hello' back to you."

		}
	}

	void printValue () {
		println "Value: $value"
	}
}