// Generated from CreateTable.g4 by ANTLR 4.4


package com.matthewroyal.marklogic.CreateTableParser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CreateTableParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__169=1, T__168=2, T__167=3, T__166=4, T__165=5, T__164=6, T__163=7, 
		T__162=8, T__161=9, T__160=10, T__159=11, T__158=12, T__157=13, T__156=14, 
		T__155=15, T__154=16, T__153=17, T__152=18, T__151=19, T__150=20, T__149=21, 
		T__148=22, T__147=23, T__146=24, T__145=25, T__144=26, T__143=27, T__142=28, 
		T__141=29, T__140=30, T__139=31, T__138=32, T__137=33, T__136=34, T__135=35, 
		T__134=36, T__133=37, T__132=38, T__131=39, T__130=40, T__129=41, T__128=42, 
		T__127=43, T__126=44, T__125=45, T__124=46, T__123=47, T__122=48, T__121=49, 
		T__120=50, T__119=51, T__118=52, T__117=53, T__116=54, T__115=55, T__114=56, 
		T__113=57, T__112=58, T__111=59, T__110=60, T__109=61, T__108=62, T__107=63, 
		T__106=64, T__105=65, T__104=66, T__103=67, T__102=68, T__101=69, T__100=70, 
		T__99=71, T__98=72, T__97=73, T__96=74, T__95=75, T__94=76, T__93=77, 
		T__92=78, T__91=79, T__90=80, T__89=81, T__88=82, T__87=83, T__86=84, 
		T__85=85, T__84=86, T__83=87, T__82=88, T__81=89, T__80=90, T__79=91, 
		T__78=92, T__77=93, T__76=94, T__75=95, T__74=96, T__73=97, T__72=98, 
		T__71=99, T__70=100, T__69=101, T__68=102, T__67=103, T__66=104, T__65=105, 
		T__64=106, T__63=107, T__62=108, T__61=109, T__60=110, T__59=111, T__58=112, 
		T__57=113, T__56=114, T__55=115, T__54=116, T__53=117, T__52=118, T__51=119, 
		T__50=120, T__49=121, T__48=122, T__47=123, T__46=124, T__45=125, T__44=126, 
		T__43=127, T__42=128, T__41=129, T__40=130, T__39=131, T__38=132, T__37=133, 
		T__36=134, T__35=135, T__34=136, T__33=137, T__32=138, T__31=139, T__30=140, 
		T__29=141, T__28=142, T__27=143, T__26=144, T__25=145, T__24=146, T__23=147, 
		T__22=148, T__21=149, T__20=150, T__19=151, T__18=152, T__17=153, T__16=154, 
		T__15=155, T__14=156, T__13=157, T__12=158, T__11=159, T__10=160, T__9=161, 
		T__8=162, T__7=163, T__6=164, T__5=165, T__4=166, T__3=167, T__2=168, 
		T__1=169, T__0=170, INTEGER=171, ID=172, ALPHANUMERIC=173, WS=174, NL=175;
	public static final String[] tokenNames = {
		"<INVALID>", "'INDEX'", "'tinyblob'", "'KEY_BLOCK_SIZE'", "'DELETE'", 
		"'LINEAR'", "'varchar'", "'COMMENT'", "'MEDIUMINT'", "'double'", "'CHECKSUM'", 
		"'IN'", "'float'", "'0'", "'longtext'", "'char'", "'YEAR'", "'PASSWORD'", 
		"'UNSIGNED'", "')'", "'LONGTEXT'", "'CHAR'", "'TABLE'", "'CHARACTER'", 
		"'unsigned'", "'zerofill'", "'BTREE'", "'MIN_ROWS'", "'DESC'", "'AUTO_INCREMENT'", 
		"'INDEX DIRECTORY'", "'smallint'", "'CASCADE'", "'TINYINT'", "'DATETIME'", 
		"'datetime'", "'REFERENCES'", "'table'", "'null'", "'STORAGE'", "'DROP'", 
		"'TABLESPACE'", "'TEXT'", "'binary'", "'1'", "'CHECK'", "'VARBINARY'", 
		"'PARTITION'", "'not null'", "'BY'", "','", "'bigint'", "'int'", "'CHARSET'", 
		"'decimal'", "'TIME'", "'COMPRESSED'", "'FOREIGN'", "'set'", "'MEDIUMBLOB'", 
		"'TINYTEXT'", "'LESS'", "'BIGINT'", "'DATE'", "'FIRST'", "'DEFAULT'", 
		"'FULLTEXT'", "'if exists'", "'BLOB'", "'ZEROFILL'", "'temporary'", "'VARCHAR'", 
		"'NO'", "'USING'", "'BIT'", "'NULL'", "'THAN'", "'SMALLINT'", "'REDUNDANT'", 
		"'CREATE'", "'if not exists'", "'FIXED'", "'ON'", "'DOUBLE'", "'REAL'", 
		"'DISK'", "'time'", "'WITH'", "'MAX_ROWS'", "'/'", "'bit'", "'tinyint'", 
		"'BINARY'", "'ROW_FORMAT'", "'CONSTRAINT'", "'CONNECTION'", "'mediumblob'", 
		"'COMPACT'", "'PRIMARY'", "'TINYBLOB'", "'LONGBLOB'", "'SET'", "'PARTIAL'", 
		"'COLUMNS'", "'TIMESTAMP'", "'NODEGROUP'", "'RANGE'", "'DECIMAL'", "'MAXVALUE'", 
		"'DYNAMIC'", "'INSERT_METHOD'", "'='", "'NOT NULL'", "'drop'", "'FLOAT'", 
		"'timestamp'", "'IF NOT EXISTS'", "'PARSER'", "'INT'", "'varbinary'", 
		"'ENGINE'", "'real'", "'INTEGER'", "'enum'", "'TEMPORARY'", "'DIRECTORY'", 
		"'MATCH'", "'ASC'", "'NUMERIC'", "'('", "'tinytext'", "'COLUMN_FORMAT'", 
		"'PACK_KEYS'", "'ALGORITHM'", "'ACTION'", "'FULL'", "'''", "'2'", "'LIST'", 
		"'COLLATE'", "'numeric'", "'longblob'", "'VALUES'", "'HASH'", "'MEMORY'", 
		"'mediumint'", "'date'", "'SIMPLE'", "'DATA'", "'LAST'", "'UPDATE'", "'ENUM'", 
		"'create'", "'IF EXISTS'", "';'", "'SUBPARTITIONS'", "'KEY'", "'SUBPARTITION'", 
		"'mediumtext'", "'PARTITIONS'", "'MEDIUMTEXT'", "'integer'", "'year'", 
		"'UNIQUE'", "'RESTRICT'", "'text'", "'SPATIAL'", "'DELAY_KEY_WRITE'", 
		"'blob'", "'AVG_ROW_LENGTH'", "'UNION'", "INTEGER", "ID", "ALPHANUMERIC", 
		"WS", "NL"
	};
	public static final int
		RULE_evaluate = 0, RULE_drop_statement = 1, RULE_create_statement = 2, 
		RULE_tbl_name = 3, RULE_create_definition = 4, RULE_column_definition = 5, 
		RULE_data_type = 6, RULE_datatype_simple = 7, RULE_datatype_length = 8, 
		RULE_datatype_ints = 9, RULE_datatype_ints_values = 10, RULE_datatype_reals = 11, 
		RULE_datatype_reals_values = 12, RULE_datatype_reals_values2 = 13, RULE_datatype_chars = 14, 
		RULE_datatype_chars_values = 15, RULE_datatype_texts = 16, RULE_datatype_texts_values = 17, 
		RULE_index_col_name = 18, RULE_index_type = 19, RULE_index_option = 20, 
		RULE_reference_definition = 21, RULE_reference_option = 22, RULE_table_options = 23, 
		RULE_table_option = 24, RULE_password_string = 25, RULE_engine_name = 26, 
		RULE_connect_string = 27, RULE_tablespace_name = 28, RULE_auto_increment_value = 29, 
		RULE_avg_row_length_value = 30, RULE_key_vlock_size_value = 31, RULE_max_rows_value = 32, 
		RULE_min_rows_value = 33, RULE_absolute_path_to_directory = 34, RULE_path = 35, 
		RULE_partition_options = 36, RULE_column_list = 37, RULE_partitions_num = 38, 
		RULE_subpartitions_num = 39, RULE_partition_definition = 40, RULE_value_list = 41, 
		RULE_partition_name = 42, RULE_data_dir = 43, RULE_index_dir = 44, RULE_max_number_of_rows = 45, 
		RULE_min_number_of_rows = 46, RULE_node_group_id = 47, RULE_subpartition_definition = 48, 
		RULE_logical_name = 49, RULE_key_block_size_value = 50, RULE_length = 51, 
		RULE_decimals = 52, RULE_unsigned = 53, RULE_zerofill = 54, RULE_binary = 55, 
		RULE_nullable = 56, RULE_auto_increment = 57, RULE_unique = 58, RULE_primary = 59, 
		RULE_foreign = 60, RULE_column_format = 61, RULE_storage = 62, RULE_expr = 63, 
		RULE_charset_name = 64, RULE_collation_name = 65, RULE_enum_value = 66, 
		RULE_set_value = 67, RULE_spatial_type = 68, RULE_parser_name = 69, RULE_col_name = 70, 
		RULE_symbol = 71, RULE_index_name = 72, RULE_default_value = 73, RULE_comment_string = 74;
	public static final String[] ruleNames = {
		"evaluate", "drop_statement", "create_statement", "tbl_name", "create_definition", 
		"column_definition", "data_type", "datatype_simple", "datatype_length", 
		"datatype_ints", "datatype_ints_values", "datatype_reals", "datatype_reals_values", 
		"datatype_reals_values2", "datatype_chars", "datatype_chars_values", "datatype_texts", 
		"datatype_texts_values", "index_col_name", "index_type", "index_option", 
		"reference_definition", "reference_option", "table_options", "table_option", 
		"password_string", "engine_name", "connect_string", "tablespace_name", 
		"auto_increment_value", "avg_row_length_value", "key_vlock_size_value", 
		"max_rows_value", "min_rows_value", "absolute_path_to_directory", "path", 
		"partition_options", "column_list", "partitions_num", "subpartitions_num", 
		"partition_definition", "value_list", "partition_name", "data_dir", "index_dir", 
		"max_number_of_rows", "min_number_of_rows", "node_group_id", "subpartition_definition", 
		"logical_name", "key_block_size_value", "length", "decimals", "unsigned", 
		"zerofill", "binary", "nullable", "auto_increment", "unique", "primary", 
		"foreign", "column_format", "storage", "expr", "charset_name", "collation_name", 
		"enum_value", "set_value", "spatial_type", "parser_name", "col_name", 
		"symbol", "index_name", "default_value", "comment_string"
	};

	@Override
	public String getGrammarFileName() { return "CreateTable.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  // Old String default
	  private StringBuilder myString = new StringBuilder("tables: ");

	  private void addString(String s){
	    if(s!=null && s.length() > 0){
	        myString.append(s);
	     }
	  }



	public CreateTableParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvaluateContext extends ParserRuleContext {
		public String result;
		public Drop_statementContext drop_statement(int i) {
			return getRuleContext(Drop_statementContext.class,i);
		}
		public List<Drop_statementContext> drop_statement() {
			return getRuleContexts(Drop_statementContext.class);
		}
		public List<Create_statementContext> create_statement() {
			return getRuleContexts(Create_statementContext.class);
		}
		public Create_statementContext create_statement(int i) {
			return getRuleContext(Create_statementContext.class,i);
		}
		public EvaluateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterEvaluate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitEvaluate(this);
		}
	}

	public final EvaluateContext evaluate() throws RecognitionException {
		EvaluateContext _localctx = new EvaluateContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_evaluate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				switch (_input.LA(1)) {
				case T__130:
				case T__57:
					{
					setState(150); drop_statement();
					}
					break;
				case T__91:
				case T__18:
					{
					setState(151); create_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(154); match(T__16);
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__130 || _la==T__91 || _la==T__57 || _la==T__18 );
			 ((EvaluateContext)_localctx).result =  myString.toString(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_statementContext extends ParserRuleContext {
		public Tbl_nameContext tbl_name() {
			return getRuleContext(Tbl_nameContext.class,0);
		}
		public Drop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDrop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDrop_statement(this);
		}
	}

	public final Drop_statementContext drop_statement() throws RecognitionException {
		Drop_statementContext _localctx = new Drop_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_drop_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==T__130 || _la==T__57) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(163);
			_la = _input.LA(1);
			if ( !(_la==T__148 || _la==T__133) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(165);
			_la = _input.LA(1);
			if (_la==T__103 || _la==T__17) {
				{
				setState(164);
				_la = _input.LA(1);
				if ( !(_la==T__103 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(167); tbl_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_statementContext extends ParserRuleContext {
		public Tbl_nameContext tbl_name() {
			return getRuleContext(Tbl_nameContext.class,0);
		}
		public Create_definitionContext create_definition(int i) {
			return getRuleContext(Create_definitionContext.class,i);
		}
		public Partition_optionsContext partition_options() {
			return getRuleContext(Partition_optionsContext.class,0);
		}
		public Table_optionsContext table_options() {
			return getRuleContext(Table_optionsContext.class,0);
		}
		public List<Create_definitionContext> create_definition() {
			return getRuleContexts(Create_definitionContext.class);
		}
		public Create_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterCreate_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitCreate_statement(this);
		}
	}

	public final Create_statementContext create_statement() throws RecognitionException {
		Create_statementContext _localctx = new Create_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_create_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !(_la==T__91 || _la==T__18) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(171);
			_la = _input.LA(1);
			if (_la==T__100 || _la==T__46) {
				{
				setState(170);
				_la = _input.LA(1);
				if ( !(_la==T__100 || _la==T__46) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(173);
			_la = _input.LA(1);
			if ( !(_la==T__148 || _la==T__133) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(175);
			_la = _input.LA(1);
			if (_la==T__90 || _la==T__54) {
				{
				setState(174);
				_la = _input.LA(1);
				if ( !(_la==T__90 || _la==T__54) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(177); tbl_name();
			setState(179);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(178); match(T__41);
				}
			}

			setState(181); create_definition();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__120) {
				{
				{
				setState(182); match(T__120);
				setState(183); create_definition();
				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
			_la = _input.LA(1);
			if (_la==T__151) {
				{
				setState(189); match(T__151);
				}
			}

			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__167) | (1L << T__163) | (1L << T__160) | (1L << T__153) | (1L << T__147) | (1L << T__143) | (1L << T__141) | (1L << T__140) | (1L << T__129) | (1L << T__117))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__105 - 65)) | (1L << (T__82 - 65)) | (1L << (T__77 - 65)) | (1L << (T__75 - 65)) | (1L << (T__60 - 65)) | (1L << (T__50 - 65)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (T__38 - 132)) | (1L << (T__31 - 132)) | (1L << (T__22 - 132)) | (1L << (T__3 - 132)) | (1L << (T__1 - 132)) | (1L << (T__0 - 132)))) != 0)) {
				{
				setState(192); table_options();
				}
			}

			setState(196);
			_la = _input.LA(1);
			if (_la==T__123) {
				{
				setState(195); partition_options();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tbl_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Tbl_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tbl_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterTbl_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitTbl_name(this);
		}
	}

	public final Tbl_nameContext tbl_name() throws RecognitionException {
		Tbl_nameContext _localctx = new Tbl_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tbl_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_definitionContext extends ParserRuleContext {
		public Index_optionContext index_option(int i) {
			return getRuleContext(Index_optionContext.class,i);
		}
		public Index_col_nameContext index_col_name(int i) {
			return getRuleContext(Index_col_nameContext.class,i);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Index_col_nameContext> index_col_name() {
			return getRuleContexts(Index_col_nameContext.class);
		}
		public List<Index_optionContext> index_option() {
			return getRuleContexts(Index_optionContext.class);
		}
		public Column_definitionContext column_definition() {
			return getRuleContext(Column_definitionContext.class,0);
		}
		public Index_typeContext index_type() {
			return getRuleContext(Index_typeContext.class,0);
		}
		public Col_nameContext col_name() {
			return getRuleContext(Col_nameContext.class,0);
		}
		public ForeignContext foreign() {
			return getRuleContext(ForeignContext.class,0);
		}
		public Index_nameContext index_name() {
			return getRuleContext(Index_nameContext.class,0);
		}
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public UniqueContext unique() {
			return getRuleContext(UniqueContext.class,0);
		}
		public Reference_definitionContext reference_definition() {
			return getRuleContext(Reference_definitionContext.class,0);
		}
		public Create_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterCreate_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitCreate_definition(this);
		}
	}

	public final Create_definitionContext create_definition() throws RecognitionException {
		Create_definitionContext _localctx = new Create_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_create_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(200); col_name();
				setState(201); column_definition();
				}
				break;
			case 2:
				{
				setState(207);
				_la = _input.LA(1);
				if (_la==T__76) {
					{
					setState(203); match(T__76);
					setState(205);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(204); symbol();
						}
					}

					}
				}

				setState(209); primary();
				setState(211);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(210); index_type();
					}
					break;
				}
				setState(214);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(213); match(T__41);
					}
				}

				setState(224);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(216); index_col_name();
					setState(221);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(217); match(T__120);
							setState(218); index_col_name();
							}
							} 
						}
						setState(223);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
					}
					}
				}

				setState(227);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(226); match(T__151);
					}
					break;
				}
				setState(237);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(229); index_option();
					setState(234);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(230); match(T__120);
							setState(231); index_option();
							}
							} 
						}
						setState(236);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 3:
				{
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==T__169 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(241);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(240); index_name();
					}
					break;
				}
				setState(244);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(243); index_type();
					}
					break;
				}
				setState(247);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(246); match(T__41);
					}
				}

				setState(257);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(249); index_col_name();
					setState(254);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(250); match(T__120);
							setState(251); index_col_name();
							}
							} 
						}
						setState(256);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
					}
					}
				}

				setState(260);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(259); match(T__151);
					}
					break;
				}
				setState(270);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(262); index_option();
					setState(267);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(263); match(T__120);
							setState(264); index_option();
							}
							} 
						}
						setState(269);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 4:
				{
				setState(276);
				_la = _input.LA(1);
				if (_la==T__76) {
					{
					setState(272); match(T__76);
					setState(274);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(273); symbol();
						}
					}

					}
				}

				setState(278); unique();
				setState(280);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(279); index_name();
					}
					break;
				}
				setState(283);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(282); index_type();
					}
					break;
				}
				setState(286);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(285); match(T__41);
					}
				}

				setState(296);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(288); index_col_name();
					setState(293);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(289); match(T__120);
							setState(290); index_col_name();
							}
							} 
						}
						setState(295);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
					}
					}
				}

				setState(299);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(298); match(T__151);
					}
					break;
				}
				setState(309);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(301); index_option();
					setState(306);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(302); match(T__120);
							setState(303); index_option();
							}
							} 
						}
						setState(308);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 5:
				{
				setState(311);
				_la = _input.LA(1);
				if ( !(_la==T__104 || _la==T__4) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(313);
				_la = _input.LA(1);
				if (_la==T__169 || _la==T__14) {
					{
					setState(312);
					_la = _input.LA(1);
					if ( !(_la==T__169 || _la==T__14) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(316);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(315); index_name();
					}
					break;
				}
				setState(319);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(318); match(T__41);
					}
				}

				setState(329);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(321); index_col_name();
					setState(326);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(322); match(T__120);
							setState(323); index_col_name();
							}
							} 
						}
						setState(328);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
					}
					}
				}

				setState(332);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(331); match(T__151);
					}
					break;
				}
				setState(342);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(334); index_option();
					setState(339);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(335); match(T__120);
							setState(336); index_option();
							}
							} 
						}
						setState(341);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(348);
				_la = _input.LA(1);
				if (_la==T__76) {
					{
					setState(344); match(T__76);
					setState(346);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(345); symbol();
						}
					}

					}
				}

				setState(350); foreign();
				setState(352);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(351); index_name();
					}
					break;
				}
				setState(355);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(354); match(T__41);
					}
				}

				setState(365);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(357); index_col_name();
					setState(362);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__120) {
						{
						{
						setState(358); match(T__120);
						setState(359); index_col_name();
						}
						}
						setState(364);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(368);
				_la = _input.LA(1);
				if (_la==T__151) {
					{
					setState(367); match(T__151);
					}
				}

				setState(370); reference_definition();
				}
				break;
			case 7:
				{
				setState(372); match(T__125);
				{
				setState(373); expr();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_definitionContext extends ParserRuleContext {
		public Column_formatContext column_format() {
			return getRuleContext(Column_formatContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Auto_incrementContext auto_increment() {
			return getRuleContext(Auto_incrementContext.class,0);
		}
		public StorageContext storage() {
			return getRuleContext(StorageContext.class,0);
		}
		public Default_valueContext default_value() {
			return getRuleContext(Default_valueContext.class,0);
		}
		public NullableContext nullable() {
			return getRuleContext(NullableContext.class,0);
		}
		public Data_typeContext data_type() {
			return getRuleContext(Data_typeContext.class,0);
		}
		public UniqueContext unique() {
			return getRuleContext(UniqueContext.class,0);
		}
		public Reference_definitionContext reference_definition() {
			return getRuleContext(Reference_definitionContext.class,0);
		}
		public Comment_stringContext comment_string() {
			return getRuleContext(Comment_stringContext.class,0);
		}
		public Column_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterColumn_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitColumn_definition(this);
		}
	}

	public final Column_definitionContext column_definition() throws RecognitionException {
		Column_definitionContext _localctx = new Column_definitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_column_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376); data_type();
			setState(378);
			_la = _input.LA(1);
			if (_la==T__132 || _la==T__122 || _la==T__95 || _la==T__58) {
				{
				setState(377); nullable();
				}
			}

			setState(382);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(380); match(T__105);
				setState(381); default_value();
				}
				break;
			}
			setState(385);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(384); auto_increment();
				}
				break;
			}
			setState(389);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(387); unique();
				}
				break;
			case T__72:
			case T__14:
				{
				setState(388); primary();
				}
				break;
			case T__167:
			case T__163:
			case T__160:
			case T__153:
			case T__151:
			case T__147:
			case T__143:
			case T__141:
			case T__140:
			case T__134:
			case T__131:
			case T__129:
			case T__123:
			case T__120:
			case T__117:
			case T__105:
			case T__82:
			case T__77:
			case T__75:
			case T__60:
			case T__50:
			case T__39:
			case T__38:
			case T__31:
			case T__22:
			case T__16:
			case T__3:
			case T__1:
			case T__0:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(393);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(391); match(T__163);
				setState(392); comment_string();
				}
				break;
			}
			setState(397);
			_la = _input.LA(1);
			if (_la==T__39) {
				{
				setState(395); match(T__39);
				setState(396); column_format();
				}
			}

			setState(401);
			_la = _input.LA(1);
			if (_la==T__131) {
				{
				setState(399); match(T__131);
				setState(400); storage();
				}
			}

			setState(404);
			_la = _input.LA(1);
			if (_la==T__134) {
				{
				setState(403); reference_definition();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_typeContext extends ParserRuleContext {
		public Datatype_charsContext datatype_chars() {
			return getRuleContext(Datatype_charsContext.class,0);
		}
		public List<Enum_valueContext> enum_value() {
			return getRuleContexts(Enum_valueContext.class);
		}
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Charset_nameContext charset_name() {
			return getRuleContext(Charset_nameContext.class,0);
		}
		public Enum_valueContext enum_value(int i) {
			return getRuleContext(Enum_valueContext.class,i);
		}
		public Set_valueContext set_value(int i) {
			return getRuleContext(Set_valueContext.class,i);
		}
		public List<Set_valueContext> set_value() {
			return getRuleContexts(Set_valueContext.class);
		}
		public Datatype_simpleContext datatype_simple() {
			return getRuleContext(Datatype_simpleContext.class,0);
		}
		public Datatype_intsContext datatype_ints() {
			return getRuleContext(Datatype_intsContext.class,0);
		}
		public Datatype_textsContext datatype_texts() {
			return getRuleContext(Datatype_textsContext.class,0);
		}
		public Datatype_realsContext datatype_reals() {
			return getRuleContext(Datatype_realsContext.class,0);
		}
		public Datatype_lengthContext datatype_length() {
			return getRuleContext(Datatype_lengthContext.class,0);
		}
		public Data_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterData_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitData_type(this);
		}
	}

	public final Data_typeContext data_type() throws RecognitionException {
		Data_typeContext _localctx = new Data_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_data_type);
		int _la;
		try {
			setState(452);
			switch (_input.LA(1)) {
			case T__168:
			case T__154:
			case T__136:
			case T__135:
			case T__115:
			case T__111:
			case T__107:
			case T__102:
			case T__84:
			case T__74:
			case T__71:
			case T__70:
			case T__66:
			case T__55:
			case T__29:
			case T__24:
			case T__8:
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(406); datatype_simple();
				}
				break;
			case T__127:
			case T__124:
			case T__96:
			case T__80:
			case T__78:
			case T__51:
				enterOuterAlt(_localctx, 2);
				{
				setState(407); datatype_length();
				}
				break;
			case T__162:
			case T__139:
			case T__137:
			case T__119:
			case T__118:
			case T__108:
			case T__93:
			case T__79:
			case T__52:
			case T__48:
			case T__25:
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(408); datatype_ints();
				}
				break;
			case T__161:
			case T__158:
			case T__116:
			case T__87:
			case T__86:
			case T__63:
			case T__56:
			case T__49:
			case T__42:
			case T__30:
				enterOuterAlt(_localctx, 4);
				{
				setState(409); datatype_reals();
				}
				break;
			case T__164:
			case T__155:
			case T__149:
			case T__99:
				enterOuterAlt(_localctx, 5);
				{
				setState(410); datatype_chars();
				}
				break;
			case T__156:
			case T__150:
			case T__128:
			case T__110:
			case T__40:
			case T__12:
			case T__10:
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(411); datatype_texts();
				}
				break;
			case T__47:
			case T__19:
				enterOuterAlt(_localctx, 7);
				{
				setState(412);
				_la = _input.LA(1);
				if ( !(_la==T__47 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(413); match(T__41);
				{
				setState(414); enum_value();
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__120) {
					{
					{
					setState(415); match(T__120);
					setState(416); enum_value();
					}
					}
					setState(421);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(422); match(T__151);
				setState(426);
				switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
				case 1:
					{
					setState(423); match(T__147);
					setState(424); match(T__69);
					setState(425); charset_name();
					}
					break;
				}
				setState(430);
				switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
				case 1:
					{
					setState(428); match(T__31);
					setState(429); collation_name();
					}
					break;
				}
				}
				break;
			case T__112:
			case T__69:
				enterOuterAlt(_localctx, 8);
				{
				setState(432);
				_la = _input.LA(1);
				if ( !(_la==T__112 || _la==T__69) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(433); match(T__41);
				{
				setState(434); set_value();
				setState(439);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__120) {
					{
					{
					setState(435); match(T__120);
					setState(436); set_value();
					}
					}
					setState(441);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(442); match(T__151);
				setState(446);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(443); match(T__147);
					setState(444); match(T__69);
					setState(445); charset_name();
					}
					break;
				}
				setState(450);
				switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
				case 1:
					{
					setState(448); match(T__31);
					setState(449); collation_name();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_simpleContext extends ParserRuleContext {
		public Datatype_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_simple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_simple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_simple(this);
		}
	}

	public final Datatype_simpleContext datatype_simple() throws RecognitionException {
		Datatype_simpleContext _localctx = new Datatype_simpleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_datatype_simple);
		int _la;
		try {
			setState(463);
			switch (_input.LA(1)) {
			case T__107:
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				_la = _input.LA(1);
				if ( !(_la==T__107 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__115:
			case T__84:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				_la = _input.LA(1);
				if ( !(_la==T__115 || _la==T__84) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__66:
			case T__55:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				_la = _input.LA(1);
				if ( !(_la==T__66 || _la==T__55) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__136:
			case T__135:
				enterOuterAlt(_localctx, 4);
				{
				setState(457);
				_la = _input.LA(1);
				if ( !(_la==T__136 || _la==T__135) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__154:
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(458);
				_la = _input.LA(1);
				if ( !(_la==T__154 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__168:
			case T__71:
				enterOuterAlt(_localctx, 6);
				{
				setState(459);
				_la = _input.LA(1);
				if ( !(_la==T__168 || _la==T__71) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__102:
			case T__2:
				enterOuterAlt(_localctx, 7);
				{
				setState(460);
				_la = _input.LA(1);
				if ( !(_la==T__102 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__111:
			case T__74:
				enterOuterAlt(_localctx, 8);
				{
				setState(461);
				_la = _input.LA(1);
				if ( !(_la==T__111 || _la==T__74) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__70:
			case T__29:
				enterOuterAlt(_localctx, 9);
				{
				setState(462);
				_la = _input.LA(1);
				if ( !(_la==T__70 || _la==T__29) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_lengthContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public Datatype_lengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_length(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_length(this);
		}
	}

	public final Datatype_lengthContext datatype_length() throws RecognitionException {
		Datatype_lengthContext _localctx = new Datatype_lengthContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_datatype_length);
		int _la;
		try {
			setState(484);
			switch (_input.LA(1)) {
			case T__96:
			case T__80:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				_la = _input.LA(1);
				if ( !(_la==T__96 || _la==T__80) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(470);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(466); match(T__41);
					setState(467); length();
					setState(468); match(T__151);
					}
				}

				}
				break;
			case T__127:
			case T__78:
				enterOuterAlt(_localctx, 2);
				{
				setState(472); binary();
				setState(477);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(473); match(T__41);
					setState(474); length();
					setState(475); match(T__151);
					}
				}

				}
				break;
			case T__124:
			case T__51:
				enterOuterAlt(_localctx, 3);
				{
				setState(479);
				_la = _input.LA(1);
				if ( !(_la==T__124 || _la==T__51) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(480); match(T__41);
				setState(481); length();
				setState(482); match(T__151);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_intsContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public ZerofillContext zerofill() {
			return getRuleContext(ZerofillContext.class,0);
		}
		public UnsignedContext unsigned() {
			return getRuleContext(UnsignedContext.class,0);
		}
		public Datatype_ints_valuesContext datatype_ints_values() {
			return getRuleContext(Datatype_ints_valuesContext.class,0);
		}
		public Datatype_intsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_ints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_ints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_ints(this);
		}
	}

	public final Datatype_intsContext datatype_ints() throws RecognitionException {
		Datatype_intsContext _localctx = new Datatype_intsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_datatype_ints);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486); datatype_ints_values();
			setState(491);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(487); match(T__41);
				setState(488); length();
				setState(489); match(T__151);
				}
			}

			setState(494);
			_la = _input.LA(1);
			if (_la==T__152 || _la==T__146) {
				{
				setState(493); unsigned();
				}
			}

			setState(497);
			_la = _input.LA(1);
			if (_la==T__145 || _la==T__101) {
				{
				setState(496); zerofill();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_ints_valuesContext extends ParserRuleContext {
		public Datatype_ints_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_ints_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_ints_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_ints_values(this);
		}
	}

	public final Datatype_ints_valuesContext datatype_ints_values() throws RecognitionException {
		Datatype_ints_valuesContext _localctx = new Datatype_ints_valuesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_datatype_ints_values);
		int _la;
		try {
			setState(505);
			switch (_input.LA(1)) {
			case T__137:
			case T__79:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				_la = _input.LA(1);
				if ( !(_la==T__137 || _la==T__79) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__139:
			case T__93:
				enterOuterAlt(_localctx, 2);
				{
				setState(500);
				_la = _input.LA(1);
				if ( !(_la==T__139 || _la==T__93) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__162:
			case T__25:
				enterOuterAlt(_localctx, 3);
				{
				setState(501);
				_la = _input.LA(1);
				if ( !(_la==T__162 || _la==T__25) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__118:
			case T__52:
				enterOuterAlt(_localctx, 4);
				{
				setState(502);
				_la = _input.LA(1);
				if ( !(_la==T__118 || _la==T__52) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__48:
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(503);
				_la = _input.LA(1);
				if ( !(_la==T__48 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__119:
			case T__108:
				enterOuterAlt(_localctx, 6);
				{
				setState(504);
				_la = _input.LA(1);
				if ( !(_la==T__119 || _la==T__108) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_realsContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public ZerofillContext zerofill() {
			return getRuleContext(ZerofillContext.class,0);
		}
		public DecimalsContext decimals() {
			return getRuleContext(DecimalsContext.class,0);
		}
		public Datatype_reals_values2Context datatype_reals_values2() {
			return getRuleContext(Datatype_reals_values2Context.class,0);
		}
		public UnsignedContext unsigned() {
			return getRuleContext(UnsignedContext.class,0);
		}
		public Datatype_reals_valuesContext datatype_reals_values() {
			return getRuleContext(Datatype_reals_valuesContext.class,0);
		}
		public Datatype_realsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_reals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_reals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_reals(this);
		}
	}

	public final Datatype_realsContext datatype_reals() throws RecognitionException {
		Datatype_realsContext _localctx = new Datatype_realsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_datatype_reals);
		int _la;
		try {
			setState(539);
			switch (_input.LA(1)) {
			case T__161:
			case T__158:
			case T__87:
			case T__86:
			case T__56:
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(507); datatype_reals_values();
				setState(514);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(508); match(T__41);
					setState(509); length();
					setState(510); match(T__120);
					setState(511); decimals();
					setState(512); match(T__151);
					}
				}

				setState(517);
				_la = _input.LA(1);
				if (_la==T__152 || _la==T__146) {
					{
					setState(516); unsigned();
					}
				}

				setState(520);
				_la = _input.LA(1);
				if (_la==T__145 || _la==T__101) {
					{
					setState(519); zerofill();
					}
				}

				}
				break;
			case T__116:
			case T__63:
			case T__42:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(522); datatype_reals_values2();
				setState(531);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(523); match(T__41);
					setState(524); length();
					setState(527);
					_la = _input.LA(1);
					if (_la==T__120) {
						{
						setState(525); match(T__120);
						setState(526); decimals();
						}
					}

					setState(529); match(T__151);
					}
				}

				setState(534);
				_la = _input.LA(1);
				if (_la==T__152 || _la==T__146) {
					{
					setState(533); unsigned();
					}
				}

				setState(537);
				_la = _input.LA(1);
				if (_la==T__145 || _la==T__101) {
					{
					setState(536); zerofill();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_reals_valuesContext extends ParserRuleContext {
		public Datatype_reals_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_reals_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_reals_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_reals_values(this);
		}
	}

	public final Datatype_reals_valuesContext datatype_reals_values() throws RecognitionException {
		Datatype_reals_valuesContext _localctx = new Datatype_reals_valuesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_datatype_reals_values);
		int _la;
		try {
			setState(544);
			switch (_input.LA(1)) {
			case T__86:
			case T__49:
				enterOuterAlt(_localctx, 1);
				{
				setState(541);
				_la = _input.LA(1);
				if ( !(_la==T__86 || _la==T__49) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__161:
			case T__87:
				enterOuterAlt(_localctx, 2);
				{
				setState(542);
				_la = _input.LA(1);
				if ( !(_la==T__161 || _la==T__87) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__158:
			case T__56:
				enterOuterAlt(_localctx, 3);
				{
				setState(543);
				_la = _input.LA(1);
				if ( !(_la==T__158 || _la==T__56) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_reals_values2Context extends ParserRuleContext {
		public Datatype_reals_values2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_reals_values2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_reals_values2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_reals_values2(this);
		}
	}

	public final Datatype_reals_values2Context datatype_reals_values2() throws RecognitionException {
		Datatype_reals_values2Context _localctx = new Datatype_reals_values2Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_datatype_reals_values2);
		int _la;
		try {
			setState(548);
			switch (_input.LA(1)) {
			case T__116:
			case T__63:
				enterOuterAlt(_localctx, 1);
				{
				setState(546);
				_la = _input.LA(1);
				if ( !(_la==T__116 || _la==T__63) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__42:
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				_la = _input.LA(1);
				if ( !(_la==T__42 || _la==T__30) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_charsContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Charset_nameContext charset_name() {
			return getRuleContext(Charset_nameContext.class,0);
		}
		public Datatype_chars_valuesContext datatype_chars_values() {
			return getRuleContext(Datatype_chars_valuesContext.class,0);
		}
		public Datatype_charsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_chars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_chars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_chars(this);
		}
	}

	public final Datatype_charsContext datatype_chars() throws RecognitionException {
		Datatype_charsContext _localctx = new Datatype_charsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_datatype_chars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550); datatype_chars_values();
			setState(555);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(551); match(T__41);
				setState(552); length();
				setState(553); match(T__151);
				}
			}

			setState(558);
			_la = _input.LA(1);
			if (_la==T__127 || _la==T__78) {
				{
				setState(557); binary();
				}
			}

			setState(563);
			switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
			case 1:
				{
				setState(560); match(T__147);
				setState(561); match(T__69);
				setState(562); charset_name();
				}
				break;
			}
			setState(567);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(565); match(T__31);
				setState(566); collation_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_chars_valuesContext extends ParserRuleContext {
		public Datatype_chars_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_chars_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_chars_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_chars_values(this);
		}
	}

	public final Datatype_chars_valuesContext datatype_chars_values() throws RecognitionException {
		Datatype_chars_valuesContext _localctx = new Datatype_chars_valuesContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_datatype_chars_values);
		int _la;
		try {
			setState(571);
			switch (_input.LA(1)) {
			case T__155:
			case T__149:
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				_la = _input.LA(1);
				if ( !(_la==T__155 || _la==T__149) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__164:
			case T__99:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				_la = _input.LA(1);
				if ( !(_la==T__164 || _la==T__99) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_textsContext extends ParserRuleContext {
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Charset_nameContext charset_name() {
			return getRuleContext(Charset_nameContext.class,0);
		}
		public Datatype_texts_valuesContext datatype_texts_values() {
			return getRuleContext(Datatype_texts_valuesContext.class,0);
		}
		public Datatype_textsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_texts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_texts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_texts(this);
		}
	}

	public final Datatype_textsContext datatype_texts() throws RecognitionException {
		Datatype_textsContext _localctx = new Datatype_textsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_datatype_texts);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573); datatype_texts_values();
			setState(575);
			_la = _input.LA(1);
			if (_la==T__127 || _la==T__78) {
				{
				setState(574); binary();
				}
			}

			setState(580);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(577); match(T__147);
				setState(578); match(T__69);
				setState(579); charset_name();
				}
				break;
			}
			setState(584);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(582); match(T__31);
				setState(583); collation_name();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datatype_texts_valuesContext extends ParserRuleContext {
		public Datatype_texts_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype_texts_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDatatype_texts_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDatatype_texts_values(this);
		}
	}

	public final Datatype_texts_valuesContext datatype_texts_values() throws RecognitionException {
		Datatype_texts_valuesContext _localctx = new Datatype_texts_valuesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_datatype_texts_values);
		int _la;
		try {
			setState(590);
			switch (_input.LA(1)) {
			case T__110:
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				_la = _input.LA(1);
				if ( !(_la==T__110 || _la==T__40) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__128:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				_la = _input.LA(1);
				if ( !(_la==T__128 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__12:
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(588);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__10) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case T__156:
			case T__150:
				enterOuterAlt(_localctx, 4);
				{
				setState(589);
				_la = _input.LA(1);
				if ( !(_la==T__156 || _la==T__150) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_col_nameContext extends ParserRuleContext {
		public LengthContext length() {
			return getRuleContext(LengthContext.class,0);
		}
		public Col_nameContext col_name() {
			return getRuleContext(Col_nameContext.class,0);
		}
		public Index_col_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_col_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterIndex_col_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitIndex_col_name(this);
		}
	}

	public final Index_col_nameContext index_col_name() throws RecognitionException {
		Index_col_nameContext _localctx = new Index_col_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_index_col_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592); col_name();
			setState(597);
			_la = _input.LA(1);
			if (_la==T__41) {
				{
				setState(593); match(T__41);
				setState(594); length();
				setState(595); match(T__151);
				}
			}

			setState(600);
			_la = _input.LA(1);
			if (_la==T__142 || _la==T__43) {
				{
				setState(599);
				_la = _input.LA(1);
				if ( !(_la==T__142 || _la==T__43) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_typeContext extends ParserRuleContext {
		public Index_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterIndex_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitIndex_type(this);
		}
	}

	public final Index_typeContext index_type() throws RecognitionException {
		Index_typeContext _localctx = new Index_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_index_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602); match(T__97);
			setState(603);
			_la = _input.LA(1);
			if ( !(_la==T__144 || _la==T__27) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_optionContext extends ParserRuleContext {
		public Index_typeContext index_type() {
			return getRuleContext(Index_typeContext.class,0);
		}
		public Key_block_size_valueContext key_block_size_value() {
			return getRuleContext(Key_block_size_valueContext.class,0);
		}
		public Comment_stringContext comment_string() {
			return getRuleContext(Comment_stringContext.class,0);
		}
		public Parser_nameContext parser_name() {
			return getRuleContext(Parser_nameContext.class,0);
		}
		public Index_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterIndex_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitIndex_option(this);
		}
	}

	public final Index_optionContext index_option() throws RecognitionException {
		Index_optionContext _localctx = new Index_optionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_index_option);
		int _la;
		try {
			setState(616);
			switch (_input.LA(1)) {
			case T__167:
				enterOuterAlt(_localctx, 1);
				{
				setState(605); match(T__167);
				setState(607);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(606); match(T__59);
					}
				}

				setState(609); key_block_size_value();
				}
				break;
			case T__97:
				enterOuterAlt(_localctx, 2);
				{
				setState(610); index_type();
				}
				break;
			case T__83:
				enterOuterAlt(_localctx, 3);
				{
				setState(611); match(T__83);
				setState(612); match(T__53);
				setState(613); parser_name();
				}
				break;
			case T__163:
				enterOuterAlt(_localctx, 4);
				{
				setState(614); match(T__163);
				setState(615); comment_string();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reference_definitionContext extends ParserRuleContext {
		public Reference_optionContext reference_option(int i) {
			return getRuleContext(Reference_optionContext.class,i);
		}
		public Tbl_nameContext tbl_name() {
			return getRuleContext(Tbl_nameContext.class,0);
		}
		public Index_col_nameContext index_col_name(int i) {
			return getRuleContext(Index_col_nameContext.class,i);
		}
		public List<Reference_optionContext> reference_option() {
			return getRuleContexts(Reference_optionContext.class);
		}
		public List<Index_col_nameContext> index_col_name() {
			return getRuleContexts(Index_col_nameContext.class);
		}
		public Reference_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterReference_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitReference_definition(this);
		}
	}

	public final Reference_definitionContext reference_definition() throws RecognitionException {
		Reference_definitionContext _localctx = new Reference_definitionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_reference_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(618); match(T__134);
			setState(619); tbl_name();
			setState(634);
			_la = _input.LA(1);
			if (_la==T__41 || _la==ID) {
				{
				setState(621);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(620); match(T__41);
					}
				}

				setState(623); index_col_name();
				setState(628);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(624); match(T__120);
						setState(625); index_col_name();
						}
						} 
					}
					setState(630);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
				}
				setState(632);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(631); match(T__151);
					}
					break;
				}
				}
			}

			setState(642);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(636); match(T__44);
				setState(637); match(T__35);
				}
				break;
			case 2:
				{
				setState(638); match(T__44);
				setState(639); match(T__68);
				}
				break;
			case 3:
				{
				setState(640); match(T__44);
				setState(641); match(T__23);
				}
				break;
			}
			setState(647);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				setState(644); match(T__88);
				setState(645); match(T__166);
				setState(646); reference_option();
				}
				break;
			}
			setState(652);
			_la = _input.LA(1);
			if (_la==T__88) {
				{
				setState(649); match(T__88);
				setState(650); match(T__20);
				setState(651); reference_option();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reference_optionContext extends ParserRuleContext {
		public Reference_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterReference_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitReference_option(this);
		}
	}

	public final Reference_optionContext reference_option() throws RecognitionException {
		Reference_optionContext _localctx = new Reference_optionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_reference_option);
		try {
			setState(660);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(654); match(T__6);
				}
				break;
			case T__138:
				enterOuterAlt(_localctx, 2);
				{
				setState(655); match(T__138);
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 3);
				{
				setState(656); match(T__69);
				setState(657); match(T__95);
				}
				break;
			case T__98:
				enterOuterAlt(_localctx, 4);
				{
				setState(658); match(T__98);
				setState(659); match(T__36);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_optionsContext extends ParserRuleContext {
		public List<Table_optionContext> table_option() {
			return getRuleContexts(Table_optionContext.class);
		}
		public Table_optionContext table_option(int i) {
			return getRuleContext(Table_optionContext.class,i);
		}
		public Table_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterTable_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitTable_options(this);
		}
	}

	public final Table_optionsContext table_options() throws RecognitionException {
		Table_optionsContext _localctx = new Table_optionsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_table_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662); table_option();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__167) | (1L << T__163) | (1L << T__160) | (1L << T__153) | (1L << T__147) | (1L << T__143) | (1L << T__141) | (1L << T__140) | (1L << T__129) | (1L << T__120) | (1L << T__117))) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__105 - 65)) | (1L << (T__82 - 65)) | (1L << (T__77 - 65)) | (1L << (T__75 - 65)) | (1L << (T__60 - 65)) | (1L << (T__50 - 65)))) != 0) || ((((_la - 132)) & ~0x3f) == 0 && ((1L << (_la - 132)) & ((1L << (T__38 - 132)) | (1L << (T__31 - 132)) | (1L << (T__22 - 132)) | (1L << (T__3 - 132)) | (1L << (T__1 - 132)) | (1L << (T__0 - 132)))) != 0)) {
				{
				{
				setState(664);
				_la = _input.LA(1);
				if (_la==T__120) {
					{
					setState(663); match(T__120);
					}
				}

				setState(666); table_option();
				}
				}
				setState(671);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_optionContext extends ParserRuleContext {
		public List<Tbl_nameContext> tbl_name() {
			return getRuleContexts(Tbl_nameContext.class);
		}
		public Min_rows_valueContext min_rows_value() {
			return getRuleContext(Min_rows_valueContext.class,0);
		}
		public Charset_nameContext charset_name() {
			return getRuleContext(Charset_nameContext.class,0);
		}
		public Engine_nameContext engine_name() {
			return getRuleContext(Engine_nameContext.class,0);
		}
		public Tablespace_nameContext tablespace_name() {
			return getRuleContext(Tablespace_nameContext.class,0);
		}
		public Password_stringContext password_string() {
			return getRuleContext(Password_stringContext.class,0);
		}
		public Auto_increment_valueContext auto_increment_value() {
			return getRuleContext(Auto_increment_valueContext.class,0);
		}
		public Avg_row_length_valueContext avg_row_length_value() {
			return getRuleContext(Avg_row_length_valueContext.class,0);
		}
		public Comment_stringContext comment_string() {
			return getRuleContext(Comment_stringContext.class,0);
		}
		public Key_vlock_size_valueContext key_vlock_size_value() {
			return getRuleContext(Key_vlock_size_valueContext.class,0);
		}
		public Tbl_nameContext tbl_name(int i) {
			return getRuleContext(Tbl_nameContext.class,i);
		}
		public Absolute_path_to_directoryContext absolute_path_to_directory() {
			return getRuleContext(Absolute_path_to_directoryContext.class,0);
		}
		public Collation_nameContext collation_name() {
			return getRuleContext(Collation_nameContext.class,0);
		}
		public Max_rows_valueContext max_rows_value() {
			return getRuleContext(Max_rows_valueContext.class,0);
		}
		public Connect_stringContext connect_string() {
			return getRuleContext(Connect_stringContext.class,0);
		}
		public Table_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterTable_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitTable_option(this);
		}
	}

	public final Table_optionContext table_option() throws RecognitionException {
		Table_optionContext _localctx = new Table_optionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_table_option);
		int _la;
		try {
			int _alt;
			setState(791);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(672); match(T__50);
				setState(674);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(673); match(T__59);
					}
				}

				setState(676); engine_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(677); match(T__141);
				setState(679);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(678); match(T__59);
					}
				}

				setState(681); auto_increment_value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(682); match(T__1);
				setState(684);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(683); match(T__59);
					}
				}

				setState(686); avg_row_length_value();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(688);
				_la = _input.LA(1);
				if (_la==T__105) {
					{
					setState(687); match(T__105);
					}
				}

				setState(693);
				switch (_input.LA(1)) {
				case T__147:
					{
					setState(690); match(T__147);
					setState(691); match(T__69);
					}
					break;
				case T__117:
					{
					setState(692); match(T__117);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(696);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(695); match(T__59);
					}
				}

				setState(698); charset_name();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(699); match(T__160);
				setState(701);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(700); match(T__59);
					}
				}

				setState(703);
				_la = _input.LA(1);
				if ( !(_la==T__157 || _la==T__126) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(705);
				_la = _input.LA(1);
				if (_la==T__105) {
					{
					setState(704); match(T__105);
					}
				}

				setState(707); match(T__31);
				setState(709);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(708); match(T__59);
					}
				}

				setState(711); collation_name();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(712); match(T__163);
				setState(714);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(713); match(T__59);
					}
				}

				setState(716); comment_string();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(717); match(T__75);
				setState(719);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(718); match(T__59);
					}
				}

				setState(721); connect_string();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(722); match(T__22);
				setState(723); match(T__45);
				setState(725);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(724); match(T__59);
					}
				}

				setState(727); absolute_path_to_directory();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(728); match(T__3);
				setState(730);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(729); match(T__59);
					}
				}

				setState(732);
				_la = _input.LA(1);
				if ( !(_la==T__157 || _la==T__126) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(733); match(T__140);
				setState(735);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(734); match(T__59);
					}
				}

				setState(737); absolute_path_to_directory();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(738); match(T__60);
				setState(740);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(739); match(T__59);
					}
				}

				setState(742);
				_la = _input.LA(1);
				if ( !(_la==T__106 || _la==T__98 || _la==T__21) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(743); match(T__167);
				setState(745);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(744); match(T__59);
					}
				}

				setState(747); key_vlock_size_value();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(748); match(T__82);
				setState(750);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(749); match(T__59);
					}
				}

				setState(752); max_rows_value();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(753); match(T__143);
				setState(755);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(754); match(T__59);
					}
				}

				setState(757); min_rows_value();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(758); match(T__38);
				setState(760);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(759); match(T__59);
					}
				}

				setState(762);
				_la = _input.LA(1);
				if ( !(((((_la - 13)) & ~0x3f) == 0 && ((1L << (_la - 13)) & ((1L << (T__157 - 13)) | (1L << (T__126 - 13)) | (1L << (T__105 - 13)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(763); match(T__153);
				setState(765);
				switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
				case 1:
					{
					setState(764); match(T__59);
					}
					break;
				}
				setState(767); password_string();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(768); match(T__77);
				setState(770);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(769); match(T__59);
					}
				}

				setState(772);
				_la = _input.LA(1);
				if ( !(((((_la - 56)) & ~0x3f) == 0 && ((1L << (_la - 56)) & ((1L << (T__114 - 56)) | (1L << (T__105 - 56)) | (1L << (T__92 - 56)) | (1L << (T__89 - 56)) | (1L << (T__73 - 56)) | (1L << (T__61 - 56)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(773); match(T__129);
				setState(774); tablespace_name();
				setState(777);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(775); match(T__131);
					setState(776);
					_la = _input.LA(1);
					if ( !(_la==T__105 || _la==T__85 || _la==T__26) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(779); match(T__0);
				setState(781);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(780); match(T__59);
					}
				}

				{
				setState(783); tbl_name();
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(784); match(T__120);
						setState(785); tbl_name();
						}
						} 
					}
					setState(790);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Password_stringContext extends ParserRuleContext {
		public Password_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_password_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPassword_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPassword_string(this);
		}
	}

	public final Password_stringContext password_string() throws RecognitionException {
		Password_stringContext _localctx = new Password_stringContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_password_string);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(794); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(793);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(796); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Engine_nameContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(CreateTableParser.ALPHANUMERIC, 0); }
		public Engine_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_engine_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterEngine_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitEngine_name(this);
		}
	}

	public final Engine_nameContext engine_name() throws RecognitionException {
		Engine_nameContext _localctx = new Engine_nameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_engine_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798); match(ALPHANUMERIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Connect_stringContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Connect_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connect_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterConnect_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitConnect_string(this);
		}
	}

	public final Connect_stringContext connect_string() throws RecognitionException {
		Connect_stringContext _localctx = new Connect_stringContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_connect_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tablespace_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Tablespace_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablespace_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterTablespace_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitTablespace_name(this);
		}
	}

	public final Tablespace_nameContext tablespace_name() throws RecognitionException {
		Tablespace_nameContext _localctx = new Tablespace_nameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tablespace_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Auto_increment_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Auto_increment_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auto_increment_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterAuto_increment_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitAuto_increment_value(this);
		}
	}

	public final Auto_increment_valueContext auto_increment_value() throws RecognitionException {
		Auto_increment_valueContext _localctx = new Auto_increment_valueContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_auto_increment_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Avg_row_length_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Avg_row_length_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_avg_row_length_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterAvg_row_length_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitAvg_row_length_value(this);
		}
	}

	public final Avg_row_length_valueContext avg_row_length_value() throws RecognitionException {
		Avg_row_length_valueContext _localctx = new Avg_row_length_valueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_avg_row_length_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Key_vlock_size_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Key_vlock_size_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_vlock_size_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterKey_vlock_size_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitKey_vlock_size_value(this);
		}
	}

	public final Key_vlock_size_valueContext key_vlock_size_value() throws RecognitionException {
		Key_vlock_size_valueContext _localctx = new Key_vlock_size_valueContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_key_vlock_size_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Max_rows_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Max_rows_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_rows_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterMax_rows_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitMax_rows_value(this);
		}
	}

	public final Max_rows_valueContext max_rows_value() throws RecognitionException {
		Max_rows_valueContext _localctx = new Max_rows_valueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_max_rows_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Min_rows_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Min_rows_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min_rows_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterMin_rows_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitMin_rows_value(this);
		}
	}

	public final Min_rows_valueContext min_rows_value() throws RecognitionException {
		Min_rows_valueContext _localctx = new Min_rows_valueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_min_rows_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Absolute_path_to_directoryContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Absolute_path_to_directoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolute_path_to_directory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterAbsolute_path_to_directory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitAbsolute_path_to_directory(this);
		}
	}

	public final Absolute_path_to_directoryContext absolute_path_to_directory() throws RecognitionException {
		Absolute_path_to_directoryContext _localctx = new Absolute_path_to_directoryContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_absolute_path_to_directory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814); path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CreateTableParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CreateTableParser.ID, i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_path);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(818); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(816); match(T__81);
					setState(817); match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(820); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(823);
			_la = _input.LA(1);
			if (_la==T__81) {
				{
				setState(822); match(T__81);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_optionsContext extends ParserRuleContext {
		public List<Partition_definitionContext> partition_definition() {
			return getRuleContexts(Partition_definitionContext.class);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public Column_listContext column_list(int i) {
			return getRuleContext(Column_listContext.class,i);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<Column_listContext> column_list() {
			return getRuleContexts(Column_listContext.class);
		}
		public Subpartitions_numContext subpartitions_num() {
			return getRuleContext(Subpartitions_numContext.class,0);
		}
		public Partitions_numContext partitions_num() {
			return getRuleContext(Partitions_numContext.class,0);
		}
		public Partition_definitionContext partition_definition(int i) {
			return getRuleContext(Partition_definitionContext.class,i);
		}
		public Partition_optionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_options; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPartition_options(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPartition_options(this);
		}
	}

	public final Partition_optionsContext partition_options() throws RecognitionException {
		Partition_optionsContext _localctx = new Partition_optionsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_partition_options);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(825); match(T__123);
			setState(826); match(T__121);
			setState(872);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(828);
				_la = _input.LA(1);
				if (_la==T__165) {
					{
					setState(827); match(T__165);
					}
				}

				setState(830); match(T__27);
				setState(831); match(T__41);
				setState(832); expr();
				setState(833); match(T__151);
				}
				break;
			case 2:
				{
				setState(836);
				_la = _input.LA(1);
				if (_la==T__165) {
					{
					setState(835); match(T__165);
					}
				}

				setState(838); match(T__14);
				setState(842);
				_la = _input.LA(1);
				if (_la==T__37) {
					{
					setState(839); match(T__37);
					setState(840); match(T__59);
					setState(841);
					_la = _input.LA(1);
					if ( !(_la==T__126 || _la==T__33) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
				}

				setState(844); match(T__41);
				setState(845); column_list();
				setState(846); match(T__151);
				}
				break;
			case 3:
				{
				setState(848); match(T__64);
				setState(858);
				switch (_input.LA(1)) {
				case T__41:
					{
					setState(849); match(T__41);
					setState(850); expr();
					setState(851); match(T__151);
					}
					break;
				case T__67:
					{
					setState(853); match(T__67);
					setState(854); match(T__41);
					setState(855); column_list();
					setState(856); match(T__151);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				setState(860); match(T__32);
				setState(870);
				switch (_input.LA(1)) {
				case T__41:
					{
					setState(861); match(T__41);
					setState(862); expr();
					setState(863); match(T__151);
					}
					break;
				case T__67:
					{
					setState(865); match(T__67);
					setState(866); match(T__41);
					setState(867); column_list();
					setState(868); match(T__151);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			setState(876);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(874); match(T__11);
				setState(875); partitions_num();
				}
			}

			setState(907);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(878); match(T__13);
				setState(879); match(T__121);
				setState(901);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(881);
					_la = _input.LA(1);
					if (_la==T__165) {
						{
						setState(880); match(T__165);
						}
					}

					setState(883); match(T__27);
					setState(884); match(T__41);
					setState(885); expr();
					setState(886); match(T__151);
					}
					break;
				case 2:
					{
					setState(889);
					_la = _input.LA(1);
					if (_la==T__165) {
						{
						setState(888); match(T__165);
						}
					}

					setState(891); match(T__14);
					setState(895);
					_la = _input.LA(1);
					if (_la==T__37) {
						{
						setState(892); match(T__37);
						setState(893); match(T__59);
						setState(894);
						_la = _input.LA(1);
						if ( !(_la==T__126 || _la==T__33) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						}
					}

					setState(897); match(T__41);
					setState(898); column_list();
					setState(899); match(T__151);
					}
					break;
				}
				setState(905);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(903); match(T__15);
					setState(904); subpartitions_num();
					}
				}

				}
			}

			setState(917);
			_la = _input.LA(1);
			if (_la==T__123) {
				{
				setState(909); partition_definition();
				setState(914);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__120) {
					{
					{
					setState(910); match(T__120);
					setState(911); partition_definition();
					}
					}
					setState(916);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_listContext extends ParserRuleContext {
		public List<Col_nameContext> col_name() {
			return getRuleContexts(Col_nameContext.class);
		}
		public Col_nameContext col_name(int i) {
			return getRuleContext(Col_nameContext.class,i);
		}
		public Column_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterColumn_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitColumn_list(this);
		}
	}

	public final Column_listContext column_list() throws RecognitionException {
		Column_listContext _localctx = new Column_listContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_column_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919); col_name();
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__120) {
				{
				{
				setState(920); match(T__120);
				setState(921); col_name();
				}
				}
				setState(926);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partitions_numContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Partitions_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitions_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPartitions_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPartitions_num(this);
		}
	}

	public final Partitions_numContext partitions_num() throws RecognitionException {
		Partitions_numContext _localctx = new Partitions_numContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_partitions_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(927); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subpartitions_numContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Subpartitions_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subpartitions_num; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterSubpartitions_num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitSubpartitions_num(this);
		}
	}

	public final Subpartitions_numContext subpartitions_num() throws RecognitionException {
		Subpartitions_numContext _localctx = new Subpartitions_numContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_subpartitions_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(929); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_definitionContext extends ParserRuleContext {
		public Subpartition_definitionContext subpartition_definition(int i) {
			return getRuleContext(Subpartition_definitionContext.class,i);
		}
		public List<Subpartition_definitionContext> subpartition_definition() {
			return getRuleContexts(Subpartition_definitionContext.class);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Engine_nameContext engine_name() {
			return getRuleContext(Engine_nameContext.class,0);
		}
		public Data_dirContext data_dir() {
			return getRuleContext(Data_dirContext.class,0);
		}
		public Partition_nameContext partition_name() {
			return getRuleContext(Partition_nameContext.class,0);
		}
		public Tablespace_nameContext tablespace_name() {
			return getRuleContext(Tablespace_nameContext.class,0);
		}
		public Index_dirContext index_dir() {
			return getRuleContext(Index_dirContext.class,0);
		}
		public Max_number_of_rowsContext max_number_of_rows() {
			return getRuleContext(Max_number_of_rowsContext.class,0);
		}
		public Value_listContext value_list() {
			return getRuleContext(Value_listContext.class,0);
		}
		public Node_group_idContext node_group_id() {
			return getRuleContext(Node_group_idContext.class,0);
		}
		public Min_number_of_rowsContext min_number_of_rows() {
			return getRuleContext(Min_number_of_rowsContext.class,0);
		}
		public Comment_stringContext comment_string() {
			return getRuleContext(Comment_stringContext.class,0);
		}
		public Partition_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPartition_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPartition_definition(this);
		}
	}

	public final Partition_definitionContext partition_definition() throws RecognitionException {
		Partition_definitionContext _localctx = new Partition_definitionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_partition_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(931); match(T__123);
			setState(932); partition_name();
			setState(953);
			_la = _input.LA(1);
			if (_la==T__28) {
				{
				setState(933); match(T__28);
				setState(951);
				switch (_input.LA(1)) {
				case T__109:
					{
					setState(934); match(T__109);
					setState(935); match(T__94);
					setState(944);
					switch (_input.LA(1)) {
					case T__41:
						{
						setState(936); match(T__41);
						setState(939);
						switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
						case 1:
							{
							setState(937); expr();
							}
							break;
						case 2:
							{
							setState(938); value_list();
							}
							break;
						}
						setState(941); match(T__151);
						}
						break;
					case T__62:
						{
						setState(943); match(T__62);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				case T__159:
					{
					setState(946); match(T__159);
					setState(947); match(T__41);
					setState(948); value_list();
					setState(949); match(T__151);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(963);
			_la = _input.LA(1);
			if (_la==T__131 || _la==T__50) {
				{
				setState(956);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(955); match(T__131);
					}
				}

				setState(958); match(T__50);
				setState(960);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(959); match(T__59);
					}
				}

				setState(962); engine_name();
				}
			}

			setState(970);
			_la = _input.LA(1);
			if (_la==T__163) {
				{
				setState(965); match(T__163);
				setState(967);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(966); match(T__59);
					}
				}

				setState(969); comment_string();
				}
			}

			setState(978);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(972); match(T__22);
				setState(973); match(T__45);
				setState(975);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(974); match(T__59);
					}
				}

				setState(977); data_dir();
				}
			}

			setState(986);
			_la = _input.LA(1);
			if (_la==T__169) {
				{
				setState(980); match(T__169);
				setState(981); match(T__45);
				setState(983);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(982); match(T__59);
					}
				}

				setState(985); index_dir();
				}
			}

			setState(993);
			_la = _input.LA(1);
			if (_la==T__82) {
				{
				setState(988); match(T__82);
				setState(990);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(989); match(T__59);
					}
				}

				setState(992); max_number_of_rows();
				}
			}

			setState(1000);
			_la = _input.LA(1);
			if (_la==T__143) {
				{
				setState(995); match(T__143);
				setState(997);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(996); match(T__59);
					}
				}

				setState(999); min_number_of_rows();
				}
			}

			setState(1007);
			_la = _input.LA(1);
			if (_la==T__129) {
				{
				setState(1002); match(T__129);
				setState(1004);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1003); match(T__59);
					}
				}

				setState(1006); tablespace_name();
				}
			}

			setState(1014);
			_la = _input.LA(1);
			if (_la==T__65) {
				{
				setState(1009); match(T__65);
				setState(1011);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1010); match(T__59);
					}
				}

				setState(1013); node_group_id();
				}
			}

			setState(1024);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(1016); subpartition_definition();
				setState(1021);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1017); match(T__120);
						setState(1018); subpartition_definition();
						}
						} 
					}
					setState(1023);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_listContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CreateTableParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CreateTableParser.ID, i);
		}
		public Value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterValue_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitValue_list(this);
		}
	}

	public final Value_listContext value_list() throws RecognitionException {
		Value_listContext _localctx = new Value_listContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1026); match(ID);
			setState(1031);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__120) {
				{
				{
				setState(1027); match(T__120);
				setState(1028); match(ID);
				}
				}
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Partition_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Partition_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partition_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPartition_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPartition_name(this);
		}
	}

	public final Partition_nameContext partition_name() throws RecognitionException {
		Partition_nameContext _localctx = new Partition_nameContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_partition_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1034); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Data_dirContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Data_dirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_dir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterData_dir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitData_dir(this);
		}
	}

	public final Data_dirContext data_dir() throws RecognitionException {
		Data_dirContext _localctx = new Data_dirContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_data_dir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036); path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_dirContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public Index_dirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_dir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterIndex_dir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitIndex_dir(this);
		}
	}

	public final Index_dirContext index_dir() throws RecognitionException {
		Index_dirContext _localctx = new Index_dirContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_index_dir);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1038); path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Max_number_of_rowsContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Max_number_of_rowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_number_of_rows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterMax_number_of_rows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitMax_number_of_rows(this);
		}
	}

	public final Max_number_of_rowsContext max_number_of_rows() throws RecognitionException {
		Max_number_of_rowsContext _localctx = new Max_number_of_rowsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_max_number_of_rows);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1040); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Min_number_of_rowsContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Min_number_of_rowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min_number_of_rows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterMin_number_of_rows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitMin_number_of_rows(this);
		}
	}

	public final Min_number_of_rowsContext min_number_of_rows() throws RecognitionException {
		Min_number_of_rowsContext _localctx = new Min_number_of_rowsContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_min_number_of_rows);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1042); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_group_idContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Node_group_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_group_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterNode_group_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitNode_group_id(this);
		}
	}

	public final Node_group_idContext node_group_id() throws RecognitionException {
		Node_group_idContext _localctx = new Node_group_idContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_node_group_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1044); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Subpartition_definitionContext extends ParserRuleContext {
		public Logical_nameContext logical_name() {
			return getRuleContext(Logical_nameContext.class,0);
		}
		public Engine_nameContext engine_name() {
			return getRuleContext(Engine_nameContext.class,0);
		}
		public Data_dirContext data_dir() {
			return getRuleContext(Data_dirContext.class,0);
		}
		public Tablespace_nameContext tablespace_name() {
			return getRuleContext(Tablespace_nameContext.class,0);
		}
		public Index_dirContext index_dir() {
			return getRuleContext(Index_dirContext.class,0);
		}
		public Max_number_of_rowsContext max_number_of_rows() {
			return getRuleContext(Max_number_of_rowsContext.class,0);
		}
		public Node_group_idContext node_group_id() {
			return getRuleContext(Node_group_idContext.class,0);
		}
		public Min_number_of_rowsContext min_number_of_rows() {
			return getRuleContext(Min_number_of_rowsContext.class,0);
		}
		public Comment_stringContext comment_string() {
			return getRuleContext(Comment_stringContext.class,0);
		}
		public Subpartition_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subpartition_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterSubpartition_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitSubpartition_definition(this);
		}
	}

	public final Subpartition_definitionContext subpartition_definition() throws RecognitionException {
		Subpartition_definitionContext _localctx = new Subpartition_definitionContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_subpartition_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1046); match(T__13);
			setState(1047); logical_name();
			setState(1056);
			_la = _input.LA(1);
			if (_la==T__131 || _la==T__50) {
				{
				setState(1049);
				_la = _input.LA(1);
				if (_la==T__131) {
					{
					setState(1048); match(T__131);
					}
				}

				setState(1051); match(T__50);
				setState(1053);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1052); match(T__59);
					}
				}

				setState(1055); engine_name();
				}
			}

			setState(1063);
			_la = _input.LA(1);
			if (_la==T__163) {
				{
				setState(1058); match(T__163);
				setState(1060);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1059); match(T__59);
					}
				}

				setState(1062); comment_string();
				}
			}

			setState(1071);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(1065); match(T__22);
				setState(1066); match(T__45);
				setState(1068);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1067); match(T__59);
					}
				}

				setState(1070); data_dir();
				}
			}

			setState(1079);
			_la = _input.LA(1);
			if (_la==T__169) {
				{
				setState(1073); match(T__169);
				setState(1074); match(T__45);
				setState(1076);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1075); match(T__59);
					}
				}

				setState(1078); index_dir();
				}
			}

			setState(1086);
			_la = _input.LA(1);
			if (_la==T__82) {
				{
				setState(1081); match(T__82);
				setState(1083);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1082); match(T__59);
					}
				}

				setState(1085); max_number_of_rows();
				}
			}

			setState(1093);
			_la = _input.LA(1);
			if (_la==T__143) {
				{
				setState(1088); match(T__143);
				setState(1090);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1089); match(T__59);
					}
				}

				setState(1092); min_number_of_rows();
				}
			}

			setState(1100);
			_la = _input.LA(1);
			if (_la==T__129) {
				{
				setState(1095); match(T__129);
				setState(1097);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1096); match(T__59);
					}
				}

				setState(1099); tablespace_name();
				}
			}

			setState(1107);
			_la = _input.LA(1);
			if (_la==T__65) {
				{
				setState(1102); match(T__65);
				setState(1104);
				_la = _input.LA(1);
				if (_la==T__59) {
					{
					setState(1103); match(T__59);
					}
				}

				setState(1106); node_group_id();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logical_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Logical_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterLogical_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitLogical_name(this);
		}
	}

	public final Logical_nameContext logical_name() throws RecognitionException {
		Logical_nameContext _localctx = new Logical_nameContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_logical_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1109); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Key_block_size_valueContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public Key_block_size_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_block_size_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterKey_block_size_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitKey_block_size_value(this);
		}
	}

	public final Key_block_size_valueContext key_block_size_value() throws RecognitionException {
		Key_block_size_valueContext _localctx = new Key_block_size_valueContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_key_block_size_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LengthContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public LengthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_length; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterLength(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitLength(this);
		}
	}

	public final LengthContext length() throws RecognitionException {
		LengthContext _localctx = new LengthContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_length);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1113); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecimalsContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(CreateTableParser.INTEGER, 0); }
		public DecimalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDecimals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDecimals(this);
		}
	}

	public final DecimalsContext decimals() throws RecognitionException {
		DecimalsContext _localctx = new DecimalsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_decimals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1115); match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsignedContext extends ParserRuleContext {
		public UnsignedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsigned; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterUnsigned(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitUnsigned(this);
		}
	}

	public final UnsignedContext unsigned() throws RecognitionException {
		UnsignedContext _localctx = new UnsignedContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_unsigned);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1117);
			_la = _input.LA(1);
			if ( !(_la==T__152 || _la==T__146) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ZerofillContext extends ParserRuleContext {
		public ZerofillContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_zerofill; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterZerofill(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitZerofill(this);
		}
	}

	public final ZerofillContext zerofill() throws RecognitionException {
		ZerofillContext _localctx = new ZerofillContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_zerofill);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			_la = _input.LA(1);
			if ( !(_la==T__145 || _la==T__101) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryContext extends ParserRuleContext {
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitBinary(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1121);
			_la = _input.LA(1);
			if ( !(_la==T__127 || _la==T__78) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullableContext extends ParserRuleContext {
		public NullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterNullable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitNullable(this);
		}
	}

	public final NullableContext nullable() throws RecognitionException {
		NullableContext _localctx = new NullableContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_nullable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1123);
			_la = _input.LA(1);
			if ( !(_la==T__132 || _la==T__122 || _la==T__95 || _la==T__58) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Auto_incrementContext extends ParserRuleContext {
		public Auto_incrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_auto_increment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterAuto_increment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitAuto_increment(this);
		}
	}

	public final Auto_incrementContext auto_increment() throws RecognitionException {
		Auto_incrementContext _localctx = new Auto_incrementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_auto_increment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1125); match(T__141);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UniqueContext extends ParserRuleContext {
		public UniqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterUnique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitUnique(this);
		}
	}

	public final UniqueContext unique() throws RecognitionException {
		UniqueContext _localctx = new UniqueContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_unique);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127); match(T__7);
			setState(1129);
			_la = _input.LA(1);
			if (_la==T__169 || _la==T__14) {
				{
				setState(1128);
				_la = _input.LA(1);
				if ( !(_la==T__169 || _la==T__14) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			_la = _input.LA(1);
			if (_la==T__72) {
				{
				setState(1131); match(T__72);
				}
			}

			setState(1134); match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForeignContext extends ParserRuleContext {
		public ForeignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterForeign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitForeign(this);
		}
	}

	public final ForeignContext foreign() throws RecognitionException {
		ForeignContext _localctx = new ForeignContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_foreign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1136); match(T__113);
			setState(1137); match(T__14);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_formatContext extends ParserRuleContext {
		public Column_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterColumn_format(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitColumn_format(this);
		}
	}

	public final Column_formatContext column_format() throws RecognitionException {
		Column_formatContext _localctx = new Column_formatContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_column_format);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			_la = _input.LA(1);
			if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__105 - 65)) | (1L << (T__89 - 65)) | (1L << (T__61 - 65)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageContext extends ParserRuleContext {
		public StorageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterStorage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitStorage(this);
		}
	}

	public final StorageContext storage() throws RecognitionException {
		StorageContext _localctx = new StorageContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_storage);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			_la = _input.LA(1);
			if ( !(_la==T__105 || _la==T__85 || _la==T__26) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Charset_nameContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(CreateTableParser.ALPHANUMERIC, 0); }
		public Charset_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charset_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterCharset_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitCharset_name(this);
		}
	}

	public final Charset_nameContext charset_name() throws RecognitionException {
		Charset_nameContext _localctx = new Charset_nameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_charset_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1145); match(ALPHANUMERIC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Collation_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Collation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterCollation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitCollation_name(this);
		}
	}

	public final Collation_nameContext collation_name() throws RecognitionException {
		Collation_nameContext _localctx = new Collation_nameContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_collation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1147); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Enum_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Enum_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enum_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterEnum_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitEnum_value(this);
		}
	}

	public final Enum_valueContext enum_value() throws RecognitionException {
		Enum_valueContext _localctx = new Enum_valueContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_enum_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Set_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterSet_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitSet_value(this);
		}
	}

	public final Set_valueContext set_value() throws RecognitionException {
		Set_valueContext _localctx = new Set_valueContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_set_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Spatial_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Spatial_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spatial_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterSpatial_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitSpatial_type(this);
		}
	}

	public final Spatial_typeContext spatial_type() throws RecognitionException {
		Spatial_typeContext _localctx = new Spatial_typeContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_spatial_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parser_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Parser_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parser_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterParser_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitParser_name(this);
		}
	}

	public final Parser_nameContext parser_name() throws RecognitionException {
		Parser_nameContext _localctx = new Parser_nameContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_parser_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Col_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Col_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_col_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterCol_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitCol_name(this);
		}
	}

	public final Col_nameContext col_name() throws RecognitionException {
		Col_nameContext _localctx = new Col_nameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_col_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterSymbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitSymbol(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Index_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterIndex_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitIndex_name(this);
		}
	}

	public final Index_nameContext index_name() throws RecognitionException {
		Index_nameContext _localctx = new Index_nameContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Default_valueContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(CreateTableParser.ALPHANUMERIC, 0); }
		public TerminalNode ID() { return getToken(CreateTableParser.ID, 0); }
		public Default_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterDefault_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitDefault_value(this);
		}
	}

	public final Default_valueContext default_value() throws RecognitionException {
		Default_valueContext _localctx = new Default_valueContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_default_value);
		try {
			setState(1169);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1163); match(ID);
				}
				break;
			case ALPHANUMERIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(1164); match(ALPHANUMERIC);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(1165); match(T__34);
				setState(1166); match(ALPHANUMERIC);
				setState(1167); match(T__34);
				}
				break;
			case T__95:
				enterOuterAlt(_localctx, 4);
				{
				setState(1168); match(T__95);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comment_stringContext extends ParserRuleContext {
		public Comment_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).enterComment_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CreateTableListener ) ((CreateTableListener)listener).exitComment_string(this);
		}
	}

	public final Comment_stringContext comment_string() throws RecognitionException {
		Comment_stringContext _localctx = new Comment_stringContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_comment_string);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1171); match(T__34);
			setState(1175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(1172);
					matchWildcard();
					}
					} 
				}
				setState(1177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
			}
			setState(1178); match(T__34);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\u00b1\u049f\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\3\2\3\2\5\2\u009b\n\2\3\2\3\2\6\2\u009f\n\2\r\2"+
		"\16\2\u00a0\3\2\3\2\3\3\3\3\3\3\5\3\u00a8\n\3\3\3\3\3\3\4\3\4\5\4\u00ae"+
		"\n\4\3\4\3\4\5\4\u00b2\n\4\3\4\3\4\5\4\u00b6\n\4\3\4\3\4\3\4\7\4\u00bb"+
		"\n\4\f\4\16\4\u00be\13\4\3\4\5\4\u00c1\n\4\3\4\5\4\u00c4\n\4\3\4\5\4\u00c7"+
		"\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u00d0\n\6\5\6\u00d2\n\6\3\6\3\6\5"+
		"\6\u00d6\n\6\3\6\5\6\u00d9\n\6\3\6\3\6\3\6\7\6\u00de\n\6\f\6\16\6\u00e1"+
		"\13\6\5\6\u00e3\n\6\3\6\5\6\u00e6\n\6\3\6\3\6\3\6\7\6\u00eb\n\6\f\6\16"+
		"\6\u00ee\13\6\5\6\u00f0\n\6\3\6\3\6\5\6\u00f4\n\6\3\6\5\6\u00f7\n\6\3"+
		"\6\5\6\u00fa\n\6\3\6\3\6\3\6\7\6\u00ff\n\6\f\6\16\6\u0102\13\6\5\6\u0104"+
		"\n\6\3\6\5\6\u0107\n\6\3\6\3\6\3\6\7\6\u010c\n\6\f\6\16\6\u010f\13\6\5"+
		"\6\u0111\n\6\3\6\3\6\5\6\u0115\n\6\5\6\u0117\n\6\3\6\3\6\5\6\u011b\n\6"+
		"\3\6\5\6\u011e\n\6\3\6\5\6\u0121\n\6\3\6\3\6\3\6\7\6\u0126\n\6\f\6\16"+
		"\6\u0129\13\6\5\6\u012b\n\6\3\6\5\6\u012e\n\6\3\6\3\6\3\6\7\6\u0133\n"+
		"\6\f\6\16\6\u0136\13\6\5\6\u0138\n\6\3\6\3\6\5\6\u013c\n\6\3\6\5\6\u013f"+
		"\n\6\3\6\5\6\u0142\n\6\3\6\3\6\3\6\7\6\u0147\n\6\f\6\16\6\u014a\13\6\5"+
		"\6\u014c\n\6\3\6\5\6\u014f\n\6\3\6\3\6\3\6\7\6\u0154\n\6\f\6\16\6\u0157"+
		"\13\6\5\6\u0159\n\6\3\6\3\6\5\6\u015d\n\6\5\6\u015f\n\6\3\6\3\6\5\6\u0163"+
		"\n\6\3\6\5\6\u0166\n\6\3\6\3\6\3\6\7\6\u016b\n\6\f\6\16\6\u016e\13\6\5"+
		"\6\u0170\n\6\3\6\5\6\u0173\n\6\3\6\3\6\3\6\3\6\5\6\u0179\n\6\3\7\3\7\5"+
		"\7\u017d\n\7\3\7\3\7\5\7\u0181\n\7\3\7\5\7\u0184\n\7\3\7\3\7\5\7\u0188"+
		"\n\7\3\7\3\7\5\7\u018c\n\7\3\7\3\7\5\7\u0190\n\7\3\7\3\7\5\7\u0194\n\7"+
		"\3\7\5\7\u0197\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u01a4"+
		"\n\b\f\b\16\b\u01a7\13\b\3\b\3\b\3\b\3\b\5\b\u01ad\n\b\3\b\3\b\5\b\u01b1"+
		"\n\b\3\b\3\b\3\b\3\b\3\b\7\b\u01b8\n\b\f\b\16\b\u01bb\13\b\3\b\3\b\3\b"+
		"\3\b\5\b\u01c1\n\b\3\b\3\b\5\b\u01c5\n\b\5\b\u01c7\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u01d2\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u01d9\n\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\n\u01e0\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u01e7\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u01ee\n\13\3\13\5\13\u01f1\n\13\3\13\5\13\u01f4"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u01fc\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0205\n\r\3\r\5\r\u0208\n\r\3\r\5\r\u020b\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\r\u0212\n\r\3\r\3\r\5\r\u0216\n\r\3\r\5\r\u0219\n\r\3\r\5\r\u021c"+
		"\n\r\5\r\u021e\n\r\3\16\3\16\3\16\5\16\u0223\n\16\3\17\3\17\5\17\u0227"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\5\20\u022e\n\20\3\20\5\20\u0231\n\20\3"+
		"\20\3\20\3\20\5\20\u0236\n\20\3\20\3\20\5\20\u023a\n\20\3\21\3\21\5\21"+
		"\u023e\n\21\3\22\3\22\5\22\u0242\n\22\3\22\3\22\3\22\5\22\u0247\n\22\3"+
		"\22\3\22\5\22\u024b\n\22\3\23\3\23\3\23\3\23\5\23\u0251\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0258\n\24\3\24\5\24\u025b\n\24\3\25\3\25\3\25\3"+
		"\26\3\26\5\26\u0262\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u026b"+
		"\n\26\3\27\3\27\3\27\5\27\u0270\n\27\3\27\3\27\3\27\7\27\u0275\n\27\f"+
		"\27\16\27\u0278\13\27\3\27\5\27\u027b\n\27\5\27\u027d\n\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\5\27\u0285\n\27\3\27\3\27\3\27\5\27\u028a\n\27\3\27"+
		"\3\27\3\27\5\27\u028f\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0297\n"+
		"\30\3\31\3\31\5\31\u029b\n\31\3\31\7\31\u029e\n\31\f\31\16\31\u02a1\13"+
		"\31\3\32\3\32\5\32\u02a5\n\32\3\32\3\32\3\32\5\32\u02aa\n\32\3\32\3\32"+
		"\3\32\5\32\u02af\n\32\3\32\3\32\5\32\u02b3\n\32\3\32\3\32\3\32\5\32\u02b8"+
		"\n\32\3\32\5\32\u02bb\n\32\3\32\3\32\3\32\5\32\u02c0\n\32\3\32\3\32\5"+
		"\32\u02c4\n\32\3\32\3\32\5\32\u02c8\n\32\3\32\3\32\3\32\5\32\u02cd\n\32"+
		"\3\32\3\32\3\32\5\32\u02d2\n\32\3\32\3\32\3\32\3\32\5\32\u02d8\n\32\3"+
		"\32\3\32\3\32\5\32\u02dd\n\32\3\32\3\32\3\32\5\32\u02e2\n\32\3\32\3\32"+
		"\3\32\5\32\u02e7\n\32\3\32\3\32\3\32\5\32\u02ec\n\32\3\32\3\32\3\32\5"+
		"\32\u02f1\n\32\3\32\3\32\3\32\5\32\u02f6\n\32\3\32\3\32\3\32\5\32\u02fb"+
		"\n\32\3\32\3\32\3\32\5\32\u0300\n\32\3\32\3\32\3\32\5\32\u0305\n\32\3"+
		"\32\3\32\3\32\3\32\3\32\5\32\u030c\n\32\3\32\3\32\5\32\u0310\n\32\3\32"+
		"\3\32\3\32\7\32\u0315\n\32\f\32\16\32\u0318\13\32\5\32\u031a\n\32\3\33"+
		"\6\33\u031d\n\33\r\33\16\33\u031e\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\6%\u0335\n%\r%\16%\u0336\3%"+
		"\5%\u033a\n%\3&\3&\3&\5&\u033f\n&\3&\3&\3&\3&\3&\3&\5&\u0347\n&\3&\3&"+
		"\3&\3&\5&\u034d\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u035d"+
		"\n&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u0369\n&\5&\u036b\n&\3&\3&\5&\u036f"+
		"\n&\3&\3&\3&\5&\u0374\n&\3&\3&\3&\3&\3&\3&\5&\u037c\n&\3&\3&\3&\3&\5&"+
		"\u0382\n&\3&\3&\3&\3&\5&\u0388\n&\3&\3&\5&\u038c\n&\5&\u038e\n&\3&\3&"+
		"\3&\7&\u0393\n&\f&\16&\u0396\13&\5&\u0398\n&\3\'\3\'\3\'\7\'\u039d\n\'"+
		"\f\'\16\'\u03a0\13\'\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\5*\u03ae\n*\3"+
		"*\3*\3*\5*\u03b3\n*\3*\3*\3*\3*\3*\5*\u03ba\n*\5*\u03bc\n*\3*\5*\u03bf"+
		"\n*\3*\3*\5*\u03c3\n*\3*\5*\u03c6\n*\3*\3*\5*\u03ca\n*\3*\5*\u03cd\n*"+
		"\3*\3*\3*\5*\u03d2\n*\3*\5*\u03d5\n*\3*\3*\3*\5*\u03da\n*\3*\5*\u03dd"+
		"\n*\3*\3*\5*\u03e1\n*\3*\5*\u03e4\n*\3*\3*\5*\u03e8\n*\3*\5*\u03eb\n*"+
		"\3*\3*\5*\u03ef\n*\3*\5*\u03f2\n*\3*\3*\5*\u03f6\n*\3*\5*\u03f9\n*\3*"+
		"\3*\3*\7*\u03fe\n*\f*\16*\u0401\13*\5*\u0403\n*\3+\3+\3+\7+\u0408\n+\f"+
		"+\16+\u040b\13+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\62\5\62\u041c\n\62\3\62\3\62\5\62\u0420\n\62\3\62\5\62\u0423\n\62\3"+
		"\62\3\62\5\62\u0427\n\62\3\62\5\62\u042a\n\62\3\62\3\62\3\62\5\62\u042f"+
		"\n\62\3\62\5\62\u0432\n\62\3\62\3\62\3\62\5\62\u0437\n\62\3\62\5\62\u043a"+
		"\n\62\3\62\3\62\5\62\u043e\n\62\3\62\5\62\u0441\n\62\3\62\3\62\5\62\u0445"+
		"\n\62\3\62\5\62\u0448\n\62\3\62\3\62\5\62\u044c\n\62\3\62\5\62\u044f\n"+
		"\62\3\62\3\62\5\62\u0453\n\62\3\62\5\62\u0456\n\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\5<\u046c"+
		"\n<\3=\5=\u046f\n=\3=\3=\3>\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D"+
		"\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3K\3K\3K\3K\5K\u0494\nK\3L"+
		"\3L\7L\u0498\nL\fL\16L\u049b\13L\3L\3L\3L\4\u031e\u0499\2M\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^"+
		"`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090"+
		"\u0092\u0094\u0096\2\65\4\2**ss\4\2\30\30\'\'\4\2EE\u009b\u009b\4\2QQ"+
		"\u009a\u009a\4\2HH~~\4\2RRvv\4\2\3\3\u009e\u009e\4\2DD\u00a8\u00a8\4\2"+
		"}}\u0099\u0099\4\2<<gg\4\2AA\u0094\u0094\4\299XX\4\2jjuu\3\2$%\4\2\22"+
		"\22\u00a4\u00a4\4\2\4\4ee\4\2FF\u00aa\u00aa\4\2==bb\4\2ff\u008f\u008f"+
		"\4\2LL\\\\\4\2\60\60yy\4\2##]]\4\2!!OO\4\2\n\n\u0093\u0093\4\2\66\66x"+
		"x\4\2||\u00a3\u00a3\4\2\65\65@@\4\2VV{{\4\2\13\13UU\4\2\16\16tt\4\288"+
		"mm\4\2\u0082\u0082\u008e\u008e\4\2\21\21\27\27\4\2\b\bII\4\2>>\u0084\u0084"+
		"\4\2,,\u00a7\u00a7\4\2\u00a0\u00a0\u00a2\u00a2\4\2\20\20\26\26\4\2\36"+
		"\36\u0081\u0081\4\2\34\34\u0091\u0091\4\2\17\17..\5\2BBJJ\u0097\u0097"+
		"\5\2\17\17..CC\b\2::CCPPSSccoo\5\2CCWW\u0092\u0092\4\2..\u008b\u008b\4"+
		"\2\24\24\32\32\4\2\33\33GG\4\2--^^\6\2((\62\62MMrr\5\2CCSSoo\u0550\2\u009e"+
		"\3\2\2\2\4\u00a4\3\2\2\2\6\u00ab\3\2\2\2\b\u00c8\3\2\2\2\n\u0178\3\2\2"+
		"\2\f\u017a\3\2\2\2\16\u01c6\3\2\2\2\20\u01d1\3\2\2\2\22\u01e6\3\2\2\2"+
		"\24\u01e8\3\2\2\2\26\u01fb\3\2\2\2\30\u021d\3\2\2\2\32\u0222\3\2\2\2\34"+
		"\u0226\3\2\2\2\36\u0228\3\2\2\2 \u023d\3\2\2\2\"\u023f\3\2\2\2$\u0250"+
		"\3\2\2\2&\u0252\3\2\2\2(\u025c\3\2\2\2*\u026a\3\2\2\2,\u026c\3\2\2\2."+
		"\u0296\3\2\2\2\60\u0298\3\2\2\2\62\u0319\3\2\2\2\64\u031c\3\2\2\2\66\u0320"+
		"\3\2\2\28\u0322\3\2\2\2:\u0324\3\2\2\2<\u0326\3\2\2\2>\u0328\3\2\2\2@"+
		"\u032a\3\2\2\2B\u032c\3\2\2\2D\u032e\3\2\2\2F\u0330\3\2\2\2H\u0334\3\2"+
		"\2\2J\u033b\3\2\2\2L\u0399\3\2\2\2N\u03a1\3\2\2\2P\u03a3\3\2\2\2R\u03a5"+
		"\3\2\2\2T\u0404\3\2\2\2V\u040c\3\2\2\2X\u040e\3\2\2\2Z\u0410\3\2\2\2\\"+
		"\u0412\3\2\2\2^\u0414\3\2\2\2`\u0416\3\2\2\2b\u0418\3\2\2\2d\u0457\3\2"+
		"\2\2f\u0459\3\2\2\2h\u045b\3\2\2\2j\u045d\3\2\2\2l\u045f\3\2\2\2n\u0461"+
		"\3\2\2\2p\u0463\3\2\2\2r\u0465\3\2\2\2t\u0467\3\2\2\2v\u0469\3\2\2\2x"+
		"\u046e\3\2\2\2z\u0472\3\2\2\2|\u0475\3\2\2\2~\u0477\3\2\2\2\u0080\u0479"+
		"\3\2\2\2\u0082\u047b\3\2\2\2\u0084\u047d\3\2\2\2\u0086\u047f\3\2\2\2\u0088"+
		"\u0481\3\2\2\2\u008a\u0483\3\2\2\2\u008c\u0485\3\2\2\2\u008e\u0487\3\2"+
		"\2\2\u0090\u0489\3\2\2\2\u0092\u048b\3\2\2\2\u0094\u0493\3\2\2\2\u0096"+
		"\u0495\3\2\2\2\u0098\u009b\5\4\3\2\u0099\u009b\5\6\4\2\u009a\u0098\3\2"+
		"\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\u009c\2\2\u009d"+
		"\u009f\3\2\2\2\u009e\u009a\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\2\1\2\u00a3"+
		"\3\3\2\2\2\u00a4\u00a5\t\2\2\2\u00a5\u00a7\t\3\2\2\u00a6\u00a8\t\4\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\5\b\5\2\u00aa\5\3\2\2\2\u00ab\u00ad\t\5\2\2\u00ac\u00ae\t\6\2\2\u00ad"+
		"\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\t\3"+
		"\2\2\u00b0\u00b2\t\7\2\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b5\5\b\5\2\u00b4\u00b6\7\u0083\2\2\u00b5\u00b4"+
		"\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00bc\5\n\6\2\u00b8"+
		"\u00b9\7\64\2\2\u00b9\u00bb\5\n\6\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3"+
		"\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c1\7\25\2\2\u00c0\u00bf\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c4\5\60\31\2\u00c3\u00c2\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c7\5J&\2\u00c6\u00c5\3\2\2"+
		"\2\u00c6\u00c7\3\2\2\2\u00c7\7\3\2\2\2\u00c8\u00c9\7\u00ae\2\2\u00c9\t"+
		"\3\2\2\2\u00ca\u00cb\5\u008eH\2\u00cb\u00cc\5\f\7\2\u00cc\u0179\3\2\2"+
		"\2\u00cd\u00cf\7`\2\2\u00ce\u00d0\5\u0090I\2\u00cf\u00ce\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\5x=\2\u00d4\u00d6\5(\25\2\u00d5\u00d4"+
		"\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d9\7\u0083\2"+
		"\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00e2\3\2\2\2\u00da\u00df"+
		"\5&\24\2\u00db\u00dc\7\64\2\2\u00dc\u00de\5&\24\2\u00dd\u00db\3\2\2\2"+
		"\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e3"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00e6\7\25\2\2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3"+
		"\2\2\2\u00e6\u00ef\3\2\2\2\u00e7\u00ec\5*\26\2\u00e8\u00e9\7\64\2\2\u00e9"+
		"\u00eb\5*\26\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2"+
		"\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00e7\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u0179\3\2\2\2\u00f1\u00f3\t\b"+
		"\2\2\u00f2\u00f4\5\u0092J\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f7\5(\25\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00fa\7\u0083\2\2\u00f9\u00f8\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u0103\3\2\2\2\u00fb\u0100\5&\24\2\u00fc\u00fd\7\64"+
		"\2\2\u00fd\u00ff\5&\24\2\u00fe\u00fc\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0103\u00fb\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105"+
		"\u0107\7\25\2\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0110\3"+
		"\2\2\2\u0108\u010d\5*\26\2\u0109\u010a\7\64\2\2\u010a\u010c\5*\26\2\u010b"+
		"\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0108\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u0179\3\2\2\2\u0112\u0114\7`\2\2\u0113\u0115\5\u0090"+
		"I\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0112\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\5v"+
		"<\2\u0119\u011b\5\u0092J\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011d\3\2\2\2\u011c\u011e\5(\25\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u0121\7\u0083\2\2\u0120\u011f\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u012a\3\2\2\2\u0122\u0127\5&\24\2\u0123\u0124\7\64"+
		"\2\2\u0124\u0126\5&\24\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u012a\u0122\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c"+
		"\u012e\7\25\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0137\3"+
		"\2\2\2\u012f\u0134\5*\26\2\u0130\u0131\7\64\2\2\u0131\u0133\5*\26\2\u0132"+
		"\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u012f\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0179\3\2\2\2\u0139\u013b\t\t\2\2\u013a\u013c\t\b"+
		"\2\2\u013b\u013a\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d"+
		"\u013f\5\u0092J\2\u013e\u013d\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0141"+
		"\3\2\2\2\u0140\u0142\7\u0083\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2"+
		"\2\u0142\u014b\3\2\2\2\u0143\u0148\5&\24\2\u0144\u0145\7\64\2\2\u0145"+
		"\u0147\5&\24\2\u0146\u0144\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0148\u0149\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2\2\2\u014b"+
		"\u0143\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d\u014f\7\25"+
		"\2\2\u014e\u014d\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0158\3\2\2\2\u0150"+
		"\u0155\5*\26\2\u0151\u0152\7\64\2\2\u0152\u0154\5*\26\2\u0153\u0151\3"+
		"\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156"+
		"\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0150\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u0179\3\2\2\2\u015a\u015c\7`\2\2\u015b\u015d\5\u0090I\2\u015c"+
		"\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015a\3\2"+
		"\2\2\u015e\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\5z>\2\u0161\u0163"+
		"\5\u0092J\2\u0162\u0161\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165\3\2\2"+
		"\2\u0164\u0166\7\u0083\2\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u016f\3\2\2\2\u0167\u016c\5&\24\2\u0168\u0169\7\64\2\2\u0169\u016b\5"+
		"&\24\2\u016a\u0168\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0167\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\7\25\2\2\u0172"+
		"\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\5,"+
		"\27\2\u0175\u0179\3\2\2\2\u0176\u0177\7/\2\2\u0177\u0179\5\u0080A\2\u0178"+
		"\u00ca\3\2\2\2\u0178\u00d1\3\2\2\2\u0178\u00f1\3\2\2\2\u0178\u0116\3\2"+
		"\2\2\u0178\u0139\3\2\2\2\u0178\u015e\3\2\2\2\u0178\u0176\3\2\2\2\u0179"+
		"\13\3\2\2\2\u017a\u017c\5\16\b\2\u017b\u017d\5r:\2\u017c\u017b\3\2\2\2"+
		"\u017c\u017d\3\2\2\2\u017d\u0180\3\2\2\2\u017e\u017f\7C\2\2\u017f\u0181"+
		"\5\u0094K\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\3\2\2"+
		"\2\u0182\u0184\5t;\2\u0183\u0182\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0187"+
		"\3\2\2\2\u0185\u0188\5v<\2\u0186\u0188\5x=\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018b\3\2\2\2\u0189\u018a\7\t"+
		"\2\2\u018a\u018c\5\u0096L\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c"+
		"\u018f\3\2\2\2\u018d\u018e\7\u0085\2\2\u018e\u0190\5|?\2\u018f\u018d\3"+
		"\2\2\2\u018f\u0190\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u0192\7)\2\2\u0192"+
		"\u0194\5~@\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0196\3\2\2"+
		"\2\u0195\u0197\5,\27\2\u0196\u0195\3\2\2\2\u0196\u0197\3\2\2\2\u0197\r"+
		"\3\2\2\2\u0198\u01c7\5\20\t\2\u0199\u01c7\5\22\n\2\u019a\u01c7\5\24\13"+
		"\2\u019b\u01c7\5\30\r\2\u019c\u01c7\5\36\20\2\u019d\u01c7\5\"\22\2\u019e"+
		"\u019f\t\n\2\2\u019f\u01a0\7\u0083\2\2\u01a0\u01a5\5\u0086D\2\u01a1\u01a2"+
		"\7\64\2\2\u01a2\u01a4\5\u0086D\2\u01a3\u01a1\3\2\2\2\u01a4\u01a7\3\2\2"+
		"\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2\2\2\u01a7\u01a5"+
		"\3\2\2\2\u01a8\u01ac\7\25\2\2\u01a9\u01aa\7\31\2\2\u01aa\u01ab\7g\2\2"+
		"\u01ab\u01ad\5\u0082B\2\u01ac\u01a9\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"\u01b0\3\2\2\2\u01ae\u01af\7\u008d\2\2\u01af\u01b1\5\u0084C\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01c7\3\2\2\2\u01b2\u01b3\t\13\2\2"+
		"\u01b3\u01b4\7\u0083\2\2\u01b4\u01b9\5\u0088E\2\u01b5\u01b6\7\64\2\2\u01b6"+
		"\u01b8\5\u0088E\2\u01b7\u01b5\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7"+
		"\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba\u01bc\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc"+
		"\u01c0\7\25\2\2\u01bd\u01be\7\31\2\2\u01be\u01bf\7g\2\2\u01bf\u01c1\5"+
		"\u0082B\2\u01c0\u01bd\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c4\3\2\2\2"+
		"\u01c2\u01c3\7\u008d\2\2\u01c3\u01c5\5\u0084C\2\u01c4\u01c2\3\2\2\2\u01c4"+
		"\u01c5\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u0198\3\2\2\2\u01c6\u0199\3\2"+
		"\2\2\u01c6\u019a\3\2\2\2\u01c6\u019b\3\2\2\2\u01c6\u019c\3\2\2\2\u01c6"+
		"\u019d\3\2\2\2\u01c6\u019e\3\2\2\2\u01c6\u01b2\3\2\2\2\u01c7\17\3\2\2"+
		"\2\u01c8\u01d2\t\f\2\2\u01c9\u01d2\t\r\2\2\u01ca\u01d2\t\16\2\2\u01cb"+
		"\u01d2\t\17\2\2\u01cc\u01d2\t\20\2\2\u01cd\u01d2\t\21\2\2\u01ce\u01d2"+
		"\t\22\2\2\u01cf\u01d2\t\23\2\2\u01d0\u01d2\t\24\2\2\u01d1\u01c8\3\2\2"+
		"\2\u01d1\u01c9\3\2\2\2\u01d1\u01ca\3\2\2\2\u01d1\u01cb\3\2\2\2\u01d1\u01cc"+
		"\3\2\2\2\u01d1\u01cd\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d1\u01cf\3\2\2\2\u01d1"+
		"\u01d0\3\2\2\2\u01d2\21\3\2\2\2\u01d3\u01d8\t\25\2\2\u01d4\u01d5\7\u0083"+
		"\2\2\u01d5\u01d6\5h\65\2\u01d6\u01d7\7\25\2\2\u01d7\u01d9\3\2\2\2\u01d8"+
		"\u01d4\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01e7\3\2\2\2\u01da\u01df\5p"+
		"9\2\u01db\u01dc\7\u0083\2\2\u01dc\u01dd\5h\65\2\u01dd\u01de\7\25\2\2\u01de"+
		"\u01e0\3\2\2\2\u01df\u01db\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e7\3\2"+
		"\2\2\u01e1\u01e2\t\26\2\2\u01e2\u01e3\7\u0083\2\2\u01e3\u01e4\5h\65\2"+
		"\u01e4\u01e5\7\25\2\2\u01e5\u01e7\3\2\2\2\u01e6\u01d3\3\2\2\2\u01e6\u01da"+
		"\3\2\2\2\u01e6\u01e1\3\2\2\2\u01e7\23\3\2\2\2\u01e8\u01ed\5\26\f\2\u01e9"+
		"\u01ea\7\u0083\2\2\u01ea\u01eb\5h\65\2\u01eb\u01ec\7\25\2\2\u01ec\u01ee"+
		"\3\2\2\2\u01ed\u01e9\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f0\3\2\2\2\u01ef"+
		"\u01f1\5l\67\2\u01f0\u01ef\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2"+
		"\2\2\u01f2\u01f4\5n8\2\u01f3\u01f2\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4\25"+
		"\3\2\2\2\u01f5\u01fc\t\27\2\2\u01f6\u01fc\t\30\2\2\u01f7\u01fc\t\31\2"+
		"\2\u01f8\u01fc\t\32\2\2\u01f9\u01fc\t\33\2\2\u01fa\u01fc\t\34\2\2\u01fb"+
		"\u01f5\3\2\2\2\u01fb\u01f6\3\2\2\2\u01fb\u01f7\3\2\2\2\u01fb\u01f8\3\2"+
		"\2\2\u01fb\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\27\3\2\2\2\u01fd\u0204"+
		"\5\32\16\2\u01fe\u01ff\7\u0083\2\2\u01ff\u0200\5h\65\2\u0200\u0201\7\64"+
		"\2\2\u0201\u0202\5j\66\2\u0202\u0203\7\25\2\2\u0203\u0205\3\2\2\2\u0204"+
		"\u01fe\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0207\3\2\2\2\u0206\u0208\5l"+
		"\67\2\u0207\u0206\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u020a\3\2\2\2\u0209"+
		"\u020b\5n8\2\u020a\u0209\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u021e\3\2\2"+
		"\2\u020c\u0215\5\34\17\2\u020d\u020e\7\u0083\2\2\u020e\u0211\5h\65\2\u020f"+
		"\u0210\7\64\2\2\u0210\u0212\5j\66\2\u0211\u020f\3\2\2\2\u0211\u0212\3"+
		"\2\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7\25\2\2\u0214\u0216\3\2\2\2\u0215"+
		"\u020d\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\3\2\2\2\u0217\u0219\5l"+
		"\67\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219\u021b\3\2\2\2\u021a"+
		"\u021c\5n8\2\u021b\u021a\3\2\2\2\u021b\u021c\3\2\2\2\u021c\u021e\3\2\2"+
		"\2\u021d\u01fd\3\2\2\2\u021d\u020c\3\2\2\2\u021e\31\3\2\2\2\u021f\u0223"+
		"\t\35\2\2\u0220\u0223\t\36\2\2\u0221\u0223\t\37\2\2\u0222\u021f\3\2\2"+
		"\2\u0222\u0220\3\2\2\2\u0222\u0221\3\2\2\2\u0223\33\3\2\2\2\u0224\u0227"+
		"\t \2\2\u0225\u0227\t!\2\2\u0226\u0224\3\2\2\2\u0226\u0225\3\2\2\2\u0227"+
		"\35\3\2\2\2\u0228\u022d\5 \21\2\u0229\u022a\7\u0083\2\2\u022a\u022b\5"+
		"h\65\2\u022b\u022c\7\25\2\2\u022c\u022e\3\2\2\2\u022d\u0229\3\2\2\2\u022d"+
		"\u022e\3\2\2\2\u022e\u0230\3\2\2\2\u022f\u0231\5p9\2\u0230\u022f\3\2\2"+
		"\2\u0230\u0231\3\2\2\2\u0231\u0235\3\2\2\2\u0232\u0233\7\31\2\2\u0233"+
		"\u0234\7g\2\2\u0234\u0236\5\u0082B\2\u0235\u0232\3\2\2\2\u0235\u0236\3"+
		"\2\2\2\u0236\u0239\3\2\2\2\u0237\u0238\7\u008d\2\2\u0238\u023a\5\u0084"+
		"C\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\37\3\2\2\2\u023b\u023e"+
		"\t\"\2\2\u023c\u023e\t#\2\2\u023d\u023b\3\2\2\2\u023d\u023c\3\2\2\2\u023e"+
		"!\3\2\2\2\u023f\u0241\5$\23\2\u0240\u0242\5p9\2\u0241\u0240\3\2\2\2\u0241"+
		"\u0242\3\2\2\2\u0242\u0246\3\2\2\2\u0243\u0244\7\31\2\2\u0244\u0245\7"+
		"g\2\2\u0245\u0247\5\u0082B\2\u0246\u0243\3\2\2\2\u0246\u0247\3\2\2\2\u0247"+
		"\u024a\3\2\2\2\u0248\u0249\7\u008d\2\2\u0249\u024b\5\u0084C\2\u024a\u0248"+
		"\3\2\2\2\u024a\u024b\3\2\2\2\u024b#\3\2\2\2\u024c\u0251\t$\2\2\u024d\u0251"+
		"\t%\2\2\u024e\u0251\t&\2\2\u024f\u0251\t\'\2\2\u0250\u024c\3\2\2\2\u0250"+
		"\u024d\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u024f\3\2\2\2\u0251%\3\2\2\2"+
		"\u0252\u0257\5\u008eH\2\u0253\u0254\7\u0083\2\2\u0254\u0255\5h\65\2\u0255"+
		"\u0256\7\25\2\2\u0256\u0258\3\2\2\2\u0257\u0253\3\2\2\2\u0257\u0258\3"+
		"\2\2\2\u0258\u025a\3\2\2\2\u0259\u025b\t(\2\2\u025a\u0259\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\'\3\2\2\2\u025c\u025d\7K\2\2\u025d\u025e\t)\2\2\u025e"+
		")\3\2\2\2\u025f\u0261\7\5\2\2\u0260\u0262\7q\2\2\u0261\u0260\3\2\2\2\u0261"+
		"\u0262\3\2\2\2\u0262\u0263\3\2\2\2\u0263\u026b\5f\64\2\u0264\u026b\5("+
		"\25\2\u0265\u0266\7Y\2\2\u0266\u0267\7w\2\2\u0267\u026b\5\u008cG\2\u0268"+
		"\u0269\7\t\2\2\u0269\u026b\5\u0096L\2\u026a\u025f\3\2\2\2\u026a\u0264"+
		"\3\2\2\2\u026a\u0265\3\2\2\2\u026a\u0268\3\2\2\2\u026b+\3\2\2\2\u026c"+
		"\u026d\7&\2\2\u026d\u027c\5\b\5\2\u026e\u0270\7\u0083\2\2\u026f\u026e"+
		"\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0271\3\2\2\2\u0271\u0276\5&\24\2\u0272"+
		"\u0273\7\64\2\2\u0273\u0275\5&\24\2\u0274\u0272\3\2\2\2\u0275\u0278\3"+
		"\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u027a\3\2\2\2\u0278"+
		"\u0276\3\2\2\2\u0279\u027b\7\25\2\2\u027a\u0279\3\2\2\2\u027a\u027b\3"+
		"\2\2\2\u027b\u027d\3\2\2\2\u027c\u026f\3\2\2\2\u027c\u027d\3\2\2\2\u027d"+
		"\u0284\3\2\2\2\u027e\u027f\7\u0080\2\2\u027f\u0285\7\u0089\2\2\u0280\u0281"+
		"\7\u0080\2\2\u0281\u0285\7h\2\2\u0282\u0283\7\u0080\2\2\u0283\u0285\7"+
		"\u0095\2\2\u0284\u027e\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0282\3\2\2\2"+
		"\u0284\u0285\3\2\2\2\u0285\u0289\3\2\2\2\u0286\u0287\7T\2\2\u0287\u0288"+
		"\7\6\2\2\u0288\u028a\5.\30\2\u0289\u0286\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u028e\3\2\2\2\u028b\u028c\7T\2\2\u028c\u028d\7\u0098\2\2\u028d\u028f"+
		"\5.\30\2\u028e\u028b\3\2\2\2\u028e\u028f\3\2\2\2\u028f-\3\2\2\2\u0290"+
		"\u0297\7\u00a6\2\2\u0291\u0297\7\"\2\2\u0292\u0293\7g\2\2\u0293\u0297"+
		"\7M\2\2\u0294\u0295\7J\2\2\u0295\u0297\7\u0088\2\2\u0296\u0290\3\2\2\2"+
		"\u0296\u0291\3\2\2\2\u0296\u0292\3\2\2\2\u0296\u0294\3\2\2\2\u0297/\3"+
		"\2\2\2\u0298\u029f\5\62\32\2\u0299\u029b\7\64\2\2\u029a\u0299\3\2\2\2"+
		"\u029a\u029b\3\2\2\2\u029b\u029c\3\2\2\2\u029c\u029e\5\62\32\2\u029d\u029a"+
		"\3\2\2\2\u029e\u02a1\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u02a0\3\2\2\2\u02a0"+
		"\61\3\2\2\2\u02a1\u029f\3\2\2\2\u02a2\u02a4\7z\2\2\u02a3\u02a5\7q\2\2"+
		"\u02a4\u02a3\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u031a"+
		"\5\66\34\2\u02a7\u02a9\7\37\2\2\u02a8\u02aa\7q\2\2\u02a9\u02a8\3\2\2\2"+
		"\u02a9\u02aa\3\2\2\2\u02aa\u02ab\3\2\2\2\u02ab\u031a\5<\37\2\u02ac\u02ae"+
		"\7\u00ab\2\2\u02ad\u02af\7q\2\2\u02ae\u02ad\3\2\2\2\u02ae\u02af\3\2\2"+
		"\2\u02af\u02b0\3\2\2\2\u02b0\u031a\5> \2\u02b1\u02b3\7C\2\2\u02b2\u02b1"+
		"\3\2\2\2\u02b2\u02b3\3\2\2\2\u02b3\u02b7\3\2\2\2\u02b4\u02b5\7\31\2\2"+
		"\u02b5\u02b8\7g\2\2\u02b6\u02b8\7\67\2\2\u02b7\u02b4\3\2\2\2\u02b7\u02b6"+
		"\3\2\2\2\u02b8\u02ba\3\2\2\2\u02b9\u02bb\7q\2\2\u02ba\u02b9\3\2\2\2\u02ba"+
		"\u02bb\3\2\2\2\u02bb\u02bc\3\2\2\2\u02bc\u031a\5\u0082B\2\u02bd\u02bf"+
		"\7\f\2\2\u02be\u02c0\7q\2\2\u02bf\u02be\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u02c1\3\2\2\2\u02c1\u031a\t*\2\2\u02c2\u02c4\7C\2\2\u02c3\u02c2\3\2\2"+
		"\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7\7\u008d\2\2\u02c6"+
		"\u02c8\7q\2\2\u02c7\u02c6\3\2\2\2\u02c7\u02c8\3\2\2\2\u02c8\u02c9\3\2"+
		"\2\2\u02c9\u031a\5\u0084C\2\u02ca\u02cc\7\t\2\2\u02cb\u02cd\7q\2\2\u02cc"+
		"\u02cb\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02ce\3\2\2\2\u02ce\u031a\5\u0096"+
		"L\2\u02cf\u02d1\7a\2\2\u02d0\u02d2\7q\2\2\u02d1\u02d0\3\2\2\2\u02d1\u02d2"+
		"\3\2\2\2\u02d2\u02d3\3\2\2\2\u02d3\u031a\58\35\2\u02d4\u02d5\7\u0096\2"+
		"\2\u02d5\u02d7\7\177\2\2\u02d6\u02d8\7q\2\2\u02d7\u02d6\3\2\2\2\u02d7"+
		"\u02d8\3\2\2\2\u02d8\u02d9\3\2\2\2\u02d9\u031a\5F$\2\u02da\u02dc\7\u00a9"+
		"\2\2\u02db\u02dd\7q\2\2\u02dc\u02db\3\2\2\2\u02dc\u02dd\3\2\2\2\u02dd"+
		"\u02de\3\2\2\2\u02de\u031a\t*\2\2\u02df\u02e1\7 \2\2\u02e0\u02e2\7q\2"+
		"\2\u02e1\u02e0\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3\u031a"+
		"\5F$\2\u02e4\u02e6\7p\2\2\u02e5\u02e7\7q\2\2\u02e6\u02e5\3\2\2\2\u02e6"+
		"\u02e7\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u031a\t+\2\2\u02e9\u02eb\7\5"+
		"\2\2\u02ea\u02ec\7q\2\2\u02eb\u02ea\3\2\2\2\u02eb\u02ec\3\2\2\2\u02ec"+
		"\u02ed\3\2\2\2\u02ed\u031a\5@!\2\u02ee\u02f0\7Z\2\2\u02ef\u02f1\7q\2\2"+
		"\u02f0\u02ef\3\2\2\2\u02f0\u02f1\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u031a"+
		"\5B\"\2\u02f3\u02f5\7\35\2\2\u02f4\u02f6\7q\2\2\u02f5\u02f4\3\2\2\2\u02f5"+
		"\u02f6\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u031a\5D#\2\u02f8\u02fa\7\u0086"+
		"\2\2\u02f9\u02fb\7q\2\2\u02fa\u02f9\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb"+
		"\u02fc\3\2\2\2\u02fc\u031a\t,\2\2\u02fd\u02ff\7\23\2\2\u02fe\u0300\7q"+
		"\2\2\u02ff\u02fe\3\2\2\2\u02ff\u0300\3\2\2\2\u0300\u0301\3\2\2\2\u0301"+
		"\u031a\5\64\33\2\u0302\u0304\7_\2\2\u0303\u0305\7q\2\2\u0304\u0303\3\2"+
		"\2\2\u0304\u0305\3\2\2\2\u0305\u0306\3\2\2\2\u0306\u031a\t-\2\2\u0307"+
		"\u0308\7+\2\2\u0308\u030b\5:\36\2\u0309\u030a\7)\2\2\u030a\u030c\t.\2"+
		"\2\u030b\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c\u031a\3\2\2\2\u030d\u030f"+
		"\7\u00ac\2\2\u030e\u0310\7q\2\2\u030f\u030e\3\2\2\2\u030f\u0310\3\2\2"+
		"\2\u0310\u0311\3\2\2\2\u0311\u0316\5\b\5\2\u0312\u0313\7\64\2\2\u0313"+
		"\u0315\5\b\5\2\u0314\u0312\3\2\2\2\u0315\u0318\3\2\2\2\u0316\u0314\3\2"+
		"\2\2\u0316\u0317\3\2\2\2\u0317\u031a\3\2\2\2\u0318\u0316\3\2\2\2\u0319"+
		"\u02a2\3\2\2\2\u0319\u02a7\3\2\2\2\u0319\u02ac\3\2\2\2\u0319\u02b2\3\2"+
		"\2\2\u0319\u02bd\3\2\2\2\u0319\u02c3\3\2\2\2\u0319\u02ca\3\2\2\2\u0319"+
		"\u02cf\3\2\2\2\u0319\u02d4\3\2\2\2\u0319\u02da\3\2\2\2\u0319\u02df\3\2"+
		"\2\2\u0319\u02e4\3\2\2\2\u0319\u02e9\3\2\2\2\u0319\u02ee\3\2\2\2\u0319"+
		"\u02f3\3\2\2\2\u0319\u02f8\3\2\2\2\u0319\u02fd\3\2\2\2\u0319\u0302\3\2"+
		"\2\2\u0319\u0307\3\2\2\2\u0319\u030d\3\2\2\2\u031a\63\3\2\2\2\u031b\u031d"+
		"\13\2\2\2\u031c\u031b\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031f\3\2\2\2"+
		"\u031e\u031c\3\2\2\2\u031f\65\3\2\2\2\u0320\u0321\7\u00af\2\2\u0321\67"+
		"\3\2\2\2\u0322\u0323\7\u00ae\2\2\u03239\3\2\2\2\u0324\u0325\7\u00ae\2"+
		"\2\u0325;\3\2\2\2\u0326\u0327\7\u00ad\2\2\u0327=\3\2\2\2\u0328\u0329\7"+
		"\u00ad\2\2\u0329?\3\2\2\2\u032a\u032b\7\u00ad\2\2\u032bA\3\2\2\2\u032c"+
		"\u032d\7\u00ad\2\2\u032dC\3\2\2\2\u032e\u032f\7\u00ad\2\2\u032fE\3\2\2"+
		"\2\u0330\u0331\5H%\2\u0331G\3\2\2\2\u0332\u0333\7[\2\2\u0333\u0335\7\u00ae"+
		"\2\2\u0334\u0332\3\2\2\2\u0335\u0336\3\2\2\2\u0336\u0334\3\2\2\2\u0336"+
		"\u0337\3\2\2\2\u0337\u0339\3\2\2\2\u0338\u033a\7[\2\2\u0339\u0338\3\2"+
		"\2\2\u0339\u033a\3\2\2\2\u033aI\3\2\2\2\u033b\u033c\7\61\2\2\u033c\u036a"+
		"\7\63\2\2\u033d\u033f\7\7\2\2\u033e\u033d\3\2\2\2\u033e\u033f\3\2\2\2"+
		"\u033f\u0340\3\2\2\2\u0340\u0341\7\u0091\2\2\u0341\u0342\7\u0083\2\2\u0342"+
		"\u0343\5\u0080A\2\u0343\u0344\7\25\2\2\u0344\u036b\3\2\2\2\u0345\u0347"+
		"\7\7\2\2\u0346\u0345\3\2\2\2\u0346\u0347\3\2\2\2\u0347\u0348\3\2\2\2\u0348"+
		"\u034c\7\u009e\2\2\u0349\u034a\7\u0087\2\2\u034a\u034b\7q\2\2\u034b\u034d"+
		"\t/\2\2\u034c\u0349\3\2\2\2\u034c\u034d\3\2\2\2\u034d\u034e\3\2\2\2\u034e"+
		"\u034f\7\u0083\2\2\u034f\u0350\5L\'\2\u0350\u0351\7\25\2\2\u0351\u036b"+
		"\3\2\2\2\u0352\u035c\7l\2\2\u0353\u0354\7\u0083\2\2\u0354\u0355\5\u0080"+
		"A\2\u0355\u0356\7\25\2\2\u0356\u035d\3\2\2\2\u0357\u0358\7i\2\2\u0358"+
		"\u0359\7\u0083\2\2\u0359\u035a\5L\'\2\u035a\u035b\7\25\2\2\u035b\u035d"+
		"\3\2\2\2\u035c\u0353\3\2\2\2\u035c\u0357\3\2\2\2\u035d\u036b\3\2\2\2\u035e"+
		"\u0368\7\u008c\2\2\u035f\u0360\7\u0083\2\2\u0360\u0361\5\u0080A\2\u0361"+
		"\u0362\7\25\2\2\u0362\u0369\3\2\2\2\u0363\u0364\7i\2\2\u0364\u0365\7\u0083"+
		"\2\2\u0365\u0366\5L\'\2\u0366\u0367\7\25\2\2\u0367\u0369\3\2\2\2\u0368"+
		"\u035f\3\2\2\2\u0368\u0363\3\2\2\2\u0369\u036b\3\2\2\2\u036a\u033e\3\2"+
		"\2\2\u036a\u0346\3\2\2\2\u036a\u0352\3\2\2\2\u036a\u035e\3\2\2\2\u036b"+
		"\u036e\3\2\2\2\u036c\u036d\7\u00a1\2\2\u036d\u036f\5N(\2\u036e\u036c\3"+
		"\2\2\2\u036e\u036f\3\2\2\2\u036f\u038d\3\2\2\2\u0370\u0371\7\u009f\2\2"+
		"\u0371\u0387\7\63\2\2\u0372\u0374\7\7\2\2\u0373\u0372\3\2\2\2\u0373\u0374"+
		"\3\2\2\2\u0374\u0375\3\2\2\2\u0375\u0376\7\u0091\2\2\u0376\u0377\7\u0083"+
		"\2\2\u0377\u0378\5\u0080A\2\u0378\u0379\7\25\2\2\u0379\u0388\3\2\2\2\u037a"+
		"\u037c\7\7\2\2\u037b\u037a\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u037d\3\2"+
		"\2\2\u037d\u0381\7\u009e\2\2\u037e\u037f\7\u0087\2\2\u037f\u0380\7q\2"+
		"\2\u0380\u0382\t/\2\2\u0381\u037e\3\2\2\2\u0381\u0382\3\2\2\2\u0382\u0383"+
		"\3\2\2\2\u0383\u0384\7\u0083\2\2\u0384\u0385\5L\'\2\u0385\u0386\7\25\2"+
		"\2\u0386\u0388\3\2\2\2\u0387\u0373\3\2\2\2\u0387\u037b\3\2\2\2\u0388\u038b"+
		"\3\2\2\2\u0389\u038a\7\u009d\2\2\u038a\u038c\5P)\2\u038b\u0389\3\2\2\2"+
		"\u038b\u038c\3\2\2\2\u038c\u038e\3\2\2\2\u038d\u0370\3\2\2\2\u038d\u038e"+
		"\3\2\2\2\u038e\u0397\3\2\2\2\u038f\u0394\5R*\2\u0390\u0391\7\64\2\2\u0391"+
		"\u0393\5R*\2\u0392\u0390\3\2\2\2\u0393\u0396\3\2\2\2\u0394\u0392\3\2\2"+
		"\2\u0394\u0395\3\2\2\2\u0395\u0398\3\2\2\2\u0396\u0394\3\2\2\2\u0397\u038f"+
		"\3\2\2\2\u0397\u0398\3\2\2\2\u0398K\3\2\2\2\u0399\u039e\5\u008eH\2\u039a"+
		"\u039b\7\64\2\2\u039b\u039d\5\u008eH\2\u039c\u039a\3\2\2\2\u039d\u03a0"+
		"\3\2\2\2\u039e\u039c\3\2\2\2\u039e\u039f\3\2\2\2\u039fM\3\2\2\2\u03a0"+
		"\u039e\3\2\2\2\u03a1\u03a2\7\u00ad\2\2\u03a2O\3\2\2\2\u03a3\u03a4\7\u00ad"+
		"\2\2\u03a4Q\3\2\2\2\u03a5\u03a6\7\61\2\2\u03a6\u03bb\5V,\2\u03a7\u03b9"+
		"\7\u0090\2\2\u03a8\u03a9\7?\2\2\u03a9\u03b2\7N\2\2\u03aa\u03ad\7\u0083"+
		"\2\2\u03ab\u03ae\5\u0080A\2\u03ac\u03ae\5T+\2\u03ad\u03ab\3\2\2\2\u03ad"+
		"\u03ac\3\2\2\2\u03ae\u03af\3\2\2\2\u03af\u03b0\7\25\2\2\u03b0\u03b3\3"+
		"\2\2\2\u03b1\u03b3\7n\2\2\u03b2\u03aa\3\2\2\2\u03b2\u03b1\3\2\2\2\u03b3"+
		"\u03ba\3\2\2\2\u03b4\u03b5\7\r\2\2\u03b5\u03b6\7\u0083\2\2\u03b6\u03b7"+
		"\5T+\2\u03b7\u03b8\7\25\2\2\u03b8\u03ba\3\2\2\2\u03b9\u03a8\3\2\2\2\u03b9"+
		"\u03b4\3\2\2\2\u03ba\u03bc\3\2\2\2\u03bb\u03a7\3\2\2\2\u03bb\u03bc\3\2"+
		"\2\2\u03bc\u03c5\3\2\2\2\u03bd\u03bf\7)\2\2\u03be\u03bd\3\2\2\2\u03be"+
		"\u03bf\3\2\2\2\u03bf\u03c0\3\2\2\2\u03c0\u03c2\7z\2\2\u03c1\u03c3\7q\2"+
		"\2\u03c2\u03c1\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\3\2\2\2\u03c4\u03c6"+
		"\5\66\34\2\u03c5\u03be\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03cc\3\2\2\2"+
		"\u03c7\u03c9\7\t\2\2\u03c8\u03ca\7q\2\2\u03c9\u03c8\3\2\2\2\u03c9\u03ca"+
		"\3\2\2\2\u03ca\u03cb\3\2\2\2\u03cb\u03cd\5\u0096L\2\u03cc\u03c7\3\2\2"+
		"\2\u03cc\u03cd\3\2\2\2\u03cd\u03d4\3\2\2\2\u03ce\u03cf\7\u0096\2\2\u03cf"+
		"\u03d1\7\177\2\2\u03d0\u03d2\7q\2\2\u03d1\u03d0\3\2\2\2\u03d1\u03d2\3"+
		"\2\2\2\u03d2\u03d3\3\2\2\2\u03d3\u03d5\5X-\2\u03d4\u03ce\3\2\2\2\u03d4"+
		"\u03d5\3\2\2\2\u03d5\u03dc\3\2\2\2\u03d6\u03d7\7\3\2\2\u03d7\u03d9\7\177"+
		"\2\2\u03d8\u03da\7q\2\2\u03d9\u03d8\3\2\2\2\u03d9\u03da\3\2\2\2\u03da"+
		"\u03db\3\2\2\2\u03db\u03dd\5Z.\2\u03dc\u03d6\3\2\2\2\u03dc\u03dd\3\2\2"+
		"\2\u03dd\u03e3\3\2\2\2\u03de\u03e0\7Z\2\2\u03df\u03e1\7q\2\2\u03e0\u03df"+
		"\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\3\2\2\2\u03e2\u03e4\5\\/\2\u03e3"+
		"\u03de\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03ea\3\2\2\2\u03e5\u03e7\7\35"+
		"\2\2\u03e6\u03e8\7q\2\2\u03e7\u03e6\3\2\2\2\u03e7\u03e8\3\2\2\2\u03e8"+
		"\u03e9\3\2\2\2\u03e9\u03eb\5^\60\2\u03ea\u03e5\3\2\2\2\u03ea\u03eb\3\2"+
		"\2\2\u03eb\u03f1\3\2\2\2\u03ec\u03ee\7+\2\2\u03ed\u03ef\7q\2\2\u03ee\u03ed"+
		"\3\2\2\2\u03ee\u03ef\3\2\2\2\u03ef\u03f0\3\2\2\2\u03f0\u03f2\5:\36\2\u03f1"+
		"\u03ec\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2\u03f8\3\2\2\2\u03f3\u03f5\7k"+
		"\2\2\u03f4\u03f6\7q\2\2\u03f5\u03f4\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6"+
		"\u03f7\3\2\2\2\u03f7\u03f9\5`\61\2\u03f8\u03f3\3\2\2\2\u03f8\u03f9\3\2"+
		"\2\2\u03f9\u0402\3\2\2\2\u03fa\u03ff\5b\62\2\u03fb\u03fc\7\64\2\2\u03fc"+
		"\u03fe\5b\62\2\u03fd\u03fb\3\2\2\2\u03fe\u0401\3\2\2\2\u03ff\u03fd\3\2"+
		"\2\2\u03ff\u0400\3\2\2\2\u0400\u0403\3\2\2\2\u0401\u03ff\3\2\2\2\u0402"+
		"\u03fa\3\2\2\2\u0402\u0403\3\2\2\2\u0403S\3\2\2\2\u0404\u0409\7\u00ae"+
		"\2\2\u0405\u0406\7\64\2\2\u0406\u0408\7\u00ae\2\2\u0407\u0405\3\2\2\2"+
		"\u0408\u040b\3\2\2\2\u0409\u0407\3\2\2\2\u0409\u040a\3\2\2\2\u040aU\3"+
		"\2\2\2\u040b\u0409\3\2\2\2\u040c\u040d\7\u00ae\2\2\u040dW\3\2\2\2\u040e"+
		"\u040f\5H%\2\u040fY\3\2\2\2\u0410\u0411\5H%\2\u0411[\3\2\2\2\u0412\u0413"+
		"\7\u00ad\2\2\u0413]\3\2\2\2\u0414\u0415\7\u00ad\2\2\u0415_\3\2\2\2\u0416"+
		"\u0417\7\u00ad\2\2\u0417a\3\2\2\2\u0418\u0419\7\u009f\2\2\u0419\u0422"+
		"\5d\63\2\u041a\u041c\7)\2\2\u041b\u041a\3\2\2\2\u041b\u041c\3\2\2\2\u041c"+
		"\u041d\3\2\2\2\u041d\u041f\7z\2\2\u041e\u0420\7q\2\2\u041f\u041e\3\2\2"+
		"\2\u041f\u0420\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u0423\5\66\34\2\u0422"+
		"\u041b\3\2\2\2\u0422\u0423\3\2\2\2\u0423\u0429\3\2\2\2\u0424\u0426\7\t"+
		"\2\2\u0425\u0427\7q\2\2\u0426\u0425\3\2\2\2\u0426\u0427\3\2\2\2\u0427"+
		"\u0428\3\2\2\2\u0428\u042a\5\u0096L\2\u0429\u0424\3\2\2\2\u0429\u042a"+
		"\3\2\2\2\u042a\u0431\3\2\2\2\u042b\u042c\7\u0096\2\2\u042c\u042e\7\177"+
		"\2\2\u042d\u042f\7q\2\2\u042e\u042d\3\2\2\2\u042e\u042f\3\2\2\2\u042f"+
		"\u0430\3\2\2\2\u0430\u0432\5X-\2\u0431\u042b\3\2\2\2\u0431\u0432\3\2\2"+
		"\2\u0432\u0439\3\2\2\2\u0433\u0434\7\3\2\2\u0434\u0436\7\177\2\2\u0435"+
		"\u0437\7q\2\2\u0436\u0435\3\2\2\2\u0436\u0437\3\2\2\2\u0437\u0438\3\2"+
		"\2\2\u0438\u043a\5Z.\2\u0439\u0433\3\2\2\2\u0439\u043a\3\2\2\2\u043a\u0440"+
		"\3\2\2\2\u043b\u043d\7Z\2\2\u043c\u043e\7q\2\2\u043d\u043c\3\2\2\2\u043d"+
		"\u043e\3\2\2\2\u043e\u043f\3\2\2\2\u043f\u0441\5\\/\2\u0440\u043b\3\2"+
		"\2\2\u0440\u0441\3\2\2\2\u0441\u0447\3\2\2\2\u0442\u0444\7\35\2\2\u0443"+
		"\u0445\7q\2\2\u0444\u0443\3\2\2\2\u0444\u0445\3\2\2\2\u0445\u0446\3\2"+
		"\2\2\u0446\u0448\5^\60\2\u0447\u0442\3\2\2\2\u0447\u0448\3\2\2\2\u0448"+
		"\u044e\3\2\2\2\u0449\u044b\7+\2\2\u044a\u044c\7q\2\2\u044b\u044a\3\2\2"+
		"\2\u044b\u044c\3\2\2\2\u044c\u044d\3\2\2\2\u044d\u044f\5:\36\2\u044e\u0449"+
		"\3\2\2\2\u044e\u044f\3\2\2\2\u044f\u0455\3\2\2\2\u0450\u0452\7k\2\2\u0451"+
		"\u0453\7q\2\2\u0452\u0451\3\2\2\2\u0452\u0453\3\2\2\2\u0453\u0454\3\2"+
		"\2\2\u0454\u0456\5`\61\2\u0455\u0450\3\2\2\2\u0455\u0456\3\2\2\2\u0456"+
		"c\3\2\2\2\u0457\u0458\7\u00ae\2\2\u0458e\3\2\2\2\u0459\u045a\7\u00ad\2"+
		"\2\u045ag\3\2\2\2\u045b\u045c\7\u00ad\2\2\u045ci\3\2\2\2\u045d\u045e\7"+
		"\u00ad\2\2\u045ek\3\2\2\2\u045f\u0460\t\60\2\2\u0460m\3\2\2\2\u0461\u0462"+
		"\t\61\2\2\u0462o\3\2\2\2\u0463\u0464\t\62\2\2\u0464q\3\2\2\2\u0465\u0466"+
		"\t\63\2\2\u0466s\3\2\2\2\u0467\u0468\7\37\2\2\u0468u\3\2\2\2\u0469\u046b"+
		"\7\u00a5\2\2\u046a\u046c\t\b\2\2\u046b\u046a\3\2\2\2\u046b\u046c\3\2\2"+
		"\2\u046cw\3\2\2\2\u046d\u046f\7d\2\2\u046e\u046d\3\2\2\2\u046e\u046f\3"+
		"\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471\7\u009e\2\2\u0471y\3\2\2\2\u0472"+
		"\u0473\7;\2\2\u0473\u0474\7\u009e\2\2\u0474{\3\2\2\2\u0475\u0476\t\64"+
		"\2\2\u0476}\3\2\2\2\u0477\u0478\t.\2\2\u0478\177\3\2\2\2\u0479\u047a\7"+
		"\u00ae\2\2\u047a\u0081\3\2\2\2\u047b\u047c\7\u00af\2\2\u047c\u0083\3\2"+
		"\2\2\u047d\u047e\7\u00ae\2\2\u047e\u0085\3\2\2\2\u047f\u0480\7\u00ae\2"+
		"\2\u0480\u0087\3\2\2\2\u0481\u0482\7\u00ae\2\2\u0482\u0089\3\2\2\2\u0483"+
		"\u0484\7\u00ae\2\2\u0484\u008b\3\2\2\2\u0485\u0486\7\u00ae\2\2\u0486\u008d"+
		"\3\2\2\2\u0487\u0488\7\u00ae\2\2\u0488\u008f\3\2\2\2\u0489\u048a\7\u00ae"+
		"\2\2\u048a\u0091\3\2\2\2\u048b\u048c\7\u00ae\2\2\u048c\u0093\3\2\2\2\u048d"+
		"\u0494\7\u00ae\2\2\u048e\u0494\7\u00af\2\2\u048f\u0490\7\u008a\2\2\u0490"+
		"\u0491\7\u00af\2\2\u0491\u0494\7\u008a\2\2\u0492\u0494\7M\2\2\u0493\u048d"+
		"\3\2\2\2\u0493\u048e\3\2\2\2\u0493\u048f\3\2\2\2\u0493\u0492\3\2\2\2\u0494"+
		"\u0095\3\2\2\2\u0495\u0499\7\u008a\2\2\u0496\u0498\13\2\2\2\u0497\u0496"+
		"\3\2\2\2\u0498\u049b\3\2\2\2\u0499\u049a\3\2\2\2\u0499\u0497\3\2\2\2\u049a"+
		"\u049c\3\2\2\2\u049b\u0499\3\2\2\2\u049c\u049d\7\u008a\2\2\u049d\u0097"+
		"\3\2\2\2\u00c8\u009a\u00a0\u00a7\u00ad\u00b1\u00b5\u00bc\u00c0\u00c3\u00c6"+
		"\u00cf\u00d1\u00d5\u00d8\u00df\u00e2\u00e5\u00ec\u00ef\u00f3\u00f6\u00f9"+
		"\u0100\u0103\u0106\u010d\u0110\u0114\u0116\u011a\u011d\u0120\u0127\u012a"+
		"\u012d\u0134\u0137\u013b\u013e\u0141\u0148\u014b\u014e\u0155\u0158\u015c"+
		"\u015e\u0162\u0165\u016c\u016f\u0172\u0178\u017c\u0180\u0183\u0187\u018b"+
		"\u018f\u0193\u0196\u01a5\u01ac\u01b0\u01b9\u01c0\u01c4\u01c6\u01d1\u01d8"+
		"\u01df\u01e6\u01ed\u01f0\u01f3\u01fb\u0204\u0207\u020a\u0211\u0215\u0218"+
		"\u021b\u021d\u0222\u0226\u022d\u0230\u0235\u0239\u023d\u0241\u0246\u024a"+
		"\u0250\u0257\u025a\u0261\u026a\u026f\u0276\u027a\u027c\u0284\u0289\u028e"+
		"\u0296\u029a\u029f\u02a4\u02a9\u02ae\u02b2\u02b7\u02ba\u02bf\u02c3\u02c7"+
		"\u02cc\u02d1\u02d7\u02dc\u02e1\u02e6\u02eb\u02f0\u02f5\u02fa\u02ff\u0304"+
		"\u030b\u030f\u0316\u0319\u031e\u0336\u0339\u033e\u0346\u034c\u035c\u0368"+
		"\u036a\u036e\u0373\u037b\u0381\u0387\u038b\u038d\u0394\u0397\u039e\u03ad"+
		"\u03b2\u03b9\u03bb\u03be\u03c2\u03c5\u03c9\u03cc\u03d1\u03d4\u03d9\u03dc"+
		"\u03e0\u03e3\u03e7\u03ea\u03ee\u03f1\u03f5\u03f8\u03ff\u0402\u0409\u041b"+
		"\u041f\u0422\u0426\u0429\u042e\u0431\u0436\u0439\u043d\u0440\u0444\u0447"+
		"\u044b\u044e\u0452\u0455\u046b\u046e\u0493\u0499";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}