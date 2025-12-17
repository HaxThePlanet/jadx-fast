package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008`\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002J;\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00072\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\u0008\u000b\u0010\u000c¨\u0006\r", d2 = {"Lkotlinx/serialization/internal/ParametrizedSerializerCache;", "T", "", "get", "Lkotlin/Result;", "Lkotlinx/serialization/KSerializer;", "key", "Lkotlin/reflect/KClass;", "types", "", "Lkotlin/reflect/KType;", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ParametrizedSerializerCache<T>  {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object get-gIAlu-s$default(kotlinx.serialization.internal.ParametrizedSerializerCache parametrizedSerializerCache, KClass kClass2, List list3, int i4, Object object5) {
            List obj2;
            if (object5 != null) {
            } else {
                if (i4 &= 2 != 0) {
                    obj2 = CollectionsKt.emptyList();
                }
                return parametrizedSerializerCache.get-gIAlu-s(kClass2, obj2);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get-gIAlu-s");
            throw obj0;
        }
    }
    public abstract Object get-gIAlu-s(KClass<Object> kClass, List<? extends KType> list2);
}
