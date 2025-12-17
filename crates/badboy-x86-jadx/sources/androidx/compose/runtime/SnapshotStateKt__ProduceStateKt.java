package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0003\u001an\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00052-\u0010\u0008\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u000e\u001ad\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00052-\u0010\u0008\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u000f\u001aZ\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052-\u0010\u0008\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u0010\u001ah\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0016\u0010\u0011\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00050\u0012\"\u0004\u0018\u00010\u00052-\u0010\u0008\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u0013\u001aP\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022-\u0010\u0008\u001a)\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t¢\u0006\u0002\u0008\rH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015", d2 = {"produceState", "Landroidx/compose/runtime/State;", "T", "initialValue", "key1", "", "key2", "key3", "producer", "Lkotlin/Function2;", "Landroidx/compose/runtime/ProduceStateScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "keys", "", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final class SnapshotStateKt__ProduceStateKt {
    public static final <T> androidx.compose.runtime.State<T> produceState(T initialValue, Object key1, Object key2, Object key3, Function2<? super androidx.compose.runtime.ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object mutableStateOf$default;
        int i;
        Object anon;
        final Object obj = producer;
        final androidx.compose.runtime.Composer composer3 = $composer;
        final int i17 = $changed;
        int i2 = 1807205155;
        ComposerKt.sourceInformationMarkerStart(composer3, i2, "C(produceState)182@6956L41,183@7035L74,183@7002L107:ProduceState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i17, -1, "androidx.compose.runtime.produceState (ProduceState.kt:181)");
        }
        String str3 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer3, 2143129681, str3);
        int i4 = 0;
        androidx.compose.runtime.Composer composer2 = $composer;
        int i14 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i18 = 0;
        final int i20 = 0;
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            int i19 = 0;
            composer2.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(initialValue, i20, 2, i20));
        } else {
            mutableStateOf$default = rememberedValue2;
        }
        androidx.compose.runtime.MutableState mutableState2 = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerStart(composer3, 2143132242, str3);
        androidx.compose.runtime.Composer composer = $composer;
        int i13 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i15 = 0;
        if (!composer3.changedInstance(obj)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                mutableStateOf$default = 0;
                anon = new SnapshotStateKt__ProduceStateKt.produceState.4.1(obj, (MutableState)mutableState2, i20);
                composer.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer3);
        EffectsKt.LaunchedEffect(key1, key2, key3, (Function2)anon, composer3, i8 | i12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)mutableState2;
    }

    public static final <T> androidx.compose.runtime.State<T> produceState(T initialValue, Object key1, Object key2, Function2<? super androidx.compose.runtime.ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object mutableStateOf$default;
        int i;
        Object anon;
        int i2 = -1703169085;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(produceState)147@5571L41,148@5644L74,148@5617L101:ProduceState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.produceState (ProduceState.kt:146)");
        }
        String str3 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 2143085361, str3);
        int i4 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        int i11 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i13 = 0;
        final int i16 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i15 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(initialValue, i16, 2, i16));
        } else {
            mutableStateOf$default = rememberedValue;
        }
        androidx.compose.runtime.MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2143087730, str3);
        androidx.compose.runtime.Composer composer2 = $composer;
        int i12 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i14 = 0;
        if (!$composer.changedInstance(producer)) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                mutableStateOf$default = 0;
                anon = new SnapshotStateKt__ProduceStateKt.produceState.3.1(producer, (MutableState)invalid$iv, i16);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(key1, key2, (Function2)anon, $composer, i6 |= i10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }

    public static final <T> androidx.compose.runtime.State<T> produceState(T initialValue, Object key1, Function2<? super androidx.compose.runtime.ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object mutableStateOf$default;
        int i;
        Object anon;
        int i2 = -1928268701;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(produceState)113@4223L41,114@4290L74,114@4269L95:ProduceState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.produceState (ProduceState.kt:112)");
        }
        String str3 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 2143042225, str3);
        int i4 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i10 = 0;
        final int i13 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i12 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(initialValue, i13, 2, i13));
        } else {
            mutableStateOf$default = rememberedValue;
        }
        androidx.compose.runtime.MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2143044402, str3);
        androidx.compose.runtime.Composer composer2 = $composer;
        int i9 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i11 = 0;
        if (!$composer.changedInstance(producer)) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                mutableStateOf$default = 0;
                anon = new SnapshotStateKt__ProduceStateKt.produceState.2.1(producer, (MutableState)invalid$iv, i13);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(key1, (Function2)anon, $composer, i5 &= 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }

    public static final <T> androidx.compose.runtime.State<T> produceState(T initialValue, Function2<? super androidx.compose.runtime.ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object mutableStateOf$default;
        int empty;
        Object anon;
        int i = 10454275;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(produceState)80@2911L41,81@2978L74,81@2957L95:ProduceState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.produceState (ProduceState.kt:79)");
        }
        String str3 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 2143000241, str3);
        int i3 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        int i5 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i8 = 0;
        final int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i9 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(initialValue, i11, 2, i11));
        } else {
            mutableStateOf$default = rememberedValue;
        }
        androidx.compose.runtime.MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2143002418, str3);
        androidx.compose.runtime.Composer composer2 = $composer;
        int i7 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i10 = 0;
        if (!$composer.changedInstance(producer)) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SnapshotStateKt__ProduceStateKt.produceState.1.1(producer, (MutableState)invalid$iv, i11);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(Unit.INSTANCE, (Function2)anon, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }

    public static final <T> androidx.compose.runtime.State<T> produceState(T initialValue, Object[] keys, Function2<? super androidx.compose.runtime.ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> producer, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object mutableStateOf$default;
        int empty;
        Object anon;
        int i = 490154582;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(produceState)215@8286L41,217@8430L74,217@8402L102:ProduceState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.runtime.produceState (ProduceState.kt:214)");
        }
        String str3 = "CC(remember):ProduceState.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart($composer, 2143172241, str3);
        int i3 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        int i5 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i8 = 0;
        final int i11 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i9 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(initialValue, i11, 2, i11));
        } else {
            mutableStateOf$default = rememberedValue;
        }
        androidx.compose.runtime.MutableState invalid$iv = mutableStateOf$default;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 2143176882, str3);
        androidx.compose.runtime.Composer composer2 = $composer;
        int i7 = 0;
        Object rememberedValue2 = composer2.rememberedValue();
        int i10 = 0;
        if (!$composer.changedInstance(producer)) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new SnapshotStateKt__ProduceStateKt.produceState.5.1(producer, (MutableState)invalid$iv, i11);
                composer2.updateRememberedValue((Function2)anon);
            } else {
                anon = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(Arrays.copyOf(keys, keys.length), (Function2)anon, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)invalid$iv;
    }
}
