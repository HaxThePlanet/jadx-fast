package androidx.compose.ui;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008ç\u0080\u0001\u0018\u0000 \u000b2\u00020\u0001:\u0003\u000b\u000c\rJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/Alignment;", "", "align", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "align-KFBX0sM", "(JJLandroidx/compose/ui/unit/LayoutDirection;)J", "Companion", "Horizontal", "Vertical", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Alignment {

    public static final androidx.compose.ui.Alignment.Companion Companion;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u001c\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000e\u0010\u0002\u001a\u0004\u0008\u000f\u0010\u000cR\u001c\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0011\u0010\u0002\u001a\u0004\u0008\u0012\u0010\u000cR\u001c\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0014\u0010\u0002\u001a\u0004\u0008\u0015\u0010\u000cR\u001c\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0017\u0010\u0002\u001a\u0004\u0008\u0018\u0010\u000cR\u001c\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001b\u0010\u0002\u001a\u0004\u0008\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u000cR\u001c\u0010!\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\"\u0010\u0002\u001a\u0004\u0008#\u0010\u0007R\u001c\u0010$\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008%\u0010\u0002\u001a\u0004\u0008&\u0010\u001dR\u001c\u0010'\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008(\u0010\u0002\u001a\u0004\u0008)\u0010\u001dR\u001c\u0010*\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008+\u0010\u0002\u001a\u0004\u0008,\u0010\u0007R\u001c\u0010-\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008.\u0010\u0002\u001a\u0004\u0008/\u0010\u000cR\u001c\u00100\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00081\u0010\u0002\u001a\u0004\u00082\u0010\u000cR\u001c\u00103\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00084\u0010\u0002\u001a\u0004\u00085\u0010\u000c¨\u00066", d2 = {"Landroidx/compose/ui/Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/Alignment$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/ui/Alignment$Vertical;", "BottomCenter", "Landroidx/compose/ui/Alignment;", "getBottomCenter$annotations", "getBottomCenter", "()Landroidx/compose/ui/Alignment;", "BottomEnd", "getBottomEnd$annotations", "getBottomEnd", "BottomStart", "getBottomStart$annotations", "getBottomStart", "Center", "getCenter$annotations", "getCenter", "CenterEnd", "getCenterEnd$annotations", "getCenterEnd", "CenterHorizontally", "Landroidx/compose/ui/Alignment$Horizontal;", "getCenterHorizontally$annotations", "getCenterHorizontally", "()Landroidx/compose/ui/Alignment$Horizontal;", "CenterStart", "getCenterStart$annotations", "getCenterStart", "CenterVertically", "getCenterVertically$annotations", "getCenterVertically", "End", "getEnd$annotations", "getEnd", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "TopCenter", "getTopCenter$annotations", "getTopCenter", "TopEnd", "getTopEnd$annotations", "getTopEnd", "TopStart", "getTopStart$annotations", "getTopStart", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.Alignment.Companion $$INSTANCE;
        private static final androidx.compose.ui.Alignment.Vertical Bottom;
        private static final androidx.compose.ui.Alignment BottomCenter;
        private static final androidx.compose.ui.Alignment BottomEnd;
        private static final androidx.compose.ui.Alignment BottomStart;
        private static final androidx.compose.ui.Alignment Center;
        private static final androidx.compose.ui.Alignment CenterEnd;
        private static final androidx.compose.ui.Alignment.Horizontal CenterHorizontally;
        private static final androidx.compose.ui.Alignment CenterStart;
        private static final androidx.compose.ui.Alignment.Vertical CenterVertically;
        private static final androidx.compose.ui.Alignment.Horizontal End;
        private static final androidx.compose.ui.Alignment.Horizontal Start;
        private static final androidx.compose.ui.Alignment.Vertical Top;
        private static final androidx.compose.ui.Alignment TopCenter;
        private static final androidx.compose.ui.Alignment TopEnd;
        private static final androidx.compose.ui.Alignment TopStart;
        static {
            Alignment.Companion companion = new Alignment.Companion();
            Alignment.Companion.$$INSTANCE = companion;
            final int i = -1082130432;
            BiasAlignment biasAlignment = new BiasAlignment(i, i);
            Alignment.Companion.TopStart = (Alignment)biasAlignment;
            final int i2 = 0;
            BiasAlignment biasAlignment2 = new BiasAlignment(i2, i);
            Alignment.Companion.TopCenter = (Alignment)biasAlignment2;
            final int i3 = 1065353216;
            BiasAlignment biasAlignment3 = new BiasAlignment(i3, i);
            Alignment.Companion.TopEnd = (Alignment)biasAlignment3;
            BiasAlignment biasAlignment4 = new BiasAlignment(i, i2);
            Alignment.Companion.CenterStart = (Alignment)biasAlignment4;
            BiasAlignment biasAlignment5 = new BiasAlignment(i2, i2);
            Alignment.Companion.Center = (Alignment)biasAlignment5;
            BiasAlignment biasAlignment6 = new BiasAlignment(i3, i2);
            Alignment.Companion.CenterEnd = (Alignment)biasAlignment6;
            BiasAlignment biasAlignment7 = new BiasAlignment(i, i3);
            Alignment.Companion.BottomStart = (Alignment)biasAlignment7;
            BiasAlignment biasAlignment8 = new BiasAlignment(i2, i3);
            Alignment.Companion.BottomCenter = (Alignment)biasAlignment8;
            BiasAlignment biasAlignment9 = new BiasAlignment(i3, i3);
            Alignment.Companion.BottomEnd = (Alignment)biasAlignment9;
            BiasAlignment.Vertical vertical = new BiasAlignment.Vertical(i);
            Alignment.Companion.Top = (Alignment.Vertical)vertical;
            BiasAlignment.Vertical vertical2 = new BiasAlignment.Vertical(i2);
            Alignment.Companion.CenterVertically = (Alignment.Vertical)vertical2;
            BiasAlignment.Vertical vertical3 = new BiasAlignment.Vertical(i3);
            Alignment.Companion.Bottom = (Alignment.Vertical)vertical3;
            BiasAlignment.Horizontal horizontal = new BiasAlignment.Horizontal(i);
            Alignment.Companion.Start = (Alignment.Horizontal)horizontal;
            BiasAlignment.Horizontal horizontal2 = new BiasAlignment.Horizontal(i2);
            Alignment.Companion.CenterHorizontally = (Alignment.Horizontal)horizontal2;
            BiasAlignment.Horizontal horizontal3 = new BiasAlignment.Horizontal(i3);
            Alignment.Companion.End = (Alignment.Horizontal)horizontal3;
        }

        public static void getBottom$annotations() {
        }

        public static void getBottomCenter$annotations() {
        }

        public static void getBottomEnd$annotations() {
        }

        public static void getBottomStart$annotations() {
        }

        public static void getCenter$annotations() {
        }

        public static void getCenterEnd$annotations() {
        }

        public static void getCenterHorizontally$annotations() {
        }

        public static void getCenterStart$annotations() {
        }

        public static void getCenterVertically$annotations() {
        }

        public static void getEnd$annotations() {
        }

        public static void getStart$annotations() {
        }

        public static void getTop$annotations() {
        }

        public static void getTopCenter$annotations() {
        }

        public static void getTopEnd$annotations() {
        }

        public static void getTopStart$annotations() {
        }

        public final androidx.compose.ui.Alignment.Vertical getBottom() {
            return Alignment.Companion.Bottom;
        }

        public final androidx.compose.ui.Alignment getBottomCenter() {
            return Alignment.Companion.BottomCenter;
        }

        public final androidx.compose.ui.Alignment getBottomEnd() {
            return Alignment.Companion.BottomEnd;
        }

        public final androidx.compose.ui.Alignment getBottomStart() {
            return Alignment.Companion.BottomStart;
        }

        public final androidx.compose.ui.Alignment getCenter() {
            return Alignment.Companion.Center;
        }

        public final androidx.compose.ui.Alignment getCenterEnd() {
            return Alignment.Companion.CenterEnd;
        }

        public final androidx.compose.ui.Alignment.Horizontal getCenterHorizontally() {
            return Alignment.Companion.CenterHorizontally;
        }

        public final androidx.compose.ui.Alignment getCenterStart() {
            return Alignment.Companion.CenterStart;
        }

        public final androidx.compose.ui.Alignment.Vertical getCenterVertically() {
            return Alignment.Companion.CenterVertically;
        }

        public final androidx.compose.ui.Alignment.Horizontal getEnd() {
            return Alignment.Companion.End;
        }

        public final androidx.compose.ui.Alignment.Horizontal getStart() {
            return Alignment.Companion.Start;
        }

        public final androidx.compose.ui.Alignment.Vertical getTop() {
            return Alignment.Companion.Top;
        }

        public final androidx.compose.ui.Alignment getTopCenter() {
            return Alignment.Companion.TopCenter;
        }

        public final androidx.compose.ui.Alignment getTopEnd() {
            return Alignment.Companion.TopEnd;
        }

        public final androidx.compose.ui.Alignment getTopStart() {
            return Alignment.Companion.TopStart;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/compose/ui/Alignment$Horizontal;", "", "align", "", "size", "space", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Horizontal {
        public abstract int align(int i, int i2, LayoutDirection layoutDirection3);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008ç\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0001", d2 = {"Landroidx/compose/ui/Alignment$Vertical;", "", "align", "", "size", "space", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Vertical {
        public abstract int align(int i, int i2);
    }
    static {
        Alignment.Companion = Alignment.Companion.$$INSTANCE;
    }

    public abstract long align-KFBX0sM(long l, long l2, LayoutDirection layoutDirection3);
}
