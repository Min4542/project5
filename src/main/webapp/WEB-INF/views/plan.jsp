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

         # 제목: <input class="form-control" type="text" name="scdTitle" value="${schedules.scdTitle}" disabled><br>
         # 작성자: <input class="form-control" type="text" name="writerEmpNo" value="${schedules.writerEmpNo}"
            disabled><br>
         # 내용: <br>
         <textarea class="form-control" rows="5" cols="30" name="scdContent" disabled>${schedules.scdContent}</textarea>
         <br>
         <li>
            # 시작날짜: ${schedules.startDate}
            <fmt:formatDate value="${schedules.startDate}" pattern="yyyy-MM-dd a hh:mm:ss" />
         </li>
         <li>
            # 종료날짜:${schedules.endDate}
            <fmt:formatDate value="${schedules.endDate}" pattern="yyyy-MM-dd a hh:mm:ss" />
         </li>

         <a id ="delete" data-board-no="${schedules.scdNo}" class="del_btn" href="/schedule/delete?scdNo=${schedules.scdNo}">[삭제]</a>


      </div>


   </div>

   <a id="go" href="/schedule/modify">스케쥴 수정하기</a>


</body>

</html>