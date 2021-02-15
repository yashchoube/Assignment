import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.io.*;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
//import cucumber.api.junit.Cucumber;
//import org.junit.runner.RunWith;
//import org.junit.AfterClass;


import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = false,
        features = {"src\\main\\resources\\features\\"},
        glue = {"practice.ui"},
        plugin = {"pretty","json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"}
)


public class RunnerTest {


}
