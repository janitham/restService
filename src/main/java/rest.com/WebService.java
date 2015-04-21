package rest.com;
 
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;


@Path("/hello")
public class WebService {

	private static final String FILE_PATH = "C:\\image.jpg";

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say1 : " + msg;
 
		return Response.status(200).entity(output).build();

	}

	@GET
	@Path("/get")
	@Produces("image/jpg")
	public Response getFile() {

		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok(file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		return response.build();

	}

	//In this example, it gets the browser “user-agent” from request header.
	@GET
	@Path("/useragent")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("userAgent : " + userAgent)
				.build();

	}

	@GET
	@Path("/device")
	@Produces(MediaType.TEXT_HTML)
	public Response ajaxResponse(@CookieParam("screen-width")Cookie cookie){

		Response.ResponseBuilder builder;

		builder = Response.ok(cookie.getValue(),MediaType.TEXT_HTML);
		builder.header("Access-Control-Allow-Origin", "*");
		builder.header("Access-Control-Max-Age", "3600");
		builder.header("Access-Control-Allow-Methods", "POST");
		builder.header(
				"Access-Control-Allow-Headers",
				"X-Requested-With,Host,User-Agent,Accept,Accept-Language,Accept-Encoding,Accept-Charset,Keep-Alive,Connection,Referer,Origin");
		return builder.build();
	}


	@GET
	@Path("/context")
	public Response addUser(@Context HttpHeaders headers) {

		for(String header : headers.getRequestHeaders().keySet()){
		System.out.println(header);


		}

		String userAgent = headers.getRequestHeader("user-agent").get(0);

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent)
				.build();
	}
}
