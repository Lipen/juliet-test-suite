/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__PropertiesFile_42.java
Label Definition File: CWE90_LDAP_Injection.label.xml
Template File: sources-sink-42.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * BadSink:  data concatenated into LDAP search, which could result in LDAP Injection
 * Flow Variant: 42 Data flow: data returned from one method to another in the same class
 *
 * */

package juliet.testcases.CWE90_LDAP_Injection;

import juliet.support.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

import javax.naming.*;
import javax.naming.directory.*;

import java.util.Hashtable;

public class CWE90_LDAP_Injection__PropertiesFile_42 extends AbstractTestCase
{
    private String badSource() throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        return data;
    }

    /* use badsource and badsink */
    public void bad() throws Throwable
    {
        String data = badSource();

        Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
        environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext directoryContext = null;

        try
        {
            directoryContext = new InitialDirContext(environmentHashTable);
            /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
            String search = "(cn=" + data + ")";

            NamingEnumeration<SearchResult> answer = directoryContext.search("", search, null);
            while (answer.hasMore())
            {
                SearchResult searchResult = answer.next();
                Attributes attributes = searchResult.getAttributes();
                NamingEnumeration<?> allAttributes = attributes.getAll();
                while (allAttributes.hasMore())
                {
                    Attribute attribute = (Attribute) allAttributes.next();
                    NamingEnumeration<?> allValues = attribute.getAll();
                    while(allValues.hasMore())
                    {
                        IO.writeLine(" Value: " + allValues.next().toString());
                    }
                }
            }
        }
        catch (NamingException exceptNaming)
        {
            IO.logger.log(Level.WARNING, "The LDAP service was not found or login failed.", exceptNaming);
        }
        finally
        {
            if (directoryContext != null)
            {
                try
                {
                    directoryContext.close();
                }
                catch (NamingException exceptNaming)
                {
                    IO.logger.log(Level.WARNING, "Error closing DirContext", exceptNaming);
                }
            }
        }

    }

    private String goodG2BSource() throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data = goodG2BSource();

        Hashtable<String, String> environmentHashTable = new Hashtable<String, String>();
        environmentHashTable.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        environmentHashTable.put(Context.PROVIDER_URL, "ldap://localhost:389");
        DirContext directoryContext = null;

        try
        {
            directoryContext = new InitialDirContext(environmentHashTable);
            /* POTENTIAL FLAW: data concatenated into LDAP search, which could result in LDAP Injection */
            String search = "(cn=" + data + ")";

            NamingEnumeration<SearchResult> answer = directoryContext.search("", search, null);
            while (answer.hasMore())
            {
                SearchResult searchResult = answer.next();
                Attributes attributes = searchResult.getAttributes();
                NamingEnumeration<?> allAttributes = attributes.getAll();
                while (allAttributes.hasMore())
                {
                    Attribute attribute = (Attribute) allAttributes.next();
                    NamingEnumeration<?> allValues = attribute.getAll();
                    while(allValues.hasMore())
                    {
                        IO.writeLine(" Value: " + allValues.next().toString());
                    }
                }
            }
        }
        catch (NamingException exceptNaming)
        {
            IO.logger.log(Level.WARNING, "The LDAP service was not found or login failed.", exceptNaming);
        }
        finally
        {
            if (directoryContext != null)
            {
                try
                {
                    directoryContext.close();
                }
                catch (NamingException exceptNaming)
                {
                    IO.logger.log(Level.WARNING, "Error closing DirContext", exceptNaming);
                }
            }
        }

    }

    public void good() throws Throwable
    {
        goodG2B();
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
