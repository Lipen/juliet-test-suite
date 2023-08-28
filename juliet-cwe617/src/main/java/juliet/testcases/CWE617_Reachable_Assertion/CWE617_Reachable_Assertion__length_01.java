/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__length_01.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 617 Assertion is reachable
* Sinks: length
*    GoodSink: assert true, which will never trigger
*    BadSink : assert false, which will always trigger
* Flow Variant: 01 Baseline
*
* */

package juliet.testcases.CWE617_Reachable_Assertion;

import juliet.support.*;

public class CWE617_Reachable_Assertion__length_01 extends AbstractTestCase
{
    public void bad() throws Throwable
    {

        /* FLAW: assertion is false */
        assert "".length() > 0;

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        /* FIX: assertion is true */
        assert "cwe617".length() > 0;

    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the juliet.testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}

