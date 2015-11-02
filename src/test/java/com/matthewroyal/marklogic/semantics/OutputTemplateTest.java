package com.matthewroyal.marklogic.semantics;

import static org.junit.Assert.*;

import org.junit.Test;

public class OutputTemplateTest {

	@Test
	public void testGetNextOutputFilename() {
		OutputTemplate ot = new OutputTemplate();
		
		String noExtensionBefore = "outputfile";
		String noExtensionAfter = "outputfile.1.out";
		assertEquals(noExtensionAfter, ot.getNextOutputFilename(noExtensionBefore));
		
		String standardTextfileUnversionedBefore = "thisisafile.txt";
		String standardTextfileUnversionedAfter = "thisisafile.1.txt";
		assertEquals(standardTextfileUnversionedAfter, ot.getNextOutputFilename(standardTextfileUnversionedBefore));
		
		String standardTextfileVersionedBefore = "thisisafile.1001.txt";
		String standardTextfileVersionedAfter = "thisisafile.1002.txt";
		assertEquals(standardTextfileVersionedAfter, ot.getNextOutputFilename(standardTextfileVersionedBefore));
		
		String lotsOfPeriodsUnversionedBefore = "over.categorization.is.my.lifes.blood.rdf";
		String lotsOfPeriodsUnversionedAfter = "over.categorization.is.my.lifes.blood.1.rdf";
		assertEquals(lotsOfPeriodsUnversionedAfter, ot.getNextOutputFilename(lotsOfPeriodsUnversionedBefore));
		
		String lotsOfPeriodsVersionedBefore = "over.categorization.is.my.lifes.blood.23.rdf";
		String lotsOfPeriodsVersionedAfter = "over.categorization.is.my.lifes.blood.24.rdf";
		assertEquals(lotsOfPeriodsVersionedAfter, ot.getNextOutputFilename(lotsOfPeriodsVersionedBefore));

	}

}
