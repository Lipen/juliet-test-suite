/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__short_max_add_42.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-42.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before adding 1 to data
 *    BadSink : Add 1 to data, which can cause an overflow
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package juliet.testcases.CWE190_Integer_Overflow.s04;
import juliet.support.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__short_max_add_42 extends AbstractTestCase
{
    private short badSource() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Short.MAX_VALUE;

        return data;
    }

    public void bad() throws Throwable
    {
        short data = badSource();

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    private short goodG2BSource() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    private void goodG2B() throws Throwable
    {
        short data = goodG2BSource();

        /* POTENTIAL FLAW: if data == Short.MAX_VALUE, this will overflow */
        short result = (short)(data + 1);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    private short goodB2GSource() throws Throwable
    {
        short data;

        /* POTENTIAL FLAW: Use the maximum size of the data type */
        data = Short.MAX_VALUE;

        return data;
    }

    private void goodB2G() throws Throwable
    {
        short data = goodB2GSource();

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Short.MAX_VALUE)
        {
            short result = (short)(data + 1);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to perform addition.");
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
