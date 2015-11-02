package com.matthewroyal.marklogic.RDBSchemaModel;

public class RDBColumn implements Comparable<RDBColumn> {

	public enum data_types {
	  BIT, TINYINT, SMALLINT, MEDIUMINT, INT, INTEGER, 
	  BIGINT, REAL, DOUBLE, FLOAT, DECIMAL, NUMERIC, 
	  DATE, TIME, TIMESTAMP, DATETIME, YEAR, CHAR, 
	  VARCHAR, BINARY, VARBINARY, TINYBLOB, BLOB, 
	  MEDIUMBLOB, LONGBLOB, TINYTEXT, TEXT, 
	  MEDIUMTEXT, LONGTEXT, ENUM,
	  SET //set_value 
//		  , spatial_type
		  		
	};

	/**
	 * <p>Map the string version of a data_type to its enum value.</p>
	 * <p>This method is here so that someday when multiple RDBMSes are supported, 
	 * we can do more complex mappings.</p>
	 * @param typeName String of data_types enum type
	 * @return data_types enum value
	 */
	public static data_types get_data_type(String typeName) {
		
		if (null != typeName) {
			// It's a little like magic.
//			System.out.printf("get_data_types got [%s] --> [%s]\n", typeName, data_types.valueOf( typeName.trim().toUpperCase() ));
			// TODO Use log4j at some point...
			return data_types.valueOf( typeName.trim().toUpperCase() );
		
		} else {
			return null; // null is dumb
		}
		
					
	}
	
	RDBTable table;
	
	// Columns
	public String name = "";
	data_types type;
	Boolean isNullable;
	String defaultValue;
	Boolean isAutoIncremented;
	Boolean isUnique;
	String column_comment;
	
	/*
	 * Column attributes
       eh? ('COLUMN_FORMAT' ('FIXED','DYNAMIC','DEFAULT'))?
	 */
	
	
	
	public RDBColumn(
			RDBTable table,
			String name, 
			data_types type
	) throws Exception {
		this.table = table;
		this.name = name;
		
		if (null != type) {
			this.type = type;
		} else {
			throw new Exception("data_types type must not be null!");
		}
		
		this.isNullable = true;
		this.defaultValue = null;
		this.isAutoIncremented = false;
		this.isUnique = false;
		this.column_comment = null;
	}
	

	public RDBColumn(
			RDBTable table,
			String name, 
			data_types type, 
			Boolean isNullable
	) throws Exception {
		this.table = table;
		this.name = name;
		
		if (null != type) {
			this.type = type;
		} else {
			throw new Exception("data_types type must not be null!");
		}
		
		this.isNullable = isNullable;
		this.defaultValue = null;
		this.isAutoIncremented = false;
		this.isUnique = false;
		this.column_comment = null;
	}
	

	public RDBColumn(
		RDBTable table,
		String name, 
		data_types type, 
		Boolean isNullable,
		String defaultValue,
		Boolean isAutoIncremented,
		Boolean isUnique,
		String column_comment
	) throws Exception {
		this.table = table;
		this.name = name;
		
		if (null != type) {
			this.type = type;
		} else {
			throw new Exception("data_types type must not be null!");
		}
		
		this.isNullable = isNullable;
		this.defaultValue = defaultValue;
		this.isAutoIncremented = isAutoIncremented;
		this.isUnique = isUnique;
		this.column_comment = column_comment;
	}


	@Override
	public int compareTo(RDBColumn o) {
		return this.name.compareTo(o.name);
	}
	
	public RDBTable getTable() {
		return table;
	}

}
