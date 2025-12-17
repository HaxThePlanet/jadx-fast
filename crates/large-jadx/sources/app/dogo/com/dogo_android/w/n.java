package app.dogo.com.dogo_android.w;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import n.a.a.b;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0008\u0008J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/tracking/CrashlyticsLogger;", "Ltimber/log/Timber$Tree;", "()V", "createStackElementTag", "", "element", "Ljava/lang/StackTraceElement;", "getTag", "getTag$app_release", "log", "", "priority", "", "tag", "message", "throwable", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n extends a.b {

    public static final app.dogo.com.dogo_android.w.n.a Companion;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/CrashlyticsLogger$Companion;", "", "()V", "ANONYMOUS_CLASS", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "CALL_STACK_INDEX", "", "MAX_TAG_LENGTH", "TRACKER_CLASS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        n.a aVar = new n.a(0);
        n.Companion = aVar;
        Pattern.compile("(\\$\\d+)+$");
    }

    @Override // n.a.a$b
    protected void m(int i, String string2, String string3, Throwable throwable4) {
        FirebaseCrashlytics obj1;
        int obj2;
        n.f(string3, "message");
        if (i != 4 && i != 5) {
            if (i != 5) {
                if (i != 6) {
                } else {
                    FirebaseCrashlytics.getInstance().log(string3);
                    if (throwable4 != null) {
                        FirebaseCrashlytics.getInstance().recordException(throwable4);
                    }
                }
            } else {
                FirebaseCrashlytics.getInstance().log(string3);
            }
        } else {
        }
    }
}
