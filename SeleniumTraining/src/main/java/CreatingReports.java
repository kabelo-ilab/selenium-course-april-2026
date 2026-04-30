import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author: Kabelo Tlhape
 **/
public class CreatingReports {
    public static void main(String[] args) {
        //Report container
        ExtentReports report = new ExtentReports();
        //report document
        ExtentSparkReporter rptSpark = new ExtentSparkReporter("src/main/resources/reports/Spark Test.html");
        rptSpark.config().setDocumentTitle("Test Progress Report");
        rptSpark.config().setReportName("Spark Report");

        report.attachReporter(rptSpark);

        //create tests
        ExtentTest test1 = report.createTest("TC1", "First Test");
        test1.pass("TC1 has passed");

        ExtentTest test2 = report.createTest("TC2", "Second Test");
        test2.fail("TC2 has failed");

        ExtentTest test3 = report.createTest("TC3", "Third Test");
        test3.info("TC3 contains general info");

        ExtentTest test4 = report.createTest("TC4", "Forth Test");
        test4.warning("TC4 contains a warning");

        ExtentTest test5 = report.createTest("TC5", "Fifth Test");
        test5.log(Status.SKIP,"TC5 has been skipped");

        report.flush();

    }
}
