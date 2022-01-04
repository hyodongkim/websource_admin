package com.teachingcash.common.vo;

public class FileVO {
	private int id;
	private int parentId;
	private String parentType;
	private String originalName;
	private String savedName;
	private long fileSize;
	private String uploadPath;
	private String insert_date;
	
	public FileVO() {
		super();
	}
	public FileVO(int parentId, String parentType, String originalName, String savedName, long fileSize, String uploadPath) {
		super();
		this.parentId = parentId;
		this.parentType = parentType;
		this.originalName = originalName;
		this.savedName = savedName;
		this.fileSize = fileSize;
		this.uploadPath = uploadPath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	@Override
	public String toString() {
		return "FileVO [id=" + id + ", parentType = "+parentType+", parentId=" + parentId + ", originalName=" + originalName + ", savedName=" + savedName + ", fileSize=" + fileSize + ", uploadPath=" + uploadPath + ", insert_date=" + insert_date + "]";
	}
	
}