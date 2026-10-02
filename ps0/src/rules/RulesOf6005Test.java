/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Another student's coursework may never be used, even if it is cited
     * and available to the whole class.
     */
    @Test
    public void testCourseworkFromAnotherStudentIsNeverAllowed() {
        assertFalse("Expected false: another student's problem set solution",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * An external (non-coursework) source that is cited and publicly
     * available is allowed when the assignment does not require you to
     * implement it yourself.
     */
    @Test
    public void testCitedAvailableExternalSourceAllowedWhenNotRequiredToImplement() {
        assertTrue("Expected true: cited, available external source, not an implement-it-yourself task",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }

    /**
     * Even a properly cited, publicly available external source may not be
     * used if the assignment specifically requires you to implement it
     * yourself.
     */
    @Test
    public void testExternalSourceNotAllowedWhenImplementationRequired() {
        assertFalse("Expected false: assignment requires your own implementation",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }

    /**
     * An external source that is cited but not available to the rest of
     * the class may not be used.
     */
    @Test
    public void testExternalSourceNotAvailableToOthersIsNotAllowed() {
        assertFalse("Expected false: cited but not available to all students",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
    }
}
