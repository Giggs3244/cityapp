package cityapp.business.businessmodel;

import cityapp.dbmodel.User;

public class UserDto {

	private int id;
	private String user;
	private String password;

	public UserDto() {
	}

	public UserDto converterUserToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUser(user.getUser());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
