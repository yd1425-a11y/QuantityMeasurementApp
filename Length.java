package com.apps.quantitymeasurement;

/**
 * UC6: Addition of Two Length Units.
 * This class handles measurements and arithmetic while preserving immutability.
 */
public class Length {
    private final double value;
    private final LengthUnit unit;

    /**
     * Enum defining length units and their conversion factors relative to inches.
     */
    public enum LengthUnit {
        FEET(12.0), 
        INCHES(1.0), 
        YARDS(36.0), 
        CENTIMETERS(0.393701); // Approx conversion [cite: 18, 167]

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double toBaseUnit(double val) {
            return val * this.conversionFactor;
        }

        public double fromBaseUnit(double baseVal) {
            return baseVal / this.conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Adds another Length to this instance.
     * The result is expressed in the unit of the first operand (this instance)[cite: 11, 22, 111].
     */
    public Length add(Length thatLength) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Operand cannot be null [cite: 44, 430]");
        }

        // 1. Convert both to base unit (inches) [cite: 36, 217]
        double totalInInches = this.unit.toBaseUnit(this.value) + 
                               thatLength.unit.toBaseUnit(thatLength.value);
        
        // 2. Convert sum back to the unit of the first operand [cite: 38, 218]
        double resultValue = this.unit.fromBaseUnit(totalInInches);
        
        // 3. Round to 2 decimal places for consistency [cite: 219, 231]
        double roundedValue = Math.round(resultValue * 100.0) / 100.0;
        
        return new Length(roundedValue, this.unit); // Returns new object [cite: 39, 41]
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length other = (Length) o;
        // Epsilon-based comparison for floating-point accuracy [cite: 74, 75]
        return Math.abs(this.unit.toBaseUnit(this.value) - 
               other.unit.toBaseUnit(other.value)) < 0.01;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}