package test.common;

class MultilineStringTester {

	static void test() {
		String multilineStr = """once
upon
a time"""
		println multilineStr
		String multilineStr2 = '''and
the
story goes on
'''
		println multilineStr2
	}
}
