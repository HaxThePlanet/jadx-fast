package com.facebook.e0.w;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0014", d2 = {"Lcom/facebook/appevents/ml/MTensor;", "", "shape", "", "([I)V", "capacity", "", "<set-?>", "", "data", "getData", "()[F", "shapeSize", "getShapeSize", "()I", "getShape", "i", "reshape", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    public static final com.facebook.e0.w.a.a d;
    private int a;
    private float[] b;
    private int[] c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007", d2 = {"Lcom/facebook/appevents/ml/MTensor$Companion;", "", "()V", "getCapacity", "", "shape", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final int a(com.facebook.e0.w.a.a a$a, int[] i2Arr2) {
            return a.b(i2Arr2);
        }

        private final int b(int[] iArr) {
            int i3;
            int i;
            int i2;
            int i4;
            int i5 = 0;
            i2 = 1;
            i3 = iArr.length == 0 ? i2 : i5;
            if (i3 != 0) {
            } else {
                i = iArr[i5];
                int i6 = i.A(iArr);
                if (i2 <= i6) {
                }
                return i;
            }
            UnsupportedOperationException obj5 = new UnsupportedOperationException("Empty array can't be reduced.");
            throw obj5;
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.d = aVar;
    }

    public a(int[] iArr) {
        n.f(iArr, "shape");
        super();
        this.c = iArr;
        int obj2 = a.a.a(a.d, iArr);
        this.a = obj2;
        this.b = new float[obj2];
    }

    public final float[] a() {
        return this.b;
    }

    public final int b(int i) {
        return this.c[i];
    }

    public final int c() {
        return iArr.length;
    }

    public final void d(int[] iArr) {
        n.f(iArr, "shape");
        this.c = iArr;
        final int obj5 = a.a.a(a.d, iArr);
        float[] fArr = new float[obj5];
        final int i3 = 0;
        System.arraycopy(this.b, i3, fArr, i3, Math.min(this.a, obj5));
        this.b = fArr;
        this.a = obj5;
    }
}
