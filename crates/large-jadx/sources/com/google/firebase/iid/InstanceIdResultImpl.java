package com.google.firebase.iid;

/* loaded from: classes2.dex */
final class InstanceIdResultImpl implements com.google.firebase.iid.InstanceIdResult {

    private final String id;
    private final String token;
    InstanceIdResultImpl(String string, String string2) {
        super();
        this.id = string;
        this.token = string2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getId() {
        return this.id;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getToken() {
        return this.token;
    }
}
