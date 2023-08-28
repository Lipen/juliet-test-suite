/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__listen_tcp_81_base.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-81_base.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE78_OS_Command_Injection;

import juliet.support.*;

import javax.servlet.http.*;

public abstract class CWE78_OS_Command_Injection__listen_tcp_81_base
{
    public abstract void action(String data ) throws Throwable;
}
