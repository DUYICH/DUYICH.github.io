// Câu 1
const para = document.getElementById("text");
para.style.color = "#777";
para.style.fontSize = "2rem";
para.innerHTML = "Tôi có thể làm <em> bất cứ điều gì </em> tôi muốn với JavaScript";

// Câu 2
const para1 = document.querySelectorAll('li');
para1.forEach(p => p.style.color = 'blue');

// Câu 3
const para2 = document.getElementById("list");
const para3 = para2.querySelectorAll('li');
para3.forEach(p => p.style.color = 'black');

//3.1
para2.insertAdjacentHTML('beforeend','<li>Item 8</li>');
para2.insertAdjacentHTML('beforeend','<li>Item 9</li>');
para2.insertAdjacentHTML('beforeend','<li>Item 10</li>');

//3.2

para3[0].style.color = 'red';

//3.3
para3[2].style.backgroundColor = 'blue';

//3.4
para2.removeChild(para3[3]);

//3.5
const newLi = document.createElement('li');
newLi.innerText = "Item Thay Thế";
para2.insertBefore(newLi, para3[4]);
