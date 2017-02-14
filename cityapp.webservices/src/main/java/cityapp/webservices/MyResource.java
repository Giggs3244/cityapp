package cityapp.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getSaludo() {
		return "{\"Nombre\":\"Bryan\", \"Apellido\":\"Bedoya\"}";
	}

}
