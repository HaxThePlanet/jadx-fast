package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public enum n0 {

    ADD(false),
    AND(true),
    APPLY(2),
    ASSIGN(3),
    BITWISE_AND(56),
    BITWISE_LEFT_SHIFT(57),
    BITWISE_NOT(58),
    BITWISE_OR(59),
    BITWISE_RIGHT_SHIFT(60),
    BITWISE_UNSIGNED_RIGHT_SHIFT(2),
    BITWISE_XOR(false),
    BLOCK(2),
    BREAK(4),
    CASE(5),
    CONST(59),
    CONTINUE(6),
    CONTROL(59),
    CREATE_ARRAY(7),
    CREATE_OBJECT(8),
    DEFAULT(3),
    DEFINE_FUNCTION(59),
    DIVIDE(true),
    DO(false),
    EQUALS(60),
    EXPRESSION_LIST(4),
    FN(59),
    FOR_IN(59),
    FOR_IN_CONST(59),
    FOR_IN_LET(59),
    FOR_LET(59),
    FOR_OF(59),
    FOR_OF_CONST(59),
    FOR_OF_LET(59),
    GET(59),
    GET_CONTAINER_VARIABLE(59),
    GET_INDEX(59),
    GET_PROPERTY(59),
    GREATER_THAN(59),
    GREATER_THAN_EQUALS(59),
    IDENTITY_EQUALS(59),
    IDENTITY_NOT_EQUALS(59),
    IF(59),
    LESS_THAN(59),
    LESS_THAN_EQUALS(59),
    MODULUS(59),
    MULTIPLY(59),
    NEGATE(59),
    NOT(59),
    NOT_EQUALS(59),
    NULL(59),
    OR(59),
    PLUS_EQUALS(59),
    POST_DECREMENT(59),
    POST_INCREMENT(5),
    QUOTE(59),
    PRE_DECREMENT(59),
    PRE_INCREMENT(5),
    RETURN(5),
    SET_PROPERTY(5),
    SUBTRACT(5),
    SWITCH(5),
    TERNARY(5),
    TYPEOF(5),
    UNDEFINED(59),
    VAR(59),
    WHILE(59);

    private final int zzaq;
    public static com.google.android.gms.internal.measurement.n0 zza(int i) {
        return (n0)n0.zzao.get(Integer.valueOf(i));
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.valueOf(this.zzaq).toString();
    }

    @Override // java.lang.Enum
    public final Integer zzb() {
        return Integer.valueOf(this.zzaq);
    }
}
