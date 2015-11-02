/**
 * Define a grammar for MySQL's CREATE TABLE syntax
 */
grammar CreateTable;


options {
    language = Java;
}


@header {

package com.matthewroyal.marklogic.CreateTableParser;

}

@members {

  // Old String default
  private StringBuilder myString = new StringBuilder("tables: ");

  private void addString(String s){
    if(s!=null && s.length() > 0){
        myString.append(s);
     }
  }


}

@rulecatch{
    catch (RecognitionException e){
            throw e;
      }
}


evaluate returns [String result]
  : ((drop_statement | create_statement) ';')+ { $result = myString.toString(); }
  ;

drop_statement
  : ('drop'|'DROP') ('table'|'TABLE') ('if exists'|'IF EXISTS')? 
    tbl_name 
  ;

create_statement
  : ('create'|'CREATE') ('temporary'|'TEMPORARY')? ('table'|'TABLE') ('if not exists'|'IF NOT EXISTS')? 
    tbl_name '('?
    create_definition (',' create_definition)* 
    ')'?
    (table_options)?
    (partition_options)?
  ;

tbl_name
  : ID
  ;

create_definition
  : (col_name column_definition
      | ('CONSTRAINT' (symbol)?)? primary (index_type)? '('? (index_col_name (',' index_col_name)*)? ')'? 
          (index_option (',' index_option)*)?
      | ('INDEX'|'KEY') (index_name)? (index_type)? '('? (index_col_name (',' index_col_name)*)? ')'?
          (index_option (',' index_option)*)?
      | ('CONSTRAINT' (symbol)?)? unique
          (index_name)? (index_type)? '('? (index_col_name (',' index_col_name)*)? ')'?
          (index_option (',' index_option)*)?
      | ('FULLTEXT'|'SPATIAL') ('INDEX'|'KEY')? (index_name)? '('? (index_col_name (',' index_col_name)*)? ')'?
          (index_option (',' index_option)*)?
      | ('CONSTRAINT' (symbol)?)? foreign
          (index_name)? '('? (index_col_name (',' index_col_name)*)? ')'? reference_definition
      | 'CHECK' (expr)
      
      )
  ; 

column_definition
  : data_type nullable? ('DEFAULT' default_value)?
      auto_increment? (unique | primary)?
      ('COMMENT' comment_string)?
      ('COLUMN_FORMAT' column_format)?
      ('STORAGE' storage)?
      (reference_definition)?
  ;

data_type
  :
    // Simple types without parameters
    datatype_simple
    
    // Simple type with length parameter
  | datatype_length

    // Integer family of types
  | datatype_ints  
  
    // Real family of types
  | datatype_reals
  
    // Char family of types
  | datatype_chars
      
    // Text family of types
  | datatype_texts
      
    // Enums
  | ('ENUM'|'enum') '(' (enum_value (',' enum_value)*) ')'
      ('CHARACTER' 'SET' charset_name)? ('COLLATE' collation_name)?
    
    // Set values
  | ('SET'|'set') '(' (set_value (',' set_value)*) ')'
      ('CHARACTER' 'SET' charset_name)? ('COLLATE' collation_name)?
//  | spatial_type //TODO look this up -- could be really awesome to translate to native geospatial coordinates
  ;

datatype_simple
  : ('DATE'|'date')
  | ('TIME'|'time')
  | ('TIMESTAMP'|'timestamp')
  | ('DATETIME'|'datetime')
  | ('YEAR'|'year')
  | ('TINYBLOB'|'tinyblob')
  | ('BLOB'|'blob')
  | ('MEDIUMBLOB'|'mediumblob')
  | ('LONGBLOB'|'longblob')
  ;

datatype_length
  : ('BIT'|'bit') ('('length')')?
  | binary ('('length')')?
  | ('VARBINARY'|'varbinary') '('length')'
  ;

datatype_ints
  : datatype_ints_values ('('length')')? unsigned? zerofill?
  ;

datatype_ints_values
  : ('TINYINT'|'tinyint')
  | ('SMALLINT'|'smallint')
  | ('MEDIUMINT'|'mediumint')
  | ('INT'|'int')
  | ('INTEGER'|'integer')
  | ('BIGINT'|'bigint')
  ;

datatype_reals
  : datatype_reals_values ('('length  ',' decimals   ')')? unsigned? zerofill?
  | datatype_reals_values2 ('('length (',' decimals)? ')')? unsigned? zerofill?
  ;

datatype_reals_values
  : ('REAL'|'real')
  | ('DOUBLE'|'double')
  | ('FLOAT'|'float')
  ; 

datatype_reals_values2
  : ('DECIMAL'|'decimal')
  | ('NUMERIC'|'numeric')
  ;
  
datatype_chars
  : datatype_chars_values ('('length')')? binary?
      ('CHARACTER' 'SET' charset_name)? ('COLLATE' collation_name)?
  ;

datatype_chars_values
  : ('CHAR'|'char')
  | ('VARCHAR'|'varchar') 
  ;

datatype_texts
  : datatype_texts_values binary? 
      ('CHARACTER' 'SET' charset_name)? ('COLLATE' collation_name)?
  ;
  
datatype_texts_values
  : ('TINYTEXT'|'tinytext') 
  | ('TEXT'|'text')
  | ('MEDIUMTEXT'|'mediumtext')
  | ('LONGTEXT'|'longtext')
  ;

index_col_name
  : col_name ('(' length ')')? ('ASC' | 'DESC')?
  ;

index_type
  : 'USING' ('BTREE' | 'HASH')
  ;

index_option
  : 'KEY_BLOCK_SIZE' '='? key_block_size_value
      | index_type
      | 'WITH' 'PARSER' parser_name
      | 'COMMENT' comment_string
  ;
  

reference_definition
  : 'REFERENCES' tbl_name ('('? index_col_name (',' index_col_name)* ')'?)? 
      ('MATCH' 'FULL' | 'MATCH' 'PARTIAL' | 'MATCH' 'SIMPLE')?
      ('ON' 'DELETE' reference_option)?
      ('ON' 'UPDATE' reference_option)?
  ;

reference_option
  : 'RESTRICT' | 'CASCADE' | 'SET' 'NULL' | 'NO' 'ACTION'
  ;
  
table_options
  : table_option (','? table_option)*
  ;

table_option
  : 'ENGINE' '='? engine_name
  | 'AUTO_INCREMENT' '='? auto_increment_value
  | 'AVG_ROW_LENGTH' '='? avg_row_length_value
  | 'DEFAULT'? ('CHARACTER' 'SET'|'CHARSET') '='? charset_name
  | 'CHECKSUM' '='? ('0' | '1')
  | 'DEFAULT'? 'COLLATE' '='? collation_name
  | 'COMMENT' '='? comment_string
  | 'CONNECTION' '='? connect_string
  | 'DATA' 'DIRECTORY' '='? absolute_path_to_directory
  | 'DELAY_KEY_WRITE' '='? ('0' | '1')
  | 'INDEX DIRECTORY' '='? absolute_path_to_directory
  | 'INSERT_METHOD' '='? ('NO' | 'FIRST' | 'LAST')
  | 'KEY_BLOCK_SIZE' '='? key_vlock_size_value
  | 'MAX_ROWS' '='? max_rows_value
  | 'MIN_ROWS' '='? min_rows_value
  | 'PACK_KEYS' '='? ('0' | '1' | 'DEFAULT')
  | 'PASSWORD' '='? password_string
  | 'ROW_FORMAT' '='? ('DEFAULT'|'DYNAMIC'|'FIXED'|'COMPRESSED'|'REDUNDANT'|'COMPACT')
  | 'TABLESPACE' tablespace_name ('STORAGE' ('DISK'|'MEMORY'|'DEFAULT'))?
  | 'UNION' '='? (tbl_name (',' tbl_name)*)
  ;

password_string : .+? ; // TODO: Research actual password character and length restrictions.

engine_name : ALPHANUMERIC ;
connect_string : ID ; // TODO: Reformat this to be an actual connection string;
tablespace_name : ID ;

auto_increment_value : INTEGER ;
avg_row_length_value : INTEGER ;
key_vlock_size_value : INTEGER; 
max_rows_value : INTEGER;
min_rows_value : INTEGER;

absolute_path_to_directory : path ;

path
  : ('/' ID)+ '/'?
  ;

partition_options
  : 'PARTITION' 'BY'
        ( 'LINEAR'? 'HASH' '(' expr ')'
        | 'LINEAR'? 'KEY' ('ALGORITHM' '=' ('1'|'2'))? '(' column_list ')'
        | 'RANGE' ('('expr')' | 'COLUMNS' '(' column_list ')')
        | 'LIST'  ('('expr')' | 'COLUMNS' '(' column_list ')') )
    ('PARTITIONS' partitions_num)?
    ('SUBPARTITION' 'BY'
        ( 'LINEAR'? 'HASH' '(' expr ')'
        | 'LINEAR'? 'KEY' ('ALGORITHM' '=' ('1'|'2'))? '(' column_list ')' )
      ('SUBPARTITIONS' subpartitions_num)?
    )?
    (partition_definition (',' partition_definition)*)?
  ;
    
column_list
  : col_name (',' col_name)*
  ;

partitions_num : INTEGER ;
subpartitions_num : INTEGER;

partition_definition
  : 'PARTITION' partition_name
        ('VALUES' 
            ('LESS' 'THAN' ( '('(expr | value_list)')' | 'MAXVALUE') 
            | 
            'IN' '('value_list')'))?
        ('STORAGE'? 'ENGINE' '='? engine_name)?
        ('COMMENT' '='? comment_string )?
        ('DATA' 'DIRECTORY' '='? data_dir)?
        ('INDEX' 'DIRECTORY' '='? index_dir)?
        ('MAX_ROWS' '='? max_number_of_rows)?
        ('MIN_ROWS' '='? min_number_of_rows)?
        ('TABLESPACE' '='? tablespace_name)?
        ('NODEGROUP' '='? node_group_id)?
        (subpartition_definition (',' subpartition_definition)*)?
  ;

value_list
  : ID (',' ID)*
  ;
  
partition_name : ID ;
data_dir : path ;
index_dir : path;
max_number_of_rows : INTEGER ;
min_number_of_rows : INTEGER;
node_group_id : INTEGER ;

subpartition_definition
  : 'SUBPARTITION' logical_name
        ('STORAGE'? 'ENGINE' '='? engine_name)?
        ('COMMENT' '='? comment_string )?
        ('DATA' 'DIRECTORY' '='? data_dir)?
        ('INDEX' 'DIRECTORY' '='? index_dir)?
        ('MAX_ROWS' '='? max_number_of_rows)?
        ('MIN_ROWS' '='? min_number_of_rows)?
        ('TABLESPACE' '='? tablespace_name)?
        ('NODEGROUP' '='? node_group_id)?
  ;

logical_name : ID ;
  
key_block_size_value  : INTEGER  ;
length   : INTEGER  ;
decimals : INTEGER  ;
unsigned : ('UNSIGNED'|'unsigned');
zerofill : ('ZEROFILL'|'zerofill');
binary   : ('BINARY'|'binary');
nullable : ('NOT NULL' | 'NULL' | 'not null' | 'null');
auto_increment : ('AUTO_INCREMENT');
unique   : 'UNIQUE' ('INDEX'|'KEY')?;
primary  : ('PRIMARY')? 'KEY';
foreign  : 'FOREIGN' 'KEY';
column_format  : ('FIXED'|'DYNAMIC'|'DEFAULT');
storage  : ('DISK'|'MEMORY'|'DEFAULT');
INTEGER : [0-9]+ ;

expr  : ID  ;
charset_name  : ALPHANUMERIC ;  
collation_name : ID ;  
enum_value : ID ;
set_value : ID ;
spatial_type : ID ; // TODO: Lookup what these should be.
parser_name : ID ;

col_name       : ID ;
symbol         : ID ;
index_name     : ID ;
default_value  : ID | ALPHANUMERIC | '\'' ALPHANUMERIC '\'' | 'NULL';

comment_string :  '\'' .*? '\'' ;


ID : [a-z]+ | '`' [a-zA-Z 0-9\-_]+ '`' ;             // match lower-case identifiers

ALPHANUMERIC: [a-zA-Z0-9\-_.]+   ;

WS : ([ \t\r\n]+ | '--' .*? NL | '#' .*? NL | '/*' .*? '*/' ';'? ) -> skip ; // skip spaces, tabs, newlines, semicolons, code comments

NL      : '\r'? '\n' | '\r';

/*
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
*/

