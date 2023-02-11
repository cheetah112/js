// Bài 1: Viết function truyền vào mảng các chuỗi có độ dài bất kỳ. Kết quả trả về là 1 mảng các chuỗi có độ dài lớn nhất
const getStringHasMaxLength = (arr) => {
    let count = 0;
    let ans =[];
    for (let i = 0; i < arr.length; i++) {
        if(arr[i].length > count) {
            count = arr[i].length;
        }
    }
    for (let j = 0; j < arr.length; j++) {
        if(arr[j].length == count) {
            ans.push(arr[j])
        }
    }
    return ans;
}
console.log(getStringHasMaxLength(['aba', 'aa', 'ad', 'c', 'vcd']));

// bài 2:
users = [
    {
        name: "Bùi Công Sơn",
        age: 30,
        isStatus: true
    },
    {
        name: "Nguyễn Thu Hằng",
        age: 27,
        isStatus: false
    },
    {
        name: "Phạm Văn Dũng",
        age: 20,
        isStatus: false
    }
]
// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age > 25 và isStatus = true:
const getUserByAgeAndIsStatus = (arr) => {
    let ans = [];
    for (let i = 0; i < arr.length; i++) {
        if(arr[i].age > 25 && arr[i].isStatus === true) {
            ans.push(arr[i])
        }
    }
    return ans;
}
console.log(getUserByAgeAndIsStatus(users));
// Viết function truyền vào 1 mảng các object user. Trả về mảng các user có age tăng dần
const sortUserByAge = (arr) => {
    arr.sort((a,b) => {
    return a.age - b.age
    })
    return arr;
}
console.log(sortUserByAge(users));

// Bài 3. Viết function truyền vào 1 mảng các chuỗi. Trả về Object hiển thị xem mỗi phần tử trong mảng xuất hiện bao nhiêu lần:
const getCountElement = (arr) => {
    let ans = {};
    for (let i = 0; i < arr.length; i++) {
        if(ans.hasOwnProperty(arr[i])){
            ans[arr[i]] ++;
        }else{
            console.log(arr[i])
            ans[arr[i]] = 1;
        }
    }
    return ans;
}
console.log(getCountElement(["one", "two", "three", "one", "one", "three"]));