package com.toubou91.filedetect.tika.test;

import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.*;

public class FileTypesTest {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(FileTypesTest.class);
	private String filename = null;
	
	/**
	 * Test CSV file detection.
	 */
	@Test
	public void testCSV() {
		filename = "/SacramentocrimeJanuary2006.csv";
		
		try {
			TikaInputStream stream = TikaInputStream.get(getClass().getResourceAsStream(filename));
			MediaType  mediaType = new AutoDetectParser().getDetector().detect(stream, new Metadata());
			
			logger.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");
			Assert.assertEquals("text/plain", mediaType.getBaseType().toString());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			logger.debug(e.getMessage());
		}
	}
	
	/**
	 * Test PDF file detection.
	 */
	@Test
	public void testPdf() {
		filename = "/leading_the_way_2015.pdf";
		try {
			TikaInputStream stream = TikaInputStream.get(getClass().getResourceAsStream(filename));
			MediaType  mediaType = new AutoDetectParser().getDetector().detect(stream, new Metadata());
			
			logger.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");
			Assert.assertEquals("application/pdf", mediaType.getBaseType().toString());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			logger.debug(e.getMessage());
		}
	}
	
	/**
	 * Test XML file detection.
	 */
	@Test
	public void testXml() {
		filename = "/note.xml";
		
		try {
			TikaInputStream stream = TikaInputStream.get(getClass().getResourceAsStream(filename));
			MediaType  mediaType = new AutoDetectParser().getDetector().detect(stream, new Metadata());
			
			logger.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");
			Assert.assertEquals("application/xml", mediaType.getBaseType().toString());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			logger.debug(e.getMessage());
		}
	}
	
	/**
	 * Test JPEG image detection.
	 */
	@Test
	public void testJpeg() {
		filename = "/sample_image.jpg";
		
		try {
			TikaInputStream stream = TikaInputStream.get(getClass().getResourceAsStream(filename));
			MediaType  mediaType = new AutoDetectParser().getDetector().detect(stream, new Metadata());
			
			logger.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");
			Assert.assertEquals("image/jpeg", mediaType.getBaseType().toString());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			logger.debug(e.getMessage());
		}
	}
	
	/**
	 * Test HTML file detection.
	 */
	@Test
	public void testHtml() {
		filename = "/index.html";
		
		try {
			TikaInputStream stream = TikaInputStream.get(getClass().getResourceAsStream(filename));
			MediaType  mediaType = new AutoDetectParser().getDetector().detect(stream, new Metadata());
			
			logger.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");
			Assert.assertEquals("text/html", mediaType.getBaseType().toString());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
			logger.debug(e.getMessage());
		}
	}
}
