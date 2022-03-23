const reply = document.querySelector("#reply");
const num = document.querySelector("#num");
const writer = document.querySelector("#writer");
const contents = document.querySelector("#contents");
const replyResult = document.querySelector("#replyResult");
const del = document.querySelectorAll(".del");

//-----------------------------------------------
replyResult.addEventListener("click", function(event) {
    if(event.target.classList.contains('update')) {
        // event.target.classList.replace('update', 'reply')
        // console.log(event.target.parentNode.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = event.target.getAttribute("data-index");
        let replyNum = document.querySelector("#up"+num);

        let text = replyNum.innerText;
        replyNum.innerText='';

        let tx = document.createElement("textarea");
        tx.setAttribute("id", "update"+num);
        tx.classList.add("reply");
        tx.setAttribute("data-num", num);
        tx.value=text;
        replyNum.append(tx);
    }
});

replyResult.addEventListener("change", function(event) {
    if(event.target.classList.contains('reply')) {
        let contents = event.target.value;
        let replyNum = event.target.getAttribute("data-num");

        let check = window.confirm("수정하시겠습니까"); //확인 : true 취소 : false return
    
        if(check) {
            let xhttp = new XMLHttpRequest();
            xhttp.open("POST", "../noticeReply/update");
            
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            
            xhttp.send("replyNum="+replyNum+"&contents="+contents);
    
            xhttp.onreadystatechange=function() {
                if(this.readyState == 4 && this.status == 200) {
                    let result = this.responseText.trim();
                    if(result == '1') {
                        alert("수정되었습니다");
                        document.querySelector("#up"+replyNum).innerHTML=contents;
                    }else {
                        alert("수정 실패했습니다");
                    }
                }
            }
        }
    }

});

//-----------------------------------------------

// for(d of del) {
//     d.addEventListener("click", function() {
//         console.log("test");
//     });
// }

replyResult.addEventListener("click", function(event) {
    let cn = event.target;

    if(cn.classList.contains('del')) {
        let replyNum = cn.getAttribute("data-num")
        console.log(replyNum);

        //url "/noticeReply/delete" method:post parameter: replyNum
        //Controller 만들어서 ajax 요청이 가는지 확인하고 replyNum print해보기
        const xhttp3 = new XMLHttpRequest();
        xhttp3.open("POST", "../noticeReply/delete");
        xhttp3.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp3.send("replyNum="+replyNum);

        xhttp3.onreadystatechange=function() {
            if(this.readyState == 4 && this.status == 200) {
                let result = this.responseText.trim();
                if(result == '1') {
                    alert("댓글이 삭제되었습니다")
                    getList();
                }else {
                    alert("삭제에 실패했습니다")
                }
            }
        }

    }
   
});

//-----------------------------------------------

getList();

function getList () {
    const xhttp2 = new XMLHttpRequest();

    //외부 js에서는 EL을 사용할 수 없음
    xhttp2.open("GET", "../noticeReply/list?num="+num.value);
    
    xhttp2.send();

    xhttp2.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            replyResult.innerHTML = this.responseText.trim();
        }
    }
}

reply.addEventListener("click", function() {
    
    console.log(num.value);
    console.log(writer.value);
    console.log(contents.value);

    //JS에서 요청 객체 선언
    const xhttp = new XMLHttpRequest();

    //요청 정보 입력
    //open('method형식', 'URL 주소')
    xhttp.open("POST", "../noticeReply/add");

    //요청 header 정보
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    //요청 전송
    //post 요청시 파라미터
    //send("이름=값&이름2=값2...")
    xhttp.send("num="+num.value+"&writer="+writer.value+"&contents="+contents.value);

    //응답 처리
    //readystate가 4이면 요청이 발송되고 응답이 끝난 상태
    //status가 200이면 정상적으로 끝난 상태
    //400이면 client 오류
    //500이면 server 오류
    xhttp.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            let result = this.responseText.trim();
            if(result == '1') {
                alert('댓글이 등록되었습니다');
                getList();
            }else {
                alert('댓글 등록이 실패했습니다');
            }
        }
    }
});

