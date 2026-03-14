package com.inetbanking.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
                    .format(new Date());

            String reportName = "ExtentReport-" + timeStamp + ".html";

            ExtentSparkReporter spark = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/test-output/" + reportName);

            spark.config().setDocumentTitle("InetBanking Automation Report");
            spark.config().setReportName("Functional Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Host Name", "Localhost");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User", "Sanjog");
        }

        return extent;
    }
}