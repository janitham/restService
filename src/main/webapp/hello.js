//{"id":1,"content":"Hello, World!"}
//http://rest-service.guides.spring.io/greeting
$(document).ready(function() {
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: "http://localhost:8080/restData/rest/captcha/textres",
        dataType: "json"
    }).then(function(data) {
       $('.captcha-name').append(data.captcha);
       $('.captcha-width').append(data.width);
        $('.captcha-height').append(data.height);
    });
});


/*$.ajax({
 type: 'PUT',
 contentType: 'application/json',
 url: rootURL + '/' + $('#wineId').val(),
 dataType: "json",
 data: formToJSON(),*/