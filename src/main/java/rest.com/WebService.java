package rest.com;
 
//import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.core.*;
import java.io.IOException;
//import javax.servlet.http.HttpServletResponse;

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
	@GET
	@Path("/textres")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setId(123456);
		track.setContent("Hello, World!");

		return track;

	}

	@POST
	@Path("/textres")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String newTodo(@FormParam("method") String method,
						@FormParam("app_id") int app_id,
						@FormParam("app_key") String app_key,
						@FormParam("platform") String platform) throws IOException {
		/*Todo todo = new Todo(id, summary);
		if (description != null) {
			todo.setDescription(description);
		}
		TodoDao.instance.getModel().put(id, todo);

		servletResponse.sendRedirect("../create_todo.html");*/

		return "ok";
	}


}

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