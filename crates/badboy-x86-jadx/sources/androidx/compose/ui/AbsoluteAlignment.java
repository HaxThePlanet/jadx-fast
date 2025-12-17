package androidx.compose.ui;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0017\u0010\u0002\u001a\u0004\u0008\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001a\u0010\u0002\u001a\u0004\u0008\u001b\u0010\u0007R\u001c\u0010\u001c\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001d\u0010\u0002\u001a\u0004\u0008\u001e\u0010\u0007¨\u0006\u001f", d2 = {"Landroidx/compose/ui/AbsoluteAlignment;", "", "()V", "BottomLeft", "Landroidx/compose/ui/Alignment;", "getBottomLeft$annotations", "getBottomLeft", "()Landroidx/compose/ui/Alignment;", "BottomRight", "getBottomRight$annotations", "getBottomRight", "CenterLeft", "getCenterLeft$annotations", "getCenterLeft", "CenterRight", "getCenterRight$annotations", "getCenterRight", "Left", "Landroidx/compose/ui/Alignment$Horizontal;", "getLeft$annotations", "getLeft", "()Landroidx/compose/ui/Alignment$Horizontal;", "Right", "getRight$annotations", "getRight", "TopLeft", "getTopLeft$annotations", "getTopLeft", "TopRight", "getTopRight$annotations", "getTopRight", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AbsoluteAlignment {

    public static final int $stable;
    private static final androidx.compose.ui.Alignment BottomLeft;
    private static final androidx.compose.ui.Alignment BottomRight;
    private static final androidx.compose.ui.Alignment CenterLeft;
    private static final androidx.compose.ui.Alignment CenterRight;
    public static final androidx.compose.ui.AbsoluteAlignment INSTANCE;
    private static final androidx.compose.ui.Alignment.Horizontal Left;
    private static final androidx.compose.ui.Alignment.Horizontal Right;
    private static final androidx.compose.ui.Alignment TopLeft;
    private static final androidx.compose.ui.Alignment TopRight;
    static {
        AbsoluteAlignment absoluteAlignment = new AbsoluteAlignment();
        AbsoluteAlignment.INSTANCE = absoluteAlignment;
        final int i = -1082130432;
        BiasAbsoluteAlignment biasAbsoluteAlignment = new BiasAbsoluteAlignment(i, i);
        AbsoluteAlignment.TopLeft = (Alignment)biasAbsoluteAlignment;
        final int i2 = 1065353216;
        BiasAbsoluteAlignment biasAbsoluteAlignment2 = new BiasAbsoluteAlignment(i2, i);
        AbsoluteAlignment.TopRight = (Alignment)biasAbsoluteAlignment2;
        final int i3 = 0;
        BiasAbsoluteAlignment biasAbsoluteAlignment3 = new BiasAbsoluteAlignment(i, i3);
        AbsoluteAlignment.CenterLeft = (Alignment)biasAbsoluteAlignment3;
        BiasAbsoluteAlignment biasAbsoluteAlignment4 = new BiasAbsoluteAlignment(i2, i3);
        AbsoluteAlignment.CenterRight = (Alignment)biasAbsoluteAlignment4;
        BiasAbsoluteAlignment biasAbsoluteAlignment5 = new BiasAbsoluteAlignment(i, i2);
        AbsoluteAlignment.BottomLeft = (Alignment)biasAbsoluteAlignment5;
        BiasAbsoluteAlignment biasAbsoluteAlignment6 = new BiasAbsoluteAlignment(i2, i2);
        AbsoluteAlignment.BottomRight = (Alignment)biasAbsoluteAlignment6;
        BiasAbsoluteAlignment.Horizontal horizontal = new BiasAbsoluteAlignment.Horizontal(i);
        AbsoluteAlignment.Left = (Alignment.Horizontal)horizontal;
        BiasAbsoluteAlignment.Horizontal horizontal2 = new BiasAbsoluteAlignment.Horizontal(i2);
        AbsoluteAlignment.Right = (Alignment.Horizontal)horizontal2;
    }

    public static void getBottomLeft$annotations() {
    }

    public static void getBottomRight$annotations() {
    }

    public static void getCenterLeft$annotations() {
    }

    public static void getCenterRight$annotations() {
    }

    public static void getLeft$annotations() {
    }

    public static void getRight$annotations() {
    }

    public static void getTopLeft$annotations() {
    }

    public static void getTopRight$annotations() {
    }

    public final androidx.compose.ui.Alignment getBottomLeft() {
        return AbsoluteAlignment.BottomLeft;
    }

    public final androidx.compose.ui.Alignment getBottomRight() {
        return AbsoluteAlignment.BottomRight;
    }

    public final androidx.compose.ui.Alignment getCenterLeft() {
        return AbsoluteAlignment.CenterLeft;
    }

    public final androidx.compose.ui.Alignment getCenterRight() {
        return AbsoluteAlignment.CenterRight;
    }

    public final androidx.compose.ui.Alignment.Horizontal getLeft() {
        return AbsoluteAlignment.Left;
    }

    public final androidx.compose.ui.Alignment.Horizontal getRight() {
        return AbsoluteAlignment.Right;
    }

    public final androidx.compose.ui.Alignment getTopLeft() {
        return AbsoluteAlignment.TopLeft;
    }

    public final androidx.compose.ui.Alignment getTopRight() {
        return AbsoluteAlignment.TopRight;
    }
}
