
<%-- 
    Document   : contact
    Created on : 27-Mar-2015, 9:26:07 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="javax.naming.Context"%>
<%@page import="session.OperationsRemote"%>
<%@page import="javax.naming.InitialContext"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Paradise Hotel</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="stylesheet/style.css" rel="stylesheet" type="text/css" />
<link href="stylesheet/layout.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="scripts/maxheight.js" type="text/javascript"></script>
   <style>
       p,dt,dd,h3, h4{
            color:#bca695;
        }
    </style>
</head>
     <%
      
        Context ctx = new InitialContext();   
        OperationsRemote contactSession = (OperationsRemote) ctx.lookup(OperationsRemote.class.getName());  
         ServletContext sc = getServletConfig().getServletContext();
        
      //  String submit = request.getParameter("send");
        
        
        %>
 
<body id="page5" onload="new ElementMaxHeight();">
    
       
   
 
    <div id="main">
  <%@include file="header.jsp" %>

<div id="content">
    <div class="wrapper">
      <div class="aside maxheight">
   <h3>Our Location</h3>
            <div class="gallery-images">
                 <img class="img-indent png" alt="" src="images/map.png" style="height:350px"/><br/>
               <br/> <p>Please feel free to come visit us at this address:</p>
            <dl class="contacts-list"> 
              <dt>Gazek st., 210</dt>
              <dd>1-800-412-4556</dd>
              <dd>1-800-542-6448</dd>
            </dl>
            </div>
      </div>
    

        <div class="content" style="margin-left: 80px;width:500px;">
        <div class="indent"><br/>
            <form>
                  <%
          if(request.getParameter("send")!=null){
              String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
         if(name!=null || email !=null || message !=null || phone!=null){
             contactSession.contact(name, email,phone, message);    
              out.println("<h4><p style='color:green'>Message Sent Successfully</p></h4>"); 
        }
         else{
             out.println("<h4><p style='color:red'>Please enter required fields</p></h4>");
         }
          }
       
         %>
          <h4>Name*</h4>
          <input type="text" name="name" placeholder="John" class="form-control"/>
          <h4>Email*</h4>
          <input type="email" name="email" placeholder="Johnsmith@gmail.com" class="form-control"/>
          
          <h4>Phone(Optional)</h4>
          <input type="text" name="phone" placeholder="4445556666" class="form-control"/>
          <h4>Message*</h4>
          <textarea name="message" placeholder="Enquiry" rows="3" class="form-control"></textarea><br/>
         
        <input type="submit" name="send" value="Send Message" class="btn btn-danger"/>
            </form>
          </div>
          
        </div>
      </div>
</div>
      <div class="clear"></div>
    </div>

</body></html>