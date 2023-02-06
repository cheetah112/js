const text = document.getElementById("text");
text.style.color = "#777";
text.style.fontSize = "2rem";
text.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript.";
const lis = document.querySelectorAll("li");
lis.forEach((e) => {
    e.style.color = "blue"
});
const list =document.getElementById("list");
list.insertAdjacentHTML("beforeend", "<li> Item 8 </li> <li> Item 9 </li> <li> Item 10 </li>");
const list1 = document.querySelector("#list li:nth-child(1)");
list1.style.color = "red";
const list3 = document.querySelector("#list li:nth-child(3)");
list3.style.backgroundColor ="green";
const list4 = document.querySelector("#list li:nth-child(4)");
list4.parentNode.removeChild(list4);
const listadd = document.createElement("li");
listadd.innerText = "Item add"
list3.insertAdjacentElement("afterend", listadd);
