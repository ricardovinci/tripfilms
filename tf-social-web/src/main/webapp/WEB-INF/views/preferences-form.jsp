<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<h1>Preferences Page</h1>  
<form:form method="POST" modelAttribute="preferences" action="preferences-result">  
<table>  
    <tbody>
    <tr>   
        <td>When a user video is available (after upload), post on FB timeline </td>  
        <td><form:checkbox path="postOnFBTimeline"></form:checkbox></td>   
    </tr>  
    <tr>
        <td>When a comment is made on a user video, send an email</td>  
        <td><form:checkbox path="sendEmail"></form:checkbox></td>
    </tr>
    <tr>  
        <td colspan="2">  
            <input type="submit" value="Submit">  
        </td>  
    </tr>  
</tbody></table>    
</form:form>  
