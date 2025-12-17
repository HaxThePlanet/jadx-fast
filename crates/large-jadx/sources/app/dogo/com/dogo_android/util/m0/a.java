package app.dogo.com.dogo_android.util.m0;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008&\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000c\u0010\u0007\u001a\u0006\u0012\u0002\u0008\u00030\u0008H$¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "Landroid/os/Parcelable;", "()V", "buildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "getActivityClass", "Ljava/lang/Class;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class a implements Parcelable {

    public static final app.dogo.com.dogo_android.util.m0.a.a Companion = null;
    public static final String SCREEN_KEY = "SCREEN_KEY";

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey$Companion;", "", "()V", "SCREEN_KEY", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.Companion = aVar;
    }

    @Override // android.os.Parcelable
    public Intent buildIntent(Context context) {
        n.f(context, "context");
        Intent intent = new Intent(context, getActivityClass());
        intent.putExtra("SCREEN_KEY", this);
        return intent;
    }

    protected abstract Class<?> getActivityClass();
}
