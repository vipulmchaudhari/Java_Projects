package com.pdf.PDFTextExtract;

public class PDFDetails {
	private String name;
	private String metadata;
	private String pdfBody;
	private String otherData;

	/**
	 * @return the otherData
	 */
	public String getOtherData() {
		return otherData;
	}
	/**
	 * @param otherData the otherData to set
	 */
	public void setOtherData(String otherData) {
		this.otherData = otherData;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the metadata
	 */
	public String getMetadata() {
		return metadata;
	}
	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	/**
	 * @return the pdfBody
	 */
	public String getPdfBody() {
		return pdfBody;
	}
	/**
	 * @param pdfBody the pdfBody to set
	 */
	public void setPdfBody(String pdfBody) {
		this.pdfBody = pdfBody;
	}
}
