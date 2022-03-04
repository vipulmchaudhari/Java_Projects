package com.pdf.PDFTextExtract;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;


public class PDFTextExtractResourcesTest {
	String jsonMimeType = "application/json";

	@Test
	public void checkIfRequestIsOK() throws IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/details");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		//Check http response status code 200
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK_200);
	}

	@Test
	public void checkJSONResponse() throws IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/details");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		//Get Mime type
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK_200);
		assertEquals(jsonMimeType, mimeType);
	}

	@Test
	public void checkPDFContent() throws IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/details");

		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		String jsonFromResponse = EntityUtils.toString(response.getEntity());

		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals(jsonMimeType, mimeType);
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK_200);
		assertNotNull(jsonFromResponse);
		
		//convert string json to json object
		JsonObject convertedObject = new Gson().fromJson(jsonFromResponse, JsonObject.class);

		//Validating content
		Assert.assertTrue(convertedObject.isJsonObject());
		Assert.assertTrue(convertedObject.get("name").getAsString().equals("Sample PDF"));
		assertNotNull(convertedObject.get("pdfBody"));
	}

}