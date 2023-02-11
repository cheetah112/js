const btn = document.getElementById('btn');
const image = document.getElementById('image');
const select = document.querySelector('select');

// Vừa load trang phải gọi API để render danh sách breed
// API : https://dog.ceo/api/breeds/list/all

async function getBreedList() {
    // Gọi API để lấy danh sách giống loài
    let res = await axios.get("https://dog.ceo/api/breeds/list/all")

    // Sau khi có data thì hiển thị kết quả trên giao diện
    renderBreed(res.data.message)
}

function renderBreed(breeds) {
    // Duyệt qua object breeds -> tạo thẻ option -> gắn vào DOM
    let list = Object.keys(breeds);
    let option = "";
    for (let i = 0; i < list.length; i++) {
        option += 
        `
        <option value = "${list[i]}">${list[i]}</option>
        `
    }
    select.innerHTML = option;
    // Cách 1: Sử dụng for ... in
    // Cách 2 : Lấy ra danh sách keys của objec (Object.keys) => Duyệt mảng
}

getBreedList()
btn.addEventListener("click", () => {
    getRandomImage()
});
function getRandomImage() {

        let data = axios.get(`https://dog.ceo/api/breed/${select.value}/images/random`)
        data.then(res =>{
            image.src = res.data.message ;
        })
}
