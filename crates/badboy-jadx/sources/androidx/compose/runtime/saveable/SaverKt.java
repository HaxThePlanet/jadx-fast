package androidx.compose.runtime.saveable;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aw\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\u0008\u0000\u0010\u0004\"\u0008\u0008\u0001\u0010\u0005*\u00020\u00022.\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\u0008\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0007¢\u0006\u0002\u0008\u000c2#\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u000e\u001a\u0018\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\u0008\u0000\u0010\u0010\"\u001c\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"AutoSaver", "Landroidx/compose/runtime/saveable/Saver;", "", "Saver", "Original", "Saveable", "save", "Lkotlin/Function2;", "Landroidx/compose/runtime/saveable/SaverScope;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/ExtensionFunctionType;", "restore", "Lkotlin/Function1;", "autoSaver", "T", "runtime-saveable_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SaverKt {

    private static final androidx.compose.runtime.saveable.Saver<Object, Object> AutoSaver;
    static {
        SaverKt.AutoSaver = SaverKt.Saver((Function2)SaverKt.AutoSaver.1.INSTANCE, (Function1)SaverKt.AutoSaver.2.INSTANCE);
    }

    public static final <Original, Saveable> androidx.compose.runtime.saveable.Saver<Original, Saveable> Saver(Function2<? super androidx.compose.runtime.saveable.SaverScope, ? super Original, ? extends Saveable> save, Function1<? super Saveable, ? extends Original> restore) {
        SaverKt.Saver.1 anon = new SaverKt.Saver.1(save, restore);
        return (Saver)anon;
    }

    public static final <T> androidx.compose.runtime.saveable.Saver<T, Object> autoSaver() {
        final androidx.compose.runtime.saveable.Saver autoSaver = SaverKt.AutoSaver;
        Intrinsics.checkNotNull(autoSaver, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return autoSaver;
    }
}
