package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

public class MySingleIOC {
    private MySingleIOCData data = new MySingleIOCData(new HashMap<>());
	public MySingleIOC(){}
    public MySingleIOC(String xmlPath) throws Exception{
    	loadbean(xmlPath);
    	//parse = loadbean(xmlPath);
        //list = parseXml(parse);
    }

    private void loadbean(String xmlPath) throws Exception{
    	//System.out.println(xmlPath);
        InputStream resourceAsStream = MySingleIOC.class.getClassLoader().getResourceAsStream(xmlPath);
        if (resourceAsStream == null){
            throw new FileNotFoundException("该xml文件无法找到：" + xmlPath);
        }
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document parse = documentBuilder.parse(resourceAsStream);
        resourceAsStream.close();
        NodeList beanList = parse.getElementsByTagName("bean");
        for (int i = 0;i < beanList.getLength();i++){
            Node node = beanList.item(i);
            if (node instanceof Element){
                Element el = (Element) node;
                String beanId = el.getAttribute("id");
                String beanClass = el.getAttribute("class");
                Class beanclazz = null;
                try{
                    beanclazz = Class.forName(beanClass);
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                Object beanObj = beanclazz.newInstance();
                NodeList propertyList = el.getElementsByTagName("property");
                for (int j = 0;j < propertyList.getLength();j++){
                    Node item = propertyList.item(j);
                    if (item instanceof Element){
                        Element ele = (Element) item;
                        String name = ele.getAttribute("name");
                        String value = ele.getAttribute("value");

                        Field declaredField = beanObj.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);
                        String fieldTypeName = declaredField.getType().getName();
                        Object o = paramType(fieldTypeName,value);
                        declaredField.set(beanObj,o);
                        data.beanMap.put(beanId,beanObj);
                    }
                }
            }
        }
    }
    public Object paramType(String fieldName, String value){
        Object obj = null;
        if ("int".equals(fieldName)||"java.lang.Integer".equals(fieldName)){
            int intFieldValue = Integer.parseInt(value);
            obj = intFieldValue;
        }
        if ("java.lang.String".equals(fieldName)){
            obj = value;
        }
        if ("ref".equals(fieldName)) {
        	
        }
        return obj;
    }
    public Object getBean(String beanName){
        Object bean = data.beanMap.get(beanName);
        if(bean == null){
            throw new IllegalArgumentException("无法实例化该名称的bean，请确定名称是否正确" + beanName);
        }
        return bean;
    }
}
