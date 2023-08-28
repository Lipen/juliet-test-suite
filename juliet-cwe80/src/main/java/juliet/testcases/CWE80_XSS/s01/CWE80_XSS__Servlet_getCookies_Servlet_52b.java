/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE80_XSS__Servlet_getCookies_Servlet_52b.java
Label Definition File: CWE80_XSS__Servlet.label.xml
Template File: sources-sink-52b.tmpl.java
*/
/*
 * @description
 * CWE: 80 Cross Site Scripting (XSS)
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Display of data in web page without any encoding or validation
 * Flow Variant: 52 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package juliet.testcases.CWE80_XSS.s01;
import juliet.support.*;

import javax.servlet.http.*;

public class CWE80_XSS__Servlet_getCookies_Servlet_52b
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_getCookies_Servlet_52c()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE80_XSS__Servlet_getCookies_Servlet_52c()).goodG2BSink(data , request, response);
    }
}
