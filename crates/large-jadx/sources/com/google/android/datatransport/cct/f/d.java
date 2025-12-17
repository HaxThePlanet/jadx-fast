package com.google.android.datatransport.cct.f;

import com.google.firebase.encoders.annotations.Encodable.Field;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class d extends com.google.android.datatransport.cct.f.j {

    private final List<com.google.android.datatransport.cct.f.m> a;
    d(List<com.google.android.datatransport.cct.f.m> list) {
        super();
        Objects.requireNonNull(list, "Null logRequests");
        this.a = list;
    }

    @Encodable$Field(name = "logRequest")
    public List<com.google.android.datatransport.cct.f.m> c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.f.j
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof j) {
            return this.a.equals((j)object.c());
        }
        return 0;
    }

    @Override // com.google.android.datatransport.cct.f.j
    public int hashCode() {
        return i ^= i3;
    }

    @Override // com.google.android.datatransport.cct.f.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BatchedLogRequest{logRequests=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
