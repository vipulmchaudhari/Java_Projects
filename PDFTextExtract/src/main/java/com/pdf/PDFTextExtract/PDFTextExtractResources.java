package com.pdf.PDFTextExtract;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.preflight.PreflightDocument;
import org.apache.pdfbox.preflight.ValidationResult;
import org.apache.pdfbox.preflight.ValidationResult.ValidationError;
import org.apache.pdfbox.preflight.parser.PreflightParser;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Produces(MediaType.APPLICATION_JSON)
public class PDFTextExtractResources {
    private static final Logger LOG = LoggerFactory.getLogger(PDFTextExtractResources.class);

    @GetMapping("/details")
    public PDFDetails findMassSchemeById() throws Exception {   	
    	PDFDetails lPDFDetails = new PDFDetails();
		
		// Loading an existing document
		File url = new File("C:\\Users\\vipul\\OneDrive\\Documents\\Java_Projects\\PDFTextExtract\\src\\main\\java\\com\\pdf\\PDFTextExtract\\sample.pdf");
    	//URL url = getClass().getResource("sample.pdf");
    	File file = new File(url.toURI());

		PDDocument document = PDDocument.load(file);
		if (!validate(file)) {
			throw new Exception();
		} else {
			LOG.info("PDF is Valid");
		}

		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		
		// Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		LOG.info("PDF Text: "+text);

		PDDocumentInformation docInfo = document.getDocumentInformation();
		lPDFDetails.setName(docInfo.getTitle()==null?"Sample PDF":docInfo.getTitle());
		lPDFDetails.setMetadata(docInfo.getMetadataKeys().toString());
		lPDFDetails.setPdfBody(text);
		lPDFDetails.setOtherData(pdfStripper.getPageEnd()+pdfStripper.getPageStart());
		
		// Closing the document
		document.close();    	
    	return lPDFDetails;
    }
    
    //Validate PDF
	public boolean validate(File file) throws Exception {
		List<ValidationError> errorList = new ArrayList<ValidationError>();

		PreflightParser parser = null;
		PreflightDocument document = null;
		ValidationResult result = null;
		try {
			parser = new PreflightParser(file);
			parser.parse();
			document = parser.getPreflightDocument();
			document.validate();
			result = document.getResult();
			errorList = result.getErrorsList();
		} catch (Exception e) {
			throw e;
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (Exception ignored) {
				}
			}
			parser = null;
			document = null;
			result = null;
		}
		return errorList.size() > 0 ? true : false;
	}

    
}