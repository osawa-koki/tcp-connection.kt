
fun main(args: Array<String>) {
  // Press Opt+Enter with your caret at the highlighted text to see how
  // IntelliJ IDEA suggests fixing it.
  println("")
  println("----- Hello and welcome! -----")
  println("")
  try {
    val server = Server()
    server.start()
    Client.run()
    println("All completed!")

    // プログラムを終了する。
    System.exit(0)
  } catch (e: Exception) {
    e.printStackTrace()
  }
}
