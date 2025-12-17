package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0001\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000e¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "Daily", "Weekly", "Monthly", "Yearly", "Once", "Temp", "FewTimesADay", "Unknown", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum l {

    Daily("daily"),
    Weekly("daily"),
    Monthly("daily"),
    Yearly("daily"),
    Once("daily"),
    Temp("daily"),
    FewTimesADay("daily"),
    Unknown("daily");

    private final String tag;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/enums/NotificationRepeating$Companion;", "", "()V", "getEnum", "Lapp/dogo/com/dogo_android/enums/NotificationRepeating;", "tag", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final app.dogo.com.dogo_android.k.l a(String string) {
            int i;
            app.dogo.com.dogo_android.k.l unknown;
            boolean z;
            n.f(string, "tag");
            app.dogo.com.dogo_android.k.l[] values = l.values();
            i = 0;
            while (i < values.length) {
                i++;
            }
            unknown = 0;
            if (unknown == null) {
                unknown = l.Unknown;
            }
            return unknown;
        }
    }
    private static final app.dogo.com.dogo_android.k.l[] $values() {
        app.dogo.com.dogo_android.k.l[] arr = new l[8];
        return arr;
    }

    @Override // java.lang.Enum
    public final String getTag() {
        return this.tag;
    }
}
