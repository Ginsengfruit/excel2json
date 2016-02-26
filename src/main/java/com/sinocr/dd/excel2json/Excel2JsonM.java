package com.sinocr.dd.excel2json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.sf.json.JSONObject;

public class Excel2JsonM {
	public static final String ARTIFACT_ID_STRING = "artifactid";
	public static final String GROUP_ID_STRING = "groupid";
	public static final String VERSION_STRING = "version";

	private Workbook wb = null;
	private Map<String, List<ArtiInfo>> dependInfoMap = new HashMap<String, List<ArtiInfo>>();

	public Excel2JsonM(String path) throws IOException, EncryptedDocumentException, InvalidFormatException {
		wb = WorkbookFactory.create(new File(path));
	}

	public String getData() {
		int groupIdIndex = 0;
		int artifactIdIndex = 1;
		int versionIndex = 2;
		boolean isRow0Header = false;
		Sheet sheet = wb.getSheetAt(0);
		Row row0 = sheet.getRow(0);
		if (row0 != null && row0.getLastCellNum() > 0) {
			for (int j = 0; j < row0.getLastCellNum(); j++) {
				Cell cell = row0.getCell(j);
				String cellString = cell.getStringCellValue().toLowerCase();
				if (cellString.equals(GROUP_ID_STRING)) {
					groupIdIndex = j;
					isRow0Header = true;
				} else if (cellString.equals(ARTIFACT_ID_STRING)) {
					artifactIdIndex = j;
					isRow0Header = true;
				} else if (cellString.equals(VERSION_STRING)) {
					versionIndex = j;
					isRow0Header = true;
				}
			}
		}
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			if (i == 0 && isRow0Header) {
				continue;
			}
			Row row = sheet.getRow(i);
			if (row != null && row.getLastCellNum() > 0) {
				ArtiInfo aInfo = new ArtiInfo();
				String artiString = null;
				for (int j = 0; j < row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					String cellString = cell.getStringCellValue();
					if (j == groupIdIndex) {
						aInfo.setGroupId(cellString);
					} else if (j == artifactIdIndex) {
						artiString = cellString;
					} else if (j == versionIndex) {
						aInfo.setVersion(cellString);
					}
				}
				boolean isAlreadHas = false;
				for (String key : dependInfoMap.keySet()) {
					if (key.equals(artiString)) {
						List<ArtiInfo>value = dependInfoMap.get(key);
						value.add(aInfo);
						isAlreadHas=true;
					}
				}
				if (isAlreadHas == false) {
					List<ArtiInfo> artiInfos=new ArrayList<ArtiInfo>();
					artiInfos.add(aInfo);
					dependInfoMap.put(artiString, artiInfos);
				}
			}
		}
		return JSONObject.fromObject(dependInfoMap).toString();
	}
}

