// Bài 1: Viết function truyền vào 1 số nguyên dường. Tính giai thừa của số đó
// Ví dụ: calculateFactorial(5) = 5 * 4 * 3 * 2 * 1 = 120
let calculateFactorial = (a) => {
    let ans = 1;
    for (let i = a; i > 0  ; i--) {
        ans = ans * i;
    }
    return ans;
}
console.log(calculateFactorial(5))
// Bài 2: Viết function truyền vào 1 chuỗi. In ra chuỗi đảo ngược của chuỗi đó
// Ví dụ: reverseString(‘hello’) => olleh
let reverseString = (a) => {
    let ans = '';
    for (let i = a.length; i >=  0 ; i--) {
        ans = ans + a.charAt(i);
    }
    return ans;
}
console.log(reverseString('hello'));
// Bài 3: Viết function truyền vào mã quốc gia. Trả về message có ý nghĩa là “Xin chào”, tương ứng với mã quốc gia được truyền vào
// Ví dụ: translate(‘VN’) => “Xin chào”
// translate(‘EN’) => “Hello”
// Gợi ý : Sử dụng switch - case . Học viên tự nghĩ ra 1 vài mã quốc gia và câu chào tương ứng với quốc gia đó
let translate = (a) => {
    switch (a){
        case 'VN' : {
           return console.log('Xin chao')
           breaks;
        }
        case 'EN' : {
            return console.log('Hello')
            breaks;
        }
        case 'FR' : {
            return console.log('Bonjour')
            breaks;
        }
        case 'ES' : {
            return console.log('Hola')
            breaks;
        }
        case 'IT' : {
            return console.log('Ciao')
            breaks;
        }
    }
}
translate('VN');
translate('EN');
translate('FR');
translate('ES');
translate('IT');
// Bài 4: Cho function truyền vào 1 chuỗi dài hơn 15 ký tự. Viết 1 function cắt chuỗi, lấy ra 10 ký tự đầu tiên và thêm vào dấu “…” ở cuối chuỗi.
// Ví dụ : subString(“xinchaocacbandenvoiTechmaster”) => “xinchaocac…”
let subString = (a) => {
    return console.log(a.substr(0,10) + "...")
}
subString("xinchaocacbandenvoiTechmaster")
subString("1234567891011121314151617181920")