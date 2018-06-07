package controllers

import javax.inject.Inject
import models._
import play.api.data._
import play.api.data.Forms._
import play.api.mvc._

class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) with play.api.i18n.I18nSupport {
  /* Formを定義 */
  val userForm = Form(
    // モデル User とマッピング
    // mapping ( "カラム名" -> 型名 )
    mapping(
      "account" -> nonEmptyText,
      "email" -> nonEmptyText,
      "kenpos_id" -> nonEmptyText,
      "kenpos_passwd" -> nonEmptyText)(User.apply)(User.unapply)
  )

  /* テンポラリー表示用 */
  def entryInit = Action {
    implicit request =>
      // Form.fill：既存の値で埋める。フォームを編集する用途で使用する
      val filledForm = userForm.fill(User("Taro_Kenpos1", "Taro@Kenpos.co.jp", "sss012345", "*****"))
      Ok(views.html.tags.entry(filledForm))
  }

  /* 登録用関数 */
  def entrySubmit = Action {
    implicit request =>
      // bindFromRequest.get or fold でリクエストからフォーム情報を取得。エラー処理を行えるfoldを推奨。getの場合は取得に失敗すると例外をスロー
      userForm.bindFromRequest.fold(
        formWithErrors => {
          println("entrySubmit:Error" + formWithErrors)
          BadRequest(views.html.tags.entry(formWithErrors))
        },
        userData => {
          println(userData)
          Ok(views.html.tags.enrtySubmit())
        }
      )
  }
}
