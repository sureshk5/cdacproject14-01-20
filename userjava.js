
function validation()
{
	var fname=document.registration.fname;
	var lname=document.registration.lname;
	var gname=document.registration.gname;
    var address=document.registration.address;
	var number=document.registration.number;
    var email= document.registration.Email;
    var otp= document.registration.OTP;
	if(allLettername(fname))
	{
		if(allLetterlast(lname))
		{
			if(genderselect(gname))
			{
                if(AddressProof(address))
                {
                    if(Mobile(number))
					{
                        if(Email(inputtext, alertMsg))
                        {
                            if(OTP(otp))
                        {
							
							if(UserID(userid))
							{
								if(Password(password))
								{
									if(RetypePassword(retypepassword))
									{

									}
								}
							}
                        }
                        }
					}
			}
		}
}
	return false;
}
function allLettername(fname)
{ 
	var letters = /^[A-Za-z]+$/;
	if(fname.value.length==0)
	{
		alert('Please enter first name');
		fname.focus();
		return false;
	}

	else if(fname.value.match(letters))
	{
		return true;
		
	}
	else
	{
		alert('First name must have alphabet characters only');
		fname.focus();
		return false;
	}
}

function allLetterlast(lname)
{ 
	var letters = /^[A-Za-z]+$/;
	if(lname.value.length==0)
	{
		alert('Please enter last name');
		fname.focus();
		return false;
	}
	else if(lname.value.match(letters))
	{
		return true;
		
	}
	else
	{
		alert('last name must have alphabet characters only');
		fname.focus();
		return false;
		
	}
}

function genderselect(gname)
{
	if(gname.value == "Default")
	{
		alert('Select your gender');
		gname.focus();
		return false;
	}
	else
	{
		return true;
	}
}
 function AddressProof(address)
 {
 }

function Mobile(number)
{ 
	var numbers = /^[0-9]+$/;
	if(number.value.length==0 )
	{
		alert('Please enter contact number');
		fname.focus();
		return false;
	}
	else if(number.value.length>10)
	{
		alert('Please enter a valid contact number');
		fname.focus();
		return false;

	}
	else if(number.value.match(numbers))
	 {
	 	 alert('Form Succesfully Submitted');
	 	window.location.reload();
	 	return true;
	 }
	else
	{
		alert('Please check your contact number');
		return false;
	}

}
    function Email(inputtext, alertMsg){
	// var regx= /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-		9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	//   if (regx.test(email)) {
    //       document.getElementById("lbl").innerHTML = "Valid";
    //       document.getElementById("lbl").style.color = "green";
    //       document.getElementById("lbl").style.visibility = "visible";
    //     } else {
    //       document.getElementById("lbl").innerHTML = "Invalid";
    //       document.getElementById("lbl").style.color = "red";
    //       document.getElementById("lbl").style.visibility = "visible";
    //     }

    // function emailValidation(inputtext, alertMsg){
var email = /^[w-.+]+@[a-zA-Z0-9.-]+.[a-zA-z0-9]{2,4}$/;
if(inputtext.value.match(emailExp))
{
return true;
}else{
document.getElementById('p3').innerText = alertMsg;
inputtext.focus();
return false;
}
}
    function OTP(otp) {


        var regx = /[7-9]\d{9}/;     
      
          if (regx.test(cell)) {
            document.getElementById("lbltext").innerHTML="Valid";
            document.getElementById("lbltext").style.visibility="visible";
            document.getElementById("lbltext").style.color="green";
        } else {
            document.getElementById("lbltext").innerHTML="Invalid";
            document.getElementById("lbltext").style.visibility="visible";
            alert("Invalid OTP");
            
        }


	}
	function UserID(userid)
	{



	}
function Password(password)
{



}
function RetypePassword(retypepassword)
{

}



}
var Guide=function( firstName,  lastName,  contact_number,  addressProof,  gmail,
			 gender, userId, password)
			  {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact_number = contact_number;
		this.addressProof = addressProof;
		this.gmail = gmail;
		this.gender = gender;
		this.userId=userId;
		this.password=password;
	}
	var Guidelogin=function(userId,password)
	{
		this.userId=userId;
		this.password=password;
	}
var url="http://localhost:8080/neha";
function getValues()
{
var firstName=document.getElementById("form").elements[1].value;
var lastName=document.getElementById("form").elements[2].value;
var gender=document.getElementById("form").elements[3].value;
var addressProof=document.getElementById("form").elements[4].value;
var contact_number=document.getElementById("form").elements[6].value;
var gmail=document.getElementById("form").elements[7].value;
let userId=document.getElementById("form").elements[8].value;
let password=document.getElementById("form").elements[9].value;
var guide = new Guide(firstName,lastName,contact_number,addressProof,gmail,gender,userId,password);
console.log(guide);
let objJsonstr=btoa(JSON.stringify(guide));
//var objBase64=Buffer.from(objJsonstr).toString("Base64");
console.log(objJsonstr);//encoding done
 $.ajax({

            url:"http://localhost:7070/neha",

            type: 'POST',

            data: objJsonstr,            

            dataType: "html",          

            contentType: 'application/json',

            mimeType: 'application/json',

            success: function(data){ 
            	var jsonresponse=JSON.stringify(data);
                console.log(JSON.parse(data).msg); 

                return false;     

            },

             error: function (e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }

        });
}

function loginVerification()
{
var login=document.getElementById("form2").elements[1].value;
var password=document.getElementById("form2").elements[2].value;
var login=new Guidelogin(login,password);
let objJsonstr=btoa(JSON.stringify(login));
//var objBase64=Buffer.from(objJsonstr).toString("Base64");
//console.log(objJsonstr);//encoding done
 $.ajax({

            url:"http://localhost:7070/login",

            type: 'POST',

            data: objJsonstr,            

            dataType: "html",          

            contentType: 'application/json',

            mimeType: 'application/json',

            success: function(data){ 
            	var jsonresponse=JSON.stringify(data);
                var message=JSON.parse(data).msg;
                if(message.localeCompare("logged in")==0)
                	window.open('./static/UserAccount.html');
                else 
              		alert("try again");
             return false;  
              	// setTimeout(5000);
              //  return false;     

            },

             error: function (e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }

        });
}
