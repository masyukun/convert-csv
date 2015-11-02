package com.matthewroyal.marklogic.RDBSchemaModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

public class RDBTable {

	
	public enum INSERT_METHOD {NO, FIRST, LAST}; 
	public enum PACK_KEYS {ZERO, ONE, DEFAULT};
	public enum ROW_FORMAT {DEFAULT, DYNAMIC, FIXED, COMPRESSED, REDUNDANT, COMPACT};
	public enum TABLESPACE {DISK, MEMORY, DEFAULT};
	
	public String tableName;
	Boolean isTemporary = false;
	String comment;
	
	
	// MySQL TABLE OPTIONS
	String engine_name = null;
	Integer auto_increment_value;
	Integer avg_row_length_value;
	String charset_name = null;
	Boolean checksum;
	String collation_name = null;
	String connect_string = null;
	String absolute_path_to_data_directory = null;
	Boolean delay_key_write;
	String absolute_path_to_index_directory = null;
	INSERT_METHOD insert_method;
	Integer key_block_size_value;
	Integer max_rows_value;
	Integer min_rows_value;
	PACK_KEYS pack_keys;
	String password_string = null;
	ROW_FORMAT row_format; 
	TABLESPACE tablespace_storage_name;
	String union_table_name = null;


	// Track the column objects by name
	private HashMap<String, RDBColumn> columnMap = new HashMap<String, RDBColumn>();
	private List<RDBColumn> columns = new ArrayList<RDBColumn>();
	
	/** Primary keys (list: local columns) */
	public List<RDBColumn> primary_keys = new ArrayList<RDBColumn>();

	/** Indexed columns (list: local columns) */
	List<RDBColumn> indexed_columns = new ArrayList<RDBColumn>();
	
	/** Foreign keys (map: local column : another table's column) */
	public BidiMap<RDBColumn, RDBColumn> foreign_keys = new TreeBidiMap<RDBColumn, RDBColumn>();

	// Column distance by table hops
	private BidiMap<RDBColumn, Integer> column_distance = new TreeBidiMap<RDBColumn, Integer>();
	
	/** To get to the key column, hop to the value column recursively until you arrive */
	private BidiMap<RDBColumn, RDBColumn> column_path = new TreeBidiMap<RDBColumn, RDBColumn>();
	


	/** Full constructor */
	public RDBTable(
			String tableName,
			Boolean isTemporary,
			String comment,
			String engine_name,
			Integer auto_increment_value,
			Integer avg_row_length_value,
			String charset_name,
			Boolean checksum,
			String collation_name,
			String connect_string,
			String absolute_path_to_data_directory,
			Boolean delay_key_write,
			String absolute_path_to_index_directory,
			INSERT_METHOD insert_method,
			Integer key_block_size_value,
			Integer max_rows_value,
			Integer min_rows_value,
			PACK_KEYS pack_keys,
			String password_string,
			ROW_FORMAT row_format,
			TABLESPACE tablespace_storage_name,
			String union_table_name
		) {
			this.tableName = tableName;
			this.isTemporary = isTemporary;
			this.comment = comment;
			this.engine_name = engine_name;
			this.auto_increment_value = auto_increment_value;
			this.avg_row_length_value = avg_row_length_value;
			this.charset_name = charset_name;
			this.checksum = checksum;
			this.collation_name = collation_name;
			this.connect_string = connect_string;
			this.absolute_path_to_data_directory = absolute_path_to_data_directory;
			this.delay_key_write = delay_key_write;
			this.absolute_path_to_index_directory = absolute_path_to_index_directory;
			this.insert_method = insert_method;
			this.key_block_size_value = key_block_size_value;
			this.max_rows_value = max_rows_value;
			this.min_rows_value = min_rows_value;
			this.pack_keys = pack_keys;
			this.password_string = password_string;
			this.row_format = row_format;
			this.tablespace_storage_name = tablespace_storage_name;
			this.union_table_name = union_table_name;
		}

	public RDBTable(
			String tableName,
			Boolean isTemporary,
			String comment
		) {
			this.tableName = tableName;
			this.isTemporary = isTemporary;
			this.comment = comment;
		}

	public RDBTable(
			String tableName
		) {
			this.tableName = tableName;
		}

	/**
	 * Add the column to the column list and column name map.
	 * 
	 * @param newColumn
	 * @return
	 * @throws Exception
	 */
	public boolean addColumn(RDBColumn newColumn) throws Exception{
		// Sanity check
		if (null == newColumn) {
			throw new Exception("newColumn is null! ");
		} else if (null == newColumn.name || newColumn.name.trim().equals("")) {
			throw new Exception("newColumn has no name! ");
		}
		
		//TODO implement merge method to merge columns with identical names
		
		// Add column to the name listing
		RDBColumn oldValue = columnMap.get(newColumn.name);
		if (null == oldValue) {
			columnMap.put(newColumn.name, newColumn);
		} else
			System.out.printf("DATA LOSS WARNING: adding column [%s] to table [%s] overwrites existing value: [%s]\n", 
					newColumn.name, this.tableName, oldValue);
		
		// Add the column to the column list.
		return columns.add(newColumn);
	}

	public boolean addPrimaryKey(RDBColumn newColumn) throws Exception {
		// Sanity check
		if (null == newColumn) {
			throw new Exception("primary key column is null! ");
		} else if (null == newColumn.name || newColumn.name.trim().equals("")) {
			throw new Exception("primary key column has no name! ");
		}
		
		// This column must already exist in order to make it a primary key 
		if (!columns.contains(newColumn)) {
			// If we hit this part, it means that the column has not already been defined,
			// which should only happen if the SQL create specification has a logic error.
			throw new Exception(
				String.format(
					"\n\nFATAL ERROR: The SQL create statement for table [%s] contains a logic error: "
						+ "tried specifying column name [%s] as a primary key without first defining it.\n\n", 
					tableName, 
					newColumn.name)
			);
		}
		
		// Add to primary keys list
		if (!primary_keys.contains(newColumn)) {
			return primary_keys.add(newColumn);
		} else {
			System.out.printf("NOTICE: Ignoring redundant primary key definition for %s.%s\n", tableName, newColumn.name);
			return false;
		}
		
	}
	
	public boolean addIndex(RDBColumn newColumn) throws Exception {
		// Sanity check
		if (null == newColumn) {
			throw new Exception("index column is null! ");
		} else if (null == newColumn.name || newColumn.name.trim().equals("")) {
			throw new Exception("index column has no name! ");
		}
		
		// This column must already exist in order to make it an index 
		if (!columns.contains(newColumn)) {
			// If we hit this part, it means that the column has not already been defined,
			// which should only happen if the SQL create specification has a logic error.
			throw new Exception(
				String.format(
					"\n\nFATAL ERROR: The SQL create statement for table [%s] contains a logic error: "
						+ "tried specifying column name [%s] as an index without first defining it.\n\n", 
					tableName, 
					newColumn.name)
			);
		}
		
		// Add to indexed keys list
		if (!indexed_columns.contains(newColumn)) {
			return indexed_columns.add(newColumn);
		} else {
			System.out.printf("NOTICE: Ignoring redundant index definition for %s.%s\n", tableName, newColumn.name);
			return false;
		}
		
	}
	
	public List<RDBColumn> getColumns() {
		return columns;
	}
	
	public RDBColumn getColumnByName(String columnName) {
		return columnMap.get(columnName);
	}
	
	public void submitColumnDistance(
		RDBColumn destination,
		RDBColumn me,
		Integer distance
	) {
		if (null == column_distance.get(destination) || column_distance.get(destination) > distance + 1) {
			// Update this table's listings
			column_distance.put(destination, distance + 1);
			column_path.put(destination, me);
			
			// Update all tables we're connected to
			for (RDBColumn adjacent_pk : foreign_keys.values() ) {
				for (RDBColumn local_fk : foreign_keys.keySet()) {
					adjacent_pk.table.submitColumnDistance(destination, local_fk, distance + 1);
				}
			}
		}
	}

	/**
	 * Relate a local column name to a column object from another table.
	 * 
	 * @param local_column_name
	 * @param foreign_column
	 * @throws Exception
	 */
	public void addForeignKey(String local_column_name, RDBColumn foreign_column) throws Exception{
		
		RDBColumn local_column;
		
		// Sanity check
		if (null == local_column_name) {
			throw new Exception("local_column_name is null! ");
		} else {
			local_column = columnMap.get(local_column_name);
			if (null == local_column) {
				throw new Exception("local_column_name does not map to a local_column! ");
			}
		}
		
		// Call the real method
		this.addForeignKey(local_column, foreign_column);
	}
	
		
	/**
	 * Relate a local column to a column object from another table.
	 * 
	 * @param local_column
	 * @param foreign_column
	 * @throws Exception
	 */
	public void addForeignKey(RDBColumn local_column, RDBColumn foreign_column) throws Exception{
		// Sanity check
		if (null == local_column || null == foreign_column) {
			throw new Exception(
				((null == local_column) ? " local_column is null! " : "")
				+ ((null == foreign_column) ? " foreign_column is null! " : "")
			);
		}
		
		// THIS table? check
		if (local_column.table != this) {
			throw new Exception("local_column must belong to this table!"
					+ "\nShould have been: ["+this.tableName
					+"]  Received instead: ["+local_column.table.tableName+"]");
		}
		
		// See if it's already in our column list
		if (!columns.contains(local_column)) {
			columns.add(local_column);
			
			// Add to lookup map
			if (null == columnMap.get(local_column.name)) {
				columnMap.put(local_column.name, local_column);
			}
		}
		
		// Add the key
		foreign_keys.put(local_column, foreign_column);
		
		// Record its distance
		for (RDBColumn primary_key : primary_keys)
			submitColumnDistance(foreign_column, primary_key, 0);
	}
	
}
