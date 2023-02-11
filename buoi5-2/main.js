let selectProvince = document.getElementById("province");
let selectDistrict= document.getElementById("district");
let selectCommune = document.getElementById("commune");
async function Select() {
    try{
        let province = await axios.get("https://provinces.open-api.vn/api/p/")
        render(province.data.message);
    } catch(error) {
        console.log(error)
    }
}