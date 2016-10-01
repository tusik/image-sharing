package cx.by.img;

/**
 * Created by zinc on 2016/9/30.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig(location = "/usr/local/apache-tomcat-8.5.5/img/img/", maxFileSize = 1024 * 1024 * 10)

public class Upload extends HttpServlet{
    private static  String dir="/usr/local/apache-tomcat-8.5.5/img/img/";
    private static final long serialVersionUID = 1L;

    public Upload() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("filename");
        //获取文件名称
        String filename = getFilename(part);
        setDir();
        creatDir(dir);
        part.write(dir+filename);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("http://img.ab.com:8080/img/"+filename);
        out.print("<script>alert(\"上传文件成功\")</script>");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
    private void setDir(){
        Calendar now = Calendar.getInstance();
        this.dir=this.dir+"/"+now.get(Calendar.YEAR)+(now.get(Calendar.MONTH)+1)+now.get(Calendar.DAY_OF_MONTH)+"/";
    }
    public void creatDir(String dir){
        File file =new File(dir);//创建文件夹
        if  (!file .exists()  && !file .isDirectory())
        {
            file .mkdir();
        } else {}
    }
    private String getRandomString(){
        return "sa";
    }

    private String getFilename(Part part) {
        if (part == null) {
            return null;
        }
        String fileName = part.getHeader("content-disposition");
        if (isBlank(fileName)) {
            return null;
        }
        return substringBetween(fileName, "filename=\"", "\"");
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0)
            return true;
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null)
            return null;
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1)
                return str.substring(start + open.length(), end);
        }
        return null;
    }

    public void init() throws ServletException {

    }
}