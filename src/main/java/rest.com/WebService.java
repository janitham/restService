package rest.com;
 
import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/captcha")
public class WebService {

	@GET
	@Path("/device")
	@Produces(MediaType.TEXT_HTML)
	public Response ajaxResponse(@HeaderParam("user-agent")String userAgent, @CookieParam("screen-width")Cookie widthCookie, @CookieParam("isTouch")Cookie isTouchCookie, @CookieParam("screen-height")Cookie heightCookie, @CookieParam("pixelDepth")Cookie pixelCookie){

		Response.ResponseBuilder builder;

		String resolution = widthCookie.getValue() +" * "+ heightCookie.getValue();

		String device = detect(userAgent);


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

	private static String detect(String userAgent)
	{
		String agent = userAgent.replace("(", "").replace(")", "").replace(";", "").toLowerCase();

		if (agent.contains("mobile") || agent.contains("iphone") || agent.contains("phone"))
		{
			return "Mobile";
		}

		if(agent.contains("android") || agent.contains("ipad") || agent.contains("tablet"))
		{
			return "Tablet";
		}

		return "PC";
	}
}