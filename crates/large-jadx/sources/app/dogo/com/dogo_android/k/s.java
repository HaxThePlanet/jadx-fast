package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0005\u0007\u0008\t\n\u000bB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0005\u000c\r\u000e\u000f\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "", "durationSec", "", "(I)V", "getDurationSec", "()I", "LibraryTrickSaveData", "LibraryTrickVariationSaveData", "ProgramTrickSaveData", "ProgramVariationSaveData", "WorkoutSaveData", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class s {

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "(ILjava/lang/String;)V", "getDurationSec", "()I", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.k.s {

        private final int a;
        private final String b;
        public a(int i, String string2) {
            n.f(string2, "trickId");
            super(i, 0);
            this.a = i;
            this.b = string2;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int a() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s.a) {
                return i3;
            }
            if (a() != (s.a)object.a()) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return i3 += i5;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LibraryTrickSaveData(durationSec=");
            stringBuilder.append(a());
            stringBuilder.append(", trickId=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "variationId", "(ILjava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.k.s {

        private final int a;
        private final String b;
        private final String c;
        public b(int i, String string2, String string3) {
            n.f(string2, "trickId");
            n.f(string3, "variationId");
            super(i, 0);
            this.a = i;
            this.b = string2;
            this.c = string3;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int a() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s.b) {
                return i3;
            }
            if (a() != (s.b)object.a()) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            if (!n.b(this.c, object.c)) {
                return i3;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return i5 += i8;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LibraryTrickVariationSaveData(durationSec=");
            stringBuilder.append(a());
            stringBuilder.append(", trickId=");
            stringBuilder.append(this.b);
            stringBuilder.append(", variationId=");
            stringBuilder.append(this.c);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "programId", "moduleId", "lessonId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.k.s {

        private final int a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        public c(int i, String string2, String string3, String string4, String string5) {
            n.f(string2, "trickId");
            n.f(string3, "programId");
            n.f(string4, "moduleId");
            n.f(string5, "lessonId");
            super(i, 0);
            this.a = i;
            this.b = string2;
            this.c = string3;
            this.d = string4;
            this.e = string5;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int a() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String d() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String e() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s.c) {
                return i3;
            }
            if (a() != (s.c)object.a()) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            if (!n.b(this.c, object.c)) {
                return i3;
            }
            if (!n.b(this.d, object.d)) {
                return i3;
            }
            if (!n.b(this.e, object.e)) {
                return i3;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return i9 += i14;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramTrickSaveData(durationSec=");
            stringBuilder.append(a());
            stringBuilder.append(", trickId=");
            stringBuilder.append(this.b);
            stringBuilder.append(", programId=");
            stringBuilder.append(this.c);
            stringBuilder.append(", moduleId=");
            stringBuilder.append(this.d);
            stringBuilder.append(", lessonId=");
            stringBuilder.append(this.e);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "programId", "variationId", "moduleId", "lessonId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "getVariationId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends app.dogo.com.dogo_android.k.s {

        private final int a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        public d(int i, String string2, String string3, String string4, String string5, String string6) {
            n.f(string2, "trickId");
            n.f(string3, "programId");
            n.f(string4, "variationId");
            n.f(string5, "moduleId");
            n.f(string6, "lessonId");
            super(i, 0);
            this.a = i;
            this.b = string2;
            this.c = string3;
            this.d = string4;
            this.e = string5;
            this.f = string6;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int a() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.f;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.e;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String d() {
            return this.c;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String e() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s.d) {
                return i3;
            }
            if (a() != (s.d)object.a()) {
                return i3;
            }
            if (!n.b(this.b, object.b)) {
                return i3;
            }
            if (!n.b(this.c, object.c)) {
                return i3;
            }
            if (!n.b(this.d, object.d)) {
                return i3;
            }
            if (!n.b(this.e, object.e)) {
                return i3;
            }
            if (!n.b(this.f, object.f)) {
                return i3;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String f() {
            return this.d;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return i11 += i17;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramVariationSaveData(durationSec=");
            stringBuilder.append(a());
            stringBuilder.append(", trickId=");
            stringBuilder.append(this.b);
            stringBuilder.append(", programId=");
            stringBuilder.append(this.c);
            stringBuilder.append(", variationId=");
            stringBuilder.append(this.d);
            stringBuilder.append(", moduleId=");
            stringBuilder.append(this.e);
            stringBuilder.append(", lessonId=");
            stringBuilder.append(this.f);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "(I)V", "getDurationSec", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends app.dogo.com.dogo_android.k.s {

        private final int a;
        public e(int i) {
            super(i, 0);
            this.a = i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int a() {
            return this.a;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof s.e) {
                return i3;
            }
            if (a() != (s.e)object.a()) {
                return i3;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return Integer.hashCode(a());
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WorkoutSaveData(durationSec=");
            stringBuilder.append(a());
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    private s(int i) {
        super();
    }

    public s(int i, g g2) {
        super(i);
    }
}
