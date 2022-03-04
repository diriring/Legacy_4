/**
 * 
 */

const title = document.getElementById("title");
const writer = document.getElementById("writer");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

let titleCheck=false;
let writerCheck=false;

btn.addEventListener("click", function() {
    if(titleCheck && writerCheck) {
        frm.submit();
    }else {
        alert("제목 혹은 작성자를 확인해주세요");
    }
});

title.addEventListener("blur", function() {
    if(title.value=='') {
        titleCheck=false;
    }else {
        titleCheck=true;
    }
});

writer.addEventListener("blur", function() {
    if(writer.value=='') {
        writerCheck=false;
    }else {
        writerCheck=true;
    }
});