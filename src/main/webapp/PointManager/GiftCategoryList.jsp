<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
{"gift":[
<c:forEach var="v" items="${gifts}" varStatus="statu">  
	{"id":"${v.giftclassid}","name":"${v.giftclassname}"}
    <c:if test="${!statu.last}">,</c:if>
</c:forEach>  
]}
