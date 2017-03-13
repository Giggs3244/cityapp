package cityapp.webservices.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.cityapp.exceptions.DatabaseException;

import cityapp.business.businessmodel.RespuestaGeneral;

public class DatabaseExceptionMapper implements ExceptionMapper<DatabaseException> {

	@Override
	public Response toResponse(DatabaseException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new RespuestaGeneral(500, exception.getMessage()))
				.type(MediaType.APPLICATION_JSON).build();
	}

}
