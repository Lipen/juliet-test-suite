/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__connect_tcp_executeBatch_16.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-16.tmpl.java
*/
/*
* @description
* CWE: 89 SQL Injection
* BadSource: connect_tcp Read data using an outbound tcp connection
* GoodSource: A hardcoded string
* Sinks: executeBatch
*    GoodSink: Use prepared statement and executeBatch (properly)
*    BadSink : data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection
* Flow Variant: 16 Control flow: while(true)
*
* */

package juliet.testcases.CWE89_SQL_Injection.s01;
import juliet.support.*;

import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

import java.util.logging.Level;

import java.sql.*;


public class CWE89_SQL_Injection__connect_tcp_executeBatch_16 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        String data;

        while (true)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    socket = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = readerBuffered.readLine();
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* clean up stream reading objects */
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

                    /* clean up socket objects */
                    try
                    {
                        if (socket != null)
                        {
                            socket.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                    }
                }
            }
            break;
        }

        while (true)
        {
            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                Statement sqlStatement = null;
                try
                {
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.createStatement();
                    for (int i = 0; i < names.length; i++)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection */
                        sqlStatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                    }
                }
            }
            break;
        }
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        while (true)
        {
            /* FIX: Use a hardcoded string */
            data = "foo";
            break;
        }

        while (true)
        {
            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                Statement sqlStatement = null;
                try
                {
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.createStatement();
                    for (int i = 0; i < names.length; i++)
                    {
                        /* POTENTIAL FLAW: data concatenated into SQL statement used in executeBatch(), which could result in SQL Injection */
                        sqlStatement.addBatch("update users set hitcount=hitcount+1 where name='" + names[i] + "'");
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Statament", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                    }
                }
            }
            break;
        }

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data;

        while (true)
        {
            data = ""; /* Initialize data */
            /* Read data using an outbound tcp connection */
            {
                Socket socket = null;
                BufferedReader readerBuffered = null;
                InputStreamReader readerInputStream = null;
                try
                {
                    /* Read data using an outbound tcp connection */
                    socket = new Socket("host.example.org", 39544);
                    /* read input from socket */
                    readerInputStream = new InputStreamReader(socket.getInputStream(), "UTF-8");
                    readerBuffered = new BufferedReader(readerInputStream);
                    /* POTENTIAL FLAW: Read data using an outbound tcp connection */
                    data = readerBuffered.readLine();
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
                }
                finally
                {
                    /* clean up stream reading objects */
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

                    /* clean up socket objects */
                    try
                    {
                        if (socket != null)
                        {
                            socket.close();
                        }
                    }
                    catch (IOException exceptIO)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Socket", exceptIO);
                    }
                }
            }
            break;
        }

        while (true)
        {
            if (data != null)
            {
                String names[] = data.split("-");
                int successCount = 0;
                Connection dbConnection = null;
                PreparedStatement sqlStatement = null;
                try
                {
                    /* FIX: Use prepared statement and executeBatch (properly) */
                    dbConnection = IO.getDBConnection();
                    sqlStatement = dbConnection.prepareStatement("update users set hitcount=hitcount+1 where name=?");
                    for (int i = 0; i < names.length; i++)
                    {
                        sqlStatement.setString(1, names[i]);
                        sqlStatement.addBatch();
                    }
                    int resultsArray[] = sqlStatement.executeBatch();
                    for (int i = 0; i < names.length; i++)
                    {
                        if (resultsArray[i] > 0)
                        {
                            successCount++;
                        }
                    }
                    IO.writeLine("Succeeded in " + successCount + " out of " + names.length + " queries.");
                }
                catch (SQLException exceptSql)
                {
                    IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
                }
                finally
                {
                    try
                    {
                        if (sqlStatement != null)
                        {
                            sqlStatement.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
                    }

                    try
                    {
                        if (dbConnection != null)
                        {
                            dbConnection.close();
                        }
                    }
                    catch (SQLException exceptSql)
                    {
                        IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
                    }
                }
            }
            break;
        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
