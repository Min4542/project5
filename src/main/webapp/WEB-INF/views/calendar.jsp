<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- fullcalender css, js cdn -->
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/main.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.0/main.min.css">

    <!-- jquery -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
               
                initialView: 'dayGridMonth',
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridDay'
                },
                buttonText: {
                    today : '오늘',
                    month : '월',
                    day : '일'
                },
                navLinks: true, // can click day/week names to navigate views
                dayMaxEvents: true, // 셀 크기보다 많은 이벤트 동록되어 있는 경우 'more'로 표기함
                selectable: true,
                locale: 'ko',

                events: function(info, successCallback, failureCallback){ // ajax 처리로 데이터를 로딩 시킨다. 
                    
                    $.ajax({
                        type:"GET",
                        url:"/schedule/get-schedule", 
                        dataType:"json",
                        success: function(result){
                            var events = [];
                            $.each(result, function(index, schedule) {
                                events.push({
                                               title: schedule.scdTitle,
                                               start: schedule.start,
                                               end: schedule.end,                                               
                                            }); //.push()
                            });
                            console.log(events);
                            successCallback(events);
                        }
                    }); 
                }
            });

            calendar.render();
        });

    </script>
    <title></title>
</head>
<body>
    <div id='calendar'></div>
</body>
</html>