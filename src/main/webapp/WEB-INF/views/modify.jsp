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
      <h1>등록한 스케쥴 정보</h1>

      <div>

       <form action="/schedule/modify" method="POST">
             <!-- post는 주소에 직접 정보를 적어보낼 수 없어서 보드 넘버가 안 넘어감 -->
                    <!-- 인풋히든은 사용자 모르게 정보를 보내는 것, 이것으로 컨트롤러에 보드 넘버 보내줌 -->
                    <input type="hidden" name="scdNo" value="${schedules.scdNo}">

             # 제목: <input class="form-control" type="text" name="scdTitle" value="${schedules.scdTitle}"><br>
             # 작성자: <input class="form-control" type="text" name="writerEmpNo" value="${schedules.writerEmpNo}"><br>
            # 내용: <br>
            <textarea class="form-control" rows="5" cols="30" name="scdContent" >${schedules.scdContent}</textarea>
            <br>
            # 시작날짜: <input type="datetime-local" name="startDate" value="${schedules.startDate}"><br>
            <fmt:formatDate value="${schedules.startDate}" pattern="yyyy-MM-dd a hh:mm:ss" />
            # 종료날짜: <input type="datetime-local" name="endDate" value="${schedules.endDate}"><br>
            <fmt:formatDate value="${schedules.endDate}" pattern="yyyy-MM-dd a hh:mm:ss" />
            <br>
            <button class="btn btn-outline-secondary" type="submit">수정</button>
         </form>
      </div>

  
   </div>

   <a id="go" href="/schedule/plan">스케쥴 목록</a>

</body>

</html>