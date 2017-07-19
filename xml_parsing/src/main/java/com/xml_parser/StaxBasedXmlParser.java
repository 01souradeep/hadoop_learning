package com.xml_parser;

import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StaxBasedXmlParser {


	public void doParse(InputStream inputStream) throws XMLStreamException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);

		while (xmlStreamReader.hasNext()) {
			int eventType = xmlStreamReader.next();
			if (eventType == XMLStreamConstants.START_ELEMENT) {
				String element = xmlStreamReader.getLocalName();

				System.out.println("START_ELEMENT: " + element);

			} else if (eventType == XMLStreamConstants.END_ELEMENT) {

				String element = xmlStreamReader.getLocalName();
				System.out.println("END_ELEMENT: " + element);

			} else if (eventType == XMLStreamConstants.CHARACTERS) {
				String chars = xmlStreamReader.getText().trim();
				System.out.println("chars: " + chars);
			} else if (eventType == XMLStreamConstants.END_DOCUMENT) {
				System.out.println("End of doc");
			}
		}
	}
	 
	public static void main(String[] a) throws XMLStreamException {
		new StaxBasedXmlParser().doParse(StaxBasedXmlParser.class.getResourceAsStream("/test/xml/sample.xml"));
	}

}
