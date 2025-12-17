package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzaae extends IOException {

    private com.google.android.gms.internal.firebase-auth-api.y zza = null;
    public zzaae(IOException iOException) {
        super(iOException.getMessage(), iOException);
        final int obj2 = 0;
    }

    public zzaae(String string) {
        super(string);
        final int obj1 = 0;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaad a() {
        zzaad zzaad = new zzaad("Protocol message tag had invalid wire type.");
        return zzaad;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae b() {
        zzaae zzaae = new zzaae("Protocol message end-group tag did not match expected tag.");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae c() {
        zzaae zzaae = new zzaae("Protocol message contained an invalid tag (zero).");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae d() {
        zzaae zzaae = new zzaae("Protocol message had invalid UTF-8.");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae e() {
        zzaae zzaae = new zzaae("CodedInputStream encountered a malformed varint.");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae f() {
        zzaae zzaae = new zzaae("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae g() {
        zzaae zzaae = new zzaae("Failed to parse the message.");
        return zzaae;
    }

    static com.google.android.gms.internal.firebase-auth-api.zzaae i() {
        zzaae zzaae = new zzaae("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return zzaae;
    }

    @Override // java.io.IOException
    public final com.google.android.gms.internal.firebase-auth-api.zzaae h(com.google.android.gms.internal.firebase-auth-api.y y) {
        this.zza = y;
        return this;
    }
}
