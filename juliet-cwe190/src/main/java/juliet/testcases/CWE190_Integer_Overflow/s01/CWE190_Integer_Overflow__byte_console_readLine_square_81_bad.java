/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__byte_console_readLine_square_81_bad.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: console_readLine Read data from the console using readLine
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: square
 *    GoodSink: Ensure there will not be an overflow before squaring data
 *    BadSink : Square data, which can lead to overflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE190_Integer_Overflow.s01;
import juliet.support.*;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__byte_console_readLine_square_81_bad extends CWE190_Integer_Overflow__byte_console_readLine_square_81_base
{
    public void action(byte data ) throws Throwable
    {

        /* POTENTIAL FLAW: if (data*data) > Byte.MAX_VALUE, this will overflow */
        byte result = (byte)(data * data);

        IO.writeLine("result: " + result);

    }
}
