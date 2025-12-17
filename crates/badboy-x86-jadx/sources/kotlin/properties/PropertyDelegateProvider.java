package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008ç\u0080\u0001\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u0000*\u0006\u0008\u0001\u0010\u0002 \u00012\u00020\u0003J\"\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u0007H¦\u0002¢\u0006\u0002\u0010\u0008¨\u0006\t", d2 = {"Lkotlin/properties/PropertyDelegateProvider;", "T", "D", "", "provideDelegate", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface PropertyDelegateProvider<T, D>  {
    public abstract D provideDelegate(T t, KProperty<?> kProperty2);
}
