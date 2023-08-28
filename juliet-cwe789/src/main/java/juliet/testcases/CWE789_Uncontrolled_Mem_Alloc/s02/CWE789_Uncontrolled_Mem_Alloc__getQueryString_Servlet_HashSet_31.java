/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getQueryString_Servlet_HashSet_31.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashSet
 *    BadSink : Create a HashSet using data as the initial size
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package juliet.testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import juliet.support.*;

import javax.servlet.http.*;


import java.util.StringTokenizer;
import java.util.logging.Level;

import java.util.HashSet;

public class CWE789_Uncontrolled_Mem_Alloc__getQueryString_Servlet_HashSet_31 extends AbstractTestCaseServlet
{
    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int dataCopy;
        {
            int data;

            data = Integer.MIN_VALUE; /* initialize data in case id is not in query string */

            /* POTENTIAL FLAW: Parse id param out of the URL querystring (without using getParam) */
            {
                StringTokenizer tokenizer = new StringTokenizer(request.getQueryString(), "&");

                while (tokenizer.hasMoreTokens())
                {
                    String token = tokenizer.nextToken(); /* a token will be like "id=33" */
                    if(token.startsWith("id=")) /* check if we have the "id" parameter" */
                    {
                        try
                        {
                            data = Integer.parseInt(token.substring(3)); /* set data to the int 33 */
                        }
                        catch(NumberFormatException exceptNumberFormat)
                        {
                            IO.logger.log(Level.WARNING, "Number format exception reading id from query string", exceptNumberFormat);
                        }
                        break; /* exit while loop */
                    }
                }
            }

            dataCopy = data;
        }
        {
            int data = dataCopy;

            /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
            HashSet intHashSet = new HashSet(data);

        }
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int dataCopy;
        {
            int data;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            dataCopy = data;
        }
        {
            int data = dataCopy;

            /* POTENTIAL FLAW: Create a HashSet using data as the initial size.  data may be very large, creating memory issues */
            HashSet intHashSet = new HashSet(data);

        }
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
