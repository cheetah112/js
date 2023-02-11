const heading = document.getElementById("heading");
const ul = document.getElementById("list");
const buttons = document.getElementById("buttons");

let btnPosts = document.createElement("button");
btnPosts.innerText = "posts";
btnPosts.classList.add("activeButton");
getList("posts");
heading.innerText = `Type : ${btnPosts.innerText}`;

const btnPhotos = document.createElement("button");
btnPhotos.innerText = "photos";

const btnAlbums = document.createElement("button");
btnAlbums.innerText = "albums";

buttons.insertAdjacentElement("beforeend", btnPosts);
buttons.insertAdjacentElement("beforeend", btnPhotos);
buttons.insertAdjacentElement("beforeend", btnAlbums);

async function getList(nameList) {
    try {
        let res = await axios.get(`https://jsonplaceholder.typicode.com/${nameList}`);
        renderList(res.data)   
    } catch{console.error();}
}

const renderList = (arr) =>{
    let html = ""
    for (let i = 0; i < arr.length; i++) {
        html += `<li>${arr[i].title}</li>`
    }
    ul.innerHTML = html
}

buttons.addEventListener("click", (e) => {
    ul.innerHTML = "";
    getList(e.target.innerText);
    
    btnAlbums.classList.remove("activeButton");
    btnPhotos.classList.remove("activeButton");
    btnPosts.classList.remove("activeButton");
    e.target.classList.add("activeButton");

    heading.innerText = `Type : ${e.target.innerText}`
})

