const fileResult = document.getElementById("fileResult");
const fileAdd = document.getElementById("fileAdd");
const del = document.getElementsByClassName("del");

let count = 0;
let num = 0; //id 용도

fileAdd.addEventListener("click", function() {
    // console.log(count);
    
    
    if(count > 4) {
        alert("파일은 최대 5개까지 추가 가능");
        return;
    }
    
    count = count + 1;

    let file = document.createElement("div");
    file.setAttribute("id", "del"+num);
    
    
    let input = document.createElement("input");
    input.setAttribute("type", "file");
    input.setAttribute("name", "files");
    
    let button = document.createElement("button");
    button.setAttribute("type", "button");
    button.className = "del";
    button.setAttribute("data-num", "del"+num);
    button.innerHTML="DEL";

    file.append(input);
    file.append(button);

    // file.innerHTML = "<input type=\"file\" name=\"files\">" +
    // "<button type=\"button\">DEL</button>";
    
    fileResult.append(file);
    
    num++;
     
});

fileResult.addEventListener("click", function(event) {
    // console.log("CurrentTarget : ", event.currentTarget);
    // console.log("this : ", this);
    // console.log("Target : ", event.target);

    let cn = event.target;
    // console.log(event.target.classList.contains('del'));

    if(cn.classList.contains('del')) {
        let delNum = cn.getAttribute("data-num");
        document.getElementById(delNum).remove();
        count--;
        // console.log(count);
    }
});

//-----------------------------------------------------------
const fileDeleteBtn = document.querySelectorAll(".fileDeleteBtn");
const files = document.querySelector("#files");

//각각의 fileNum을 console에 출력
files.addEventListener("click", function(event) {

    let check = confirm("정말 삭제하시겠습니까?");

    if(!check) {
        return;
    }

    if(event.target.classList.contains("fileDeleteBtn")) {
        let fileNum = event.target.getAttribute("data-fileNum");
        
        //ajax로 파라미터 : fileNum, method : POST, url : fileDelete, controller : fileDelete
        let xhttp = new XMLHttpRequest();
        xhttp.open("POST", "./fileDelete");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");    
        xhttp.send("fileNum="+fileNum);

        xhttp.onreadystatechange=function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = this.responseText.trim();
                if(result == '1') {
                    console.log("파일 삭제");
                    event.target.parentNode.remove();
                }else {
                    
                }
            }
        }
    
    }
});

