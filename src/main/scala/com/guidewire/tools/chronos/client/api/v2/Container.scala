package com.guidewire.tools.chronos.client.api.v2

import play.api.libs.json._

/**
 * @author - Eran Withana (ewithana@comprehend.com) 
 */

case class Volume(containerPath: String,
                  hostPath: String,
                  mode: String)

object Volume {
  implicit val reads = Json.reads[Volume]
  implicit val writes = Json.writes[Volume]
}

case class Container(image: String,
                     containerType: String = "DOCKER",
                     network: String = "BRIDGE",
                     volumes: Seq[Volume] = Seq.empty) {

}

object Container {
  implicit val containerWrites = new Writes[Container] {
    override def writes(o: Container): JsValue = {
      val baseObj: JsObject = Json.obj(
                                    "image" -> o.image,
                                    "type" -> o.containerType,
                                    "network" -> o.network
                                  )

      if (o.volumes.isEmpty) baseObj else {
        baseObj ++ Json.obj("volumes" -> o.volumes)
      }
    }
  }

  implicit val containerReads = new Reads[Container] {
    override def reads(json: JsValue): JsResult[Container] = {
      JsSuccess(Container(
                           (json \ "image").as[String],
                           (json \ "type").as[String],
                           (json \ "network").as[String],
                           (json \ "volumes").as[Seq[Volume
                           ]]
                         ))
    }
  }
}
