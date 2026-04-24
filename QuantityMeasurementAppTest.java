package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        // 1.0 FEET + 12.0 INCHES should yield 2.0 FEET [cite: 981, 1294]
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = l1.add(l2);
        
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        // 12.0 INCHES + 1.0 FEET should yield 24.0 INCHES [cite: 1296, 1375]
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        Length result = l1.add(l2);
        
        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_Commutativity() {
        // add(A, B) magnitude equals add(B, A) magnitude [cite: 1018, 1390]
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        
        assertTrue(a.add(b).equals(b.add(a)));
    }

    @Test
    public void testAddition_WithZero() {
        // 5.0 FEET + 0.0 INCHES = 5.0 FEET [cite: 1312, 1340]
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);
        
        assertEquals(new Length(5.0, Length.LengthUnit.FEET), l1.add(l2));
    }

    @Test
    public void testAddition_NegativeValues() {
        // 5.0 FEET + (-2.0) FEET = 3.0 FEET [cite: 1315, 1396]
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
        
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), l1.add(l2));
    }
}