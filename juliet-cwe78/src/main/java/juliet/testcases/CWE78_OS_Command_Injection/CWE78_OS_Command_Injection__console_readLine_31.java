/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__console_readLine_31.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-31.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: console_readLine Read data from the console using readLine()
 * GoodSource: A hardcoded string
 * Sinks: exec
 *    BadSink : dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

package juliet.testcases.CWE78_OS_Command_Injection;

import juliet.support.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.logging.Level;

public class CWE78_OS_Command_Injection__console_readLine_31 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        String dataCopy;
        {
            String data;

            data = ""; /* Initialize data */

            {
                InputStreamReader readerInputStream = null;
                BufferedReader readerBuffered = null;

                /* read user input from console with readLine */
                try
                {
                    readerInputStream = new InputStreamReader(System.in, "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);

                    /* POTENTIAL FLAW: Read data from the console using readLine */
                    data = readerBuffered.readLine();
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    try
                    {
                        if (readerBuffered != null)
                        {
                            readerBuffered.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing BufferedReader", exceptIO);
                    }

                    try
                    {
                        if (readerInputStream != null)
                        {
                            readerInputStream.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing InputStreamReader", exceptIO);
                    }
                }
            }
            /* NOTE: Tools may report a flaw here because buffread and isr are not closed.  Unfortunately, closing those will close System.in, which will cause any future attempts to read from the console to fail and throw an exception */

            dataCopy = data;
        }
        {
            String data = dataCopy;

            String osCommand;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
            }
            else
            {
                /* running on non-Windows */
                osCommand = "/bin/ls ";
            }

            /* POTENTIAL FLAW: command injection */
            Process process = Runtime.getRuntime().exec(osCommand + data);
            process.waitFor();

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String dataCopy;
        {
            String data;

            /* FIX: Use a hardcoded string */
            data = "foo";

            dataCopy = data;
        }
        {
            String data = dataCopy;

            String osCommand;
            if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
            {
                /* running on Windows */
                osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
            }
            else
            {
                /* running on non-Windows */
                osCommand = "/bin/ls ";
            }

            /* POTENTIAL FLAW: command injection */
            Process process = Runtime.getRuntime().exec(osCommand + data);
            process.waitFor();

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
