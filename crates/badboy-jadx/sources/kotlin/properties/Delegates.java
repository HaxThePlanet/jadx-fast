package kotlin.properties;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0008\u0008\u0000\u0010\u0005*\u00020\u0001J\u0080\u0001\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052Q\u0008\u0004\u0010\u0008\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u0011H\u0005¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0013\u0012\u0011H\u0005¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0080\u0001\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\u0008\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u0002H\u00052Q\u0008\u0004\u0010\u0008\u001aK\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u00030\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0013\u0012\u0011H\u0005¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000e\u0012\u0013\u0012\u0011H\u0005¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00130\tH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0014", d2 = {"Lkotlin/properties/Delegates;", "", "()V", "notNull", "Lkotlin/properties/ReadWriteProperty;", "T", "observable", "initialValue", "onChange", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Delegates {

    public static final kotlin.properties.Delegates INSTANCE;
    static {
        Delegates delegates = new Delegates();
        Delegates.INSTANCE = delegates;
    }

    public final <T> kotlin.properties.ReadWriteProperty<Object, T> notNull() {
        NotNullVar notNullVar = new NotNullVar();
        return (ReadWriteProperty)notNullVar;
    }

    public final <T> kotlin.properties.ReadWriteProperty<Object, T> observable(T initialValue, Function3<? super KProperty<?>, ? super T, ? super T, Unit> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        int i = 0;
        Delegates.observable.1 anon = new Delegates.observable.1(initialValue, onChange);
        return (ReadWriteProperty)anon;
    }

    public final <T> kotlin.properties.ReadWriteProperty<Object, T> vetoable(T initialValue, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> onChange) {
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        int i = 0;
        Delegates.vetoable.1 anon = new Delegates.vetoable.1(initialValue, onChange);
        return (ReadWriteProperty)anon;
    }
}
