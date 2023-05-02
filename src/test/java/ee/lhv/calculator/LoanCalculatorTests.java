package ee.lhv.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Selenide.*;

@SpringBootTest
class LoanCalculatorTests {

	@Test
	void openPage() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		open("https://www.lhv.ee/et/liising#kalkulaator");
		sleep(3000);
	}

	@Test
	void agreeCookies() {
		openPage();
		$("#acceptPirukas").click();
		sleep(3000);
	}

	@Test
	void openCalculator() {
		agreeCookies();
		$("#kalkulaator").click();
		sleep(3000);
	}

}
