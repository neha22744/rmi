package com.rmsutil.util;

import java.io.IOException;







import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
private static Logger logger=LogManager.getLogger(JsonUtil.class);
public static <T> T convertJsonToJava(String str,Class<T> cls){
	T response=null;
	ObjectMapper objectMapper=new ObjectMapper();
	try {
		response=objectMapper.readValue(str,cls);
	} catch (Exception e) {
		e.printStackTrace();
	logger.error("Exception Occured while converting the Json into java object :: "+e.getMessage());
	}
	return response;
}
public static <T> T convertJsonToList(String str,Class<?> cls){
	T response=null;
	ObjectMapper objectMapper=new ObjectMapper();
	try {
response = 
objectMapper.readValue(str, objectMapper.getTypeFactory().constructCollectionType(List.class, Class.forName(cls.getName())));
	} catch (Exception e) {
		e.printStackTrace();
	logger.error("Exception Occured while converting the Json into java object :: "+e.getMessage());
	}
	return response;
}
public static <T> T convertJsonToSet(String str,Class<?> cls){
	T response=null;
	ObjectMapper objectMapper=new ObjectMapper();
	try {
response = 
objectMapper.readValue(str, objectMapper.getTypeFactory().constructCollectionType(Set.class, Class.forName(cls.getName())));
	} catch (Exception e) {
		e.printStackTrace();
	logger.error("Exception Occured while converting the Json into java object :: "+e.getMessage());
	}
	return response;
}


public static  String convertJavaToJson(Object obj){
	String jsonStr="";
ObjectMapper objectMapper=new ObjectMapper();
	try {
		jsonStr=objectMapper.writeValueAsString(obj);
	} catch (JsonProcessingException e) {
		logger.error("Exception Occured while converting the Java obj into Json  :: "+e.getMessage());

	}
	return jsonStr;
}
}
