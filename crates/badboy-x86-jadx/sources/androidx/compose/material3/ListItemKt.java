package androidx.compose.material3;

import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a©\u0001\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\u0008\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0015\u0008\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0015\u0008\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0015\u0008\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0015\u0008\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\u00012\u0008\u0008\u0002\u0010$\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001at\u0010'\u001a\u00020\u00172\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\u0008\u001a2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001a2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\u0008\u001aH\u0003¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\u0008\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a\u001a\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\u00089\u0010:\u001aV\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020<2\u0006\u00107\u001a\u0002082\u0006\u00106\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\u001aN\u0010G\u001a\u00020<*\u00020=2\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\u0006\u0010J\u001a\u00020<2\u0006\u0010K\u001a\u00020<2\u0006\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\u0008N\u0010O\u001a\u0014\u0010P\u001a\u00020Q*\u00020R2\u0006\u0010S\u001a\u00020<H\u0002\u001an\u0010T\u001a\u00020U*\u00020V2\u0006\u0010W\u001a\u00020<2\u0006\u0010X\u001a\u00020<2\u0008\u0010Y\u001a\u0004\u0018\u00010Z2\u0008\u0010[\u001a\u0004\u0018\u00010Z2\u0008\u0010\\\u001a\u0004\u0018\u00010Z2\u0008\u0010]\u001a\u0004\u0018\u00010Z2\u0008\u0010^\u001a\u0004\u0018\u00010Z2\u0006\u0010_\u001a\u00020Q2\u0006\u0010`\u001a\u00020<2\u0006\u0010a\u001a\u00020<2\u0006\u0010b\u001a\u00020<H\u0002\u001a\u0014\u0010c\u001a\u00020<*\u00020<2\u0006\u0010d\u001a\u00020<H\u0002\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u0008\u0010\u0003\u001a\u0004\u0008\t\u0010\u0005\"\u001e\u0010\n\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u000b\u0010\u0003\u001a\u0004\u0008\u000c\u0010\u0005\"\u001e\u0010\r\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u000e\u0010\u0003\u001a\u0004\u0008\u000f\u0010\u0005\"\u001e\u0010\u0010\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u0011\u0010\u0003\u001a\u0004\u0008\u0012\u0010\u0005\"\u001e\u0010\u0013\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\u0008\u0014\u0010\u0003\u001a\u0004\u0008\u0015\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006e", d2 = {"LeadingContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "getLeadingContentEndPadding$annotations", "()V", "getLeadingContentEndPadding", "()F", "F", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "getListItemVerticalPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "verticalPadding", "listItemType", "Landroidx/compose/material3/ListItemType;", "verticalPadding-yh95HIg", "(I)F", "calculateHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "leadingHeight", "trailingHeight", "headlineHeight", "overlineHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIIJ)I", "calculateWidth", "leadingWidth", "trailingWidth", "headlineWidth", "overlineWidth", "supportingWidth", "horizontalPadding", "calculateWidth-yeHjK3Y", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;IIIIIIJ)I", "isSupportingMultilineHeuristic", "", "Landroidx/compose/ui/unit/Density;", "estimatedSupportingHeight", "place", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "width", "height", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "isThreeLine", "startPadding", "endPadding", "topPadding", "subtractConstraintSafely", "n", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListItemKt {

    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float ListItemThreeLineVerticalPadding;
    private static final float ListItemVerticalPadding;
    private static final float TrailingContentStartPadding;
    static {
        int i7 = 0;
        ListItemKt.ListItemVerticalPadding = Dp.constructor-impl((float)i);
        int i8 = 0;
        ListItemKt.ListItemThreeLineVerticalPadding = Dp.constructor-impl((float)i2);
        int i9 = 0;
        ListItemKt.ListItemStartPadding = Dp.constructor-impl((float)i3);
        int i10 = 0;
        ListItemKt.ListItemEndPadding = Dp.constructor-impl((float)i4);
        int i11 = 0;
        ListItemKt.LeadingContentEndPadding = Dp.constructor-impl((float)i5);
        int i12 = 0;
        ListItemKt.TrailingContentStartPadding = Dp.constructor-impl((float)i6);
    }

    public static final void ListItem-HXNGIdc(Function2<? super Composer, ? super Integer, Unit> headlineContent, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> overlineContent, Function2<? super Composer, ? super Integer, Unit> supportingContent, Function2<? super Composer, ? super Integer, Unit> leadingContent, Function2<? super Composer, ? super Integer, Unit> trailingContent, androidx.compose.material3.ListItemColors colors, float tonalElevation, float shadowElevation, Composer $composer, int $changed, int i12) {
        Object obj3;
        int traceInProgress2;
        int defaultsInvalid;
        int leadingContent2;
        androidx.compose.runtime.internal.ComposableLambda leadingContent3;
        androidx.compose.runtime.internal.ComposableLambda decoratedOverlineContent;
        int it;
        int shape;
        int str;
        float tonalElevation2;
        androidx.compose.material3.ListItemColors tonalElevation3;
        Object colors2;
        int $dirty;
        Object $dirty2;
        int i9;
        Object trailingContent3;
        Object trailingContent2;
        Object obj;
        int modifier2;
        int i15;
        int elevation-D9Ej5fM;
        boolean traceInProgress;
        Object obj6;
        Object obj5;
        androidx.compose.material3.ListItemColors overlineContent2;
        int i8;
        int str2;
        Object anon;
        Object str3;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda2;
        float f;
        Object composableLambda2;
        float supportingContent2;
        int i16;
        Object colors-J08w3-E;
        androidx.compose.material3.ListItemKt.ListItem.decoratedOverlineContent.1.1 anon2;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        int i3;
        Object obj2;
        float i4;
        float $composer2;
        Composer composer2;
        int i24;
        long i13;
        Object obj4;
        int i11;
        int i21;
        boolean changed;
        int headlineColor-vNxB06k$material3_release;
        int i23;
        int i2;
        int i17;
        float i7;
        int i22;
        int i10;
        int i18;
        Composer composer3;
        int i5;
        int i25;
        int i19;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i20;
        int i;
        Composer composer;
        int i14;
        int i6;
        Object obj36;
        androidx.compose.runtime.internal.ComposableLambda obj37;
        androidx.compose.runtime.internal.ComposableLambda obj38;
        androidx.compose.runtime.internal.ComposableLambda obj39;
        androidx.compose.runtime.internal.ComposableLambda obj40;
        androidx.compose.runtime.internal.ComposableLambda obj41;
        int obj42;
        shape = headlineContent;
        final int i40 = $changed;
        final int i41 = i12;
        Composer restartGroup = $composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation(restartGroup, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)100@4555L8,104@4735L176,157@6562L5,162@6761L288,155@6438L611:ListItem.kt#uh7d8r");
        $dirty = $changed;
        if (i41 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i40 & 6 == 0) {
                i9 = restartGroup.changedInstance(shape) ? 4 : 2;
                $dirty |= i9;
            }
        }
        int i32 = i41 & 2;
        if (i32 != 0) {
            $dirty |= 48;
            obj = modifier;
        } else {
            if (i40 & 48 == 0) {
                i15 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i15;
            } else {
                obj = modifier;
            }
        }
        elevation-D9Ej5fM = i41 & 4;
        if (elevation-D9Ej5fM != 0) {
            $dirty |= 384;
            obj5 = overlineContent;
        } else {
            if (i40 & 384 == 0) {
                i8 = restartGroup.changedInstance(overlineContent) ? 256 : 128;
                $dirty |= i8;
            } else {
                obj5 = overlineContent;
            }
        }
        str2 = i41 & 8;
        if (str2 != null) {
            $dirty |= 3072;
            composableLambda2 = supportingContent;
        } else {
            if (i40 & 3072 == 0) {
                i16 = restartGroup.changedInstance(supportingContent) ? 2048 : 1024;
                $dirty |= i16;
            } else {
                composableLambda2 = supportingContent;
            }
        }
        colors-J08w3-E = i41 & 16;
        if (colors-J08w3-E != 0) {
            $dirty |= 24576;
            obj2 = leadingContent;
        } else {
            if (i40 & 24576 == 0) {
                i24 = restartGroup.changedInstance(leadingContent) ? 16384 : 8192;
                $dirty |= i24;
            } else {
                obj2 = leadingContent;
            }
        }
        i13 = i41 & 32;
        int i55 = 196608;
        if (i13 != 0) {
            $dirty |= i55;
            obj4 = trailingContent;
        } else {
            if (i55 &= i40 == 0) {
                i11 = restartGroup.changedInstance(trailingContent) ? 131072 : 65536;
                $dirty |= i11;
            } else {
                obj4 = trailingContent;
            }
        }
        if (i40 & i58 == 0) {
            if (i41 & 64 == 0) {
                i21 = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                obj3 = colors;
            }
            $dirty |= i21;
        } else {
            obj3 = colors;
        }
        int i46 = i41 & 128;
        final int i62 = 12582912;
        if (i46 != 0) {
            $dirty |= i62;
            headlineColor-vNxB06k$material3_release = i46;
            i4 = tonalElevation;
        } else {
            if (i40 & i62 == 0) {
                headlineColor-vNxB06k$material3_release = i46;
                i23 = restartGroup.changed(tonalElevation) ? 8388608 : 4194304;
                $dirty |= i23;
            } else {
                headlineColor-vNxB06k$material3_release = i46;
                i4 = tonalElevation;
            }
        }
        int i47 = i41 & 256;
        int i60 = 100663296;
        if (i47 != 0) {
            $dirty |= i60;
            i2 = i47;
            $composer2 = shadowElevation;
        } else {
            if (i40 & i60 == 0) {
                i2 = i47;
                i17 = restartGroup.changed(shadowElevation) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                i2 = i47;
                $composer2 = shadowElevation;
            }
        }
        i7 = 38347923;
        composer = restartGroup;
        if ($dirty & i7 == 38347922) {
            if (!composer.getSkipping()) {
                composer.startDefaults();
                int i31 = -3670017;
                if (i40 & 1 != 0) {
                    if (composer.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (elevation-D9Ej5fM != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (str2 != null) {
                            composableLambda2 = defaultsInvalid;
                        }
                        leadingContent2 = colors-J08w3-E != 0 ? 0 : leadingContent;
                        trailingContent3 = i13 != 0 ? 0 : obj4;
                        if (i41 & 64 != 0) {
                            elevation-D9Ej5fM = headlineColor-vNxB06k$material3_release;
                            str2 = i2;
                            colors-J08w3-E = ListItemDefaults.INSTANCE.colors-J08w3-E(0, i13, 0, headlineColor-vNxB06k$material3_release, 0, i7, 0, obj20, 0, obj22, 0, obj24);
                            composer2 = composer;
                            $dirty &= i31;
                        } else {
                            elevation-D9Ej5fM = headlineColor-vNxB06k$material3_release;
                            str2 = i2;
                            composer2 = composer;
                            colors-J08w3-E = colors;
                        }
                        if (elevation-D9Ej5fM != 0) {
                            tonalElevation2 = ListItemDefaults.INSTANCE.getElevation-D9Ej5fM();
                        } else {
                            tonalElevation2 = tonalElevation;
                        }
                        if (str2 != null) {
                            i7 = tonalElevation2;
                            i22 = elevation-D9Ej5fM;
                            tonalElevation3 = colors-J08w3-E;
                        } else {
                            i22 = shadowElevation;
                            i7 = tonalElevation2;
                            tonalElevation3 = colors-J08w3-E;
                        }
                    } else {
                        composer.skipToGroupEnd();
                        if (i41 & 64 != 0) {
                            $dirty &= i31;
                        }
                        leadingContent2 = leadingContent;
                        tonalElevation3 = colors;
                        i7 = tonalElevation;
                        i22 = $composer2;
                        trailingContent3 = obj4;
                        composer2 = composer;
                    }
                } else {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1647707763, $dirty, -1, "androidx.compose.material3.ListItem (ListItem.kt:103)");
                }
                ListItemKt.ListItem.decoratedHeadlineContent.1 anon3 = new ListItemKt.ListItem.decoratedHeadlineContent.1(tonalElevation3, shape);
                anon2 = 1;
                int i49 = 54;
                composer2.startReplaceGroup(1640970492);
                ComposerKt.sourceInformation(composer2, "*113@5021L204");
                if (composableLambda2 == null) {
                    obj42 = leadingContent2;
                    leadingContent3 = 0;
                } else {
                    headlineColor-vNxB06k$material3_release = 0;
                    anon = new ListItemKt.ListItem.decoratedSupportingContent.1.1(tonalElevation3, composableLambda2);
                    obj42 = leadingContent2;
                    leadingContent3 = ComposableLambdaKt.rememberComposableLambda(-1020860251, anon2, anon, composer2, i49);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1640980724);
                ComposerKt.sourceInformation(composer2, "*123@5341L196");
                if (obj5 == null) {
                    obj41 = leadingContent3;
                    decoratedOverlineContent = 0;
                } else {
                    obj4 = 0;
                    anon2 = new ListItemKt.ListItem.decoratedOverlineContent.1.1(tonalElevation3, obj5);
                    obj41 = leadingContent3;
                    decoratedOverlineContent = ComposableLambdaKt.rememberComposableLambda(-764441232, true, anon2, composer2, i49);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1640990750);
                ComposerKt.sourceInformation(composer2, "*133@5651L302");
                if (obj42 == null) {
                    obj40 = decoratedOverlineContent;
                    rememberComposableLambda = 0;
                } else {
                    str3 = 0;
                    ListItemKt.ListItem.decoratedLeadingContent.1.1 anon5 = new ListItemKt.ListItem.decoratedLeadingContent.1.1(tonalElevation3, obj42);
                    obj40 = decoratedOverlineContent;
                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1400509200, true, anon5, composer2, i49);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(1641004177);
                ComposerKt.sourceInformation(composer2, "*144@6069L353");
                if (trailingContent3 == null) {
                    rememberComposableLambda2 = 0;
                } else {
                    Object obj7 = trailingContent3;
                    str = 0;
                    ListItemKt.ListItem.decoratedTrailingContent.1.1 anon4 = new ListItemKt.ListItem.decoratedTrailingContent.1.1(tonalElevation3, obj7);
                    obj36 = obj7;
                    rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1512306332, true, anon4, composer2, i49);
                }
                composer2.endReplaceGroup();
                int i56 = 1;
                obj38 = rememberComposableLambda2;
                obj37 = rememberComposableLambda;
                obj36 = anon6;
                super(obj37, obj38, (Function2)ComposableLambdaKt.rememberComposableLambda(-403249643, anon2, anon3, composer2, i49), obj40, obj41);
                composableLambda = obj37;
                i20 = obj38;
                i19 = obj40;
                androidx.compose.runtime.internal.ComposableLambda composableLambda3 = obj41;
                obj4 = $dirty >> 9;
                composer3 = composer2;
                SurfaceKt.Surface-T9BRK9s(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, i56, (Function1)ListItemKt.ListItem.1.INSTANCE).then(obj), ListItemDefaults.INSTANCE.getShape(composer2, 6), tonalElevation3.containerColor-0d7_KjU$material3_release(), obj4, tonalElevation3.headlineColor-vNxB06k$material3_release(i56), i2, i7, i22, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1502590376, i56, obj36, composer2, 54), composer3);
                composer = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty;
                obj6 = trailingContent3;
                $dirty2 = obj5;
                trailingContent2 = composableLambda2;
                f = i7;
                supportingContent2 = i22;
                overlineContent2 = tonalElevation3;
                colors2 = obj;
                modifier2 = obj42;
            } else {
                composer.skipToGroupEnd();
                f = tonalElevation;
                i3 = $dirty;
                colors2 = obj;
                $dirty2 = obj5;
                trailingContent2 = composableLambda2;
                supportingContent2 = $composer2;
                obj6 = obj4;
                modifier2 = leadingContent;
                overlineContent2 = colors;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ListItemKt.ListItem.3(headlineContent, colors2, $dirty2, trailingContent2, modifier2, obj6, overlineContent2, f, supportingContent2, i40, i41);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void ListItemLayout(Function2<? super Composer, ? super Integer, Unit> leading, Function2<? super Composer, ? super Integer, Unit> trailing, Function2<? super Composer, ? super Integer, Unit> headline, Function2<? super Composer, ? super Integer, Unit> overline, Function2<? super Composer, ? super Integer, Unit> supporting, Composer $composer, int $changed) {
        boolean traceInProgress;
        Object valueOf2;
        Object $i$a$CacheLayoutKt$Layout$3$iv;
        Object setCompositeKeyHash;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object constructor-impl;
        Object valueOf;
        int $dirty;
        int i3;
        int i4;
        int i9;
        int i;
        int i7;
        java.util.List listOf;
        boolean traceInProgress2;
        androidx.compose.ui.Modifier.Companion companion2;
        Object $i$a$CacheListItemKt$ListItemLayout$measurePolicy$1;
        int i8;
        Object lambda-3$material3_release;
        Object lambda-4$material3_release;
        int changed;
        int i6;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i15;
        int str;
        Object lambda-1$material3_release;
        Object lambda-2$material3_release;
        Function2 combineAsVirtualLayouts;
        int i10;
        int i2;
        Object listItemMeasurePolicy;
        int i14;
        int i12;
        int companion;
        int i13;
        int i5;
        kotlin.jvm.functions.Function0 function0;
        Composer composer;
        int i11;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv$iv;
        Object obj31;
        valueOf2 = leading;
        setCompositeKeyHash = trailing;
        constructor-impl = headline;
        valueOf = overline;
        final Object obj = supporting;
        final int i26 = $changed;
        traceInProgress = 2052297037;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ListItemLayout)P(1,4)181@7324L36,182@7365L261:ListItem.kt#uh7d8r");
        i8 = 2;
        if (i26 & 6 == 0) {
            i3 = restartGroup.changedInstance(valueOf2) ? 4 : i8;
            $dirty |= i3;
        }
        if (i26 & 48 == 0) {
            i4 = restartGroup.changedInstance(setCompositeKeyHash) ? 32 : 16;
            $dirty |= i4;
        }
        if (i26 & 384 == 0) {
            i9 = restartGroup.changedInstance(constructor-impl) ? 256 : 128;
            $dirty |= i9;
        }
        if (i26 & 3072 == 0) {
            i = restartGroup.changedInstance(valueOf) ? 2048 : 1024;
            $dirty |= i;
        }
        if (i26 & 24576 == 0) {
            i7 = restartGroup.changedInstance(obj) ? 16384 : 8192;
            $dirty |= i7;
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:180)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -748109790, "CC(remember):ListItem.kt#9igjgp");
                int i17 = 0;
                Composer composer2 = restartGroup;
                int i35 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i39 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i29 = 0;
                    listItemMeasurePolicy = new ListItemMeasurePolicy();
                    composer2.updateRememberedValue(listItemMeasurePolicy);
                } else {
                    $i$a$CacheListItemKt$ListItemLayout$measurePolicy$1 = rememberedValue3;
                }
                Object invalid$iv = $i$a$CacheListItemKt$ListItemLayout$measurePolicy$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Function2[] arr = new Function2[5];
                if (valueOf == null) {
                    lambda-1$material3_release = ComposableSingletons.ListItemKt.INSTANCE.getLambda-1$material3_release();
                } else {
                    lambda-1$material3_release = valueOf;
                }
                if (obj == null) {
                    lambda-2$material3_release = ComposableSingletons.ListItemKt.INSTANCE.getLambda-2$material3_release();
                } else {
                    lambda-2$material3_release = obj;
                }
                arr[i8] = lambda-2$material3_release;
                if (valueOf2 == null) {
                    lambda-3$material3_release = ComposableSingletons.ListItemKt.INSTANCE.getLambda-3$material3_release();
                } else {
                    lambda-3$material3_release = valueOf2;
                }
                arr[3] = lambda-3$material3_release;
                if (setCompositeKeyHash == null) {
                    lambda-4$material3_release = ComposableSingletons.ListItemKt.INSTANCE.getLambda-4$material3_release();
                } else {
                    lambda-4$material3_release = setCompositeKeyHash;
                }
                arr[4] = lambda-4$material3_release;
                str = i30;
                i10 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
                if (i31 ^= i33 > 256) {
                    if (!restartGroup.changed((MultiContentMeasurePolicy)(ListItemMeasurePolicy)invalid$iv)) {
                        i6 = str & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer3 = restartGroup;
                int i40 = 0;
                Object rememberedValue = composer3.rememberedValue();
                int i41 = 0;
                if (i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i22 = 0;
                        composer3.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy((MultiContentMeasurePolicy)invalid$iv));
                    } else {
                        $i$a$CacheLayoutKt$Layout$3$iv = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                i2 = currentCompositeKeyHash;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                companion = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)$i$a$CacheLayoutKt$Layout$3$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i5 = 0;
                composer = constructor-impl;
                i11 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i2))) {
                        composer.updateRememberedValue(Integer.valueOf(i2));
                        constructor-impl.apply(Integer.valueOf(i2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = composer;
                    }
                } else {
                    measurePolicy$iv$iv = $i$a$CacheLayoutKt$Layout$3$iv;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                LayoutKt.combineAsVirtualLayouts(CollectionsKt.listOf(arr)).invoke(restartGroup, Integer.valueOf(i20 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ListItemKt.ListItemLayout.1(leading, trailing, headline, overline, obj, i26);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void ProvideTextStyleFromToken-3J-VO9M(long color, TypographyKeyTokens textToken, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty2;
        int $dirty;
        boolean traceInProgress;
        int i2;
        int i4;
        int i3;
        int str;
        Object obj;
        Object obj2;
        long l;
        androidx.compose.ui.text.TextStyle value;
        Object obj3;
        int i;
        final int i8 = obj18;
        traceInProgress2 = 1133967795;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)659@26906L5,657@26816L128:ListItem.kt#uh7d8r");
        if (i8 & 6 == 0) {
            i2 = restartGroup.changed(color) ? 4 : 2;
            $dirty2 |= i2;
        }
        if (i8 & 48 == 0) {
            i4 = restartGroup.changed(content) ? 32 : 16;
            $dirty2 |= i4;
        }
        if (i8 & 384 == 0) {
            i3 = restartGroup.changedInstance($composer) ? 256 : 128;
            $dirty2 |= i3;
        } else {
            obj2 = $composer;
        }
        final int i9 = $dirty2;
        if (i9 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i9, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:657)");
                }
                ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(color, obj7, TypographyKt.getValue(content, restartGroup, i5 &= 14), obj2, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ListItemKt.ProvideTextStyleFromToken.1(color, str, content, $composer, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$ListItemLayout(Function2 leading, Function2 trailing, Function2 headline, Function2 overline, Function2 supporting, Composer $composer, int $changed) {
        ListItemKt.ListItemLayout(leading, trailing, headline, overline, supporting, $composer, $changed);
    }

    public static final void access$ProvideTextStyleFromToken-3J-VO9M(long color, TypographyKeyTokens textToken, Function2 content, Composer $composer, int $changed) {
        ListItemKt.ProvideTextStyleFromToken-3J-VO9M(color, textToken, content, $composer, $changed);
    }

    public static final int access$calculateHeight-N4Jib3Y(IntrinsicMeasureScope $receiver, int leadingHeight, int trailingHeight, int headlineHeight, int overlineHeight, int supportingHeight, int listItemType, int verticalPadding, long constraints) {
        return ListItemKt.calculateHeight-N4Jib3Y($receiver, leadingHeight, trailingHeight, headlineHeight, overlineHeight, supportingHeight, listItemType, verticalPadding, constraints);
    }

    public static final int access$calculateWidth-yeHjK3Y(IntrinsicMeasureScope $receiver, int leadingWidth, int trailingWidth, int headlineWidth, int overlineWidth, int supportingWidth, int horizontalPadding, long constraints) {
        return ListItemKt.calculateWidth-yeHjK3Y($receiver, leadingWidth, trailingWidth, headlineWidth, overlineWidth, supportingWidth, horizontalPadding, constraints);
    }

    public static final boolean access$isSupportingMultilineHeuristic(Density $receiver, int estimatedSupportingHeight) {
        return ListItemKt.isSupportingMultilineHeuristic($receiver, estimatedSupportingHeight);
    }

    public static final MeasureResult access$place(MeasureScope $receiver, int width, int height, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable headlinePlaceable, Placeable overlinePlaceable, Placeable supportingPlaceable, boolean isThreeLine, int startPadding, int endPadding, int topPadding) {
        return ListItemKt.place($receiver, width, height, leadingPlaceable, trailingPlaceable, headlinePlaceable, overlinePlaceable, supportingPlaceable, isThreeLine, startPadding, endPadding, topPadding);
    }

    public static final int access$subtractConstraintSafely(int $receiver, int n) {
        return ListItemKt.subtractConstraintSafely($receiver, n);
    }

    public static final float access$verticalPadding-yh95HIg(int listItemType) {
        return ListItemKt.verticalPadding-yh95HIg(listItemType);
    }

    private static final int calculateHeight-N4Jib3Y(IntrinsicMeasureScope $this$calculateHeight_u2dN4Jib3Y, int leadingHeight, int trailingHeight, int headlineHeight, int overlineHeight, int supportingHeight, int listItemType, int verticalPadding, long constraints) {
        float listItemOneLineContainerHeight-D9Ej5fM;
        if (ListItemType.equals-impl0(listItemType, ListItemType.Companion.getOneLine-AlXitO8())) {
            listItemOneLineContainerHeight-D9Ej5fM = ListTokens.INSTANCE.getListItemOneLineContainerHeight-D9Ej5fM();
        } else {
            if (ListItemType.equals-impl0(listItemType, ListItemType.Companion.getTwoLine-AlXitO8())) {
                listItemOneLineContainerHeight-D9Ej5fM = ListTokens.INSTANCE.getListItemTwoLineContainerHeight-D9Ej5fM();
            } else {
                listItemOneLineContainerHeight-D9Ej5fM = ListTokens.INSTANCE.getListItemThreeLineContainerHeight-D9Ej5fM();
            }
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.getMinHeight-impl(constraints), $this$calculateHeight_u2dN4Jib3Y.roundToPx-0680j_4(listItemOneLineContainerHeight-D9Ej5fM)), i5 += verticalPadding), Constraints.getMaxHeight-impl(constraints));
    }

    private static final int calculateWidth-yeHjK3Y(IntrinsicMeasureScope $this$calculateWidth_u2dyeHjK3Y, int leadingWidth, int trailingWidth, int headlineWidth, int overlineWidth, int supportingWidth, int horizontalPadding, long constraints) {
        if (Constraints.getHasBoundedWidth-impl(constraints)) {
            return Constraints.getMaxWidth-impl(constraints);
        }
        return i4 += trailingWidth;
    }

    public static final float getLeadingContentEndPadding() {
        return ListItemKt.LeadingContentEndPadding;
    }

    public static void getLeadingContentEndPadding$annotations() {
    }

    public static final float getListItemEndPadding() {
        return ListItemKt.ListItemEndPadding;
    }

    public static void getListItemEndPadding$annotations() {
    }

    public static final float getListItemStartPadding() {
        return ListItemKt.ListItemStartPadding;
    }

    public static void getListItemStartPadding$annotations() {
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemKt.ListItemThreeLineVerticalPadding;
    }

    public static void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static final float getListItemVerticalPadding() {
        return ListItemKt.ListItemVerticalPadding;
    }

    public static void getListItemVerticalPadding$annotations() {
    }

    public static final float getTrailingContentStartPadding() {
        return ListItemKt.TrailingContentStartPadding;
    }

    public static void getTrailingContentStartPadding$annotations() {
    }

    private static final boolean isSupportingMultilineHeuristic(Density $this$isSupportingMultilineHeuristic, int estimatedSupportingHeight) {
        int i;
        i = estimatedSupportingHeight > $this$isSupportingMultilineHeuristic.roundToPx--R2X_6o(TextUnitKt.getSp(30)) ? 1 : 0;
        return i;
    }

    private static final MeasureResult place(MeasureScope $this$place, int width, int height, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable headlinePlaceable, Placeable overlinePlaceable, Placeable supportingPlaceable, boolean isThreeLine, int startPadding, int endPadding, int topPadding) {
        ListItemKt.place.1 anon = new ListItemKt.place.1(leadingPlaceable, trailingPlaceable, startPadding, isThreeLine, topPadding, headlinePlaceable, overlinePlaceable, supportingPlaceable, height, width, endPadding);
        return MeasureScope.layout$default($this$place, width, height, 0, (Function1)anon, 4, 0);
    }

    private static final int subtractConstraintSafely(int $this$subtractConstraintSafely, int n) {
        if ($this$subtractConstraintSafely == Integer.MAX_VALUE) {
            return $this$subtractConstraintSafely;
        }
        return $this$subtractConstraintSafely - n;
    }

    private static final float verticalPadding-yh95HIg(int listItemType) {
        float listItemThreeLineVerticalPadding;
        listItemThreeLineVerticalPadding = ListItemType.equals-impl0(listItemType, ListItemType.Companion.getThreeLine-AlXitO8()) ? ListItemKt.ListItemThreeLineVerticalPadding : ListItemKt.ListItemVerticalPadding;
        return listItemThreeLineVerticalPadding;
    }
}
