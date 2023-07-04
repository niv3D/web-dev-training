
const signUpForm = document.forms.signUp;

const userList = [];
const container = document.getElementById("itemContainer");

for(em of signUpForm.elements){
	em.addEventListener("focus",(e)=>{
		e.target.className = null;
		e.target.placeholder = '';
	});
};


signUpForm.addEventListener("submit",(e)=>{
	e.preventDefault();
	
	if (!verifyName(signUpForm.name.value)) {
		signUpForm.name.className = "wrong-input";
		signUpForm.name.value = null;
		signUpForm.name.placeholder = "inavlid username!";
		return;
	}

	if (!verifyEmail(signUpForm.email.value)) {
		signUpForm.email.className = "wrong-input";
		signUpForm.email.value = null;
		signUpForm.email.placeholder = "inavlid email!";
		return;
	}

	if (!verifyNumber(signUpForm.mobile.value)) {
		signUpForm.mobile.className = "wrong-input";
		signUpForm.mobile.value = null;
		signUpForm.mobile.placeholder = "inavlid number!";
		return;
	}

	const newId = userList.length === 0 ? 0 : userList[userList.length-1].id + 1;

	const user = {
		id : newId,
		name : signUpForm.name.value,
		email : signUpForm.email.value,
		mobile : signUpForm.mobile.value,
		dob : signUpForm.dob.value,
		gender : signUpForm.gender.value,
		html : signUpForm.html.checked,
		css : signUpForm.css.checked,
		js: signUpForm.js.checked,
		bio : signUpForm.bio.value
	};
	signUpForm.reset();
	signUpForm.add.value = "add";
	userList.push(user);
	container.replaceChildren(...getItemList());

});

function getItemList(){
	const itemList = [];
	for(user of userList){
		itemList.push(createItem(user));
	}
	return itemList;
}

function verifyName(name){
	const userNameRegex = /^[a-zA-Z\-]+$/ig;
	return name.match(userNameRegex);
}

function verifyEmail(email){
	const emailRegex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|.(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/ig;
	return email.match(emailRegex);
}

function verifyNumber(number){
	const numberRegex = /[1-9][0-9]{9}/g;
	return number.match(numberRegex);
}

function createItem(user){

	const item = document.createElement("div");
	item.className = "item";

	const name = document.createElement("h3");
	name.innerHTML = user.name;
	item.appendChild(name);

	const email = document.createElement('div');
	email.innerHTML = "email : " + user.email;
	item.appendChild(email);

	const mobile = document.createElement("div");
	mobile.innerHTML = "mobile : " + user.mobile;
	item.appendChild(mobile);

	const dob = document.createElement("div");
	dob.innerHTML = "dob : " + user.dob;
	item.appendChild(mobile);

	const gender = document.createElement("div");
	gender.innerHTML = "gender : " + user.gender;
	item.appendChild(gender);


	const skills = document.createElement("label");
	skills.innerHTML = "skills : ";
	item.appendChild(skills);

	const html = document.createElement("label");
	html.innerHTML = user.html ? " html " : "";
	item.appendChild(html);

	const css = document.createElement("label");
	css.innerHTML = user.css ? " css " : "";
	item.appendChild(css);

	const js = document.createElement("label");
	js.innerHTML = user.js ? " js " : "";
	item.appendChild(js);

	const bio = document.createElement("div");
	bio.innerHTML = "bio : " + user.bio;
	item.appendChild(bio);



	const edit = document.createElement("label");
	const ebt = document.createElement("button");
	ebt.innerHTML = "edit";
	ebt.id = "ebt" + user.id;
	ebt.addEventListener("click",editItem);
	edit.appendChild(ebt);

	item.appendChild(edit);
	
	const del = document.createElement("label");
	const dbt = document.createElement("button");
	dbt.innerHTML = "delete";
	dbt.id = "dbt" + user.id;
	dbt.addEventListener("click",deleteItem);
	del.appendChild(dbt);

	item.appendChild(del);

	return item;
}

function editItem(e){
	const id = Number(e.target.id.match(/\d+/)[0]);
	let item;
	for(i=0;i<userList.length;i++){
		if (id === userList[i].id) {
			item = userList.splice(i,1)[0];
			break;
		}
	}

	signUpForm.name.value = item.name;
	signUpForm.email.value = item.email;
	signUpForm.mobile.value = item.mobile;
	signUpForm.dob.value = item.dob;
	signUpForm.gender.value = item.gender;
	signUpForm.html.checked = item.html;
	signUpForm.css.checked = item.css;
	signUpForm.js.checked = item.js;
	signUpForm.bio.value = item.bio;
	signUpForm.add.value = "save";

	container.replaceChildren(...getItemList());

}

function deleteItem(e){
	const id = Number(e.target.id.match(/\d+/)[0]);
	for(i=0;i<userList.length;i++){
		if (id === userList[i].id) {
			userList.splice(i,1);
			break;
		}
	}
	container.replaceChildren(...getItemList());
}



