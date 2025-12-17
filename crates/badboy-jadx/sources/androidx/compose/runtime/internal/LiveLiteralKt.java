package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0008\u0010\u000c\u001a\u00020\rH\u0007\u001a)\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u000f\"\u0004\u0008\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0007\"&\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00018\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0005\":\u0010\u0006\u001a.\u0012\u0004\u0012\u00020\u0008\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u0007j\u0016\u0012\u0004\u0012\u00020\u0008\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"<set-?>", "", "isLiveLiteralsEnabled", "isLiveLiteralsEnabled$annotations", "()V", "()Z", "liveLiteralCache", "Ljava/util/HashMap;", "", "Landroidx/compose/runtime/MutableState;", "", "Lkotlin/collections/HashMap;", "enableLiveLiterals", "", "liveLiteral", "Landroidx/compose/runtime/State;", "T", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/compose/runtime/State;", "updateLiveLiteralValue", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LiveLiteralKt {

    private static boolean isLiveLiteralsEnabled;
    private static final HashMap<String, MutableState<Object>> liveLiteralCache;
    static {
        HashMap hashMap = new HashMap();
        LiveLiteralKt.liveLiteralCache = hashMap;
    }

    public static final void enableLiveLiterals() {
        LiveLiteralKt.isLiveLiteralsEnabled = true;
    }

    public static final boolean isLiveLiteralsEnabled() {
        return LiveLiteralKt.isLiveLiteralsEnabled;
    }

    @ComposeCompilerApi
    public static void isLiveLiteralsEnabled$annotations() {
    }

    @ComposeCompilerApi
    public static final <T> State<T> liveLiteral(String key, T value) {
        Object $i$a$GetOrPutLiveLiteralKt$liveLiteral$1;
        int i;
        int i2;
        HashMap liveLiteralCache = LiveLiteralKt.liveLiteralCache;
        final int i3 = 0;
        final Object obj = (Map)liveLiteralCache.get(key);
        if (obj == null) {
            int i4 = 0;
            i2 = 0;
            liveLiteralCache.put(key, SnapshotStateKt.mutableStateOf$default(value, i2, 2, i2));
        } else {
            $i$a$GetOrPutLiveLiteralKt$liveLiteral$1 = obj;
        }
        Intrinsics.checkNotNull($i$a$GetOrPutLiveLiteralKt$liveLiteral$1, "null cannot be cast to non-null type androidx.compose.runtime.State<T of androidx.compose.runtime.internal.LiveLiteralKt.liveLiteral>");
        return (State)$i$a$GetOrPutLiveLiteralKt$liveLiteral$1;
    }

    public static final void updateLiveLiteralValue(String key, Object value) {
        int needToUpdate;
        Object $i$a$GetOrPutLiveLiteralKt$updateLiveLiteralValue$stateObj$1;
        int i;
        int i2;
        int i3 = 0;
        needToUpdate = 1;
        HashMap liveLiteralCache = LiveLiteralKt.liveLiteralCache;
        final int i4 = 0;
        final Object obj = (Map)liveLiteralCache.get(key);
        if (obj == null) {
            int i5 = 0;
            needToUpdate = 0;
            i2 = 0;
            liveLiteralCache.put(key, SnapshotStateKt.mutableStateOf$default(value, i2, 2, i2));
        } else {
            $i$a$GetOrPutLiveLiteralKt$updateLiveLiteralValue$stateObj$1 = obj;
        }
        if (needToUpdate != 0) {
            (MutableState)$i$a$GetOrPutLiveLiteralKt$updateLiveLiteralValue$stateObj$1.setValue(value);
        }
    }
}
