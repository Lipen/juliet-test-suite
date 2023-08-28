/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_54e.java
Label Definition File: CWE81_XSS_Error_Message__Servlet.label.xml
Template File: sources-sink-54e.tmpl.java
*/
/*
 * @description
 * CWE: 81 Cross Site Scripting (XSS) in Error Message
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: sendErrorServlet
 *    BadSink : XSS in sendError
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package juliet.testcases.CWE81_XSS_Error_Message;

import juliet.support.*;

import javax.servlet.http.*;

public class CWE81_XSS_Error_Message__Servlet_getQueryString_Servlet_54e
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
            * The built-in J2EE server automatically does some HTML entity encoding.
            * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
            */
            response.sendError(404, "<br>bad() - Parameter name has value " + data);
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        if (data != null)
        {
            /* POTENTIAL FLAW: script code (e.g. id=<script>alert('xss')</script>) is sent to the client;
            * The built-in J2EE server automatically does some HTML entity encoding.
            * Therefore, to test this, change response.sendError to response.getWriter().println and remove the 404,
            */
            response.sendError(404, "<br>bad() - Parameter name has value " + data);
        }

    }
}
