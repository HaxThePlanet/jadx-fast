package e.a.a.a.b.c;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LessonWithTask.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/android/persistencedb/room/junction/LessonWithTask;", "", "locale_lessonId", "", "locale_taskId", "(Ljava/lang/String;Ljava/lang/String;)V", "getLocale_lessonId", "()Ljava/lang/String;", "getLocale_taskId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final /* data */ class LessonWithTask {

    /* renamed from: a, reason: from kotlin metadata */
    private final String locale_lessonId;
    /* renamed from: b, reason: from kotlin metadata */
    private final String locale_taskId;
    public c(String str, String str2) {
        n.f(str, "locale_lessonId");
        n.f(str2, "locale_taskId");
        super();
        this.locale_lessonId = str;
        this.locale_taskId = str2;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.locale_lessonId;
    }

    public final String b() {
        return this.locale_taskId;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof LessonWithTask)) {
            return false;
        }
        if (!n.b(this.locale_lessonId, other.locale_lessonId)) {
            return false;
        }
        return !n.b(this.locale_taskId, other.locale_taskId) ? z4 : z;
    }

    public int hashCode() {
        return (this.locale_lessonId.hashCode() * 31) + this.locale_taskId.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonWithTask(locale_lessonId=";
        String str3 = ", locale_taskId=";
        str = str2 + this.locale_lessonId + str3 + this.locale_taskId + 41;
        return str;
    }
}
