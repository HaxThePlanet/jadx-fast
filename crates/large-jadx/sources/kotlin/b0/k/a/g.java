package kotlin.b0.k.a;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0008H\u0002\u001a\u000c\u0010\t\u001a\u00020\u0001*\u00020\u0008H\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000b*\u00020\u0008H\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0008H\u0001¢\u0006\u0002\u0008\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class g {
    private static final void a(int i, int i2) {
        if (i2 > i) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Debug metadata version mismatch. Expected: ");
        stringBuilder.append(i);
        stringBuilder.append(", got ");
        stringBuilder.append(i2);
        stringBuilder.append(". Please update the Kotlin standard library.");
        IllegalStateException obj3 = new IllegalStateException(stringBuilder.toString().toString());
        throw obj3;
    }

    private static final kotlin.b0.k.a.f b(kotlin.b0.k.a.a a) {
        return (f)a.getClass().getAnnotation(f.class);
    }

    private static final int c(kotlin.b0.k.a.a a) {
        Object obj2;
        try {
            Field declaredField = a.getClass().getDeclaredField("label");
            n.e(declaredField, "field");
            int i = 1;
            declaredField.setAccessible(i);
            if (!obj2 instanceof Integer) {
            }
            obj2 = 0;
            if ((Integer)obj2 != null) {
            } else {
            }
            obj2 = (Integer)obj2.intValue();
            obj2 = 0;
            obj2 -= i;
            a = -1;
            return obj2;
        }
    }

    public static final java.lang.StackTraceElement d(kotlin.b0.k.a.a a) {
        int i2;
        int[] i;
        Object stringBuilder;
        String obj4;
        n.f(a, "$this$getStackTraceElementImpl");
        kotlin.b0.k.a.f fVar = g.b(a);
        if (fVar != null) {
            g.a(1, fVar.v());
            int i4 = g.c(a);
            if (i4 < 0) {
                i2 = -1;
            } else {
                i2 = fVar.l()[i4];
            }
            obj4 = i.c.b(a);
            if (obj4 == null) {
                obj4 = fVar.c();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(obj4);
                stringBuilder.append('/');
                stringBuilder.append(fVar.c());
                obj4 = stringBuilder.toString();
            }
            StackTraceElement stackTraceElement = new StackTraceElement(obj4, fVar.m(), fVar.f(), i2);
            return stackTraceElement;
        }
        return null;
    }
}
