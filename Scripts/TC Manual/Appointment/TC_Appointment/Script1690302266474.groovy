import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('reuseable test/block_Login with valid credential'), [('username') : 'John Doe', ('pass') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Spy Manual/Appointment/dropdown_Facility'), facility, false)

if (hospital_readmission == true) {
    //jika true, maka click hospital readmission 
    WebUI.check(findTestObject('Object Spy Manual/Appointment/chk_hospital_readmission'))
}

def select_radio = healthcare_program

switch (select_radio) {
    case select_radio = 'medicare':
        println(select_radio)

        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_programMedicare'))

        break
    case select_radio = 'medicaid':
        println(select_radio)

        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_programMedicaid'))

        break
    default:
        println(select_radio)

        WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_programNone'))

        break
}

//WebUI.click(findTestObject('Object Spy Manual/Appointment/inpt_programMedicaid'))
WebUI.setText(findTestObject('Object Spy Manual/Appointment/inpt_visitDate'), visit_date)

WebUI.setText(findTestObject('Object Spy Manual/Appointment/inpt_comment'), comment)

WebUI.click(findTestObject('Object Spy Manual/Appointment/btn_Book Appointment'))

WebUI.waitForElementPresent(findTestObject('Object Spy Manual/Appointment/btn_GoToHomepage'), 0)

WebUI.verifyElementPresent(findTestObject('Object Spy Manual/Appointment/btn_GoToHomepage'), 0)

WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_Facility'), facility)

if (hospital_readmission == true) {
	WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_hospital_readmission'), 'Yes')
}
else {
	WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_hospital_readmission'), 'No')
}

//HEALTHCARE PROGRAM
switch (select_radio) {
	case select_radio = 'medicare':
		println(select_radio)

		WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_program'), 'Medicare')
		break
		
	case select_radio = 'medicaid':
		println(select_radio)

		WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_program'), 'Medicaid')
		break
		
	default:
		println(select_radio)

		WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_program'), 'None')
		break
}



WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_visit_date'), visit_date)

WebUI.verifyElementText(findTestObject('Object Spy Manual/Appointment_Confirmation/txt_comment'), comment)

WebUI.closeBrowser()

