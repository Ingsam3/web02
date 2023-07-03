<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>EL (Expression Language : 표현언어 = >외부 라이브러리 필요 없음)</h3>
[1] 정수형  : ${10} <br>
<%-- ${출력할 값} 형태로 출력한다 --%>
[2] 실수형 : ${10.3}<br>
[3] 문자열 형 : ${"이순신"}<br>
[4] 논리형 : ${true}<br>
[5] null : ${null}<br>

<%
	String input = null;

%>
<h3>표현언어 연산자</h3>
\${10+10} = ${10+10}<br>
\${5/2} = ${5/2}<br>
\${5 mod 2} = ${5 mod 2}<br>
<!-- mod는 나머지 연산 -->
\${5 div 2} = ${5 div 2}<br>
<!-- div는 표현식 연산에서 나눗셈을 한다, 몫과 나머지를 함께 구한다. -->
\${2 gt 10} = ${2 gt 10}<br>
<!-- gt : ~보다 크기 비교 -->
\${empty input} = ${empty input}<hr>
<!-- input 비었는지 판단 -->
