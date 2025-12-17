package androidx.compose.foundation.contextmenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a=\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u00012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\u0008\u0012¢\u0006\u0002\u0008\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001ai\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000c\u001a\u00020\u00012\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2*\u0008\u0002\u0010\u001a\u001a$\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008\u001c\u0012\u0008\u0008\u001d\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\u0002\u0008\u00122\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000b0 H\u0001¢\u0006\u0002\u0010!\u001aN\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u000b0 2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000c\u001a\u00020\u00012\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\u0008\u0013H\u0001¢\u0006\u0002\u0010(\u001aF\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u000b0 2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0002\u0008\u0013H\u0001¢\u0006\u0002\u0010)\u001a!\u0010*\u001a\u00020\u00012\u0008\u0008\u0003\u0010+\u001a\u00020,2\u0008\u0008\u0003\u0010-\u001a\u00020,H\u0001¢\u0006\u0002\u0010.\u001a \u0010/\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001a \u00104\u001a\u00020\u001b*\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\u00085\u00103\u001a2\u00106\u001a\u00020\u001b*\u0002072\u0008\u0008\u0001\u00108\u001a\u00020,2\u0008\u0008\u0001\u00109\u001a\u00020,2\u0006\u00101\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\u0008:\u0010;\u001a\"\u0010<\u001a\u0004\u0018\u000100*\u0002072\u0008\u0008\u0001\u00108\u001a\u00020,2\u0008\u0008\u0001\u00109\u001a\u00020,H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006=", d2 = {"DefaultContextMenuColors", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "getDefaultContextMenuColors$annotations", "()V", "getDefaultContextMenuColors", "()Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "DefaultPopupProperties", "Landroidx/compose/ui/window/PopupProperties;", "DisabledAlpha", "", "ContextMenuColumn", "", "colors", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ContextMenuItem", "label", "", "enabled", "", "leadingIcon", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "iconColor", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;ZLandroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ContextMenuPopup", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "onDismiss", "contextMenuBuilderBlock", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/contextmenu/ContextMenuColors;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "computeContextMenuColors", "backgroundStyleId", "", "foregroundStyleId", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "disabledColor", "Landroid/content/res/ColorStateList;", "defaultColor", "disabledColor-4WTKRHQ", "(Landroid/content/res/ColorStateList;J)J", "enabledColor", "enabledColor-4WTKRHQ", "resolveColor", "Landroid/content/Context;", "resId", "attrId", "resolveColor-g2O1Hgs", "(Landroid/content/Context;IIJ)J", "resolveColorStateList", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContextMenuUi_androidKt {

    private static final androidx.compose.foundation.contextmenu.ContextMenuColors DefaultContextMenuColors = null;
    private static final PopupProperties DefaultPopupProperties = null;
    private static final float DisabledAlpha = 0.38f;
    static {
        final int i5 = 14;
        final int i3 = 0;
        PopupProperties popupProperties = new PopupProperties(1, 0, i3, 0, i5, 0);
        ContextMenuUi_androidKt.DefaultPopupProperties = popupProperties;
        final int i8 = 0;
        final int i12 = 0;
        ContextMenuColors contextMenuColors = new ContextMenuColors(Color.Companion.getWhite-0d7_KjU(), i3, Color.Companion.getBlack-0d7_KjU(), i5, Color.Companion.getBlack-0d7_KjU(), obj7, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), obj9, 1052938076, i8, 0, i12, 14), obj9, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), i8, 1052938076, i12, 0, 0, 14), i8, 0);
        ContextMenuUi_androidKt.DefaultContextMenuColors = contextMenuColors;
    }

    public static final void ContextMenuColumn(androidx.compose.foundation.contextmenu.ContextMenuColors colors, Modifier modifier, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        int $dirty;
        boolean $dirty2;
        boolean traceInProgress2;
        Function0 factory$iv$iv$iv;
        Object obj3;
        Object obj;
        int valueOf3;
        int i2;
        int valueOf2;
        Composer composer;
        Integer valueOf;
        Object obj2;
        int i7;
        int i11;
        int i4;
        androidx.compose.foundation.layout.Arrangement.Vertical top;
        androidx.compose.ui.Alignment.Horizontal start;
        androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy;
        int i9;
        long l2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i;
        Modifier modifier2;
        int i8;
        int i10;
        Function0 function0;
        long l;
        int i3;
        int $changed$iv;
        int i5;
        int obj26;
        Modifier obj28;
        final Object obj4 = content;
        valueOf3 = $changed;
        traceInProgress = -921259293;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuColumn)P(!1,2)154@5499L21,145@5128L427:ContextMenuUi.android.kt#3xeu6s");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
            obj3 = colors;
        } else {
            if (valueOf3 & 6 == 0) {
                i2 = restartGroup.changed(colors) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj3 = colors;
            }
        }
        valueOf2 = i6 & 2;
        if (valueOf2 != 0) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (valueOf3 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                obj2 = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (valueOf3 & 384 == 0) {
                i11 = restartGroup.changedInstance(obj4) ? 256 : 128;
                $dirty |= i11;
            }
        }
        int i27 = $dirty;
        if (i27 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (valueOf2 != 0) {
                    i4 = $dirty2;
                } else {
                    i4 = obj2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i27, -1, "androidx.compose.foundation.contextmenu.ContextMenuColumn (ContextMenuUi.android.kt:144)");
                }
                int i28 = 1;
                int i12 = 0;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.padding-VpY3zN4$default(IntrinsicKt.width(BackgroundKt.background-bw27NRU$default(ShadowKt.shadow-s4CzXII$default(i4, ContextMenuSpec.INSTANCE.getMenuContainerElevation-D9Ej5fM(), (Shape)RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ContextMenuSpec.INSTANCE.getCornerRadius-D9Ej5fM()), false, 0, obj14, 0, obj16), obj3.getBackgroundColor-0d7_KjU(), obj21, 0, 2), IntrinsicSize.Max), 0, ContextMenuSpec.INSTANCE.getVerticalPadding-D9Ej5fM(), i28, 0), ScrollKt.rememberScrollState(i12, restartGroup, i12, i28), false, 0, false, 14, 0);
                i20 &= 7168;
                obj2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                l2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj26 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, verticalScroll$default);
                obj28 = verticalScroll$default;
                Function0 function02 = constructor;
                i = 0;
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
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i46 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), restartGroup, i32 |= i37), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i10 = 0;
                l = constructor-impl;
                i3 = 0;
                if (!l.getInserting()) {
                    $changed$iv = valueOf;
                    if (!Intrinsics.areEqual(l.rememberedValue(), Integer.valueOf(obj26))) {
                        l.updateRememberedValue(Integer.valueOf(obj26));
                        constructor-impl.apply(Integer.valueOf(obj26), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = l;
                    }
                } else {
                    $changed$iv = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i16 &= 14;
                Composer composer2 = restartGroup;
                valueOf3 = 0;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                obj4.invoke(ColumnScopeInstance.INSTANCE, composer2, Integer.valueOf(i23 |= 6));
                ComposerKt.sourceInformationMarkerEnd(composer2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i4;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ContextMenuUi_androidKt.ContextMenuColumn.1(colors, obj, obj4, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ContextMenuItem(String label, boolean enabled, androidx.compose.foundation.contextmenu.ContextMenuColors colors, Modifier modifier, Function3<? super Color, ? super Composer, ? super Integer, Unit> leadingIcon, Function0<Unit> onClick, Composer $composer, int $changed, int i9) {
        int i25;
        int i34;
        boolean traceInProgress2;
        Object materialized$iv$iv;
        long disabledTextColor-0d7_KjU;
        boolean currentCompositionLocalMap;
        long disabledIconColor-0d7_KjU;
        Modifier weight;
        int $dirty;
        int skipping;
        Object modifier2;
        Object valueOf2;
        Function0 factory$iv$iv$iv2;
        int i27;
        int i26;
        int i23;
        int i4;
        boolean traceInProgress;
        int empty;
        boolean valueOf;
        int i7;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy;
        int i14;
        Composer composer6;
        Object rowMeasurePolicy;
        Object obj5;
        Object str;
        Object anon;
        int materializeModifier;
        Object obj;
        int i16;
        int i6;
        Object obj2;
        int i35;
        Object i;
        Object factory$iv$iv$iv;
        Object obj4;
        Object $composer2;
        int i38;
        int i28;
        int localMap$iv$iv;
        String currentCompositeKeyHash2;
        int i8;
        Function0 constructor;
        int i11;
        int i21;
        int i19;
        Composer.Companion companion;
        int i37;
        Composer composer3;
        int i20;
        int i22;
        Composer composer2;
        boolean inserting;
        int i2;
        int i32;
        int currentCompositeKeyHash;
        int i13;
        int i24;
        Object obj3;
        int i31;
        int $i$f$Row;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i15;
        int i39;
        int i12;
        Modifier modifier4;
        Composer composer;
        int i29;
        int i18;
        int i33;
        Alignment alignment;
        int i17;
        Modifier modifier3;
        int i30;
        int i5;
        int i36;
        int i10;
        Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i3;
        int obj56;
        weight = enabled;
        obj2 = onClick;
        i35 = $changed;
        traceInProgress2 = 791018367;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuItem)P(2,1!1,4)189@6696L221,182@6391L1588:ContextMenuUi.android.kt#3xeu6s");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            factory$iv$iv$iv = label;
        } else {
            if (i35 & 6 == 0) {
                i27 = restartGroup.changed(label) ? 4 : 2;
                $dirty |= i27;
            } else {
                factory$iv$iv$iv = label;
            }
        }
        int i63 = 32;
        if (i9 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i35 & 48 == 0) {
                i26 = restartGroup.changed(weight) ? i63 : 16;
                $dirty |= i26;
            }
        }
        if (i9 & 4 != 0) {
            $dirty |= 384;
            obj4 = colors;
        } else {
            if (i35 & 384 == 0) {
                i23 = restartGroup.changed(colors) ? 256 : 128;
                $dirty |= i23;
            } else {
                obj4 = colors;
            }
        }
        i4 = i9 & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            str = modifier;
        } else {
            if (i35 & 3072 == 0) {
                i16 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i16;
            } else {
                str = modifier;
            }
        }
        i6 = i9 & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            $composer2 = leadingIcon;
        } else {
            if (i35 & 24576 == 0) {
                i38 = restartGroup.changedInstance(leadingIcon) ? 16384 : 8192;
                $dirty |= i38;
            } else {
                $composer2 = leadingIcon;
            }
        }
        i8 = 131072;
        i11 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i11;
        } else {
            if (i35 & i11 == 0) {
                i28 = restartGroup.changedInstance(obj2) ? i8 : 65536;
                $dirty |= i28;
            }
        }
        localMap$iv$iv = $dirty;
        if ($dirty2 &= localMap$iv$iv == 74898) {
            if (!restartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                i = i6 != 0 ? i4 : $composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, localMap$iv$iv, -1, "androidx.compose.foundation.contextmenu.ContextMenuItem (ContextMenuUi.android.kt:181)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1814201532, "CC(remember):ContextMenuUi.android.kt#9igjgp");
                i25 = localMap$iv$iv & 112 == i63 ? 1 : 0;
                i14 = i64 &= localMap$iv$iv == i8 ? 1 : 0;
                Composer composer8 = restartGroup;
                int i75 = 0;
                Object rememberedValue3 = composer8.rememberedValue();
                int i94 = 0;
                if (i25 |= i14 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new ContextMenuUi_androidKt.ContextMenuItem.1.1(weight, obj2);
                        composer8.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object obj6 = modifier2;
                int i46 = 0;
                int i53 = 0;
                int i54 = 432;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(ContextMenuSpec.INSTANCE.getHorizontalPadding-D9Ej5fM()), ContextMenuSpec.INSTANCE.getLabelVerticalTextAlignment(), restartGroup, i72 |= i78);
                i74 &= 112;
                i6 = 0;
                currentCompositeKeyHash2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositeKeyHash2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                obj56 = localMap$iv$iv;
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, PaddingKt.padding-VpY3zN4$default(SizeKt.sizeIn-qDBjuR0(SizeKt.fillMaxWidth$default(ClickableKt.clickable-XHw0xAI$default(obj6, weight, factory$iv$iv$iv, 0, (Function0)anon, 4, 0), i46, 1, i53), ContextMenuSpec.INSTANCE.getContainerWidthMin-D9Ej5fM(), ContextMenuSpec.INSTANCE.getListItemHeight-D9Ej5fM(), ContextMenuSpec.INSTANCE.getContainerWidthMax-D9Ej5fM(), ContextMenuSpec.INSTANCE.getListItemHeight-D9Ej5fM()), ContextMenuSpec.INSTANCE.getHorizontalPadding-D9Ej5fM(), i46, 2, i53));
                Function0 function03 = constructor;
                i24 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i89 = 0;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i37 = 0;
                composer3 = constructor-impl;
                i22 = 0;
                if (!composer3.getInserting()) {
                    $i$f$Row = valueOf;
                    measurePolicy = rowMeasurePolicy;
                    if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer3;
                    }
                } else {
                    $i$f$Row = valueOf;
                    measurePolicy = rowMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                valueOf2 = restartGroup;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i15 = i91 | 6;
                Composer composer9 = valueOf2;
                i39 = 0;
                i12 = i44;
                modifier4 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer9, 554565222, "C212@7698L275:ContextMenuUi.android.kt#3xeu6s");
                if (i == null) {
                    composer9.startReplaceGroup(554568909);
                    composer9.endReplaceGroup();
                    composer = valueOf2;
                    i29 = i7;
                    i17 = materializeModifier;
                    i36 = i6;
                } else {
                    composer9.startReplaceGroup(554568910);
                    ComposerKt.sourceInformation(composer9, "*204@7349L330");
                    i37 = i21;
                    i22 = 0;
                    inserting = i47;
                    composer = valueOf2;
                    ComposerKt.sourceInformationMarkerStart(composer9, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    int i57 = 0;
                    i29 = i7;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i57);
                    i18 = 0;
                    alignment = topStart;
                    ComposerKt.sourceInformationMarkerStart(composer9, -1323940314, currentCompositeKeyHash2);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer9, 0);
                    currentCompositionLocalMap = composer9.getCurrentCompositionLocalMap();
                    constructor = i57;
                    i17 = materializeModifier;
                    Modifier propagateMinConstraints$iv = modifier7;
                    modifier3 = propagateMinConstraints$iv;
                    Function0 function04 = constructor2;
                    composer3 = 0;
                    i36 = i6;
                    ComposerKt.sourceInformationMarkerStart(composer9, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    composer9.startReusableNode();
                    if (composer9.getInserting()) {
                        composer9.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        composer9.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl(composer9);
                    int i99 = 0;
                    function0 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i100 = 0;
                    Composer composer10 = constructor-impl2;
                    int i101 = 0;
                    if (!composer10.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy2 = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer10;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy2 = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(composer9, propagateMinConstraints$iv), ComposeUiNode.Companion.getSetModifier());
                    Composer composer7 = composer9;
                    i30 = i51;
                    ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i81 |= 6;
                    i10 = 0;
                    boxScopeInstance = iNSTANCE4;
                    String $composer$iv2 = "C210@7612L65:ContextMenuUi.android.kt#3xeu6s";
                    i3 = i62;
                    i7 = i21;
                    ComposerKt.sourceInformationMarkerStart(i7, -1218311042, $composer$iv2);
                    if (enabled) {
                        disabledIconColor-0d7_KjU = obj4.getIconColor-0d7_KjU();
                    } else {
                        disabledIconColor-0d7_KjU = obj4.getDisabledIconColor-0d7_KjU();
                    }
                    i.invoke(Color.box-impl(disabledIconColor-0d7_KjU), i7, 0);
                    ComposerKt.sourceInformationMarkerEnd(i7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer9.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    composer9.endReplaceGroup();
                }
                if (enabled) {
                    disabledTextColor-0d7_KjU = obj4.getTextColor-0d7_KjU();
                } else {
                    disabledTextColor-0d7_KjU = obj4.getDisabledTextColor-0d7_KjU();
                }
                skipping = currentCompositionLocalMap2;
                i33 = obj56;
                composer2 = composer9;
                Function0 function02 = function03;
                BasicTextKt.BasicText-VhcvRP8(label, (RowScope)RowScopeInstance.INSTANCE.weight((Modifier)Modifier.Companion, 1065353216, true), ContextMenuSpec.INSTANCE.textStyle-8_81llA(disabledTextColor-0d7_KjU), 0, 0, false, 1, 0, 0, composer2, i56 | i4, 440);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = i;
                obj5 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                obj5 = str;
                obj = $composer2;
                i33 = localMap$iv$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ContextMenuUi_androidKt.ContextMenuItem.3(label, enabled, colors, obj5, obj, obj2, i35, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ContextMenuPopup(PopupPositionProvider popupPositionProvider, Function0<Unit> onDismiss, Modifier modifier, androidx.compose.foundation.contextmenu.ContextMenuColors colors, Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, Unit> contextMenuBuilderBlock, Composer $composer, int $changed, int i8) {
        int traceInProgress2;
        int $dirty;
        boolean $dirty2;
        int i10;
        int i4;
        int i9;
        boolean traceInProgress;
        Object str;
        int i2;
        int i;
        int i5;
        int i3;
        Object obj;
        PopupProperties defaultPopupProperties;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i6;
        int i7;
        final Object obj3 = colors;
        final Object obj4 = contextMenuBuilderBlock;
        final int i16 = $changed;
        traceInProgress2 = 1447189339;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuPopup)P(4,3,2)126@4681L257,122@4530L408:ContextMenuUi.android.kt#3xeu6s");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i16 & 6 == 0) {
                i10 = restartGroup.changed(popupPositionProvider) ? 4 : 2;
                $dirty |= i10;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj = onDismiss;
        } else {
            if (i16 & 48 == 0) {
                i4 = restartGroup.changedInstance(onDismiss) ? 32 : 16;
                $dirty |= i4;
            } else {
                obj = onDismiss;
            }
        }
        i9 = i8 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            str = modifier;
        } else {
            if (i16 & 384 == 0) {
                i2 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i2;
            } else {
                str = modifier;
            }
        }
        if (i8 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i16 & 3072 == 0) {
                i = restartGroup.changed(obj3) ? 2048 : 1024;
                $dirty |= i;
            }
        }
        if (i8 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i16 & 24576 == 0) {
                i5 = restartGroup.changedInstance(obj4) ? 16384 : 8192;
                $dirty |= i5;
            }
        }
        final int i18 = $dirty;
        if (i18 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i9 != 0) {
                    $dirty2 = Modifier.Companion;
                } else {
                    $dirty2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i18, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:121)");
                }
                ContextMenuUi_androidKt.ContextMenuPopup.2 anon = new ContextMenuUi_androidKt.ContextMenuPopup.2(obj3, $dirty2, obj4);
                AndroidPopup_androidKt.Popup(popupPositionProvider, obj, ContextMenuUi_androidKt.DefaultPopupProperties, (Function2)ComposableLambdaKt.rememberComposableLambda(795909757, true, anon, restartGroup, 54), restartGroup, i12 | i9, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str = $dirty2;
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ContextMenuUi_androidKt.ContextMenuPopup.3(popupPositionProvider, onDismiss, str, obj3, obj4, i16, i8);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ContextMenuPopup(PopupPositionProvider popupPositionProvider, Function0<Unit> onDismiss, Modifier modifier, Function1<? super androidx.compose.foundation.contextmenu.ContextMenuScope, Unit> contextMenuBuilderBlock, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int $dirty;
        boolean $dirty2;
        boolean traceInProgress;
        int i8;
        Object obj3;
        int i5;
        Object obj6;
        int str;
        Object obj;
        int i3;
        int i4;
        int i6;
        Object obj4;
        Object obj2;
        androidx.compose.foundation.contextmenu.ContextMenuColors contextMenuColors;
        Object obj5;
        int i2;
        int i;
        final int i21 = $changed;
        traceInProgress2 = 712057293;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ContextMenuPopup)P(3,2,1)108@4164L26,104@4014L241:ContextMenuUi.android.kt#3xeu6s");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i21 & 6 == 0) {
                i8 = restartGroup.changed(popupPositionProvider) ? 4 : 2;
                $dirty |= i8;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
            obj3 = onDismiss;
        } else {
            if (i21 & 48 == 0) {
                i5 = restartGroup.changedInstance(onDismiss) ? 32 : 16;
                $dirty |= i5;
            } else {
                obj3 = onDismiss;
            }
        }
        str = i7 & 4;
        if (str != null) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i21 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj = modifier;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
            obj5 = contextMenuBuilderBlock;
        } else {
            if (i21 & 3072 == 0) {
                i4 = restartGroup.changedInstance(contextMenuBuilderBlock) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                obj5 = contextMenuBuilderBlock;
            }
        }
        final int i22 = $dirty;
        if (i22 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    obj2 = $dirty2;
                } else {
                    obj2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i22, -1, "androidx.compose.foundation.contextmenu.ContextMenuPopup (ContextMenuUi.android.kt:103)");
                }
                int i9 = 0;
                ContextMenuUi_androidKt.ContextMenuPopup(popupPositionProvider, obj3, obj2, ContextMenuUi_androidKt.computeContextMenuColors(i9, i9, restartGroup, i9, 3), obj5, restartGroup, i12 | $dirty2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                obj6 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ContextMenuUi_androidKt.ContextMenuPopup.1(popupPositionProvider, onDismiss, obj6, contextMenuBuilderBlock, i21, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.foundation.contextmenu.ContextMenuColors computeContextMenuColors(int backgroundStyleId, int foregroundStyleId, Composer $composer, int $changed, int i5) {
        int backgroundStyleId2;
        int foregroundStyleId2;
        int traceInProgress;
        String str;
        int i2;
        Object empty;
        ColorStateList resolveColorStateList;
        long disabledTextColor-0d7_KjU;
        int i3;
        Object contextMenuColors;
        long resolveColor-g2O1Hgs;
        long enabledColor-4WTKRHQ;
        long l;
        long disabledColor-4WTKRHQ;
        long l2;
        int i;
        final Composer composer = $composer;
        int i4 = 1689505294;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(computeContextMenuColors)355@13081L7,356@13137L7,356@13100L846:ContextMenuUi.android.kt#3xeu6s");
        backgroundStyleId2 = i5 & 1 != 0 ? 0x01030086 /* Unknown resource */ : backgroundStyleId;
        foregroundStyleId2 = i5 & 2 != 0 ? 0x01030080 /* Unknown resource */ : foregroundStyleId;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.contextmenu.computeContextMenuColors (ContextMenuUi.android.kt:354)");
        } else {
            i2 = $changed;
        }
        int i8 = 0;
        int i11 = 0;
        int i13 = 2023513938;
        String str4 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, i13, str4);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object this_$iv = consume2;
        int i12 = 0;
        int i15 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i13, str4);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -753201361, "CC(remember):ContextMenuUi.android.kt#9igjgp");
        Composer composer2 = $composer;
        int i14 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i16 = 0;
        if (changed |= changed2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                i3 = 16842801;
                resolveColorStateList = ContextMenuUi_androidKt.resolveColorStateList(this_$iv, foregroundStyleId2, 16842806);
                enabledColor-4WTKRHQ = ContextMenuUi_androidKt.enabledColor-4WTKRHQ(resolveColorStateList, ContextMenuUi_androidKt.DefaultContextMenuColors.getTextColor-0d7_KjU());
                disabledColor-4WTKRHQ = ContextMenuUi_androidKt.disabledColor-4WTKRHQ(resolveColorStateList, ContextMenuUi_androidKt.DefaultContextMenuColors.getDisabledTextColor-0d7_KjU());
                contextMenuColors = new ContextMenuColors(ContextMenuUi_androidKt.resolveColor-g2O1Hgs(this_$iv, backgroundStyleId2, i3, ContextMenuUi_androidKt.DefaultContextMenuColors.getBackgroundColor-0d7_KjU()), obj16, enabledColor-4WTKRHQ, obj18, enabledColor-4WTKRHQ, obj20, disabledColor-4WTKRHQ, obj22, disabledColor-4WTKRHQ, obj24, 0);
                composer2.updateRememberedValue(contextMenuColors);
            } else {
                contextMenuColors = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ContextMenuColors)contextMenuColors;
    }

    private static final long disabledColor-4WTKRHQ(ColorStateList $this$disabledColor_u2d4WTKRHQ, long defaultColor) {
        int valueOf;
        int intValue;
        long l;
        final int argb-8_81llA = ColorKt.toArgb-8_81llA(defaultColor);
        if ($this$disabledColor_u2d4WTKRHQ != null) {
            valueOf = Integer.valueOf($this$disabledColor_u2d4WTKRHQ.getColorForState(/* result */, argb-8_81llA));
        } else {
            valueOf = 0;
        }
        if (valueOf != 0) {
            if (valueOf.intValue() == argb-8_81llA) {
                l = defaultColor;
            } else {
                l = ColorKt.Color(valueOf.intValue());
            }
        } else {
        }
        return l;
    }

    private static final long enabledColor-4WTKRHQ(ColorStateList $this$enabledColor_u2d4WTKRHQ, long defaultColor) {
        int valueOf;
        int intValue;
        long l;
        final int argb-8_81llA = ColorKt.toArgb-8_81llA(defaultColor);
        if ($this$enabledColor_u2d4WTKRHQ != null) {
            valueOf = Integer.valueOf($this$enabledColor_u2d4WTKRHQ.getColorForState(/* result */, argb-8_81llA));
        } else {
            valueOf = 0;
        }
        if (valueOf != 0) {
            if (valueOf.intValue() == argb-8_81llA) {
                l = defaultColor;
            } else {
                l = ColorKt.Color(valueOf.intValue());
            }
        } else {
        }
        return l;
    }

    public static final androidx.compose.foundation.contextmenu.ContextMenuColors getDefaultContextMenuColors() {
        return ContextMenuUi_androidKt.DefaultContextMenuColors;
    }

    public static void getDefaultContextMenuColors$annotations() {
    }

    private static final long resolveColor-g2O1Hgs(Context $this$resolveColor_u2dg2O1Hgs, int resId, int attrId, long defaultColor) {
        long l;
        TypedArray styledAttributes = $this$resolveColor_u2dg2O1Hgs.obtainStyledAttributes(resId, /* result */);
        final int argb-8_81llA = ColorKt.toArgb-8_81llA(defaultColor);
        int color = styledAttributes.getColor(0, argb-8_81llA);
        styledAttributes.recycle();
        if (color == argb-8_81llA) {
            l = defaultColor;
        } else {
            l = ColorKt.Color(color);
        }
        return l;
    }

    private static final ColorStateList resolveColorStateList(Context $this$resolveColorStateList, int resId, int attrId) {
        TypedArray styledAttributes = $this$resolveColorStateList.obtainStyledAttributes(resId, /* result */);
        styledAttributes.recycle();
        return styledAttributes.getColorStateList(0);
    }
}
