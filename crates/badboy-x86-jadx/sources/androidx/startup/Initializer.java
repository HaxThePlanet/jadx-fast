package androidx.startup;

import android.content.Context;
import java.util.List;

/* loaded from: classes5.dex */
public interface Initializer<T>  {
    public abstract T create(Context context);

    public abstract List<Class<? extends androidx.startup.Initializer<?>>> dependencies();
}
