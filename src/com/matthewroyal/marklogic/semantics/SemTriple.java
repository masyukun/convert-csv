package com.matthewroyal.marklogic.semantics;

public class SemTriple {

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

}
