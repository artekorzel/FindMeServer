package model

import play.api.db.slick.Config.driver.simple._

case class Location(id: Option[Long], date: java.sql.Timestamp, latitude: Double, longitude: Double)

object Tables {
  class Locations(tag: Tag) extends Table[Location](tag, "locations") {
    def id: Column[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    def date: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date")
    def latitude: Column[Double] = column[Double]("latitude")
    def longitude: Column[Double] = column[Double]("longitude")
    def * = (id.?, date, latitude, longitude) <> (Location.tupled, Location.unapply)
  }

  val locations = TableQuery[Locations]
}