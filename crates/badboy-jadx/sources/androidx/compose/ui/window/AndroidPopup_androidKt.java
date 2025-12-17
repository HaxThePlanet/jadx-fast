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
        Object $i$a$CacheAndroidPopup_androidKt$Popup$2;
        Object $i$a$CacheAndroidPopup_androidKt$Popup$3;
        int traceInProgress2;
        Object onDismissRequest2;
        Object $i$a$CacheAndroidPopup_androidKt$Popup$5;
        Object onGloballyPositioned;
        Object $i$a$CacheAndroidPopup_androidKt$Popup$8;
        int $dirty2;
        int $dirty;
        boolean traceInProgress;
        Object properties2;
        Object invalid$iv3;
        Object invalid$iv;
        Object $i$a$CacheAndroidPopup_androidKt$Popup$4;
        boolean invalid$iv2;
        boolean changedInstance;
        Object $i$a$CacheAndroidPopup_androidKt$Popup$7;
        Function0 factory$iv$iv;
        Object empty;
        Object obj6;
        int i22;
        int str;
        Object $composer2;
        Object obj4;
        Object obj3;
        Object valueOf;
        Composer composer3;
        int i19;
        Object $this$cache$iv;
        Object restartGroup;
        Object obj2;
        int i17;
        int i3;
        int i;
        int i13;
        int i8;
        int currentCompositeKeyHash;
        int i11;
        int i15;
        int i9;
        Object anon;
        int i16;
        int i21;
        Object obj7;
        Composer composer4;
        Composer composer;
        String layoutDirection;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        State state;
        androidx.compose.runtime.CompositionContext context;
        int companion2;
        int companion;
        int i2;
        Object popupLayout;
        Object popupLayout2;
        Object obj8;
        Object it$iv;
        Object layoutDirection2;
        int i20;
        Object obj;
        int i18;
        Object i10;
        int i4;
        int i12;
        int i5;
        int measurePolicy$iv;
        int i14;
        Object obj5;
        Composer composer2;
        int i6;
        Object obj9;
        Composer obj31;
        Object obj32;
        int obj34;
        onDismissRequest2 = popupPositionProvider;
        obj7 = content;
        int i90 = $changed;
        traceInProgress2 = -830247068;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(Popup)P(2,1,3)303@13293L7,304@13332L7,305@13376L7,306@13431L7,307@13467L28,308@13522L29,309@13570L38,310@13631L944,338@14611L387,338@14581L417,353@15015L218,353@15004L229,362@15279L126,362@15239L166,374@15996L147,374@15968L175,387@16413L573,395@16993L99,384@16321L771:AndroidPopup.android.kt#2oxthz");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i90 & 6 == 0) {
                i22 = restartGroup.changed(onDismissRequest2) ? 4 : 2;
                $dirty2 |= i22;
            }
        }
        str = i7 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj3 = onDismissRequest;
        } else {
            if (i90 & 48 == 0) {
                i19 = restartGroup.changedInstance(onDismissRequest) ? 32 : 16;
                $dirty2 |= i19;
            } else {
                obj3 = onDismissRequest;
            }
        }
        $this$cache$iv = i7 & 4;
        if ($this$cache$iv != 0) {
            $dirty2 |= 384;
            obj2 = properties;
        } else {
            if (i90 & 384 == 0) {
                i17 = restartGroup.changed(properties) ? 256 : 128;
                $dirty2 |= i17;
            } else {
                obj2 = properties;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (i90 & 3072 == 0) {
                i3 = restartGroup.changedInstance(obj7) ? 2048 : 1024;
                $dirty2 |= i3;
            }
        }
        currentCompositeKeyHash = $dirty2;
        if (currentCompositeKeyHash & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                it$iv = str != null ? $dirty : obj3;
                if ($this$cache$iv != 0) {
                    layoutDirection2 = new PopupProperties(0, 0, 0, 0, 15, 0);
                } else {
                    layoutDirection2 = obj2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, currentCompositeKeyHash, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:302)");
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
                anon = consume3;
                int i51 = 6;
                int i61 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj = consume4;
                int i52 = 6;
                int i62 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i55, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i29 = 0;
                int i58 = i29;
                int i93 = i65;
                Object obj12 = obj13;
                Composer composer6 = restartGroup;
                String str3 = "CC(remember):AndroidPopup.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer6, -1370792809, str3);
                Composer composer7 = composer6;
                companion2 = i31;
                int i96 = 0;
                properties2 = composer7.rememberedValue();
                i10 = 0;
                i = 1;
                if (properties2 == Composer.Companion.getEmpty()) {
                    measurePolicy$iv = 0;
                    i14 = currentCompositeKeyHash;
                    Object obj11 = onDismissRequest2;
                    Object obj10 = it$iv;
                    Object it$iv2 = layoutDirection2;
                    layoutDirection = obj31;
                    obj31 = composer6;
                    PopupLayout view2 = new PopupLayout(obj10, it$iv2, (String)obj, (View)this_$iv, (Density)anon, obj11, (UUID)RememberSaveableKt.rememberSaveable(new Object[i58], 0, 0, (Function0)AndroidPopup_androidKt.Popup.popupId.1.INSTANCE, restartGroup, 3072, 6), 0, 128, 0);
                    it$iv = obj10;
                    onDismissRequest2 = obj11;
                    restartGroup = properties3;
                    layoutDirection2 = it$iv2;
                    properties2 = obj9;
                    i = view2;
                    currentCompositeKeyHash = 0;
                    anon = new AndroidPopup_androidKt.Popup.popupLayout.1.1.1(i, SnapshotStateKt.rememberUpdatedState(obj7, restartGroup, i56 &= 14));
                    i.setContent(ComposablesKt.rememberCompositionContext(restartGroup, i29), (Function2)ComposableLambdaKt.composableLambdaInstance(1302892335, i, anon));
                    composer7.updateRememberedValue(view2);
                } else {
                    obj31 = composer6;
                    composer4 = composer7;
                    i21 = i;
                    i14 = currentCompositeKeyHash;
                    $this$cache$iv = anon;
                    restartGroup = obj12;
                    $composer2 = obj;
                    layoutDirection = str3;
                    valueOf = this_$iv;
                    view = properties2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj31);
                composer = obj31;
                ComposerKt.sourceInformationMarkerStart(composer, -1370762006, layoutDirection);
                i13 = i14 & 112 == 32 ? i21 : 0;
                i8 = i14;
                i11 = i8 & 896 == 256 ? i21 : 0;
                i35 |= changed4;
                Composer composer8 = composer;
                int i81 = 0;
                Object rememberedValue2 = composer8.rememberedValue();
                int i98 = 0;
                if (i36 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        companion2 = new AndroidPopup_androidKt.Popup.2.1(popupLayout, it$iv, layoutDirection2, $composer2, restartGroup);
                        obj31 = popupLayout3;
                        $i$a$CacheAndroidPopup_androidKt$Popup$2 = popupLayout;
                        obj32 = i36;
                        composer8.updateRememberedValue((Function1)companion2);
                    } else {
                        obj32 = i36;
                        invalid$iv3 = rememberedValue2;
                        $i$a$CacheAndroidPopup_androidKt$Popup$2 = popupLayout;
                    }
                } else {
                    popupLayout = view;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.DisposableEffect($i$a$CacheAndroidPopup_androidKt$Popup$2, (Function1)invalid$iv3, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370749247, layoutDirection);
                i15 = i8 & 112 == 32 ? 1 : 0;
                i9 = i8 & 896 == 256 ? 1 : 0;
                i40 |= changed6;
                Composer composer9 = composer;
                int i84 = 0;
                Object rememberedValue3 = composer9.rememberedValue();
                int i97 = 0;
                if (i41 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        companion2 = new AndroidPopup_androidKt.Popup.3.1(popupLayout2, it$iv, layoutDirection2, $composer2, restartGroup);
                        obj31 = popupLayout4;
                        $i$a$CacheAndroidPopup_androidKt$Popup$3 = popupLayout2;
                        obj32 = i41;
                        composer9.updateRememberedValue((Function0)companion2);
                    } else {
                        obj32 = i41;
                        invalid$iv = rememberedValue3;
                        $i$a$CacheAndroidPopup_androidKt$Popup$3 = popupLayout2;
                    }
                } else {
                    popupLayout2 = $i$a$CacheAndroidPopup_androidKt$Popup$2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.SideEffect((Function0)invalid$iv, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370740891, layoutDirection);
                i6 = i8 & 14 == 4 ? 1 : 0;
                changedInstance4 |= i6;
                Composer composer10 = composer;
                int i86 = 0;
                Object rememberedValue4 = composer10.rememberedValue();
                int i94 = 0;
                if (empty == 0) {
                    obj31 = empty;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        obj32 = invalid$iv5;
                        $i$a$CacheAndroidPopup_androidKt$Popup$4 = new AndroidPopup_androidKt.Popup.4.1($i$a$CacheAndroidPopup_androidKt$Popup$3, onDismissRequest2);
                        composer10.updateRememberedValue((Function1)$i$a$CacheAndroidPopup_androidKt$Popup$4);
                    } else {
                        $i$a$CacheAndroidPopup_androidKt$Popup$4 = rememberedValue4;
                    }
                } else {
                    obj31 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.DisposableEffect(onDismissRequest2, (Function1)$i$a$CacheAndroidPopup_androidKt$Popup$4, composer, i8 & 14);
                ComposerKt.sourceInformationMarkerStart(composer, -1370717926, layoutDirection);
                invalid$iv2 = composer.changedInstance($i$a$CacheAndroidPopup_androidKt$Popup$3);
                Composer composer11 = composer;
                int i87 = 0;
                Object rememberedValue5 = composer11.rememberedValue();
                int i95 = 0;
                if (!invalid$iv2) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        obj31 = i26;
                        obj32 = invalid$iv2;
                        $i$a$CacheAndroidPopup_androidKt$Popup$5 = new AndroidPopup_androidKt.Popup.5.1($i$a$CacheAndroidPopup_androidKt$Popup$3, 0);
                        composer11.updateRememberedValue((Function2)$i$a$CacheAndroidPopup_androidKt$Popup$5);
                    } else {
                        obj32 = invalid$iv2;
                        $i$a$CacheAndroidPopup_androidKt$Popup$5 = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                EffectsKt.LaunchedEffect($i$a$CacheAndroidPopup_androidKt$Popup$3, (Function2)$i$a$CacheAndroidPopup_androidKt$Popup$5, composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1370704156, layoutDirection);
                changedInstance = composer.changedInstance($i$a$CacheAndroidPopup_androidKt$Popup$3);
                Composer composer12 = composer;
                int i88 = 0;
                Object rememberedValue6 = composer12.rememberedValue();
                companion = 0;
                if (changedInstance == null) {
                    obj31 = changedInstance;
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        obj32 = invalid$iv4;
                        $i$a$CacheAndroidPopup_androidKt$Popup$7 = new AndroidPopup_androidKt.Popup.7.1($i$a$CacheAndroidPopup_androidKt$Popup$3);
                        composer12.updateRememberedValue((Function1)$i$a$CacheAndroidPopup_androidKt$Popup$7);
                    } else {
                        $i$a$CacheAndroidPopup_androidKt$Popup$7 = rememberedValue6;
                    }
                } else {
                    obj31 = changedInstance;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned((Modifier)Modifier.Companion, (Function1)$i$a$CacheAndroidPopup_androidKt$Popup$7);
                ComposerKt.sourceInformationMarkerStart(composer, -1370686070, layoutDirection);
                Composer composer13 = composer;
                int i89 = 0;
                Object rememberedValue7 = composer13.rememberedValue();
                int i91 = 0;
                if (changedInstance5 |= changed7 == 0) {
                    obj31 = onGloballyPositioned;
                    if (rememberedValue7 == Composer.Companion.getEmpty()) {
                        obj32 = i24;
                        $i$a$CacheAndroidPopup_androidKt$Popup$8 = new AndroidPopup_androidKt.Popup.8.1($i$a$CacheAndroidPopup_androidKt$Popup$3, restartGroup);
                        composer13.updateRememberedValue((MeasurePolicy)$i$a$CacheAndroidPopup_androidKt$Popup$8);
                    } else {
                        $i$a$CacheAndroidPopup_androidKt$Popup$8 = rememberedValue7;
                    }
                } else {
                    obj31 = onGloballyPositioned;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                obj7 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                obj8 = $i$a$CacheAndroidPopup_androidKt$Popup$3;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, obj31);
                obj32 = constructor;
                i2 = 0;
                i20 = $composer2;
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
                i18 = 0;
                i12 = factory$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)$i$a$CacheAndroidPopup_androidKt$Popup$8, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, composer.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i4 = 0;
                obj32 = constructor-impl;
                i5 = 0;
                if (!obj32.getInserting()) {
                    measurePolicy$iv = $i$a$CacheAndroidPopup_androidKt$Popup$8;
                    obj5 = valueOf;
                    if (!Intrinsics.areEqual(obj32.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj32.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = obj32;
                    }
                } else {
                    measurePolicy$iv = $i$a$CacheAndroidPopup_androidKt$Popup$8;
                    obj5 = valueOf;
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
                obj6 = it$iv;
                obj4 = layoutDirection2;
            } else {
                restartGroup.skipToGroupEnd();
                obj6 = obj3;
                composer = restartGroup;
                obj4 = obj2;
                i8 = currentCompositeKeyHash;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new AndroidPopup_androidKt.Popup.9(popupPositionProvider, obj6, obj4, content, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final Function2<Composer, Integer, Unit> Popup$lambda$1(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    public static final void Popup-K5zGePQ(Alignment alignment, long offset, Function0<Unit> onDismissRequest, androidx.compose.ui.window.PopupProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        int i9;
        int invalid$iv;
        androidx.compose.ui.window.AlignmentOffsetPositionProvider anon;
        int $dirty;
        Object $dirty2;
        Object alignment3;
        long alignment2;
        int traceInProgress;
        int i10;
        Object obj4;
        long offset2;
        Object offset4;
        int i;
        Object obj;
        int i7;
        boolean traceInProgress2;
        long offset3;
        Object obj5;
        int i13;
        int i6;
        Object i2;
        Object obj3;
        int i3;
        int empty;
        Object obj2;
        Object alignmentOffsetPositionProvider;
        int i4;
        Object obj6;
        int i5;
        androidx.compose.ui.window.PopupProperties popupProperties;
        int i17;
        int i12;
        int i15;
        int i11;
        int i16;
        int i14;
        long l;
        long l2;
        int obj26;
        final int i31 = i8;
        anon = 295309329;
        final Composer restartGroup = $changed.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(Popup)P(!1,2:c#ui.unit.IntOffset,3,4)269@12290L128,276@12424L165:AndroidPopup.android.kt#2oxthz");
        $dirty = i8;
        int i20 = obj34 & 1;
        if (i20 != 0) {
            $dirty |= 6;
            obj4 = alignment;
        } else {
            if (i31 & 6 == 0) {
                i = restartGroup.changed(alignment) ? 4 : 2;
                $dirty |= i;
            } else {
                obj4 = alignment;
            }
        }
        int i25 = obj34 & 2;
        if (i25 != 0) {
            $dirty |= 48;
            offset3 = offset;
        } else {
            if (i31 & 48 == 0) {
                i6 = restartGroup.changed(offset) ? 32 : 16;
                $dirty |= i6;
            } else {
                offset3 = offset;
            }
        }
        i2 = obj34 & 4;
        if (i2 != 0) {
            $dirty |= 384;
            obj3 = properties;
        } else {
            if (i31 & 384 == 0) {
                i3 = restartGroup.changedInstance(properties) ? 256 : 128;
                $dirty |= i3;
            } else {
                obj3 = properties;
            }
        }
        empty = obj34 & 8;
        if (empty != 0) {
            $dirty |= 3072;
            obj2 = content;
        } else {
            if (i31 & 3072 == 0) {
                i4 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty |= i4;
            } else {
                obj2 = content;
            }
        }
        if (obj34 & 16 != 0) {
            $dirty |= 24576;
            obj6 = $composer;
        } else {
            if (i31 & 24576 == 0) {
                i5 = restartGroup.changedInstance($composer) ? 16384 : 8192;
                $dirty |= i5;
            } else {
                obj6 = $composer;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (i20 != 0) {
                    alignment3 = Alignment.Companion.getTopStart();
                } else {
                    alignment3 = obj4;
                }
                i10 = 0;
                if (i25 != 0) {
                    offset2 = IntOffsetKt.IntOffset(i10, i10);
                } else {
                    offset2 = offset3;
                }
                obj5 = i2 != 0 ? i7 : obj3;
                if (empty != 0) {
                    popupProperties = new PopupProperties(0, 0, 0, 0, 15, 0);
                    i2 = popupProperties;
                } else {
                    i2 = obj2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty, -1, "androidx.compose.ui.window.Popup (AndroidPopup.android.kt:268)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1370836537, "CC(remember):AndroidPopup.android.kt#9igjgp");
                int i26 = 1;
                i9 = $dirty & 14 == 4 ? i26 : i10;
                if ($dirty & 112 == 32) {
                    i10 = i26;
                }
                i9 |= i10;
                Composer composer = restartGroup;
                int i27 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i37 = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj26 = invalid$iv;
                        alignmentOffsetPositionProvider = new AlignmentOffsetPositionProvider(alignment3, offset2, i25, 0);
                        composer.updateRememberedValue(alignmentOffsetPositionProvider);
                    } else {
                        obj26 = invalid$iv;
                        alignmentOffsetPositionProvider = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                AndroidPopup_androidKt.Popup((PopupPositionProvider)(AlignmentOffsetPositionProvider)alignmentOffsetPositionProvider, obj5, i2, obj6, restartGroup, i23 | i7, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                offset4 = obj5;
                offset3 = l;
                obj = i2;
            } else {
                restartGroup.skipToGroupEnd();
                alignment3 = obj4;
                offset4 = obj3;
                obj = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            i13 = $dirty;
            anon = new AndroidPopup_androidKt.Popup.1(alignment3, offset3, traceInProgress, offset4, obj, $composer, i31, obj34);
            endRestartGroup.updateScope((Function2)anon);
        } else {
            i13 = $dirty;
            $dirty2 = alignment3;
            alignment2 = l2;
        }
    }

    public static final void PopupTestTag(String tag, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int i2;
        int skipping;
        boolean traceInProgress;
        int str;
        traceInProgress2 = -498879600;
        final Composer obj6 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj6, "C(PopupTestTag)P(1)429@18089L75:AndroidPopup.android.kt#2oxthz");
        if ($changed & 6 == 0) {
            i = obj6.changed(tag) ? 4 : 2;
            $dirty |= i;
        }
        if ($changed & 48 == 0) {
            i2 = obj6.changedInstance(content) ? 32 : 16;
            $dirty |= i2;
        }
        if ($dirty & 19 == 18) {
            if (!obj6.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.window.PopupTestTag (AndroidPopup.android.kt:428)");
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
