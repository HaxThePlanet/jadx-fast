package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a&\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u000e\u001a:\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u0012\u001a>\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u0015\u001aT\u0010\u0016\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u001b\u001aJ\u0010\u0016\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u001c\u001a@\u0010\u0016\u001a\u00020\u00062\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u001d\u001aN\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0013\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u001e\u001a6\u0010\u0016\u001a\u00020\u00062'\u0010\u0017\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\u0008\nH\u0007¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u00062\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060!H\u0007¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001\u001a#\u0010(\u001a\u00020\u00192\u0013\u0008\u0006\u0010)\u001a\r\u0012\u0004\u0012\u00020%0!¢\u0006\u0002\u0008*H\u0087\u0008¢\u0006\u0002\u0010+\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"DisposableEffectNoParamError", "", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "LaunchedEffectNoParamError", "DisposableEffect", "", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SideEffect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class EffectsKt {

    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final androidx.compose.runtime.DisposableEffectScope InternalDisposableEffectScope = null;
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";
    static {
        DisposableEffectScope disposableEffectScope = new DisposableEffectScope();
        EffectsKt.InternalDisposableEffectScope = disposableEffectScope;
    }

    public static final void DisposableEffect(Object key1, Object key2, Object key3, Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object disposableEffectImpl;
        int i = -1239538271;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(DisposableEffect)P(1,2,3)237@10087L59:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:236)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1176328163, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (i3 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                disposableEffectImpl = new DisposableEffectImpl(effect);
                composer.updateRememberedValue(disposableEffectImpl);
            } else {
                disposableEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void DisposableEffect(Object key1, Object key2, Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object disposableEffectImpl;
        int i = 1429097729;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(DisposableEffect)P(1,2)196@8163L53:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:195)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1176266589, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i5 = 0;
        if (changed |= changed2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                disposableEffectImpl = new DisposableEffectImpl(effect);
                composer.updateRememberedValue(disposableEffectImpl);
            } else {
                disposableEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void DisposableEffect(Object key1, Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object disposableEffectImpl;
        int i = -1371986847;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(DisposableEffect)P(1)156@6277L47:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:155)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1176206231, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i4 = 0;
        if (!$composer.changed(key1)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                disposableEffectImpl = new DisposableEffectImpl(effect);
                composer.updateRememberedValue(disposableEffectImpl);
            } else {
                disposableEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.")
    public static final void DisposableEffect(Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -904483903;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(DisposableEffect):Effects.kt#9igjgp");
        if (!ComposerKt.isTraceInProgress()) {
        } else {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:119)");
        }
        IllegalStateException illegalStateException = new IllegalStateException("DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.".toString());
        throw illegalStateException;
    }

    public static final void DisposableEffect(Object[] keys, Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int invalid$iv;
        int i;
        Object obj;
        boolean changed;
        Object empty;
        androidx.compose.runtime.DisposableEffectImpl disposableEffectImpl;
        int i2 = -1307627122;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(DisposableEffect)P(1)277@11983L48:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:276)");
        }
        Object[] copyOf = Arrays.copyOf(keys, keys.length);
        int i3 = 0;
        int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
        invalid$iv = 0;
        i = 0;
        while (i < copyOf.length) {
            invalid$iv |= changed;
            i++;
        }
        androidx.compose.runtime.Composer composer = $composer;
        int i6 = 0;
        int i7 = 0;
        if (invalid$iv == 0) {
            if (composer.rememberedValue() == Composer.Companion.getEmpty()) {
                empty = 0;
                disposableEffectImpl = new DisposableEffectImpl(effect);
                composer.updateRememberedValue(disposableEffectImpl);
            } else {
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void LaunchedEffect(Object key1, Object key2, Object key3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object launchedEffectImpl;
        int i = -54093371;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(LaunchedEffect)P(1,2,3)386@16393L70:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:384)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2065030688, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i5 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (i3 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                launchedEffectImpl = new LaunchedEffectImpl($composer.getApplyCoroutineContext(), block);
                composer.updateRememberedValue(launchedEffectImpl);
            } else {
                launchedEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void LaunchedEffect(Object key1, Object key2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object launchedEffectImpl;
        int i = 590241125;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(LaunchedEffect)P(1,2)362@15355L64:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:360)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2064997466, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i5 = 0;
        if (changed |= changed2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                launchedEffectImpl = new LaunchedEffectImpl($composer.getApplyCoroutineContext(), block);
                composer.updateRememberedValue(launchedEffectImpl);
            } else {
                launchedEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void LaunchedEffect(Object key1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object empty;
        Object launchedEffectImpl;
        int i = 1179185413;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(LaunchedEffect)P(1)339@14347L58:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:337)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2064965204, "CC(remember):Effects.kt#9igjgp");
        androidx.compose.runtime.Composer composer = $composer;
        final int i3 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i4 = 0;
        if (!$composer.changed(key1)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                launchedEffectImpl = new LaunchedEffectImpl($composer.getApplyCoroutineContext(), block);
                composer.updateRememberedValue(launchedEffectImpl);
            } else {
                launchedEffectImpl = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    public static final void LaunchedEffect(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, androidx.compose.runtime.Composer $composer, int $changed) {
        int skipping;
        boolean traceInProgress;
        String str;
        int i = -805415771;
        final androidx.compose.runtime.Composer obj4 = $composer.startRestartGroup(i);
        ComposerKt.sourceInformation(obj4, "C(LaunchedEffect):Effects.kt#9igjgp");
        if ($changed & 1 == 0) {
            if (!obj4.getSkipping()) {
            } else {
                obj4.skipToGroupEnd();
                androidx.compose.runtime.ScopeUpdateScope endRestartGroup = obj4.endRestartGroup();
                if (endRestartGroup != null) {
                    skipping = new EffectsKt.LaunchedEffect.1(block, $changed);
                    endRestartGroup.updateScope((Function2)skipping);
                }
            }
        }
        if (!ComposerKt.isTraceInProgress()) {
        } else {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:318)");
        }
        IllegalStateException illegalStateException = new IllegalStateException("LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.".toString());
        throw illegalStateException;
    }

    public static final void LaunchedEffect(Object[] keys, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int invalid$iv;
        int i;
        Object obj;
        boolean changed;
        Object empty;
        androidx.compose.runtime.LaunchedEffectImpl launchedEffectImpl;
        int i2 = -139560008;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(LaunchedEffect)P(1)412@17562L59:Effects.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:410)");
        }
        Object[] copyOf = Arrays.copyOf(keys, keys.length);
        int i3 = 0;
        final int i4 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, -568225417, "CC(remember)P(1):Composables.kt#9igjgp");
        invalid$iv = 0;
        i = 0;
        while (i < copyOf.length) {
            invalid$iv |= changed;
            i++;
        }
        androidx.compose.runtime.Composer composer = $composer;
        int i6 = 0;
        int i7 = 0;
        if (invalid$iv == 0) {
            if (composer.rememberedValue() == Composer.Companion.getEmpty()) {
                empty = 0;
                launchedEffectImpl = new LaunchedEffectImpl($composer.getApplyCoroutineContext(), block);
                composer.updateRememberedValue(launchedEffectImpl);
            } else {
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void SideEffect(Function0<Unit> effect, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        int i;
        String str;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1288466761, $changed, -1, "androidx.compose.runtime.SideEffect (Effects.kt:48)");
        }
        $composer.recordSideEffect(effect);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    public static final androidx.compose.runtime.DisposableEffectScope access$getInternalDisposableEffectScope$p() {
        return EffectsKt.InternalDisposableEffectScope;
    }

    public static final CoroutineScope createCompositionCoroutineScope(CoroutineContext coroutineContext, androidx.compose.runtime.Composer composer) {
        CoroutineScope applyContext;
        Object obj;
        int i;
        java.lang.IllegalArgumentException illegalArgumentException;
        String str;
        if (coroutineContext.get((CoroutineContext.Key)Job.Key) != null) {
            int i3 = 0;
            CompletableJob completableJob = JobKt.Job$default(i3, 1, i3);
            i = 0;
            illegalArgumentException = new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job");
            completableJob.completeExceptionally((Throwable)illegalArgumentException);
            applyContext = CoroutineScopeKt.CoroutineScope((CoroutineContext)completableJob);
        } else {
            CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
            applyContext = obj;
        }
        return applyContext;
    }

    public static final CoroutineScope rememberCoroutineScope(Function0<? extends CoroutineContext> getContext, androidx.compose.runtime.Composer $composer, int $changed, int i4) {
        int empty;
        Object compositionScopedCoroutineScopeCanceller;
        CoroutineScope compositionCoroutineScope;
        androidx.compose.runtime.EffectsKt.rememberCoroutineScope.1 obj9;
        int obj12;
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
        if (i4 &= 1 != 0) {
            obj9 = obj12;
        }
        ComposerKt.sourceInformationMarkerStart($composer, -954367824, "CC(remember):Effects.kt#9igjgp");
        int i5 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        final int i6 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i7 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)obj9.invoke(), $composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
        } else {
            compositionScopedCoroutineScopeCanceller = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
    }
}
