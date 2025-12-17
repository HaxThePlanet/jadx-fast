package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0014\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001f\u0008\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B9\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c¢\u0006\u0002\u0010\rJ \u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0007J\u0012\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0001\u0010\u0018\u001a\u00020\u000cH\u0017J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "transformSource", "transformDestination", "renderIntent", "transform", "", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDestination", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getRenderIntent-uksYyKA", "()I", "I", "getSource", "r", "", "g", "b", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class Connector {

    public static final androidx.compose.ui.graphics.colorspace.Connector.Companion Companion;
    private final androidx.compose.ui.graphics.colorspace.ColorSpace destination;
    private final int renderIntent;
    private final androidx.compose.ui.graphics.colorspace.ColorSpace source;
    private final float[] transform;
    private final androidx.compose.ui.graphics.colorspace.ColorSpace transformDestination;
    private final androidx.compose.ui.graphics.colorspace.ColorSpace transformSource;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0008\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "()V", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "Landroidx/compose/ui/graphics/colorspace/Connector;", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final float[] access$computeTransform-YBCOT_4(androidx.compose.ui.graphics.colorspace.Connector.Companion $this, androidx.compose.ui.graphics.colorspace.ColorSpace source, androidx.compose.ui.graphics.colorspace.ColorSpace destination, int intent) {
            return $this.computeTransform-YBCOT_4(source, destination, intent);
        }

        private final float[] computeTransform-YBCOT_4(androidx.compose.ui.graphics.colorspace.ColorSpace source, androidx.compose.ui.graphics.colorspace.ColorSpace destination, int intent) {
            Object obj;
            float[] d50Xyz$ui_graphics_release;
            float[] d50Xyz$ui_graphics_release2;
            int i = 0;
            if (!RenderIntent.equals-impl0(intent, RenderIntent.Companion.getAbsolute-uksYyKA())) {
                return i;
            }
            boolean equals-impl02 = ColorModel.equals-impl0(source.getModel-xdoWZVw(), obj3);
            boolean equals-impl03 = ColorModel.equals-impl0(destination.getModel-xdoWZVw(), obj3);
            if (equals-impl02 && equals-impl03) {
                if (equals-impl03) {
                    return i;
                }
            }
            if (!equals-impl02 && equals-impl03) {
                if (equals-impl03) {
                }
                return i;
            }
            obj = equals-impl02 ? source : destination;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            if (equals-impl02) {
                d50Xyz$ui_graphics_release = (Rgb)obj.getWhitePoint().toXyz$ui_graphics_release();
            } else {
                d50Xyz$ui_graphics_release = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            }
            if (equals-impl03) {
                d50Xyz$ui_graphics_release2 = obj.getWhitePoint().toXyz$ui_graphics_release();
            } else {
                d50Xyz$ui_graphics_release2 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            }
            final int i2 = 0;
            int i4 = 1;
            int i6 = 2;
            float[] fArr = new float[3];
            fArr[i2] = f /= f2;
            fArr[i4] = f3 /= f4;
            fArr[i6] = f5 /= f6;
            return fArr;
        }

        public final androidx.compose.ui.graphics.colorspace.Connector identity$ui_graphics_release(androidx.compose.ui.graphics.colorspace.ColorSpace source) {
            Connector.Companion.identity.1 anon = new Connector.Companion.identity.1(source, RenderIntent.Companion.getRelative-uksYyKA());
            return (Connector)anon;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0014\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "computeTransform", "source", "destination", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "transform", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "color", "transformToColor-l2rxGTc$ui_graphics_release", "(J)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RgbConnector extends androidx.compose.ui.graphics.colorspace.Connector {

        private final androidx.compose.ui.graphics.colorspace.Rgb mDestination;
        private final androidx.compose.ui.graphics.colorspace.Rgb mSource;
        private final float[] mTransform;
        private RgbConnector(androidx.compose.ui.graphics.colorspace.Rgb mSource, androidx.compose.ui.graphics.colorspace.Rgb mDestination, int intent) {
            final Object obj = this;
            final int i = intent;
            super((ColorSpace)mSource, (ColorSpace)mDestination, (ColorSpace)mSource, (ColorSpace)mDestination, i, 0, 0);
            obj.mSource = mSource;
            obj.mDestination = mDestination;
            obj.mTransform = computeTransform-YBCOT_4(obj.mSource, obj.mDestination, i);
        }

        public RgbConnector(androidx.compose.ui.graphics.colorspace.Rgb rgb, androidx.compose.ui.graphics.colorspace.Rgb rgb2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            super(rgb, rgb2, i3);
        }

        private final float[] computeTransform-YBCOT_4(androidx.compose.ui.graphics.colorspace.Rgb source, androidx.compose.ui.graphics.colorspace.Rgb destination, int intent) {
            float[] transform;
            float[] inverseTransform;
            boolean chromaticAdaptation;
            boolean chromaticAdaptation2;
            boolean equals-impl0;
            String str;
            float[] transform$ui_graphics_release;
            androidx.compose.ui.graphics.colorspace.WhitePoint copyOf;
            int length;
            int i;
            int i2;
            float[] fArr;
            if (ColorSpaceKt.compare(source.getWhitePoint(), destination.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(destination.getInverseTransform$ui_graphics_release(), source.getTransform$ui_graphics_release());
            }
            transform = source.getTransform$ui_graphics_release();
            inverseTransform = destination.getInverseTransform$ui_graphics_release();
            float[] xyz$ui_graphics_release = source.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = destination.getWhitePoint().toXyz$ui_graphics_release();
            str = "copyOf(this, size)";
            if (!ColorSpaceKt.compare(source.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] d50Xyz$ui_graphics_release = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                float[] copyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, str);
                transform = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), xyz$ui_graphics_release, copyOf2), source.getTransform$ui_graphics_release());
            }
            if (!ColorSpaceKt.compare(destination.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] d50Xyz$ui_graphics_release2 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                copyOf = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, str);
                inverseTransform = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(Adaptation.Companion.getBradford().getTransform$ui_graphics_release(), xyz$ui_graphics_release2, copyOf), destination.getTransform$ui_graphics_release()));
            }
            if (RenderIntent.equals-impl0(intent, RenderIntent.Companion.getAbsolute-uksYyKA())) {
                equals-impl0 = 0;
                copyOf = 1;
                i = 2;
                fArr = new float[3];
                fArr[equals-impl0] = f /= f2;
                fArr[copyOf] = f3 /= f4;
                fArr[i] = f5 /= f6;
                transform = ColorSpaceKt.mul3x3Diag(fArr, transform);
            }
            return ColorSpaceKt.mul3x3(inverseTransform, transform);
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        public float[] transform(float[] v) {
            int i = 0;
            v[i] = (float)invoke3;
            int i3 = 1;
            v[i3] = (float)invoke4;
            int i4 = 2;
            v[i4] = (float)invoke5;
            ColorSpaceKt.mul3x3Float3(this.mTransform, v);
            v[i] = (float)invoke6;
            v[i3] = (float)invoke;
            v[i4] = (float)invoke2;
            return v;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        public long transformToColor-l2rxGTc$ui_graphics_release(long color) {
            final Object obj = this;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            float f = (float)invoke;
            float f2 = (float)invoke2;
            float f3 = (float)invoke3;
            float[] mTransform = obj.mTransform;
            int i5 = 0;
            float[] mTransform2 = obj.mTransform;
            int i6 = 0;
            float[] mTransform3 = obj.mTransform;
            int i7 = 0;
            return ColorKt.Color((float)invoke4, (float)invoke5, (float)invoke6, Color.getAlpha-impl(color), (ColorSpace)obj.mDestination);
        }
    }
    static {
        Connector.Companion companion = new Connector.Companion(0);
        Connector.Companion = companion;
    }

    private Connector(androidx.compose.ui.graphics.colorspace.ColorSpace source, androidx.compose.ui.graphics.colorspace.ColorSpace destination, int intent) {
        androidx.compose.ui.graphics.colorspace.ColorSpace adapt$default;
        boolean adapt$default2;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2;
        final int i = 2;
        int i2 = 0;
        if (ColorModel.equals-impl0(source.getModel-xdoWZVw(), obj1)) {
            colorSpace = adapt$default;
        } else {
            colorSpace = source;
        }
        if (ColorModel.equals-impl0(destination.getModel-xdoWZVw(), obj4)) {
            colorSpace2 = adapt$default2;
        } else {
            colorSpace2 = destination;
        }
        super(source, destination, colorSpace, colorSpace2, intent, Connector.Companion.access$computeTransform-YBCOT_4(Connector.Companion, source, destination, intent), 0);
    }

    public Connector(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(colorSpace, colorSpace2, i3);
    }

    private Connector(androidx.compose.ui.graphics.colorspace.ColorSpace source, androidx.compose.ui.graphics.colorspace.ColorSpace destination, androidx.compose.ui.graphics.colorspace.ColorSpace transformSource, androidx.compose.ui.graphics.colorspace.ColorSpace transformDestination, int renderIntent, float[] transform) {
        super();
        this.source = source;
        this.destination = destination;
        this.transformSource = transformSource;
        this.transformDestination = transformDestination;
        this.renderIntent = renderIntent;
        this.transform = transform;
    }

    public Connector(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace3, androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace4, int i5, float[] f6Arr6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(colorSpace, colorSpace2, colorSpace3, colorSpace4, i5, f6Arr6);
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getDestination() {
        return this.destination;
    }

    public final int getRenderIntent-uksYyKA() {
        return this.renderIntent;
    }

    public final androidx.compose.ui.graphics.colorspace.ColorSpace getSource() {
        return this.source;
    }

    public final float[] transform(float r, float g, float b) {
        float[] fArr = new float[3];
        return transform(fArr);
    }

    public float[] transform(float[] v) {
        float[] transform;
        int i;
        float f;
        float[] xyz = this.transformSource.toXyz(v);
        if (this.transform != null) {
            int i2 = 0;
            xyz[i2] = f2 *= f5;
            int i3 = 1;
            xyz[i3] = f3 *= f6;
            transform = 2;
            xyz[transform] = f4 *= f;
        }
        return this.transformDestination.fromXyz(xyz);
    }

    public long transformToColor-l2rxGTc$ui_graphics_release(long color) {
        int z;
        int bits$iv$iv;
        int y;
        int i2;
        int i;
        int i3 = 0;
        float $i$f$component1Impl = Color.getRed-impl(color);
        int i4 = 0;
        float $i$f$component2Impl = Color.getGreen-impl(color);
        int i5 = 0;
        float $i$f$component3Impl = Color.getBlue-impl(color);
        int i6 = 0;
        final long xy$ui_graphics_release = this.transformSource.toXy$ui_graphics_release($i$f$component1Impl, $i$f$component2Impl, $i$f$component3Impl);
        int i7 = 0;
        int i12 = 0;
        bits$iv$iv = Float.intBitsToFloat((int)i10);
        int i8 = 0;
        int i15 = 0;
        float bits$iv$iv2 = Float.intBitsToFloat((int)i13);
        z = this.transformSource.toZ$ui_graphics_release($i$f$component1Impl, $i$f$component2Impl, $i$f$component3Impl);
        if (this.transform != null) {
            i = z;
            i2 = y2;
            y = bits$iv$iv;
        } else {
            i = z;
            i2 = bits$iv$iv2;
            y = bits$iv$iv;
        }
        return this.transformDestination.xyzaToColor-JlNiLsg$ui_graphics_release(y, i2, i, Color.getAlpha-impl(color), this.destination);
    }
}
