/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__int_connect_tcp_sub_81_bad.java
Label Definition File: CWE191_Integer_Underflow__int.label.xml
Template File: sources-sinks-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: sub
 *    GoodSink: Ensure there will not be an underflow before subtracting 1 from data
 *    BadSink : Subtract 1 from data, which can cause an Underflow
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE191_Integer_Underflow.s01;
import juliet.support.*;

import javax.servlet.http.*;

public class CWE191_Integer_Underflow__int_connect_tcp_sub_81_bad extends CWE191_Integer_Underflow__int_connect_tcp_sub_81_base
{
    public void action(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Integer.MIN_VALUE, this will overflow */
        int result = (int)(data - 1);

        IO.writeLine("result: " + result);

    }
}
