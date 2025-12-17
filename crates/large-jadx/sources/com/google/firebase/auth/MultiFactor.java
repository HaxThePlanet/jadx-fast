package com.google.firebase.auth;

import com.google.android.gms.tasks.j;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MultiFactor {
    public abstract j<Void> enroll(com.google.firebase.auth.MultiFactorAssertion multiFactorAssertion, String string2);

    public abstract List<com.google.firebase.auth.MultiFactorInfo> getEnrolledFactors();

    public abstract j<com.google.firebase.auth.MultiFactorSession> getSession();

    public abstract j<Void> unenroll(com.google.firebase.auth.MultiFactorInfo multiFactorInfo);

    public abstract j<Void> unenroll(String string);
}
