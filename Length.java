package com.apps.quantitymeasurement;

import java.util.Objects;

/**
 * Use Case 6: Add two quantities of the same category.
 * The result is returned in the unit of the first operand.
 */
public class Length {
    private final double value;
    private final LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0), 
        INCHES(1.0), 
        YARDS(36.0), 
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

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
        Length length = (Length) o;
        return Math.abs(this.unit.toBaseUnit(this.value) - 
               length.unit.toBaseUnit(length.value)) < 0.01;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
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