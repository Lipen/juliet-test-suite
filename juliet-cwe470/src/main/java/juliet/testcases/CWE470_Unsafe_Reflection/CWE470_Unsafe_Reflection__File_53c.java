/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE470_Unsafe_Reflection__File_53c.java
Label Definition File: CWE470_Unsafe_Reflection.label.xml
Template File: sources-sink-53c.tmpl.java
*/
/*
 * @description
 * CWE: 470 Use of Externally-Controlled Input to Select Classes or Code ('Unsafe Reflection')
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: Set data to a hardcoded class name
 * Sinks:
 *    BadSink : Instantiate class named in data
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package juliet.testcases.CWE470_Unsafe_Reflection;

import juliet.support.*;

import javax.servlet.http.*;

public class CWE470_Unsafe_Reflection__File_53c
{
    public void badSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__File_53d()).badSink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data ) throws Throwable
    {
        (new CWE470_Unsafe_Reflection__File_53d()).goodG2BSink(data );
    }
}
