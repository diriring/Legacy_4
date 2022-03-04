/**
 * 
 */

//전역변수
const pw = document.getElementById("pw");
const pwResult = document.getElementById("pwResult");

const id = document.getElementById("id");
const idAlert = document.getElementById("idAlert");
const pw2 = document.getElementById("pw2");
const pwResult2 = document.getElementById("pwResult2");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

let idCheck=false; //체크가 됐으면 true 안됐으면 false
let pwCheck=false;
let nameCheck=false;
let phoneCheck=false;
let emailCheck=false;

btn.addEventListener("click", function() {
    if(idCheck && pwCheck && nameCheck && phoneCheck && emailCheck) {
        frm.submit();
    }else {
        alert("필수 요건을 확인하세요");
    }
});

pw.addEventListener("change", function() {
    pwCheck=false;
    pw2.value='';
    pwResult2.innerHTML='';
    pw2.focus();
});

pw.addEventListener("keyup", function() {
    let v = pw.value;
    pwResult.innerHTML="8글자 이상 입력해주세요";
    if(v.length >= 8) {
        pwResult.innerHTML="이상 없음"
        if(v.length > 12) {
            pwResult.innerHTML="12글자 이하로 입력해주세요"
        }
    }
});

id.onblur = function() {
    let v = id.value;
    if(v.length == 0) {
        idAlert.innerHTML = "입력 필수 입니다";
        idCheck=false;
    }else {
        idCheck=true;
    }
};

pw2.onblur = function() {
    pwResult2.innerHTML="일치하지 않습니다";
    if(pw.value == pw2.value) {
        pwResult2.innerHTML="일치합니다";
        pwCheck=true;
    }else {
        pwCheck=false;
    }
};

name.addEventListener("blur", function() {
    let v = name.value;
    if(v.length == 0) {
        nameCheck=false;
    }else {
        nameCheck=true;
    }
});

phone.addEventListener("blur", function() {
    let v = phone.value;
    if(v.length == 0) {
        phoneCheck=false;
    }else {
        phoneCheck=true;
    }
});

email.addEventListener("blur", function() {
    let v = email.value;
    if(v.length == 0) {
        emailCheck=false;
    }else {
        emailCheck=true;
    }
});