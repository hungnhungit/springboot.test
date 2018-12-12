/**
 * 
 */
package com.hungit.controller;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hungit.util.CsvUtil;
import com.opencsv.CSVWriter;

/**
 * @author Kashiwagi
 *
 */
@Controller
public class ExportCsvController {

	@RequestMapping(value = { "/download.csv" }, produces = "text/csv")
	public void downloadCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		CsvUtil.writeDataToCsvUsingStringArray(response.getWriter());
	}

}
