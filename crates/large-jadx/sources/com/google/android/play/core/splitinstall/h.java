package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import java.util.List;

/* loaded from: classes2.dex */
final class h extends com.google.android.play.core.splitinstall.d {

    private final int a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final List<String> f;
    private final List<String> g;
    private final PendingIntent h;
    private final List<Intent> i;
    h(int i, int i2, int i3, long l4, long l5, List<String> list6, List<String> list7, PendingIntent pendingIntent8, List<Intent> list9) {
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = l4;
        this.e = list6;
        this.f = pendingIntent8;
        this.g = list9;
        this.h = obj10;
        this.i = obj11;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final long a() {
        return this.d;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int c() {
        return this.c;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final boolean equals(Object object) {
        boolean equals;
        List i;
        long l;
        boolean obj8;
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (object instanceof d && this.a == (d)object.h() && this.b == object.i() && this.c == object.c() && Long.compare(i, l) == 0 && Long.compare(i, l) == 0) {
            if (this.a == (d)object.h()) {
                if (this.b == object.i()) {
                    if (this.c == object.c()) {
                        if (Long.compare(i, l) == 0) {
                            if (Long.compare(i, l) == 0) {
                                List list = this.f;
                                if (list == null) {
                                    if (object.l() == null) {
                                        List list2 = this.g;
                                        if (list2 == null) {
                                            if (object.k() == null) {
                                                PendingIntent intent = this.h;
                                                if (intent == null) {
                                                    if (object.g() == null) {
                                                        equals = this.i;
                                                        if (equals == null) {
                                                            if (object.m() == null) {
                                                            }
                                                        } else {
                                                            if (!equals.equals(object.m())) {
                                                            }
                                                        }
                                                        return i2;
                                                    }
                                                } else {
                                                    if (intent.equals(object.g())) {
                                                    }
                                                }
                                            }
                                        } else {
                                            if (list2.equals(object.k())) {
                                            }
                                        }
                                    }
                                } else {
                                    if (list.equals(object.l())) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    @Deprecated
    public final PendingIntent g() {
        return this.h;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int h() {
        return this.a;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int hashCode() {
        int i2;
        int i;
        int i3;
        int i4;
        final long l = this.d;
        final long l2 = this.e;
        final int i31 = 1000003;
        int i24 = 32;
        List list = this.f;
        i4 = 0;
        if (list == null) {
            i2 = i4;
        } else {
            i2 = list.hashCode();
        }
        List list2 = this.g;
        if (list2 == null) {
            i = i4;
        } else {
            i = list2.hashCode();
        }
        PendingIntent intent = this.h;
        if (intent == null) {
            i3 = i4;
        } else {
            i3 = intent.hashCode();
        }
        List list3 = this.i;
        if (list3 == null) {
        } else {
            i4 = list3.hashCode();
        }
        return i21 ^= i4;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final int i() {
        return this.b;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final long j() {
        return this.e;
    }

    final List<String> k() {
        return this.g;
    }

    final List<String> l() {
        return this.f;
    }

    final List<Intent> m() {
        return this.i;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final String toString() {
        Object obj = this;
        String valueOf = String.valueOf(obj.f);
        String valueOf2 = String.valueOf(obj.g);
        String valueOf3 = String.valueOf(obj.h);
        String valueOf4 = String.valueOf(obj.i);
        StringBuilder stringBuilder = new StringBuilder(i6 += length4);
        stringBuilder.append("SplitInstallSessionState{sessionId=");
        stringBuilder.append(obj.a);
        stringBuilder.append(", status=");
        stringBuilder.append(obj.b);
        stringBuilder.append(", errorCode=");
        stringBuilder.append(obj.c);
        stringBuilder.append(", bytesDownloaded=");
        stringBuilder.append(obj.d);
        stringBuilder.append(", totalBytesToDownload=");
        stringBuilder.append(obj.e);
        stringBuilder.append(", moduleNamesNullable=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", languagesNullable=");
        stringBuilder.append(valueOf2);
        stringBuilder.append(", resolutionIntent=");
        stringBuilder.append(valueOf3);
        stringBuilder.append(", splitFileIntents=");
        stringBuilder.append(valueOf4);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
