let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]
const boxes = document.querySelector(".boxes")
const box = document.createElement("div");
colors.forEach(e => {
    const box = document.createElement("div");
    box.classList.add("box");
    box.style.backgroundColor = e;
    boxes.appendChild(box);
});
const countBox = document.querySelectorAll(".box")
let count =  countBox.length;
const points = document.querySelector(".points");
points.innerText =` ${count}`
boxes.addEventListener('click', function(event) {
    boxes.removeChild(event.target);
    points.innerText =` ${--count}`
   })
const btn = document.getElementById("btn");
btn.addEventListener('click', () => {
    colors.forEach(e => {
        const box = document.createElement("div");
        box.classList.add("box");
        box.style.backgroundColor = e;
        boxes.appendChild(box);
    });
    count = count + colors.length;
    points.innerText =` ${count}`;

} )
