package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzkh extends IOException {
    public zzkh(String string) {
        super(string);
    }

    static com.google.android.gms.internal.measurement.zzkg a() {
        zzkg zzkg = new zzkg("Protocol message tag had invalid wire type.");
        return zzkg;
    }

    static com.google.android.gms.internal.measurement.zzkh b() {
        zzkh zzkh = new zzkh("Protocol message contained an invalid tag (zero).");
        return zzkh;
    }

    static com.google.android.gms.internal.measurement.zzkh c() {
        zzkh zzkh = new zzkh("Protocol message had invalid UTF-8.");
        return zzkh;
    }

    static com.google.android.gms.internal.measurement.zzkh d() {
        zzkh zzkh = new zzkh("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return zzkh;
    }

    static com.google.android.gms.internal.measurement.zzkh e() {
        zzkh zzkh = new zzkh("Failed to parse the message.");
        return zzkh;
    }

    static com.google.android.gms.internal.measurement.zzkh f() {
        zzkh zzkh = new zzkh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return zzkh;
    }
}
