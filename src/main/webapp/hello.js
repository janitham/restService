//{"id":1,"content":"Hello, World!"}
//http://rest-service.guides.spring.io/greeting
$(document).ready(function() {
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: "http://localhost:8080/restData/rest/captcha/textres",
        dataType: "json"
    }).then(function(data) {
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});


/*$.ajax({
 type: 'PUT',
 contentType: 'application/json',
 url: rootURL + '/' + $('#wineId').val(),
 dataType: "json",
 data: formToJSON(),*/