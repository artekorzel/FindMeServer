package controllers

import play.api.mvc._
import model.Tables
import requests._
import requests.RequestHelpers._
import play.api.db.slick.DB
import play.api.Play.current
import play.api.db.slick.Config.driver.simple._

object MobileApi extends Controller {

  def saveLocation = Action(parse.json) { implicit request =>
    request.body.validate[LocationRequest].fold(
      valid = res => {
        DB.withSession { implicit session =>
          Tables.locations.insert(res.location)
        }
        Ok
      },
      invalid = e => BadRequest(e.toString())
    )
  }
}
