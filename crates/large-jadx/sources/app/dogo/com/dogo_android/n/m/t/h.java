package app.dogo.com.dogo_android.n.m.t;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u001f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "", "dogId", "", "trickId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getTrickId", "BitingProgram", "ClassicProgram", "Library", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class h {

    private final String a;
    private final String b;
    private final int c;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "variationId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getVariationId", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.n.m.t.h {

        private final String d;
        public a(String string, int i2, String string3, String string4) {
            n.f(string, "dogId");
            n.f(string3, "trickId");
            n.f(string4, "variationId");
            super(string, string3, i2, 0);
            this.d = string4;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String d() {
            return this.d;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "programId", "moduleId", "lessonId", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.n.m.t.h {

        private final String d;
        private final String e;
        private final String f;
        public b(String string, int i2, String string3, String string4, String string5, String string6) {
            n.f(string, "dogId");
            n.f(string3, "trickId");
            n.f(string4, "programId");
            n.f(string5, "moduleId");
            n.f(string6, "lessonId");
            super(string, string3, i2, 0);
            this.d = string4;
            this.e = string5;
            this.f = string6;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String d() {
            return this.f;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String e() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.h
        public final String f() {
            return this.d;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "dogId", "", "knowledge", "", "trickId", "(Ljava/lang/String;ILjava/lang/String;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.n.m.t.h {
        public c(String string, int i2, String string3) {
            n.f(string, "dogId");
            n.f(string3, "trickId");
            super(string, string3, i2, 0);
        }
    }
    private h(String string, String string2, int i3) {
        super();
        this.a = string;
        this.b = string2;
        this.c = i3;
    }

    public h(String string, String string2, int i3, g g4) {
        super(string, string2, i3);
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }
}
