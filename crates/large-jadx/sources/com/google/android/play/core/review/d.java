package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;

/* loaded from: classes2.dex */
final class d extends com.google.android.play.core.review.ReviewInfo {

    private final PendingIntent a;
    private final boolean b;
    d(PendingIntent pendingIntent, boolean z2) {
        super();
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.a = pendingIntent;
        this.b = z2;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    final PendingIntent a() {
        return this.a;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    final boolean b() {
        return this.b;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final boolean equals(Object object) {
        boolean equals;
        PendingIntent intent;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof ReviewInfo && this.a.equals((ReviewInfo)object.a()) && this.b == object.b()) {
            if (this.a.equals((ReviewInfo)object.a())) {
                if (this.b == object.b()) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final int hashCode() {
        int i;
        int i6 = 1000003;
        i = 1 != this.b ? 1237 : 1231;
        return i4 ^= i;
    }

    @Override // com.google.android.play.core.review.ReviewInfo
    public final String toString() {
        String valueOf = String.valueOf(this.a);
        StringBuilder stringBuilder = new StringBuilder(length += 40);
        stringBuilder.append("ReviewInfo{pendingIntent=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", isNoOp=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
