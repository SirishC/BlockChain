<%-- 
    Document   : index
    Created on : 17 Sep, 2018, 8:38:20 PM
    Author     : sirish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Vote Call </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">                                      
    </head>
    <body>
        <p>It is a Block Chain voting application .. (just for fun) </p>
        <div>
            <form action="/VoteCall/Question">
                
              Take polling As you like!<br>
              <textarea name="que" placeholder="Question"></textarea><br>
                Option 1<input name="opt1" type="text" placeholder="option 1"><br>
                Option 2<input name="opt2" type="text" placeholder="option 2"><br>
                Option 3<input name="opt3" type="text" placeholder="option 3"><br>
                Option 4<input name="opt4" type="text" placeholder="option 4"><br>
                <button>Create Vote Call</button>               
            </form>
        </div>
    </body>
</html>

