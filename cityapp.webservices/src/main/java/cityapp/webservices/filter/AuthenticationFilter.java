package cityapp.webservices.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

import cityapp.business.businessmodel.RespuestaGeneral;
import cityapp.business.UserController;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString("Authorization");
		if (authorizationHeader != null && !authorizationHeader.isEmpty()) {
			authorizationHeader = authorizationHeader.replaceFirst("Basic ", "");
			System.out.println(authorizationHeader);
			String authorizationDecoded = new String(DatatypeConverter.parseBase64Binary(authorizationHeader));
			System.out.println(authorizationDecoded);
			StringTokenizer tokenizer = new StringTokenizer(authorizationDecoded, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			if (UserController.isValidoUser(username, password)) {
				System.out.println("Bienvenido");
			} else {
				requestContext.abortWith(createResponse(Response.Status.UNAUTHORIZED, "Unauthorized."));
			}
		} else {
			requestContext.abortWith(createResponse(Response.Status.BAD_REQUEST, "Missing Authorization Header."));
		}
		System.out.println("Into filter request");
	}

	private Response createResponse(Response.Status status, String mensaje) {
		RespuestaGeneral respuestaGeneral = new RespuestaGeneral(status.getStatusCode(), mensaje);
		return Response.status(status).entity(respuestaGeneral).build();
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		System.out.println("Into filter response");
	}

}
