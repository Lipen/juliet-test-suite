/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE23_Relative_Path_Traversal__getQueryString_Servlet_54d.java
Label Definition File: CWE23_Relative_Path_Traversal.label.xml
Template File: sources-sink-54d.tmpl.java
*/
/*
 * @description
 * CWE: 23 Relative Path Traversal
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : no validation
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package juliet.testcases.CWE23_Relative_Path_Traversal;

import juliet.support.*;

import java.io.*;
import javax.servlet.http.*;

public class CWE23_Relative_Path_Traversal__getQueryString_Servlet_54d
{
    public void badSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__getQueryString_Servlet_54e()).badSink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE23_Relative_Path_Traversal__getQueryString_Servlet_54e()).goodG2BSink(data , request, response);
    }
}
