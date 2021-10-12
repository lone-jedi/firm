public class Test {
    public void printPassed(String testId) {
        System.out.println("\u001B[30m" + "\u001B[42m" + "TEST PASSED!" + "\u001B[0m" + "\t" + testId);
    }

    public void printFailed(String testId, String expected) {
        System.out.println("\u001B[41m" + "TEST FAILED!" + "\u001B[0m" + "\t" + testId + " " + expected);
    }

    public void assertEquals(String testId, Employee expected, Employee actual) {
        if(expected == null && actual == null) {
            printPassed(testId);
            return;
        }

        if(expected.equals(actual)) {
            printPassed(testId);
            return;
        }
        printFailed(testId, "Expected:" + expected + " actual:" + actual);
    }

    public void assertEquals(String testId, String expected, String actual) {
        if(expected.equals(actual)) {
            printPassed(testId);
            return;
        }
        printFailed(testId, "Expected:" + expected + " actual:" + actual);
    }
}
