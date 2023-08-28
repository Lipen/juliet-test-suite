/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_max_square_54c.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-54c.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package juliet.testcases.CWE190_Integer_Overflow.s04;
import juliet.support.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_max_square_54c
{
    public void badSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_54d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_54d()).goodG2BSink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(long data ) throws Throwable
    {
        (new CWE190_Integer_Overflow__long_max_square_54d()).goodB2GSink(data );
    }
}
