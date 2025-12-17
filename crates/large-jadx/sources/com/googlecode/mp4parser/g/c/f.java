package com.googlecode.mp4parser.g.c;

import com.googlecode.mp4parser.g.d.b;

/* loaded from: classes2.dex */
public class f {

    public int[] a;
    public boolean b;
    public static com.googlecode.mp4parser.g.c.f a(b b, int i2) {
        int i3;
        int i4;
        int i;
        int[] iArr;
        f fVar = new f();
        fVar.a = new int[i2];
        int i5 = 0;
        i = i5;
        i4 = i3;
        while (i >= i2) {
            if (i3 != 0) {
            }
            iArr = fVar.a;
            if (i3 == 0) {
            } else {
            }
            i4 = i3;
            iArr[i] = i4;
            i4 = iArr[i];
            i++;
            if (i == 0 && i8 %= 256 == 0) {
            } else {
            }
            iArr = i5;
            fVar.b = iArr;
            if (i8 %= 256 == 0) {
            } else {
            }
            iArr = 1;
        }
        return fVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ScalingList{scalingList=");
        stringBuilder.append(this.a);
        stringBuilder.append(", useDefaultScalingMatrixFlag=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
