/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-08-30 04:14:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Controls;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class QuickSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    $(document).ready(function () {\r\n");
      out.write("        $(\"#sltShop\").attr(\"style\", \"display:none\").after($(\"#SearchShop\"));\r\n");
      out.write("        $(\"#btnShop\").bind(\"click\", CreateQuickSearchList);\r\n");
      out.write("        $(\"#btnSearch\").bind(\"click\", GetShop);\r\n");
      out.write("        $(\"#btnSearchAll\").bind(\"click\", function () {\r\n");
      out.write("            $(\"#txtShop\").val(\"\");\r\n");
      out.write("            $(\"#sltShop\").get(0).selectedIndex = 0;\r\n");
      out.write("            quickSearch.close();\r\n");
      out.write("        });\r\n");
      out.write(" \r\n");
      out.write("        if ($(\"#sltShop\").find(\"option:selected\").val() == \"\") {\r\n");
      out.write("            $(\"#txtShop\").val(\"\");\r\n");
      out.write("            $(\"#txtQueryShop\").val(\"\");\r\n");
      out.write("        }\r\n");
      out.write("        else {\r\n");
      out.write("            $(\"#txtShop\").val($(\"#sltShop\").find(\"option:selected\").text());\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("    //创建表格\r\n");
      out.write("    function CreateQuickSearchList() {\r\n");
      out.write("       \r\n");
      out.write("        \r\n");
      out.write("        $(\"#txtQueryMem\").focus();\r\n");
      out.write("        quickSearch = art.dialog({\r\n");
      out.write("            title: '快速查找',\r\n");
      out.write("            content: document.getElementById('divQuickSearch'),\r\n");
      out.write("            id: 'divQuickSearch',\r\n");
      out.write("            lock: true,\r\n");
      out.write("            close: function () {\r\n");
      out.write("                $set = $(\"#sltShop\").find(\"option:selected\");\r\n");
      out.write("                if ($set.attr(\"index\") > 0) {\r\n");
      out.write("                    $(\"#txtShop\").val($set.text());\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        GetShop();\r\n");
      out.write("    }\r\n");
      out.write("    function GetShop() {\r\n");
      out.write("        var html = \"\";\r\n");
      out.write("        \r\n");
      out.write("        var SearchShopName = $(\"#txtQueryShop\").val();\r\n");
      out.write("        $('#sltShop option').each(function (index, item) {\r\n");
      out.write("            var $option = $(this);\r\n");
      out.write("            //  if (index > 0) {\r\n");
      out.write("            if ($option.html().indexOf(\"请选择\") < 0) {\r\n");
      out.write("                if (SearchShopName != \"\") {\r\n");
      out.write("                    if ($option.html().indexOf(SearchShopName) >= 0) {\r\n");
      out.write("                        html += \"<tr class=\\\"td\\\" ondblclick=\\\"javascript:QuickSelectShop(\\'\" + $option.html() + \"\\','\" + index + \"',\"+item.value+\");\\\">\" + '<td style=\" width:120px;text-align: left\">' + $option.html() + '</td>' + '</tr>';\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    if ($option.html() != \"全部\") {\r\n");
      out.write("                        html += \"<tr class=\\\"td\\\" ondblclick=\\\"javascript:QuickSelectShop(\\'\" + $option.html() + \"\\','\" + index + \"',\"+item.value+\");\\\">\" + '<td style=\" width:120px;text-align: left\">' + $option.html() + '</td>' + '</tr>';\r\n");
      out.write("+'<td style=\" width:120px;text-align: left\">' + $option.val() + '</td>'\r\n");
      out.write("                 + '</tr>';\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        $(\"#tbQuickSearch\").html(html);\r\n");
      out.write("    }\r\n");
      out.write("    function QuickSelectShop(ShopName, selectIndex,shopID) {\r\n");
      out.write("        $(\"#txtShop\").val(ShopName);\r\n");
      out.write("        $(\"#HDsltshop\").val(ShopName);\r\n");
      out.write("        $(\"#HDsshopid\").val(shopID);\r\n");
      out.write("        $(\"#sltShop\").get(0).selectedIndex = selectIndex;\r\n");
      out.write("        quickSearch.close();\r\n");
      out.write("        $(\"#txtQueryShop\").val(\"\");\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("<span id=\"SearchShop\">\r\n");
      out.write("    <input id=\"txtShop\" type=\"text\" class=\"border_radius\" readonly=\"readonly\" />\r\n");
      out.write("    <input id=\"btnShop\" type=\"button\" value=\"选择\" class=\"common_Button\" /></span>\r\n");
      out.write("<div id=\"divQuickSearch\" style=\"display: none\">\r\n");
      out.write("    <table class=\"table-style table-hover user_List_txt\">\r\n");
      out.write("        <thead class=\"thead\">\r\n");
      out.write("            <tr class=\"th\">\r\n");
      out.write("                <th>\r\n");
      out.write("                    店铺名称\r\n");
      out.write("                </th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div style=\"height: 260px; width: 600px; overflow: auto;\">\r\n");
      out.write("        <table class=\"table-style table-hover user_List_txt\" id=\"tbQuickSearch\">\r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div style=\"height: 30px; line-height: 30px; text-align: center;\">\r\n");
      out.write("        <input type=\"text\" id=\"txtQueryShop\" class=\"border_radius\" style=\"clear: both; float: none\" />\r\n");
      out.write("        <input type=\"button\" id=\"btnSearch\" class=\"common_Button common_ServiceButton\" value=\"查找\" />\r\n");
      out.write("        <input type=\"button\" id=\"btnSearchAll\" class=\"common_Button common_ServiceButton\"\r\n");
      out.write("            value=\"全部\" />\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
