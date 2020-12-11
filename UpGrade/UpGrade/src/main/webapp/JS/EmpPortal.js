/**
 * 
 */
window.onload = function() {
	console.log("this baby is working!!");
	getEmployee();
}

function getEmployee() {
	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		console.log("ready state go BBBBRRRRRRRR")
		console.log(xhttp.responseText);
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let emp = JSON.parse(xhttp.responseText);
			console.log(emp);
			console.log(emp.employee.firstName);
			loadElements(emp);
		}

	}


	xhttp.open("GET", "/UpGrade/getsession.json", false);

	xhttp.send();
}

function loadElements(emp){
	document.getElementById("empName").innerHTML=emp.employee.firstName;
	document.getElementById("amt").innerHTML=emp.employee.availableR;
}
