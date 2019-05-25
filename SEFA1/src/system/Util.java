package system;

import java.io.Closeable;
import java.io.IOException;

public class Util {
	
	/**
	 * Try to close the closable/Scanner silently
	 * @param closable
	 */
	public static void close(Closeable closable) {
		try {
			closable.close();
		} catch (IOException e) {
		}
	}
}
