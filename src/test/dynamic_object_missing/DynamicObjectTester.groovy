package test.dynamic_object_missing;

import java.util.Map;

class DynamicObjectTester {
	static void test() {
		LikeJavaScriptObject.test()
		def banana = new DynamicBanana()
		println banana.bananaName
		println "banana.color is not set and has value: " + banana.color
		banana.color = "green"
		println "banana.color is already set and has value: " + banana.color
	}
}

// use a class as javascript object
class LikeJavaScriptObject {
	private Map props = [:]

	def propertyMissing(String propName) {
		props[propName]
	}

	def propertyMissing(String propName, def value) {
		props[propName] = value
	}

	static void test() {
		LikeJavaScriptObject obj = new LikeJavaScriptObject()
		obj.name = "Minimal"
		obj.status = "painful"
		println obj.props
	}}

	// another option is to put the above behavior in a trait, like that you can
	// pass it to different classes
trait DynamicObject{
	private Map props = [:]

	def propertyMissing(String propName) {
		props[propName]
	}

	def propertyMissing(String propName, def value) {
		props[propName] = value
	}
}

class DynamicBanana implements DynamicObject {
	def bananaName = "Gosho"
}