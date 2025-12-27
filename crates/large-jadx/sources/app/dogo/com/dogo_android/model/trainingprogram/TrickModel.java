package app.dogo.com.dogo_android.model.trainingprogram;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: TrickModel.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00087\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0005OPQRSBÝ\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007¢\u0006\u0002\u0010\u001eJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000f\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u001aHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%Jæ\u0001\u0010I\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00072\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00072\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u000f2\u0008\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\rHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\"R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010(R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008-\u0010%R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010/R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\"R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010\"¨\u0006T", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "", "id", "", "name", "image", "trickSteps", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "category", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "examInstructions", "examTimeLimit", "", "isExam", "", "sortOrder", "tags", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "hasProgress", "videoId", "videoThumbnail", "videoSteps", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "description", "updatedAt", "", "locale", "variations", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVariation;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;)V", "getCategory", "()Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "getDescription", "()Ljava/lang/String;", "getExamInstructions", "getExamTimeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasProgress", "()Z", "getId", "getImage", "getLocale", "getName", "getSortOrder", "getTags", "()Ljava/util/List;", "getTrickSteps", "getUpdatedAt", "()J", "getVariations", "getVideoId", "getVideoSteps", "getVideoThumbnail", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;)Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "equals", "other", "hashCode", "toString", "TrickCategory", "TrickStep", "TrickTag", "TrickVariation", "TrickVideoStep", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickModel {

    private final TrickModel.TrickCategory category;
    private final String description;
    private final String examInstructions;
    private final Integer examTimeLimit;
    private final boolean hasProgress;
    private final String id;
    private final String image;
    private final boolean isExam;
    private final String locale;
    private final String name;
    private final Integer sortOrder;
    private final List<TrickModel.TrickTag> tags;
    private final List<TrickModel.TrickStep> trickSteps;
    private final long updatedAt;
    private final List<TrickModel.TrickVariation> variations;
    private final String videoId;
    private final List<TrickModel.TrickVideoStep> videoSteps;
    private final String videoThumbnail;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "", "id", "", "name", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickCategory {

        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public TrickCategory(String str, String str2, long j, String str3) {
            n.f(str, "id");
            n.f(str2, "name");
            n.f(str3, "locale");
            super();
            this.id = str;
            this.name = str2;
            this.updatedAt = j;
            this.locale = str3;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final String getName() {
            return this.name;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ TrickCategory(String str, String str2, long j, String str3, int i, g gVar) {
            String str22;
            int j32 = 0;
            str22 = "";
            gVar = i & 1 != 0 ? str22 : str;
            String r1 = i & 2 != 0 ? str22 : str2;
            j32 = i & 4 != 0 ? 0 : j32;
            i = i & 8 != 0 ? str22 : str3;
            this(str22, str22, j32, str3, (i & 8 != 0 ? str22 : str3));
        }

        public TrickCategory() {
            this(null, null, 0L, str, 0, 15, 0);
        }

        public static /* synthetic */ TrickModel.TrickCategory copy$default(TrickModel.TrickCategory trickCategory, String str, String str2, long j, String str3, int i, Object object) {
            String str22;
            String str32;
            long j42;
            String i62;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return trickCategory.copy(str22, str32, j42, i62);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.name;
        }

        /* operator */ public final long component3() {
            return this.updatedAt;
        }

        /* operator */ public final String component4() {
            return this.locale;
        }

        public final TrickModel.TrickCategory copy(String id, String name, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(name, "name");
            n.f(locale, "locale");
            TrickModel_TrickCategory trickModel_TrickCategory = new TrickModel_TrickCategory(id, name, updatedAt, str4, locale);
            return trickModel_TrickCategory;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof TrickModel_TrickCategory)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z5 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickCategory(id=";
            String str3 = ", name=";
            String str4 = ", updatedAt=";
            String str5 = ", locale=";
            str = str2 + this.id + str3 + this.name + str4 + this.updatedAt + str5 + this.locale + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "", "id", "", "image", "description", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getId", "getImage", "getLocale", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStep {

        private final String description;
        private final String id;
        private final String image;
        private final String locale;
        private final long updatedAt;
        public TrickStep(String str, String str2, String str3, long j, String str4) {
            n.f(str, "id");
            n.f(str2, "image");
            n.f(str3, "description");
            n.f(str4, "locale");
            super();
            this.id = str;
            this.image = str2;
            this.description = str3;
            this.updatedAt = j;
            this.locale = str4;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImage() {
            return this.image;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ TrickStep(String str, String str2, String str3, long j, String str4, int i, g gVar) {
            String str22;
            int j42 = 0;
            str22 = "";
            gVar = i & 1 != 0 ? str22 : str;
            String r1 = i & 2 != 0 ? str22 : str2;
            String r2 = i & 4 != 0 ? str22 : str3;
            j42 = i & 8 != 0 ? 0 : j42;
            i = i & 16 != 0 ? str22 : str4;
            this(str22, str22, str22, j42, str4, (i & 16 != 0 ? str22 : str4));
        }

        public TrickStep() {
            this(null, null, null, 0L, str, 0, 31, 0);
        }

        public static /* synthetic */ TrickModel.TrickStep copy$default(TrickModel.TrickStep trickStep, String str, String str2, String str3, long j, String str4, int i, Object object) {
            String str22;
            String str32;
            String str42;
            long j52;
            String i72;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            if (i & 16 != 0) {
            }
            return trickStep.copy(str22, str32, str42, j52, i72);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.image;
        }

        /* operator */ public final String component3() {
            return this.description;
        }

        /* operator */ public final long component4() {
            return this.updatedAt;
        }

        /* operator */ public final String component5() {
            return this.locale;
        }

        public final TrickModel.TrickStep copy(String id, String image, String description, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(image, "image");
            n.f(description, "description");
            n.f(locale, "locale");
            TrickModel_TrickStep trickModel_TrickStep = new TrickModel_TrickStep(id, image, description, updatedAt, str5, locale);
            return trickModel_TrickStep;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z6 = false;
            if (!(other instanceof TrickModel_TrickStep)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.image, other.image)) {
                return false;
            }
            if (!n.b(this.description, other.description)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z6 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.image.hashCode() * 31 + this.description.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickStep(id=";
            String str3 = ", image=";
            String str4 = ", description=";
            String str5 = ", updatedAt=";
            String str6 = ", locale=";
            str = str2 + this.id + str3 + this.image + str4 + this.description + str5 + this.updatedAt + str6 + this.locale + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "", "id", "", "name", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickTag {

        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public TrickTag(String str, String str2, long j, String str3) {
            n.f(str, "id");
            n.f(str2, "name");
            n.f(str3, "locale");
            super();
            this.id = str;
            this.name = str2;
            this.updatedAt = j;
            this.locale = str3;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final String getName() {
            return this.name;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ TrickTag(String str, String str2, long j, String str3, int i, g gVar) {
            String str22;
            int j32 = 0;
            str22 = "";
            gVar = i & 1 != 0 ? str22 : str;
            String r1 = i & 2 != 0 ? str22 : str2;
            j32 = i & 4 != 0 ? 0 : j32;
            i = i & 8 != 0 ? str22 : str3;
            this(str22, str22, j32, str3, (i & 8 != 0 ? str22 : str3));
        }

        public TrickTag() {
            this(null, null, 0L, str, 0, 15, 0);
        }

        public static /* synthetic */ TrickModel.TrickTag copy$default(TrickModel.TrickTag trickTag, String str, String str2, long j, String str3, int i, Object object) {
            String str22;
            String str32;
            long j42;
            String i62;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            if (i & 8 != 0) {
            }
            return trickTag.copy(str22, str32, j42, i62);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.name;
        }

        /* operator */ public final long component3() {
            return this.updatedAt;
        }

        /* operator */ public final String component4() {
            return this.locale;
        }

        public final TrickModel.TrickTag copy(String id, String name, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(name, "name");
            n.f(locale, "locale");
            TrickModel_TrickTag trickModel_TrickTag = new TrickModel_TrickTag(id, name, updatedAt, str4, locale);
            return trickModel_TrickTag;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof TrickModel_TrickTag)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z5 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickTag(id=";
            String str3 = ", name=";
            String str4 = ", updatedAt=";
            String str5 = ", locale=";
            str = str2 + this.id + str3 + this.name + str4 + this.updatedAt + str5 + this.locale + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0014\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BQ\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000f\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JU\u0010\u001e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0008\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000eR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVariation;", "", "tips", "", "", "id", "title", "description", "locale", "contentfulId", "updatedAt", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getContentfulId", "()Ljava/lang/String;", "getDescription", "getId", "getLocale", "getTips", "()Ljava/util/List;", "getTitle", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVariation {

        private final String contentfulId;
        private final String description;
        private final String id;
        private final String locale;
        private final List<String> tips;
        private final String title;
        private final long updatedAt;
        public TrickVariation(List<String> list, String str, String str2, String str3, String str4, String str5, long j) {
            n.f(list, "tips");
            n.f(str, "id");
            n.f(str2, "title");
            n.f(str3, "description");
            n.f(str4, "locale");
            n.f(str5, "contentfulId");
            super();
            this.tips = list;
            this.id = str;
            this.title = str2;
            this.description = str3;
            this.locale = str4;
            this.contentfulId = str5;
            this.updatedAt = j;
        }

        public final String getContentfulId() {
            return this.contentfulId;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final List<String> getTips() {
            return this.tips;
        }

        public final String getTitle() {
            return this.title;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ TrickVariation(List list, String str, String str2, String str3, String str4, String str5, long j, int i, g gVar) {
            List list2;
            String str22;
            int j72 = 0;
            if (i & 1 != 0) {
                list2 = p.g();
            } else {
                list2 = list;
            }
            str22 = "";
            String r1 = i & 2 != 0 ? str22 : str;
            String r3 = i & 4 != 0 ? str22 : str2;
            String r4 = i & 8 != 0 ? str22 : str3;
            String r5 = i & 16 != 0 ? str22 : str4;
            if (i & 32 == 0) {
                str22 = str5;
            }
            int r6 = i & 64 != 0 ? 0 : j;
            this(list2, str22, str22, str22, str22, str22, (i & 64 != 0 ? 0 : j), i);
        }

        public TrickVariation() {
            this(null, null, null, null, null, null, 0L, i8, 127, 0);
        }

        public static /* synthetic */ TrickModel.TrickVariation copy$default(TrickModel.TrickVariation trickVariation, List list, String str, String str2, String str3, String str4, String str5, long j, int i, Object object) {
            List list22;
            String str32;
            String str42;
            String str52;
            String str62;
            String str72;
            long j82;
            Object trickVariation2 = trickVariation;
            List r1 = i & 1 != 0 ? trickVariation2.tips : list;
            String r2 = i & 2 != 0 ? trickVariation2.id : str;
            String r3 = i & 4 != 0 ? trickVariation2.title : str2;
            String r4 = i & 8 != 0 ? trickVariation2.description : str3;
            String r5 = i & 16 != 0 ? trickVariation2.locale : str4;
            String r6 = i & 32 != 0 ? trickVariation2.contentfulId : str5;
            long r7 = i & 64 != 0 ? trickVariation2.updatedAt : j;
            return trickVariation.copy(list22, str32, str42, str52, str62, str72, (i & 64 != 0 ? trickVariation2.updatedAt : j), r17);
        }

        /* operator */ public final List<String> component1() {
            return this.tips;
        }

        /* operator */ public final String component2() {
            return this.id;
        }

        /* operator */ public final String component3() {
            return this.title;
        }

        /* operator */ public final String component4() {
            return this.description;
        }

        /* operator */ public final String component5() {
            return this.locale;
        }

        /* operator */ public final String component6() {
            return this.contentfulId;
        }

        /* operator */ public final long component7() {
            return this.updatedAt;
        }

        public final TrickModel.TrickVariation copy(List<String> tips, String id, String title, String description, String locale, String contentfulId, long updatedAt) {
            n.f(tips, "tips");
            n.f(id, "id");
            n.f(title, "title");
            n.f(description, "description");
            n.f(locale, "locale");
            final Object contentfulId2 = contentfulId;
            n.f(contentfulId2, "contentfulId");
            TrickModel_TrickVariation trickModel_TrickVariation = new TrickModel_TrickVariation(tips, id, title, description, locale, contentfulId2, updatedAt, obj);
            return trickModel_TrickVariation;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z9 = false;
            if (!(other instanceof TrickModel_TrickVariation)) {
                return false;
            }
            if (!n.b(this.tips, other.tips)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.title, other.title)) {
                return false;
            }
            if (!n.b(this.description, other.description)) {
                return false;
            }
            if (!n.b(this.locale, other.locale)) {
                return false;
            }
            if (!n.b(this.contentfulId, other.contentfulId)) {
                return false;
            }
            return this.updatedAt != other.updatedAt ? z9 : z;
        }

        public int hashCode() {
            return (this.tips.hashCode() * 31) + this.id.hashCode() * 31 + this.title.hashCode() * 31 + this.description.hashCode() * 31 + this.locale.hashCode() * 31 + this.contentfulId.hashCode() * 31 + Long.hashCode(this.updatedAt);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickVariation(tips=";
            String str3 = ", id=";
            String str4 = ", title=";
            String str5 = ", description=";
            String str6 = ", locale=";
            String str7 = ", contentfulId=";
            String str8 = ", updatedAt=";
            str = str2 + this.tips + str3 + this.id + str4 + this.title + str5 + this.description + str6 + this.locale + str7 + this.contentfulId + str8 + this.updatedAt + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "", "id", "", "text", "startTime", "", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getStartTime", "()I", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVideoStep {

        private final String id;
        private final String locale;
        private final int startTime;
        private final String text;
        private final long updatedAt;
        public TrickVideoStep(String str, String str2, int i, long j, String str3) {
            n.f(str, "id");
            n.f(str2, "text");
            n.f(str3, "locale");
            super();
            this.id = str;
            this.text = str2;
            this.startTime = i;
            this.updatedAt = j;
            this.locale = str3;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final int getStartTime() {
            return this.startTime;
        }

        public final String getText() {
            return this.text;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public /* synthetic */ TrickVideoStep(String str, String str2, int i, long j, String str3, int i2, g gVar) {
            String str22;
            int i32 = 0;
            int j42 = 0;
            str22 = "";
            gVar = i2 & 1 != 0 ? str22 : str;
            String r1 = i2 & 2 != 0 ? str22 : str2;
            i32 = i2 & 4 != 0 ? 0 : i32;
            j42 = i2 & 8 != 0 ? 0 : j42;
            i2 = i2 & 16 != 0 ? str22 : str3;
            this(str22, str22, i32, j42, str3, (i2 & 16 != 0 ? str22 : str3));
        }

        public TrickVideoStep() {
            this(null, null, 0, 0L, str, 0, 31, 0);
        }

        public static /* synthetic */ TrickModel.TrickVideoStep copy$default(TrickModel.TrickVideoStep trickVideoStep, String str, String str2, int i, long j, String str3, int i2, Object object) {
            String str22;
            String str32;
            int i42;
            long j52;
            String i72;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            if (i2 & 8 != 0) {
            }
            if (i2 & 16 != 0) {
            }
            return trickVideoStep.copy(str22, str32, i42, j52, i72);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.text;
        }

        /* operator */ public final int component3() {
            return this.startTime;
        }

        /* operator */ public final long component4() {
            return this.updatedAt;
        }

        /* operator */ public final String component5() {
            return this.locale;
        }

        public final TrickModel.TrickVideoStep copy(String id, String text, int startTime, long updatedAt, String locale) {
            n.f(id, "id");
            n.f(text, "text");
            n.f(locale, "locale");
            TrickModel_TrickVideoStep trickModel_TrickVideoStep = new TrickModel_TrickVideoStep(id, text, startTime, updatedAt, str4, locale);
            return trickModel_TrickVideoStep;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z5 = false;
            if (!(other instanceof TrickModel_TrickVideoStep)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.text, other.text)) {
                return false;
            }
            if (this.startTime != other.startTime) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            return !n.b(this.locale, other.locale) ? z5 : z;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.text.hashCode() * 31 + Integer.hashCode(this.startTime) * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "TrickVideoStep(id=";
            String str3 = ", text=";
            String str4 = ", startTime=";
            String str5 = ", updatedAt=";
            String str6 = ", locale=";
            str = str2 + this.id + str3 + this.text + str4 + this.startTime + str5 + this.updatedAt + str6 + this.locale + 41;
            return str;
        }
    }
    public TrickModel(String str, String str2, String str3, List<TrickModel.TrickStep> list, TrickModel.TrickCategory trickCategory, String str4, Integer integer, boolean z, Integer integer2, List<TrickModel.TrickTag> list2, boolean z2, String str5, String str6, List<TrickModel.TrickVideoStep> list3, String str7, long j, String str8, List<TrickModel.TrickVariation> list4) {
        final Object str52 = this;
        final Object trickCategory52 = trickCategory;
        final Object list102 = list2;
        final Object list142 = list3;
        final Object list182 = str8;
        final Object obj = list4;
        n.f(str, "id");
        n.f(str2, "name");
        n.f(str3, "image");
        n.f(list, "trickSteps");
        n.f(trickCategory52, "category");
        n.f(list102, "tags");
        n.f(list142, "videoSteps");
        n.f(list182, "locale");
        n.f(obj, "variations");
        super();
        str52.id = str;
        str52.name = str2;
        str52.image = str3;
        str52.trickSteps = list;
        str52.category = trickCategory52;
        str52.examInstructions = str4;
        str52.examTimeLimit = integer;
        str52.isExam = z;
        str52.sortOrder = integer2;
        str52.tags = list102;
        str52.hasProgress = z2;
        str52.videoId = str5;
        str52.videoThumbnail = str6;
        str52.videoSteps = list142;
        str52.description = str7;
        str52.updatedAt = j;
        str52.locale = list182;
        str52.variations = obj;
    }

    public final TrickModel.TrickCategory getCategory() {
        return this.category;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExamInstructions() {
        return this.examInstructions;
    }

    public final Integer getExamTimeLimit() {
        return this.examTimeLimit;
    }

    public final boolean getHasProgress() {
        return this.hasProgress;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final List<TrickModel.TrickTag> getTags() {
        return this.tags;
    }

    public final List<TrickModel.TrickStep> getTrickSteps() {
        return this.trickSteps;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<TrickModel.TrickVariation> getVariations() {
        return this.variations;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final List<TrickModel.TrickVideoStep> getVideoSteps() {
        return this.videoSteps;
    }

    public final String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public final boolean isExam() {
        return this.isExam;
    }

    public /* synthetic */ TrickModel(String str, String str2, String str3, List list, TrickModel.TrickCategory trickCategory, String str4, Integer integer, boolean z, Integer integer2, List list2, boolean z2, String str5, String str6, List list3, String str7, long j, String str8, List list4, int i, g gVar) {
        List i192;
        int str152 = 0;
        List list42;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickCategory52;
        int str62 = 0;
        List list142;
        int integer72 = 0;
        int z82;
        int integer92 = 0;
        List list102;
        int str122 = 0;
        int str132 = 0;
        int j162 = 0;
        int gVar202 = i;
        str4 = "";
        String r1 = gVar202 & 1 != 0 ? str4 : str;
        String r3 = gVar202 & 2 != 0 ? str4 : str2;
        String r4 = gVar202 & 4 != 0 ? str4 : str3;
        if (gVar202 & 8 != 0) {
            list42 = p.g();
        } else {
            list42 = list;
        }
        if (gVar202 & 16 != 0) {
            str5 = null;
            str7 = null;
            long l = 0L;
            i = 0;
            gVar = 15;
            int i2 = 0;
            super(str5, str7, l, str8, i, gVar, i2);
        } else {
            trickCategory52 = trickCategory;
        }
        int r7 = gVar202 & 32 != 0 ? 0 : str4;
        int r9 = gVar202 & 64 != 0 ? 0 : integer;
        z82 = 0;
        int r10 = gVar202 & 128 != 0 ? 0 : z;
        int r12 = gVar202 & 256 != 0 ? 0 : integer2;
        if (gVar202 & 512 != 0) {
            list102 = p.g();
        } else {
            list102 = list2;
        }
        if (gVar202 & 1024 == 0) {
            z82 = z2;
        }
        int r14 = gVar202 & 2048 != 0 ? 0 : str5;
        int r15 = gVar202 & 4096 != 0 ? 0 : str6;
        if (gVar202 & 8192 != 0) {
            list142 = p.g();
        } else {
            list142 = list3;
        }
        int r2 = gVar202 & 16384 != 0 ? 0 : str7;
        int r16 = gVar202 & 32768 != 0 ? 0 : j;
        String r18 = gVar202 & 65536 != 0 ? str4 : str8;
        if (gVar202 & 131072 != 0) {
            i192 = p.g();
        } else {
            i192 = list4;
        }
        this(str4, str4, str4, list42, trickCategory52, str62, integer72, z82, integer92, list102, z82, str122, str132, list142, str152, j162, str8, str4, i192);
    }

    public TrickModel() {
        this(null, null, null, null, null, null, null, false, null, null, false, null, null, null, null, 0L, str, null, 0, 262143, 0);
    }

    public static /* synthetic */ TrickModel copy$default(TrickModel trickModel, String str, String str2, String str3, List list, TrickModel.TrickCategory trickCategory, String str4, Integer integer, boolean z, Integer integer2, List list2, boolean z2, String str5, String str6, List list3, String str7, long j, String str8, List list4, int i, Object object) {
        List i202;
        String str22;
        String str32;
        String str42;
        List list52;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickCategory62;
        String str72;
        Integer integer82;
        boolean z92;
        Integer integer102;
        List list112;
        boolean z122;
        String str132;
        String str142;
        long j172;
        String list192;
        List list152;
        String str162;
        Object trickModel2 = trickModel;
        int object212 = i;
        String r2 = object212 & 1 != 0 ? trickModel2.id : str;
        String r3 = object212 & 2 != 0 ? trickModel2.name : str2;
        String r4 = object212 & 4 != 0 ? trickModel2.image : str3;
        List r5 = object212 & 8 != 0 ? trickModel2.trickSteps : list;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory r6 = object212 & 16 != 0 ? trickModel2.category : trickCategory;
        String r7 = object212 & 32 != 0 ? trickModel2.examInstructions : str4;
        Integer r8 = object212 & 64 != 0 ? trickModel2.examTimeLimit : integer;
        boolean r9 = object212 & 128 != 0 ? trickModel2.isExam : z;
        Integer r10 = object212 & 256 != 0 ? trickModel2.sortOrder : integer2;
        List r11 = object212 & 512 != 0 ? trickModel2.tags : list2;
        boolean r12 = object212 & 1024 != 0 ? trickModel2.hasProgress : z2;
        String r13 = object212 & 2048 != 0 ? trickModel2.videoId : str5;
        String r14 = object212 & 4096 != 0 ? trickModel2.videoThumbnail : str6;
        List r15 = object212 & 8192 != 0 ? trickModel2.videoSteps : list3;
        r15 = object212 & 16384 != 0 ? trickModel2.description : str7;
        r14 = object212 & 32768 != 0 ? trickModel2.updatedAt : j;
        r14 = object212 & 65536 != 0 ? trickModel2.locale : str8;
        List r1 = object212 & 131072 != 0 ? trickModel2.variations : list4;
        return trickModel.copy(str22, str32, str42, list52, trickCategory62, str72, integer82, z92, integer102, list112, z122, str132, str142, (object212 & 8192 != 0 ? trickModel2.videoSteps : list3), (object212 & 16384 != 0 ? trickModel2.description : str7), (object212 & 32768 != 0 ? trickModel2.updatedAt : j), r34, list192, (object212 & 131072 != 0 ? trickModel2.variations : list4));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final List<TrickModel.TrickTag> component10() {
        return this.tags;
    }

    /* operator */ public final boolean component11() {
        return this.hasProgress;
    }

    /* operator */ public final String component12() {
        return this.videoId;
    }

    /* operator */ public final String component13() {
        return this.videoThumbnail;
    }

    /* operator */ public final List<TrickModel.TrickVideoStep> component14() {
        return this.videoSteps;
    }

    /* operator */ public final String component15() {
        return this.description;
    }

    /* operator */ public final long component16() {
        return this.updatedAt;
    }

    /* operator */ public final String component17() {
        return this.locale;
    }

    /* operator */ public final List<TrickModel.TrickVariation> component18() {
        return this.variations;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.image;
    }

    /* operator */ public final List<TrickModel.TrickStep> component4() {
        return this.trickSteps;
    }

    /* operator */ public final TrickModel.TrickCategory component5() {
        return this.category;
    }

    /* operator */ public final String component6() {
        return this.examInstructions;
    }

    /* operator */ public final Integer component7() {
        return this.examTimeLimit;
    }

    /* operator */ public final boolean component8() {
        return this.isExam;
    }

    /* operator */ public final Integer component9() {
        return this.sortOrder;
    }

    public final TrickModel copy(String id, String name, String image, List<TrickModel.TrickStep> trickSteps, TrickModel.TrickCategory category, String examInstructions, Integer examTimeLimit, boolean isExam, Integer sortOrder, List<TrickModel.TrickTag> tags, boolean hasProgress, String videoId, String videoThumbnail, List<TrickModel.TrickVideoStep> videoSteps, String description, long updatedAt, String locale, List<TrickModel.TrickVariation> variations) {
        Object id2 = id;
        n.f(id2, "id");
        n.f(name, "name");
        n.f(image, "image");
        n.f(trickSteps, "trickSteps");
        n.f(category, "category");
        n.f(tags, "tags");
        n.f(videoSteps, "videoSteps");
        n.f(locale, "locale");
        n.f(variations, "variations");
        TrickModel trickModel = new TrickModel(id2, name, image, trickSteps, category, examInstructions, examTimeLimit, isExam, sortOrder, tags, hasProgress, videoId, videoThumbnail, videoSteps, description, updatedAt, str11, locale, variations);
        return trickModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z17 = false;
        if (!(other instanceof TrickModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.trickSteps, other.trickSteps)) {
            return false;
        }
        if (!n.b(this.category, other.category)) {
            return false;
        }
        if (!n.b(this.examInstructions, other.examInstructions)) {
            return false;
        }
        if (!n.b(this.examTimeLimit, other.examTimeLimit)) {
            return false;
        }
        if (this.isExam != other.isExam) {
            return false;
        }
        if (!n.b(this.sortOrder, other.sortOrder)) {
            return false;
        }
        if (!n.b(this.tags, other.tags)) {
            return false;
        }
        if (this.hasProgress != other.hasProgress) {
            return false;
        }
        if (!n.b(this.videoId, other.videoId)) {
            return false;
        }
        if (!n.b(this.videoThumbnail, other.videoThumbnail)) {
            return false;
        }
        if (!n.b(this.videoSteps, other.videoSteps)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        return !n.b(this.variations, other.variations) ? z17 : z;
    }

    public int hashCode() {
        int i;
        boolean isExam2;
        int i2 = 1;
        i = 0;
        if (this.examInstructions == null) {
        } else {
            i = this.examInstructions.hashCode();
        }
        if (this.examTimeLimit == null) {
        } else {
            i = this.examTimeLimit.hashCode();
        }
        i2 = 1;
        if (this.isExam) {
        }
        if (this.sortOrder == null) {
        } else {
            i = this.sortOrder.hashCode();
        }
        if (!(this.hasProgress)) {
        }
        if (this.videoId == null) {
        } else {
            i = this.videoId.hashCode();
        }
        if (this.videoThumbnail == null) {
        } else {
            i = this.videoThumbnail.hashCode();
        }
        if (this.description != null) {
            i = this.description.hashCode();
        }
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.image.hashCode() * 31 + this.trickSteps.hashCode() * 31 + this.category.hashCode() * 31 + i * 31 + i * 31 + isExam2 * 31 + i * 31 + this.tags.hashCode() * 31 + i2 * 31 + i * 31 + i * 31 + this.videoSteps.hashCode() * 31 + i * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale.hashCode() * 31 + this.variations.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickModel(id=";
        String str3 = ", name=";
        String str4 = ", image=";
        String str5 = ", trickSteps=";
        String str6 = ", category=";
        String str7 = ", examInstructions=";
        String str8 = ", examTimeLimit=";
        String str9 = ", isExam=";
        String str10 = ", sortOrder=";
        String str11 = ", tags=";
        String str12 = ", hasProgress=";
        String str13 = ", videoId=";
        String str14 = ", videoThumbnail=";
        String str15 = ", videoSteps=";
        String str16 = ", description=";
        String str17 = ", updatedAt=";
        String str18 = ", locale=";
        String str19 = ", variations=";
        str = str2 + this.id + str3 + this.name + str4 + this.image + str5 + this.trickSteps + str6 + this.category + str7 + this.examInstructions + str8 + this.examTimeLimit + str9 + this.isExam + str10 + this.sortOrder + str11 + this.tags + str12 + this.hasProgress + str13 + this.videoId + str14 + this.videoThumbnail + str15 + this.videoSteps + str16 + this.description + str17 + this.updatedAt + str18 + this.locale + str19 + this.variations + 41;
        return str;
    }
}
