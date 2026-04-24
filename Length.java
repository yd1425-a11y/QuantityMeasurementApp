package com.apps.quantitymeasurement;

import java.util.Objects;

/**

 * UC6: Addition of Two Length Units.
 * Results are expressed in the unit of the first operand[cite: 980, 1080].
=======
 * Use Case 6: Add two quantities of the same category.
 * The result is returned in the unit of the first operand.

 */
public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {

        // conversionFactor relative to the base unit (Inches) [cite: 987, 1005]
=======

        FEET(12.0), 
        INCHES(1.0), 
        YARDS(36.0), 
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }


        public double toBase(double val) { return val * this.conversionFactor; }
        public double fromBase(double val) { return val / this.conversionFactor; }
=======
        public double toBaseUnit(double value) {
            return value * conversionFactor;
        }

        public double fromBaseUnit(double valueInInches) {
            return valueInInches / conversionFactor;
        }

    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
 feat/uc7
     * Main Flow:
     * 1. Convert to base unit (Inches)[cite: 1186].
     * 2. Sum the values[cite: 1006].
     * 3. Convert sum back to first operand's unit[cite: 1007, 1187].
     * 4. Round to 2 decimal places[cite: 1188, 1201].
     */
    public Length add(Length that) {
        if (that == null) {
            throw new IllegalArgumentException("Operand cannot be null [cite: 1399]");
        }
        
        // Step 1 & 2: Sum in base unit
        double sumInInches = this.unit.toBase(this.value) + that.unit.toBase(that.value);
        
        // Step 3 & 4: Convert back and round
        double resultValue = this.unit.fromBase(sumInInches);
        double roundedValue = Math.round(resultValue * 100.0) / 100.0;
        
        return new Length(roundedValue, this.unit);
=======
     * Adds another length to this length.
     * 1. Convert both to base unit (inches).
     * 2. Sum values.
     * 3. Convert back to this instance's unit.
     */
    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Operand cannot be null");
        }
        double totalInInches = this.unit.toBaseUnit(this.value) + 
                               thatLength.unit.toBaseUnit(thatLength.value);
        
        double resultValue = this.unit.fromBaseUnit(totalInInches);
        // Rounding to two decimal places as per requirements
        resultValue = Math.round(resultValue * 100.0) / 100.0;
        
        return new Length(resultValue, this.unit);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length other = (Length) o;
        // Use epsilon-based comparison for floating point accuracy [cite: 1043]
        return Math.abs(this.unit.toBase(this.value) - other.unit.toBase(other.value)) < 0.01;
=======
        Length length = (Length) o;
        return Math.abs(this.unit.toBaseUnit(this.value) - 
               length.unit.toBaseUnit(length.value)) < 0.01;
dev
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
 feat/uc7
=======
}

/**
 * Static application class to demonstrate addition functionality.
 */
class QuantityMeasurementApp {
    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

}