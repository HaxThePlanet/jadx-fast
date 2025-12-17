package androidx.activity.result.f;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.a;

/* loaded from: classes.dex */
public final class c extends androidx.activity.result.f.a<Intent, a> {
    @Override // androidx.activity.result.f.a
    public Intent a(Context context, Object object2) {
        d(context, (Intent)object2);
        return object2;
    }

    @Override // androidx.activity.result.f.a
    public Object c(int i, Intent intent2) {
        return e(i, intent2);
    }

    @Override // androidx.activity.result.f.a
    public Intent d(Context context, Intent intent2) {
        return intent2;
    }

    @Override // androidx.activity.result.f.a
    public a e(int i, Intent intent2) {
        a aVar = new a(i, intent2);
        return aVar;
    }
}
