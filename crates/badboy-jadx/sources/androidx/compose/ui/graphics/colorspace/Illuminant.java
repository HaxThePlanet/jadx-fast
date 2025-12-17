package androidx.compose.ui.graphics.colorspace;

import _COROUTINE.ArtificialStackFrames;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0014\n\u0002\u0008\r\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0006R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0006R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0006R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0006¨\u0006\u001b", d2 = {"Landroidx/compose/ui/graphics/colorspace/Illuminant;", "", "()V", "A", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getA", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "B", "getB", "C", "getC", "D50", "getD50", "D50Xyz", "", "getD50Xyz$ui_graphics_release", "()[F", "D55", "getD55", "D60", "getD60", "D65", "getD65", "D75", "getD75", "E", "getE", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Illuminant {

    private static final androidx.compose.ui.graphics.colorspace.WhitePoint A;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint B;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint C;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint D50;
    private static final float[] D50Xyz;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint D55;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint D60;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint D65;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint D75;
    private static final androidx.compose.ui.graphics.colorspace.WhitePoint E;
    public static final androidx.compose.ui.graphics.colorspace.Illuminant INSTANCE;
    static {
        Illuminant illuminant = new Illuminant();
        Illuminant.INSTANCE = illuminant;
        WhitePoint whitePoint = new WhitePoint(1055205349, 1053859145);
        Illuminant.A = whitePoint;
        WhitePoint whitePoint2 = new WhitePoint(1051878427, 1051985466);
        Illuminant.B = whitePoint2;
        WhitePoint whitePoint3 = new WhitePoint(1050591279, 1050795961);
        Illuminant.C = whitePoint3;
        WhitePoint whitePoint4 = new WhitePoint(1051786153, 1052216656);
        Illuminant.D50 = whitePoint4;
        WhitePoint whitePoint5 = new WhitePoint(1051341556, 1051845208);
        Illuminant.D55 = whitePoint5;
        WhitePoint whitePoint6 = new WhitePoint(1050981182, 1051517717);
        Illuminant.D60 = whitePoint6;
        WhitePoint whitePoint7 = new WhitePoint(1050680198, 1051227471);
        Illuminant.D65 = whitePoint7;
        WhitePoint whitePoint8 = new WhitePoint(1050220838, 1050752005);
        Illuminant.D75 = whitePoint8;
        int i10 = 1051372091;
        WhitePoint whitePoint9 = new WhitePoint(i10, i10);
        Illuminant.E = whitePoint9;
        float[] fArr = new float[3];
        fArr = new int[]{1064752793, 1065353216, 1062420357};
        Illuminant.D50Xyz = fArr;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getA() {
        return Illuminant.A;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getB() {
        return Illuminant.B;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getC() {
        return Illuminant.C;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getD50() {
        return Illuminant.D50;
    }

    public final float[] getD50Xyz$ui_graphics_release() {
        return Illuminant.D50Xyz;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getD55() {
        return Illuminant.D55;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getD60() {
        return Illuminant.D60;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getD65() {
        return Illuminant.D65;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getD75() {
        return Illuminant.D75;
    }

    public final androidx.compose.ui.graphics.colorspace.WhitePoint getE() {
        return Illuminant.E;
    }
}
