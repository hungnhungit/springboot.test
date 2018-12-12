/**
 * 
 */
package com.hungit.util;

import java.io.File;

/**
 * @author Kashiwagi
 *
 */
public class FileUtil {
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}
}
