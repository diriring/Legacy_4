//ID, PW, NAME, EMAIL, PHONE 비어있으면 어디가 비어있는지 알려주는 알림창
//알림창 뜨고나면 비어있는 창에 focus 되도록

const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

const idResult = document.getElementById("idResult");
const pwResult = document.getElementById("pwResult");
const pwResult2 = document.getElementById("pwResult2");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

//-----------------PW 검증
pw.addEventListener("blur", function() {
    if(pw.value.length<8 || pw.value.length>12) {
        pwResult.innerHTML="password의 글자수가 맞지 않아요";
    }
});
let pwCheck=true; //같지 않을 때 true, 같으면 false;
pw2.addEventListener("blur", function() {
    let message = "pw가 일치합니다";
    if(pw.value != pw2.value) {
        pwCheck = true;
        message = "pw가 일치하지 않습니다";
        pw2.value='';
    }else {
        pwCheck=false;
    }
    pwResult2.innerHTML=message;
});
//-----------------PW검증이 끝나고 PW를 수정한 경우
pw.addEventListener("change", function() {
    pwCheck=true;
    pw2.value='';
    pwResult2.value='';
    pw2.focus();
});

//-----------------ID 입력 후
id.addEventListener("blur", function() {
    if(id.value=='') {
        idResult.innerHTML="ID를 입력하세요";
    }else {
        
    }
});


//------------------가입버튼 눌렀을 때
btn.addEventListener("click", function() {
    if(id.value=='') {
        alert('ID를 입력하세요');
        id.focus();
        return;
    }
    if(pw.value=='' || pw.value.length<8 || pw.value.length>12) {
        alert('pw가 정확하지 않습니다');
        pw.focus();
        return;
    }
    if(pwCheck) {
        alert('pw가 일치하지 않습니다');
        pw2.focus();
        return;
    }
    if(name.value=='') {
        alert('이름을 입력하세요');
        name.focus();
        return;
    }
    if(phone.value=='') {
        alert('번호를 입력하세요');
        phone.focus();
        return;
    }
    if(email.value=='') {
        alert('email을 입력하세요');
        email.focus();
        return;
    }
    frm.submit();
});



pw.addEventListener("blur", function() {
    let v = pw.value;
    if(v.length == 0) {
        pwCheck=false;
    }else {
        pwCheck=true;
    }
});
