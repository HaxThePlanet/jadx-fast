package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0008H\u0002\u001a\u000c\u0010\t\u001a\u00020\u0001*\u00020\u0008H\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000b*\u00020\u0008H\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0008H\u0001¢\u0006\u0002\u0008\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DebugMetadataKt {

    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;
    private static final void checkDebugMetadataVersion(int expected, int actual) {
        if (actual > expected) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Debug metadata version mismatch. Expected: ").append(expected).append(", got ").append(actual).append(". Please update the Kotlin standard library.").toString().toString());
        throw illegalStateException;
    }

    private static final kotlin.coroutines.jvm.internal.DebugMetadata getDebugMetadataAnnotation(kotlin.coroutines.jvm.internal.BaseContinuationImpl $this$getDebugMetadataAnnotation) {
        return (DebugMetadata)$this$getDebugMetadataAnnotation.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(kotlin.coroutines.jvm.internal.BaseContinuationImpl $this$getLabel) {
        Field declaredField;
        int obj;
        int intValue;
        int i;
        declaredField = $this$getLabel.getClass().getDeclaredField("label");
        int i2 = 1;
        declaredField.setAccessible(i2);
        if (obj instanceof Integer) {
            try {
                obj = 0;
                if (obj != null) {
                } else {
                }
                intValue = obj.intValue();
                intValue = 0;
                intValue -= i2;
                int i3 = -1;
                return i;
            }
        } else {
        }
    }

    public static final String[] getSpilledVariableFieldMapping(kotlin.coroutines.jvm.internal.BaseContinuationImpl $this$getSpilledVariableFieldMapping) {
        int i;
        int i2;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter($this$getSpilledVariableFieldMapping, "<this>");
        kotlin.coroutines.jvm.internal.DebugMetadata debugMetadataAnnotation = DebugMetadataKt.getDebugMetadataAnnotation($this$getSpilledVariableFieldMapping);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        DebugMetadataKt.checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
        ArrayList arrayList = new ArrayList();
        int[] iArr = debugMetadataAnnotation.i();
        int i8 = 0;
        i = i8;
        while (i < iArr.length) {
            i2 = i;
            if (iArr[i] == DebugMetadataKt.getLabel($this$getSpilledVariableFieldMapping)) {
            }
            i++;
            arrayList.add(debugMetadataAnnotation.s()[i2]);
            arrayList.add(debugMetadataAnnotation.n()[i2]);
        }
        int i7 = 0;
        return (String[])(Collection)arrayList.toArray(new String[i8]);
    }

    public static final java.lang.StackTraceElement getStackTraceElement(kotlin.coroutines.jvm.internal.BaseContinuationImpl $this$getStackTraceElementImpl) {
        int i;
        String string;
        String str;
        Intrinsics.checkNotNullParameter($this$getStackTraceElementImpl, "<this>");
        kotlin.coroutines.jvm.internal.DebugMetadata debugMetadataAnnotation = DebugMetadataKt.getDebugMetadataAnnotation($this$getStackTraceElementImpl);
        if (debugMetadataAnnotation == null) {
            return null;
        }
        DebugMetadataKt.checkDebugMetadataVersion(1, debugMetadataAnnotation.v());
        int label = DebugMetadataKt.getLabel($this$getStackTraceElementImpl);
        if (label < 0) {
            i = -1;
        } else {
            i = debugMetadataAnnotation.l()[label];
        }
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName($this$getStackTraceElementImpl);
        if (moduleName == null) {
            string = debugMetadataAnnotation.c();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(moduleName).append('/').append(debugMetadataAnnotation.c()).toString();
        }
        StackTraceElement stackTraceElement = new StackTraceElement(string, debugMetadataAnnotation.m(), debugMetadataAnnotation.f(), i);
        return stackTraceElement;
    }
}
