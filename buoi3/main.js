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

// 6.Thêm 1 nút “add” + 1 ô input để nhập text. Mỗi khi bấm nút thêm 1 thẻ <li> có nội dung là nội dung trong ô input vào cuối danh sách
const btnadd = document.createElement("button");
btnadd.innerText = "Add";

const input = document.createElement("input");
input.type = "text";
input.placeholder = " Enter text ...";

list.insertAdjacentElement("beforebegin", btnadd);
btnadd.insertAdjacentElement("beforebegin", input);

const addEle = () => {
    const value = input.value;
    if(value.trim() ===""){
        alert("Nội dung không được để trống !!!");
    }else{
    list.insertAdjacentHTML("beforeend", `<li>${value}</li>`);
    input.value = "";
    }
}

btnadd.addEventListener("click", addEle);
input.addEventListener("keydown", (e) =>{
    if(e.key === "Enter") {
        addEle();
    }
} );

//7. Thêm 1 nút “remove”. Chức năng để xóa thẻ <li> cuối cùng của danh sách
const btnRemove = document.createElement("button");
btnRemove.innerText = "Remove";
list.insertAdjacentElement("beforebegin", btnRemove);
btnRemove.addEventListener("click", () => {
    list.removeChild(list.lastChild);
})
// 8. Thêm 1 nút “Hide” trên đầu của danh sách <ul>.
// Khi bấm vào “Hide” thì <ul> sẽ ẩn. Đồng thời label của nút “Hide” => “Show”
// Và ngược lại Khi bấm vào “Show” thì <ul> sẽ hiện. Đồng thời label của nút “Show” => “Hide”
const btnHide = document.createElement("button");
btnHide.innerText = "Hide";
btnRemove.insertAdjacentElement("afterend", btnHide);
btnHide.addEventListener("click", () => {
    if(btnHide.textContent === "Hide"){
        btnHide.innerText = "Show";
        list.style.display = "none"
    }else{
        btnHide.innerText = "Hide";
        list.style.display = "block";
    }
})
