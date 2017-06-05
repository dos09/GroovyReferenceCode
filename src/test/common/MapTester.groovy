package test.common

class MapTester {

	static void test() {
		testMap()
	}
	
	static void testMap() {
		println "TEST OF MAP"
		def mapA = [:]
		mapA.Asen = 20
		mapA["Iva"] = 30
		mapA['Minka'] = 40
		println mapA
		mapA = [Dingo : 30, "Ringo" : 40, 'Mingo' : 50]
		println mapA
		println mapA.get("Asen")
		//get(key, default) - if key is not found in the map, key:default pair is added and
		//default is returned
		println mapA.get("Asen", 2000)
		println mapA
		
		def mymap = [1:"Jim Knopf", 2:"Thomas Edison", 3:"Lars Vogel"]
		mymap.each {entry -> println (entry.key > 1)}
		//mymap.each ( {entry -> println (entry.key > 1)} ) //same as above with enclosing parenthesis
		print "\n"
		mymap.each {entry -> println (entry.value.contains("o"))}
		println "'Lars' is contained: " + mymap.any {entry -> entry.value.contains("Lars")}
		println "Every key in the map is smaller than 4: " + mymap.every {entry -> entry.key < 4}
		
		mymap.each { key, value ->
			print key + " " + value + "\n"
		}
		print "\n"
		mymap.each { entry ->
			print entry.key + " " + entry.value + "\n"
		}
		//Finds all entries satisfying the condition defined by the closure
		println mymap.findAll { entry -> entry.key >= 2 }
		//Find the first entry satisfying the condition defined by the closure
		println mymap.find { entry -> entry.key >= 2 }
		//get a list of the collected data
		def collected = mymap.collect { entry -> entry.key + "_" + entry.value.toUpperCase() }
		println collected
	}
	
}