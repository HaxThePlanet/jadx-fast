package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u0000\n\u0002\u0008\u000f\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 ^2\u00020\u0001:\u0001^BC\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\nB[\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B#\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B+\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B#\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0008¢\u0006\u0002\u0010\u001aB+\u0008\u0016\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0008¢\u0006\u0002\u0010\u001bB?\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\u0008\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\u0008\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u001fB[\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020 \u0012\u0006\u0010\t\u001a\u00020 \u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0008\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\"J\u0013\u0010<\u001a\u00020.2\u0008\u0010=\u001a\u0004\u0018\u00010>H\u0096\u0002J \u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010?\u001a\u00020\u00052\u0008\u0008\u0001\u0010C\u001a\u00020\u0005H\u0007J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0008\u0010E\u001a\u00020\u0005H\u0007J\u0012\u0010E\u001a\u00020\u00052\u0008\u0008\u0001\u0010*\u001a\u00020\u0005H\u0007J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0008\u0010I\u001a\u00020\u0005H\u0007J\u0012\u0010I\u001a\u00020\u00052\u0008\u0008\u0001\u0010\u000b\u001a\u00020\u0005H\u0007J\u0008\u0010J\u001a\u00020\u0005H\u0007J\u0012\u0010J\u001a\u00020\u00052\u0008\u0008\u0001\u0010\u001e\u001a\u00020\u0005H\u0007J\u0008\u0010K\u001a\u00020\u0017H\u0016J \u0010L\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010L\u001a\u00020\u00052\u0008\u0008\u0001\u0010C\u001a\u00020\u0005H\u0007J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\u0008RJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J%\u0010T\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\u0008UJ=\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\\\u0010]R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010$R\u0014\u0010%\u001a\u00020 X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u00020 X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010'R\u0014\u0010*\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0014\u0010-\u001a\u00020.X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010/R\u0014\u00100\u001a\u00020.X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010/R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010$R\u0014\u00102\u001a\u00020 X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010'R\u0014\u00104\u001a\u00020 X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010'R\u0014\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010,R\u0013\u0010!\u001a\u0004\u0018\u00010\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u0014\u0010\u001e\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010,R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006_", d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfFunc", "getEotfFunc$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfFunc", "getOetfFunc$ui_graphics_release", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Rgb extends androidx.compose.ui.graphics.colorspace.ColorSpace {

    public static final androidx.compose.ui.graphics.colorspace.Rgb.Companion Companion;
    private static final androidx.compose.ui.graphics.colorspace.DoubleFunction DoubleIdentity;
    private final Function1<Double, Double> eotf;
    private final androidx.compose.ui.graphics.colorspace.DoubleFunction eotfFunc;
    private final androidx.compose.ui.graphics.colorspace.DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    private final float max;
    private final float min;
    private final Function1<Double, Double> oetf;
    private final androidx.compose.ui.graphics.colorspace.DoubleFunction oetfFunc;
    private final androidx.compose.ui.graphics.colorspace.DoubleFunction oetfOrig;
    private final float[] primaries;
    private final androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters;
    private final float[] transform;
    private final androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0008H\u0002J\u0018\u0010\u0014\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0008H\u0002J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J@\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "area", "", "primaries", "", "compare", "", "point", "", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final androidx.compose.ui.graphics.colorspace.WhitePoint access$computeWhitePoint(androidx.compose.ui.graphics.colorspace.Rgb.Companion $this, float[] toXYZ) {
            return $this.computeWhitePoint(toXYZ);
        }

        public static final float[] access$computeXYZMatrix(androidx.compose.ui.graphics.colorspace.Rgb.Companion $this, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint) {
            return $this.computeXYZMatrix(primaries, whitePoint);
        }

        public static final boolean access$isSrgb(androidx.compose.ui.graphics.colorspace.Rgb.Companion $this, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, androidx.compose.ui.graphics.colorspace.DoubleFunction OETF, androidx.compose.ui.graphics.colorspace.DoubleFunction EOTF, float min, float max, int id) {
            return $this.isSrgb(primaries, whitePoint, OETF, EOTF, min, max, id);
        }

        public static final boolean access$isWideGamut(androidx.compose.ui.graphics.colorspace.Rgb.Companion $this, float[] primaries, float min, float max) {
            return $this.isWideGamut(primaries, min, max);
        }

        public static final float[] access$xyPrimaries(androidx.compose.ui.graphics.colorspace.Rgb.Companion $this, float[] primaries) {
            return $this.xyPrimaries(primaries);
        }

        private final float area(float[] primaries) {
            int i;
            int i3 = primaries[0];
            int i5 = primaries[1];
            int i7 = primaries[2];
            int i9 = primaries[3];
            int i11 = primaries[4];
            int i13 = primaries[5];
            i25 *= i19;
            i = Float.compare(i26, i27) < 0 ? -i26 : i26;
            return i;
        }

        private final boolean compare(double point, androidx.compose.ui.graphics.colorspace.DoubleFunction a, androidx.compose.ui.graphics.colorspace.DoubleFunction b) {
            int i;
            i = Double.compare(d, l) <= 0 ? 1 : 0;
            return i;
        }

        private final androidx.compose.ui.graphics.colorspace.WhitePoint computeWhitePoint(float[] toXYZ) {
            float[] fArr = new float[3];
            fArr = new int[]{1065353216, 1065353216, 1065353216};
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(toXYZ, fArr);
            int i2 = 0;
            int i6 = 1;
            i4 += f5;
            WhitePoint whitePoint = new WhitePoint(f /= i5, f3 /= i5);
            return whitePoint;
        }

        private final float[] computeXYZMatrix(float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint) {
            int i = 0;
            final int i3 = primaries[i];
            int i4 = 1;
            final int i8 = primaries[i4];
            final int i9 = 2;
            final int i10 = primaries[i9];
            final int i11 = 3;
            final int i12 = primaries[i11];
            final int i13 = 4;
            final int i14 = primaries[i13];
            final int i15 = 5;
            final int i16 = primaries[i15];
            final float f = whitePoint.getX();
            final float f2 = whitePoint.getY();
            float f3 = (float)i4;
            i19 /= i8;
            i21 /= i12;
            final int i25 = i3 / i8;
            final int i26 = i10 / i12;
            final int i27 = i14 / i16;
            final int i28 = f / f2;
            int i42 = i31 / i37;
            i45 /= i49;
            int i50 = 1065353216;
            i54 -= i42;
            final int i56 = i55 / i8;
            final int i57 = i46 / i12;
            final int i58 = i42 / i16;
            float[] fArr = new float[9];
            fArr[i] = i56 * i3;
            fArr[i4] = i55;
            fArr[i9] = i61 *= i56;
            fArr[i11] = i57 * i10;
            fArr[i13] = i46;
            fArr[i15] = i65 *= i57;
            fArr[6] = i58 * i14;
            fArr[7] = i42;
            fArr[8] = i52 *= i58;
            return fArr;
        }

        private final boolean contains(float[] p1, float[] p2) {
            int i8;
            int cmp;
            int cmp3;
            int cmp2;
            int i2;
            float f2;
            float f;
            int i3;
            float i;
            int i4;
            int i7;
            int i6;
            int i5;
            i8 = 0;
            int i18 = 1;
            int i23 = 2;
            int i37 = 3;
            int i48 = 4;
            int i54 = 5;
            float[] fArr = new float[6];
            fArr[i8] = i9 -= i17;
            fArr[i18] = i19 -= i22;
            fArr[i23] = i28 -= i36;
            fArr[i37] = i38 -= i47;
            fArr[i48] = i49 -= i53;
            fArr[i54] = i55 -= i58;
            int i21 = 0;
            if (Float.compare(cross, i21) >= 0) {
                if (Float.compare(cross2, i21) < 0) {
                } else {
                    if (Float.compare(cross3, i21) >= 0) {
                        if (Float.compare(cross4, i21) < 0) {
                        } else {
                            if (Float.compare(cross5, i21) >= 0 && Float.compare(cross6, i21) >= 0) {
                                if (Float.compare(cross6, i21) >= 0) {
                                    i8 = i18;
                                } else {
                                }
                            } else {
                            }
                        }
                        return i8;
                    }
                }
                return i8;
            }
            return i8;
        }

        private final float cross(float ax, float ay, float bx, float by) {
            return i -= i3;
        }

        private final boolean isSrgb(float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, androidx.compose.ui.graphics.colorspace.DoubleFunction OETF, androidx.compose.ui.graphics.colorspace.DoubleFunction EOTF, float min, float max, int id) {
            int i2;
            int i;
            int x;
            long l;
            final int i3 = 1;
            if (id == 0) {
                return i3;
            }
            final int i6 = 0;
            if (!ColorSpaceKt.compare(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) {
                return i6;
            }
            if (!ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
                return i6;
            }
            i2 = Float.compare(min, i4) == 0 ? i3 : i6;
            if (i2 == 0) {
                return i6;
            }
            i = Float.compare(max, i5) == 0 ? i3 : i6;
            if (i == 0) {
                return i6;
            }
            androidx.compose.ui.graphics.colorspace.Rgb srgb = ColorSpaces.INSTANCE.getSrgb();
            x = 0;
            while (Double.compare(x, l2) <= 0) {
                x += l;
            }
            return i3;
        }

        private final boolean isWideGamut(float[] primaries, float min, float max) {
            int i;
            boolean contains;
            if (Float.compare(i2, i5) > 0) {
                if (!contains(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) {
                    if (Float.compare(min, i3) < 0 && Float.compare(max, i4) > 0) {
                        i = Float.compare(max, i4) > 0 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private final float[] xyPrimaries(float[] primaries) {
            int i;
            float[] sum;
            int i3;
            int i4;
            int i5;
            int i2;
            int i7;
            int i6;
            i = 6;
            final float[] fArr = new float[i];
            if (primaries.length == 9) {
                int i11 = 0;
                int i25 = 1;
                int i29 = 2;
                i20 += i32;
                fArr[i11] = i33 /= i21;
                fArr[i25] = i12 /= i21;
                int i14 = 3;
                i2 = 4;
                i7 = 5;
                i27 += i6;
                fArr[i29] = sum2 /= i4;
                fArr[i14] = i23 /= i4;
                i3 = 7;
                i16 += i5;
                fArr[i2] = i8 /= i17;
                fArr[i7] = i10 /= i17;
                sum = primaries;
            } else {
                ArraysKt.copyInto$default(primaries, fArr, 0, 0, 6, 6, 0);
            }
            return fArr;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] toXYZ) {
            final float[] fArr = toXYZ;
            int i = 3;
            float[] fArr3 = new float[i];
            fArr3 = new int[]{1065353216, 0, 0};
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, fArr3);
            float[] fArr4 = new float[i];
            fArr4 = new int[]{0, 1065353216, 0};
            float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(fArr, fArr4);
            float[] fArr5 = new float[i];
            fArr5 = new int[]{0, 0, 1065353216};
            float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(fArr, fArr5);
            int i3 = 0;
            final int i8 = 1;
            int i9 = 2;
            i6 += f3;
            i10 += f6;
            i12 += f9;
            float[] fArr2 = new float[6];
            fArr2[i3] = f10 /= i7;
            fArr2[i8] = f11 /= i7;
            fArr2[i9] = f12 /= i11;
            fArr2[i] = f13 /= i11;
            fArr2[4] = f14 /= i13;
            fArr2[5] = f15 /= i13;
            return fArr2;
        }
    }
    public static double $r8$lambda$-dnaBie4LWY14HMiVYPEW1zVyJ0(androidx.compose.ui.graphics.colorspace.Rgb rgb, double d2) {
        return Rgb.eotfFunc$lambda$1(rgb, d2);
    }

    public static double $r8$lambda$0VnaReYaJMb11m2G7-Mh0wuBaWA(androidx.compose.ui.graphics.colorspace.Rgb rgb, double d2) {
        return Rgb.oetfFunc$lambda$0(rgb, d2);
    }

    public static double $r8$lambda$4B3Mjo5CGxeec3-DWxI9_rR2CpE(Function1 function1, double d2) {
        return Rgb._init_$lambda$5(function1, d2);
    }

    public static double $r8$lambda$GJALvqGg75YDwjBAsDOf0UE6v5A(androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, double d2) {
        return Rgb._init_$lambda$9(transferParameters, d2);
    }

    public static double $r8$lambda$IntSl_jJJrniYA6DFCtcEZiKFa4(androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, double d2) {
        return Rgb._init_$lambda$8(transferParameters, d2);
    }

    public static double $r8$lambda$LOvDXKeBCWVMEVqkoYOT9dw91J4(Function1 function1, double d2) {
        return Rgb._init_$lambda$2(function1, d2);
    }

    public static double $r8$lambda$Mbf_x4s2comCdC8Y9VioiAZ0drY(androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, double d2) {
        return Rgb._init_$lambda$7(transferParameters, d2);
    }

    public static double $r8$lambda$NBAtvciw6pO7qi1pZQhckAj5hfk(double d) {
        return Rgb.DoubleIdentity$lambda$12(d);
    }

    public static double $r8$lambda$Re7xw3aJmdVA8XGvDpOzDTnMqwA(androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, double d2) {
        return Rgb._init_$lambda$6(transferParameters, d2);
    }

    public static double $r8$lambda$Y4_0Z8BcQ1jwFsIirYybkdCHk2o(double d, double d2) {
        return Rgb._init_$lambda$11(d, d2);
    }

    public static double $r8$lambda$fQ-NxHYBbQei_ep6070iYk6_yIE(Function1 function1, double d2) {
        return Rgb._init_$lambda$3(function1, d2);
    }

    public static double $r8$lambda$lKCEZgZqPByZ-lZ_EptzW9A350w(double d, double d2) {
        return Rgb._init_$lambda$10(d, d2);
    }

    public static double $r8$lambda$odGRB3RlKNA6dRFB404DG7BV1Q8(Function1 function1, double d2) {
        return Rgb._init_$lambda$4(function1, d2);
    }

    static {
        Rgb.Companion companion = new Rgb.Companion(0);
        Rgb.Companion = companion;
        Rgb$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new Rgb$$ExternalSyntheticLambda5();
        Rgb.DoubleIdentity = externalSyntheticLambda5;
    }

    public Rgb(androidx.compose.ui.graphics.colorspace.Rgb colorSpace, float[] transform, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint) {
        super(colorSpace.getName(), colorSpace.primaries, whitePoint, transform, colorSpace.oetfOrig, colorSpace.eotfOrig, colorSpace.min, colorSpace.max, colorSpace.transferParameters, -1);
    }

    public Rgb(String name, float[] toXYZ, double gamma) {
        super(name, Rgb.Companion.computePrimaries$ui_graphics_release(toXYZ), Rgb.Companion.access$computeWhitePoint(Rgb.Companion, toXYZ), gamma, obj6, 0, 1065353216, -1);
    }

    public Rgb(String name, float[] toXYZ, androidx.compose.ui.graphics.colorspace.TransferParameters function) {
        super(name, Rgb.Companion.computePrimaries$ui_graphics_release(toXYZ), Rgb.Companion.access$computeWhitePoint(Rgb.Companion, toXYZ), function, -1);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, double gamma) {
        super(name, primaries, whitePoint, gamma, obj5, 0, 1065353216, -1);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, double gamma, float min, float max, int id) {
        int i2;
        androidx.compose.ui.graphics.colorspace.DoubleFunction doubleIdentity;
        androidx.compose.ui.graphics.colorspace.DoubleFunction doubleIdentity2;
        int i;
        androidx.compose.ui.graphics.colorspace.DoubleFunction num;
        androidx.compose.ui.graphics.colorspace.DoubleFunction externalSyntheticLambda9;
        final long l = gamma;
        long l2 = 4607182418800017408L;
        final int i4 = 0;
        i2 = Double.compare(l, l2) == 0 ? i : i4;
        if (i2 != 0) {
            num = doubleIdentity;
        } else {
            doubleIdentity = new Rgb$$ExternalSyntheticLambda8(l, obj2);
            num = doubleIdentity;
        }
        if (Double.compare(l, l2) == 0) {
        } else {
            i = i4;
        }
        if (i != 0) {
            externalSyntheticLambda9 = doubleIdentity2;
        } else {
            doubleIdentity2 = new Rgb$$ExternalSyntheticLambda9(l, obj2);
            externalSyntheticLambda9 = doubleIdentity2;
        }
        TransferParameters transferParameters = new TransferParameters(l, obj2, 4607182418800017408L, obj4, 0, i4, 0, obj8, 0, obj10, 0, obj12, 0, obj14, 96, 0);
        super(name, primaries, whitePoint, 0, num, externalSyntheticLambda9, max, id, transferParameters, obj27);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters function) {
        super(name, primaries, whitePoint, function, -1);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters function, int id) {
        int i;
        Object externalSyntheticLambda1;
        int cmp;
        Object externalSyntheticLambda2;
        int i2;
        double d;
        Object externalSyntheticLambda12;
        Object externalSyntheticLambda22;
        double d2;
        int i3 = 0;
        i2 = 1;
        int i4 = 0;
        i = Double.compare(d3, i3) == 0 ? i2 : i4;
        if (i != 0) {
            i = Double.compare(d, i3) == 0 ? i2 : i4;
            if (i != 0) {
                externalSyntheticLambda1 = new Rgb$$ExternalSyntheticLambda12(function);
                externalSyntheticLambda12 = externalSyntheticLambda1;
            } else {
                externalSyntheticLambda1 = new Rgb$$ExternalSyntheticLambda1(function);
                externalSyntheticLambda12 = externalSyntheticLambda1;
            }
        } else {
        }
        cmp = Double.compare(d2, i3) == 0 ? i2 : i4;
        if (cmp != 0) {
            if (Double.compare(d2, i3) == 0) {
            } else {
                i2 = i4;
            }
            if (i2 != 0) {
                externalSyntheticLambda2 = new Rgb$$ExternalSyntheticLambda2(function);
                externalSyntheticLambda22 = externalSyntheticLambda2;
            } else {
                externalSyntheticLambda2 = new Rgb$$ExternalSyntheticLambda3(function);
                externalSyntheticLambda22 = externalSyntheticLambda2;
            }
        } else {
        }
        super(name, primaries, whitePoint, 0, externalSyntheticLambda12, externalSyntheticLambda22, 0, 1065353216, function, id);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, Function1<? super Double, Double> oetf, Function1<? super Double, Double> eotf, float min, float max) {
        Rgb$$ExternalSyntheticLambda10 externalSyntheticLambda10 = new Rgb$$ExternalSyntheticLambda10(oetf);
        Rgb$$ExternalSyntheticLambda11 externalSyntheticLambda11 = new Rgb$$ExternalSyntheticLambda11(eotf);
        super(name, primaries, whitePoint, 0, externalSyntheticLambda10, externalSyntheticLambda11, min, max, 0, -1);
    }

    public Rgb(String name, float[] primaries, androidx.compose.ui.graphics.colorspace.WhitePoint whitePoint, float[] transform, androidx.compose.ui.graphics.colorspace.DoubleFunction oetf, androidx.compose.ui.graphics.colorspace.DoubleFunction eotf, float min, float max, androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters, int id) {
        int length;
        int length2;
        float primaries2;
        int whitePoint2;
        final float[] fArr2 = primaries;
        final float[] fArr3 = transform;
        Object obj = this;
        super(name, ColorModel.Companion.getRgb-xdoWZVw(), obj3, id, 0);
        obj.whitePoint = whitePoint;
        obj.min = min;
        obj.max = max;
        obj.transferParameters = transferParameters;
        final androidx.compose.ui.graphics.colorspace.DoubleFunction num = oetf;
        obj.oetfOrig = num;
        Rgb.oetf.1 anon = new Rgb.oetf.1(obj);
        obj.oetf = (Function1)anon;
        Rgb$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Rgb$$ExternalSyntheticLambda0(obj);
        obj.oetfFunc = externalSyntheticLambda0;
        final androidx.compose.ui.graphics.colorspace.DoubleFunction num2 = eotf;
        obj.eotfOrig = num2;
        Rgb.eotf.1 anon2 = new Rgb.eotf.1(obj);
        obj.eotf = (Function1)anon2;
        Rgb$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new Rgb$$ExternalSyntheticLambda4(obj);
        obj.eotfFunc = externalSyntheticLambda4;
        whitePoint2 = 9;
        if (fArr2.length != 6) {
            if (fArr2.length != whitePoint2) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
            throw illegalArgumentException;
        }
        if (Float.compare(min2, primaries2) >= 0) {
        } else {
            obj.primaries = Rgb.Companion.access$xyPrimaries(Rgb.Companion, fArr2);
            if (fArr3 == null) {
                obj.transform = Rgb.Companion.access$computeXYZMatrix(Rgb.Companion, obj.primaries, obj.whitePoint);
                obj.inverseTransform = ColorSpaceKt.inverse3x3(obj.transform);
                obj.isWideGamut = Rgb.Companion.access$isWideGamut(Rgb.Companion, obj.primaries, obj.min, obj.max);
                obj.isSrgb = Rgb.Companion.access$isSrgb(Rgb.Companion, obj.primaries, obj.whitePoint, num, num2, obj.min, obj.max, id);
            } else {
                if (fArr3.length != whitePoint2) {
                } else {
                    obj.transform = fArr3;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder2.append("Transform must have 9 entries! Has ").append(fArr3.length).toString());
            throw illegalArgumentException3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder.append("Invalid range: min=").append(obj.min).append(", max=").append(obj.max).append("; min must be strictly < max").toString());
        throw illegalArgumentException2;
    }

    public Rgb(String name, float[] toXYZ, Function1<? super Double, Double> oetf, Function1<? super Double, Double> eotf) {
        final float[] fArr = toXYZ;
        Rgb$$ExternalSyntheticLambda6 externalSyntheticLambda6 = new Rgb$$ExternalSyntheticLambda6(oetf);
        Rgb$$ExternalSyntheticLambda7 externalSyntheticLambda7 = new Rgb$$ExternalSyntheticLambda7(eotf);
        super(name, Rgb.Companion.computePrimaries$ui_graphics_release(fArr), Rgb.Companion.access$computeWhitePoint(Rgb.Companion, fArr), 0, externalSyntheticLambda6, externalSyntheticLambda7, 0, 1065353216, 0, -1);
    }

    private static final double DoubleIdentity$lambda$12(double d) {
        return d;
    }

    private static final double _init_$lambda$10(double $gamma, double x) {
        int i;
        if (Double.compare(obj6, i) < 0) {
        } else {
            i = obj6;
        }
        return Math.pow(i, obj1);
    }

    private static final double _init_$lambda$11(double $gamma, double x) {
        int i;
        if (Double.compare(obj5, i) < 0) {
        } else {
            i = obj5;
        }
        return Math.pow(i, obj1);
    }

    private static final double _init_$lambda$2(Function1 $oetf, double x) {
        return (Number)$oetf.invoke(Double.valueOf(x)).doubleValue();
    }

    private static final double _init_$lambda$3(Function1 $eotf, double x) {
        return (Number)$eotf.invoke(Double.valueOf(x)).doubleValue();
    }

    private static final double _init_$lambda$4(Function1 $oetf, double x) {
        return (Number)$oetf.invoke(Double.valueOf(x)).doubleValue();
    }

    private static final double _init_$lambda$5(Function1 $eotf, double x) {
        return (Number)$eotf.invoke(Double.valueOf(x)).doubleValue();
    }

    private static final double _init_$lambda$6(androidx.compose.ui.graphics.colorspace.TransferParameters $function, double x) {
        return ColorSpaceKt.rcpResponse(x, obj1, $function.getA(), obj3, $function.getB(), obj5);
    }

    private static final double _init_$lambda$7(androidx.compose.ui.graphics.colorspace.TransferParameters $function, double x) {
        return ColorSpaceKt.rcpResponse(x, obj3, $function.getA(), obj5, $function.getB(), obj7, $function.getC(), obj9);
    }

    private static final double _init_$lambda$8(androidx.compose.ui.graphics.colorspace.TransferParameters $function, double x) {
        return ColorSpaceKt.response(x, obj1, $function.getA(), obj3, $function.getB(), obj5);
    }

    private static final double _init_$lambda$9(androidx.compose.ui.graphics.colorspace.TransferParameters $function, double x) {
        return ColorSpaceKt.response(x, obj3, $function.getA(), obj5, $function.getB(), obj7, $function.getC(), obj9);
    }

    public static final float access$getMax$p(androidx.compose.ui.graphics.colorspace.Rgb $this) {
        return $this.max;
    }

    public static final float access$getMin$p(androidx.compose.ui.graphics.colorspace.Rgb $this) {
        return $this.min;
    }

    private static final double eotfFunc$lambda$1(androidx.compose.ui.graphics.colorspace.Rgb this$0, double x) {
        return this$0.eotfOrig.invoke(RangesKt.coerceIn(x, obj3, (double)min));
    }

    private static final double oetfFunc$lambda$0(androidx.compose.ui.graphics.colorspace.Rgb this$0, double x) {
        return RangesKt.coerceIn(this$0.oetfOrig.invoke(x), obj2, (double)min);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean equals(Object other) {
        boolean eotfOrig;
        int equal;
        Class class2;
        Class class;
        int i = 1;
        if (this == other) {
            return i;
        }
        equal = 0;
        if (other != null) {
            if (getClass() != other.getClass()) {
            } else {
                if (!super.equals(other)) {
                    return equal;
                }
                Object obj = other;
                if (Float.compare(obj.min, this.min) != 0) {
                    return equal;
                }
                if (Float.compare(obj.max, this.max) != 0) {
                    return equal;
                }
                if (!Intrinsics.areEqual(this.whitePoint, obj.whitePoint)) {
                    return equal;
                }
                if (!Arrays.equals(this.primaries, obj.primaries)) {
                    return equal;
                }
                if (this.transferParameters != null) {
                    return Intrinsics.areEqual(this.transferParameters, obj.transferParameters);
                }
                if (obj.transferParameters == null) {
                    return i;
                }
                if (!Intrinsics.areEqual(this.oetfOrig, obj.oetfOrig)) {
                } else {
                    equal = Intrinsics.areEqual(this.eotfOrig, obj.eotfOrig);
                }
            }
            return equal;
        }
        return equal;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] fromLinear(float r, float g, float b) {
        float[] fArr = new float[3];
        return fromLinear(fArr);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] fromLinear(float[] v) {
        int i = 0;
        v[i] = (float)invoke;
        int i2 = 1;
        v[i2] = (float)invoke2;
        int i3 = 2;
        v[i3] = (float)invoke3;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] fromXyz(float[] v) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, v);
        int i = 0;
        v[i] = (float)invoke;
        int i2 = 1;
        v[i2] = (float)invoke2;
        int i3 = 2;
        v[i3] = (float)invoke3;
        return v;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.DoubleFunction getEotfFunc$ui_graphics_release() {
        return this.eotfFunc;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.DoubleFunction getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getInverseTransform() {
        float[] inverseTransform = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(inverseTransform, inverseTransform.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getInverseTransform(float[] inverseTransform) {
        return ArraysKt.copyInto$default(this.inverseTransform, inverseTransform, 0, 0, 0, 14, 0);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int component) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float getMinValue(int component) {
        return this.min;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.DoubleFunction getOetfFunc$ui_graphics_release() {
        return this.oetfFunc;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.DoubleFunction getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getPrimaries() {
        float[] primaries = this.primaries;
        float[] copyOf = Arrays.copyOf(primaries, primaries.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getPrimaries(float[] primaries) {
        return ArraysKt.copyInto$default(this.primaries, primaries, 0, 0, 0, 14, 0);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getTransform() {
        float[] transform = this.transform;
        float[] copyOf = Arrays.copyOf(transform, transform.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getTransform(float[] transform) {
        return ArraysKt.copyInto$default(this.transform, transform, 0, 0, 0, 14, 0);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final androidx.compose.ui.graphics.colorspace.WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public int hashCode() {
        androidx.compose.ui.graphics.colorspace.TransferParameters result;
        int i2;
        int i;
        int floatToIntBits2;
        int floatToIntBits;
        androidx.compose.ui.graphics.colorspace.TransferParameters transferParameters;
        int i3;
        int i4;
        final int i15 = 0;
        i4 = 0;
        i = Float.compare(min, i15) == 0 ? i3 : i4;
        if (i == 0) {
            floatToIntBits2 = Float.floatToIntBits(this.min);
        } else {
            floatToIntBits2 = i4;
        }
        if (Float.compare(max, i15) == 0) {
        } else {
            i3 = i4;
        }
        if (i3 == 0) {
            floatToIntBits = Float.floatToIntBits(this.max);
        } else {
            floatToIntBits = i4;
        }
        if (this.transferParameters != null) {
            i4 = this.transferParameters.hashCode();
        }
        if (this.transferParameters == null) {
            result6 += transferParameters;
        }
        return i2;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] toLinear(float r, float g, float b) {
        float[] fArr = new float[3];
        return toLinear(fArr);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] toLinear(float[] v) {
        int i = 0;
        v[i] = (float)invoke;
        int i2 = 1;
        v[i2] = (float)invoke2;
        int i3 = 2;
        v[i3] = (float)invoke3;
        return v;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        final Object obj = this;
        float f = (float)invoke;
        float f2 = (float)invoke2;
        float f3 = (float)invoke3;
        float[] transform = obj.transform;
        int i2 = 0;
        float[] transform2 = obj.transform;
        int i3 = 0;
        int i = 0;
        return i21 | i22;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] toXyz(float[] v) {
        int i = 0;
        v[i] = (float)invoke;
        int i2 = 1;
        v[i2] = (float)invoke2;
        int i3 = 2;
        v[i3] = (float)invoke3;
        return ColorSpaceKt.mul3x3Float3(this.transform, v);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        float[] transform = this.transform;
        final int i = 0;
        return i4 += i9;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long xyzaToColor-JlNiLsg$ui_graphics_release(float x, float y, float z, float a, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        float[] inverseTransform = this.inverseTransform;
        int i = 0;
        float[] inverseTransform2 = this.inverseTransform;
        int i2 = 0;
        float[] inverseTransform3 = this.inverseTransform;
        int i3 = 0;
        return ColorKt.Color((float)invoke, (float)invoke2, (float)invoke3, a, colorSpace);
    }
}
