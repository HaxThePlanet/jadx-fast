package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0087@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\u0008\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J&\u0010\u0019\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\u0008\u0016¢\u0006\u0004\u0008\u001a\u0010\u0018JI\u0010\u001b\u001a\u00020\u0013\"\u0004\u0008\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\u0008\u0016¢\u0006\u0004\u0008!\u0010\"JH\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\u0008\u0008\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0004\u0008!\u0010#J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\u0008&\u0010'JI\u0010(\u001a\u00020\u0013\"\u0004\u0008\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\u0008\u0016¢\u0006\u0004\u0008)\u0010\"JH\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\u0008\u0008\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0004\u0008)\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006*", d2 = {"Landroidx/compose/runtime/Updater;", "T", "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", "V", "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Updater<T>  {

    private final androidx.compose.runtime.Composer composer;
    private Updater(androidx.compose.runtime.Composer composer) {
        super();
        this.composer = composer;
    }

    public static final androidx.compose.runtime.Updater box-impl(androidx.compose.runtime.Composer composer) {
        Updater updater = new Updater(composer);
        return updater;
    }

    public static <T> androidx.compose.runtime.Composer constructor-impl(androidx.compose.runtime.Composer composer) {
        return composer;
    }

    public static boolean equals-impl(androidx.compose.runtime.Composer composer, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof Updater) {
            return i2;
        }
        if (!Intrinsics.areEqual(composer, (Updater)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(androidx.compose.runtime.Composer composer, androidx.compose.runtime.Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    public static void getComposer$annotations() {
    }

    public static int hashCode-impl(androidx.compose.runtime.Composer composer) {
        return composer.hashCode();
    }

    public static final void init-impl(androidx.compose.runtime.Composer arg0, Function1<? super T, Unit> block) {
        boolean iNSTANCE;
        androidx.compose.runtime.Updater.init.1 anon;
        if (arg0.getInserting()) {
            anon = new Updater.init.1(block);
            arg0.apply(Unit.INSTANCE, (Function2)anon);
        }
    }

    public static final void reconcile-impl(androidx.compose.runtime.Composer arg0, Function1<? super T, Unit> block) {
        Updater.reconcile.1 anon = new Updater.reconcile.1(block);
        arg0.apply(Unit.INSTANCE, (Function2)anon);
    }

    public static final void set-impl(androidx.compose.runtime.Composer arg0, int value, Function2<? super T, ? super Integer, Unit> block) {
        boolean valueOf;
        Integer valueOf2;
        final int i = 0;
        final Object obj = arg0;
        final int i2 = 0;
        if (!obj.getInserting()) {
            if (!Intrinsics.areEqual(obj.rememberedValue(), Integer.valueOf(value))) {
                obj.updateRememberedValue(Integer.valueOf(value));
                arg0.apply(Integer.valueOf(value), block);
            }
        } else {
        }
    }

    public static final <V> void set-impl(androidx.compose.runtime.Composer arg0, V value, Function2<? super T, ? super V, Unit> block) {
        boolean inserting;
        final Object obj = arg0;
        final int i = 0;
        if (!obj.getInserting()) {
            if (!Intrinsics.areEqual(obj.rememberedValue(), value)) {
                obj.updateRememberedValue(value);
                arg0.apply(value, block);
            }
        } else {
        }
    }

    public static String toString-impl(androidx.compose.runtime.Composer composer) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Updater(composer=").append(composer).append(')').toString();
    }

    public static final void update-impl(androidx.compose.runtime.Composer arg0, int value, Function2<? super T, ? super Integer, Unit> block) {
        boolean valueOf2;
        Integer valueOf;
        final int i = 0;
        final Object obj = arg0;
        final int i2 = 0;
        final boolean inserting = obj.getInserting();
        if (!inserting) {
            obj.updateRememberedValue(Integer.valueOf(value));
            if (!Intrinsics.areEqual(obj.rememberedValue(), Integer.valueOf(value)) && !inserting) {
                obj.updateRememberedValue(Integer.valueOf(value));
                if (!inserting) {
                    obj.apply(Integer.valueOf(value), block);
                }
            }
        } else {
        }
    }

    public static final <V> void update-impl(androidx.compose.runtime.Composer arg0, V value, Function2<? super T, ? super V, Unit> block) {
        boolean equal;
        final Object obj = arg0;
        final int i = 0;
        final boolean inserting = obj.getInserting();
        if (!inserting) {
            obj.updateRememberedValue(value);
            if (!Intrinsics.areEqual(obj.rememberedValue(), value) && !inserting) {
                obj.updateRememberedValue(value);
                if (!inserting) {
                    obj.apply(value, block);
                }
            }
        } else {
        }
    }

    public boolean equals(Object object) {
        return Updater.equals-impl(this.composer, object);
    }

    public int hashCode() {
        return Updater.hashCode-impl(this.composer);
    }

    public String toString() {
        return Updater.toString-impl(this.composer);
    }

    public final androidx.compose.runtime.Composer unbox-impl() {
        return this.composer;
    }
}
