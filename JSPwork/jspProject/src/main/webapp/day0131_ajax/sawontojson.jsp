<%@page import="java.text.SimpleDateFormat"%>
<%@page import="sawon.data.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="sawon.data.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	SawonDao dao=new SawonDao();
    	String search=request.getParameter("search");
    	List<SawonDto> list = dao.getAllDatas(search);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
    
    [
    	<%
    	StringBuffer sb=new StringBuffer();
    		for(SawonDto dto:list){
    			sb.append("{");
    			sb.append("\"num\":\""+dto.getNum()+"\",");
    			sb.append("\"sname\":\""+dto.getSname()+"\",");
    			sb.append("\"sphoto\":\""+dto.getSphoto()+"\",");
    			sb.append("\"sbirth\":\""+dto.getSbirth()+"\",");
    			sb.append("\"sblood\":\""+dto.getSblood()+"\",");
    			sb.append("\"ipsaday\":\""+dto.getIpsaday()+"\",");
    			sb.append("\"writeday\":\""+sdf.format(dto.getWriteday())+"\"");
    			sb.append("},");
    		}
    		//마지막 콤마는 젝어 해야함 
    		sb.deleteCharAt(sb.length()-1);
    			
    	%>
    	<%=sb.toString() %>
    ]