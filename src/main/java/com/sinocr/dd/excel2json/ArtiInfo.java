package com.sinocr.dd.excel2json;

import java.io.Serializable;

public class ArtiInfo implements Serializable {

	private static final long serialVersionUID = -3565862694093810088L;

	private String groupId;
	private String version;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}