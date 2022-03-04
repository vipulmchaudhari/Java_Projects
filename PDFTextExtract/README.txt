Technical Challenge:
1. Access PDF using any API
2. Validate PDF
3. Extract few attribute/text and return in JSON
4. Write appropriate Unit Test Cases

How to Run Project
1. Run main springboot class PdfTextExtractApplication
   http://localhost:8080/details
   Sample Json Response:
   {"name":"Sample PDF","metadata":"[CreationDate, Creator, Producer]","pdfBody":" A Simple PDF File \r\n This is a small demonstration .pdf file - \r\n just for use in the Virtual Mechanics tutorials. More text. And more \r\n text. And more text. And more text. And more text. \r\n And more text. And more text. And more text. And more text. And more \r\n text. And more text. Boring, zzzzz. And more text. And more text. And \r\n more text. And more text. And more text. And more text. And more text. \r\n And more text. And more text. \r\n And more text. And more text. And more text. And more text. And more \r\n text. And more text. And more text. Even more. Continued on page 2 ...\r\n Simple PDF File 2 \r\n ...continued from page 1. Yet more text. And more text. And more text. \r\n And more text. And more text. And more text. And more text. And more \r\n text. Oh, how boring typing this stuff. But not as boring as watching \r\n paint dry. And more text. And more text. And more text. And more text. \r\n Boring.  More, a little more text. The end, and just as well. \r\n","otherData":"\r\n"}

2. Validate application with Unit Test cases PDFTextExtractResourcesTest
