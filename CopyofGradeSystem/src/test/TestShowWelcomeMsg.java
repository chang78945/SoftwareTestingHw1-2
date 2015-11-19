package test;

import static org.junit.Assert.*;
import gradeSystem.UI;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShowWelcomeMsg {

	/**
	 * @uml.property  name="outContent"
	 */
	final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	/**
	 * @uml.property  name="aUI"
	 * @uml.associationEnd  
	 */
	UI aUI = null;
	@Before
	public void setUp() throws Exception {
		final ByteArrayInputStream inContent = new ByteArrayInputStream(
				"Q".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		aUI = new UI();
	}

	@After
	public void tearDown() throws Exception {
	}

	/** ----------------------------------------------------------------------------------------------------------------------
	TestShowWelcomeMsg 
	case 1: UserName:��v��
	------------------------------------------------------------------------------------------------------------------------- */
	
	@Test
	public void test() {
		aUI.setUserName("��v��");
		String predictOutput = "��JID�� Q (�����ϥ�)? "+"�����F.\r\n";
		predictOutput=predictOutput+"Welcome "
						+ "��v��\r\n"
						+ "��J���O \t1) G ��ܦ��Z (Grade)\n \t2) R ��ܱƦW (Rank)\n \t3) W ��s�t�� (Weight)\n \t4) I �s�W�Ǹ� (Insert)\n \t5) D �R���Ǹ� (Delete)\n \t6) E ���}��� (Exit)\r\n";
		aUI.showWelcomeMsg();
		assertEquals(predictOutput, outContent.toString());
	}

}