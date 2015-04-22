package rest.com;
 
import com.sun.javafx.scene.layout.region.Margins;
import sun.org.mozilla.javascript.internal.json.JsonParser;
import sun.plugin2.message.Conversation;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;
import java.util.*;


@Path("/captcha")
public class WebService {

	@GET
	@Path("/device")
	@Produces(MediaType.TEXT_HTML)
	public Response ajaxResponse(@CookieParam("screen-width")Cookie widthCookie, @CookieParam("isTouch")Cookie isTouchCookie, @CookieParam("screen-height")Cookie heightCookie){

		Response.ResponseBuilder builder;

		double width = Double.parseDouble(widthCookie.getValue());
		double height = Double.parseDouble(heightCookie.getValue());
		double diagonal = Math.sqrt((width*width)+(height*height));

		width = Math.round(width *100.0)/100;
		height = Math.round(height *100.0)/100;

		String device = "Unidentified";
		if(diagonal < 7)
		{
			device = "Mobile";
		}
		else if(diagonal < 13)
		{
			device = "Tablet";
		}
		else
		{
			device = "PC";
		}

		String response = device +";"+width+";"+height+";"+isTouchCookie.getValue();
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
