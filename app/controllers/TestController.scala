package controllers

import play.api._
import models.User
import models.UserForm
import play.api.mvc._
import play.i18n.MessagesApi
import play.data.FormFactory
import play.data.Form
import collection.mutable._
import javax.inject.Inject
import services.MySQLDatabase
import play.api.db._
import anorm.{BatchSql, SQL, SimpleSql, SqlQueryResult}

import scala.Predef.->

class TestController @Inject()(cc: ControllerComponents,
                               var messageApi: MessagesApi,
                               var formFactory: FormFactory,
                               user: User,
                               userform: UserForm,
                               var users: java.util.List[User]) extends AbstractController(cc)  {
  private var form: Form[UserForm] = formFactory.form(classOf[UserForm])
  this.users = user.finder().all()
  this.messageApi = messageApi

  def index = Action {
    //database.updateSomething()
    Ok(views.html.test("Your new application is ready."))
  }
}
