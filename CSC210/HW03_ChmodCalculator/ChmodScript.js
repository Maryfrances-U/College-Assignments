$(document).ready(function(){

	var numOut = 0;
	var letOut = "---------";


	function changer(box, num, index, char)	{
		if (box.checked)	{
			numOut = numOut + num;
			letOut = letOut.substr(0, index) + char + letOut.substr(index+1, letOut.length);
			document.getElementById('numbers').value = numOut;
			document.getElementById('letters').value = letOut;
		}
		else{
			numOut = numOut - num;
			letOut = letOut.substr(0, index) + '-' + letOut.substr(index+1, letOut.length);
			document.getElementById('numbers').value = numOut;
			document.getElementById('letters').value = letOut;
		}

		//$("#numbers").html(numOut);
		//$("#letters").html(letOut);
	}


	const box1 = document.querySelector("#OwnerR");
	box1.addEventListener('change', function(e){
		changer(box1, 400, 0, 'r');
	})

	const box2 = document.querySelector("#OwnerW");
	box2.addEventListener('change', function(e){
		changer(box2, 40, 1, 'w');
	})

	const box3 = document.querySelector("#OwnerX");
	box3.addEventListener('change', function(e){
		changer(box3, 4, 2, 'x');
	})

	const box4 = document.querySelector("#GroupR");
	box4.addEventListener('change', function(e){
		changer(box4, 200, 3, 'r');
	})

	const box5 = document.querySelector("#GroupW");
	box5.addEventListener('change', function(e){
		changer(box5, 20, 4, 'w');
	})

	const box6 = document.querySelector("#GroupX");
	box6.addEventListener('change', function(e){
		changer(box6, 2, 5, 'x');
	})

	const box7 = document.querySelector("#PublicR");
	box7.addEventListener('change', function(e){
		changer(box7, 100, 6, 'r');
	})

	const box8 = document.querySelector("#PublicW");
	box8.addEventListener('change', function(e){
		changer(box8, 10, 7, 'w');
	})

	const box9 = document.querySelector("#PublicX");
	box9.addEventListener('change', function(e){
		changer(box9, 1, 8, 'x');
	})
})
