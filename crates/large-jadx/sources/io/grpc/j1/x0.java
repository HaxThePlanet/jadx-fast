package io.grpc.j1;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class x0 {

    private final ArrayList<String> a;
    public x0() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public io.grpc.j1.x0 a(Object object) {
        this.a.add(String.valueOf(object));
        return this;
    }

    public io.grpc.j1.x0 b(String string, Object object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("=");
        stringBuilder.append(object2);
        this.a.add(stringBuilder.toString());
        return this;
    }

    public String toString() {
        return this.a.toString();
    }
}
