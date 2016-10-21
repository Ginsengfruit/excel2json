package com.sinocr.dd.excel2json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONString;

@Deprecated
public class DependInfo implements JSONString, Serializable {

	private static final long serialVersionUID = -226679334548189783L;

	private String artifactId;
	private List<ArtiInfo> artiInfos = new ArrayList<ArtiInfo>();

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public List<ArtiInfo> getArtiInfos() {
		return artiInfos;
	}

	public void setArtiInfos(List<ArtiInfo> artiInfos) {
		this.artiInfos = artiInfos;
	}

	public void addArtiInfo(ArtiInfo artiInfo) {
		for (ArtiInfo info : artiInfos) {
			if (info.getGroupId().equals(artiInfo.getGroupId()) && info.getVersion().equals(artiInfo.getVersion())) {
				return;
			}
		}
		artiInfos.add(artiInfo);
	}

	public String toJSONString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\"" + artifactId + "\":");
		JSONArray aInfo = JSONArray.fromObject(artiInfos);
		sb.append(aInfo.toString());
		return sb.toString();
	}

}
