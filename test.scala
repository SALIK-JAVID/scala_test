import scala.collection.mutable

// Generic Key-Value Database
class SimpleDatabase[T] {
  private val storage = mutable.Map[String, T]()

  // Store a key-value pair
  def put(key: String, value: T): Unit = {
    storage(key) = value
    println(s"Added: $key -> $value")
  }

  // Retrieve a value by key
  def get(key: String): Option[T] = {
    storage.get(key) match {
      case Some(value) => Some(value)
      case None =>
        println(s"Key '$key' not found.")
        None
    }
  }

  // Delete a key-value pair
  def delete(key: String): Unit = {
    if (storage.contains(key)) {
      storage.remove(key)
      println(s"Deleted: $key")
    } else {
      println(s"Key '$key' does not exist.")
    }
  }

  // Display all key-value pairs
  def display(): Unit = {
    if (storage.isEmpty) {
      println("Database is empty.")
    } else {
      println("Stored Key-Value Pairs:")
      storage.foreach { case (key, value) => println(s"$key -> $value") }
    }
  }
}

// Example Usage
object Main extends App {
  val db = new SimpleDatabase[String]()

  db.put("name", "John Doe")
  db.put("age", "30")

  println(s"Retrieved: ${db.get("name").getOrElse("Not Found")}")
  
  db.delete("age")
  db.display()
}