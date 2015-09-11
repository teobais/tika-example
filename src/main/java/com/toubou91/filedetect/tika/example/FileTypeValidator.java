package com.toubou91.filedetect.tika.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;

/**
 * Perform validation against the supported format of an uploaded file.
 * 
 * @author Thodoris Bais
 */
public class FileTypeValidator {

	private static final Logger LOGGER = Logger.getLogger(FileTypeValidator.class);
	private final static Detector detector = TikaConfig.getDefaultConfig().getDetector();
	private static MediaType mediaType = null;
	private final static String parentDirectory = "./src/main/resources/";

	/**
	 * Detects whether a file is of "xml" type.
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 */
	public static boolean isXml(byte[] filebytes) {

		try {
			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			if (mediaType.getSubtype().equals("xml"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());

		}
		return false;
	}

	/**
	 * Detects whether a file is of "pdf" type.
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 */
	public static boolean isPdf(byte[] filebytes) {
		try {
			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			if (mediaType.getSubtype().equals("pdf"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());

		}
		return false;
	}

	/**
	 * Detects whether a file is of "jpeg" type.
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 */
	public static boolean isJpeg(byte[] filebytes) {
		try {
			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			if (mediaType.getSubtype().equals("jpeg"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * Detects whether a file is of "doc" or ".docx" type.
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 */
	public static boolean isDoc(byte[] filebytes) {
		try {
			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			if (mediaType.getSubtype().equals("msword")
					|| mediaType.getSubtype().equals("vnd.openxmlformats-officedocument.wordprocessingml.document"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * Detects whether a file is of "zip" type.
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 */
	public static boolean isZip(byte[] filebytes) {
		try {
			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			if (mediaType.getSubtype().equals("zip"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

	/**
	 * Detects whether a file is of any acceptable type ("pdf", "doc", "docx",
	 * "zip", "jpeg").
	 * 
	 * @param filebytes
	 *            The byte array argument of the caller method.
	 * @return A boolean.
	 * @throws UnsupportedEncodingException
	 */
	public static boolean isAcceptedSupportingDoc(String filename) {
		try {
			Path path = Paths.get(parentDirectory + filename);
			byte[] filebytes = Files.readAllBytes(path);

			mediaType = detector.detect(TikaInputStream.get(filebytes), new Metadata());
			
			LOGGER.debug("File " + filename + " is of type " + mediaType.getBaseType() + ".");

			if (mediaType.getSubtype().equals("vnd.openxmlformats-officedocument.wordprocessingml.document")
					|| mediaType.getSubtype().equals("msword") || mediaType.getSubtype().equals("zip")
					|| mediaType.getSubtype().equals("pdf") || mediaType.getSubtype().equals("jpeg")
					|| mediaType.getSubtype().equals("html") || mediaType.getSubtype().equals("xml")
					|| mediaType.getSubtype().equals("plain"))
				return true;
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return false;
	}

}
