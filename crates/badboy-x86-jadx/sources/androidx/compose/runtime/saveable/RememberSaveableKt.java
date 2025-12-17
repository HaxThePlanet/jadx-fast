package androidx.compose.runtime.saveable;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a>\u0010\u0006\u001a\u001c\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\t0\u0008\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00080\u0007\"\u0004\u0008\u0000\u0010\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u0007H\u0002\u001aa\u0010\u000b\u001a\u0002H\t\"\u0008\u0008\u0000\u0010\t*\u00020\u00052\u0016\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00050\r\"\u0004\u0018\u00010\u00052\u0016\u0008\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u00072\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001ag\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u0008\"\u0004\u0008\u0000\u0010\t2\u0016\u0010\u000c\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00050\r\"\u0004\u0018\u00010\u00052\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u00072\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\t0\u00080\u0011H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"MaxSupportedRadix", "", "generateCannotBeSavedErrorMessage", "", "value", "", "mutableStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/runtime/MutableState;", "T", "inner", "rememberSaveable", "inputs", "", "saver", "key", "init", "Lkotlin/Function0;", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Ljava/lang/Object;", "stateSaver", "([Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/MutableState;", "requireCanBeSaved", "", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RememberSaveableKt {

    private static final int MaxSupportedRadix = 36;
    static {
        final int i = 36;
    }

    public static final void access$requireCanBeSaved(androidx.compose.runtime.saveable.SaveableStateRegistry $receiver, Object value) {
        RememberSaveableKt.requireCanBeSaved($receiver, value);
    }

    public static final String generateCannotBeSavedErrorMessage(Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(value).append(" cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().").toString();
    }

    private static final <T> androidx.compose.runtime.saveable.Saver<MutableState<T>, MutableState<Object>> mutableStateSaver(androidx.compose.runtime.saveable.Saver<T, ? extends Object> inner) {
        Intrinsics.checkNotNull(inner, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver, kotlin.Any>");
        Object obj = inner;
        final int i = 0;
        RememberSaveableKt.mutableStateSaver.1.1 anon = new RememberSaveableKt.mutableStateSaver.1.1(obj);
        RememberSaveableKt.mutableStateSaver.1.2 anon2 = new RememberSaveableKt.mutableStateSaver.1.2(obj);
        return SaverKt.Saver((Function2)anon, (Function1)anon2);
    }

    public static final <T> MutableState<T> rememberSaveable(Object[] inputs, androidx.compose.runtime.saveable.Saver<T, ? extends Object> stateSaver, String key, Function0<? extends MutableState<T>> init, Composer $composer, int $changed, int i7) {
        int i;
        int obj10;
        int obj14;
        final int i2 = -202053668;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberSaveable)P(1,3,2)127@5317L106:RememberSaveable.kt#r2ddri");
        i = i7 &= 4 != 0 ? obj10 : key;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:127)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (MutableState)RememberSaveableKt.rememberSaveable(Arrays.copyOf(inputs, inputs.length), RememberSaveableKt.mutableStateSaver(stateSaver), i, init, composer, obj10 | obj14, 0);
    }

    public static final <T> T rememberSaveable(Object[] inputs, androidx.compose.runtime.saveable.Saver<T, ? extends Object> saver, String key, Function0<? extends T> init, Composer $composer, int $changed, int i7) {
        int length;
        int string;
        Object it$iv2;
        androidx.compose.runtime.saveable.Saver holder;
        int i2;
        boolean traceInProgress;
        Object $changed$iv;
        String str2;
        String registry;
        Object it;
        Object consumeRestored;
        Object valueIfInputsDidntChange;
        Object value;
        int consume;
        Object[] it$iv;
        Object obj3;
        int i;
        int empty;
        int i3;
        int changedInstance;
        int i4;
        Object obj;
        Object obj2;
        String str;
        final Composer composer = $composer;
        final int i16 = $changed;
        int i5 = 441892779;
        ComposerKt.sourceInformationMarkerStart(composer, i5, "C(rememberSaveable)P(1,3,2)71@3180L23,81@3526L7,83@3552L313,93@3951L71,93@3940L82:RememberSaveable.kt#r2ddri");
        if (i7 & 2 != 0) {
            holder = SaverKt.autoSaver();
        } else {
            holder = saver;
        }
        i3 = i7 & 4 != 0 ? i2 : key;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i16, -1, "androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:70)");
        }
        final int i17 = 0;
        length = i3;
        if ((CharSequence)length != 0) {
            if ((CharSequence)length.length() == 0) {
                string = i;
            } else {
                string = i17;
            }
        } else {
        }
        if (string == null) {
            registry = i3;
        } else {
            string = Integer.toString(ComposablesKt.getCurrentCompositeKeyHash(composer, i17), CharsKt.checkRadix(RememberSaveableKt.MaxSupportedRadix));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            registry = string;
        }
        Intrinsics.checkNotNull(holder, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable, kotlin.Any>");
        int i10 = 6;
        int i11 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        $changed$iv = consume;
        String str6 = "CC(remember):RememberSaveable.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, -1519365315, str6);
        Composer composer2 = $composer;
        int i21 = i8;
        int i24 = 0;
        it$iv2 = composer2.rememberedValue();
        int i25 = 0;
        if (it$iv2 == Composer.Companion.getEmpty()) {
            i4 = 0;
            consumeRestored = (SaveableStateRegistry)$changed$iv.consumeRestored(registry);
            if ($changed$iv != null && consumeRestored != null) {
                consumeRestored = $changed$iv.consumeRestored(registry);
                if (consumeRestored != null) {
                    consume = 0;
                    it = holder.restore(consumeRestored);
                } else {
                    it = 0;
                }
            } else {
            }
            obj = it;
            if (obj == null) {
                consumeRestored = init.invoke();
            } else {
                consumeRestored = obj;
            }
            obj2 = obj4;
            it$iv2 = new SaveableHolder(holder, $changed$iv, registry, consumeRestored, inputs);
            composer2.updateRememberedValue(it$iv2);
        } else {
            it$iv = inputs;
            obj2 = it$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if ((SaveableHolder)it$iv2.getValueIfInputsDidntChange(it$iv) == null) {
            valueIfInputsDidntChange = init.invoke();
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1519352789, str6);
        int i22 = 32;
        if (i20 ^= 48 > i22) {
            if (!composer.changedInstance(holder)) {
                if (i16 & 48 == i22) {
                } else {
                    i = i17;
                }
            } else {
            }
        } else {
        }
        Composer composer3 = $composer;
        int i23 = 0;
        Object rememberedValue = composer3.rememberedValue();
        int i26 = 0;
        if (changedInstance5 |= empty == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i4 = 0;
                String value2 = registry;
                Object finalKey = $changed$iv;
                androidx.compose.runtime.saveable.Saver registry2 = holder;
                Object saver2 = it$iv2;
                RememberSaveableKt.rememberSaveable.1.1 holder2 = new RememberSaveableKt.rememberSaveable.1.1(saver2, registry2, finalKey, value2, valueIfInputsDidntChange, inputs);
                it$iv2 = saver2;
                holder = registry2;
                $changed$iv = finalKey;
                registry = str;
                composer3.updateRememberedValue((Function0)holder2);
            } else {
                obj3 = valueIfInputsDidntChange;
                value = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.SideEffect((Function0)value, composer, i17);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return obj3;
    }

    private static final void requireCanBeSaved(androidx.compose.runtime.saveable.SaveableStateRegistry $this$requireCanBeSaved, Object value) {
        boolean beSaved;
        androidx.compose.runtime.SnapshotMutationPolicy policy;
        String cannotBeSavedErrorMessage;
        androidx.compose.runtime.SnapshotMutationPolicy structuralEqualityPolicy;
        if (value != null && !$this$requireCanBeSaved.canBeSaved(value)) {
            if (!$this$requireCanBeSaved.canBeSaved(value)) {
                if (value instanceof SnapshotMutableState) {
                    if ((SnapshotMutableState)value.getPolicy() != SnapshotStateKt.neverEqualPolicy() && (SnapshotMutableState)value.getPolicy() != SnapshotStateKt.structuralEqualityPolicy() && (SnapshotMutableState)value.getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                        if ((SnapshotMutableState)value.getPolicy() != SnapshotStateKt.structuralEqualityPolicy()) {
                            if ((SnapshotMutableState)value.getPolicy() != SnapshotStateKt.referentialEqualityPolicy()) {
                                cannotBeSavedErrorMessage = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                cannotBeSavedErrorMessage = stringBuilder.append("MutableState containing ").append((SnapshotMutableState)value.getValue()).append(" cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().").toString();
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    cannotBeSavedErrorMessage = RememberSaveableKt.generateCannotBeSavedErrorMessage(value);
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(cannotBeSavedErrorMessage);
                throw illegalArgumentException;
            }
        }
    }
}
