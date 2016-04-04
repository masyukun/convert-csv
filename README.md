# convert-csv
Tool to 1) convert relational schemas into MarkLogic sem:triples and 2) convert CSV files into a number of destination formats, including XML, RDF, user-provided template, and MarkLogic sem:triple nodes.

##Background information
Here is a PowerPoint presentation of the project's technical background. It will be updated periodically, but may lag behind current functionality. There is a demo script in the same folder with a sample workflow that you can adapt to use this tool on your own dataset. https://github.com/masyukun/convert-csv/blob/master/demo-ppt/

##Required libraries:
 - ANTLR 4.4+ Complete and Runtime http://www.antlr.org/download.html
 - Apache Collections 4.0+ https://commons.apache.org/proper/commons-collections/
 - Apache Commons CSV 1.1+ https://commons.apache.org/proper/commons-csv/
 - Apache Commons CLI 1.2+ https://commons.apache.org/proper/commons-cli/
 - Apache Commons Lang 3.4+ https://commons.apache.org/proper/commons-lang/
 - Apache Log4j 2.4+ https://logging.apache.org/log4j/2.x/ 

##Parameters, command-line and properties file
| Option        | Meaning |
|:----------|:--------------|
| --csv-filename <CSVFILENAME>        |File name of the CSV file to read as input.
| --csv-input-directory <CSVFILENAME> | The absolute path of a folder containing 1 or more CSV files for ingest. Overrides csv-filename!
| --database-name <DBNAME>            | Name of database for output schema. (Default=[sql-file]) |
| --define-header <DEFINITION-STRING> | Specify the header by command line with comma separated list. "ColumnID,Column1,Column2,Column3" |
| --generate-triples <BOOLEAN>        | Should the code attempt to generate MarkLogic sem:triple nodes inside the resulting output document? (True/false) |
| --has-header                        |  The first line of the CSV file contains a comma separated list of column names. |
| --output-filename <FILENAME>        |  Filename to store converted content. |
| --output-filename-auto <BOOLEAN>    |  Automatically generate output filenames based on the name of each input CSV file. |
| --output-format <TYPE>              |  Type to convert into: SEMTRIPLE, TEMPLATE, XML |
| --output-path <PATH>                |  Output directory for output files as absolute filesystem path. |
| --output-record-num <NUMRECORDS>    |  Maximum number of transformed records to write to the output file before starting a new output file. |
| --properties-file <FILENAME>        |  set properties file name [convertCsv.properties] |
| --schema-output-filename <OUTFILE>  |  Filename for output schema. (Default=[myfile.txt]) |
| --schema-output-type <FORMAT>       |  Format of output schema: PLAINTEXT, SEMTRIPLES, SQLINSERT |
| --sql-file <SQLFILE>                |  Filename of MySQL SQL file containing CREATE TABLE statements to ingest. |
| --template-file <TEMPLATEFILENAME>  |  File name of template file to use. |
| --template-footer <FOOTER>          |  Footer content to insert at the end of each template output file. |
| --template-header <HEADER>          |  Header content to insert at the beginning of each template output file. |
| --xml-namespace <URI>               |  Default namespace URI for XML output file. |
| --xml-namespace-prefix <PREFIX>     |  Prefix name for XML default namespace. |
| --xml-record <ELEMENTNAME>          |  Element name for each output CSV record. |
| --xml-root <ELEMENTNAME>            |  Element name for root of XML output file. |
