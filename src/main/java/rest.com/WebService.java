package rest.com;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.File;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.ResponseBuilder;

//import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

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

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");
		return response.build();

	}

	//In this example, it gets the browser “user-agent” from request header.
	@GET
	@Path("/useragent")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent)
				.build();

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

