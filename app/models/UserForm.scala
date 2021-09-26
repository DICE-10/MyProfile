package models

import play.data.validation.Constraints

class UserForm () {
  @Constraints.Required(message="必須入力です")
  @Constraints.MaxLength(value=255, message="255文字以下にしてください。")
  private var name:String = null

  @Constraints.Required(message="必須入力です")
  @Constraints.MaxLength(value=255, message="255文字以下にしてください。")
  private var text:String = null

  def getName() = name
  def setName(_name:String): Unit ={
    this.name = _name
  }

  def getText() = text
  def setText(_text:String): Unit ={
    this.text = _text
  }
}
