package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        // 1.0 FEET + 12.0 INCHES = 2.0 FEET [cite: 12, 324, 326]
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length result = length1.add(length2);
        
        assertEquals(new Length(2.0, Length.LengthUnit.FEET), result);
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusFeet() {
        // 12.0 INCHES + 1.0 FEET = 24.0 INCHES [cite: 327, 329]
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length result = length1.add(length2);
        
        assertEquals(new Length(24.0, Length.LengthUnit.INCHES), result);
    }

    @Test
    public void testAddition_Commutativity() {
        // add(A, B) should equal add(B, A) in magnitude [cite: 49, 80, 421]
        Length a = new Length(1.0, Length.LengthUnit.FEET);
        Length b = new Length(12.0, Length.LengthUnit.INCHES);
        
        assertTrue(a.add(b).equals(b.add(a)));
    }

    @Test
    public void testAddition_WithZeroValue() {
        // Adding zero should return the original value [cite: 368, 371, 423]
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);
        
        assertEquals(new Length(5.0, Length.LengthUnit.FEET), length1.add(length2));
    }

    @Test
    public void testAddition_NegativeValues() {
        // 5.0 FEET + (-2.0) FEET = 3.0 FEET [cite: 345, 347, 427]
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);
        
        assertEquals(new Length(3.0, Length.LengthUnit.FEET), l1.add(l2));
    }

    @Test
    public void testAddition_NullOperand_ShouldThrowException() {
        // Null inputs result in documented exception [cite: 44, 430]
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> length1.add(null));
    }
}