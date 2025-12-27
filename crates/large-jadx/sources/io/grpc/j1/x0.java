package io.grpc.j1;

import java.util.ArrayList;

/* compiled from: InsightBuilder.java */
/* loaded from: classes3.dex */
public final class x0 {

    private final ArrayList<String> a = new ArrayList<>();
    public x0() {
        super();
        final ArrayList arrayList = new ArrayList();
    }

    public x0 a(Object object) {
        this.a.add(String.valueOf(object));
        return this;
    }

    public x0 b(String str, Object object) {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = "=";
        str3 = str + str2 + object;
        this.a.add(str3);
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
