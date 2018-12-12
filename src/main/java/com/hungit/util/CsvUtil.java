/**
 * 
 */
package com.hungit.util;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Kashiwagi
 *
 */
public final class CsvUtil {
	public static void writeDataToCsvUsingStringArray(PrintWriter writer) {
		String[] CSV_HEADER = { "id", "firstname", "lastname" };
		try (CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
				CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);) {
			csvWriter.writeNext(CSV_HEADER);

//			for (Customer customer : customers) {
//				String[] data = { customer.getId().toString(), customer.getFirstName(), customer.getLastName() };
//
//				csvWriter.writeNext(data);
//			}

			System.out.println("Write CSV using CSVWriter successfully!");
		} catch (Exception e) {
			System.out.println("Writing CSV error!");
			e.printStackTrace();
		}
	}

}
