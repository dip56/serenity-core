package net.thucydides.core.webdriver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

/**
 * Created by john on 30/01/15.
 */
class WhenMonitoringWebDriverTimeoutOptions extends Specification {

    def webDriverFactory = new WebDriverFactory()

    def "should record the driver implicit timeout when it is set"() {
        given:
            def driver = new WebDriverFacade(HtmlUnitDriver.class, webDriverFactory)
        when:
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        then:
            driver.implicitTimeoutValue == 10
            driver.implicitTimeoutUnit == TimeUnit.SECONDS
    }
}
