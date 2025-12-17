package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0087@\u0018\u0000 G2\u00020\u0001:\u0001GB\u0011\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086\n¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020 2\u0006\u0010!\u001a\u00020 ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u0015\u0010\u001b\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\u0008\u001e\u0010%J\r\u0010&\u001a\u00020\u0018¢\u0006\u0004\u0008'\u0010\u001aJ\u0015\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\u0008*\u0010+J\u0015\u0010,\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\u0008-\u0010+J\u0015\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u000e¢\u0006\u0004\u0008/\u0010+J+\u00100\u001a\u00020\u00182\u0008\u0008\u0002\u00101\u001a\u00020\u000e2\u0008\u0008\u0002\u00102\u001a\u00020\u000e2\u0008\u0008\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\u00084\u00105J(\u00106\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u000eH\u0086\n¢\u0006\u0004\u00088\u00109J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u001b\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008@\u0010=J\u000f\u0010A\u001a\u00020BH\u0016¢\u0006\u0004\u0008C\u0010DJ+\u0010E\u001a\u00020\u00182\u0008\u0008\u0002\u00101\u001a\u00020\u000e2\u0008\u0008\u0002\u00102\u001a\u00020\u000e2\u0008\u0008\u0002\u00103\u001a\u00020\u000e¢\u0006\u0004\u0008F\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006H", d2 = {"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Matrix {

    public static final androidx.compose.ui.graphics.Matrix.Companion Companion = null;
    public static final int Perspective0 = 3;
    public static final int Perspective1 = 7;
    public static final int Perspective2 = 15;
    public static final int ScaleX = 0;
    public static final int ScaleY = 5;
    public static final int ScaleZ = 10;
    public static final int SkewX = 4;
    public static final int SkewY = 1;
    public static final int TranslateX = 12;
    public static final int TranslateY = 13;
    public static final int TranslateZ = 14;
    private final float[] values;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/compose/ui/graphics/Matrix$Companion;", "", "()V", "Perspective0", "", "Perspective1", "Perspective2", "ScaleX", "ScaleY", "ScaleZ", "SkewX", "SkewY", "TranslateX", "TranslateY", "TranslateZ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        Matrix.Companion companion = new Matrix.Companion(0);
        Matrix.Companion = companion;
    }

    private Matrix(float[] values) {
        super();
        this.values = values;
    }

    public static final androidx.compose.ui.graphics.Matrix box-impl(float[] fArr) {
        Matrix matrix = new Matrix(fArr);
        return matrix;
    }

    public static float[] constructor-impl(float[] fArr) {
        return fArr;
    }

    public static float[] constructor-impl$default(float[] fArr, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int i;
        float[] obj1;
        int obj2;
        int obj3;
        obj3 = 1;
        if (i2 &= obj3 != 0) {
            obj1 = new float[16];
            i = 1065353216;
            obj2 = 0;
            obj1[obj3] = obj2;
            obj1[2] = obj2;
            obj1[3] = obj2;
            obj1[4] = obj2;
            obj1[5] = i;
            obj1[6] = obj2;
            obj1[7] = obj2;
            obj1[8] = obj2;
            obj1[9] = obj2;
            obj1[10] = i;
            obj1[11] = obj2;
            obj1[12] = obj2;
            obj1[13] = obj2;
            obj1[14] = obj2;
            obj1[15] = i;
        }
        return Matrix.constructor-impl(obj1);
    }

    public static boolean equals-impl(float[] fArr, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof Matrix) {
            return i2;
        }
        if (!Intrinsics.areEqual(fArr, (Matrix)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(float[] fArr, float[] f2Arr2) {
        return Intrinsics.areEqual(fArr, f2Arr2);
    }

    public static final float get-impl(float[] arg0, int row, int column) {
        final int i = 0;
        return arg0[i2 += column];
    }

    public static int hashCode-impl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static final void invert-impl(float[] arg0) {
        int i;
        int i29 = 0;
        int row$iv = arg0[i62 += i7];
        int i64 = 0;
        int row$iv5 = arg0[i67 += i30];
        int i69 = 0;
        int row$iv13 = arg0[i72 += i65];
        int i74 = 0;
        int row$iv15 = arg0[i77 += i70];
        int i79 = 0;
        int row$iv16 = arg0[i82 += i75];
        int i84 = 0;
        int row$iv17 = arg0[i87 += i80];
        int i89 = 0;
        int row$iv18 = arg0[i92 += i85];
        int i94 = 0;
        int row$iv19 = arg0[i97 += i90];
        int i99 = 0;
        int row$iv20 = arg0[i102 += i95];
        int i104 = 0;
        int row$iv21 = arg0[i107 += i100];
        int i109 = 0;
        int row$iv22 = arg0[i112 += i105];
        int i114 = 0;
        int row$iv23 = arg0[i117 += i110];
        int i119 = 0;
        int row$iv24 = arg0[i122 += i115];
        int i124 = 0;
        int row$iv25 = arg0[i127 += i120];
        int i129 = 0;
        int row$iv26 = arg0[i133 += i125];
        int i135 = 0;
        int row$iv27 = arg0[i139 += i130];
        i131 -= i136;
        i137 -= i141;
        i142 -= i144;
        i145 -= i147;
        i148 -= i150;
        i151 -= i153;
        i154 -= i156;
        i157 -= i159;
        i160 -= i162;
        i163 -= i165;
        i166 -= i168;
        i169 -= i171;
        i176 += i182;
        i = Float.compare(i177, i183) == 0 ? 1 : 0;
        if (i != 0) {
        }
        i184 /= i177;
        int i223 = 0;
        arg0[i269 += i209] = i218 *= i185;
        int i220 = row$iv13;
        int i226 = 0;
        arg0[i271 += i210] = i34 *= i185;
        int i229 = 0;
        arg0[i273 += i187] = i213 *= i185;
        int i215 = row$iv5;
        int i232 = 0;
        arg0[i275 += i188] = i11 *= i185;
        int i235 = 0;
        arg0[i277 += i36] = i15 *= i185;
        int i238 = 0;
        arg0[i279 += i37] = i192 *= i185;
        int i241 = 0;
        arg0[i281 += i38] = i19 *= i185;
        int i244 = 0;
        arg0[i283 += i39] = i197 *= i185;
        int i247 = 0;
        arg0[i285 += i40] = i201 *= i185;
        int i250 = 0;
        arg0[i287 += i41] = i23 *= i185;
        int i253 = 0;
        arg0[i289 += i42] = i206 *= i185;
        int i256 = 0;
        arg0[i291 += i43] = i5 *= i185;
        int i259 = 0;
        arg0[i293 += i25] = i47 *= i185;
        int i262 = 0;
        arg0[i295 += i26] = i51 *= i185;
        int i265 = 0;
        arg0[i297 += i27] = i56 *= i185;
        int i268 = 0;
        arg0[i299 += i28] = i60 *= i185;
    }

    public static final long map-MK-Hz9U(float[] arg0, long point) {
        int i2;
        int i;
        boolean infinite;
        final float x-impl = Offset.getX-impl(point);
        final float y-impl = Offset.getY-impl(point);
        int i9 = 0;
        int i15 = 0;
        int i16 = 0;
        f /= i5;
        if (!Float.isInfinite(i12) && !Float.isNaN(i12)) {
            if (!Float.isNaN(i12)) {
            } else {
                i2 = 0;
            }
        } else {
        }
        i = i2 != 0 ? i12 : 0;
        int i32 = 0;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i51 = 0;
        int i52 = 0;
        return OffsetKt.Offset(i19 *= i, i30 *= i);
    }

    public static final Rect map-impl(float[] arg0, Rect rect) {
        final float top = rect.getTop();
        long map-MK-Hz9U = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getLeft(), top));
        final float bottom = rect.getBottom();
        long map-MK-Hz9U2 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getLeft(), bottom));
        final float top2 = rect.getTop();
        long map-MK-Hz9U3 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getRight(), top2));
        final float bottom2 = rect.getBottom();
        long map-MK-Hz9U4 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getRight(), bottom2));
        Rect rect2 = new Rect(Math.min(Math.min(Offset.getX-impl(map-MK-Hz9U), Offset.getX-impl(map-MK-Hz9U2)), Math.min(Offset.getX-impl(map-MK-Hz9U3), Offset.getX-impl(map-MK-Hz9U4))), Math.min(Math.min(Offset.getY-impl(map-MK-Hz9U), Offset.getY-impl(map-MK-Hz9U2)), Math.min(Offset.getY-impl(map-MK-Hz9U3), Offset.getY-impl(map-MK-Hz9U4))), Math.max(Math.max(Offset.getX-impl(map-MK-Hz9U), Offset.getX-impl(map-MK-Hz9U2)), Math.max(Offset.getX-impl(map-MK-Hz9U3), Offset.getX-impl(map-MK-Hz9U4))), Math.max(Math.max(Offset.getY-impl(map-MK-Hz9U), Offset.getY-impl(map-MK-Hz9U2)), Math.max(Offset.getY-impl(map-MK-Hz9U3), Offset.getY-impl(map-MK-Hz9U4))));
        return rect2;
    }

    public static final void map-impl(float[] arg0, MutableRect rect) {
        final float top = rect.getTop();
        long map-MK-Hz9U = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getLeft(), top));
        final float bottom = rect.getBottom();
        long map-MK-Hz9U2 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getLeft(), bottom));
        final float top2 = rect.getTop();
        long map-MK-Hz9U3 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getRight(), top2));
        final float bottom2 = rect.getBottom();
        long map-MK-Hz9U4 = Matrix.map-MK-Hz9U(arg0, OffsetKt.Offset(rect.getRight(), bottom2));
        rect.setLeft(Math.min(Math.min(Offset.getX-impl(map-MK-Hz9U), Offset.getX-impl(map-MK-Hz9U2)), Math.min(Offset.getX-impl(map-MK-Hz9U3), Offset.getX-impl(map-MK-Hz9U4))));
        rect.setTop(Math.min(Math.min(Offset.getY-impl(map-MK-Hz9U), Offset.getY-impl(map-MK-Hz9U2)), Math.min(Offset.getY-impl(map-MK-Hz9U3), Offset.getY-impl(map-MK-Hz9U4))));
        rect.setRight(Math.max(Math.max(Offset.getX-impl(map-MK-Hz9U), Offset.getX-impl(map-MK-Hz9U2)), Math.max(Offset.getX-impl(map-MK-Hz9U3), Offset.getX-impl(map-MK-Hz9U4))));
        rect.setBottom(Math.max(Math.max(Offset.getY-impl(map-MK-Hz9U), Offset.getY-impl(map-MK-Hz9U2)), Math.max(Offset.getY-impl(map-MK-Hz9U3), Offset.getY-impl(map-MK-Hz9U4))));
    }

    public static final void reset-impl(float[] arg0) {
        int c;
        int i4;
        int r;
        int i;
        int i3;
        int i2;
        c = 0;
        i4 = 4;
        while (c < i4) {
            r = 0;
            while (r < i4) {
                if (c == r) {
                } else {
                }
                i = 0;
                i3 = 0;
                arg0[i5 += c] = i;
                r++;
                i = 1065353216;
            }
            c++;
            i4 = 4;
            if (c == r) {
            } else {
            }
            i = 0;
            i3 = 0;
            arg0[i5 += c] = i;
            r++;
            i = 1065353216;
        }
    }

    public static final void rotateX-impl(float[] arg0, float degrees) {
        final Object obj = degrees;
        long l = 4614256656552045848L;
        long l2 = 4640537203540230144L;
        float f = (float)d2;
        float f2 = (float)d3;
        int i6 = 0;
        int row$iv = arg0[i10 += i4];
        int i12 = 0;
        int row$iv2 = arg0[i18 += i7];
        int i24 = 0;
        int row$iv3 = arg0[i28 += i22];
        int i30 = 0;
        int row$iv4 = arg0[i34 += i25];
        int i40 = 0;
        int row$iv5 = arg0[i44 += i38];
        int i46 = 0;
        int row$iv6 = arg0[i50 += i41];
        int i56 = 0;
        int row$iv7 = arg0[i60 += i54];
        int i62 = 0;
        int row$iv8 = arg0[i66 += i57];
        int i78 = 0;
        arg0[i86 += i70] = i8 -= i13;
        int i79 = 0;
        arg0[i88 += i71] = i14 += i20;
        int i80 = 0;
        arg0[i90 += i72] = i26 -= i31;
        int i81 = 0;
        arg0[i92 += i73] = i32 += i36;
        int i82 = 0;
        arg0[i94 += i74] = i42 -= i47;
        int i83 = 0;
        arg0[i96 += i75] = i48 += i52;
        int i84 = 0;
        arg0[i98 += i76] = i58 -= i63;
        int i85 = 0;
        arg0[i100 += i77] = i64 += i68;
    }

    public static final void rotateY-impl(float[] arg0, float degrees) {
        Object obj = degrees;
        long l = 4614256656552045848L;
        long l2 = 4640537203540230144L;
        float f = (float)d2;
        float f2 = (float)d3;
        int i9 = 0;
        int row$iv = arg0[i13 += i7];
        int i15 = 0;
        int row$iv2 = arg0[i22 += i10];
        int i28 = 0;
        int row$iv3 = arg0[i32 += i26];
        int i34 = 0;
        int row$iv4 = arg0[i39 += i29];
        int i45 = 0;
        int row$iv5 = arg0[i49 += i43];
        int i51 = 0;
        int row$iv6 = arg0[i56 += i46];
        int i62 = 0;
        int row$iv7 = arg0[i66 += i60];
        int i68 = 0;
        int row$iv8 = arg0[i72 += i63];
        int i82 = 0;
        arg0[i90 += i74] = i11 += i16;
        int i83 = 0;
        arg0[i92 += i75] = i18 += i24;
        int i84 = 0;
        arg0[i94 += i76] = i30 += i35;
        int i85 = 0;
        arg0[i96 += i77] = i37 += i41;
        int i86 = 0;
        arg0[i98 += i78] = i47 += i52;
        int i87 = 0;
        arg0[i100 += i79] = i54 += i58;
        int i88 = 0;
        arg0[i102 += i80] = i64 += i69;
        int i89 = 0;
        arg0[i104 += i81] = i2 += i70;
    }

    public static final void rotateZ-impl(float[] arg0, float degrees) {
        Object obj = degrees;
        long l = 4614256656552045848L;
        long l2 = 4640537203540230144L;
        float f = (float)d2;
        float f2 = (float)d3;
        int i9 = 0;
        int row$iv = arg0[i13 += i7];
        int i15 = 0;
        int row$iv2 = arg0[i22 += i10];
        int i28 = 0;
        int row$iv3 = arg0[i32 += i26];
        int i34 = 0;
        int row$iv4 = arg0[i39 += i29];
        int i45 = 0;
        int row$iv5 = arg0[i49 += i43];
        int i51 = 0;
        int row$iv6 = arg0[i56 += i46];
        int i62 = 0;
        int row$iv7 = arg0[i66 += i60];
        int i68 = 0;
        int row$iv8 = arg0[i72 += i63];
        int i82 = 0;
        arg0[i90 += i74] = i11 += i16;
        int i83 = 0;
        arg0[i92 += i75] = i30 += i35;
        int i84 = 0;
        arg0[i94 += i76] = i47 += i52;
        int i85 = 0;
        arg0[i96 += i77] = i64 += i69;
        int i86 = 0;
        arg0[i98 += i78] = i18 += i24;
        int i87 = 0;
        arg0[i100 += i79] = i37 += i41;
        int i88 = 0;
        arg0[i102 += i80] = i54 += i58;
        int i89 = 0;
        arg0[i104 += i81] = i2 += i70;
    }

    public static final void scale-impl(float[] arg0, float x, float y, float z) {
        int i10 = 0;
        int i3 = 0;
        int i45 = 0;
        arg0[i51 += i37] = row$iv *= x;
        int i38 = 0;
        int i39 = 1;
        int i53 = 0;
        arg0[i59 += i48] = row$iv3 *= x;
        int i49 = 0;
        int i50 = 2;
        int i61 = 0;
        arg0[i81 += i56] = row$iv5 *= x;
        int i57 = 0;
        int i58 = 3;
        int i83 = 0;
        arg0[i100 += i64] = row$iv7 *= x;
        int i65 = 0;
        int i86 = 0;
        arg0[i102 += i66] = row$iv9 *= y;
        int i67 = 0;
        int i89 = 0;
        arg0[i104 += i68] = row$iv11 *= y;
        int i69 = 0;
        int i92 = 0;
        arg0[i106 += i70] = row$iv13 *= y;
        int i71 = 0;
        int i95 = 0;
        arg0[i108 += i72] = row$iv15 *= y;
        int i73 = 0;
        int i74 = 0;
        arg0[i98 += i3] = row$iv17 *= z;
        int i28 = 0;
        int i29 = 0;
        arg0[i77 += i39] = row$iv19 *= z;
        int i30 = 0;
        int i42 = 0;
        arg0[i79 += i31] = row$iv21 *= z;
        int i32 = 0;
        int i9 = 0;
        arg0[i33 += i58] = row$iv23 *= z;
    }

    public static void scale-impl$default(float[] fArr, float f2, float f3, float f4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 1065353216;
        if (i5 & 1 != 0) {
            obj2 = i;
        }
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        Matrix.scale-impl(fArr, obj2, obj3, obj4);
    }

    public static final void set-impl(float[] arg0, int row, int column, float v) {
        final int i = 0;
        arg0[i2 += column] = v;
    }

    public static final void setFrom-58bKbWc(float[] arg0, float[] matrix) {
        int i;
        int i2;
        i = 0;
        while (i < 16) {
            arg0[i] = matrix[i];
            i++;
        }
    }

    public static final void timesAssign-58bKbWc(float[] arg0, float[] m) {
        final float[] fArr = arg0;
        final float[] fArr2 = m;
        int i = 0;
        int i2 = 1;
        int i3 = 2;
        int i4 = 3;
        int i22 = 0;
        fArr[i38 += i6] = MatrixKt.access$dot-p89u6pk(fArr, i, fArr2, i);
        int i23 = 0;
        fArr[i40 += i7] = MatrixKt.access$dot-p89u6pk(fArr, i, fArr2, i2);
        int i24 = 0;
        fArr[i42 += i8] = MatrixKt.access$dot-p89u6pk(fArr, i, fArr2, i3);
        int i25 = 0;
        fArr[i44 += i9] = MatrixKt.access$dot-p89u6pk(fArr, i, fArr2, i4);
        int i26 = 0;
        fArr[i46 += i10] = MatrixKt.access$dot-p89u6pk(fArr, i2, fArr2, i);
        int i27 = 0;
        fArr[i48 += i11] = MatrixKt.access$dot-p89u6pk(fArr, i2, fArr2, i2);
        int i28 = 0;
        fArr[i50 += i12] = MatrixKt.access$dot-p89u6pk(fArr, i2, fArr2, i3);
        int i29 = 0;
        fArr[i52 += i13] = MatrixKt.access$dot-p89u6pk(fArr, i2, fArr2, i4);
        int i30 = 0;
        fArr[i54 += i14] = MatrixKt.access$dot-p89u6pk(fArr, i3, fArr2, i);
        int i31 = 0;
        fArr[i56 += i15] = MatrixKt.access$dot-p89u6pk(fArr, i3, fArr2, i2);
        int i32 = 0;
        fArr[i58 += i16] = MatrixKt.access$dot-p89u6pk(fArr, i3, fArr2, i3);
        int i33 = 0;
        fArr[i60 += i17] = MatrixKt.access$dot-p89u6pk(fArr, i3, fArr2, i4);
        int i34 = 0;
        fArr[i62 += i18] = MatrixKt.access$dot-p89u6pk(fArr, i4, fArr2, i);
        int i35 = 0;
        fArr[i64 += i19] = MatrixKt.access$dot-p89u6pk(fArr, i4, fArr2, i2);
        int i36 = 0;
        fArr[i66 += i20] = MatrixKt.access$dot-p89u6pk(fArr, i4, fArr2, i3);
        int i37 = 0;
        fArr[i68 += i21] = MatrixKt.access$dot-p89u6pk(fArr, i4, fArr2, i4);
    }

    public static String toString-impl(float[] arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        int i13 = 0;
        int i3 = 32;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        String str3 = "|\n            |";
        int i53 = 0;
        int i54 = 0;
        int i55 = 0;
        int i56 = 0;
        int i57 = 0;
        int i58 = 0;
        int i59 = 0;
        stringBuilder.append("\n            |").append(arg0[i29 += i5]).append(i3).append(arg0[i47 += i14]).append(i3).append(arg0[i49 += i15]).append(i3).append(arg0[i51 += i16]).append(str3).append(arg0[i68 += i34]).append(i3).append(arg0[i70 += i35]).append(i3).append(arg0[i72 += i36]).append(i3).append(arg0[i74 += i37]).append(str3).append(arg0[i76 += i38]).append(i3).append(arg0[i78 += i39]).append(i3).append(arg0[i80 += i40]).append(i3);
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i28 = 0;
        stringBuilder.append(arg0[i60 += i24]).append(str3).append(arg0[i62 += i25]).append(i3).append(arg0[i64 += i26]).append(i3).append(arg0[i66 += i27]).append(i3).append(arg0[i45 += i12]).append("|\n        ");
        return StringsKt.trimIndent(stringBuilder.toString());
    }

    public static final void translate-impl(float[] arg0, float x, float y, float z) {
        int i13 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i50 = 0;
        int i51 = 0;
        int i52 = 0;
        int i53 = 0;
        int i70 = 0;
        int i71 = 0;
        int i72 = 0;
        int i73 = 0;
        int i89 = 0;
        int i90 = 0;
        int i91 = 0;
        int i92 = 0;
        arg0[i102 += i77] = i3 += row$iv7;
        int i93 = 0;
        arg0[i104 += i78] = i11 += row$iv14;
        int i94 = 0;
        arg0[i106 += i79] = i23 += row$iv21;
        int i95 = 0;
        arg0[i108 += i80] = i40 += row$iv28;
    }

    public static void translate-impl$default(float[] fArr, float f2, float f3, float f4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 1 != 0) {
            obj2 = i;
        }
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        Matrix.translate-impl(fArr, obj2, obj3, obj4);
    }

    public boolean equals(Object object) {
        return Matrix.equals-impl(this.values, object);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return Matrix.hashCode-impl(this.values);
    }

    public String toString() {
        return Matrix.toString-impl(this.values);
    }

    public final float[] unbox-impl() {
        return this.values;
    }
}
