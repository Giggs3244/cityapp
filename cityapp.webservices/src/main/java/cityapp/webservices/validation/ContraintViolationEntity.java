package cityapp.webservices.validation;

import java.util.ArrayList;
import java.util.List;

public class ContraintViolationEntity {

	private int code;
	private List<String> errorsMessages;

	public ContraintViolationEntity() {
		errorsMessages = new ArrayList<>();
	}

	public void addErrorMessage(String errorMessage) {
		this.errorsMessages.add(errorMessage);
	}

	public List<String> getErrorsMessages() {
		return errorsMessages;
	}

	public void setErrorsMessages(List<String> errorsMessages) {
		this.errorsMessages = errorsMessages;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
