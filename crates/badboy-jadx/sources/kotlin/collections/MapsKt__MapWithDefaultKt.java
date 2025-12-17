package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001¢\u0006\u0004\u0008\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\u0008\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000c\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u000c2!\u0010\u0008\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007¢\u0006\u0002\u0008\r¨\u0006\u000e", d2 = {"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> $this$getOrImplicitDefault, K key) {
        boolean key2;
        Intrinsics.checkNotNullParameter($this$getOrImplicitDefault, "<this>");
        if ($this$getOrImplicitDefault instanceof MapWithDefault) {
            return (MapWithDefault)$this$getOrImplicitDefault.getOrImplicitDefault(key);
        }
        Object obj2 = $this$getOrImplicitDefault;
        final int i = 0;
        final Object obj3 = obj2.get(key);
        if (obj3 == null) {
            if (!obj2.containsKey(key)) {
            } else {
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Key ").append(key).append(" is missing in the map.").toString());
            throw noSuchElementException;
        }
        return obj3;
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> $this$withDefault, Function1<? super K, ? extends V> defaultValue) {
        Map mapWithDefaultImpl;
        Intrinsics.checkNotNullParameter($this$withDefault, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if ($this$withDefault instanceof MapWithDefault) {
            mapWithDefaultImpl = MapsKt.withDefault((MapWithDefault)$this$withDefault.getMap(), defaultValue);
        } else {
            mapWithDefaultImpl = new MapWithDefaultImpl($this$withDefault, defaultValue);
        }
        return mapWithDefaultImpl;
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> $this$withDefault, Function1<? super K, ? extends V> defaultValue) {
        Map mutableMapWithDefaultImpl;
        Intrinsics.checkNotNullParameter($this$withDefault, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if ($this$withDefault instanceof MutableMapWithDefault) {
            mutableMapWithDefaultImpl = MapsKt.withDefaultMutable((MutableMapWithDefault)$this$withDefault.getMap(), defaultValue);
        } else {
            mutableMapWithDefaultImpl = new MutableMapWithDefaultImpl($this$withDefault, defaultValue);
        }
        return mutableMapWithDefaultImpl;
    }
}
