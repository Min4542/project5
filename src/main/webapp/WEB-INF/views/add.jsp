<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
</head>

<body>
   
   <div class="write-container">
      <h1>스케쥴 등록</h1>

      <form class="write-form" action="/schedule/scd-add">
         <div class="input-box">

            
            # 제목: <input class="form-control" type="text" name="scdTitle"><br>
            # 내용: <br>
            <textarea class="form-control" rows="5" cols="30" name="scdContent"></textarea>
            <br>
            # 시작날짜: <input type="date" name="startDate"><br>
            # 종료날짜: <input type="date" name="endDate"><br>

            <label>
                #일정 구분: 
                <input type="checkbox" name="type" value="C"> 회사 일정
                <input type="checkbox" name="type" value="D"> 부서 일정
                <input type="checkbox" name="type" value="P"> 개인 일정
            </label>

         </div>
         <button type="submit">등록</button>
      </form>
   </div>

   <a id="go" href="/board/list">글 목록보기</a>

</body>

</html>