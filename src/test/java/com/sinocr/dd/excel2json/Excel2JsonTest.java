package com.sinocr.dd.excel2json;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;

public class Excel2JsonTest extends TestCase {
	public static final String SOURCE_FILE_STRING = "data/sample.xlsx";

	/*@Test
	public void test1() {
		System.out.println("***********"+"  test1");
		Excel2Json excel2Json = null;
		try {
			excel2Json = new Excel2Json(SOURCE_FILE_STRING);
			String jsonString = excel2Json.getData();
			String formatString = jsonString.replace(",", ",\n");
			System.out.println(formatString);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***********"+"  test1 end");
	}*/
	@Test
	public void test2() {
		System.out.println("***********"+"  test2");
		Excel2JsonM excel2Json = null;
		try {
			excel2Json = new Excel2JsonM(SOURCE_FILE_STRING);
			String jsonString = excel2Json.getData();
			String formatString = jsonString.replace(",", ",\n");
			System.out.println(formatString);
			Assert.assertNotNull(formatString);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***********"+"  test2 end");
	}
}
