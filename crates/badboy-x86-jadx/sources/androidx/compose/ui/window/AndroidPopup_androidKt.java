package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aU\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014\u001aD\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001a(\u0010\u0018\u001a\u00020\u00082\u0006\u0010\u0019\u001a\u00020\u00022\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u0012H\u0001¢\u0006\u0002\u0010\u001a\u001a+\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u001d2\u0013\u0008\u0008\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u0012H\u0083\u0008¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!H\u0002\u001a\u001c\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\n\u0008\u0002\u0010(\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u00102\u0006\u0010*\u001a\u00020!H\u0002\u001a\u000c\u0010+\u001a\u00020!*\u00020'H\u0000\u001a\u000c\u0010,\u001a\u00020-*\u00020.H\u0002\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006/²\u0006\u0015\u00100\u001a\r\u0012\u0004\u0012\u00020\u00080\u000e¢\u0006\u0002\u0008\u0012X\u008a\u0084\u0002", d2 = {"LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "PopupPropertiesBaseFlags", "", "Popup", "", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/IntOffset;", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Landroidx/compose/runtime/Composable;", "Popup-K5zGePQ", "(Landroidx/compose/ui/Alignment;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "(Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PopupTestTag", "tag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "createFlags", "focusable", "", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "clippingEnabled", "isPopupLayout", "view", "Landroid/view/View;", "testTag", "flagsWithSecureFlagInherited", "isParentFlagSecureEnabled", "isFlagSecureEnabled", "toIntBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/graphics/Rect;", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPopup_androidKt {

    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = null;
    private static final int PopupPropertiesBaseFlags = 262144;
    static {
        final int i2 = 0;
        AndroidPopup_androidKt.LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(i2, (Function0)AndroidPopup_androidKt.LocalPopupTestTag.1.INSTANCE, 1, i2);
    }

    public static final void Popup(androidx.compose.ui.window.PopupPositionProvider popupPositionProvider, Function0<Unit> onDismissRequest, androidx.compose.ui.window.PopupProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        Object view;
        Object empty2;
        Object obj4;
        int traceInProgress;
        Object onDismissRequest2;
        Object anon3;
        Object onGloballyPositioned;
        Object valueOf;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        Object properties2;
        Object invalid$iv2;
        Object invalid$iv3;
        Object anon4;
        boolean invalid$iv;
        boolean changedInstance;
        Object anon;
        Function0 factory$iv$iv;
        Object empty;
        Object obj8;
        int i4;
        int str;
        Object $composer2;
        Object obj6;
        Object obj2;
        Object valueOf2;
        Composer composer3;
        int i18;
        Object $this$cache$iv;
        Object restartGroup;
        Object obj10;
        int i5;
        int i10;
        int i13;
        int i6;
        int i;
        int currentCompositeKeyHash;
        int i11;
        int i21;
        int i17;
        Object anon2;
        int i2;
        int i20;
        Object obj3;
        Composer composer4;
        Composer composer;
        String layoutDirection;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        State state;
        androidx.compose.runtime.CompositionContext context;
        int companion2;
        int companion;
        int i14;
        Object popupLayout2;
        Object popupLayout;
        Object obj;
        Object it$iv;
        Object layoutDirection2;
        int i22;
        Object obj7;
        int i8;
        Object i12;
        int i9;
        int i16;
        int i15;
        int measurePolicy$iv;
        int i3;
        Object obj9;
        Composer composer2;
        int i19;
        Object obj5;
        Composer obj31;
        Object obj32;
        int obj34;
        onDismissRequest2 = popupPositionProvider;
        obj3 = content;
        int i90 = $changed;
        traceInProgress = -830247068;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Popup)P(2,1,3)303@13293L7,304@13332L7,305@13376L7,306@13431L7,307@13467L28,308@13522L29,309@13570L38,310@13631L944,338@14611L387,338@14581L417,353@15015L218,353@15004L229,362@15279L126,362@15239L166,374@15996L147,374@15968L175,387@16413L573,395@16993L99,384@16321L771:AndroidPopup.android.kt#2oxthz");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i90 & 6 == 0) {
                i4 = restartGroup.changed(onDismissRequest2) ? 4 : 2;
                $dirty2 |= i4;
            }
        }
        str = i7 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj2 = onDismissRequest;
        } else {
            if (i90 & 48 == 0) {
                i18 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i18;
            } else {
                obj2 = onDismissRequest;
            }
        }
        $this$cache$iv = i7 & 4;
        if ($this$cache$iv != 0) {
            $dirty2 |= 384;
            obj10 = properties;
        } else {
            if (i90 & 384 == 0) {
                i5 = restartGroup.changed(properties) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                obj10 = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (i90 & 3072 == 0) {
                i10 = restartGroup.changedInstance(obj3) ? 2048 : 1024;
                $dirty2 |= i10;
            }
        }
        currentCompositeKeyHash = $dirty2;
        if (currentCompositeKeyHash & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                it$iv = str != null ? $dirty : obj2;
                if ($this$cache$iv != 0) {
                    layoutDirection2 = new PopupProperties(0, 0, 0, 0, 15, 0);
                } else {
                    layoutDirection2 = obj10;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, currentCompositeKeyHash, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:302)");
                }
                int i28 = 6;
                int i49 = 0;
                int i55 = 2023513938;
                String str4 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                int i50 = 6;
                int i60 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                anon2 = consume3;
                int i51 = 6;
                int i61 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj7 = consume4;
                int i52 = 6;
                int i62 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i29 = 0;
                int i58 = i29;
                int i93 = i65;
                Object obj13 = obj14;
                Composer composer6 = restartGroup;
                String str3 = "CC(remember):AndroidPopup.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer6, -1370792809, str3);
                Composer composer7 = composer6;
                companion2 = i31;
                int i96 = 0;
                properties2 = composer7.rememberedValue();
                i12 = 0;
                i13 = 1;
                if (properties2 == Composer.Companion.getEmpty()) {
                    measurePolicy$iv = 0;
                    i3 = currentCompositeKeyHash;
                    Object obj12 = onDismissRequest2;
                    Object obj11 = it$iv;
                    Object it$iv2 = layoutDirection2;
                    layoutDirection = obj31;
                    obj31 = composer6;
                    PopupLayout view2 = new PopupLayout(obj11, it$iv2, (String)obj7, (View)this_$iv, (Density)anon2, obj12, (UUID)RememberSaveableKt.rememberSaveable(new Object[i58], 0, 0, (Function0)AndroidPopup_androidKt.Popup.popupId.1.INSTANCE, restartGroup, 3072, 6), 0, 128, 0);
                    it$iv = obj11;
                    onDismissRequest2 = obj12;
                    restartGroup = properties3;
                    layoutDirection2 = it$iv2;
                    properties2 = obj5;
                    i13 = view2;
                    currentCompositeKeyHash = 0;
                    anon2 = new AndroidPopup_androidKt.Popup.popupLayout.1.1.1(i13, SnapshotStateKt.rememberUpdatedState(obj3, restartGroup, i56 &= 14));
                    i13.setContent(ComposablesKt.rememberCompositionContext(restartGroup, i29), (Function2)ComposableLambdaKt.composableLambdaInstance(1302892335, i13, anon2));
                    composer7.updateRememberedValue(view2);
                } else {
                    obj31 = composer6;
                    composer4 = composer7;
                    i20 = i13;
                    i3 = currentCompositeKeyHash;
                    $this$cache$iv = anon2;
                    restartGroup = obj13;
                    $composer2 = obj7;
                    layoutDirection = str3;
                    valueOf2 = this_$iv;
                    view = properties2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj31);
                composer = obj31;
                ComposerKt.sourceInformationMarkerStart(composer, -1370762006, layoutDirection);
                i6 = i3 & 112 == 32 ? i20 : 0;
                i = i3;
                i11 = i & 896 == 256 ? i20 : 0;
                i35 |= changed4;
                Composer composer8 = composer;
                int i81 = 0;
                Object rememberedValue2 = composer8.rememberedValue();
                int i98 = 0;
                if (i36 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        companion2 = new AndroidPopup_androidKt.Popup.2.1(popupLayout2, it$iv, layoutDirection2, $composer2, restartGroup);
                        obj31 = popupLayout3;
                        empty2 = popupLayout2;
                        obj32 = i36;
                        composer8.updateRememberedValue((Function1)companion2);
                    } else {
                        obj32 = i36;
                        invalid$iv2 = rememberedValue2;
                        empty2 = popupLayout2;
                    }
                } else {
                    popupLayout2 = view;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.DisposableEffect(empty2, (Function1)invalid$iv2, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370749247, layoutDirection);
                i21 = i & 112 == 32 ? 1 : 0;
                i17 = i & 896 == 256 ? 1 : 0;
                i40 |= changed6;
                Composer composer9 = composer;
                int i84 = 0;
                Object rememberedValue3 = composer9.rememberedValue();
                int i97 = 0;
                if (i41 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        companion2 = new AndroidPopup_androidKt.Popup.3.1(popupLayout, it$iv, layoutDirection2, $composer2, restartGroup);
                        obj31 = popupLayout4;
                        obj4 = popupLayout;
                        obj32 = i41;
                        composer9.updateRememberedValue((Function0)companion2);
                    } else {
                        obj32 = i41;
                        invalid$iv3 = rememberedValue3;
                        obj4 = popupLayout;
                    }
                } else {
                    popupLayout = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.SideEffect((Function0)invalid$iv3, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370740891, layoutDirection);
                i19 = i & 14 == 4 ? 1 : 0;
                changedInstance4 |= i19;
                Composer composer10 = composer;
                int i86 = 0;
                Object rememberedValue4 = composer10.rememberedValue();
                int i94 = 0;
                if (empty == 0) {
                    obj31 = empty;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        obj32 = invalid$iv5;
                        anon4 = new AndroidPopup_androidKt.Popup.4.1(obj4, onDismissRequest2);
                        composer10.updateRememberedValue((Function1)anon4);
                    } else {
                        anon4 = rememberedValue4;
                    }
                } else {
                    obj31 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.DisposableEffect(onDismissRequest2, (Function1)anon4, composer, i & 14);
                ComposerKt.sourceInformationMarkerStart(composer, -1370717926, layoutDirection);
                invalid$iv = composer.changedInstance(obj4);
                Composer composer11 = composer;
                int i87 = 0;
                Object rememberedValue5 = composer11.rememberedValue();
                int i95 = 0;
                if (!invalid$iv) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        obj31 = i26;
                        obj32 = invalid$iv;
                        anon3 = new AndroidPopup_androidKt.Popup.5.1(obj4, 0);
                        composer11.updateRememberedValue((Function2)anon3);
                    } else {
                        obj32 = invalid$iv;
                        anon3 = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect(obj4, (Function2)anon3, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370704156, layoutDirection);
                changedInstance = composer.changedInstance(obj4);
                Composer composer12 = composer;
                int i88 = 0;
                Object rememberedValue6 = composer12.rememberedValue();
                companion = 0;
                if (changedInstance == null) {
                    obj31 = changedInstance;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        obj32 = invalid$iv4;
                        anon = new AndroidPopup_androidKt.Popup.7.1(obj4);
                        composer12.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue6;
                    }
                } else {
                    obj31 = changedInstance;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned((Modifier)Modifier.Companion, (Function1)anon);
                ComposerKt.sourceInformationMarkerStart(composer, -1370686070, layoutDirection);
                Composer composer13 = composer;
                int i89 = 0;
                Object rememberedValue7 = composer13.rememberedValue();
                int i91 = 0;
                if (changedInstance5 |= changed7 == 0) {
                    obj31 = onGloballyPositioned;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        obj32 = i24;
                        valueOf = new AndroidPopup_androidKt.Popup.8.1(obj4, restartGroup);
                        composer13.updateRememberedValue((MeasurePolicy)valueOf);
                    } else {
                        valueOf = rememberedValue7;
                    }
                } else {
                    obj31 = onGloballyPositioned;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                obj3 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                obj = obj4;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, obj31);
                obj32 = constructor;
                i14 = 0;
                i22 = $composer2;
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(obj32);
                } else {
                    factory$iv$iv = obj32;
                    composer.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(composer);
                i8 = 0;
                i16 = factory$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)valueOf, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, composer.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i9 = 0;
                obj32 = constructor-impl;
                i15 = 0;
                if (!obj32.getInserting()) {
                    measurePolicy$iv = valueOf;
                    obj9 = valueOf2;
                    if (!Intrinsics.areEqual(obj32.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj32.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = obj32;
                    }
                } else {
                    measurePolicy$iv = valueOf;
                    obj9 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i25 &= 14;
                Composer composer5 = composer;
                int i53 = 0;
                obj32 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer5, 2112480445, "C:AndroidPopup.android.kt#2oxthz");
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj8 = it$iv;
                obj6 = layoutDirection2;
            } else {
                restartGroup.skipToGroupEnd();
                obj8 = obj2;
                composer = restartGroup;
                obj6 = obj10;
                i = currentCompositeKeyHash;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AndroidPopup_androidKt.Popup.9(popupPositionProvider, obj8, obj6, content, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    public static final void Popup-K5zGePQ(Alignment alignment, long offset, Function0<Unit> onDismissRequest, androidx.compose.ui.window.PopupProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        int i4;
        int invalid$iv;
        androidx.compose.ui.window.AlignmentOffsetPositionProvider anon;
        int $dirty;
        Object $dirty2;
        Object alignment2;
        long alignment3;
        int traceInProgress2;
        int i3;
        Object obj2;
        long offset4;
        Object offset3;
        int i15;
        Object obj4;
        int i12;
        boolean traceInProgress;
        long offset2;
        Object obj;
        int i2;
        int i10;
        Object i;
        Object obj6;
        int i9;
        int empty;
        Object obj3;
        Object alignmentOffsetPositionProvider;
        int i5;
        Object obj5;
        int i13;
        androidx.compose.ui.window.PopupProperties popupProperties;
        int i6;
        int i16;
        int i14;
        int i7;
        int i11;
        int i17;
        long l2;
        long l;
        int obj26;
        final int i31 = i8;
        anon = 295309329;
        final Composer restartGroup = $changed.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)269@12290L128,276@12424L165:AndroidPopup.android.kt#2oxthz");
        $dirty = i8;
        int i20 = obj34 & 1;
        if (i20 != 0) {
            $dirty |= 6;
            obj2 = alignment;
        } else {
            if (i31 & 6 == 0) {
                i15 = restartGroup.changed(alignment) ? 4 : 2;
                $dirty |= i15;
            } else {
                obj2 = alignment;
            }
        }
        int i25 = obj34 & 2;
        if (i25 != 0) {
            $dirty |= 48;
            offset2 = offset;
        } else {
            if (i31 & 48 == 0) {
                i10 = restartGroup.changed(offset) ? 32 : 16;
                $dirty |= i10;
            } else {
                offset2 = offset;
            }
        }
        i = obj34 & 4;
        if (i != 0) {
            $dirty |= 384;
            obj6 = properties;
        } else {
            if (i31 & 384 == 0) {
                i9 = restartGroup.changedInstance(properties) ? 256 : 128;
                $dirty |= i9;
            } else {
                obj6 = properties;
            }
        }
        empty = obj34 & 8;
        if (empty != 0) {
            $dirty |= 3072;
            obj3 = content;
        } else {
            if (i31 & 3072 == 0) {
                i5 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                obj3 = content;
            }
        }
        if (obj34 & 16 != 0) {
            $dirty |= 24576;
            obj5 = $composer;
        } else {
            if (i31 & 24576 == 0) {
                i13 = restartGroup.changedInstance($composer) ? 16384 : 8192;
                $dirty |= i13;
            } else {
                obj5 = $composer;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i20 != 0) {
                    alignment2 = Alignment.Companion.getTopStart();
                } else {
                    alignment2 = obj2;
                }
                i3 = 0;
                if (i25 != 0) {
                    offset4 = IntOffsetKt.IntOffset(i3, i3);
                } else {
                    offset4 = offset2;
                }
                obj = i != 0 ? i12 : obj6;
                if (empty != 0) {
                    popupProperties = new PopupProperties(0, 0, 0, 0, 15, 0);
                    i = popupProperties;
                } else {
                    i = obj3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1370836537, "CC(remember):AndroidPopup.android.kt#9igjgp");
                int i26 = 1;
                i4 = $dirty & 14 == 4 ? i26 : i3;
                if ($dirty & 112 == 32) {
                    i3 = i26;
                }
                i4 |= i3;
                Composer composer = restartGroup;
                int i27 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i37 = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj26 = invalid$iv;
                        alignmentOffsetPositionProvider = new AlignmentOffsetPositionProvider(alignment2, offset4, i25, 0);
                        composer.updateRememberedValue(alignmentOffsetPositionProvider);
                    } else {
                        obj26 = invalid$iv;
                        alignmentOffsetPositionProvider = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidPopup_androidKt.Popup((PopupPositionProvider)(AlignmentOffsetPositionProvider)alignmentOffsetPositionProvider, obj, i, obj5, restartGroup, i23 | i12, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                offset3 = obj;
                offset2 = l2;
                obj4 = i;
            } else {
                restartGroup.skipToGroupEnd();
                alignment2 = obj2;
                offset3 = obj6;
                obj4 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            i2 = $dirty;
            anon = new AndroidPopup_androidKt.Popup.1(alignment2, offset2, traceInProgress2, offset3, obj4, $composer, i31, obj34);
            endRestartGroup.updateScope((Function2)anon);
        } else {
            i2 = $dirty;
            $dirty2 = alignment2;
            alignment3 = l;
        }
    }

    public static final void PopupTestTag(String tag, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        int i2;
        int i;
        int skipping;
        boolean traceInProgress2;
        int str;
        traceInProgress = -498879600;
        final Composer obj6 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj6, "C(PopupTestTag)P(1)429@18089L75:AndroidPopup.android.kt#2oxthz");
        if ($changed & 6 == 0) {
            i2 = obj6.changed(tag) ? 4 : 2;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i = obj6.changedInstance(content) ? 32 : 16;
            $dirty |= i;
        }
        if ($dirty & 19 == 18) {
            if (!obj6.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:428)");
                }
                CompositionLocalKt.CompositionLocalProvider(AndroidPopup_androidKt.LocalPopupTestTag.provides(tag), content, obj6, $stable |= str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj6.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj6.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new AndroidPopup_androidKt.PopupTestTag.1(tag, content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Integer valueOf;
        Composer composer;
        Object iNSTANCE;
        int $i$f$SimpleStack;
        androidx.compose.ui.window.AndroidPopup_androidKt.SimpleStack.1 stack;
        final Composer composer2 = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, 1406149896, "CC(SimpleStack)P(1)437@18427L979:AndroidPopup.android.kt#2oxthz");
        iNSTANCE = AndroidPopup_androidKt.SimpleStack.1.INSTANCE;
        int i10 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        final int i16 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            composer2.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(composer2);
        int i18 = 0;
        Updater.set-impl(constructor-impl, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        final int i19 = 0;
        final Composer composer3 = constructor-impl;
        final int i20 = 0;
        if (!composer3.getInserting()) {
            $i$f$SimpleStack = valueOf;
            stack = iNSTANCE;
            if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = composer3;
            }
        } else {
            $i$f$SimpleStack = valueOf;
            stack = iNSTANCE;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier), ComposeUiNode.Companion.getSetModifier());
        content.invoke(composer2, Integer.valueOf(i &= 14));
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
    }

    public static final Function2 access$Popup$lambda$1(State $currentContent$delegate) {
        return AndroidPopup_androidKt.Popup$lambda$1($currentContent$delegate);
    }

    public static final int access$createFlags(boolean focusable, androidx.compose.ui.window.SecureFlagPolicy securePolicy, boolean clippingEnabled) {
        return AndroidPopup_androidKt.createFlags(focusable, securePolicy, clippingEnabled);
    }

    public static final int access$flagsWithSecureFlagInherited(androidx.compose.ui.window.PopupProperties $receiver, boolean isParentFlagSecureEnabled) {
        return AndroidPopup_androidKt.flagsWithSecureFlagInherited($receiver, isParentFlagSecureEnabled);
    }

    public static final IntRect access$toIntBounds(Rect $receiver) {
        return AndroidPopup_androidKt.toIntBounds($receiver);
    }

    private static final int createFlags(boolean focusable, androidx.compose.ui.window.SecureFlagPolicy securePolicy, boolean clippingEnabled) {
        int flags;
        if (!focusable) {
            flags |= 8;
        }
        if (securePolicy == SecureFlagPolicy.SecureOn) {
            flags |= 8192;
        }
        if (!clippingEnabled) {
            flags |= 512;
        }
        return flags;
    }

    private static final int flagsWithSecureFlagInherited(androidx.compose.ui.window.PopupProperties $this$flagsWithSecureFlagInherited, boolean isParentFlagSecureEnabled) {
        int flags$ui_release;
        if ($this$flagsWithSecureFlagInherited.getInheritSecurePolicy$ui_release() && isParentFlagSecureEnabled) {
            if (isParentFlagSecureEnabled) {
                flags$ui_release3 |= 8192;
            } else {
                if ($this$flagsWithSecureFlagInherited.getInheritSecurePolicy$ui_release() && !isParentFlagSecureEnabled) {
                    if (!isParentFlagSecureEnabled) {
                        flags$ui_release2 &= -8193;
                    } else {
                        flags$ui_release = $this$flagsWithSecureFlagInherited.getFlags$ui_release();
                    }
                } else {
                }
            }
        } else {
        }
        return flags$ui_release;
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return AndroidPopup_androidKt.LocalPopupTestTag;
    }

    public static final boolean isFlagSecureEnabled(View $this$isFlagSecureEnabled) {
        int layoutParams;
        int i;
        if (layoutParams instanceof WindowManager.LayoutParams) {
        } else {
            layoutParams = 0;
        }
        if (layoutParams != 0 && flags &= 8192 != 0) {
            if (flags &= 8192 != 0) {
                i = 1;
            }
            return i;
        }
        return 0;
    }

    public static final boolean isPopupLayout(View view, String testTag) {
        boolean equal;
        int i;
        if (view instanceof PopupLayout) {
            if (testTag != null) {
                i = Intrinsics.areEqual(testTag, (PopupLayout)view.getTestTag()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static boolean isPopupLayout$default(View view, String string2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 0;
        }
        return AndroidPopup_androidKt.isPopupLayout(view, obj1);
    }

    private static final IntRect toIntBounds(Rect $this$toIntBounds) {
        IntRect intRect = new IntRect($this$toIntBounds.left, $this$toIntBounds.top, $this$toIntBounds.right, $this$toIntBounds.bottom);
        return intRect;
    }
}
