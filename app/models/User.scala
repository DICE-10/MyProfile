package models

import play.data.validation.Constraints
import io.ebean.Model
import io.ebean.Finder
import javax.persistence.Entity;
import javax.persistence.Id


@Entity
class User() extends Model{

  def finder() = new Finder[Long, User](classOf[User])
  @Id
  private var id:Long = 0

  @Constraints.Required
  private var name:String = null

  @Constraints.Required
  private var text:String = null

  def getId():Long = id
  def setId(_id: Long): Unit ={
    this.id = _id
  }
  def getName():String = name
  def setName(_name:String): Unit = {
    this.name = _name
  }

  def getText():String = text
  def setText(_text: String):Unit={
    this.text = _text
  }

 }