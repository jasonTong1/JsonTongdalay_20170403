// 'use strict';
// var done = false;
// var longtime = {};
// longtime.delete1 = function() {

//     for (var i = 0, j = 9; i < 900000000; i++) {
//         j *= j;
//     }
//     console.log('done=true1   j=' + j);
//     done = true;
// };
// longtime.delete2 = function() {

//     for (var i = 0, j = 9; i < 900000000; i++) {
//         j *= j;
//     }
//     console.log('done=true2   j=' + j);
//     done = true;
// };

// longtime.delete3 = function() {

//     for (var i = 0, j = 9; i < 900000000; i++) {
//         j *= j;
//     }
//     console.log('done=true3   j=' + j);
//     done = true;
// };



// function deleteLongtime(a) {
// 	console.log(' --- '+a);
//     if (done === false) {
//     	delete longtime.delete;
//         console.log('delete.....done'+a);
//     }

// }

// setTimeout("deleteLongtime(2)", 15000);
// deleteLongtime(1);

// try {
//     longtime.delete1();
// } catch (e) {
//     console.log(e + 'sahnchule...');
// }
// try {
//     longtime.delete2();
// } catch (e) {
//     console.log(e + 'sahnchule...');
// }
// try {
//     longtime.delete3();
// } catch (e) {
//     console.log(e + 'sahnchule...');
// }



// 'use strict';

// function longtime() {
// 	setTimeout(function(){return;},100);
//     for (var i = 0, j = 9; i < 900000000; i++) {
//         j *= j;
//     }
//     console.log('done=true1   j=' + j);
//     // done = true;
// }
// longtime();

// //三种不同方式的 函数作用域 ，动态的 构造函数的作用域在 顶层！
// var k=1;
// var a;
// function test1(){
// 	// var k =2;
// 	// function test2(){
// 	// 	return k;
// 	// }
// 	// var test2= function(){
// 	// 	return k;
// 	// }

// 	var test2 = new Function('a','b','a=1');


// 	alert(test2());


// }

// test1();

// alert(a);

// function foo(a){
// 	if(a<1){return 1}
// 		else{
// 			return a*arguments.callee(a-1);
// 		}

// }
// var f = foo;
// foo = null;
// alert(f(5));
// alert(f);
// alert(foo);

// var name ="AA";
// var obj ={
// 	name:"BB",
// 	getname:function(){
// 		var _this = this;
//         return function(){
// 			return _this.name;
//         }

// 	}
// }
	

// alert(obj.getname()())


// function foo(x){
// 	var temp =x;
// 	return function(x){
// 		 temp+=x;
// 		return temp;
// 	}
// }

// var a =foo(50);
// console.log(a);
// console.log(a(10));
// console.log(a(12));
// console.log(a(13));


// var a ={b:1};

// function foo(arg){
// 	delete arg.b;
// 	console.log(arg);
// }

// foo(a);
// console.log(a);



/*
	
	这是练习 offset 到边框的距离

*/


       var test = document.getElementById("div1");
       var test2 = document.getElementById("div2");
       var test3 = document.getElementById("div3");
       var p1 = document.getElementById("p1");
        p1.innerHTML =
            "<p>offsetWidth:" + test.offsetWidth + "</p>" +
            "<p>offsetHeight:"+test.offsetHeight+"</p>"+
            "<p>offsetLeft:"+test.offsetLeft+"</p>"+
            "<p>offsetTop:"+test.offsetTop+"</p>"+
            "<hr>"+
            "<p>offsetWidth:" + test2.offsetWidth + "</p>" +
            "<p>offsetHeight:"+test2.offsetHeight+"</p>"+
            "<p>offsetLeft:"+test2.offsetLeft+"</p>"+
            "<p>offsetTop:"+test2.offsetTop+"</p>"+
            "<hr>"+
            "<p>offsetWidth:" + test3.offsetWidth + "</p>" +
            "<p>offsetHeight:"+test3.offsetHeight+"</p>"+
            "<p>offsetLeft:"+test3.offsetLeft+"</p>"+
            "<p>offsetTop:"+test3.offsetTop+"</p>"+
            "<p>div3距离div1的下方距离为："+(test.offsetTop+test.offsetHeight-
            	test3.offsetHeight-test3.offsetTop)+"</p>"

           ;
           function showXy(e){
            console.log(e.clientX+","+e.clientY);
           }