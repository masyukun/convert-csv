package com.matthewroyal.marklogic.RDBSchemaModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.matthewroyal.marklogic.CreateTableParser.CreateTableListener;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Absolute_path_to_directoryContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Auto_incrementContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Auto_increment_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Avg_row_length_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.BinaryContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Charset_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Col_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Collation_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Column_definitionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Column_formatContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Column_listContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Comment_stringContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Connect_stringContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Create_definitionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Create_statementContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Data_dirContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Data_typeContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_charsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_chars_valuesContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_intsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_ints_valuesContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_lengthContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_realsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_reals_values2Context;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_reals_valuesContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_simpleContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_textsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Datatype_texts_valuesContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.DecimalsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Default_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Drop_statementContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Engine_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Enum_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.EvaluateContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.ExprContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.ForeignContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Index_col_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Index_dirContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Index_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Index_optionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Index_typeContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Key_block_size_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Key_vlock_size_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.LengthContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Logical_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Max_number_of_rowsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Max_rows_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Min_number_of_rowsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Min_rows_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Node_group_idContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.NullableContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Parser_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Partition_definitionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Partition_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Partition_optionsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Partitions_numContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Password_stringContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.PathContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.PrimaryContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Reference_definitionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Reference_optionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Set_valueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Spatial_typeContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.StorageContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Subpartition_definitionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Subpartitions_numContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.SymbolContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Table_optionContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Table_optionsContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Tablespace_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Tbl_nameContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.UniqueContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.UnsignedContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.Value_listContext;
import com.matthewroyal.marklogic.CreateTableParser.CreateTableParser.ZerofillContext;


public class SqlListener implements CreateTableListener {

	private static Logger logger = LogManager.getLogger( SqlListener.class.getClass() );
	
	private class ForeignKey {
		public String tableName;
		public String columnName;
		public String relationshipName; // Optional name of the relationship
	}
	
	// Track the tables by name
	public HashMap<String, RDBTable> tableMap = new HashMap<String, RDBTable>();
	
	
	// Track all the foreign keys as they're parsed, then link them in the schema at the end.
	public HashMap<RDBColumn, ForeignKey> foreignKeyQueue = new HashMap<RDBColumn, SqlListener.ForeignKey>();
	
	

	public SqlListener() {
		// Nothing to do here.
	}

	
	/* *****
	 * BEGIN Unused parse event listeners
	 */
	@Override public void enterEveryRule(ParserRuleContext arg0) {}
	@Override public void exitEveryRule(ParserRuleContext arg0) {}
	@Override public void visitErrorNode(ErrorNode arg0) {}
	@Override public void visitTerminal(TerminalNode arg0) {}
	@Override public void enterDrop_statement(Drop_statementContext ctx) {}
	@Override public void enterSubpartitions_num(Subpartitions_numContext ctx) {}
	@Override public void exitSubpartitions_num(Subpartitions_numContext ctx) {}
	@Override public void enterMax_rows_value(Max_rows_valueContext ctx) {}
	@Override public void exitMax_rows_value(Max_rows_valueContext ctx) {}
	@Override public void enterConnect_string(Connect_stringContext ctx) {}
	@Override public void exitConnect_string(Connect_stringContext ctx) {}
	@Override public void enterValue_list(Value_listContext ctx) {}
	@Override public void exitValue_list(Value_listContext ctx) {}
	@Override public void enterMin_rows_value(Min_rows_valueContext ctx) {}
	@Override public void exitMin_rows_value(Min_rows_valueContext ctx) {}
	@Override public void enterParser_name(Parser_nameContext ctx) {}
	@Override public void exitParser_name(Parser_nameContext ctx) {}
	@Override public void enterData_type(Data_typeContext ctx) {}
	@Override public void exitData_type(Data_typeContext ctx) {}
	@Override public void enterSet_value(Set_valueContext ctx) {}
	@Override public void exitSet_value(Set_valueContext ctx) {}
	@Override public void enterReference_option(Reference_optionContext ctx) {}
	@Override public void exitReference_option(Reference_optionContext ctx) {}
	@Override public void enterSpatial_type(Spatial_typeContext ctx) {}
	@Override public void exitSpatial_type(Spatial_typeContext ctx) {}
	@Override public void enterCreate_statement(Create_statementContext ctx) {}
	@Override public void enterReference_definition(Reference_definitionContext ctx) {}
	@Override public void exitReference_definition(Reference_definitionContext ctx) {}
	@Override public void enterSymbol(SymbolContext ctx) {}
	@Override public void exitSymbol(SymbolContext ctx) {}
	@Override public void enterData_dir(Data_dirContext ctx) {}
	@Override public void exitData_dir(Data_dirContext ctx) {}
	@Override public void enterMax_number_of_rows(Max_number_of_rowsContext ctx) {}
	@Override public void exitMax_number_of_rows(Max_number_of_rowsContext ctx) {}
	@Override public void enterSubpartition_definition(Subpartition_definitionContext ctx) {}
	@Override public void exitSubpartition_definition(Subpartition_definitionContext ctx) {}
	@Override public void enterColumn_definition(Column_definitionContext ctx) {}
	@Override public void exitColumn_definition(Column_definitionContext ctx) {}
	@Override public void enterPassword_string(Password_stringContext ctx) {}
	@Override public void exitPassword_string(Password_stringContext ctx) {}
	@Override public void enterPartition_name(Partition_nameContext ctx) {}
	@Override public void exitPartition_name(Partition_nameContext ctx) {}
	@Override public void enterEngine_name(Engine_nameContext ctx) {}
	@Override public void exitEngine_name(Engine_nameContext ctx) {}
	@Override public void enterEvaluate(EvaluateContext ctx) {}
	@Override public void enterPartitions_num(Partitions_numContext ctx) {}
	@Override public void exitPartitions_num(Partitions_numContext ctx) {}
	@Override public void enterMin_number_of_rows(Min_number_of_rowsContext ctx) {}
	@Override public void exitMin_number_of_rows(Min_number_of_rowsContext ctx) {}
	@Override public void enterTable_options(Table_optionsContext ctx) {}
	@Override public void exitTable_options(Table_optionsContext ctx) {}
	@Override public void enterExpr(ExprContext ctx) {}
	@Override public void exitExpr(ExprContext ctx) {}
	@Override public void enterCharset_name(Charset_nameContext ctx) {}
	@Override public void exitCharset_name(Charset_nameContext ctx) {}
	@Override public void enterNode_group_id(Node_group_idContext ctx) {}
	@Override public void exitNode_group_id(Node_group_idContext ctx) {}
	@Override public void enterTablespace_name(Tablespace_nameContext ctx) {}
	@Override public void exitTablespace_name(Tablespace_nameContext ctx) {}
	@Override public void enterLogical_name(Logical_nameContext ctx) {}
	@Override public void exitLogical_name(Logical_nameContext ctx) {}
	@Override public void enterIndex_name(Index_nameContext ctx) {}
	@Override public void exitIndex_name(Index_nameContext ctx) {}
	@Override public void enterColumn_list(Column_listContext ctx) {}
	@Override public void exitColumn_list(Column_listContext ctx) {}
	@Override public void enterPath(PathContext ctx) {}
	@Override public void exitPath(PathContext ctx) {}
	@Override public void enterIndex_dir(Index_dirContext ctx) {}
	@Override public void exitIndex_dir(Index_dirContext ctx) {}
	@Override public void enterLength(LengthContext ctx) {}
	@Override public void exitLength(LengthContext ctx) {}
	@Override public void enterTbl_name(Tbl_nameContext ctx) {}
	@Override public void exitTbl_name(Tbl_nameContext ctx) {}
	@Override public void enterCol_name(Col_nameContext ctx) {}
	@Override public void exitCol_name(Col_nameContext ctx) {}
	@Override public void enterEnum_value(Enum_valueContext ctx) {}
	@Override public void exitEnum_value(Enum_valueContext ctx) {}
	@Override public void enterAuto_increment_value(Auto_increment_valueContext ctx) {}
	@Override public void exitAuto_increment_value(Auto_increment_valueContext ctx) {}
	@Override public void enterIndex_option(Index_optionContext ctx) {}
	@Override public void exitIndex_option(Index_optionContext ctx) {}
	@Override public void enterKey_vlock_size_value(Key_vlock_size_valueContext ctx) {}
	@Override public void exitKey_vlock_size_value(Key_vlock_size_valueContext ctx) {}
	@Override public void enterPartition_definition(Partition_definitionContext ctx) {}
	@Override public void exitPartition_definition(Partition_definitionContext ctx) {}
	@Override public void enterIndex_col_name(Index_col_nameContext ctx) {}
	@Override public void exitIndex_col_name(Index_col_nameContext ctx) {}
	@Override public void enterPartition_options(Partition_optionsContext ctx) {}
	@Override public void exitPartition_options(Partition_optionsContext ctx) {}
	@Override public void enterDecimals(DecimalsContext ctx) {}
	@Override public void exitDecimals(DecimalsContext ctx) {}
	@Override public void enterAvg_row_length_value(Avg_row_length_valueContext ctx) {}
	@Override public void exitAvg_row_length_value(Avg_row_length_valueContext ctx) {}
	@Override public void enterDefault_value(Default_valueContext ctx) {}
	@Override public void exitDefault_value(Default_valueContext ctx) {}
	@Override public void enterAbsolute_path_to_directory(Absolute_path_to_directoryContext ctx) {}
	@Override public void exitAbsolute_path_to_directory(Absolute_path_to_directoryContext ctx) {}
	@Override public void enterKey_block_size_value(Key_block_size_valueContext ctx) {}
	@Override public void exitKey_block_size_value(Key_block_size_valueContext ctx) {}
	@Override public void enterTable_option(Table_optionContext ctx) {}
	@Override public void exitTable_option(Table_optionContext ctx) {}
	@Override public void enterCollation_name(Collation_nameContext ctx) {}
	@Override public void exitCollation_name(Collation_nameContext ctx) {}
	@Override public void enterCreate_definition(Create_definitionContext ctx) {}
	@Override public void enterComment_string(Comment_stringContext ctx) {}
	@Override public void exitComment_string(Comment_stringContext ctx) {}
	@Override public void enterIndex_type(Index_typeContext ctx) {}
	@Override public void exitIndex_type(Index_typeContext ctx) {}
	@Override public void enterDatatype_reals_values2(Datatype_reals_values2Context ctx) {}
	@Override public void exitDatatype_reals_values2(Datatype_reals_values2Context ctx) {}
	@Override public void enterDatatype_reals_values(Datatype_reals_valuesContext ctx) {}
	@Override public void exitDatatype_reals_values(Datatype_reals_valuesContext ctx) {}
	@Override public void enterDatatype_texts(Datatype_textsContext ctx) {}
	@Override public void exitDatatype_texts(Datatype_textsContext ctx) {}
	@Override public void enterDatatype_length(Datatype_lengthContext ctx) {}
	@Override public void exitDatatype_length(Datatype_lengthContext ctx) {}
	@Override public void enterDatatype_reals(Datatype_realsContext ctx) {}
	@Override public void exitDatatype_reals(Datatype_realsContext ctx) {}
	@Override public void enterZerofill(ZerofillContext ctx) {}
	@Override public void exitZerofill(ZerofillContext ctx) {}
	@Override public void enterBinary(BinaryContext ctx) {}
	@Override public void exitBinary(BinaryContext ctx) {}
	@Override public void enterDatatype_ints_values(Datatype_ints_valuesContext ctx) {}
	@Override public void exitDatatype_ints_values(Datatype_ints_valuesContext ctx) {}
	@Override public void enterDatatype_texts_values(Datatype_texts_valuesContext ctx) {}
	@Override public void exitDatatype_texts_values(Datatype_texts_valuesContext ctx) {}
	@Override public void enterDatatype_ints(Datatype_intsContext ctx) {}
	@Override public void exitDatatype_ints(Datatype_intsContext ctx) {}
	@Override public void enterUnsigned(UnsignedContext ctx) {}
	@Override public void exitUnsigned(UnsignedContext ctx) {}
	@Override public void enterDatatype_chars_values(Datatype_chars_valuesContext ctx) {}
	@Override public void exitDatatype_chars_values(Datatype_chars_valuesContext ctx) {}
	@Override public void enterDatatype_simple(Datatype_simpleContext ctx) {}
	@Override public void exitDatatype_simple(Datatype_simpleContext ctx) {}
	@Override public void enterDatatype_chars(Datatype_charsContext ctx) {}
	@Override public void exitDatatype_chars(Datatype_charsContext ctx) {}
	@Override public void enterPrimary(PrimaryContext ctx) {}
	@Override public void exitPrimary(PrimaryContext ctx) {}
	@Override public void enterAuto_increment(Auto_incrementContext ctx) {}
	@Override public void exitAuto_increment(Auto_incrementContext ctx) {}
	@Override public void enterUnique(UniqueContext ctx) {}
	@Override public void exitUnique(UniqueContext ctx) {}
	@Override public void enterColumn_format(Column_formatContext ctx) {}
	@Override public void exitColumn_format(Column_formatContext ctx) {}
	@Override public void enterNullable(NullableContext ctx) {}
	@Override public void exitNullable(NullableContext ctx) {}
	@Override public void enterStorage(StorageContext ctx) {}
	@Override public void exitStorage(StorageContext ctx) {}
	@Override public void enterForeign(ForeignContext ctx) {}
	@Override public void exitForeign(ForeignContext ctx) {}
	@Override public void exitDrop_statement(Drop_statementContext ctx) {}
	/*
	 * END Unused parse event listeners
	 * *****/


	@Override
	public void exitEvaluate(EvaluateContext ctx) {

		// Link all the foreign keys that were defined in the schema
		logger.debug(String.format("Linking [%s] foreign keys", foreignKeyQueue.size()));
		for (RDBColumn localColumn : foreignKeyQueue.keySet()) {

			// Sanity check -- local table reference exists
			RDBTable localTable = localColumn.getTable();
			if (null == localTable) {
				logger.error(String.format("ERROR: Cannot find table reference for local foreign key column [%s]", localColumn.name));
				return;
			}
			
			ForeignKey fk = foreignKeyQueue.get(localColumn);
			RDBTable fkTable = tableMap.get(fk.tableName);
			if (null != fkTable) {
				RDBColumn fkColumn = fkTable.getColumnByName(fk.columnName);
				
				if (null != fkColumn) {
					try {
						localTable.addForeignKey(localColumn, fkColumn);
					} catch (Exception e) {
						// Foreign key linking failed!
						logger.error(String.format("ERROR: Linking foreign key from: %s.%s -%s-> %s.%s", 
							localTable.tableName, localColumn.name, 
							(null != fk.relationshipName) ? fk.relationshipName : "--", 
							fk.tableName, fk.columnName), e);
					}
				}
			}
		}
		
	}


	@Override 
	public void exitCreate_statement(Create_statementContext ctx) {
		String  columnName = null, 
				dataType = null, 
				comment = null, 
				default_value = null,
				length = null, 
				decimals = null, 
				charset_name = null, 
				collation_name = null,
				column_format = null,
				storage = null;
		Boolean nullable = true,
				unsigned = false, 
				zerofill = false, 
				binary = false,
				auto_increment = false,
				unique = false,
				primary = false;
		
		ArrayList<Enum_valueContext> enum_values = new ArrayList<Enum_valueContext>();
		ArrayList<Set_valueContext> set_values = new ArrayList<Set_valueContext>();
		

		
		// Get a reference to the current table
		String tableName = ctx.tbl_name().getText().replaceAll("`", "");
		RDBTable tableObject = tableMap.get(tableName);
		
		if (null == tableObject) {
			tableObject = new RDBTable(tableName);
			tableMap.put(tableName, tableObject);
		}


		
		// Used to populate the schema model
		RDBColumn newColumn = null;

		
		// See what this column is made of
		List<Create_definitionContext> createDefs = ctx.create_definition();
		for (Create_definitionContext createDef : createDefs) {
			Column_definitionContext column = createDef.column_definition();
			
			if (null != column) {
				
				// Column definition 
				columnName = (null != createDef.col_name()) ? createDef.col_name().getText().replaceAll("`", "") : null;
				nullable       = 
					(null != column.nullable()) 
						? (column.nullable().getText().toLowerCase().contains("not") ? false : true)
						: true;
				default_value  = (null != column.default_value()) ? column.default_value().getText() : null;
				auto_increment = (null != column.auto_increment());
				unique         = (null != column.unique());
				primary        = (null != column.primary());
				comment        = ((null != column.comment_string())) ? column.comment_string().getText() : null;
				column_format  = (null != column.column_format()) ? column.column_format().getText() : null;
				storage        = (null != column.storage()) ? column.storage().getText() : null;
				
					
				// Column data type
				Data_typeContext type = (null != column) ? column.data_type() : null;
				if (null != type) {
					// Simple type, no parameters
					if (null != type.datatype_simple()) {
						dataType = type.datatype_simple().getText();
					}
					
					// Simple type with length
					else if (null != type.datatype_length()) {
						dataType = type.datatype_length().getChild(0).getText();
						length = type.datatype_length().length().getText();
					}
					
					// Integer types
					else if (null != type.datatype_ints()) {
						dataType = type.datatype_ints().datatype_ints_values().getText();
						length = (null != type.datatype_ints().length()) 
							? type.datatype_ints().length().getText() : null;
						unsigned = (null != type.datatype_ints().unsigned());
						zerofill = (null != type.datatype_ints().zerofill());
					}
				    
					// Reals types 
					else if (null != type.datatype_reals()) {
						dataType = (null != type.datatype_reals().datatype_reals_values())
							? type.datatype_reals().datatype_reals_values().getText()
							: type.datatype_reals().datatype_reals_values2().getText();
						length = (null != type.datatype_reals().length())
							? type.datatype_reals().length().getText() : null;
						decimals = (null != type.datatype_reals().decimals())
							? type.datatype_reals().decimals().getText() : null;
						unsigned = (null != type.datatype_reals().unsigned());
						zerofill = (null != type.datatype_reals().zerofill());
					}
						
					// Chars types
					else if (null != type.datatype_chars()) {
						dataType = type.datatype_chars().datatype_chars_values().getText();
						length = (null != type.datatype_chars().length()) 
							? type.datatype_chars().length().getText(): null;
						binary = (null != type.datatype_chars().binary());
						charset_name = (null != type.datatype_chars().charset_name())
							? type.datatype_chars().charset_name().getText() : null;
						collation_name = (null != type.datatype_chars().collation_name())
								? type.datatype_chars().collation_name().getText() : null;
					}

					// Text types
					else if (null != type.datatype_texts()) {
						dataType = type.datatype_texts().datatype_texts_values().getText();
						binary = (null != type.datatype_texts().binary());
						charset_name = (null != type.datatype_texts().charset_name())
							? type.datatype_texts().charset_name().getText() : null;
						collation_name = (null != type.datatype_texts().collation_name())
								? type.datatype_texts().collation_name().getText() : null;
					}

					// Enum type
					else if (null != type.enum_value()) {
						dataType = type.getChild(0).getText();
						enum_values.addAll( type.enum_value() );
						charset_name = (null != type.charset_name())
							? type.charset_name().getText() : null;
						collation_name = (null != type.collation_name())
							? type.collation_name().getText() : null;
					}

					// Set Values type
					else if (null != type.enum_value()) {
						dataType = type.getChild(0).getText();
						set_values.addAll( type.set_value() );
						charset_name = (null != type.charset_name())
							? type.charset_name().getText() : null;
						collation_name = (null != type.collation_name())
							? type.collation_name().getText() : null;
					}
					
					// TODO: Add Spatial type at some point, if someone wants it
					
					// Add typed column
					try {
						// Create schema model
						newColumn = new RDBColumn(tableObject, columnName, RDBColumn.get_data_type(dataType), nullable, default_value, auto_increment, unique, comment);
						if (null != newColumn)
							tableObject.addColumn(newColumn);
						
						// Is it a primary key?
						if (null != column.primary() && !tableObject.primary_keys.contains(newColumn)) {
							logger.debug("PRIMARY KEY in createdef: " + createDef.col_name());
							tableObject.primary_keys.add(newColumn);
						}
					} catch (Exception e) {
						logger.error("Column definition contained no type information.", e);
					}

				} // end type checking
				
				
			// Map primary key definition
			} else if (null != createDef.primary()) {
				
				// Primary key definition
				List<Index_col_nameContext> primaryKeyColumns = createDef.index_col_name();
				logger.debug(String.format("PRIMARY KEY definition contains [%d] column%s", primaryKeyColumns.size(), (primaryKeyColumns.size() == 1) ? "" : "s"));
				for (Index_col_nameContext primaryKeyColumn : primaryKeyColumns) {
					columnName = (null != primaryKeyColumn.col_name()) ? primaryKeyColumn.col_name().getText().replaceAll("`", "") : null;
					logger.debug("  PRIMARY KEY: " + columnName);
					
					// This column must already exist
					newColumn = tableObject.getColumnByName(columnName);
							
					// Add to primary keys list
					try {
						tableObject.addPrimaryKey(newColumn);
						tableObject.addIndex(newColumn);

					} catch (Exception e) {
						logger.error(String.format("Cannot add primary key [%s] to table [%s]", columnName, tableName), e);
					}
					
				}

				
			// Map indexed column definition
			} else if (null != createDef.index_name()) {
				
				// Index definition
				List<Index_col_nameContext> indexedColumns = createDef.index_col_name();
				logger.debug(String.format("INDEX definition contains [%s] column%s", indexedColumns.size(), (indexedColumns.size() == 1) ? "" : "s"));
				for (Index_col_nameContext index : indexedColumns) {
					columnName = index.getText().replaceAll("`", "");
					logger.debug("  INDEX ON: " + columnName);
			
					// This column must already exist
					newColumn = tableObject.getColumnByName(columnName);
							
					// Add to primary keys list
					try {
						tableObject.addIndex(newColumn);
					} catch (Exception e) {
						logger.error(String.format("ERROR: Cannot add index to %s.%s", tableName, columnName), e);
					}
				}

				
			// Map foreign key definition
			} else if (null != createDef.foreign()) {
				
				// Get the list of local columns being related
				List<Index_col_nameContext> localColumns = createDef.index_col_name();
				logger.debug(String.format("FOREIGN KEY definition \"%s\" contains [%s] column%s", 
					((null != createDef.symbol())?createDef.symbol().getText():"X"), 
					localColumns.size(), (localColumns.size() == 1) ? "" : "s")
				);

				// Get the foreign table name
				Reference_definitionContext reference = createDef.reference_definition();
				String foreignTableName = 
					(null != reference) ?
						((null != reference.tbl_name()) ? reference.tbl_name().getText().replaceAll("`", "") : null)
					: null;
				
				// Get the foreign column list
				List<Index_col_nameContext> referencedColumns = reference.index_col_name();

				// Sanity check -- same number of local and remote columns
				if (localColumns.size() != referencedColumns.size()) {
					logger.error(String.format("ERROR: Foreign key definition contains mismatched number of local keys [%d] and foreign keys [%d]", localColumns.size(), referencedColumns.size()));

					// This isn't ideal, but the function doesn't have a throws declaration.
					continue;
				}
				
				
				// Loop through all the foreign key definitions in this entry (aggregate FKs)
				for (int ii = 0; ii < localColumns.size(); ii++) {
					String localColumnName = localColumns.get(ii).getText().replaceAll("`", "");
					String foreignColumnName = referencedColumns.get(ii).getText().replaceAll("`", "");
					String relationshipName = (null != createDef.index_name()) ? createDef.index_name().getText().replaceAll("`", "") : null; 
					
					logger.debug(String.format("  FOREIGN KEY from: %s.%s -%s-> %s.%s", 
						tableName, localColumnName, 
						(null != relationshipName) ? relationshipName : "--", 
						foreignTableName, foreignColumnName)
					);
					
					 

					// This column must already exist
					RDBColumn localColumn = tableObject.getColumnByName(localColumnName);
					
					
					// Add to foreign keys queue -- we'll add everything at the end, 
					// after all the table and column information has been loaded into the schema model.
					ForeignKey newFk = new ForeignKey();
					newFk.tableName = foreignTableName.replaceAll("`", "");
					newFk.columnName = foreignColumnName;
					newFk.relationshipName = relationshipName;
					
					foreignKeyQueue.put(localColumn, newFk);
				}
			}
			
//			column_format
//			storage
		}
		

	}

	@Override
	public void exitCreate_definition(Create_definitionContext ctx) {
		
		
	}


}
