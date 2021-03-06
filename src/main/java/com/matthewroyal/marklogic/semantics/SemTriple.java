package com.matthewroyal.marklogic.semantics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.csv.CSVRecord;

import com.matthewroyal.marklogic.RDBSchemaModel.RDBSchemaModel;

public class SemTriple {

	public static final String SEM = "sem";
	public static final String SEM_TRIPLE_NAMESPACE = "http://marklogic.com/semantics";

	// RDB namespaces
	public static String NAMESPACE_ROOT = "http://matthewroyal.com/ConvertRDB/";
	public static String RDB = NAMESPACE_ROOT + "rdb#";
	public static String DB = NAMESPACE_ROOT + "db#";
	public static String FK = NAMESPACE_ROOT + "foreignKey#";
	
	/**
	 * Use this namespace when referring to the table itself
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static String TABLE_NAMESPACE(String dbName, String tableName) {
		return String.format("%s%s/table#%s", NAMESPACE_ROOT, dbName, tableName);
	}
	
	/**
	 * Use this namespace when referring to specific data from a table
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static String TABLEDATA_NAMESPACE(String dbName, String tableName) {
		return String.format("%s%s/%s", NAMESPACE_ROOT, dbName, tableName);
	}
	
	
	public String subject = null;
	public String predicate = null;
	public String object = null;
	
	
	public SemTriple() {
	}
	
	public SemTriple(String subject, String predicate, String object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	
	
	
	/**
	 * Write a SemTriple to the incoming XMLStreamWriter
	 * @param xMLStreamWriter
	 * @param triple
	 * @param solitary TRUE = A triple all by itself gets wrapped in a element sem:triples {}. 
	 *                FALSE = It's part of a series of writes, so no outer wrapper is written.
	 * @throws XMLStreamException
	 */
	public static void writeTriple(XMLStreamWriter xMLStreamWriter, SemTriple triple, Boolean solitary) throws XMLStreamException {
		writeTriple(xMLStreamWriter, triple.subject, triple.predicate, triple.object, solitary);
	}

	public static void writeTriple(XMLStreamWriter xMLStreamWriter, List<SemTriple> triple, Boolean solitary) throws XMLStreamException {

		if (null != triple && triple.size() > 0) {
			// Group the collection of triples in their own triples element
			if (solitary) {
				xMLStreamWriter.writeCharacters("\n  ");
		        xMLStreamWriter.writeStartElement(SEM, "triples", SEM_TRIPLE_NAMESPACE);
		        xMLStreamWriter.writeNamespace(SEM, SEM_TRIPLE_NAMESPACE);			
			}
			for (SemTriple t : triple) {
				// Lie to the next method down about solitariness -- it's handled for collections right here
				writeTriple(xMLStreamWriter, t, false);			
			}
		    if (solitary) {
		        xMLStreamWriter.writeCharacters("\n  ");
			    xMLStreamWriter.writeEndElement();
		    }
		}
	}
	
	/**
	 * Write a triple to the incoming XMLStreamWriter
	 * 
	 * @param xMLStreamWriter
	 * @param subject
	 * @param predicate
	 * @param object
	 * @param solitary TRUE = A triple all by itself gets wrapped in a element sem:triples {}. 
	 *                FALSE = It's part of a series of writes, so no outer wrapper is written.
	 * @throws XMLStreamException
	 */
	public static void writeTriple(
			XMLStreamWriter xMLStreamWriter, 
			String subject, String predicate, String object,
			Boolean solitary
	) throws XMLStreamException {

		// Opening sem:triple element
        if (solitary) {
			xMLStreamWriter.writeCharacters("\n  ");
	        xMLStreamWriter.writeStartElement(SEM, "triples", SEM_TRIPLE_NAMESPACE);
	        xMLStreamWriter.writeNamespace(SEM, SEM_TRIPLE_NAMESPACE);
        }
		xMLStreamWriter.writeCharacters("\n    ");
        xMLStreamWriter.writeStartElement(SEM, "triple", SEM_TRIPLE_NAMESPACE);
        
        // Body of subject, predicate, and object
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "subject", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( subject.trim() );
        xMLStreamWriter.writeEndElement();
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "predicate", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( predicate.trim() );
        xMLStreamWriter.writeEndElement();
        xMLStreamWriter.writeCharacters("\n      ");
        xMLStreamWriter.writeStartElement(SEM, "object", SEM_TRIPLE_NAMESPACE);
        xMLStreamWriter.writeCharacters( object.trim() );
        xMLStreamWriter.writeEndElement();

        // Closing sem:triple element
        xMLStreamWriter.writeCharacters("\n    ");
        xMLStreamWriter.writeEndElement();
	    if (solitary) {
	        xMLStreamWriter.writeCharacters("\n  ");
		    xMLStreamWriter.writeEndElement();
	    }
	}

}
