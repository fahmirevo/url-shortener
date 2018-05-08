<%@ page import="core.*" %>

<%
    String id,url,password;
    id = request.getParameter("i");
    password = request.getParameter("password");
    
    DaoUrl daourl = new DaoUrl();
    Url ourl = new Url();
    ourl.setShortened(id);
    ourl.setPassword(password);
    ourl = daourl.findByShortened(ourl);
    
    String redirectUrl = ourl.getReal();
    
    if(ourl.getReal().equals("PASSWORD PROTECTED")){
        %>
<!Doctype html>
<html>
    <head>
        <title>Masukan Password</title>
    </head>
    <body>
        <form action="" method="get">
            <input type="hidden" name="i" value="<%out.print(id);%>">
            Password : <input type="password" name="password" placeholder="Password"> <br/>
            <input type="submit" name="submit" value="submit">
        </form>
    </body>
</html>
        <%
    }else{
        out.print(redirectUrl);
        response.sendRedirect(redirectUrl);
    }

%>
