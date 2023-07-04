
//1.Write a Javascript function to insert a string within a string at a particular position (default is 1 ).
function insertInside(str, sub, pos = 1){
	return str.slice(0,pos) + sub + str.slice(pos);
};

//2.Write a Javascript function to humanized number (Formats a number to a human readable string) with the correct suffix such as 1st, 2nd, 3rd, 4th.
function humanizeNumber(num){
	
	if(typeof num != 'number') return;
	
	const suffixes = ['th', 'st', 'nd', 'rd'];
	
	let last = num%100;
	
	let suffix;
	
	if(last >10 && last < 14){
		suffix = suffixes[0];
	}
	else{
		last %= 10;
		suffix = suffixes[last] || suffixes[0];
	}
	
	return num + suffix;
};

//3.Write a Javascript function to repeat a string a specified times.
function repeatString(str, num){
	
	let newStr = '';
	
	for(i=0;i<num;i++){
		newStr+=str;
	}
	return newStr;
};

//4.Write a Javascript function to check whether an input is an array or not.
function isArray(input){
	return Array.isArray(input);
};

//5.Find if the element has present in the array.
function isPresent(arr,elem){
	if(arr.indexOf(elem)=== -1){
		return false;
	}
	else{
		return true;
	}
};

//6.Write a Javascript program to list the properties of a Javascript object.
function getProperties(obj){
	let keys=[];
	for(let key in obj){
		keys.push(key);
	}
	return keys;
}


obj = {
	name : "nived",
	age: 23
};

//7.Write a Javascript program to check whether the key is present or not in the object.

	"name" in obj;

//8.Write a Javascript program counter (increment, decrement, reset option) with an object.

	counter = {
		value : 0,
		increment : function(){this.value++},
		decrement : function(){this.value--},
		reset: function(){this.value = 0}
	};

//9.Write a Javascript program to add and update the array data in the object.

	data = {
		list: [{name:'nived', age:23},{name:'belbin', age:22}]
	}

	function addData(name, age){
		this.list.push({ name : name, age : age});
	}

//10.Write a JavaScript program to construct the following pattern, using a nested for loop. 

	for(let i=1; i<=5; i++){
		for(let j=1; j<=i;j++){
			console.log('*');
		}
		console.log('\n');
	}

//11.

	for(let i=5; i>=1; i--){
		for(let j=1; j<=i;j++){
			console.log('*');
		}
		console.log('\n');
	}



