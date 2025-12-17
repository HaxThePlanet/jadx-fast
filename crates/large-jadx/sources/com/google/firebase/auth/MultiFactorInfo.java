package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class MultiFactorInfo extends a {

    public static final String FACTOR_ID_KEY = "factorIdKey";
    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getDisplayName();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract long getEnrollmentTimestamp();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getFactorId();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract String getUid();

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public abstract JSONObject toJson();
}
