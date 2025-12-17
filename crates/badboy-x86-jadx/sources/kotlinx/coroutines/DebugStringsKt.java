package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u0008H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0004¨\u0006\t", d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DebugStringsKt {
    public static final String getClassSimpleName(Object $this$classSimpleName) {
        return $this$classSimpleName.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object $this$hexAddress) {
        return Integer.toHexString(System.identityHashCode($this$hexAddress));
    }

    public static final String toDebugString(Continuation<?> $this$toDebugString) {
        String string;
        String string2;
        Object $i$a$GetOrElseDebugStringsKt$toDebugString$2;
        int i;
        Object exceptionOrNull-impl;
        String hexAddress2;
        String hexAddress;
        if ($this$toDebugString instanceof DispatchedContinuation) {
            string2 = $this$toDebugString.toString();
        } else {
            string = 64;
            kotlin.Result.Companion companion = Result.Companion;
            Object obj = $this$toDebugString;
            i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            $i$a$GetOrElseDebugStringsKt$toDebugString$2 = Result.constructor-impl(stringBuilder.append(obj).append(string).append(DebugStringsKt.getHexAddress(obj)).toString());
            if (Result.exceptionOrNull-impl($i$a$GetOrElseDebugStringsKt$toDebugString$2) == null) {
            } else {
                int i2 = 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                $i$a$GetOrElseDebugStringsKt$toDebugString$2 = string;
            }
            string2 = $i$a$GetOrElseDebugStringsKt$toDebugString$2;
        }
        return string2;
    }
}
