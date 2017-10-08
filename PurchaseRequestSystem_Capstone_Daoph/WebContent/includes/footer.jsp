<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>



<p id = footer style = "font-size: 10pt; text-align:center">&copy; Copyright <%= currentYear %> Phuc Dao </p>
</body>
</html>