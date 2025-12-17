package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum p1 {

    DOUBLE(field_1, true),
    FLOAT("DOUBLE", 5),
    INT64("FLOAT", false),
    UINT64("FLOAT", false),
    INT32(field_11, false),
    FIXED64("FLOAT", true),
    FIXED32(field_11, 5),
    BOOL(4, false),
    STRING(4, 2),
    GROUP(4, 3),
    MESSAGE(4, 5),
    BYTES(4, 5),
    UINT32(field_11, false),
    ENUM(4, false),
    SFIXED32(field_11, 2),
    SFIXED64("FLOAT", false),
    SINT32(field_11, 5),
    SINT64("FLOAT", 5);

    private final com.google.android.gms.internal.firebase-auth-api.q1 zzt;
    @Override // java.lang.Enum
    public final com.google.android.gms.internal.firebase-auth-api.q1 zza() {
        return this.zzt;
    }
}
