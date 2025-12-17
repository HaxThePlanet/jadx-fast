package app.dogo.com.dogo_android.k;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/enums/NotificationType;", "", "tag", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()I", "getTag", "()Ljava/lang/String;", "Training", "Custom", "Fcm", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum m {

    Training("training", false),
    Custom("training", false),
    Fcm("training", false);

    private final int id;
    private final String tag;
    private static final app.dogo.com.dogo_android.k.m[] $values() {
        app.dogo.com.dogo_android.k.m[] arr = new m[3];
        return arr;
    }

    @Override // java.lang.Enum
    public final int getId() {
        return this.id;
    }

    @Override // java.lang.Enum
    public final String getTag() {
        return this.tag;
    }
}
