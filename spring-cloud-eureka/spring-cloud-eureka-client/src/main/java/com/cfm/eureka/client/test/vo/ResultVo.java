package com.cfm.eureka.client.test.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
* @Title:  ResultVo.java   
* @Package： com.cfm.eureka.client.test.vo   
* @Description: TODO(返回结果类)   
*
* @version: v1.0.0
* @author: Chen WeiYu
* @date: 2019年12月5日 下午5:27:10
 */
public class ResultVo extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
 
	private static int ERROR_CODE = 500;
	private static int SUCCESS_CODE = 200;
	
	public ResultVo() {
		put("code", 0);
	}
	
	public static ResultVo error() {
		return error(ERROR_CODE, "未知异常，请联系管理员");
	}
	
	public static ResultVo error(String msg) {
		return error(ERROR_CODE, msg);
	}
	
	public static ResultVo error(int code, String msg) {
		ResultVo r = new ResultVo();
		r.put("code", code);
		r.put("success", false);
		r.put("msg", msg);
		return r;
	}

	public static ResultVo success() {
		ResultVo r = new ResultVo();
		r.put("msg", "获取成功");
		r.put("code", SUCCESS_CODE);
		r.put("success", true);
		return r;
	}
	public static ResultVo success(String msg) {
		ResultVo r = new ResultVo();
		r.put("msg", msg);
		r.put("code", SUCCESS_CODE);
		r.put("success", true);
		return r;
	}
	public static ResultVo success(Object data) {
		ResultVo r = new ResultVo();
		r.put("code", SUCCESS_CODE);
		r.put("success", true);
		r.put("data", data);
		return r;
	}
	
	public static ResultVo ok(Object data) {
		ResultVo r = new ResultVo();
		r.put("data", data);
		return r;
	}
	
	public static ResultVo ok() {
		return new ResultVo();
	}
	
	public ResultVo put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	
	public static ResultVo build(int code,String msg,Object data) {
		ResultVo r = new ResultVo();
		r.put("code", code);
		r.put("msg", msg);
		r.put("success", true);
		r.put("data", msg);
		return r;
	}
	
	/**
     * 将json结果集转化为ResultVo对象
* @param jsonData json数据
* @param clazz ResultVo中的object类型
* @return
* @history 方法创建;Mender:cwy; Date:2019年12月5日；
*/
public static ResultVo formatToPojo(String jsonData, Class<?> clazz) {
   try {
       if (clazz == null) {
           return MAPPER.readValue(jsonData, ResultVo.class);
       }
       JsonNode jsonNode = MAPPER.readTree(jsonData);
       JsonNode data = jsonNode.get("data");
       Object obj = null;
       if (clazz != null) {
           if (data.isObject()) {
               obj = MAPPER.readValue(data.traverse(), clazz);
           } else if (data.isTextual()) {
               obj = MAPPER.readValue(data.asText(), clazz);
           }
       }
       return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
   } catch (Exception e) {
       return null;
   }
}


/**
* Object是集合转化
* 
* @param jsonData json数据
* @param clazz 集合中的类型
* @return
*/
public static ResultVo formatToList(String jsonData, Class<?> clazz) {
   try {
       JsonNode jsonNode = MAPPER.readTree(jsonData);
       JsonNode data = jsonNode.get("data");
       Object obj = null;
       if (data.isArray() && data.size() > 0) {
           obj = MAPPER.readValue(data.traverse(),
                   MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
       }
       return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
   } catch (Exception e) {
       return null;
   }
}
}
