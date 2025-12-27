package app.dogo.com.dogo_android.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ClickerSoundChanged.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "listener", "Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;", "(Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;)V", "getListener", "()Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;", "onSharedPreferenceChanged", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "SoundChangedListener", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class ClickerSoundChanged implements SharedPreferences.OnSharedPreferenceChangeListener {

    private final o.a a;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/clicker/ClickerSoundChanged$SoundChangedListener;", "", "changed", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: a, reason: from kotlin metadata */
        void changed();
    }
    public o(o.a aVar) {
        n.f(aVar, "listener");
        super();
        this.a = aVar;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (n.b(key, "clicker_sound_id")) {
            this.a.changed();
        }
    }
}
