package services

import akka.actor.ActorSystem
import play.api.db.Database
import play.api.libs.concurrent.CustomExecutionContext

import java.sql.{Connection, DriverManager, ResultSet, SQLException, Statement}
import javax.inject.Inject
import scala.concurrent.Future

class MySQLDatabase @Inject() (db: Database, databaseExecutionContext: DatabaseExecutionContext){
  def updateSomething(): Unit = {
    Future {
      // get jdbc connection
      val conn = db.getConnection()
      val state = conn.createStatement()
      val res = state.executeQuery("show tables")
      while (res.next()){
        print(res.getString(1))
      }

      // do whatever you need with the db connection

      // remember to close the connection
      conn.close()
    }(databaseExecutionContext)
  }
}
//@Singleton
class DatabaseExecutionContext @Inject()(system: ActorSystem) extends CustomExecutionContext(system, "database.dispatcher")