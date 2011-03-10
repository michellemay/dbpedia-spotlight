///**
// * Copyright 2011 Andrés García-Silva
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// * http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//// Package
/////////////////
//package dbpediaontology2xml;
//
//
//// Imports
/////////////////
//import com.hp.hpl.jena.ontology.*;
//import com.hp.hpl.jena.rdf.model.ModelFactory;
//
//
///**
// * <p>
// * Execution wrapper for class hierarchy example
// * </p>
// *
// * @author Ian Dickinson, HP Labs
// *         (<a  href="mailto:ian_dickinson@users.sourceforge.net" >email</a>)
// * @version CVS $Id: Main.java,v 1.3 2009/10/06 13:04:43 ian_dickinson Exp $
// */
//public class Main {
//    // Constants
//    //////////////////////////////////
//
//    // Static variables
//    //////////////////////////////////
//
//    // Instance variables
//    //////////////////////////////////
//
//    // Constructors
//    //////////////////////////////////
//
//    // External signature methods
//    //////////////////////////////////
//
//    public static void main( String[] args ) throws Exception {
//        OntModel m = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
//
//        // we have a local copy of the wine ontology
//        //m.getDocumentManager().addAltEntry( "http://www.w3.org/2001/sw/WebOnt/guide-src/wine",
//        //                                    "file:C:/impl/lib/Jena-2.6.3/testing/reasoners/bugs/wine.owl" );
//        m.getDocumentManager().addAltEntry( "http://dbpedia.org/ontology/",
//                                            "file:dbpedia_3.5.1.owl" );
//
//
////        m.getDocumentManager().addAltEntry( "http://www.w3.org/2001/sw/WebOnt/guide-src/wine.owl",
////                                            "file:C:/impl/lib/Jena-2.6.3/testing/reasoners/bugs/wine.owl" );
////        m.getDocumentManager().addAltEntry( "http://www.w3.org/2001/sw/WebOnt/guide-src/food",
////                                            "file:C:/impl/lib/Jena-2.6.3/testing/reasoners/bugs/food.owl" );
////        m.getDocumentManager().addAltEntry( "http://www.w3.org/2001/sw/WebOnt/guide-src/food.owl",
////                                            "file:C:/impl/lib/Jena-2.6.3/testing/reasoners/bugs/food.owl" );
//
//        //m.read( "http://www.w3.org/2001/sw/WebOnt/guide-src/wine" );
//        m.read( "http://dbpedia.org/ontology/" );
//
//        new CustomClassHierarchy().showHierarchy( m );
//
//
//    }
//
//
//    // Internal implementation methods
//    //////////////////////////////////
//
//    //==============================================================================
//    // Inner class definitions
//    //==============================================================================
//
//}
//