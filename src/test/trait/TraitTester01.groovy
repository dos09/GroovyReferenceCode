package test.trait

import groovy.transform.ToString

class TraitTester01 {
	static void test() {
		def orc = new Orc(name : "Mogka")
		orc.talk()
		println "warrior's title: " + orc.getWarriorRank()
		println "the orc attacks with: " + orc.attack()
		println "now the orc attacks with: " + orc.useKnightAttack()
		println "honor points: $orc.honorPoints"
		orc.die()
		String str = "x";
		println "the result is not an instance of the original object: " + (str as Knight).attack()
	}
	
	/*-
	 avoids the diamond problem (https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem)
	 by invoking the method from the last trait having method name conflict (default behavior)
	 e.g.: orc.attack(),
	 to specify explicitly can use Knight.super.attack()
	 */
	@ToString(includeNames = true)
	static class Orc implements Knight, Warrior {
		def name = "Unnamed"
		def hp = 1000
	
		def talk() {
			println "orc \"$name\" is talking"
		}
	
		@Override
		String getWarriorRank() {
			return "Warmonger"
		}
	
		@Override
		public void die() {
			println "the orc died"
		}
	
		String useKnightAttack() {
			Knight.super.attack()
		}
	}
	
	trait Charger {
		def chargeDistanceYards = 10
		void charge() {
			println "Charger charged"
		}
	}
	//A trait can extends only one trait, but can implement multiple traits
	//couldn't find any difference between extending and implementing trait except that: (extends 1, implements 1 or more)
	trait Warrior extends Charger implements IKillable {
		abstract String getWarriorRank()
		String attack() {
			"warrior's attack"
		}
	}
	//a trait can't have constructor and can't be directly instantiated
	trait Knight implements IKillable {
		int honorPoints = 100
	
		String attack() {
			"knight's attack"
		}
	}
	
	interface IKillable {
		void die()
	}
}


/*-
 trait A { void methodFromA() {
 println "aaaA"
 } }
 trait B { void methodFromB() {
 println "bbbB"
 } }
 class C {}
 def c = new C()
 def d = c.withTraits A, B
 d.methodFromA()
 d.methodFromB()
 */

