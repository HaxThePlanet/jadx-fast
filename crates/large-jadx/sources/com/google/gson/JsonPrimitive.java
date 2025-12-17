package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes2.dex */
public final class JsonPrimitive extends com.google.gson.JsonElement {

    private final Object value;
    public JsonPrimitive(Boolean boolean) {
        super();
        this.value = .Gson.Preconditions.checkNotNull(boolean);
    }

    public JsonPrimitive(Character character) {
        super();
        this.value = (Character).Gson.Preconditions.checkNotNull(character).toString();
    }

    public JsonPrimitive(Number number) {
        super();
        this.value = .Gson.Preconditions.checkNotNull(number);
    }

    public JsonPrimitive(String string) {
        super();
        this.value = .Gson.Preconditions.checkNotNull(string);
    }

    private static boolean isIntegral(com.google.gson.JsonPrimitive jsonPrimitive) {
        boolean z;
        int i;
        Object obj2;
        obj2 = jsonPrimitive.value;
        i = 0;
        if (obj2 instanceof Number) {
            if (!obj2 instanceof BigInteger && !obj2 instanceof Long && !obj2 instanceof Integer && !obj2 instanceof Short) {
                if (!obj2 instanceof Long) {
                    if (!obj2 instanceof Integer) {
                        if (!obj2 instanceof Short) {
                            if (obj2 instanceof Byte) {
                                i = 1;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonElement deepCopy() {
        return deepCopy();
    }

    @Override // com.google.gson.JsonElement
    public com.google.gson.JsonPrimitive deepCopy() {
        return this;
    }

    @Override // com.google.gson.JsonElement
    public boolean equals(Object object) {
        int i;
        boolean integral;
        Class<com.google.gson.JsonPrimitive> obj;
        boolean z;
        Class class;
        int obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (JsonPrimitive.class != object.getClass()) {
            } else {
                if (this.value == null) {
                    if (object.value == null) {
                    } else {
                        i = i2;
                    }
                    return i;
                }
                if (JsonPrimitive.isIntegral(this) && JsonPrimitive.isIntegral((JsonPrimitive)object)) {
                    if (JsonPrimitive.isIntegral(object)) {
                        if (Long.compare(longValue, longValue2) == 0) {
                        } else {
                            i = i2;
                        }
                        return i;
                    }
                }
                Object value2 = this.value;
                z = value3 instanceof Number;
                double doubleValue = getAsNumber().doubleValue();
                double doubleValue2 = object.getAsNumber().doubleValue();
                if (value2 instanceof Number && z && Double.compare(doubleValue, doubleValue2) != 0) {
                    z = value3 instanceof Number;
                    if (z) {
                        doubleValue = getAsNumber().doubleValue();
                        doubleValue2 = object.getAsNumber().doubleValue();
                        if (Double.compare(doubleValue, doubleValue2) != 0) {
                            if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                                if (Double.isNaN(doubleValue2)) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        }
                        return i;
                    }
                }
            }
            return value2.equals(object.value);
        }
        return i2;
    }

    @Override // com.google.gson.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object bigDecimal;
        boolean string;
        if (bigDecimal instanceof BigDecimal) {
        } else {
            bigDecimal = new BigDecimal(this.value.toString());
        }
        return bigDecimal;
    }

    @Override // com.google.gson.JsonElement
    public BigInteger getAsBigInteger() {
        Object bigInteger;
        boolean string;
        if (bigInteger instanceof BigInteger) {
        } else {
            bigInteger = new BigInteger(this.value.toString());
        }
        return bigInteger;
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        if (isBoolean()) {
            return (Boolean)this.value.booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gson.JsonElement
    public byte getAsByte() {
        byte byteValue;
        if (isNumber()) {
            byteValue = getAsNumber().byteValue();
        } else {
            byteValue = Byte.parseByte(getAsString());
        }
        return byteValue;
    }

    @Override // com.google.gson.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gson.JsonElement
    public double getAsDouble() {
        double doubleValue;
        if (isNumber()) {
            doubleValue = getAsNumber().doubleValue();
        } else {
            doubleValue = Double.parseDouble(getAsString());
        }
        return doubleValue;
    }

    @Override // com.google.gson.JsonElement
    public float getAsFloat() {
        float floatValue;
        if (isNumber()) {
            floatValue = getAsNumber().floatValue();
        } else {
            floatValue = Float.parseFloat(getAsString());
        }
        return floatValue;
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        int intValue;
        if (isNumber()) {
            intValue = getAsNumber().intValue();
        } else {
            intValue = Integer.parseInt(getAsString());
        }
        return intValue;
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        long longValue;
        if (isNumber()) {
            longValue = getAsNumber().longValue();
        } else {
            longValue = Long.parseLong(getAsString());
        }
        return longValue;
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        Object lazilyParsedNumber;
        Object value;
        if (lazilyParsedNumber instanceof String != null) {
            lazilyParsedNumber = new LazilyParsedNumber((String)this.value);
        } else {
        }
        return lazilyParsedNumber;
    }

    @Override // com.google.gson.JsonElement
    public short getAsShort() {
        short shortValue;
        if (isNumber()) {
            shortValue = getAsNumber().shortValue();
        } else {
            shortValue = Short.parseShort(getAsString());
        }
        return shortValue;
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return (Boolean)this.value.toString();
        }
        return (String)this.value;
    }

    @Override // com.google.gson.JsonElement
    public int hashCode() {
        Number asNumber;
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (JsonPrimitive.isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
            return (int)i3;
        } else {
        }
        return value2.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    @Override // com.google.gson.JsonElement
    public boolean isNumber() {
        return value instanceof Number;
    }

    @Override // com.google.gson.JsonElement
    public boolean isString() {
        return value instanceof String;
    }
}
