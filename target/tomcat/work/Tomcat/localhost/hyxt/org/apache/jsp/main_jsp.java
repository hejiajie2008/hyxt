/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-09-10 02:38:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html class=\"ks-trident7 ks-trident ks-ie11 ks-ie\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>连锁会员管理系统 专业版 </title>\r\n");
      out.write("    <link href=\"Inc/Style/Style.css\" rel=\"stylesheet\" />    \r\n");
      out.write("    <link href=\"Inc/artDialogskins/blue.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <script src=\"Scripts/jquery-1.10.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"Scripts/jquery.artDialog.basic.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"Scripts/artDialog.iframeTools.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("        //iframe高度自适应\r\n");
      out.write("        function IFrameReSize(iframename) {\r\n");
      out.write("            var pTar = document.getElementById(iframename);\r\n");
      out.write("            if (pTar) {  //ff\r\n");
      out.write("                if (pTar.contentDocument && pTar.contentDocument.body.offsetHeight) {\r\n");
      out.write("                    pTar.height = pTar.contentDocument.body.offsetHeight;\r\n");
      out.write("                } //ie\r\n");
      out.write("                else if (pTar.Document && pTar.Document.body.scrollHeight) {\r\n");
      out.write("                    pTar.height = pTar.Document.body.scrollHeight;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        //iframe宽度自适应\r\n");
      out.write("        function IFrameReSizeWidth(iframename) {\r\n");
      out.write("            var pTar = document.getElementById(iframename);\r\n");
      out.write("            if (pTar) {  //ff\r\n");
      out.write("                if (pTar.contentDocument && pTar.contentDocument.body.offsetWidth) {\r\n");
      out.write("                    pTar.width = pTar.contentDocument.body.offsetWidth;\r\n");
      out.write("                }  //ie\r\n");
      out.write("                else if (pTar.Document && pTar.Document.body.scrollWidth) {\r\n");
      out.write("                    pTar.width = pTar.Document.body.scrollWidth;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        var text = document.title\r\n");
      out.write("        var timerID\r\n");
      out.write("\r\n");
      out.write("//        newtext();\r\n");
      out.write("\r\n");
      out.write("//        function newtext() {\r\n");
      out.write("//            clearTimeout(timerID)\r\n");
      out.write("//            document.title = text.substring(1, text.length) + text.substring(0, 1)\r\n");
      out.write("//            text = document.title.substring(0, text.length)\r\n");
      out.write("//            timerID = setTimeout(\"newtext()\", 1000)\r\n");
      out.write("//        }\r\n");
      out.write("        //onload = \"setHeight();\"\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<frameset rows=\"102,*,30\" border=\"0\">\r\n");
      out.write("    <frame src=\"top.jsp\" noresize=\"noresize\" frameborder=\"0\" name=\"top\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" />\r\n");
      out.write("    <frameset cols=\"160,*\" border=\"0\" id=\"MainFrameset\">\r\n");
      out.write("       <frame src=\"leftMenu.jsp\" id=\"menu\" name=\"menu\" marginwidth=\"0\" marginheight=\"0\" frameborder=\"0\" scrolling=\"no\" noresize=\"noresize\" />\r\n");
      out.write("       <frame src=\"startPage.do\" name=\"mainFrame\" id=\"mainFrame\" frameborder=\"0\" scrolling=\"auto\" noresize=\"noresize\" onload=\"Javascript:IFrameReSize(this)\" />\r\n");
      out.write("    </frameset>\r\n");
      out.write("    <frame src=\"foot.jsp\" noresize=\"noresize\" frameborder=\"0\" name=\"foot\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\" />\r\n");
      out.write("  \r\n");
      out.write("    <noframes>\r\n");
      out.write("      <body> 本系统需要IE8+、Firefox3.0+、Opera9+或者Chrome浏览器支持。\r\n");
      out.write("      </body>\r\n");
      out.write("    </noframes>\r\n");
      out.write("  </frameset>\r\n");
      out.write("</html>\r\n");
      out.write("    ");
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