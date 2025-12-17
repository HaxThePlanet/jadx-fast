package com.google.firebase.auth;

/* loaded from: classes2.dex */
public abstract class ActionCodeEmailInfo extends com.google.firebase.auth.ActionCodeInfo {
    @Override // com.google.firebase.auth.ActionCodeInfo
    public String getEmail() {
        return super.getEmail();
    }

    @Override // com.google.firebase.auth.ActionCodeInfo
    public abstract String getPreviousEmail();
}
