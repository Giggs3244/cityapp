package cityapp.business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashText {

	private HashText() {
	}

	public static String sha1(String input) {
		MessageDigest mDigest;
		StringBuilder sb = null;
		try {
			mDigest = MessageDigest.getInstance("SHA1");
			byte[] result = mDigest.digest(input.getBytes());
			sb = new StringBuilder();
			for (int i = 0; i < result.length; i++) {
				sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

}
