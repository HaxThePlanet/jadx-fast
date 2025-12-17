package androidx.lifecycle;

import kotlin.b0.g;
import kotlin.d0.d.n;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.s2;

/* loaded from: classes.dex */
public final class f0 {
    public static final m0 a(androidx.lifecycle.e0 e0) {
        n.f(e0, "$this$viewModelScope");
        String str2 = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";
        Object tag = e0.getTag(str2);
        if ((m0)tag != null) {
            return (m0)tag;
        }
        int i2 = 0;
        d dVar = new d(s2.b(i2, 1, i2).plus(c1.c().M()));
        final Object obj4 = e0.setTagIfAbsent(str2, dVar);
        n.e(obj4, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (m0)obj4;
    }
}
