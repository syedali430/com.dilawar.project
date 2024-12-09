package com.dilawar.project.com.dilawar.project.repository.view;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JLabelMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import com.dilawar.project.com.dilawar.project.swingview.StudentSwingview;

public class StudentSwingViewTest extends AssertJSwingJUnitTestCase{
	private FrameFixture window;
	private StudentSwingview studentSwingView;
	

	@Override
	protected void onSetUp() throws Exception {

		GuiActionRunner.execute(() -> {
			studentSwingView = new StudentSwingview();
			return studentSwingView;
		});
		window = new FrameFixture(robot(), studentSwingView);
		window.show();

	}
	
	
	@Test
	@GUITest
	public void testControlsInitialStates() {

		// Verify Labels
		window.label(JLabelMatcher.withText("Student ID"));
		window.label(JLabelMatcher.withText("Name"));
		window.label(JLabelMatcher.withText("Email"));




		// Verify TextFields
		window.textBox("student_id").requireEnabled();
		window.textBox("name_text").requireEnabled();
		window.textBox("email_text").requireEnabled();


		// Verify ListLayout JList
		window.list("students_list");

		// Verify Buttons using text
		window.button(JButtonMatcher.withText("Add Students")).requireDisabled();
		window.button(JButtonMatcher.withText("Update")).requireDisabled();
		window.button(JButtonMatcher.withText("Delete Selected")).requireDisabled();

	}

	
	@Test
	
	public void testWhenIdIsEmptyAndNameEmailNotEmptyThenAddButtonShouldBeEnabeld() {
		
		window.textBox("name_text").enterText("ali");
		window.textBox("email_text").enterText("ali@gmail.com");
		window.button(JButtonMatcher.withText("Add Students")).requireEnabled();
	}

	@Test
	@GUITest
	public void testWhenStudentIdNameAndEmailAreNotEmptyThenUpdateButtonShouldBeEnabled() {
	    // Simulate entering data into the text fields
	    window.textBox("student_id").enterText("STUDENT_ID_1");  // Student ID field
	    window.textBox("name_text").enterText("STUDENT_NAME_1");  // Name field
	    window.textBox("email_text").enterText("STUDENT_EMAIL_1");  // Email field

	    
	    
	    // Verify that the Update button is enabled
	    window.button(JButtonMatcher.withText("Update")).requireEnabled();
	}
}


