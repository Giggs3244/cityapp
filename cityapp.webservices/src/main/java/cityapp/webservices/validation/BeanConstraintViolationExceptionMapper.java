package cityapp.webservices.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import cityapp.business.businessmodel.RespuestaGeneral;

@Provider
public class BeanConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {

		RespuestaGeneral respuestaGeneral = new RespuestaGeneral();
//		ContraintViolationEntity constraintViolationEntity = new ContraintViolationEntity();
		for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
//			constraintViolationEntity.addErrorMessage(cv.getMessage());
			respuestaGeneral.addErrorMessage(cv.getMessage());
		}
		
//		constraintViolationEntity.setCode(400);
		respuestaGeneral.setCodigo(400);
//		return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolationEntity).build();
		return Response.status(Response.Status.BAD_REQUEST).entity(respuestaGeneral).build();

	}

}
