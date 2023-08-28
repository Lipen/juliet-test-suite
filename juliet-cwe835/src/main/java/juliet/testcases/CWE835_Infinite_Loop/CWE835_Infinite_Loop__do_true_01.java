/*
 * @description Infinite loop - do{}while(true)
 *
 * */

package juliet.testcases.CWE835_Infinite_Loop;

import juliet.support.*;

public class CWE835_Infinite_Loop__do_true_01 extends AbstractTestCase 
{
    
    public void bad()
    {
        int i = 0;
    
        /* FLAW: Infinite Loop - do{}while(true)with no break point */
        do 
        {
            IO.writeLine(i);
            i++;
        } while(true);
    }
    
    private void good1() 
    {
        int i = 0;

        do 
        {
            /* FIX: Add a break point for the loop if i = 10 */
            if (i == 10) 
            { 
                break; 
            }
            
            IO.writeLine(i);
            i++;
        } while(true);
    }
    
    public void good()  
    {
        good1();
    }    
    
    /* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the juliet.testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */ 
    public static void main(String[] args) 
            throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        mainFromParent(args);
    }
}
