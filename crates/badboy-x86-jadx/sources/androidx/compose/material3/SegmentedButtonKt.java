package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aD\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00062\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\r2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\rH\u0003¢\u0006\u0002\u0010\u0014\u001aD\u0010\u0015\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0008\r¢\u0006\u0002\u0008\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0010\u001a\u0091\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u000c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\u0008\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010&\u001a\u008b\u0001\u0010\u0018\u001a\u00020\u0006*\u00020\u00162\u0006\u0010'\u001a\u00020\u001a2\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\n\u0008\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0013\u0008\u0002\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\r2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00060\u0013¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010)\u001a\u0017\u0010*\u001a\u0008\u0012\u0004\u0012\u00020,0+*\u00020-H\u0003¢\u0006\u0002\u0010.\u001a\"\u0010/\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u001a2\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020,0+H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00061", d2 = {"CheckedZIndexFactor", "", "IconSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "MultiChoiceSegmentedButtonRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "space", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "MultiChoiceSegmentedButtonRow-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SegmentedButtonContent", "icon", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SingleChoiceSegmentedButtonRow", "Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;", "SingleChoiceSegmentedButtonRow-uFdPcIQ", "SegmentedButton", "checked", "", "onCheckedChange", "shape", "Landroidx/compose/ui/graphics/Shape;", "enabled", "colors", "Landroidx/compose/material3/SegmentedButtonColors;", "border", "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "label", "(Landroidx/compose/material3/MultiChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "onClick", "(Landroidx/compose/material3/SingleChoiceSegmentedButtonRowScope;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SegmentedButtonColors;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "interactionCountAsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "interactionZIndex", "interactionCount", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SegmentedButtonKt {

    private static final float CheckedZIndexFactor = 5f;
    private static final float IconSpacing;
    static {
        final int i2 = 0;
        SegmentedButtonKt.IconSpacing = Dp.constructor-impl((float)i);
    }

    public static final void MultiChoiceSegmentedButtonRow-uFdPcIQ(Modifier modifier, float space, Function3<? super androidx.compose.material3.MultiChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        Function0 factory$iv$iv$iv;
        int traceInProgress2;
        int $dirty2;
        int $dirty;
        Object modifier3;
        Object it$iv2;
        Object obj;
        float space2;
        float f2;
        Integer valueOf2;
        Object empty;
        boolean traceInProgress;
        Composer composer2;
        Object valueOf;
        int i3;
        int centerVertically;
        float f;
        int i8;
        int i7;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i2;
        int i12;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i11;
        int i;
        float f3;
        int i16;
        int i15;
        int i10;
        Modifier modifier2;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalArrangement$iv;
        Composer composer;
        int i4;
        int i5;
        int i13;
        Object it$iv;
        int i14;
        Object obj30;
        Modifier obj31;
        Function0 obj33;
        final Object obj2 = content;
        valueOf2 = $changed;
        traceInProgress2 = 155922315;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(MultiChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)307@14058L411:SegmentedButton.kt#uh7d8r");
        $dirty2 = $changed;
        int i23 = i6 & 1;
        if (i23 != 0) {
            $dirty2 |= 6;
            empty = modifier;
        } else {
            if (valueOf2 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                empty = modifier;
            }
        }
        centerVertically = i6 & 2;
        if (centerVertically != 0) {
            $dirty2 |= 48;
            f = space;
        } else {
            if (valueOf2 & 48 == 0) {
                i8 = restartGroup.changed(space) ? 32 : 16;
                $dirty2 |= i8;
            } else {
                f = space;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (valueOf2 & 384 == 0) {
                i7 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty2 |= i7;
            }
        }
        int i39 = $dirty2;
        if (i39 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i23 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = empty;
                }
                if (centerVertically != 0) {
                    space2 = SegmentedButtonDefaults.INSTANCE.getBorderWidth-D9Ej5fM();
                } else {
                    space2 = f;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i39, -1, "androidx.compose.material3.MultiChoiceSegmentedButtonRow (SegmentedButton.kt:306)");
                }
                Modifier width = IntrinsicKt.width(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, 0), IntrinsicSize.Min);
                int i35 = 0;
                valueOf = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(-space2));
                f = 384;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, width);
                obj31 = width;
                obj33 = constructor;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj33);
                } else {
                    factory$iv$iv$iv = obj33;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i49 = 0;
                obj33 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy((Arrangement.Horizontal)valueOf, Alignment.Companion.getCenterVertically(), restartGroup, i42 |= i45), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i50 = 0;
                Composer composer6 = constructor-impl;
                int i51 = 0;
                if (!composer6.getInserting()) {
                    horizontalArrangement$iv = valueOf;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer6;
                    }
                } else {
                    horizontalArrangement$iv = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i16 = i20;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i10 = 0;
                modifier2 = materializeModifier;
                i4 = i27;
                valueOf2 = composer5;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 1297400858, "C315@14382L57,316@14454L9:SegmentedButton.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(valueOf2, 596041317, "CC(remember):SegmentedButton.kt#9igjgp");
                Composer composer4 = valueOf2;
                i15 = 0;
                i5 = i22;
                it$iv2 = composer4.rememberedValue();
                i13 = 0;
                i14 = i33;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    it$iv = it$iv2;
                    it$iv2 = new MultiChoiceSegmentedButtonScopeWrapper((RowScope)RowScopeInstance.INSTANCE);
                    composer4.updateRememberedValue(it$iv2);
                } else {
                    it$iv = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                obj2.invoke((MultiChoiceSegmentedButtonScopeWrapper)it$iv2, valueOf2, Integer.valueOf(i25 |= 6));
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj30;
                f2 = f3;
            } else {
                restartGroup.skipToGroupEnd();
                obj = empty;
                f2 = f;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SegmentedButtonKt.MultiChoiceSegmentedButtonRow.2(obj, f2, obj2, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void SegmentedButton(androidx.compose.material3.MultiChoiceSegmentedButtonRowScope $this$SegmentedButton, boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Shape shape, Modifier modifier, boolean enabled, androidx.compose.material3.SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj3;
        Object endRestartGroup;
        Object obj9;
        Object obj4;
        int i19;
        int i14;
        boolean traceInProgress;
        boolean colors4;
        Object obj2;
        int defaultsInvalid;
        Object modifier2;
        int i12;
        Object colors2;
        Object enabled3;
        boolean colors3;
        boolean $composer2;
        int $dirty4;
        Object $dirty3;
        Object $dirty;
        int $dirty12;
        Object obj8;
        int i2;
        int rememberedValue;
        int i21;
        int i3;
        Object obj7;
        int i9;
        boolean z;
        Object obj6;
        int enabled2;
        Object borderStroke-l07J4OM$default;
        boolean traceInProgress2;
        String str;
        int i10;
        Object obj5;
        int i7;
        int interactionSource3;
        int iNSTANCE;
        int interactionSource2;
        Object rememberComposableLambda;
        int i6;
        int $dirty2;
        int i13;
        int i16;
        int i17;
        Composer composer;
        int changed2;
        int i5;
        int i18;
        int changed;
        int i;
        Object obj;
        int i20;
        int companion;
        int i4;
        int iNSTANCE2;
        long borderColor-WaAFU9c$material3_release;
        long l;
        int i11;
        int $dirty1;
        int i8;
        int containerColor-WaAFU9c$material3_release;
        Object obj31;
        Modifier obj32;
        traceInProgress = checked;
        obj3 = label;
        int i41 = $changed;
        i12 = i15;
        Composer restartGroup = $composer.startRestartGroup(-1596038053);
        ComposerKt.sourceInformation(restartGroup, "C(SegmentedButton)P(1,8,9,7,3,2!1,5)133@6692L8,137@6905L41,144@7279L25,163@7880L51,146@7310L621:SegmentedButton.kt#uh7d8r");
        $dirty4 = $changed;
        $dirty12 = $changed1;
        if (i47 &= i12 != 0) {
            $dirty4 |= 6;
        } else {
            if (i41 & 6 == 0) {
                i21 = restartGroup.changed($this$SegmentedButton) ? 4 : 2;
                $dirty4 |= i21;
            }
        }
        if (i12 & 1 != 0) {
            $dirty4 |= 48;
        } else {
            if (i41 & 48 == 0) {
                i3 = restartGroup.changed(traceInProgress) ? 32 : 16;
                $dirty4 |= i3;
            }
        }
        if (i12 & 2 != 0) {
            $dirty4 |= 384;
            obj7 = onCheckedChange;
        } else {
            if (i41 & 384 == 0) {
                i10 = restartGroup.changedInstance(onCheckedChange) ? 256 : 128;
                $dirty4 |= i10;
            } else {
                obj7 = onCheckedChange;
            }
        }
        if (i12 & 4 != 0) {
            $dirty4 |= 3072;
            obj5 = shape;
        } else {
            if (i41 & 3072 == 0) {
                i7 = restartGroup.changed(shape) ? 2048 : 1024;
                $dirty4 |= i7;
            } else {
                obj5 = shape;
            }
        }
        interactionSource3 = i12 & 8;
        if (interactionSource3 != 0) {
            $dirty4 |= 24576;
            rememberComposableLambda = modifier;
        } else {
            if (i41 & 24576 == 0) {
                i6 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty4 |= i6;
            } else {
                rememberComposableLambda = modifier;
            }
        }
        i13 = i12 & 16;
        i16 = 196608;
        if (i13 != 0) {
            $dirty4 |= i16;
            z = enabled;
        } else {
            if (i41 & i16 == 0) {
                i16 = restartGroup.changed(enabled) ? 131072 : 65536;
                $dirty4 |= i16;
            } else {
                z = enabled;
            }
        }
        if (i41 & i60 == 0) {
            if (i12 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                colors2 = colors;
            }
            $dirty4 |= changed2;
        } else {
            colors2 = colors;
        }
        if (i41 & i61 == 0) {
            if (i12 & 64 == 0) {
                changed = restartGroup.changed(border) ? 8388608 : 4194304;
            } else {
                borderStroke-l07J4OM$default = border;
            }
            $dirty4 |= changed;
        } else {
            borderStroke-l07J4OM$default = border;
        }
        int i28 = i12 & 128;
        int i62 = 100663296;
        if (i28 != 0) {
            $dirty4 |= i62;
            i = i28;
            obj9 = interactionSource;
        } else {
            if (i41 & i62 == 0) {
                i = i28;
                i20 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty4 |= i20;
            } else {
                i = i28;
                obj9 = interactionSource;
            }
        }
        int i29 = i12 & 256;
        int i65 = 805306368;
        if (i29 != 0) {
            $dirty4 |= i65;
            companion = i29;
            obj4 = icon;
        } else {
            if (i41 & i65 == 0) {
                companion = i29;
                i4 = restartGroup.changedInstance(icon) ? 536870912 : 268435456;
                $dirty4 |= i4;
            } else {
                companion = i29;
                obj4 = icon;
            }
        }
        if (i12 & 512 != 0) {
            $dirty12 |= 6;
        } else {
            if ($changed1 & 6 == 0) {
                i19 = restartGroup.changedInstance(obj3) ? 4 : 2;
                $dirty12 |= i19;
            }
        }
        i14 = $dirty12;
        if ($dirty13 &= $dirty4 == 306783378 && i14 & 3 == 2) {
            if (i14 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i18 = -29360129;
                    iNSTANCE2 = -3670017;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (interactionSource3 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rememberComposableLambda;
                            }
                            if (i13 != 0) {
                                z = 1;
                            }
                            if (i12 & 32 != 0) {
                                colors2 = SegmentedButtonDefaults.INSTANCE.colors(restartGroup, 6);
                                $dirty4 &= iNSTANCE2;
                            }
                            if (i12 & 64 != 0) {
                                borderStroke-l07J4OM$default = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors2.borderColor-WaAFU9c$material3_release(z, traceInProgress), obj22, 0, 2);
                                $dirty4 &= i18;
                            }
                            interactionSource2 = i != 0 ? 0 : interactionSource;
                            if (companion != 0) {
                                SegmentedButtonKt.SegmentedButton.1 anon2 = new SegmentedButtonKt.SegmentedButton.1(traceInProgress);
                                $dirty = composableLambda;
                                obj2 = colors2;
                                colors3 = z;
                                enabled2 = i63;
                                obj = obj31;
                                i11 = interactionSource2;
                                interactionSource3 = borderStroke-l07J4OM$default;
                            } else {
                                obj = obj31;
                                obj2 = colors2;
                                colors3 = z;
                                i11 = interactionSource2;
                                enabled2 = $dirty4;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                $dirty = icon;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i12 & 32 != 0) {
                                $dirty4 &= iNSTANCE2;
                            }
                            if (i12 & 64 != 0) {
                                enabled2 = i44;
                                obj2 = colors2;
                                colors3 = $dirty5;
                                i11 = interactionSource;
                                $dirty = icon;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                obj = rememberComposableLambda;
                            } else {
                                i11 = interactionSource;
                                obj2 = colors2;
                                colors3 = z;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                obj = rememberComposableLambda;
                                enabled2 = $dirty4;
                                $dirty = icon;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1596038053, enabled2, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:139)");
                    }
                    restartGroup.startReplaceGroup(1788099965);
                    ComposerKt.sourceInformation(restartGroup, "141@7068L39");
                    if (i11 == 0) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1788100616, "CC(remember):SegmentedButton.kt#9igjgp");
                        str = 0;
                        Composer composer2 = restartGroup;
                        i13 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i18 = 0;
                        $dirty1 = i14;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i40 = 0;
                            composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i14 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        rememberComposableLambda = i14;
                    } else {
                        $dirty1 = i14;
                        rememberComposableLambda = i11;
                    }
                    restartGroup.endReplaceGroup();
                    State interactionCountAsState = SegmentedButtonKt.interactionCountAsState((InteractionSource)rememberComposableLambda, restartGroup, 0);
                    obj31 = i30;
                    SegmentedButtonKt.SegmentedButton.2 anon = new SegmentedButtonKt.SegmentedButton.2($dirty, obj3);
                    obj3 = interactionCountAsState;
                    SurfaceKt.Surface-d85dljk(traceInProgress, onCheckedChange, SizeKt.defaultMinSize-VpY3zN4(SegmentedButtonKt.interactionZIndex(RowScope.weight$default((RowScope)$this$SegmentedButton, obj, 1065353216, false, 2, 0), traceInProgress, interactionCountAsState), ButtonDefaults.INSTANCE.getMinWidth-D9Ej5fM(), ButtonDefaults.INSTANCE.getMinHeight-D9Ej5fM()), colors3, shape, obj2.containerColor-WaAFU9c$material3_release(colors3, traceInProgress), interactionCountAsState, obj2.contentColor-WaAFU9c$material3_release(colors3, traceInProgress), enabled2, 0, 0, interactionSource3, rememberComposableLambda, (Function2)ComposableLambdaKt.rememberComposableLambda(1635710341, true, anon, restartGroup, 54), restartGroup, i27 | i39);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty2 = i14;
                    $composer2 = colors3;
                    obj8 = interactionSource3;
                    enabled3 = i4;
                    $dirty3 = borderColor-WaAFU9c$material3_release;
                    obj6 = l;
                    i9 = i11;
                } else {
                    restartGroup.skipToGroupEnd();
                    i9 = interactionSource;
                    $dirty1 = i14;
                    composer = restartGroup;
                    $dirty2 = $dirty4;
                    $composer2 = z;
                    obj8 = borderStroke-l07J4OM$default;
                    obj6 = icon;
                    $dirty3 = colors2;
                    enabled3 = rememberComposableLambda;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj31 = $dirty2;
            endRestartGroup = new SegmentedButtonKt.SegmentedButton.3($this$SegmentedButton, checked, onCheckedChange, shape, enabled3, $composer2, $dirty3, obj8, i9, obj6, label, $changed, $changed1, i15);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj31 = $dirty2;
        }
    }

    public static final void SegmentedButton(androidx.compose.material3.SingleChoiceSegmentedButtonRowScope $this$SegmentedButton, boolean selected, Function0<Unit> onClick, Shape shape, Modifier modifier, boolean enabled, androidx.compose.material3.SegmentedButtonColors colors, BorderStroke border, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, Composer $composer, int $changed, int $changed1, int i15) {
        Object anon;
        Object obj;
        Object obj6;
        int i6;
        int i14;
        Object endRestartGroup;
        boolean traceInProgress;
        boolean skipping;
        Object obj3;
        int defaultsInvalid;
        Object modifier2;
        int i17;
        Object colors4;
        Object enabled3;
        boolean colors2;
        boolean $composer2;
        int $dirty3;
        Object $dirty;
        Object $dirty2;
        int $dirty1;
        Object obj2;
        int i9;
        int rememberedValue;
        int i2;
        int i12;
        Object obj8;
        int i20;
        boolean z;
        Object obj5;
        int enabled2;
        Object borderStroke-l07J4OM$default;
        boolean traceInProgress2;
        String str;
        int i16;
        Object obj7;
        int i11;
        int interactionSource3;
        int iNSTANCE2;
        int interactionSource2;
        Object rememberComposableLambda;
        int i;
        int $dirty4;
        int i8;
        int i13;
        int i3;
        Composer composer;
        int changed2;
        int colors3;
        int i4;
        int changed;
        int i5;
        Object obj4;
        int i7;
        int companion;
        int i18;
        int iNSTANCE;
        long borderColor-WaAFU9c$material3_release;
        long l;
        int i10;
        int $dirty12;
        int i19;
        int containerColor;
        long l2;
        Object obj33;
        int obj34;
        traceInProgress = selected;
        anon = label;
        int i32 = $changed;
        i17 = i15;
        Composer restartGroup = $composer.startRestartGroup(-1016574361);
        ComposerKt.sourceInformation(restartGroup, "C(SegmentedButton)P(8,7,9,6,2,1!1,4)211@10255L8,215@10469L42,222@10846L25,242@11489L51,224@10877L663:SegmentedButton.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        if (i47 &= i17 != 0) {
            $dirty3 |= 6;
        } else {
            if (i32 & 6 == 0) {
                i2 = restartGroup.changed($this$SegmentedButton) ? 4 : 2;
                $dirty3 |= i2;
            }
        }
        if (i17 & 1 != 0) {
            $dirty3 |= 48;
        } else {
            if (i32 & 48 == 0) {
                i12 = restartGroup.changed(traceInProgress) ? 32 : 16;
                $dirty3 |= i12;
            }
        }
        if (i17 & 2 != 0) {
            $dirty3 |= 384;
            obj8 = onClick;
        } else {
            if (i32 & 384 == 0) {
                i16 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty3 |= i16;
            } else {
                obj8 = onClick;
            }
        }
        if (i17 & 4 != 0) {
            $dirty3 |= 3072;
            obj7 = shape;
        } else {
            if (i32 & 3072 == 0) {
                i11 = restartGroup.changed(shape) ? 2048 : 1024;
                $dirty3 |= i11;
            } else {
                obj7 = shape;
            }
        }
        interactionSource3 = i17 & 8;
        if (interactionSource3 != 0) {
            $dirty3 |= 24576;
            rememberComposableLambda = modifier;
        } else {
            if (i32 & 24576 == 0) {
                i = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty3 |= i;
            } else {
                rememberComposableLambda = modifier;
            }
        }
        i8 = i17 & 16;
        i13 = 196608;
        if (i8 != 0) {
            $dirty3 |= i13;
            z = enabled;
        } else {
            if (i32 & i13 == 0) {
                i13 = restartGroup.changed(enabled) ? 131072 : 65536;
                $dirty3 |= i13;
            } else {
                z = enabled;
            }
        }
        if (i32 & i62 == 0) {
            if (i17 & 32 == 0) {
                changed2 = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                colors4 = colors;
            }
            $dirty3 |= changed2;
        } else {
            colors4 = colors;
        }
        if (i32 & i63 == 0) {
            if (i17 & 64 == 0) {
                changed = restartGroup.changed(border) ? 8388608 : 4194304;
            } else {
                borderStroke-l07J4OM$default = border;
            }
            $dirty3 |= changed;
        } else {
            borderStroke-l07J4OM$default = border;
        }
        int i21 = i17 & 128;
        int i64 = 100663296;
        if (i21 != 0) {
            $dirty3 |= i64;
            i5 = i21;
            obj = interactionSource;
        } else {
            if (i32 & i64 == 0) {
                i5 = i21;
                i7 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty3 |= i7;
            } else {
                i5 = i21;
                obj = interactionSource;
            }
        }
        int i22 = i17 & 256;
        int i67 = 805306368;
        if (i22 != 0) {
            $dirty3 |= i67;
            companion = i22;
            obj6 = icon;
        } else {
            if (i32 & i67 == 0) {
                companion = i22;
                i18 = restartGroup.changedInstance(icon) ? 536870912 : 268435456;
                $dirty3 |= i18;
            } else {
                companion = i22;
                obj6 = icon;
            }
        }
        if (i17 & 512 != 0) {
            $dirty1 |= 6;
        } else {
            if ($changed1 & 6 == 0) {
                i6 = restartGroup.changedInstance(anon) ? 4 : 2;
                $dirty1 |= i6;
            }
        }
        i14 = $dirty1;
        if ($dirty13 &= $dirty3 == 306783378 && i14 & 3 == 2) {
            if (i14 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    restartGroup.startDefaults();
                    i4 = -29360129;
                    iNSTANCE = -3670017;
                    if ($changed & 1 != 0) {
                        if (restartGroup.getDefaultsInvalid()) {
                            if (interactionSource3 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = rememberComposableLambda;
                            }
                            if (i8 != 0) {
                                z = 1;
                            }
                            if (i17 & 32 != 0) {
                                colors4 = SegmentedButtonDefaults.INSTANCE.colors(restartGroup, 6);
                                $dirty3 &= iNSTANCE;
                            }
                            if (i17 & 64 != 0) {
                                borderStroke-l07J4OM$default = SegmentedButtonDefaults.borderStroke-l07J4OM$default(SegmentedButtonDefaults.INSTANCE, colors4.borderColor-WaAFU9c$material3_release(z, traceInProgress), obj22, 0, 2);
                                $dirty3 &= i4;
                            }
                            interactionSource2 = i5 != 0 ? 0 : interactionSource;
                            if (companion != 0) {
                                SegmentedButtonKt.SegmentedButton.4 anon3 = new SegmentedButtonKt.SegmentedButton.4(traceInProgress);
                                $dirty2 = composableLambda;
                                obj3 = colors4;
                                colors2 = z;
                                enabled2 = i65;
                                obj4 = obj33;
                                i10 = interactionSource2;
                                interactionSource3 = borderStroke-l07J4OM$default;
                            } else {
                                obj4 = obj33;
                                obj3 = colors4;
                                colors2 = z;
                                i10 = interactionSource2;
                                enabled2 = $dirty3;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                $dirty2 = icon;
                            }
                        } else {
                            restartGroup.skipToGroupEnd();
                            if (i17 & 32 != 0) {
                                $dirty3 &= iNSTANCE;
                            }
                            if (i17 & 64 != 0) {
                                enabled2 = i44;
                                obj3 = colors4;
                                colors2 = $dirty5;
                                i10 = interactionSource;
                                $dirty2 = icon;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                obj4 = rememberComposableLambda;
                            } else {
                                i10 = interactionSource;
                                obj3 = colors4;
                                colors2 = z;
                                interactionSource3 = borderStroke-l07J4OM$default;
                                obj4 = rememberComposableLambda;
                                enabled2 = $dirty3;
                                $dirty2 = icon;
                            }
                        }
                    } else {
                    }
                    restartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1016574361, enabled2, i14, "androidx.compose.material3.SegmentedButton (SegmentedButton.kt:217)");
                    }
                    restartGroup.startReplaceGroup(1788214045);
                    ComposerKt.sourceInformation(restartGroup, "219@10633L39");
                    if (i10 == 0) {
                        ComposerKt.sourceInformationMarkerStart(restartGroup, 1788214696, "CC(remember):SegmentedButton.kt#9igjgp");
                        str = 0;
                        Composer composer2 = restartGroup;
                        i8 = 0;
                        rememberedValue = composer2.rememberedValue();
                        i4 = 0;
                        $dirty12 = i14;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            int i24 = 0;
                            composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                        } else {
                            i14 = rememberedValue;
                        }
                        ComposerKt.sourceInformationMarkerEnd(restartGroup);
                        rememberComposableLambda = i14;
                    } else {
                        $dirty12 = i14;
                        rememberComposableLambda = i10;
                    }
                    restartGroup.endReplaceGroup();
                    State interactionCountAsState = SegmentedButtonKt.interactionCountAsState((InteractionSource)rememberComposableLambda, restartGroup, 0);
                    obj34 = i23;
                    SegmentedButtonKt.SegmentedButton.6 anon2 = new SegmentedButtonKt.SegmentedButton.6($dirty2, anon);
                    borderColor-WaAFU9c$material3_release = interactionCountAsState;
                    SurfaceKt.Surface-d85dljk(selected, onClick, SemanticsModifierKt.semantics$default(SizeKt.defaultMinSize-VpY3zN4(SegmentedButtonKt.interactionZIndex(RowScope.weight$default((RowScope)$this$SegmentedButton, obj4, 1065353216, false, 2, 0), traceInProgress, interactionCountAsState), ButtonDefaults.INSTANCE.getMinWidth-D9Ej5fM(), ButtonDefaults.INSTANCE.getMinHeight-D9Ej5fM()), false, (Function1)SegmentedButtonKt.SegmentedButton.5.INSTANCE, 1, 0), colors2, shape, obj3.containerColor-WaAFU9c$material3_release(colors2, traceInProgress), interactionCountAsState, obj3.contentColor-WaAFU9c$material3_release(colors2, traceInProgress), enabled2, 0, 0, interactionSource3, rememberComposableLambda, (Function2)ComposableLambdaKt.rememberComposableLambda(383378045, true, anon2, restartGroup, 54), restartGroup, i30 |= i41);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $dirty4 = i14;
                    $composer2 = colors2;
                    obj2 = interactionSource3;
                    enabled3 = i18;
                    $dirty = l;
                    i20 = i10;
                    obj5 = containerColor;
                } else {
                    restartGroup.skipToGroupEnd();
                    i20 = interactionSource;
                    $dirty12 = i14;
                    composer = restartGroup;
                    $dirty4 = $dirty3;
                    $composer2 = z;
                    obj2 = borderStroke-l07J4OM$default;
                    obj5 = icon;
                    $dirty = colors4;
                    enabled3 = rememberComposableLambda;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj33 = $dirty4;
            anon = new SegmentedButtonKt.SegmentedButton.7($this$SegmentedButton, selected, onClick, shape, enabled3, $composer2, $dirty, obj2, i20, obj5, label, $changed, $changed1, i15);
            endRestartGroup.updateScope((Function2)anon);
        } else {
            obj33 = $dirty4;
        }
    }

    private static final void SegmentedButtonContent(Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        boolean maybeCachedBoxMeasurePolicy;
        int traceInProgress;
        Object rememberComposableLambda;
        int $dirty;
        int i5;
        int i6;
        int skipping;
        boolean traceInProgress2;
        int $changed2;
        Composer composer3;
        Integer valueOf;
        int $changed$iv;
        int i9;
        int i11;
        int i8;
        int i15;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Function0 constructor;
        int i3;
        int i14;
        Modifier modifier;
        int i2;
        int i;
        Composer composer;
        int i12;
        int i7;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        int i10;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        int i13;
        int i4;
        final Object obj = icon;
        final Object obj2 = content;
        final int i16 = $changed;
        traceInProgress = 1464121570;
        rememberComposableLambda = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(rememberComposableLambda, "C(SegmentedButtonContent)P(1)325@14600L595:SegmentedButton.kt#uh7d8r");
        if (i16 & 6 == 0) {
            i5 = rememberComposableLambda.changedInstance(obj) ? 4 : 2;
            $dirty |= i5;
        }
        if (i16 & 48 == 0) {
            i6 = rememberComposableLambda.changedInstance(obj2) ? 32 : 16;
            $dirty |= i6;
        }
        if ($dirty & 19 == 18) {
            if (!rememberComposableLambda.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.SegmentedButtonContent (SegmentedButton.kt:324)");
                }
                int i30 = i22;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberComposableLambda, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
                i15 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberComposableLambda, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(rememberComposableLambda, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(rememberComposableLambda, PaddingKt.padding((Modifier)Modifier.Companion, ButtonDefaults.INSTANCE.getTextButtonContentPadding()));
                i3 = $dirty;
                int $dirty2 = 6;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(rememberComposableLambda, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                rememberComposableLambda.startReusableNode();
                if (rememberComposableLambda.getInserting()) {
                    rememberComposableLambda.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    rememberComposableLambda.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(rememberComposableLambda);
                valueOf = 0;
                composer = rememberComposableLambda;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, rememberComposableLambda.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i36 = 0;
                Composer composer5 = constructor-impl;
                int i37 = 0;
                if (!composer5.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i10 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer5;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i10 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = composer;
                i = i18;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i7 = 0;
                boxScopeInstance = iNSTANCE;
                i13 = i21;
                $dirty = composer6;
                ComposerKt.sourceInformationMarkerStart($dirty, 1425737070, "C329@14804L5,330@14847L342,330@14818L371:SegmentedButton.kt#uh7d8r");
                SegmentedButtonKt.SegmentedButtonContent.1.1 anon = new SegmentedButtonKt.SegmentedButtonContent.1.1(obj, obj2);
                modifier = materializeModifier;
                i12 = i29;
                i4 = i30;
                TextKt.ProvideTextStyle(TypographyKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getLabelTextFont(), $dirty, $dirty2), (Function2)ComposableLambdaKt.rememberComposableLambda(1420592651, true, anon, $dirty, 54), $dirty, 48);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                rememberComposableLambda.skipToGroupEnd();
                composer = rememberComposableLambda;
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            rememberComposableLambda = new SegmentedButtonKt.SegmentedButtonContent.2(obj, obj2, i16);
            endRestartGroup.updateScope((Function2)rememberComposableLambda);
        }
    }

    public static final void SingleChoiceSegmentedButtonRow-uFdPcIQ(Modifier modifier, float space, Function3<? super androidx.compose.material3.SingleChoiceSegmentedButtonRowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        Function0 factory$iv$iv$iv;
        int traceInProgress2;
        int $dirty;
        int $dirty2;
        Object modifier2;
        Object it$iv;
        Object obj;
        float space2;
        float f;
        Integer valueOf;
        Object empty;
        boolean traceInProgress;
        Composer composer2;
        Object valueOf2;
        int i7;
        int centerVertically;
        float f3;
        int i15;
        int i8;
        int i12;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i14;
        int i4;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i5;
        int i16;
        float f2;
        int i2;
        int i9;
        int i10;
        Modifier modifier3;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalArrangement$iv;
        Composer composer;
        int i3;
        int i;
        int i11;
        Object it$iv2;
        int i13;
        Object obj30;
        Modifier obj31;
        Function0 obj33;
        final Object obj2 = content;
        valueOf = $changed;
        traceInProgress2 = -1520863498;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(SingleChoiceSegmentedButtonRow)P(1,2:c#ui.unit.Dp)269@12565L447:SegmentedButton.kt#uh7d8r");
        $dirty = $changed;
        int i23 = i6 & 1;
        if (i23 != 0) {
            $dirty |= 6;
            empty = modifier;
        } else {
            if (valueOf & 6 == 0) {
                i7 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i7;
            } else {
                empty = modifier;
            }
        }
        centerVertically = i6 & 2;
        if (centerVertically != 0) {
            $dirty |= 48;
            f3 = space;
        } else {
            if (valueOf & 48 == 0) {
                i15 = restartGroup.changed(space) ? 32 : 16;
                $dirty |= i15;
            } else {
                f3 = space;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (valueOf & 384 == 0) {
                i8 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty |= i8;
            }
        }
        int i38 = $dirty;
        if (i38 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (i23 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = empty;
                }
                if (centerVertically != 0) {
                    space2 = SegmentedButtonDefaults.INSTANCE.getBorderWidth-D9Ej5fM();
                } else {
                    space2 = f3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i38, -1, "androidx.compose.material3.SingleChoiceSegmentedButtonRow (SegmentedButton.kt:268)");
                }
                Modifier width = IntrinsicKt.width(SizeKt.defaultMinSize-VpY3zN4$default(SelectableGroupKt.selectableGroup(modifier2), 0, OutlinedSegmentedButtonTokens.INSTANCE.getContainerHeight-D9Ej5fM(), 1, 0), IntrinsicSize.Min);
                int i34 = 0;
                valueOf2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(-space2));
                f3 = 384;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, width);
                obj31 = width;
                obj33 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj33);
                } else {
                    factory$iv$iv$iv = obj33;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i49 = 0;
                obj33 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy((Arrangement.Horizontal)valueOf2, Alignment.Companion.getCenterVertically(), restartGroup, i42 |= i45), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i50 = 0;
                Composer composer6 = constructor-impl;
                int i51 = 0;
                if (!composer6.getInserting()) {
                    horizontalArrangement$iv = valueOf2;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer6;
                    }
                } else {
                    horizontalArrangement$iv = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                i2 = i20;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i10 = 0;
                modifier3 = materializeModifier;
                i3 = i27;
                valueOf = composer5;
                ComposerKt.sourceInformationMarkerStart(valueOf, 1586778660, "C278@12924L58,279@12997L9:SegmentedButton.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(valueOf, -1334286565, "CC(remember):SegmentedButton.kt#9igjgp");
                Composer composer4 = valueOf;
                i9 = 0;
                i = i22;
                it$iv = composer4.rememberedValue();
                i11 = 0;
                i13 = i32;
                if (it$iv == Composer.Companion.getEmpty()) {
                    empty = 0;
                    it$iv2 = it$iv;
                    it$iv = new SingleChoiceSegmentedButtonScopeWrapper((RowScope)RowScopeInstance.INSTANCE);
                    composer4.updateRememberedValue(it$iv);
                } else {
                    it$iv2 = it$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                obj2.invoke((SingleChoiceSegmentedButtonScopeWrapper)it$iv, valueOf, Integer.valueOf(i25 |= 6));
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj30;
                f = f2;
            } else {
                restartGroup.skipToGroupEnd();
                obj = empty;
                f = f3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SegmentedButtonKt.SingleChoiceSegmentedButtonRow.2(obj, f, obj2, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$SegmentedButtonContent(Function2 icon, Function2 content, Composer $composer, int $changed) {
        SegmentedButtonKt.SegmentedButtonContent(icon, content, $composer, $changed);
    }

    public static final float access$getIconSpacing$p() {
        return SegmentedButtonKt.IconSpacing;
    }

    private static final State<Integer> interactionCountAsState(InteractionSource $this$interactionCountAsState, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed;
        String str;
        Object empty;
        Object mutableIntStateOf;
        Object anon;
        int i2;
        int i;
        int i3 = 281890131;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(interactionCountAsState)397@17381L33,398@17440L499,398@17419L520:SegmentedButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.interactionCountAsState (SegmentedButton.kt:396)");
        }
        String str3 = "CC(remember):SegmentedButton.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 408875648, str3);
        int i5 = 0;
        Composer composer2 = $composer;
        int i11 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        empty = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i13 = 0;
            composer2.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(0));
        } else {
            mutableIntStateOf = rememberedValue2;
        }
        androidx.compose.runtime.MutableIntState invalid$iv = mutableIntStateOf;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 408878002, str3);
        int i9 = 4;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed($this$interactionCountAsState)) {
                if ($changed & 6 == i9) {
                    i2 = 1;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SegmentedButtonKt.interactionCountAsState.1.1($this$interactionCountAsState, (MutableIntState)invalid$iv, 0);
                composer.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($this$interactionCountAsState, (Function2)anon, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }

    private static final Modifier interactionZIndex(Modifier $this$interactionZIndex, boolean checked, State<Integer> interactionCount) {
        SegmentedButtonKt.interactionZIndex.1 anon = new SegmentedButtonKt.interactionZIndex.1(interactionCount, checked);
        return LayoutModifierKt.layout($this$interactionZIndex, (Function3)anon);
    }
}
