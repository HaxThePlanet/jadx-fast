package com.googlecode.mp4parser.g.c;

import java.util.Arrays;

/* compiled from: ScalingMatrix.java */
/* loaded from: classes2.dex */
public class g {

    public f[] a;
    public f[] b;
    public String toString() {
        Object obj;
        Object obj2 = null;
        StringBuilder stringBuilder = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        if (this.a == null) {
        } else {
            java.util.List list = Arrays.asList(this.a);
        }
        stringBuilder.append(obj);
        String str3 = "\n";
        stringBuilder.append(str3);
        stringBuilder.append(", ScalingList8x8=");
        if (this.b != null) {
            java.util.List list2 = Arrays.asList(this.b);
        }
        stringBuilder.append(obj2);
        stringBuilder.append(str3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
