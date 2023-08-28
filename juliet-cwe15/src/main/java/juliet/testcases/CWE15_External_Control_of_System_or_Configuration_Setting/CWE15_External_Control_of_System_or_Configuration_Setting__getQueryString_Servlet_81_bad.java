/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE15_External_Control_of_System_or_Configuration_Setting__getQueryString_Servlet_81_bad.java
Label Definition File: CWE15_External_Control_of_System_or_Configuration_Setting.label.xml
Template File: sources-sink-81_bad.tmpl.java
*/
/*
 * @description
 * CWE: 15 External Control of System or Configuration Setting
 * BadSource: getQueryString_Servlet Parse id param out of the URL query string (without using getParameter())
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : Set the catalog name with the value of data
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package juliet.testcases.CWE15_External_Control_of_System_or_Configuration_Setting;

import juliet.support.*;

import javax.servlet.http.*;

import java.sql.*;

import java.util.logging.Level;

public class CWE15_External_Control_of_System_or_Configuration_Setting__getQueryString_Servlet_81_bad extends CWE15_External_Control_of_System_or_Configuration_Setting__getQueryString_Servlet_81_base
{
    public void action(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Connection dbConnection = null;

        try
        {
            dbConnection = IO.getDBConnection();

            /* POTENTIAL FLAW: Set the catalog name with the value of data
             * allowing a nonexistent catalog name or unauthorized access to a portion of the DB */
            dbConnection.setCatalog(data);
        }
        catch (SQLException exceptSql)
        {
            IO.logger.log(Level.WARNING, "Error getting database connection", exceptSql);
        }
        finally
        {
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
}
