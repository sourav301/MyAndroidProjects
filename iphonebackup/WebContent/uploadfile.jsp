<% 
String getname = null;
try{
	getname = (String)session.getAttribute("username") ;
}catch(Exception e){
	e.printStackTrace();
}
if (getname != null) {
	//out.println("Session Exists");
}else{
	response.sendRedirect("index.html");
}
%>

<script type="text/javascript" charset="utf-8" src="cordovaios.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8">
	var str;
    var strtable;
    var count = 0;
    var names = [];
    var phno = [];
    function uploadcontacts(){
    	document.getElementById("upload").disabled=true;
        document.getElementById("download").disabled=true;
       
    	//Reading Contacts
    	var contactList = new ContactFindOptions(); 
        contactList.filter=""; 
        contactList.multiple=true;
        filter = ["*"];  //"*" will return all contact fields
        navigator.contacts.find(filter,  onSuccess, onError, contactList );
    	
    }
    function onSuccess(contacts) {
    	 for (var i=0; i<contacts.length; i++){
        	 try{
        		 if (contacts[i].name.formatted!="undefined"||contacts[i].name.formatted!="null"||contacts[i].name.formatted!=null){
          	 	names[i]=contacts[i].name.formatted;
          	 if (contacts[i].phoneNumbers[0].value!=null){
         		phno[i]=contacts[i].phoneNumbers[0].value;
         	}
          
        	}	
         	 }catch(err){}
         } 
         for(var n = 0 ; n < phno.length ; n++)
         {
        	 try{
         
        		 phno[n]= phno[n].replace(/[^0-9]/g,' ');
        		}catch(err){}
         }
        //Construct XML
        
        str = "<contactlist>";
        strtable="<table>";
        //strtable+="<tr><th>"+"No"+"</th><th>"+"Name"+"</th><th>"+"Number"+"</th></tr>";
        for (var i=0; i<names.length; i++)
         {
        	 
        	if(names[i]==null){}else{
        		if(phno[i]==null){}else{
        	//strtable+="<tr><td>"+i+"</td><td>"+names[i]+"</td><td>"+phno[i]+"</td></tr>";
        	str += " <contact id=\""+i+"\">";
        	str +=  "<name>"+names[i]+"</name>";
        	str += "<number>"+phno[i]+"</number>";
        	str += "</contact>";
        	
        		}
         }
        	strtable+="</table>";
        }
        str += "</contactlist>";
  		//Posting Data
  		postData();
    }
    function onError(contactError) {
        alert('onError!');
	} 
    function postData(){
    	//alert("Posting Data - "+str);
    	$.ajax({
        	
            type : 'POST',          
            url : 'http://mindworkers.in/iphonebackup/controller', // Servlet URL          
            data:{
                contacts:str,
                requestpage:"uploadcontacts",
                },
                success : function(data) {
                	if(data==1){
                	alert("Contacts Backup Complete!!");
                	}
                	else{
                		alert("No new Contacts.");
                	}
                num.innerHTML="Backup Complete. You may Logout.";
                },
                error: function (xhr, ajaxOptions, thrownError) 
                { 
                	console.log("Post Error");
                alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " +      thrownError);
                }   
    	});
    	document.getElementById("upload").disabled=false;
        document.getElementById("download").disabled=false;
        num.innerHTML("Upload Complete");
         
	}
</script>

<script>
function downloadcontacts(){
	names=[];
	phno=[];
	//alert("Name Array"+names);
	document.getElementById("upload").disabled=true;
    document.getElementById("download").disabled=true;
   // document.getElementById("logout").disabled=true;
    var contactList = new ContactFindOptions(); 
        contactList.filter=""; 
        contactList.multiple=true;
        filter = ["*"];  //"*" will return all contact fields
        navigator.contacts.find(filter,  onSuccessDownload, onError, contactList );
	   
	       	   	
} 
function onSuccessDownload(contacts){
	//alert("OnSuccess");
	// num.innerHTML = "Receiving Contacts Please Wait...";
	
	 for (var i=0; i<contacts.length; i++){
    	 try{
    		 if (contacts[i].name.formatted!="undefined"||contacts[i].name.formatted!="null"||contacts[i].name.formatted!=null){
      	 	names[i]=contacts[i].name.formatted;
      	 if (contacts[i].phoneNumbers[0].value!=null){
     		phno[i]=contacts[i].phoneNumbers[0].value;
     	}
      
    	}	
     	 }catch(err){}
     } 
     for(var n = 0 ; n < phno.length ; n++)
     {
    	 try{
     
    		 phno[n]= phno[n].replace(/[^0-9]/g,' ');
    		}catch(err){}
     }  
    // alert("Sending Post");
	 $.ajax({
	            type : 'POST',          
	            url : 'http://mindworkers.in/iphonebackup/controller', // Servlet URL          
     	        data:{
	           
	                     requestpage:"downloadcontacts",
	            
	                 },

	       	success : function(data) {
	      
	       	var contact=data.split("&&&&");
	       	var conname=contact[0].split("||||");
	       	var connumber=contact[1].split("||||");
	       	var len = conname.length-1;
	       
	       	for(var n = 0 ; n < len ; n++){
      	         try{
      		           connumber[n]= connumber[n].replace(/[^0-9]/g,' ');
      	             }catch(err)
      	                       {
      		                      alert(err);
                          	   }
      	      }
	       	for(var i = 0 ; i < len ; i++ ){
	       	 //Checking For Existing Data
	       	// alert("#"+connumber[i]+"#");
	       	       var flag = 0;
	       	      
	       	      try{
	       		   for(var j=0 ; j<names.length ; j++){
	       			
	       	//		alert("Comparing "+" "+conname[i]+" "+names[j]+" "+connumber[i]+" "+phno[j])
	       		    if(conname[i]==names[j]&&connumber[i]==phno[j]){
	       		    	{ 
	       		    		flag=1;
	       		    		break;
	       		    	}
	       			// alert("Contact Exists");
	       		 }
	       	 }
	       	 }catch(err){
	       		 alert(err);
	       	 }
	       	 if(flag==0)
	       	 {
	       		 if(conname[i]==""||connumber[i]==""){
	    //   			 alert("Empty Contact");
	       		 }else{ 
	    //   		 	alert("New Contact");
	       	 var contact = navigator.contacts.create();
	       	 contact.displayName = conname[i];
	       	 //contact.nickname = conname[i]; //specify both to support all devices
	       	 var name = new ContactName();
	       	 name.givenName = conname[i];
	       	 
	       	 //contact.name = name;
	       	 var phoneNumbers = []; 
	       	     phoneNumbers[0] = new ContactField('mobile', connumber[i], false);
	       	     
	       	 contact.phoneNumbers = phoneNumbers;

	       	  
	       	 // save
	       	 contact.save(onSaveSuccess,onSaveError);
	       	 //document.getElementById("logout").disabled=false;
	       		 }
	       	 }

	       	}
	       if((conname.length-1)==names.length)
	       		{
	       		alert("No New Cotact Found in Database!!!");
	       	 	num.innerHTML = "You May Logout";

	       		}
	       	else{
	       	num.innerHTML = "Receiving Contacts Please Wait...";
	       	alert("Restore Complete!!!");
	       	num.innerHTML = "Restore Complete. You May Logout";
	       	}
	       	document.getElementById("upload").disabled=false;
	       	document.getElementById("download").disabled=false;
	       	   
	       	function onSaveSuccess(contact) {
	       		//alert("Save Success");
	       		}
	       		 
	       		// onSaveError: Failed to get the contacts
	       		//
	       		function onSaveError(contactError) {
	       		//alert("Error = " + contactError.code);
	       		}
	       	},
	       	   	error: function (xhr, ajaxOptions, thrownError) 
	       	   	{ 
	       	   	alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " +      thrownError);
	       	   	}
	       	   	    }); 
}
	        
</script>





</head>
<body>
<h3>Contacts Backup/Restore:</h3>
<h3>Welcome:<%= (String)session.getAttribute("username") %></h3>
 <br />

<input type="button" id="upload" value="Backup Contacts" onclick="uploadcontacts()" />
<input type="button" id="download" value="Restore Contacts" onclick="downloadcontacts()" />

<form action="controller" method="get">
 <input type="hidden" name="requestpage" value="logout">
  <input id ="logout" type="submit" value="Log Out" >
</form>
<div id="num">Backup or Restore</div>
</body>
</html>