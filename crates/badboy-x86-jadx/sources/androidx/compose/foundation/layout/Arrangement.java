package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001:\u0005EFGHIB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020$H\u0007J-\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u0008.J%\u0010/\u001a\u00020&2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u00080J-\u00101\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u00082J-\u00103\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u00084J-\u00105\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u00086J-\u00107\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0000¢\u0006\u0002\u00088J\u001a\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\"\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\"\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;2\u0006\u0010\"\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010@J/\u0010A\u001a\u00020&*\u00020*2\u0006\u0010B\u001a\u00020-2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020&0DH\u0082\u0008R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0013\u0010\u0002\u001a\u0004\u0008\u0014\u0010\u000cR\u001c\u0010\u0015\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0016\u0010\u0002\u001a\u0004\u0008\u0017\u0010\u000cR\u001c\u0010\u0018\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0019\u0010\u0002\u001a\u0004\u0008\u001a\u0010\u000cR\u001c\u0010\u001b\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001c\u0010\u0002\u001a\u0004\u0008\u001d\u0010\u0011R\u001c\u0010\u001e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001f\u0010\u0002\u001a\u0004\u0008 \u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006J", d2 = {"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Arrangement {

    public static final int $stable;
    private static final androidx.compose.foundation.layout.Arrangement.Vertical Bottom;
    private static final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical Center;
    private static final androidx.compose.foundation.layout.Arrangement.Horizontal End;
    public static final androidx.compose.foundation.layout.Arrangement INSTANCE;
    private static final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical SpaceAround;
    private static final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical SpaceBetween;
    private static final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical SpaceEvenly;
    private static final androidx.compose.foundation.layout.Arrangement.Horizontal Start;
    private static final androidx.compose.foundation.layout.Arrangement.Vertical Top;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000cH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Horizontal {
        public static float access$getSpacing-D9Ej5fM$jd(androidx.compose.foundation.layout.Arrangement.Horizontal $this) {
            return super.getSpacing-D9Ej5fM();
        }

        public abstract void arrange(Density density, int i2, int[] i3Arr3, LayoutDirection layoutDirection4, int[] i5Arr5);

        public float getSpacing-D9Ej5fM() {
            final int i2 = 0;
            return Dp.constructor-impl((float)i);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fJ\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!J\"\u0010\u001a\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020#H\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010$R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002\u001a\u0004\u0008\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0012\u0010\u0002\u001a\u0004\u0008\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0002\u001a\u0004\u0008\u0016\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", "", "()V", "Center", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "getLeft$annotations", "getLeft", "Right", "getRight$annotations", "getRight", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Landroidx/compose/ui/Alignment$Vertical;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Absolute {

        public static final int $stable;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal Center;
        public static final androidx.compose.foundation.layout.Arrangement.Absolute INSTANCE;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal Left;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal Right;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal SpaceAround;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal SpaceBetween;
        private static final androidx.compose.foundation.layout.Arrangement.Horizontal SpaceEvenly;
        static {
            Arrangement.Absolute absolute = new Arrangement.Absolute();
            Arrangement.Absolute.INSTANCE = absolute;
            Arrangement.Absolute.Left.1 anon = new Arrangement.Absolute.Left.1();
            Arrangement.Absolute.Left = (Arrangement.Horizontal)anon;
            Arrangement.Absolute.Center.1 anon2 = new Arrangement.Absolute.Center.1();
            Arrangement.Absolute.Center = (Arrangement.Horizontal)anon2;
            Arrangement.Absolute.Right.1 anon3 = new Arrangement.Absolute.Right.1();
            Arrangement.Absolute.Right = (Arrangement.Horizontal)anon3;
            Arrangement.Absolute.SpaceBetween.1 anon4 = new Arrangement.Absolute.SpaceBetween.1();
            Arrangement.Absolute.SpaceBetween = (Arrangement.Horizontal)anon4;
            Arrangement.Absolute.SpaceEvenly.1 anon5 = new Arrangement.Absolute.SpaceEvenly.1();
            Arrangement.Absolute.SpaceEvenly = (Arrangement.Horizontal)anon5;
            Arrangement.Absolute.SpaceAround.1 anon6 = new Arrangement.Absolute.SpaceAround.1();
            Arrangement.Absolute.SpaceAround = (Arrangement.Horizontal)anon6;
        }

        public static void getCenter$annotations() {
        }

        public static void getLeft$annotations() {
        }

        public static void getRight$annotations() {
        }

        public static void getSpaceAround$annotations() {
        }

        public static void getSpaceBetween$annotations() {
        }

        public static void getSpaceEvenly$annotations() {
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal aligned(Alignment.Horizontal alignment) {
            int i2 = 0;
            Arrangement.Absolute.aligned.1 $i$f$getDp = new Arrangement.Absolute.aligned.1(alignment);
            Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(Dp.constructor-impl((float)i), 0, (Function2)$i$f$getDp, 0);
            return (Arrangement.Horizontal)spacedAligned;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getCenter() {
            return Arrangement.Absolute.Center;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getLeft() {
            return Arrangement.Absolute.Left;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getRight() {
            return Arrangement.Absolute.Right;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getSpaceAround() {
            return Arrangement.Absolute.SpaceAround;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getSpaceBetween() {
            return Arrangement.Absolute.SpaceBetween;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal getSpaceEvenly() {
            return Arrangement.Absolute.SpaceEvenly;
        }

        public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spacedBy-0680j_4(float space) {
            final int i2 = 0;
            Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 0, i2, i2);
            return (Arrangement.HorizontalOrVertical)spacedAligned;
        }

        public final androidx.compose.foundation.layout.Arrangement.Horizontal spacedBy-D5KLDUw(float space, Alignment.Horizontal alignment) {
            Arrangement.Absolute.spacedBy.1 anon = new Arrangement.Absolute.spacedBy.1(alignment);
            Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 0, (Function2)anon, 0);
            return (Arrangement.Horizontal)spacedAligned;
        }

        public final androidx.compose.foundation.layout.Arrangement.Vertical spacedBy-D5KLDUw(float space, Alignment.Vertical alignment) {
            Arrangement.Absolute.spacedBy.2 anon = new Arrangement.Absolute.spacedBy.2(alignment);
            Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 0, (Function2)anon, 0);
            return (Arrangement.Vertical)spacedAligned;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0002\u0008g\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0003", d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Vertical {
        public static float access$getSpacing-D9Ej5fM$jd(androidx.compose.foundation.layout.Arrangement.Vertical $this) {
            return super.getSpacing-D9Ej5fM();
        }

        public abstract void arrange(Density density, int i2, int[] i3Arr3, int[] i4Arr4);

        public float getSpacing-D9Ej5fM() {
            final int i2 = 0;
            return Dp.constructor-impl((float)i);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u00002\u00020\u00012\u00020\u0002R\u001a\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0003", d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface HorizontalOrVertical extends androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical {
        public static float access$getSpacing-D9Ej5fM$jd(androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical $this) {
            return super.getSpacing-D9Ej5fM();
        }

        @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
        public float getSpacing-D9Ej5fM() {
            final int i2 = 0;
            return Dp.constructor-impl((float)i);
        }
    }

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0003\u0008\u0081\u0008\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0010J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0008\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0008HÖ\u0001J\u0008\u0010\u001f\u001a\u00020 H\u0016J,\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020&H\u0016J$\u0010!\u001a\u00020\"*\u00020#2\u0006\u0010$\u001a\u00020\u00082\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016R%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u0003X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0013\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006)", d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SpacedAligned implements androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical {

        public static final int $stable;
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;
        static {
        }

        private SpacedAligned(float space, boolean rtlMirror, Function2<? super Integer, ? super LayoutDirection, Integer> alignment) {
            super();
            this.space = space;
            this.rtlMirror = rtlMirror;
            this.alignment = alignment;
            this.spacing = this.space;
        }

        public SpacedAligned(float f, boolean z2, Function2 function23, DefaultConstructorMarker defaultConstructorMarker4) {
            super(f, z2, function23);
        }

        public static androidx.compose.foundation.layout.Arrangement.SpacedAligned copy-8Feqmps$default(androidx.compose.foundation.layout.Arrangement.SpacedAligned arrangement$SpacedAligned, float f2, boolean z3, Function2 function24, int i5, Object object6) {
            float obj1;
            boolean obj2;
            Function2 obj3;
            if (i5 & 1 != 0) {
                obj1 = spacedAligned.space;
            }
            if (i5 & 2 != 0) {
                obj2 = spacedAligned.rtlMirror;
            }
            if (i5 &= 4 != 0) {
                obj3 = spacedAligned.alignment;
            }
            return spacedAligned.copy-8Feqmps(obj1, obj2, obj3);
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public void arrange(Density $this$arrange, int totalSize, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            int i10;
            Function2 intValue;
            int i5;
            int i8;
            int index;
            int length;
            int occupied;
            int lastSpace;
            int lastSpace2;
            int i7;
            boolean rtlMirror;
            int i4;
            int i9;
            int i$iv;
            int i;
            int i2;
            int i11;
            int i6;
            int i3;
            final Object obj = this;
            final int i12 = totalSize;
            final LayoutDirection layoutDirection2 = layoutDirection;
            final int[] iArr = outPositions;
            length = 1;
            i5 = i10.length == 0 ? length : 0;
            if (i5 != 0) {
            }
            int roundToPx-0680j_4 = $this$arrange.roundToPx-0680j_4(obj.space);
            if (obj.rtlMirror && layoutDirection2 == LayoutDirection.Rtl) {
                i7 = layoutDirection2 == LayoutDirection.Rtl ? length : 0;
            } else {
            }
            final androidx.compose.foundation.layout.Arrangement iNSTANCE = Arrangement.INSTANCE;
            final int i28 = sizes;
            final int i29 = 0;
            if (i7 == 0) {
                length = i28;
                i4 = 0;
                i = i31;
                i$iv = lastSpace;
                lastSpace2 = occupied;
                occupied = 0;
                while (occupied < length.length) {
                    i6 = i2;
                    i3 = 0;
                    iArr[i] = Math.min(lastSpace2, i12 - i6);
                    lastSpace2 = i25 + i$iv;
                    occupied++;
                    i10 = sizes;
                    i = i11;
                }
            } else {
                length2 -= length;
                while (-1 < i10) {
                    i8 = i28[i10];
                    length = i10;
                    i4 = 0;
                    iArr[length] = Math.min(occupied, i12 - i8);
                    occupied = i18 + lastSpace;
                    i10 = i9 + -1;
                }
                int i30 = i10;
                i$iv = lastSpace;
                lastSpace2 = occupied;
            }
            lastSpace2 -= i$iv;
            if (obj.alignment != null && occupied2 < i12) {
                if (occupied2 < i12) {
                    index = 0;
                    while (index < iArr.length) {
                        iArr[index] = i27 += intValue;
                        index++;
                    }
                }
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public void arrange(Density $this$arrange, int totalSize, int[] sizes, int[] outPositions) {
            this.arrange($this$arrange, totalSize, sizes, LayoutDirection.Ltr, outPositions);
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public final float component1-D9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public final boolean component2() {
            return this.rtlMirror;
        }

        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        public final androidx.compose.foundation.layout.Arrangement.SpacedAligned copy-8Feqmps(float f, boolean z2, Function2<? super Integer, ? super LayoutDirection, Integer> function23) {
            Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(f, z2, function23, 0);
            return spacedAligned;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof Arrangement.SpacedAligned) {
                return i2;
            }
            Object obj = object;
            if (!Dp.equals-impl0(this.space, obj.space)) {
                return i2;
            }
            if (this.rtlMirror != obj.rtlMirror) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
                return i2;
            }
            return i;
        }

        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public final float getSpace-D9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public float getSpacing-D9Ej5fM() {
            return this.spacing;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public int hashCode() {
            int i;
            if (this.alignment == null) {
                i = 0;
            } else {
                i = this.alignment.hashCode();
            }
            return i3 += i;
        }

        @Override // androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical
        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            str = this.rtlMirror ? "" : "Absolute";
            return stringBuilder.append(str).append("Arrangement#spacedAligned(").append(Dp.toString-impl(this.space)).append(", ").append(this.alignment).append(')').toString();
        }
    }
    static {
        Arrangement arrangement = new Arrangement();
        Arrangement.INSTANCE = arrangement;
        Arrangement.Start.1 anon = new Arrangement.Start.1();
        Arrangement.Start = (Arrangement.Horizontal)anon;
        Arrangement.End.1 anon2 = new Arrangement.End.1();
        Arrangement.End = (Arrangement.Horizontal)anon2;
        Arrangement.Top.1 anon3 = new Arrangement.Top.1();
        Arrangement.Top = (Arrangement.Vertical)anon3;
        Arrangement.Bottom.1 anon4 = new Arrangement.Bottom.1();
        Arrangement.Bottom = (Arrangement.Vertical)anon4;
        Arrangement.Center.1 anon5 = new Arrangement.Center.1();
        Arrangement.Center = (Arrangement.HorizontalOrVertical)anon5;
        Arrangement.SpaceEvenly.1 anon6 = new Arrangement.SpaceEvenly.1();
        Arrangement.SpaceEvenly = (Arrangement.HorizontalOrVertical)anon6;
        Arrangement.SpaceBetween.1 anon7 = new Arrangement.SpaceBetween.1();
        Arrangement.SpaceBetween = (Arrangement.HorizontalOrVertical)anon7;
        Arrangement.SpaceAround.1 anon8 = new Arrangement.SpaceAround.1();
        Arrangement.SpaceAround = (Arrangement.HorizontalOrVertical)anon8;
    }

    private final void forEachIndexed(int[] $this$forEachIndexed, boolean reversed, Function2<? super Integer, ? super Integer, Unit> action) {
        int i2;
        Integer valueOf3;
        int i5;
        Integer valueOf;
        int length;
        int i4;
        int i;
        int i3;
        Integer valueOf2;
        final int i6 = 0;
        if (!reversed) {
            i2 = $this$forEachIndexed;
            i5 = 0;
            valueOf = 0;
            i4 = 0;
            while (i4 < i2.length) {
                action.invoke(Integer.valueOf(valueOf), Integer.valueOf(i2[i4]));
                i4++;
                valueOf = i3;
            }
        } else {
            length2--;
            while (-1 < i2) {
                action.invoke(Integer.valueOf(i2), Integer.valueOf($this$forEachIndexed[i2]));
                i2--;
            }
        }
    }

    public static void getBottom$annotations() {
    }

    public static void getCenter$annotations() {
    }

    public static void getEnd$annotations() {
    }

    public static void getSpaceAround$annotations() {
    }

    public static void getSpaceBetween$annotations() {
    }

    public static void getSpaceEvenly$annotations() {
    }

    public static void getStart$annotations() {
    }

    public static void getTop$annotations() {
    }

    public final androidx.compose.foundation.layout.Arrangement.Horizontal aligned(Alignment.Horizontal alignment) {
        int i2 = 0;
        Arrangement.aligned.1 $i$f$getDp = new Arrangement.aligned.1(alignment);
        Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(Dp.constructor-impl((float)i), 1, (Function2)$i$f$getDp, 0);
        return (Arrangement.Horizontal)spacedAligned;
    }

    public final androidx.compose.foundation.layout.Arrangement.Vertical aligned(Alignment.Vertical alignment) {
        int i2 = 0;
        Arrangement.aligned.2 $i$f$getDp = new Arrangement.aligned.2(alignment);
        Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(Dp.constructor-impl((float)i), 0, (Function2)$i$f$getDp, 0);
        return (Arrangement.Vertical)spacedAligned;
    }

    public final androidx.compose.foundation.layout.Arrangement.Vertical getBottom() {
        return Arrangement.Bottom;
    }

    public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical getCenter() {
        return Arrangement.Center;
    }

    public final androidx.compose.foundation.layout.Arrangement.Horizontal getEnd() {
        return Arrangement.End;
    }

    public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical getSpaceAround() {
        return Arrangement.SpaceAround;
    }

    public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical getSpaceBetween() {
        return Arrangement.SpaceBetween;
    }

    public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical getSpaceEvenly() {
        return Arrangement.SpaceEvenly;
    }

    public final androidx.compose.foundation.layout.Arrangement.Horizontal getStart() {
        return Arrangement.Start;
    }

    public final androidx.compose.foundation.layout.Arrangement.Vertical getTop() {
        return Arrangement.Top;
    }

    public final void placeCenter$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int current;
        int accumulator$iv;
        int i$iv;
        int i6;
        int i4;
        int i7;
        int a;
        int length;
        int i3;
        int i;
        int i5;
        int i8;
        float f;
        int i2;
        int[] iArr = size;
        int i12 = 0;
        accumulator$iv = i9;
        i6 = i$iv;
        while (i6 < iArr.length) {
            i3 = 0;
            accumulator$iv = a;
            i6++;
        }
        int i10 = 0;
        f2 /= f3;
        int[] current2 = size;
        Object obj = this;
        int i14 = 0;
        if (!reverseInput) {
            i4 = current2;
            i7 = 0;
            a = 0;
            while (i$iv < i4.length) {
                i8 = 0;
                i2 = 0;
                outPosition[a] = Math.round(current);
                current += f;
                i$iv++;
                a = i;
            }
        } else {
            length3--;
            while (-1 < i$iv) {
                a = 0;
                i3 = 0;
                outPosition[i$iv] = Math.round(current);
                current += length;
                i$iv--;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean reverseInput) {
        int current;
        int i$iv;
        int i7;
        int i;
        int i5;
        int length;
        int i6;
        int i2;
        int i3;
        int i4;
        int i8;
        current = 0;
        final int i9 = size;
        final Object obj = this;
        final int i10 = 0;
        if (!reverseInput) {
            i$iv = i9;
            i = 0;
            i5 = 0;
            i6 = 0;
            while (i6 < i$iv.length) {
                i8 = 0;
                outPosition[i5] = current;
                current += i4;
                i6++;
                i5 = i3;
            }
        } else {
            length2--;
            while (-1 < i$iv) {
                length = 0;
                outPosition[i$iv] = current;
                current += i7;
                i$iv--;
            }
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int current;
        int accumulator$iv;
        int i$iv;
        int i3;
        int i;
        int i4;
        int a;
        int length;
        int i7;
        int i6;
        int i2;
        int i5;
        int[] iArr = size;
        int i10 = 0;
        accumulator$iv = i8;
        i3 = i$iv;
        while (i3 < iArr.length) {
            i7 = 0;
            accumulator$iv = a;
            i3++;
        }
        int i9 = 0;
        current = totalSize - accumulator$iv;
        int[] iArr2 = size;
        Object obj = this;
        int i11 = 0;
        if (!reverseInput) {
            i = iArr2;
            i4 = 0;
            a = 0;
            while (i$iv < i.length) {
                i5 = 0;
                outPosition[a] = current;
                current += i2;
                i$iv++;
                a = i6;
            }
        } else {
            length3--;
            while (-1 < i$iv) {
                a = 0;
                outPosition[i$iv] = current;
                current += i3;
                i$iv--;
            }
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i$iv;
        int i8;
        int i6;
        int i12;
        int i2;
        float i13;
        int current;
        int accumulator$iv;
        int i3;
        int i11;
        int i9;
        int a;
        int i10;
        int length;
        int i14;
        int i7;
        int i;
        int i4;
        int $this$fastRoundToInt$iv;
        int i5;
        i$iv = size;
        int[] iArr = size;
        i13 = 0;
        accumulator$iv = i16;
        i3 = 0;
        i11 = i3;
        while (i11 < iArr.length) {
            length = 0;
            accumulator$iv = a;
            i11++;
        }
        i12 = 1;
        i8 = i$iv.length == 0 ? i12 : i3;
        if (i8 == 0) {
            f2 /= i13;
        } else {
            i6 = 0;
        }
        int i18 = 0;
        current = i6 / f3;
        int[] iArr2 = size;
        Object obj = this;
        int i20 = 0;
        if (!reverseInput) {
            i2 = iArr2;
            a = 0;
            i10 = 0;
            while (i3 < i2.length) {
                i4 = 0;
                i5 = 0;
                outPosition[i10] = Math.round(current);
                current += i15;
                i3++;
                i$iv = size;
                i10 = i7;
            }
        } else {
            length2 -= i12;
            while (-1 < i$iv) {
                a = 0;
                length = 0;
                outPosition[i$iv] = Math.round(current);
                current += i10;
                i$iv--;
            }
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int[] i$iv;
        int i4;
        int i2;
        int i5;
        int current;
        int accumulator$iv;
        int length2;
        int i6;
        int i7;
        int a;
        int i;
        int length;
        int i8;
        int i9;
        int i10;
        int i3;
        int $this$fastRoundToInt$iv;
        int i11;
        i$iv = size;
        i2 = 0;
        i5 = 1;
        i4 = i$iv.length == 0 ? i5 : i2;
        if (i4 != 0) {
        }
        int[] iArr = size;
        int i17 = 0;
        accumulator$iv = i13;
        i6 = i2;
        while (i6 < iArr.length) {
            length = 0;
            accumulator$iv = a;
            i6++;
        }
        f2 /= f3;
        current = 0;
        if (reverseInput && i$iv.length == i5) {
            if (i$iv.length == i5) {
                current = i16;
            }
        }
        int[] iArr2 = size;
        Object obj = this;
        int i18 = 0;
        if (!reverseInput) {
            i5 = iArr2;
            a = 0;
            i = 0;
            while (i2 < i5.length) {
                i3 = 0;
                i11 = 0;
                outPosition[i] = Math.round(current);
                current += i12;
                i2++;
                i$iv = size;
                i = i9;
            }
        } else {
            length3 -= i5;
            while (-1 < i$iv) {
                a = 0;
                length = 0;
                outPosition[i$iv] = Math.round(current);
                current += i;
                i$iv--;
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i$iv;
        int current;
        int accumulator$iv;
        int i6;
        int i4;
        int i9;
        int a;
        int i;
        int i5;
        int length;
        int i2;
        int i10;
        int i3;
        int i11;
        int gapSize;
        int i8;
        int i7;
        int[] iArr = size;
        int i15 = 0;
        accumulator$iv = i12;
        i4 = i6;
        while (i4 < iArr.length) {
            i5 = 0;
            accumulator$iv = a;
            i4++;
        }
        f /= f2;
        int i17 = 0;
        current = i$iv;
        int[] iArr3 = size;
        Object obj = this;
        int i18 = 0;
        if (!reverseInput) {
            a = iArr3;
            i = 0;
            i5 = 0;
            while (i6 < a.length) {
                i11 = 0;
                i7 = 0;
                outPosition[i5] = Math.round(current);
                i8 = i$iv;
                current += i14;
                i6++;
                i5 = i10;
                i$iv = i8;
            }
            gapSize = i$iv;
        } else {
            gapSize2--;
            while (-1 < i$iv) {
                i = 0;
                length = 0;
                outPosition[i$iv] = Math.round(current);
                current += i5;
                i$iv--;
            }
        }
    }

    public final androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical spacedBy-0680j_4(float space) {
        Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 1, (Function2)Arrangement.spacedBy.1.INSTANCE, 0);
        return (Arrangement.HorizontalOrVertical)spacedAligned;
    }

    public final androidx.compose.foundation.layout.Arrangement.Horizontal spacedBy-D5KLDUw(float space, Alignment.Horizontal alignment) {
        Arrangement.spacedBy.2 anon = new Arrangement.spacedBy.2(alignment);
        Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 1, (Function2)anon, 0);
        return (Arrangement.Horizontal)spacedAligned;
    }

    public final androidx.compose.foundation.layout.Arrangement.Vertical spacedBy-D5KLDUw(float space, Alignment.Vertical alignment) {
        Arrangement.spacedBy.3 anon = new Arrangement.spacedBy.3(alignment);
        Arrangement.SpacedAligned spacedAligned = new Arrangement.SpacedAligned(space, 0, (Function2)anon, 0);
        return (Arrangement.Vertical)spacedAligned;
    }
}
