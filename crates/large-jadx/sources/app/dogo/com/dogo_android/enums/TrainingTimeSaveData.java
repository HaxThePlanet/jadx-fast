package app.dogo.com.dogo_android.k;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrainingTimeSaveData.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0005\u0007\u0008\t\n\u000bB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0005\u000c\r\u000e\u000f\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "", "durationSec", "", "(I)V", "getDurationSec", "()I", "LibraryTrickSaveData", "LibraryTrickVariationSaveData", "ProgramTrickSaveData", "ProgramVariationSaveData", "WorkoutSaveData", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s, reason: from kotlin metadata */
public abstract /* sealed */ class TrainingTimeSaveData {

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "(ILjava/lang/String;)V", "getDurationSec", "()I", "getTrickId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends s {

        /* renamed from: a, reason: from kotlin metadata */
        private final int durationSec;
        /* renamed from: b, reason: from kotlin metadata */
        private final String trickId;
        public a(int i, String str) {
            n.f(str, "trickId");
            super(i, null);
            this.durationSec = i;
            this.trickId = str;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public int component1() {
            return this.durationSec;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.trickId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof TrainingTimeSaveData_LibraryTrickSaveData)) {
                return false;
            }
            if (component1() != other.component1()) {
                return false;
            }
            return !n.b(this.trickId, other.trickId) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return (Integer.hashCode(component1()) * 31) + this.trickId.hashCode();
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LibraryTrickSaveData(durationSec=";
            int component1 = component1();
            String str3 = ", trickId=";
            str = str2 + component1 + str3 + this.trickId + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$LibraryTrickVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "variationId", "(ILjava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends s {

        /* renamed from: a, reason: from kotlin metadata */
        private final int durationSec;
        /* renamed from: b, reason: from kotlin metadata */
        private final String trickId;
        /* renamed from: c, reason: from kotlin metadata */
        private final String variationId;
        public b(int i, String str, String str2) {
            n.f(str, "trickId");
            n.f(str2, "variationId");
            super(i, null);
            this.durationSec = i;
            this.trickId = str;
            this.variationId = str2;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public int component1() {
            return this.durationSec;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.trickId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.variationId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof TrainingTimeSaveData_LibraryTrickVariationSaveData)) {
                return false;
            }
            if (component1() != other.component1()) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            return !n.b(this.variationId, other.variationId) ? z4 : z;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return (Integer.hashCode(component1()) * 31) + this.trickId.hashCode() * 31 + this.variationId.hashCode();
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "LibraryTrickVariationSaveData(durationSec=";
            int component1 = component1();
            String str3 = ", trickId=";
            String str4 = ", variationId=";
            str = str2 + component1 + str3 + this.trickId + str4 + this.variationId + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\r¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramTrickSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "programId", "moduleId", "lessonId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends s {

        /* renamed from: a, reason: from kotlin metadata */
        private final int durationSec;
        /* renamed from: b, reason: from kotlin metadata */
        private final String lessonId;
        /* renamed from: c, reason: from kotlin metadata */
        private final String moduleId;
        /* renamed from: d, reason: from kotlin metadata */
        private final String programId;
        /* renamed from: e, reason: from kotlin metadata */
        private final String trickId;
        public c(int i, String str, String str2, String str3, String str4) {
            n.f(str, "trickId");
            n.f(str2, "programId");
            n.f(str3, "moduleId");
            n.f(str4, "lessonId");
            super(i, null);
            this.durationSec = i;
            this.lessonId = str;
            this.moduleId = str2;
            this.programId = str3;
            this.trickId = str4;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public int component1() {
            return this.durationSec;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.trickId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.programId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String d() {
            return this.moduleId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String e() {
            return this.lessonId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z6 = false;
            if (!(other instanceof TrainingTimeSaveData_ProgramTrickSaveData)) {
                return false;
            }
            if (component1() != other.component1()) {
                return false;
            }
            if (!n.b(this.lessonId, other.lessonId)) {
                return false;
            }
            if (!n.b(this.moduleId, other.moduleId)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            return !n.b(this.trickId, other.trickId) ? z6 : z;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return (Integer.hashCode(component1()) * 31) + this.lessonId.hashCode() * 31 + this.moduleId.hashCode() * 31 + this.programId.hashCode() * 31 + this.trickId.hashCode();
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramTrickSaveData(durationSec=";
            int component1 = component1();
            String str3 = ", trickId=";
            String str4 = ", programId=";
            String str5 = ", moduleId=";
            String str6 = ", lessonId=";
            str = str2 + component1 + str3 + this.lessonId + str4 + this.moduleId + str5 + this.programId + str6 + this.trickId + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000e¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$ProgramVariationSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "trickId", "", "programId", "variationId", "moduleId", "lessonId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDurationSec", "()I", "getLessonId", "()Ljava/lang/String;", "getModuleId", "getProgramId", "getTrickId", "getVariationId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends s {

        /* renamed from: a, reason: from kotlin metadata */
        private final int durationSec;
        /* renamed from: b, reason: from kotlin metadata */
        private final String lessonId;
        /* renamed from: c, reason: from kotlin metadata */
        private final String moduleId;
        /* renamed from: d, reason: from kotlin metadata */
        private final String programId;
        /* renamed from: e, reason: from kotlin metadata */
        private final String trickId;
        /* renamed from: f, reason: from kotlin metadata */
        private final String variationId;
        public d(int i, String str, String str2, String str3, String str4, String str5) {
            n.f(str, "trickId");
            n.f(str2, "programId");
            n.f(str3, "variationId");
            n.f(str4, "moduleId");
            n.f(str5, "lessonId");
            super(i, null);
            this.durationSec = i;
            this.lessonId = str;
            this.moduleId = str2;
            this.programId = str3;
            this.trickId = str4;
            this.variationId = str5;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public int component1() {
            return this.durationSec;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String b() {
            return this.variationId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String c() {
            return this.trickId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String d() {
            return this.moduleId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String e() {
            return this.lessonId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public final String f() {
            return this.programId;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z7 = false;
            if (!(other instanceof TrainingTimeSaveData_ProgramVariationSaveData)) {
                return false;
            }
            if (component1() != other.component1()) {
                return false;
            }
            if (!n.b(this.lessonId, other.lessonId)) {
                return false;
            }
            if (!n.b(this.moduleId, other.moduleId)) {
                return false;
            }
            if (!n.b(this.programId, other.programId)) {
                return false;
            }
            if (!n.b(this.trickId, other.trickId)) {
                return false;
            }
            return !n.b(this.variationId, other.variationId) ? z7 : z;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return (Integer.hashCode(component1()) * 31) + this.lessonId.hashCode() * 31 + this.moduleId.hashCode() * 31 + this.programId.hashCode() * 31 + this.trickId.hashCode() * 31 + this.variationId.hashCode();
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramVariationSaveData(durationSec=";
            int component1 = component1();
            String str3 = ", trickId=";
            String str4 = ", programId=";
            String str5 = ", variationId=";
            String str6 = ", moduleId=";
            String str7 = ", lessonId=";
            str = str2 + component1 + str3 + this.lessonId + str4 + this.moduleId + str5 + this.programId + str6 + this.trickId + str7 + this.variationId + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData$WorkoutSaveData;", "Lapp/dogo/com/dogo_android/enums/TrainingTimeSaveData;", "durationSec", "", "(I)V", "getDurationSec", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e extends s {

        /* renamed from: a, reason: from kotlin metadata */
        private final int durationSec;
        public e(int i) {
            super(i, null);
            this.durationSec = i;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* renamed from: a, reason: from kotlin metadata */
        /* operator */ public int component1() {
            return this.durationSec;
        }

        @Override // app.dogo.com.dogo_android.k.s
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof TrainingTimeSaveData_WorkoutSaveData)) {
                return false;
            }
            return component1() != other.component1() ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.k.s
        public int hashCode() {
            return Integer.hashCode(component1());
        }

        @Override // app.dogo.com.dogo_android.k.s
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "WorkoutSaveData(durationSec=";
            int component1 = component1();
            str = str2 + component1 + 41;
            return str;
        }
    }
    private s(int i) {
        super();
    }

    public /* synthetic */ s(int i, g gVar) {
        this(i);
    }
}
