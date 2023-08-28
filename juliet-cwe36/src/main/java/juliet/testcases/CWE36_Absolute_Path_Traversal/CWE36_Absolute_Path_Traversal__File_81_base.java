/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE36_Absolute_Path_Traversal__File_81_base.java
Label Definition File: CWE36_Absolute_Path_Traversal.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 36 Absolute Path Traversal
 * BadSource: File Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: readFile
 *    BadSink : read line from file from disk
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE36_Absolute_Path_Traversal;

import juliet.support.*;

import java.io.*;
import javax.servlet.http.*;

public abstract class CWE36_Absolute_Path_Traversal__File_81_base
{
    public abstract void action(String data ) throws Throwable;
}
