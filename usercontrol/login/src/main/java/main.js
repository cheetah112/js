const username = document.getElementById("username");
const password = document.getElementById("password");
const button = document.getElementById("login");
let user = {};
button.addEventListener("click", () => {
user.username = username.value;
user.password = password.value;
console.log(user);
})
;