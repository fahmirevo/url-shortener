<%@ page import="core.*" %>
<%
    
    
String url,custom,password;
url = request.getParameter("url");
custom = request.getParameter("custom");
password = request.getParameter("password");
    

DaoUrl daourl = new DaoUrl();
Url ourl;
    


    
    /*
ourl = new Url();
ourl.setReal("asw");
out.println(ourl.getShortened());
ourl = daourl.save(ourl);
out.println(ourl.getShortened());
ourl = daourl.findByReal(ourl);
out.println(ourl);
    */
    
    
 
if(!url.equals("") && !custom.equals("") && !password.equals("")){ // tidak ada yang kosong
    ourl = new Url(url,custom,password);
    ourl = daourl.save(ourl);
    out.println(ourl.getId());
}else if(!url.equals("") && !custom.equals("")){ // ada url dan costum, tapi tanpa password
    ourl = new Url(url,custom);
    ourl = daourl.save(ourl);
    out.println(ourl.getId());
}else if(!url.equals("") && !password.equals("")){ // ada url dan password, tapi tanpa custom
    ourl = new Url(url, "", password);
    ourl = daourl.save(ourl);
    out.println(ourl.getId());
}else if(!url.equals("")){ // ada url, tanpa custom dan password
    ourl = new Url(url);
    ourl = daourl.save(ourl);
    out.println(ourl.getId());
}
 
%>