package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u0002*\u0004\u0008\u0002\u0010\u00032\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0008\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001\u0012J%\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0011R*\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007X¦\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0013", d2 = {"Lkotlin/reflect/KMutableProperty2;", "D", "E", "V", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty2$Setter;", "getSetter$annotations", "()V", "getSetter", "()Lkotlin/reflect/KMutableProperty2$Setter;", "set", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KMutableProperty2<D, E, V>  extends kotlin.reflect.KProperty2<D, E, V>, kotlin.reflect.KMutableProperty<V> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void getSetter$annotations() {
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u0000*\u0004\u0008\u0003\u0010\u0001*\u0004\u0008\u0004\u0010\u0002*\u0004\u0008\u0005\u0010\u00032\u0008\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007", d2 = {"Lkotlin/reflect/KMutableProperty2$Setter;", "D", "E", "V", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function3;", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Setter extends kotlin.reflect.KMutableProperty.Setter<V>, Function3<D, E, V, Unit> {
    }
    public abstract kotlin.reflect.KMutableProperty2.Setter<D, E, V> getSetter();

    public abstract void set(D d, E e2, V v3);
}
