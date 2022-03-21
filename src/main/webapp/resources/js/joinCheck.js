/**
 * 
 */

const checkAll = document.getElementById('checkAll');
const check = document.getElementsByClassName('check');
const rules = document.getElementById('rules');
const btn = document.getElementById('btn');

checkAll.addEventListener("click", function() {
    // console.log('checkAll click');
    for(i of check) {
        i.checked=true;
    }

    if(checkAll.checked != true) {
        for(i of check) {
            i.checked=false;
        }
    }
})

rules.addEventListener("click", function(event) {
	let final = true;
	for(i of check) {
		if(!i.checked) {
		final = false;
		}
	};
	checkAll.checked = final;
});



btn.addEventListener("click", function() {
    if(checkAll.checked) {
        window.location.href="./join";
    }else {
        alert('모두 동의해주세요');
    }
});

