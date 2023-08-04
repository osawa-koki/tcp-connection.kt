import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Client {
  companion object {
    fun run() {
      try {
        Socket("localhost", 8000).use { socket ->
          PrintWriter(socket.getOutputStream(), true).use { writer ->
            BufferedReader(InputStreamReader(socket.getInputStream())).use { reader ->
              writer.println("GET / HTTP/1.1")
              writer.println("Accept: text/plain")
              writer.println("Content-Type: text/plain; charset=utf-8")
              writer.println("Host: localhost:8000")
              writer.println("User-Agent: Kotlin/1.8.0_181")
              writer.println("")
              writer.println("1: Apple")
              writer.println("2: Banana")
              writer.println("3: Cherry")
              writer.println("4: Durian")
              writer.println("5: Eggplant")
              writer.flush()
              var line: String? = null
              while (reader.ready()) {
                line = reader.readLine()
                println("🔵 Client: $line")
              }
            }
          }
        }
      } catch (e: Exception) {
        e.printStackTrace()
      }
    }
  }
}
