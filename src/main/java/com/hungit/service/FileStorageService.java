/**
 * 
 */
package com.hungit.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hungit.property.FileStorageProperties;
import com.hungit.util.DateUtil;
import com.hungit.util.RandomUtil;

/**
 * @author Kashiwagi
 *
 */
@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) throws IOException {

		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		Files.createDirectories(this.fileStorageLocation);

	}

	public String storeFile(MultipartFile file) throws IOException {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		fileName = RandomUtil.getRandomStr() + fileName;
		
		Path targetLocation = this.fileStorageLocation.resolve(fileName);

		Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

		return fileName;

	}

}