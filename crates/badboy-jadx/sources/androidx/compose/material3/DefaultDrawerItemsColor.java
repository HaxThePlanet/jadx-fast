package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001c\u001a\u00020\u00192\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\u0008\u0010\u001f\u001a\u00020 H\u0016J\u001b\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aJ\u001b\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aR\u0019\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000f\u0010\rR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0010\u0010\rR\u0019\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0011\u0010\rR\u0019\u0010\n\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0012\u0010\rR\u0019\u0010\u0008\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0013\u0010\rR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0014\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u0015\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material3/DefaultDrawerItemsColor;", "Landroidx/compose/material3/NavigationDrawerItemColors;", "selectedIconColor", "Landroidx/compose/ui/graphics/Color;", "unselectedIconColor", "selectedTextColor", "unselectedTextColor", "selectedContainerColor", "unselectedContainerColor", "selectedBadgeColor", "unselectedBadgeColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSelectedBadgeColor-0d7_KjU", "()J", "J", "getSelectedContainerColor-0d7_KjU", "getSelectedIconColor-0d7_KjU", "getSelectedTextColor-0d7_KjU", "getUnselectedBadgeColor-0d7_KjU", "getUnselectedContainerColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "badgeColor", "Landroidx/compose/runtime/State;", "selected", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "containerColor", "equals", "other", "", "hashCode", "", "iconColor", "textColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultDrawerItemsColor implements androidx.compose.material3.NavigationDrawerItemColors {

    private final long selectedBadgeColor;
    private final long selectedContainerColor;
    private final long selectedIconColor;
    private final long selectedTextColor;
    private final long unselectedBadgeColor;
    private final long unselectedContainerColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;
    private DefaultDrawerItemsColor(long selectedIconColor, long unselectedIconColor, long selectedTextColor, long unselectedTextColor, long selectedContainerColor, long unselectedContainerColor, long selectedBadgeColor, long unselectedBadgeColor) {
        super();
        this.selectedIconColor = selectedIconColor;
        this.unselectedIconColor = selectedTextColor;
        this.selectedTextColor = selectedContainerColor;
        this.unselectedTextColor = selectedBadgeColor;
        this.selectedContainerColor = obj23;
        this.unselectedContainerColor = obj25;
        this.selectedBadgeColor = obj27;
        this.unselectedBadgeColor = obj29;
    }

    public DefaultDrawerItemsColor(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(l, l2, l3, l4, l5, l6, l7, l8, defaultConstructorMarker9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    public State<Color> badgeColor(boolean selected, Composer $composer, int $changed) {
        long unselectedBadgeColor;
        boolean traceInProgress;
        String str;
        int i = -561675044;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(badgeColor)1101@44962L80:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.badgeColor (NavigationDrawer.kt:1100)");
        }
        unselectedBadgeColor = selected ? this.selectedBadgeColor : this.unselectedBadgeColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(unselectedBadgeColor), $composer, 0);
    }

    public State<Color> containerColor(boolean selected, Composer $composer, int $changed) {
        long selectedContainerColor;
        boolean traceInProgress;
        String str;
        int i = -433512770;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(containerColor)1094@44750L110:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.containerColor (NavigationDrawer.kt:1093)");
        }
        selectedContainerColor = selected ? this.selectedContainerColor : this.unselectedContainerColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(selectedContainerColor), $composer, 0);
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof DefaultDrawerItemsColor) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedIconColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.unselectedIconColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedTextColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.unselectedTextColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.unselectedContainerColor, obj3)) {
            return i2;
        }
        if (!Color.equals-impl0(this.selectedBadgeColor, obj3)) {
            return i2;
        }
        return Color.equals-impl0(this.unselectedBadgeColor, i2);
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getSelectedBadgeColor-0d7_KjU() {
        return this.selectedBadgeColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getSelectedContainerColor-0d7_KjU() {
        return this.selectedContainerColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getSelectedIconColor-0d7_KjU() {
        return this.selectedIconColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getSelectedTextColor-0d7_KjU() {
        return this.selectedTextColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getUnselectedBadgeColor-0d7_KjU() {
        return this.unselectedBadgeColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getUnselectedContainerColor-0d7_KjU() {
        return this.unselectedContainerColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getUnselectedIconColor-0d7_KjU() {
        return this.unselectedIconColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public final long getUnselectedTextColor-0d7_KjU() {
        return this.unselectedTextColor;
    }

    @Override // androidx.compose.material3.NavigationDrawerItemColors
    public int hashCode() {
        return result6 += i16;
    }

    public State<Color> iconColor(boolean selected, Composer $composer, int $changed) {
        long unselectedIconColor;
        boolean traceInProgress;
        String str;
        int i = 1141354218;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(iconColor)1084@44387L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.iconColor (NavigationDrawer.kt:1083)");
        }
        unselectedIconColor = selected ? this.selectedIconColor : this.unselectedIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(unselectedIconColor), $composer, 0);
    }

    public State<Color> textColor(boolean selected, Composer $composer, int $changed) {
        long unselectedTextColor;
        boolean traceInProgress;
        String str;
        int i = 1275109558;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(textColor)1089@44566L78:NavigationDrawer.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DefaultDrawerItemsColor.textColor (NavigationDrawer.kt:1088)");
        }
        unselectedTextColor = selected ? this.selectedTextColor : this.unselectedTextColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(unselectedTextColor), $composer, 0);
    }
}
