package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\r\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000bJ\r\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\r\u0010\u000bJ2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0086\n¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\u0008 \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\u0008#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008(\u0012\u0008\u0008)\u0012\u0004\u0008\u0008(*\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008(\u0012\u0008\u0008)\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\t0'H\u0082\u0008¢\u0006\u0004\u0008,\u0010-J\u0018\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\u00080\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\u0086\n¢\u0006\u0004\u00083\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\u00086\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\u00089\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\u0008;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\u0008>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\u0008D\u0010EJ\u001b\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008H\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\u0008K\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006M", d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", "sat", "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ColorMatrix {

    private final float[] values;
    private ColorMatrix(float[] values) {
        super();
        this.values = values;
    }

    public static final androidx.compose.ui.graphics.ColorMatrix box-impl(float[] fArr) {
        ColorMatrix colorMatrix = new ColorMatrix(fArr);
        return colorMatrix;
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
            obj1 = new float[20];
            i = 1065353216;
            obj2 = 0;
            obj1[obj3] = obj2;
            obj1[2] = obj2;
            obj1[3] = obj2;
            obj1[4] = obj2;
            obj1[5] = obj2;
            obj1[6] = i;
            obj1[7] = obj2;
            obj1[8] = obj2;
            obj1[9] = obj2;
            obj1[10] = obj2;
            obj1[11] = obj2;
            obj1[12] = i;
            obj1[13] = obj2;
            obj1[14] = obj2;
            obj1[15] = obj2;
            obj1[16] = obj2;
            obj1[17] = obj2;
            obj1[18] = i;
            obj1[19] = obj2;
        }
        return ColorMatrix.constructor-impl(obj1);
    }

    public static final void convertRgbToYuv-impl(float[] arg0) {
        ColorMatrix.reset-impl(arg0);
        int i20 = 0;
        arg0[i29 += i2] = 1050220167;
        int i21 = 0;
        arg0[i31 += i3] = 1058424226;
        int i22 = 0;
        arg0[i33 += i4] = 1038710997;
        int i23 = 0;
        arg0[i35 += i5] = -1104360914;
        int i24 = 0;
        arg0[i37 += i6] = -1096181015;
        int i25 = 0;
        arg0[i39 += i7] = 1056964608;
        int i26 = 0;
        arg0[i41 += i8] = 1056964608;
        int i27 = 0;
        arg0[i43 += i9] = -1093247351;
        int i28 = 0;
        arg0[i45 += i10] = -1113160229;
    }

    public static final void convertYuvToRgb-impl(float[] arg0) {
        ColorMatrix.reset-impl(arg0);
        int i16 = 0;
        arg0[i23 += i2] = 1068725436;
        int i17 = 0;
        arg0[i25 += i3] = 1065353216;
        int i18 = 0;
        arg0[i27 += i4] = -1095748834;
        int i19 = 0;
        arg0[i29 += i5] = -1086926367;
        int i20 = 0;
        arg0[i31 += i6] = 1065353216;
        int i21 = 0;
        arg0[i33 += i7] = 1071829221;
        int i22 = 0;
        arg0[i35 += i8] = 0;
    }

    private static final float dot-Me4OoYI(float[] arg0, float[] m1, int row, float[] m2, int column) {
        int i6 = 0;
        int i15 = 0;
        int i16 = 0;
        int i23 = 0;
        int i17 = 0;
        int i26 = 0;
        int i18 = 0;
        int i29 = 0;
        return i4 += i12;
    }

    public static boolean equals-impl(float[] fArr, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof ColorMatrix) {
            return i2;
        }
        if (!Intrinsics.areEqual(fArr, (ColorMatrix)object2.unbox-impl())) {
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

    public static final void reset-impl(float[] arg0) {
        final float[] fArr = arg0;
        ArraysKt.fill$default(fArr, 0, 0, 0, 6, 0);
        int i12 = 0;
        fArr[i17 += i2] = 1065353216;
        int i13 = 0;
        fArr[i19 += i3] = 1065353216;
        int i14 = 0;
        fArr[i21 += i4] = 1065353216;
        int i15 = 0;
        fArr[i23 += i5] = 1065353216;
    }

    private static final void rotateInternal-impl(float[] arg0, float degrees, Function2<? super Float, ? super Float, Unit> block) {
        final int i = 0;
        ColorMatrix.reset-impl(arg0);
        i2 /= l2;
        block.invoke(Float.valueOf((float)d2), Float.valueOf((float)d3));
    }

    public static final void set-impl(float[] arg0, int row, int column, float v) {
        final int i = 0;
        arg0[i2 += column] = v;
    }

    public static final void set-jHG-Opc(float[] arg0, float[] src) {
        ArraysKt.copyInto$default(src, arg0, 0, 0, 0, 14, 0);
    }

    public static final void setToRotateBlue-impl(float[] arg0, float degrees) {
        final int i = 0;
        ColorMatrix.reset-impl(arg0);
        i2 /= l2;
        final float f3 = f;
        final float f4 = f2;
        final int i4 = 0;
        int i10 = 0;
        arg0[i14 += i6] = f3;
        int i11 = 0;
        arg0[i16 += i7] = f3;
        int i12 = 0;
        arg0[i18 += i8] = f4;
        int i20 = 0;
        arg0[i21 += i9] = -f4;
    }

    public static final void setToRotateGreen-impl(float[] arg0, float degrees) {
        final int i = 0;
        ColorMatrix.reset-impl(arg0);
        i2 /= l2;
        final float f3 = f;
        final float f4 = f2;
        final int i4 = 0;
        int i10 = 0;
        arg0[i14 += i6] = f3;
        int i11 = 0;
        arg0[i16 += i7] = f3;
        int i18 = 0;
        arg0[i21 += i8] = -f4;
        int i13 = 0;
        arg0[i19 += i9] = f4;
    }

    public static final void setToRotateRed-impl(float[] arg0, float degrees) {
        final int i = 0;
        ColorMatrix.reset-impl(arg0);
        i2 /= l2;
        final float f3 = f;
        final float f4 = f2;
        final int i4 = 0;
        int i10 = 0;
        arg0[i14 += i6] = f3;
        int i11 = 0;
        arg0[i16 += i7] = f3;
        int i12 = 0;
        arg0[i18 += i8] = f4;
        int i20 = 0;
        arg0[i21 += i9] = -f4;
    }

    public static final void setToSaturation-impl(float[] arg0, float sat) {
        ColorMatrix.reset-impl(arg0);
        f -= sat;
        i3 *= i2;
        i5 *= i2;
        i7 *= i2;
        int i28 = 0;
        arg0[i43 += i10] = i4 + sat;
        int i20 = 0;
        arg0[i29 += i11] = i6;
        int i21 = 0;
        arg0[i31 += i12] = i8;
        int i22 = 0;
        arg0[i33 += i13] = i4;
        int i35 = 0;
        arg0[i45 += i14] = i6 + sat;
        int i24 = 0;
        arg0[i36 += i15] = i8;
        int i25 = 0;
        arg0[i38 += i16] = i4;
        int i26 = 0;
        arg0[i40 += i17] = i6;
        int i42 = 0;
        arg0[i47 += i18] = i8 + sat;
    }

    public static final void setToScale-impl(float[] arg0, float redScale, float greenScale, float blueScale, float alphaScale) {
        ColorMatrix.reset-impl(arg0);
        int i6 = 0;
        arg0[i10 += i2] = redScale;
        int i7 = 0;
        arg0[i12 += i3] = greenScale;
        int i8 = 0;
        arg0[i14 += i4] = blueScale;
        int i9 = 0;
        arg0[i16 += i5] = alphaScale;
    }

    public static final void timesAssign-jHG-Opc(float[] arg0, float[] colorMatrix) {
        final float[] fArr = arg0;
        final float[] fArr2 = colorMatrix;
        int i = 0;
        int i2 = 1;
        int i3 = 2;
        int i4 = 3;
        int i19 = 0;
        int i27 = 0;
        int i28 = 0;
        int i39 = 0;
        int i30 = 0;
        int i42 = 0;
        int i32 = 0;
        int i45 = 0;
        int i34 = 0;
        int i68 = 0;
        int i76 = 0;
        int i77 = 0;
        int i88 = 0;
        int i79 = 0;
        int i91 = 0;
        int i81 = 0;
        int i94 = 0;
        int i83 = 0;
        int i123 = 0;
        int i140 = 0;
        int i141 = 0;
        int i178 = 0;
        int i143 = 0;
        int i181 = 0;
        int i145 = 0;
        int i184 = 0;
        int i147 = 0;
        int i148 = 0;
        int i189 = 0;
        int i190 = 0;
        int i227 = 0;
        int i192 = 0;
        int i230 = 0;
        int i194 = 0;
        int i233 = 0;
        int i196 = 0;
        int i197 = 0;
        fArr[i236 += i154] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i, fArr2, i);
        int i198 = 0;
        fArr[i238 += i155] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i, fArr2, i2);
        int i199 = 0;
        fArr[i240 += i156] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i, fArr2, i3);
        int i200 = 0;
        fArr[i242 += i157] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i, fArr2, i4);
        int i201 = 0;
        fArr[i244 += i158] = i9 += row$iv6;
        int i202 = 0;
        fArr[i246 += i159] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i2, fArr2, i);
        int i203 = 0;
        fArr[i248 += i160] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i2, fArr2, i2);
        int i204 = 0;
        fArr[i250 += i161] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i2, fArr2, i3);
        int i205 = 0;
        fArr[i252 += i162] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i2, fArr2, i4);
        int i206 = 0;
        fArr[i254 += i163] = i58 += row$iv15;
        int i207 = 0;
        fArr[i256 += i164] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i3, fArr2, i);
        int i208 = 0;
        fArr[i258 += i165] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i3, fArr2, i2);
        int i209 = 0;
        fArr[i260 += i166] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i3, fArr2, i3);
        int i210 = 0;
        fArr[i262 += i167] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i3, fArr2, i4);
        int i211 = 0;
        fArr[i264 += i168] = i107 += row$iv24;
        int i212 = 0;
        fArr[i266 += i169] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i4, fArr2, i);
        int i213 = 0;
        fArr[i268 += i170] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i4, fArr2, i2);
        int i214 = 0;
        fArr[i270 += i171] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i4, fArr2, i3);
        int i215 = 0;
        fArr[i272 += i172] = ColorMatrix.dot-Me4OoYI(fArr, fArr, i4, fArr2, i4);
        int i216 = 0;
        fArr[i274 += i173] = i121 += row$iv33;
    }

    public static String toString-impl(float[] fArr) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ColorMatrix(values=").append(Arrays.toString(fArr)).append(')').toString();
    }

    public boolean equals(Object object) {
        return ColorMatrix.equals-impl(this.values, object);
    }

    public final float[] getValues() {
        return this.values;
    }

    public int hashCode() {
        return ColorMatrix.hashCode-impl(this.values);
    }

    public String toString() {
        return ColorMatrix.toString-impl(this.values);
    }

    public final float[] unbox-impl() {
        return this.values;
    }
}
