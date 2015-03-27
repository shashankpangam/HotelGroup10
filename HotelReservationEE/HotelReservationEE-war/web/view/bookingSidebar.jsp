<%-- 
    Document   : bookingSidebar
    Created on : 27-Mar-2015, 12:15:37 AM
    Author     : meenakshimehta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <div class="box maxheight">
          <div class="inner">
            <h3>Reservation:</h3>
            <form action="#" id="reservation-form">
              <fieldset>
              <div class="field">
                <label>Check In:</label>
                <select class="select1">
                  <option>30</option>
                </select>
                <select class="select2">
                  <option>April 2009</option>
                </select>
              </div><br/>
              <div class="field">
                <label>Check Out:</label>
                <select class="select1">
                  <option>01</option>
                </select>
                <select class="select2">
                  <option>May 2009</option>
                </select>
              </div><br/>
              <div class="field"> Persons: &nbsp;
                <input type="text" value="1"/>
&nbsp; &nbsp; &nbsp; &nbsp; 
<br/>Rooms:&nbsp;
                <input type="text" value="1"/>
              </div>
              <div class="button"><span><span><a href="#">Check Availability</a></span></span></div>
              </fieldset>
            </form>
          </div>
        </div>
