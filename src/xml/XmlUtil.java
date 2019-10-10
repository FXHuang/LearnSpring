package xml;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {
	public Document loadbean(String xmlPath) throws Exception {
		// System.out.println(xmlPath);
		InputStream resourceAsStream = MySingleIOC.class.getClassLoader().getResourceAsStream(xmlPath);
		if (resourceAsStream == null) {
			throw new FileNotFoundException("该xml文件无法找到：" + xmlPath);
		}
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
		Document parse = documentBuilder.parse(resourceAsStream);
		// resourceAsStream.close();
		return parse;
	}

	public ArrayList<String> parseXml(Document parse) {
		ArrayList<String> list = new ArrayList<String>();
		NodeList beanList = parse.getElementsByTagName("bean");
		for (int i = 0; i < beanList.getLength(); i++) {
			Node node = beanList.item(i);
			if (node instanceof Element) {
				Element el = (Element) node;
				String beanId = el.getAttribute("id");
				String beanClass = el.getAttribute("class");
				list.add(beanId);
				list.add(beanClass);
			}
		}
		return list;
	}
}
