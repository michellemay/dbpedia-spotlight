package org.dbpedia.spotlight.db.memory

import org.dbpedia.spotlight.db.model.OntologyTypeStore
import java.util.HashMap
import org.dbpedia.spotlight.model.{Factory, OntologyType, OntologyTypeID}
import java.lang.String

/**
 * @author Joachim Daiber
 *
 */

@SerialVersionUID(1004001)
class MemoryOntologyTypeStore
  extends MemoryStore
  with OntologyTypeStore {

  var idFromName: HashMap[String, OntologyTypeID] = null
  var ontologyTypeFromID: HashMap[OntologyTypeID, OntologyType] = null

  def size = idFromName.size

  def getOntologyType(id: OntologyTypeID): OntologyType = {
    ontologyTypeFromID.get(id)
  }

  def getOntologyTypeByName(name: String): OntologyType = {
    getOntologyType(idFromName.get(Factory.OntologyType.fromQName(name).typeID))
  }

  def getOntologyTypeByURL(url: String): OntologyType = {
    getOntologyType(idFromName.get(Factory.OntologyType.fromURI(url).typeID))
  }



}
