/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Vera Y. Petrashkova
* @version $Revision$
*/

package org.apache.harmony.security.tests.java.security;

import dalvik.annotation.TestTargetClass;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;

import java.security.KeyException;

import junit.framework.TestCase;
@TestTargetClass(KeyException.class)
/**
 * Tests for <code>KeyException</code> class constructors and methods.
 * 
 */
public class KeyExceptionTest extends TestCase {

    private static String[] msgs = {
            "",
            "Check new message",
            "Check new message Check new message Check new message Check new message Check new message" };

    private static Throwable tCause = new Throwable("Throwable for exception");

    /**
     * Test for <code>KeyException()</code> constructor Assertion: constructs
     * KeyException with no detail message
     */
    @TestTargetNew(
        level = TestLevel.COMPLETE,
        notes = "",
        method = "KeyException",
        args = {}
    )
    public void testKeyException01() {
        KeyException tE = new KeyException();
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>KeyException(String)</code> constructor Assertion:
     * constructs KeyException with detail message msg. Parameter
     * <code>msg</code> is not null.
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class}
    )
    public void testKeyException02() {
        KeyException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new KeyException(msgs[i]);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>KeyException(String)</code> constructor Assertion:
     * constructs KeyException when <code>msg</code> is null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class}
    )
    public void testKeyException03() {
        String msg = null;
        KeyException tE = new KeyException(msg);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>KeyException(Throwable)</code> constructor Assertion:
     * constructs KeyException when <code>cause</code> is null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.Throwable.class}
    )
    public void testKeyException04() {
        Throwable cause = null;
        KeyException tE = new KeyException(cause);
        assertNull("getMessage() must return null.", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>KeyException(Throwable)</code> constructor Assertion:
     * constructs KeyException when <code>cause</code> is not null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.Throwable.class}
    )
    public void testKeyException05() {
        KeyException tE = new KeyException(tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() should contain ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>KeyException(String, Throwable)</code> constructor
     * Assertion: constructs KeyException when <code>cause</code> is null
     * <code>msg</code> is null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class, java.lang.Throwable.class}
    )
    public void testKeyException06() {
        KeyException tE = new KeyException(null, null);
        assertNull("getMessage() must return null", tE.getMessage());
        assertNull("getCause() must return null", tE.getCause());
    }

    /**
     * Test for <code>KeyException(String, Throwable)</code> constructor
     * Assertion: constructs KeyException when <code>cause</code> is null
     * <code>msg</code> is not null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class, java.lang.Throwable.class}
    )
    public void testKeyException07() {
        KeyException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new KeyException(msgs[i], null);
            assertEquals("getMessage() must return: ".concat(msgs[i]), tE
                    .getMessage(), msgs[i]);
            assertNull("getCause() must return null", tE.getCause());
        }
    }

    /**
     * Test for <code>KeyException(String, Throwable)</code> constructor
     * Assertion: constructs KeyException when <code>cause</code> is not null
     * <code>msg</code> is null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class, java.lang.Throwable.class}
    )
    public void testKeyException08() {
        KeyException tE = new KeyException(null, tCause);
        if (tE.getMessage() != null) {
            String toS = tCause.toString();
            String getM = tE.getMessage();
            assertTrue("getMessage() must should ".concat(toS), (getM
                    .indexOf(toS) != -1));
        }
        assertNotNull("getCause() must not return null", tE.getCause());
        assertEquals("getCause() must return ".concat(tCause.toString()), tE
                .getCause(), tCause);
    }

    /**
     * Test for <code>KeyException(String, Throwable)</code> constructor
     * Assertion: constructs KeyException when <code>cause</code> is not null
     * <code>msg</code> is not null
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "",
        method = "KeyException",
        args = {java.lang.String.class, java.lang.Throwable.class}
    )
    public void testKeyException09() {
        KeyException tE;
        for (int i = 0; i < msgs.length; i++) {
            tE = new KeyException(msgs[i], tCause);
            String getM = tE.getMessage();
            String toS = tCause.toString();
            if (msgs[i].length() > 0) {
                assertTrue("getMessage() must contain ".concat(msgs[i]), getM
                        .indexOf(msgs[i]) != -1);
                if (!getM.equals(msgs[i])) {
                    assertTrue("getMessage() should contain ".concat(toS), getM
                            .indexOf(toS) != -1);
                }
            }
            assertNotNull("getCause() must not return null", tE.getCause());
            assertEquals("getCause() must return ".concat(tCause.toString()),
                    tE.getCause(), tCause);
        }
    }
}