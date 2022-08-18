<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 등록</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>

<body>

	<%-- 	<form method="get" action="/ajax/user/add" id="userForm"> --%>
		<label>이름 </label><input type="text" name="name" id="nameInput">
		<label>생년월일 </label><input type="text" name="birthday" id="birthDayInput">
		<label>이메일 </label><input type="text" name="email" id="emailInput">
		<button type="submit" id="saveBtn">저장</button>
	
	<%-- </form> --%> 
	
	
	<%-- button 을 id로 저장해서 id를 통해서 script 에서 쓸수 있게 객체화! --%>
	
	
	
	<%-- 에러 났을 때 검사!! 소스 input 눌러서 에러내용 확인 --%>
	<script>
		$(document).ready(function() {
			
			$("#saveBtn").on("click", function(){
				
				let name = $("#nameInput").val();
				let birthDay = $("#birthDayInput").val();
				let email = $("#emailInput").val();
				
				
				// 유효성 검사 : 밸리데이션 (사용자가 제대로 입력했는지 확인 하는 것)
				if(name == "") {
					alert("이름을 입력하세요!!");
					return false ;   
				} 
				
				if(birthDay == "") {
					alert("생년월일을 입력하세요");
					return false;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return false;
				}
				
				// 중괄호 안에 옵션들을 나열 
				// 클릭이벤트에 의해서 수행되어야 하니까 클릭이벤트 안에 들어가야함
				
				// ajax 를 사용하는 가장 기본적인 방침
				$.ajax({
					
					// request
					type:"get"
					, url:"/ajax/user/add"
					, data:{"name":name, "birthday":birthDay, "email":email}   // parameter = data, dictionary 형태-{"name":"김인규"}
					
					// response
					, success:function(data) {  // 괄호 안에 parameter 추가
					//	alert(data);
						
						// 원래는 문자열이지만 jquery 가 확인하고 객체형태로 전환하여 때문에 쉽게 쓸 수 있게 해준다
						
						// 즉, response 에 담기는 건 문자열 이지만, 그 문자열을 전달받아서 jquery 가 객체형태로 변환해서 전달
						if(data.result == "success") {
							// 성공시
							// 자바스크립트 코드를 통해서 페이지 이동
							location.href="/ajax/user/list";    // 절대경로 (host 뒷부분 모두 입력)
						} else {
							alert("저장실패");  // error 와 구분해주는 것이 좋다 : 구분을 해줘야 빠르게 처리가능
						}
					
					// 그래서 그냥 기본 데이터를 보여주는 형식으로 만들고, 그것을 우리는 API 라고 하기로 함
					
					} // response 가 정상적으로 등록되었을 때 호출 될 함수를 등록해주는 것
					, error:function() {
						alert("저장 에러");
					} // 실패했을 때 호출될 함수
				});
			});
			
			
			// submit 이벤트 : 다루기 까다로워서 잘 안씀
		/*	$("#userForm").on("submit", function(){
			
				// submit는 다름 : 중단이 되길 바란다!! return false 를 해주어야 함
				
				let name = $("#nameInput").val();
				let birthDay = $("#birthDayInput").val();
				let email = $("#emailInput").val();
				
				if(name == "") {
					alert("이름을 입력하세요!!");
					return false ;   
				} 
				
				if(birthDay == "") {
					alert("생년월일을 입력하세요");
					return false;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return false;
				}
			
				
			}); */
			
			// 이벤트 이름, 그 이벤트가 수행됐을 때 진행할 함수
			// $("#saveBtn").on("click", function(){
			//		let name = $("#nameInput").val();
			//		let birthDay = $("#bithDayInput").val();
			//		let email = $("#email").val();
					
			//		if(name == "") {
			//			alert("이름을 입력하세요!!");
			//			return ;   // 더이상 진행 못하도록 해당하는 함수 리턴
			//		} 
			//		
			//		if(birthDay == "") {
			//			alert("생년월일을 입력하세요");
			//			return;
			//		}
			//		
			//		if(email == "") {
			//			alert("이메일을 입력하세요");
			//			return;
			//		}
			//	}); // return이 되었음에도 불구하고, form이 가지고 있는 특성 때문에 action에 있는 주소로 페이지를 이동해서 해당 내용을 수행한다
				    // return 은 됐지만 form이 하는 일은 그대로 진행한 것
				    // form 일 때는 우리가 잡아야할 이벤트가 따로있다
				    // -> button 을 잡는 게 아니라 submit 라는 이벤트를 잡아야한다 즉: form 태그를 잡아야 한다
			
			
		});
		
	</script>
</body>
</html>



<%-- 나는 request 2번 response 2번 인줄 알았는데 그게 아니라 form 으로 입력받았을 때 그 때는 request 가 맞지만 그냥 input 만 있을 때엔 input만 덩그러니 있는 거지 request 가 아니다
	즉, request 는 ajax 가 했고 (request 1번) , request 한 걸 토대로 모두 처리하고 return map 으로 response 한 번, 그 response 를 받아서 ajax 가 수행!!
	자바스크립트를 통해서 브라우저가 할일을 내가 직접한다고 생각하면 된다!! (브라우저가 알아서 처리해주던걸 우리가 아작스로 코드 만드는 것)
 --%>