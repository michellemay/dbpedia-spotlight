/*
 * Copyright 2011 Pablo Mendes, Max Jakob
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Check our project website for information on how to acknowledge the authors and how to contribute to the project: http://spotlight.dbpedia.org
 */

package org.dbpedia.spotlight.model

import java.lang.{Integer, String}

/**
 * Representation of types (DBpedia, Freebase, Schema.org, etc.)
 *
 * @author maxjakob
 * @author Joachim Daiber
 * @author pablomendes (introduced and fixed bug for OntologyType.equals :)
 * @author dirk.weissenborn (introduced opencyc)
 */

trait OntologyType extends Serializable {
      def getFullUri: String
      def typeID: String = "OntologyTypeUnknown"

      var id: Integer = 0.toInt

      override def hashCode() : Int = {
        typeID.hashCode()
      }

      override def equals(other : Any) : Boolean = {
          if (other==null)
               false
          else
            other match {
                case o: OntologyType => o.typeID != null && o.typeID.equals(typeID)
                case _ => false;
            }
      }

      override def toString = typeID
}

/**
 * Types from the DBpedia ontology (hierarchical)
 */


@SerialVersionUID(8037662401509425326l)
class DBpediaType(var name : String) extends OntologyType {

    name = name.replace(DBpediaType.DBPEDIA_ONTOLOGY_PREFIX, "")

    name = name.replace("DBpedia:","")

    name = name.capitalize

    name = name.replaceAll(" ([a-zA-Z])", "$1".toUpperCase).trim

    def equals(that : DBpediaType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri =  if (name.toLowerCase.startsWith("http")) name else DBpediaType.DBPEDIA_ONTOLOGY_PREFIX + name
    override def typeID = if (name.toLowerCase.startsWith("http")) name else "DBpedia:".concat(name)

}

object DBpediaType {
    val DBPEDIA_ONTOLOGY_PREFIX = SpotlightConfiguration.DEFAULT_ONTOLOGY_PREFIX
    val UNKNOWN = new DBpediaType("unknown")
}


/**
 * Types from Freebase: non-hierarchical, grouped into domains.
 */

@SerialVersionUID(8037662401509425325l)
class FreebaseType(val domain: String, val typeName: String) extends OntologyType {

  override def getFullUri = FreebaseType.FREEBASE_RDF_PREFIX + domain + "." + typeName
  override def typeID = {
    var typeID = "Freebase:/" + domain

    if(typeName != null) {
      typeID += "/" + typeName
    }

    typeID
  }
}

object FreebaseType {

  def fromTypeString(typeString: String) : FreebaseType = {
    val typeParts: Array[String] = typeString.replace(FREEBASE_RDF_PREFIX, "").split("/")

    var domain: String = null
    var theType: String = null
    typeParts.length match {
      case 0 =>
      case 1 => domain = typeParts(0)
      case 2 => domain = typeParts(1)
      case _ => {domain = typeParts(1); theType = typeParts(2)}
    }

    new FreebaseType(domain, theType)
  }

  val FREEBASE_RDF_PREFIX = "http://rdf.freebase.com/ns"
}

@SerialVersionUID(8037662401509425324l)
class SchemaOrgType(var name : String) extends OntologyType {

    name = name.replace(SchemaOrgType.SCHEMAORG_PREFIX, "")

    def equals(that : SchemaOrgType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = SchemaOrgType.SCHEMAORG_PREFIX + name
    override def typeID = "Schema:" + name

   // override def toString = "%s/%s".format(SchemaOrgType.SCHEMAORG_PREFIX,name)

}

object SchemaOrgType {
    val SCHEMAORG_PREFIX = "http://schema.org/"
}


@SerialVersionUID(8037662401509425323l)
class OpenCycConcept(var name : String) extends OntologyType {

    name = name.replace(OpenCycConcept.OPENCYCCONCEPT_PREFIX, "")

    def equals(that : OpenCycConcept) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = OpenCycConcept.OPENCYCCONCEPT_PREFIX + name
    override def typeID = "OpenCyc:" + name
}

object OpenCycConcept {
    val OPENCYCCONCEPT_PREFIX = "http://sw.opencyc.org/concept/"
}

@SerialVersionUID(8037662401509425322l)
class YagoType(var name : String) extends OntologyType {

    name = name.replace(YagoType.YAGO_PREFIX, "")

    def equals(that : YagoType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = YagoType.YAGO_PREFIX + name
    override def typeID = "Yago:" + name
}

object YagoType {
    val YAGO_PREFIX = "http://dbpedia.org/class/yago/"
}

@SerialVersionUID(8037662401509425321l)
class FOAFType(var name : String) extends OntologyType {

    name = name.replace(FOAFType.FOAF_PREFIX, "")

    def equals(that : FOAFType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = FOAFType.FOAF_PREFIX + name
    override def typeID = "FOAF:" + name
}

object FOAFType {
    val FOAF_PREFIX = "http://xmlns.com/foaf/0.1/"
}

@SerialVersionUID(8037662401509425320l)
class DULType(var name : String) extends OntologyType {

    name = name.replace(DULType.DUL_PREFIX, "")

    def equals(that : DULType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = DULType.DUL_PREFIX + name
    override def typeID = "DUL:" + name
}

object DULType {
    val DUL_PREFIX = "http://www.ontologydesignpatterns.org/ont/dul/DUL.owl#"
}

@SerialVersionUID(8037662401509425319l)
class WikidataType(var name : String) extends OntologyType {

    name = name.replace(WikidataType.WIKIDATA_PREFIX, "")

    def equals(that : WikidataType) : Boolean = {
        name.equalsIgnoreCase(that.name)
    }

    override def getFullUri = WikidataType.WIKIDATA_PREFIX + name
    override def typeID = "Wikidata:" + name
}

object WikidataType {
    val WIKIDATA_PREFIX = "http://wikidata.dbpedia.org/resource/"
}
