package com.dilawar.project.com.dilawar.project.utils;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class EntityValidator {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	// null
	// ""
	// white space start , end
	// does not contains numbers
	// length 10<name<25
	// speacial charachter
	// 100% correct name
	public String name(String text) {
		if(text == null) {
			throw new NullPointerException("Name cannot be null");
		}
		if("".equals(text)) {
			throw new NullPointerException("Name cannot be null");
		}
		if(text.length()<=10 || text.length()>25) {
			throw new IllegalArgumentException("Name should be greater than 10 and less then 25");

		}
		
		if (text.startsWith(" ") || text.endsWith(" ")) {
		    throw new IllegalArgumentException("Name should not have leading or trailing spaces");
		}

		if (text.matches(".*\\d.*")) {
		    throw new IllegalArgumentException("Name should not contain numbers");
		}
		
		if (text.matches(".*[^a-zA-Z\\s].*")) {
		    throw new IllegalArgumentException("Name should not contain special characters");
		}
		
		return text;
	}
	
	public String email(String text) {
		
        //  Check if email is null or empty
		//  Check for leading or trailing spaces
		//  Check the length (between 5 and 50 characters)
		//  Ensure there is exactly one '@' symbol
		//  Check the structure of the email (basic pattern)
		//  Validate the local part (before @) for allowed characters
		// Validate the domain part (after @) - should contain at least one dot (.)
		
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Email should not be null or empty");
        }

       
        if (text.startsWith(" ") || text.endsWith(" ")) {
            throw new IllegalArgumentException("Email should not have leading or trailing spaces");
        }

        
        if (text.length() <= 5 || text.length() >= 50) {
            throw new IllegalArgumentException("Email should be between 5 and 50 characters long");
        }

        
        if (text.chars().filter(ch -> ch == '@').count() != 1) {
            throw new IllegalArgumentException("Email should contain exactly one '@' symbol");
        }

        
        String[] emailParts = text.split("@");
        if (emailParts.length != 2 || emailParts[0].isEmpty() || emailParts[1].isEmpty()) {
            throw new IllegalArgumentException("Email should have a valid local part and domain");
        }

        String localPart = emailParts[0];
        String domainPart = emailParts[1];

        
        if (!localPart.matches("[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+")) {
            throw new IllegalArgumentException("Email local part contains invalid characters");
        }

        
        if (!domainPart.matches("[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException("Email domain part is invalid");
        }

        return text; 
    }
	
	  public String validateDateRange(String startDateText, String endDateText) {
	        // Validate Start Date
	        LocalDate startDate = validateSingleDate(startDateText, "Start");

	        // Validate End Date
	        LocalDate endDate = validateSingleDate(endDateText, "End");

	        // Ensure Start Date is before or equal to End Date
	        if (startDate.isAfter(endDate)) {
	            throw new IllegalArgumentException("Start date must be before or equal to end date");
	        }

	        return "Start: " + startDate + ", End: " + endDate;
	    }

	    // Single date validation method
	    public LocalDate validateSingleDate(String dateText, String dateType) {
	        // Null Check
	        if (dateText == null) {
	            throw new NullPointerException(dateType + " date cannot be null");
	        }

	        // Empty Check
	        if ("".equals(dateText)) {
	            throw new NullPointerException(dateType + " date cannot be empty");
	        }

	        // No Leading or Trailing Spaces
	        if (dateText.startsWith(" ") || dateText.endsWith(" ")) {
	            throw new IllegalArgumentException(dateType + " date should not have leading or trailing spaces");
	        }

	        // Validate Date Format
	        LocalDate parsedDate;
	        try {
	            parsedDate = LocalDate.parse(dateText, DATE_FORMATTER);
	        } catch (DateTimeParseException e) {
	            throw new IllegalArgumentException(dateType + " date is not in valid format (yyyy-MM-dd)");
	        }

	        // Check if Date is in the Future
	        if (parsedDate.isAfter(LocalDate.now())) {
	            throw new IllegalArgumentException(dateType + " date cannot be in the future");
	        }

	        return parsedDate;
	    }
	
}

