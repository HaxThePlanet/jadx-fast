package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment.Horizontal;
import androidx.compose.ui.Alignment.Vertical;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00081\u0018\u0000 \u00152\u00020\u0001:\u0007\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J-\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0008H ¢\u0006\u0002\u0008\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000c\u001a\u00020\rH\u0010¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0006\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 ", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment;", "", "()V", "isRelative", "", "isRelative$foundation_layout_release", "()Z", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "calculateAlignmentLinePosition", "calculateAlignmentLinePosition$foundation_layout_release", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "AlignmentLineCrossAxisAlignment", "CenterCrossAxisAlignment", "Companion", "EndCrossAxisAlignment", "HorizontalCrossAxisAlignment", "StartCrossAxisAlignment", "VerticalCrossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment$AlignmentLineCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CrossAxisAlignment {

    public static final int $stable;
    private static final androidx.compose.foundation.layout.CrossAxisAlignment Center;
    public static final androidx.compose.foundation.layout.CrossAxisAlignment.Companion Companion;
    private static final androidx.compose.foundation.layout.CrossAxisAlignment End;
    private static final androidx.compose.foundation.layout.CrossAxisAlignment Start;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000cH\u0010¢\u0006\u0002\u0008\u0013J\u0017\u0010\u0014\u001a\u00020\u000c2\u0006\u0010\u0010\u001a\u00020\u0011H\u0010¢\u0006\u0004\u0008\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00088PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$AlignmentLineCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "alignmentLineProvider", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "(Landroidx/compose/foundation/layout/AlignmentLineProvider;)V", "getAlignmentLineProvider", "()Landroidx/compose/foundation/layout/AlignmentLineProvider;", "isRelative", "", "isRelative$foundation_layout_release", "()Z", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "calculateAlignmentLinePosition", "calculateAlignmentLinePosition$foundation_layout_release", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AlignmentLineCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        private final androidx.compose.foundation.layout.AlignmentLineProvider alignmentLineProvider;
        public AlignmentLineCrossAxisAlignment(androidx.compose.foundation.layout.AlignmentLineProvider alignmentLineProvider) {
            super(0);
            this.alignmentLineProvider = alignmentLineProvider;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            int line;
            LayoutDirection rtl;
            int alignmentLinePosition = this.alignmentLineProvider.calculateAlignmentLinePosition(placeable);
            if (alignmentLinePosition != Integer.MIN_VALUE) {
                if (layoutDirection == LayoutDirection.Rtl) {
                    line = rtl;
                } else {
                }
            } else {
                line = 0;
            }
            return line;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public Integer calculateAlignmentLinePosition$foundation_layout_release(Placeable placeable) {
            return Integer.valueOf(this.alignmentLineProvider.calculateAlignmentLinePosition(placeable));
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final androidx.compose.foundation.layout.AlignmentLineProvider getAlignmentLineProvider() {
            return this.alignmentLineProvider;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public boolean isRelative$foundation_layout_release() {
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CenterCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        public static final androidx.compose.foundation.layout.CrossAxisAlignment.CenterCrossAxisAlignment INSTANCE;
        static {
            CrossAxisAlignment.CenterCrossAxisAlignment centerCrossAxisAlignment = new CrossAxisAlignment.CenterCrossAxisAlignment();
            CrossAxisAlignment.CenterCrossAxisAlignment.INSTANCE = centerCrossAxisAlignment;
        }

        private CenterCrossAxisAlignment() {
            super(0);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return size / 2;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\u0008\u0014J\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0008\u0017J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\u0008\u001aR\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0007¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$Companion;", "", "()V", "Center", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "End", "getEnd$annotations", "getEnd", "Start", "getStart$annotations", "getStart", "AlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "Relative", "alignmentLineProvider", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "Relative$foundation_layout_release", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontal$foundation_layout_release", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "vertical$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCenter$annotations() {
        }

        public static void getEnd$annotations() {
        }

        public static void getStart$annotations() {
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment AlignmentLine(AlignmentLine alignmentLine) {
            AlignmentLineProvider.Value value = new AlignmentLineProvider.Value(alignmentLine);
            CrossAxisAlignment.AlignmentLineCrossAxisAlignment alignmentLineCrossAxisAlignment = new CrossAxisAlignment.AlignmentLineCrossAxisAlignment((AlignmentLineProvider)value);
            return (CrossAxisAlignment)alignmentLineCrossAxisAlignment;
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment Relative$foundation_layout_release(androidx.compose.foundation.layout.AlignmentLineProvider alignmentLineProvider) {
            CrossAxisAlignment.AlignmentLineCrossAxisAlignment alignmentLineCrossAxisAlignment = new CrossAxisAlignment.AlignmentLineCrossAxisAlignment(alignmentLineProvider);
            return (CrossAxisAlignment)alignmentLineCrossAxisAlignment;
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment getCenter() {
            return CrossAxisAlignment.access$getCenter$cp();
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment getEnd() {
            return CrossAxisAlignment.access$getEnd$cp();
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment getStart() {
            return CrossAxisAlignment.access$getStart$cp();
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment horizontal$foundation_layout_release(Alignment.Horizontal horizontal) {
            CrossAxisAlignment.HorizontalCrossAxisAlignment horizontalCrossAxisAlignment = new CrossAxisAlignment.HorizontalCrossAxisAlignment(horizontal);
            return (CrossAxisAlignment)horizontalCrossAxisAlignment;
        }

        public final androidx.compose.foundation.layout.CrossAxisAlignment vertical$foundation_layout_release(Alignment.Vertical vertical) {
            CrossAxisAlignment.VerticalCrossAxisAlignment verticalCrossAxisAlignment = new CrossAxisAlignment.VerticalCrossAxisAlignment(vertical);
            return (CrossAxisAlignment)verticalCrossAxisAlignment;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class EndCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        public static final androidx.compose.foundation.layout.CrossAxisAlignment.EndCrossAxisAlignment INSTANCE;
        static {
            CrossAxisAlignment.EndCrossAxisAlignment endCrossAxisAlignment = new CrossAxisAlignment.EndCrossAxisAlignment();
            CrossAxisAlignment.EndCrossAxisAlignment.INSTANCE = endCrossAxisAlignment;
        }

        private EndCrossAxisAlignment() {
            super(0);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            int i;
            i = layoutDirection == LayoutDirection.Ltr ? size : 0;
            return i;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0008H\u0010¢\u0006\u0002\u0008\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class HorizontalCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        private final Alignment.Horizontal horizontal;
        public HorizontalCrossAxisAlignment(Alignment.Horizontal horizontal) {
            super(0);
            this.horizontal = horizontal;
        }

        public static androidx.compose.foundation.layout.CrossAxisAlignment.HorizontalCrossAxisAlignment copy$default(androidx.compose.foundation.layout.CrossAxisAlignment.HorizontalCrossAxisAlignment crossAxisAlignment$HorizontalCrossAxisAlignment, Alignment.Horizontal alignment$Horizontal2, int i3, Object object4) {
            Alignment.Horizontal obj1;
            if (i3 &= 1 != 0) {
                obj1 = horizontalCrossAxisAlignment.horizontal;
            }
            return horizontalCrossAxisAlignment.copy(obj1);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return this.horizontal.align(0, size, layoutDirection);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final Alignment.Horizontal component1() {
            return this.horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final androidx.compose.foundation.layout.CrossAxisAlignment.HorizontalCrossAxisAlignment copy(Alignment.Horizontal alignment$Horizontal) {
            CrossAxisAlignment.HorizontalCrossAxisAlignment horizontalCrossAxisAlignment = new CrossAxisAlignment.HorizontalCrossAxisAlignment(horizontal);
            return horizontalCrossAxisAlignment;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof CrossAxisAlignment.HorizontalCrossAxisAlignment) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.horizontal, obj.horizontal)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final Alignment.Horizontal getHorizontal() {
            return this.horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int hashCode() {
            return this.horizontal.hashCode();
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("HorizontalCrossAxisAlignment(horizontal=").append(this.horizontal).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0010¢\u0006\u0002\u0008\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class StartCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        public static final androidx.compose.foundation.layout.CrossAxisAlignment.StartCrossAxisAlignment INSTANCE;
        static {
            CrossAxisAlignment.StartCrossAxisAlignment startCrossAxisAlignment = new CrossAxisAlignment.StartCrossAxisAlignment();
            CrossAxisAlignment.StartCrossAxisAlignment.INSTANCE = startCrossAxisAlignment;
        }

        private StartCrossAxisAlignment() {
            super(0);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            int i;
            i = layoutDirection == LayoutDirection.Ltr ? 0 : size;
            return i;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0008H\u0010¢\u0006\u0002\u0008\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class VerticalCrossAxisAlignment extends androidx.compose.foundation.layout.CrossAxisAlignment {

        private final Alignment.Vertical vertical;
        public VerticalCrossAxisAlignment(Alignment.Vertical vertical) {
            super(0);
            this.vertical = vertical;
        }

        public static androidx.compose.foundation.layout.CrossAxisAlignment.VerticalCrossAxisAlignment copy$default(androidx.compose.foundation.layout.CrossAxisAlignment.VerticalCrossAxisAlignment crossAxisAlignment$VerticalCrossAxisAlignment, Alignment.Vertical alignment$Vertical2, int i3, Object object4) {
            Alignment.Vertical obj1;
            if (i3 &= 1 != 0) {
                obj1 = verticalCrossAxisAlignment.vertical;
            }
            return verticalCrossAxisAlignment.copy(obj1);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int align$foundation_layout_release(int size, LayoutDirection layoutDirection, Placeable placeable, int beforeCrossAxisAlignmentLine) {
            return this.vertical.align(0, size);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final Alignment.Vertical component1() {
            return this.vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final androidx.compose.foundation.layout.CrossAxisAlignment.VerticalCrossAxisAlignment copy(Alignment.Vertical alignment$Vertical) {
            CrossAxisAlignment.VerticalCrossAxisAlignment verticalCrossAxisAlignment = new CrossAxisAlignment.VerticalCrossAxisAlignment(vertical);
            return verticalCrossAxisAlignment;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof CrossAxisAlignment.VerticalCrossAxisAlignment) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.vertical, obj.vertical)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public final Alignment.Vertical getVertical() {
            return this.vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int hashCode() {
            return this.vertical.hashCode();
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("VerticalCrossAxisAlignment(vertical=").append(this.vertical).append(')').toString();
        }
    }
    static {
        CrossAxisAlignment.Companion companion = new CrossAxisAlignment.Companion(0);
        CrossAxisAlignment.Companion = companion;
        CrossAxisAlignment.Center = (CrossAxisAlignment)CrossAxisAlignment.CenterCrossAxisAlignment.INSTANCE;
        CrossAxisAlignment.Start = (CrossAxisAlignment)CrossAxisAlignment.StartCrossAxisAlignment.INSTANCE;
        CrossAxisAlignment.End = (CrossAxisAlignment)CrossAxisAlignment.EndCrossAxisAlignment.INSTANCE;
    }

    public CrossAxisAlignment(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static final androidx.compose.foundation.layout.CrossAxisAlignment access$getCenter$cp() {
        return CrossAxisAlignment.Center;
    }

    public static final androidx.compose.foundation.layout.CrossAxisAlignment access$getEnd$cp() {
        return CrossAxisAlignment.End;
    }

    public static final androidx.compose.foundation.layout.CrossAxisAlignment access$getStart$cp() {
        return CrossAxisAlignment.Start;
    }

    public abstract int align$foundation_layout_release(int i, LayoutDirection layoutDirection2, Placeable placeable3, int i4);

    public Integer calculateAlignmentLinePosition$foundation_layout_release(Placeable placeable) {
        return null;
    }

    public boolean isRelative$foundation_layout_release() {
        return 0;
    }
}
