package requests

import model.Location
import play.api.libs.json._

case class LocationRequest (location: Location)

object RequestHelpers {

  implicit val timestampReads: Reads[java.sql.Timestamp] =
    __.read[Long].map{ millis => new java.sql.Timestamp(millis) }

  implicit val locationReads = Json.reads[Location]

  implicit val locationRequestReads = Json.reads[LocationRequest]

}