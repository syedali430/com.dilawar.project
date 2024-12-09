package com.dilawar.project.com.dilawar.project.utils;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.assertj.core.api.Assertions.assertThat;;

public class EntityValidatorTest {
	private EntityValidator entityValidation = new EntityValidator();

	@Test
	public void testValidateNameWhenNull() {
		assertThatThrownBy(() -> entityValidation.name(null)).isInstanceOf(NullPointerException.class)
				.hasMessage("Name cannot be null");
	}

	@Test
	public void testValidateNameWhenEmptyString() {
		assertThatThrownBy(() -> entityValidation.name(null)).isInstanceOf(NullPointerException.class)
				.hasMessage("Name cannot be null");
	}
	

	@Test
	public void testValidateNameWhenNameIsLessThanTenChars() {
		assertThatThrownBy(() -> entityValidation.name("aaaaaaaa")).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Name should be greater than 10 and less then 25");
	}
	@Test
	public void testValidateNameWhenNameIsEqualToTenChars() {
		assertThatThrownBy(() -> entityValidation.name("aaaaaaaaaa")).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Name should be greater than 10 and less then 25");
	}
	@Test
	public void testValidateNameWhenNameIsGreaterThanTwentyFiveChars() {
		assertThatThrownBy(() -> entityValidation.name("aaaaaaaaaaaaaaaaaaaaaaaaaa")).isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Name should be greater than 10 and less then 25");
	}
	
	
	@Test
	public void testValidateNameWhenNameIsCorrectName() {
		String name = "Syed Ali Dilawar";
		assertThat(entityValidation.name(name)).isEqualTo(name);
	}
	
	@Test
	public void testValidateNameWhenNameHasLeadingOrTrailingSpaces() {
	    String nameWithSpaces = " Syed Ali Dilawar ";
	    assertThatThrownBy(() -> entityValidation.name(nameWithSpaces))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Name should not have leading or trailing spaces");
	}

	@Test
	public void testValidateNameWhenNameContainsNumbers() {
	    String nameWithNumbers = "Syed Ali Dilawar123";
	    assertThatThrownBy(() -> entityValidation.name(nameWithNumbers))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Name should not contain numbers");
	}

	@Test
	public void testValidateNameWhenNameContainsSpecialCharacters() {
	    String nameWithSpecialChars = "Syed@Ali!Dilawar";
	    assertThatThrownBy(() -> entityValidation.name(nameWithSpecialChars))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Name should not contain special characters");
	}

	@Test
	public void testValidateEmailWhenEmailIsValid() {
	    String email = "test.user@example.com";
	    assertThat(entityValidation.email(email)).isEqualTo(email);
	}

	@Test
	public void testValidateEmailWhenEmailIsNull() {
	    String email = null;
	    assertThatThrownBy(() -> entityValidation.email(email))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Email should not be null or empty");
	}

	@Test
	public void testValidateEmailWhenEmailIsEmpty() {
	    String email = "";
	    assertThatThrownBy(() -> entityValidation.email(email))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Email should not be null or empty");
	}

	@Test
	public void testValidateEmailWhenEmailHasLeadingOrTrailingSpaces() {
	    String email = " test.user@example.com ";
	    assertThatThrownBy(() -> entityValidation.email(email))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Email should not have leading or trailing spaces");
	}

	@Test
	public void testValidateEmailWhenEmailDoesNotContainAtSymbol() {
	    String email = "test.userexample.com";
	    assertThatThrownBy(() -> entityValidation.email(email))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Email should contain exactly one '@' symbol");
	}
	@Test
	public void testValidateEmailWhenDomainPartIsInvalid() {
	    String email = "test.user@examplecom";
	    assertThatThrownBy(() -> entityValidation.email(email))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Email domain part is invalid");
	}
	
	@Test
	public void testValidateDateRangeWhenDatesAreValid() {
	    String startDate = "2022-01-01";
	    String endDate = "2022-12-31";
	    assertThat(entityValidation.validateDateRange(startDate, endDate))
	            .isEqualTo("Start: 2022-01-01, End: 2022-12-31");
	}

	@Test
	public void testValidateDateRangeWhenStartDateIsAfterEndDate() {
	    String startDate = "2022-12-31";
	    String endDate = "2022-01-01";
	    assertThatThrownBy(() -> entityValidation.validateDateRange(startDate, endDate))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Start date must be before or equal to end date");
	}

	@Test
	public void testValidateSingleDateWhenDateIsNull() {
	    assertThatThrownBy(() -> entityValidation.validateSingleDate(null, "Start"))
	            .isInstanceOf(NullPointerException.class)
	            .hasMessage("Start date cannot be null");
	}

	@Test
	public void testValidateSingleDateWhenDateIsEmpty() {
	    assertThatThrownBy(() -> entityValidation.validateSingleDate("", "End"))
	            .isInstanceOf(NullPointerException.class)
	            .hasMessage("End date cannot be empty");
	}

	@Test
	public void testValidateSingleDateWhenDateHasLeadingOrTrailingSpaces() {
	    String dateWithSpaces = " 2022-01-01 ";
	    assertThatThrownBy(() -> entityValidation.validateSingleDate(dateWithSpaces, "Start"))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Start date should not have leading or trailing spaces");
	}

	@Test
	public void testValidateSingleDateWhenDateIsInFuture() {
	    String futureDate = "2050-01-01";
	    assertThatThrownBy(() -> entityValidation.validateSingleDate(futureDate, "Start"))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Start date cannot be in the future");
	}

	@Test
	public void testValidateSingleDateWhenDateFormatIsInvalid() {
	    String invalidDate = "31-12-2022";  // Galat format
	    assertThatThrownBy(() -> entityValidation.validateSingleDate(invalidDate, "Start"))
	            .isInstanceOf(IllegalArgumentException.class)
	            .hasMessage("Start date is not in valid format (yyyy-MM-dd)");
	}
}
