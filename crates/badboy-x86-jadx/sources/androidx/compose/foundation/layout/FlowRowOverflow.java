package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0087\u0001\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u00120\u0008\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008\u00120\u0008\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0008\u000f\u0018\u00010\u0008¢\u0006\u0002\u0010\u0011¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", "name", "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowRowOverflow extends androidx.compose.foundation.layout.FlowLayoutOverflow {

    public static final int $stable;
    private static final androidx.compose.foundation.layout.FlowRowOverflow Clip;
    public static final androidx.compose.foundation.layout.FlowRowOverflow.Companion Companion;
    private static final androidx.compose.foundation.layout.FlowRowOverflow Visible;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u000b\u001a\u00020\u00042\u001c\u0010\u000c\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010¢\u0006\u0002\u0008\u0011H\u0007¢\u0006\u0002\u0010\u0012Jb\u0010\u0013\u001a\u00020\u00042\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010¢\u0006\u0002\u0008\u00112\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0008\u0010¢\u0006\u0002\u0008\u00112\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u00020\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/foundation/layout/FlowRowOverflow$Companion;", "", "()V", "Clip", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "getClip$annotations", "getClip", "()Landroidx/compose/foundation/layout/FlowRowOverflow;", "Visible", "getVisible$annotations", "getVisible", "expandIndicator", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowOverflowScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/layout/FlowRowOverflow;", "expandOrCollapseIndicator", "collapseIndicator", "minRowsToShowCollapse", "", "minHeightToShowCollapse", "Landroidx/compose/ui/unit/Dp;", "expandOrCollapseIndicator--jt2gSs", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getClip$annotations() {
        }

        public static void getVisible$annotations() {
        }

        public final androidx.compose.foundation.layout.FlowRowOverflow expandIndicator(Function3<? super androidx.compose.foundation.layout.FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> content) {
            FlowRowOverflow.Companion.expandIndicator.seeMoreGetter.1 anon = new FlowRowOverflow.Companion.expandIndicator.seeMoreGetter.1(content);
            FlowRowOverflow flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandIndicator, 0, 0, (Function1)anon, 0, 22, 0);
            return flowRowOverflow;
        }

        public final androidx.compose.foundation.layout.FlowRowOverflow expandOrCollapseIndicator--jt2gSs(Function3<? super androidx.compose.foundation.layout.FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> expandIndicator, Function3<? super androidx.compose.foundation.layout.FlowRowOverflowScope, ? super Composer, ? super Integer, Unit> collapseIndicator, int minRowsToShowCollapse, float minHeightToShowCollapse, Composer $composer, int $changed, int i7) {
            boolean changed;
            int i4;
            int i10;
            float minHeightToShowCollapse2;
            int i9;
            boolean traceInProgress;
            int changed3;
            int i6;
            int changed2;
            Object flowRowOverflow;
            float str;
            int expandOrCollapseIndicator;
            int i5;
            int i8;
            int i2;
            int i;
            int i3;
            final Object obj = expandIndicator;
            final Object obj2 = collapseIndicator;
            final Composer composer = $composer;
            final int i11 = $changed;
            int i12 = -58693346;
            ComposerKt.sourceInformationMarkerStart(composer, i12, "C(expandOrCollapseIndicator)P(1!1,3,2:c#ui.unit.Dp)*155@7080L7,158@7176L1079:FlowLayoutOverflow.kt#2w3rfo");
            i5 = i7 & 4 != 0 ? i10 : minRowsToShowCollapse;
            if (i7 & 8 != 0) {
                i9 = 0;
                minHeightToShowCollapse2 = Dp.constructor-impl((float)i19);
            } else {
                minHeightToShowCollapse2 = minHeightToShowCollapse;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i12, i11, -1, "androidx.compose.foundation.layout.FlowRowOverflow.Companion.expandOrCollapseIndicator (FlowLayoutOverflow.kt:154)");
            }
            int i20 = 0;
            int i25 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            int i21 = 0;
            int roundToPx-0680j_4 = (Density)composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).roundToPx-0680j_4(minHeightToShowCollapse2);
            ComposerKt.sourceInformationMarkerStart(composer, -132686000, "CC(remember):FlowLayoutOverflow.kt#9igjgp");
            int i22 = 256;
            expandOrCollapseIndicator = 0;
            i8 = 1;
            if (i14 ^= 384 > i22) {
                if (!composer.changed(i5)) {
                    i4 = i11 & 384 == i22 ? i8 : expandOrCollapseIndicator;
                } else {
                }
            } else {
            }
            int i27 = 4;
            if (i23 ^= 6 > i27) {
                if (!composer.changed(obj)) {
                    i6 = i11 & 6 == i27 ? i8 : expandOrCollapseIndicator;
                } else {
                }
            } else {
            }
            i2 = 32;
            if (i24 ^= 48 > i2) {
                if (!composer.changed(obj2)) {
                    if (i11 & 48 == i2) {
                        expandOrCollapseIndicator = i8;
                    }
                } else {
                }
            } else {
            }
            final Composer composer2 = $composer;
            final int i28 = 0;
            final Object rememberedValue = composer2.rememberedValue();
            final int i29 = 0;
            if (i16 |= expandOrCollapseIndicator == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    i3 = 0;
                    FlowRowOverflow.Companion.expandOrCollapseIndicator.1.seeMoreGetter.1 anon = new FlowRowOverflow.Companion.expandOrCollapseIndicator.1.seeMoreGetter.1(obj);
                    FlowRowOverflow.Companion.expandOrCollapseIndicator.1.collapseGetter.1 anon2 = new FlowRowOverflow.Companion.expandOrCollapseIndicator.1.collapseGetter.1(obj2);
                    flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator, i5, roundToPx-0680j_4, (Function1)anon, (Function1)anon2, 0);
                    composer2.updateRememberedValue(flowRowOverflow);
                } else {
                    flowRowOverflow = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return (FlowRowOverflow)flowRowOverflow;
        }

        public final androidx.compose.foundation.layout.FlowRowOverflow getClip() {
            return FlowRowOverflow.access$getClip$cp();
        }

        public final androidx.compose.foundation.layout.FlowRowOverflow getVisible() {
            return FlowRowOverflow.access$getVisible$cp();
        }
    }
    static {
        FlowRowOverflow.Companion companion = new FlowRowOverflow.Companion(0);
        FlowRowOverflow.Companion = companion;
        final int i3 = 0;
        final int i6 = 0;
        FlowRowOverflow flowRowOverflow = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Visible, 0, i3, 0, i6, 30, 0);
        FlowRowOverflow.Visible = flowRowOverflow;
        FlowRowOverflow flowRowOverflow2 = new FlowRowOverflow(FlowLayoutOverflow.OverflowType.Clip, i3, 0, i6, 0, 30, 0);
        FlowRowOverflow.Clip = flowRowOverflow2;
    }

    private FlowRowOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type, int minLinesToShowCollapse, int minCrossAxisSizeToShowCollapse, Function1<? super androidx.compose.foundation.layout.FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> seeMoreGetter, Function1<? super androidx.compose.foundation.layout.FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> collapseGetter) {
        super(type, minLinesToShowCollapse, minCrossAxisSizeToShowCollapse, seeMoreGetter, collapseGetter, 0);
    }

    FlowRowOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType, int i2, int i3, Function1 function14, Function1 function15, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int obj3;
        int obj4;
        int obj5;
        int obj7;
        int i = 0;
        obj3 = i6 & 2 != 0 ? i : obj3;
        obj4 = i6 & 4 != 0 ? i : obj4;
        int i4 = 0;
        obj5 = i6 & 8 != 0 ? i4 : obj5;
        obj7 = i6 &= 16 != 0 ? i4 : function15;
        super(overflowType, obj3, obj4, obj5, obj7);
    }

    public FlowRowOverflow(androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType flowLayoutOverflow$OverflowType, int i2, int i3, Function1 function14, Function1 function15, DefaultConstructorMarker defaultConstructorMarker6) {
        super(overflowType, i2, i3, function14, function15);
    }

    public static final androidx.compose.foundation.layout.FlowRowOverflow access$getClip$cp() {
        return FlowRowOverflow.Clip;
    }

    public static final androidx.compose.foundation.layout.FlowRowOverflow access$getVisible$cp() {
        return FlowRowOverflow.Visible;
    }
}
