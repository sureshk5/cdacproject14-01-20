module.exports.Guide = function(fname,lname,adress_Proof,contact_number,gender,gmail)
{
	this.fname=fname;
	this.lname=lname;
	this.adress_Proof=adress_Proof;
	this.contact_number=contact_number;
	this.gender=gender;
	this.gmail=gmail;
}
module.exports.FetchData=function(){
	getFirstName=function()
	{
		return fname;
	}
	getlastName=function()
	{
		return lname;
	}
	getAddress=function()
	{
		return adress_Proof;
	}
	getcontact=function()
	{
		return contact_number;
	}
	getgender=function()
	{
		return gender;
	}
	getgmail=function()
	{
		return gmail;
	}
	return {
	  getFirstName:getFirstName,
	  getlastName:getlastName,
	  getAddress:getAddress,
	  getcontact:getcontact,
	  getgmail:getgmail,
	  getgender:getgender
	}

}();