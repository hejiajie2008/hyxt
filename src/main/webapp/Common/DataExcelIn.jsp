<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%@taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="ks-trident7 ks-trident ks-ie11 ks-ie">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="../Inc/Style/Style.css" rel="stylesheet" type="text/css" />
 
    <link href="../Inc/artDialogskins/blue.css" rel="stylesheet" type="text/css" />
    <script src="../Scripts/js/jquery.min.js" type="text/javascript"></script>
   
    <script src="../Scripts/js/ajaxfileupload.js" type="text/javascript"></script>
    <script src="../Scripts/jquery-common.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.artDialog.basic.js" type="text/javascript"></script>
    <script src="../Scripts/artDialog.iframeTools.js" type="text/javascript"></script>
    <script src="../Scripts/Module/Common/Common.js" type="text/javascript"></script>
   
</head>
<body>
    <form id="frmDataExcelIn" >
    <div class="system_Info box_right">
        <div class="system_Top">
            <div class="user_regist_title">
                <utils:title/>
            </div>
        </div>
        <div class="user_List_All">
            <div>
                <div class="user_regist_infor" style="width: 100%">
                    导入说明
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_right">
                            （1）先下载模板,严格按模板文件里面的说明进行EXCEL内容整理。
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （2）点击浏览,选择整理好的EXCEL文件。
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （3）点击"检验数据",验证要导入的数据是否正确。
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （4）点击"导入",导入成功后系统会提示上传成功。
                        </td>
                    </tr>
                </table>
                <div class="user_regist_infor" style="width: 100%">
                    会员导入
                </div>
                <table border="1" cellpadding="0" cellspacing="0" bordercolor="#434343" class="tableStyle">
                    <tr>
                        <td class="tableStyle_right">
                            （1）点击按钮下载会员模板：
                            <input type="Button" id="btnMemTemplate"  class="common_Button common_ServiceButton"
                                value="会员模板"  visible="false" />
                        </td>
                    </tr>
                    <tr>
                        <td class="tableStyle_right">
                            （2）点击按钮导入会员数据：
                            <input type="file" id="fileUploadMem" name="fileData" class="common_Button common_ServiceButton"  style="width:210px;"  />&nbsp;&nbsp;&nbsp;
                            <input type="button" id="btnMemCheck" value="检验数据" class="common_Button common_ServiceButton"
                                  />&nbsp;&nbsp;&nbsp;
                            <input type="button" id="btnMemImport" value="导入会员" class="common_Button common_ServiceButton"
                                OnClick="btnMemImport_Click"  />
                          
                            <input type="hidden"  class="common_ServiceButton" id="strPath" />
                        </td>
                    </tr>
                </table>
                <div style="padding-left: 10px; padding-right: 10px; padding-top: 20px;">
                    <span id="lblError" ></span>
                    <div style="width:1800px; height:100%; overflow:scroll;" >
							<table id="resultTable" class="table-style table-hover user_List_txt"
								cellspacing="0" cellpadding="4" 
								border="0" 
								style="color: #333333; border-style: Double; height: 100%; width: 100%; border-collapse: collapse;">
								
							</table>
						</div>
                    
                </div>
            </div>
        </div>
    </div>
    </form>
</body>
</html>
