package com.googlecode.mp4parser.g.c;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class g {

    public com.googlecode.mp4parser.g.c.f[] a;
    public com.googlecode.mp4parser.g.c.f[] b;
    public String toString() {
        int list;
        java.util.List list2;
        StringBuilder stringBuilder = new StringBuilder("ScalingMatrix{ScalingList4x4=");
        com.googlecode.mp4parser.g.c.f[] objArr = this.a;
        if (objArr == null) {
            list = list2;
        } else {
            list = Arrays.asList(objArr);
        }
        stringBuilder.append(list);
        String str2 = "\n";
        stringBuilder.append(str2);
        stringBuilder.append(", ScalingList8x8=");
        com.googlecode.mp4parser.g.c.f[] objArr2 = this.b;
        if (objArr2 == null) {
        } else {
            list2 = Arrays.asList(objArr2);
        }
        stringBuilder.append(list2);
        stringBuilder.append(str2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
