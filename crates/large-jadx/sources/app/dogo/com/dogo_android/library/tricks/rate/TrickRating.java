package app.dogo.com.dogo_android.n.m.t;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickRating.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u001f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "", "dogId", "", "trickId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getTrickId", "BitingProgram", "ClassicProgram", "Library", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public abstract /* sealed */ class TrickRating {

    /* renamed from: a, reason: from kotlin metadata */
    private final String dogId;
    private final String b;
    private final int c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "variationId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getVariationId", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends h {

        /* renamed from: d, reason: from kotlin metadata */
        private final String variationId;
        public a(String str, int i, String str2, String str3) {
            n.f(str, "dogId");
            n.f(str2, "trickId");
            n.f(str3, "variationId");
            super(str, str2, i, null);
            this.variationId = str3;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String d() {
            return this.variationId;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "programId", "moduleId", "lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends h {

        /* renamed from: d, reason: from kotlin metadata */
        private final String lessonId;
        /* renamed from: e, reason: from kotlin metadata */
        private final String moduleId;
        /* renamed from: f, reason: from kotlin metadata */
        private final String programId;
        public b(String str, int i, String str2, String str3, String str4, String str5) {
            n.f(str, "dogId");
            n.f(str2, "trickId");
            n.f(str3, "programId");
            n.f(str4, "moduleId");
            n.f(str5, "lessonId");
            super(str, str2, i, null);
            this.lessonId = str3;
            this.moduleId = str4;
            this.programId = str5;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String d() {
            return this.programId;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String e() {
            return this.moduleId;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String f() {
            return this.lessonId;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "(Ljava/lang/String;ILjava/lang/String;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends h {
        public c(String str, int i, String str2) {
            n.f(str, "dogId");
            n.f(str2, "trickId");
            super(str, str2, i, null);
        }
    }
    private h(String str, String str2, int i) {
        super();
        this.dogId = str;
        this.b = str2;
        this.c = i;
    }

    public final String a() {
        return this.dogId;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public /* synthetic */ h(String str, String str2, int i, g gVar) {
        this(str, str2, i);
    }
}
