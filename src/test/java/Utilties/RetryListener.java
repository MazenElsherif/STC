package Utilties;

import Step_Difination.Hooks;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
// retry the run when failing
public class RetryListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult result) {
        // Do nothing before method invocation
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            int maxRetries = 1; // Adjust the number of retries as needed
            int retryCount = 0;

            while (retryCount < maxRetries) {
                retryCount++;
                try {
                    // Close the browser if it's open
                    if (Hooks.isBrowserOpen()) {
                        Hooks.quitDriver();
                    }

                    // Open a new browser session
                    Hooks.getDriver();

                    // Rerun the failed scenario here
                    System.out.println("Retrying test: " + result.getName() + " - Retry #" + retryCount);
                    method.getTestMethod().getConstructorOrMethod().getMethod().invoke(result.getInstance());
                    method.getTestMethod().getConstructorOrMethod().getMethod().invoke(result.getInstance());

                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
