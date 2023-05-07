package ee.lhv.calculator;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Selenide.*;

@SpringBootTest
class LoanCalculatorTests {

	@Test
	void openPage() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		open("https://www.lhv.ee/et/liising#kalkulaator");
		sleep(2000);
	}

	@Test
	void agreeCookies() {
		openPage();
		$("#acceptPirukas").click();
		sleep(2000);
	}

	@Test
	void openCalculator() {
		agreeCookies();
		$("#monthly-payment").click();
		sleep(2000);
	}

	@Test
	void selectOperationalLease() {
		openCalculator();
		$("input[name=\"lease_type\"]:checked").shouldHave(Condition.value("HP"));

		$("label[for=\"kas_rent\"]").click();

		$("input[name=\"lease_type\"]:checked").shouldHave(Condition.value("FL"));
		sleep(2000);
	}

	@Test
	void priceInput() {
		openCalculator();
		//$(input[id=\"price\"]").shouldHave(Condition.value("15000"));
		$("input[id=\"price\"]").clear();
		$("input[id=\"price\"]").click();
		$("input[id=\"price\"]").setValue("30000");
		sleep(2000);
	}

	@Test
	void notIncludeVat() {
		openCalculator();
		Boolean checked = $("label[for=\"vat_included\"]").is(Condition.checked);
		if(checked){
			$("label[for=\"vat_included\"]").click();
		}
		sleep(3000);
	}

	@Test
	void downPaymentPercentageInput() {
		openCalculator();
		//$(input[id=\"price\"]").shouldHave(Condition.value("10"));
		$("input[id=\"initial_percentage\"]").clear();
		$("input[id=\"initial_percentage\"]").click();
		$("input[id=\"initial_percentage\"]").setValue("5");
		sleep(2000);
	}

	@Test
	void changeYears() {
		openCalculator();
		$("select[name=\"years\"]").shouldHave(Condition.value("72"));
		$("select[name=\"years\"]").click();
		$("option[value=\"60\"]").click();
		sleep(2000);
	}

}
