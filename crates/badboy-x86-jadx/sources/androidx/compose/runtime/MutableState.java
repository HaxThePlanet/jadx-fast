package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u000e\u0010\u0008\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nH¦\u0002R\u0018\u0010\u0003\u001a\u00028\u0000X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/MutableState;", "T", "Landroidx/compose/runtime/State;", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "Lkotlin/Function1;", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableState<T>  extends androidx.compose.runtime.State<T> {
    public abstract T component1();

    public abstract Function1<T, Unit> component2();

    public abstract T getValue();

    public abstract void setValue(T t);
}
