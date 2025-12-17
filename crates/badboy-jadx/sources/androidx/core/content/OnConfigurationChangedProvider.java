package androidx.core.content;

import android.content.res.Configuration;
import androidx.core.util.Consumer;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/core/content/OnConfigurationChangedProvider;", "", "addOnConfigurationChangedListener", "", "listener", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "removeOnConfigurationChangedListener", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface OnConfigurationChangedProvider {
    public abstract void addOnConfigurationChangedListener(Consumer<Configuration> consumer);

    public abstract void removeOnConfigurationChangedListener(Consumer<Configuration> consumer);
}
