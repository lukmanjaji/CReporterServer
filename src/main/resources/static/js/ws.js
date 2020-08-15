/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const socket = new WebSocket("ws://localhost:9494/socket");
var http = getHTTPObject();

function getHTTPObject()
{ 
    var xmlhttp;
    if (!xmlhttp && typeof XMLHttpRequest != 'undefined')
    {
        try
        {
           xmlhttp = new XMLHttpRequest();
        }
        catch(e) 
        {
           xmlhttp = false;
        }
    }
    return xmlhttp;
}


function ImageViewer(sr)
{
    alertify.alert("<img style='width:100%;' src='"+sr+"'/>");
}


function testCase(id)
{
       
}

function openCase(caseID)
{
    
    
    alertify.defaults.glossary.title = 'Case Manager ('+caseID+')';
    alertify.alert().setting('pinnable', true);
    var req = new XMLHttpRequest();
    var pre = document.createElement('pre');
    
//custom style.

newElement = document.createElement('div');
newElement.innerHTML = '<img align="center" border="0" src="img/loader.gif">';

  alertify.alert(newElement.innerHTML).setting('modal', true);
req.open("GET", '/gridframe?t='+caseID, true);
req.onreadystatechange = req.onreadystatechange = function() {
	if( req.readyState == 4 ) {
		if( req.status == 200 || req.status == 304) {
                        newElement.innerHTML = req.responseText;
                        pre.appendChild(newElement);
                        
                        if(!alertify.myAlert){
  //define a new dialog
  alertify.dialog('myAlert',function factory(){
    return{
      main:function(message){
        this.message = message;
      },
      setup:function(){
          return { 
            buttons:[{text: "Done", key:27/*Esc*/}],
            focus: { element:0 }
          };
      },
      prepare:function(){
        this.setContent(this.message);
      },
      onclose:function(){
          var x = document.getElementById("vplay");
          x.pause();
      }
  }}, true);
}
                        
                        
                        alertify.closeAll();
                        alertify.myAlert(newElement.innerHTML).setting({'movable': false,onshow:null, onclose:function(){
                           var x = document.getElementById("vplay");
          x.pause();
                            }}).maximize().set('resizable',true).resizeTo('100%',250);
                        
		} else {
			alert('The server encountered an error processing your request');
		}
	} else {
	}
}
req.send(null);
 }



function handleHttpResponse(toUpdate)
{
    if (http.readyState == 4)
    {
        toUpdate.innerHTML = http.responseText;
    }
}

function startWS()
{
    socket.onopen = function (event) {
    console.log("i connected to websocket");
    };
}


    
    function switchView(viewName)
    {
         
        
        document.getElementById("contentArea").innerHTML = '';
        document.getElementById("mapArea").innerHTML = '';
        var toSwitch;
        if(viewName == "map")
        {
            toSwitch = "map";
        }
        if(viewName == "mapframe")
        {
            toSwitch = "mapframe";
        }
        
        if(viewName == "summary")
        {
            toSwitch = "summary";
        }
        if(viewName == "gridframe")
        {
            toSwitch = "grid";
        }

        
        document.getElementById("contentArea").innerHTML = '<p align="center"><img border="0" src="img/loader.gif"></p>';
        http.open("GET", '/'+toSwitch, true);
        http.onreadystatechange = http.onreadystatechange = function()
        {
            if( http.readyState == 4)
            {
		if( http.status == 200 || http.status == 304)
                {
                    if(viewName != "mapframe")
                    {
                        document.getElementById("mapArea").hidden = true;
                        document.getElementById("contentArea").hidden = false;
                       document.getElementById("contentArea").innerHTML = http.responseText; 
                    }
                    else
                    {
                        document.getElementById("mapArea").hidden = false;
                        document.getElementById("contentArea").hidden = true;
                        document.getElementById("mapArea").innerHTML = http.responseText; 
                    }
                    
                    layTable();
		}
                else
                {
                    
		}
            }
            else 
            {
            }
        };
        http.send(null);
    }
    
    function layTable()
    {
        $('#example').DataTable();
    }
    
    
    socket.onmessage = function (event) {
            
            var m = event.data;
            //alert(m);
            var res = m.split(/##/g).filter(function(value){
                return value !== "";
            });
            var msgType = res[0];
            var msg = res[1];
            if(msg.startsWith("welcome"))
            {
                socket.send("countAll##");
            }
            if(m.startsWith('countAll'))
            {
                document.getElementById("count").innerHTML = msg + " cases reported";
            }
    };
    
    function countAll()
    {
        socket.send("countAll##");
    }
    
    
    
    