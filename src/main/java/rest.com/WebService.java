package rest.com;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.*;
import java.io.IOException;

@Path("/captcha")
public class WebService {

	@GET
	@Path("/device")
	@Produces(MediaType.TEXT_HTML)
	public Response ajaxResponse(@CookieParam("screen-width")Cookie widthCookie, @CookieParam("isTouch")Cookie isTouchCookie, @CookieParam("screen-height")Cookie heightCookie, @CookieParam("pixelDepth")Cookie pixelCookie){

		Response.ResponseBuilder builder;


		String resolution = widthCookie.getValue() +" * "+ heightCookie.getValue();
		double width = Double.parseDouble(widthCookie.getValue())/96;

		String device;
		if(width < 7)
		{
			device = "Mobile";
		}
		else if(width < 13)
		{
			device = "Tablet";
		}
		else
		{
			device = "PC";
		}

		String response = device +";"+resolution+";"+pixelCookie.getValue()+";"+isTouchCookie.getValue();

		builder = Response.ok(response,MediaType.TEXT_HTML);

		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("Access-Control-Max-Age", "3600");
		builder.header("Access-Control-Allow-Methods", "POST");
		builder.header(
				"Access-Control-Allow-Headers",
				"X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
		return builder.build();
	}


	////{"id":1,"content":"Hello, World!"}
	//follow below url and it shows how deserialize this response json
	//url : http://localhost:8080/restData/index1.html
	@GET
	@Path("/textres")
	@Produces(MediaType.APPLICATION_JSON)
	public Captcha getCaptchaInJSON() {

		Captcha captcha = new Captcha();
		captcha.captcha = "sweetcaptcha";
		captcha.width=200;
		captcha.height=300;

		return captcha;

	}
}

/*@POST
	@Path("/textres")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String newTodo(@FormParam("method") String method,
						@FormParam("app_id") int app_id,
						@FormParam("app_key") String app_key,
						@FormParam("platform") String platform) throws IOException {

		return "ok";
	}*/



/*
* private static final String FILE_PATH = "c:\\mkyong-logo.png";

	@GET
	@Path("/get")
	@Produces("image/png")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=image_from_server.png");
		return response.build();

	}
*
* */