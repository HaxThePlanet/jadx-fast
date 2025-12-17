package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013", d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class PlatformImplementations {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ReflectThrowable {

        public static final kotlin.internal.PlatformImplementations.ReflectThrowable INSTANCE;
        public static final Method addSuppressed = null;
        public static final Method getSuppressed = null;
        static {
            int i2;
            int i;
            int i3;
            Method method2;
            int it;
            Method method;
            int name;
            int str2;
            boolean equal;
            String str;
            PlatformImplementations.ReflectThrowable reflectThrowable = new PlatformImplementations.ReflectThrowable();
            PlatformImplementations.ReflectThrowable.INSTANCE = reflectThrowable;
            Class<Throwable> obj = Throwable.class;
            final Method[] methods = obj.getMethods();
            Intrinsics.checkNotNull(methods);
            i2 = 0;
            i = i2;
            while (i < methods.length) {
                method = method2;
                name = 0;
                str2 = i2;
                i++;
                Class[] parameterTypes = method.getParameterTypes();
                Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
                str2 = 1;
            }
            it = i3;
            while (i2 < methods.length) {
                i = methods[i2];
                method = 0;
                if (Intrinsics.areEqual(i.getName(), "getSuppressed") != 0) {
                    break;
                } else {
                }
                i2++;
            }
            int i4 = i;
        }
    }
    public void addSuppressed(Throwable cause, Throwable exception) {
        void arr;
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method addSuppressed = PlatformImplementations.ReflectThrowable.addSuppressed;
        if (addSuppressed != null) {
            addSuppressed.invoke(cause, /* result */);
        }
    }

    public Random defaultPlatformRandom() {
        FallbackThreadLocalRandom fallbackThreadLocalRandom = new FallbackThreadLocalRandom();
        return (Random)fallbackThreadLocalRandom;
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        throw unsupportedOperationException;
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object it;
        Object[] arr;
        Object obj;
        Intrinsics.checkNotNullParameter(exception, "exception");
        it = PlatformImplementations.ReflectThrowable.getSuppressed;
        it = it.invoke(exception, new Object[0]);
        if (it != null && it != null) {
            it = it.invoke(exception, new Object[0]);
            if (it != null) {
                arr = 0;
                if (ArraysKt.asList((Throwable[])it) == null) {
                    it = CollectionsKt.emptyList();
                }
            } else {
            }
        } else {
        }
        return it;
    }
}
