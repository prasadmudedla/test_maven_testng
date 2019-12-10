package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import util.ConfigFileReader;
import util.DriverManager;

public class SuiteManager {

    DriverManager driverManager;
    private static ConfigFileReader config = new ConfigFileReader();

    @BeforeSuite(alwaysRun = true)
    public void startDriver() {
        driverManager = new DriverManager();
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriver() {
        DriverManager.driver.quit();
    }

    @BeforeClass
    public void launchUrl() {
        DriverManager.driver.manage().window().maximize();
        String baseUrl = config.getProperty("base_url");
        DriverManager.driver.get(baseUrl);
    }

}




//    A gitignore file specifies intentionally untracked files that Git should ignore.
//        Files already tracked by Git are not affected; see the NOTES below for details.
//
//        Each line in a gitignore file specifies a pattern. When deciding whether to ignore a path,
//        Git normally checks gitignore patterns from multiple sources,
//        with the following order of precedence, from highest to lowest
//        (within one level of precedence, the last matching pattern decides the outcome):
//
//        Patterns read from the command line for those commands that support them.
//
//        Patterns read from a .gitignore file in the same directory as the path,
//        or in any parent directory,
//        with patterns in the higher level files (up to the toplevel of the work tree)
//        being overridden by those in lower level files down to the directory containing the file.
//        These patterns match relative to the location of the .gitignore file. A project normally
//        includes such .gitignore files in its repository, containing patterns for files generated as
//        part of the project build.











