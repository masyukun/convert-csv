package com.matthewroyal.marklogic.semantics;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import com.matthewroyal.grammar.HelloLexer;
import com.matthewroyal.grammar.HelloParser;

public class ParseSchema {

	public ParseSchema() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws Exception{
     
		String parseme = "hello world";
        CharStream charstream = new ANTLRInputStream(parseme);
        HelloLexer lexer = new HelloLexer(charstream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokenStream);
        String parsed = parser.r().getText();
        System.out.println("\n\nParsed: [" + parsed + "]");
     
        
	}


}
