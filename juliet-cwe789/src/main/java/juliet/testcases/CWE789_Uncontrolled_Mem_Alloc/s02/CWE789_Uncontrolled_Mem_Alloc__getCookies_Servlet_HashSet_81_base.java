/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getCookies_Servlet_HashSet_81_base.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: getCookies_Servlet Read data from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashSet
 *    BadSink : Create a HashSet using data as the initial size
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE789_Uncontrolled_Mem_Alloc.s02;
import juliet.support.*;

import javax.servlet.http.*;

public abstract class CWE789_Uncontrolled_Mem_Alloc__getCookies_Servlet_HashSet_81_base
{
    public abstract void action(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
