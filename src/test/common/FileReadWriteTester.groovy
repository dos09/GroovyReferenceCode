package test.common

class FileReadWriteTester {
	static void test() {
		File file = new File("data")
		String fileData1 = file.text;
		println fileData1
		println "---------"
		def lineNum = 0;
		//in a groovy string you can execute and code
		file.eachLine { line -> println "${++lineNum}. $line" }
		println "---------"
		//file.write("new stuff")
		file.append("\nappended text (append time: ${new Date().format("yyyy-MM-dd HH:mm:ss")})")
		println "new file contents:"
		println file.text
	}
}