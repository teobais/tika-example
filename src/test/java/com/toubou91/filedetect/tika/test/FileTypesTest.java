package com.toubou91.filedetect.tika.test;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;

import com.toubou91.filedetect.tika.example.FileTypeValidator;

public class FileTypesTest {

	private final Logger LOG = org.slf4j.LoggerFactory.getLogger(FileTypesTest.class);
	

	/**
	 * Test CSV file detection.
	 */
	@Test
	public void testCSV() {
		try {
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("SacramentocrimeJanuary2006.csv"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test PDF file detection.
	 */
	@Test
	public void testPdf() {
		try {
			
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("leading_the_way_2015.pdf"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test XML file detection.
	 */
	@Test
	public void testXml() {
		try {
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("note.xml"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test JPEG image detection.
	 */
	@Test
	public void testJpeg() {
		try {
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("sample_image.jpg"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test HTML file detection.
	 */
	@Test
	public void testHtml() {
		try {
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("index.html"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}

	/**
	 * Test doc file detection.
	 */
	@Test
	public void testDoc() {
		try {
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("test.doc"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}
	
	/**
	 * Test docx file detection.
	 */
	@Test
	public void testDocx() {
		try {			
			Assert.assertTrue(FileTypeValidator.isAcceptedSupportingDoc("test.docx"));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			LOG.debug(e.getMessage());
		}
	}
}
