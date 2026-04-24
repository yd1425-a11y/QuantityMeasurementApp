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
        
=======
    public void testAddition_SameUnit_FeetPlusFeet() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        Length result = length1.add(length2);
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        // 1 foot + 12 inches = 2 feet
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = length1.add(length2);

        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {

        // 12.0 INCHES + 1.0 FEET should yield 24.0 INCHES [cite: 1296, 1375]
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);
        Length result = l1.add(l2);
        
=======
        // 12 inches + 1 foot = 24 inches
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length result = length1.add(length2);

        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_Commutativity() {

        // add(A, B) magnitude equals add(B, A) magnitude [cite: 1018, 1390]
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        
        assertTrue(a.add(b).equals(b.add(a)));
=======
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        
        // Sum result depends on the unit of the first operand
        Length res1 = length1.add(length2); // 2.0 FEET
        Length res2 = length2.add(length1); // 24.0 INCHES
        
        // They should still be equal in magnitude
        assertTrue(res1.equals(res2));

    }

    @Test
    public void testAddition_WithZero() {

        // 5.0 FEET + 0.0 INCHES = 5.0 FEET [cite: 1312, 1340]
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);
        
        assertEquals(new Length(5.0, Length.LengthUnit.FEET), l1.add(l2));
=======
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);
        Length result = length1.add(length2);
        assertEquals(new Length(5.0, Length.LengthUnit.FEET), result);

    }

    @Test
    public void testAddition_NegativeValues() {

        // 5.0 FEET + (-2.0) FEET = 3.0 FEET [cite: 1315, 1396]
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
        
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), l1.add(l2));
=======
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);
        Length result = length1.add(length2);
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_NullSecondOperand() {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> {
            length1.add(null);
        });

    }
}