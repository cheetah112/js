// Danh sách các sản phẩm có trong giỏ hàng
let products = [
    {
        name: "Iphone 13 Pro Max", // Tên sản phẩm
        price: 3000000, // Giá mỗi sản phẩm
        brand: "Apple", // Thương hiệu
        count: 2, // Số lượng sản phẩm trong giỏ hàng
    },
    {
        name: "Samsung Galaxy Z Fold3",
        price: 41000000,
        brand: "Samsung",
        count: 1,
    },
    {
        name: "IPhone 11",
        price: 15500000,
        brand: "Apple",
        count: 1,
    },
    {
        name: "OPPO Find X3 Pro",
        price: 19500000,
        brand: "OPPO",
        count: 3,
    },
]
console.log(products);
// 6. Thêm 1 sản phẩm bất kỳ vào trong mảng product
products.push({
    name: "Samsung s21 ultra",
    price: 28000000,
    brand: "Samsung",
    count: 5,
});
console.log("----6-----")
console.log(products);
// 7. Xóa tất cả sản phẩm của thương hiệu "Samsung" trong giỏ hàng
console.log("----7-----")
const deleteProducts = (arr, namebrand) => {
    return arr.filter((p) => p.brand.toLowerCase() !== namebrand.toLowerCase());
}
console.log(deleteProducts(products, "Samsung"));
// 8. Sắp xếp giỏ hàng theo price tăng dần
const sortProductsByPrice = (arr) => {
    return arr.sort((a,b) => {return a.price - b.price });
}
console.log("----8-----")
console.log(sortProductsByPrice(products));
// 9. Sắp xếp giỏ hàng theo count giảm dần
const sortProductsByCount  = (arr) => {
    return arr.sort((a,b) => {return b.count - a.count});
}
console.log("----9-----")
console.log(sortProductsByCount(products));
// 10. Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
const pickRandomProducts = (arr, quantity) => {
    let ans = [];
    do{
    ans = arr.filter((p) => arr.indexOf(p) == Math.floor(Math.random() * arr.length));
    } while (ans.length !== quantity);
    return ans;
}
console.log("----10-----")
console.log(pickRandomProducts(products, 2));
console.log(Math.floor(Math.random() * products.length));
