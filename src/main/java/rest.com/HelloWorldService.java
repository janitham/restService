package rest.com;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import java.io.File;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/hello")
public class HelloWorldService {

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
}

