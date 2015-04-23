package rest.com;
 
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
}