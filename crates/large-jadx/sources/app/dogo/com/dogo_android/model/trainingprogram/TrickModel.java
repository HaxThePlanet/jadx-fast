package app.dogo.com.dogo_android.model.trainingprogram;

import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u00087\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0005OPQRSBÝ\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000f\u0012\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007\u0012\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007¢\u0006\u0002\u0010\u001eJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000f\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u001aHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007HÆ\u0003J\t\u0010D\u001a\u00020\nHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010%Jæ\u0001\u0010I\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\u000e\u0008\u0002\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00072\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00072\n\u0008\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u000f2\u0008\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\rHÖ\u0001J\t\u0010N\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010 R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\"R\u0015\u0010\u000c\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008$\u0010%R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\"R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010(R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010&\u001a\u0004\u0008-\u0010%R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u0017\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010/R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0017\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010/R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\"R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010\"¨\u0006T", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "", "id", "", "name", "image", "trickSteps", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "category", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "examInstructions", "examTimeLimit", "", "isExam", "", "sortOrder", "tags", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "hasProgress", "videoId", "videoThumbnail", "videoSteps", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "description", "updatedAt", "", "locale", "variations", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVariation;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;)V", "getCategory", "()Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "getDescription", "()Ljava/lang/String;", "getExamInstructions", "getExamTimeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasProgress", "()Z", "getId", "getImage", "getLocale", "getName", "getSortOrder", "getTags", "()Ljava/util/List;", "getTrickSteps", "getUpdatedAt", "()J", "getVariations", "getVideoId", "getVideoSteps", "getVideoThumbnail", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;JLjava/lang/String;Ljava/util/List;)Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "equals", "other", "hashCode", "toString", "TrickCategory", "TrickStep", "TrickTag", "TrickVariation", "TrickVideoStep", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickModel {

    private final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory category;
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
    private final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag> tags;
    private final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep> trickSteps;
    private final long updatedAt;
    private final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation> variations;
    private final String videoId;
    private final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep> videoSteps;
    private final String videoThumbnail;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "", "id", "", "name", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickCategory {

        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public TrickCategory() {
            super(0, 0, 0, obj4, 0, 15, 0);
        }

        public TrickCategory(String string, String string2, long l3, String string4) {
            n.f(string, "id");
            n.f(string2, "name");
            n.f(obj6, "locale");
            super();
            this.id = string;
            this.name = string2;
            this.updatedAt = l3;
            this.locale = obj6;
        }

        public TrickCategory(String string, String string2, long l3, String string4, int i5, g g6) {
            String str;
            int obj7;
            String obj10;
            String obj11;
            final String str2 = "";
            obj11 = g6 & 1 != 0 ? str2 : string;
            str = g6 & 2 != 0 ? str2 : string2;
            obj7 = g6 & 4 != 0 ? 0 : obj7;
            obj10 = g6 & 8 != 0 ? str2 : i5;
            super(obj11, str, obj7, i5, obj10);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickModel$TrickCategory, String string2, String string3, long l4, String string5, int i6, Object object7) {
            String obj4;
            String obj5;
            long obj6;
            String obj8;
            if (object7 & 1 != 0) {
                obj4 = trickCategory.id;
            }
            if (object7 & 2 != 0) {
                obj5 = trickCategory.name;
            }
            if (object7 & 4 != 0) {
                obj6 = trickCategory.updatedAt;
            }
            if (object7 & 8 != 0) {
                obj8 = trickCategory.locale;
            }
            return trickCategory.copy(obj4, obj5, obj6, object7);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.updatedAt;
        }

        public final String component4() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory copy(String string, String string2, long l3, String string4) {
            n.f(string, "id");
            n.f(string2, "name");
            n.f(obj12, "locale");
            super(string, string2, l3, obj5, obj12);
            return trickCategory;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickModel.TrickCategory) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            return i6 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickCategory(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickStep;", "", "id", "", "image", "description", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getId", "getImage", "getLocale", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickStep {

        private final String description;
        private final String id;
        private final String image;
        private final String locale;
        private final long updatedAt;
        public TrickStep() {
            super(0, 0, 0, 0, obj5, 0, 31, 0);
        }

        public TrickStep(String string, String string2, String string3, long l4, String string5) {
            n.f(string, "id");
            n.f(string2, "image");
            n.f(string3, "description");
            n.f(obj7, "locale");
            super();
            this.id = string;
            this.image = string2;
            this.description = string3;
            this.updatedAt = l4;
            this.locale = obj7;
        }

        public TrickStep(String string, String string2, String string3, long l4, String string5, int i6, g g7) {
            String str2;
            String str;
            int obj9;
            String obj12;
            String obj13;
            final String str3 = "";
            obj13 = g7 & 1 != 0 ? str3 : string;
            str2 = g7 & 2 != 0 ? str3 : string2;
            str = g7 & 4 != 0 ? str3 : string3;
            obj9 = g7 & 8 != 0 ? 0 : obj9;
            obj12 = g7 & 16 != 0 ? str3 : i6;
            super(obj13, str2, str, obj9, i6, obj12);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep trickModel$TrickStep, String string2, String string3, String string4, long l5, String string6, int i7, Object object8) {
            String obj5;
            String obj6;
            String obj7;
            long obj8;
            String obj10;
            if (object8 & 1 != 0) {
                obj5 = trickStep.id;
            }
            if (object8 & 2 != 0) {
                obj6 = trickStep.image;
            }
            if (object8 & 4 != 0) {
                obj7 = trickStep.description;
            }
            if (object8 & 8 != 0) {
                obj8 = trickStep.updatedAt;
            }
            if (object8 & 16 != 0) {
                obj10 = trickStep.locale;
            }
            return trickStep.copy(obj5, obj6, obj7, obj8, object8);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.image;
        }

        public final String component3() {
            return this.description;
        }

        public final long component4() {
            return this.updatedAt;
        }

        public final String component5() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep copy(String string, String string2, String string3, long l4, String string5) {
            n.f(string, "id");
            n.f(string2, "image");
            n.f(string3, "description");
            n.f(obj14, "locale");
            super(string, string2, string3, l4, obj6, obj14);
            return trickStep;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickModel.TrickStep) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.image, object.image)) {
                return i2;
            }
            if (!n.b(this.description, object.description)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            return i8 += i13;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickStep(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", image=");
            stringBuilder.append(this.image);
            stringBuilder.append(", description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickTag;", "", "id", "", "name", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickTag {

        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public TrickTag() {
            super(0, 0, 0, obj4, 0, 15, 0);
        }

        public TrickTag(String string, String string2, long l3, String string4) {
            n.f(string, "id");
            n.f(string2, "name");
            n.f(obj6, "locale");
            super();
            this.id = string;
            this.name = string2;
            this.updatedAt = l3;
            this.locale = obj6;
        }

        public TrickTag(String string, String string2, long l3, String string4, int i5, g g6) {
            String str;
            int obj7;
            String obj10;
            String obj11;
            final String str2 = "";
            obj11 = g6 & 1 != 0 ? str2 : string;
            str = g6 & 2 != 0 ? str2 : string2;
            obj7 = g6 & 4 != 0 ? 0 : obj7;
            obj10 = g6 & 8 != 0 ? str2 : i5;
            super(obj11, str, obj7, i5, obj10);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag trickModel$TrickTag, String string2, String string3, long l4, String string5, int i6, Object object7) {
            String obj4;
            String obj5;
            long obj6;
            String obj8;
            if (object7 & 1 != 0) {
                obj4 = trickTag.id;
            }
            if (object7 & 2 != 0) {
                obj5 = trickTag.name;
            }
            if (object7 & 4 != 0) {
                obj6 = trickTag.updatedAt;
            }
            if (object7 & 8 != 0) {
                obj8 = trickTag.locale;
            }
            return trickTag.copy(obj4, obj5, obj6, object7);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.updatedAt;
        }

        public final String component4() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag copy(String string, String string2, long l3, String string4) {
            n.f(string, "id");
            n.f(string2, "name");
            n.f(obj12, "locale");
            super(string, string2, l3, obj5, obj12);
            return trickTag;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickModel.TrickTag) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            return i6 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickTag(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
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
        public TrickVariation() {
            super(0, 0, 0, 0, 0, 0, 0, obj8, 127, 0);
        }

        public TrickVariation(List<String> list, String string2, String string3, String string4, String string5, String string6, long l7) {
            n.f(list, "tips");
            n.f(string2, "id");
            n.f(string3, "title");
            n.f(string4, "description");
            n.f(string5, "locale");
            n.f(string6, "contentfulId");
            super();
            this.tips = list;
            this.id = string2;
            this.title = string3;
            this.description = string4;
            this.locale = string5;
            this.contentfulId = string6;
            this.updatedAt = l7;
        }

        public TrickVariation(List list, String string2, String string3, String string4, String string5, String string6, long l7, int i8, g g9) {
            List list2;
            String str3;
            String str5;
            String str4;
            String str;
            String str2;
            int i;
            if (g9 & 1 != 0) {
                list2 = p.g();
            } else {
                list2 = list;
            }
            str5 = "";
            str3 = g9 & 2 != 0 ? str5 : string2;
            str4 = g9 & 4 != 0 ? str5 : string3;
            str = g9 & 8 != 0 ? str5 : string4;
            str2 = g9 & 16 != 0 ? str5 : string5;
            if (g9 & 32 != 0) {
            } else {
                str5 = string6;
            }
            i = g9 & 64 != 0 ? 0 : l7;
            super(list2, str3, str4, str, str2, str5, i, g9);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation trickModel$TrickVariation, List list2, String string3, String string4, String string5, String string6, String string7, long l8, int i9, Object object10) {
            List tips;
            String str;
            String title;
            String description;
            String locale;
            String contentfulId;
            long updatedAt;
            Object obj = trickVariation;
            tips = object10 & 1 != 0 ? obj.tips : list2;
            str = object10 & 2 != 0 ? obj.id : string3;
            title = object10 & 4 != 0 ? obj.title : string4;
            description = object10 & 8 != 0 ? obj.description : string5;
            locale = object10 & 16 != 0 ? obj.locale : string6;
            contentfulId = object10 & 32 != 0 ? obj.contentfulId : string7;
            updatedAt = object10 & 64 != 0 ? obj.updatedAt : l8;
            return trickVariation.copy(tips, str, title, description, locale, contentfulId, updatedAt);
        }

        public final List<String> component1() {
            return this.tips;
        }

        public final String component2() {
            return this.id;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.description;
        }

        public final String component5() {
            return this.locale;
        }

        public final String component6() {
            return this.contentfulId;
        }

        public final long component7() {
            return this.updatedAt;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation copy(List<String> list, String string2, String string3, String string4, String string5, String string6, long l7) {
            n.f(list, "tips");
            n.f(string2, "id");
            n.f(string3, "title");
            n.f(string4, "description");
            n.f(string5, "locale");
            final Object obj = string6;
            n.f(obj, "contentfulId");
            super(list, string2, string3, string4, string5, obj, l7, obj9);
            return trickVariation;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickModel.TrickVariation) {
                return i2;
            }
            if (!n.b(this.tips, object.tips)) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.title, object.title)) {
                return i2;
            }
            if (!n.b(this.description, object.description)) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            if (!n.b(this.contentfulId, object.contentfulId)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            return i12 += i19;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickVariation(tips=");
            stringBuilder.append(this.tips);
            stringBuilder.append(", id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", title=");
            stringBuilder.append(this.title);
            stringBuilder.append(", description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(", contentfulId=");
            stringBuilder.append(this.contentfulId);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0008HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickVideoStep;", "", "id", "", "text", "startTime", "", "updatedAt", "", "locale", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLocale", "getStartTime", "()I", "getText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVideoStep {

        private final String id;
        private final String locale;
        private final int startTime;
        private final String text;
        private final long updatedAt;
        public TrickVideoStep() {
            super(0, 0, 0, 0, obj5, 0, 31, 0);
        }

        public TrickVideoStep(String string, String string2, int i3, long l4, String string5) {
            n.f(string, "id");
            n.f(string2, "text");
            n.f(obj7, "locale");
            super();
            this.id = string;
            this.text = string2;
            this.startTime = i3;
            this.updatedAt = l4;
            this.locale = obj7;
        }

        public TrickVideoStep(String string, String string2, int i3, long l4, String string5, int i6, g g7) {
            String str;
            int obj8;
            int obj9;
            String obj12;
            String obj13;
            final String str2 = "";
            obj13 = g7 & 1 != 0 ? str2 : string;
            str = g7 & 2 != 0 ? str2 : string2;
            obj8 = g7 & 4 != 0 ? 0 : obj8;
            obj9 = g7 & 8 != 0 ? 0 : obj9;
            obj12 = g7 & 16 != 0 ? str2 : i6;
            super(obj13, str, obj8, obj9, i6, obj12);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep trickModel$TrickVideoStep, String string2, String string3, int i4, long l5, String string6, int i7, Object object8) {
            String obj5;
            String obj6;
            int obj7;
            long obj8;
            String obj10;
            if (object8 & 1 != 0) {
                obj5 = trickVideoStep.id;
            }
            if (object8 & 2 != 0) {
                obj6 = trickVideoStep.text;
            }
            if (object8 & 4 != 0) {
                obj7 = trickVideoStep.startTime;
            }
            if (object8 & 8 != 0) {
                obj8 = trickVideoStep.updatedAt;
            }
            if (object8 & 16 != 0) {
                obj10 = trickVideoStep.locale;
            }
            return trickVideoStep.copy(obj5, obj6, obj7, obj8, object8);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.text;
        }

        public final int component3() {
            return this.startTime;
        }

        public final long component4() {
            return this.updatedAt;
        }

        public final String component5() {
            return this.locale;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep copy(String string, String string2, int i3, long l4, String string5) {
            n.f(string, "id");
            n.f(string2, "text");
            n.f(obj14, "locale");
            super(string, string2, i3, l4, obj6, obj14);
            return trickVideoStep;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof TrickModel.TrickVideoStep) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.text, object.text)) {
                return i2;
            }
            if (this.startTime != object.startTime) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            return i8 += i13;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickVideoStep(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", text=");
            stringBuilder.append(this.text);
            stringBuilder.append(", startTime=");
            stringBuilder.append(this.startTime);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public TrickModel() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj17, 0, 0, 262143, 0);
    }

    public TrickModel(String string, String string2, String string3, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep> list4, app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickModel$TrickCategory5, String string6, Integer integer7, boolean z8, Integer integer9, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag> list10, boolean z11, String string12, String string13, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep> list14, String string15, long l16, String string17, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation> list18) {
        final Object obj = this;
        final Object obj2 = trickCategory5;
        final Object obj3 = list10;
        final Object obj4 = list14;
        final Object obj5 = list18;
        final Object obj6 = obj30;
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "image");
        n.f(list4, "trickSteps");
        n.f(obj2, "category");
        n.f(obj3, "tags");
        n.f(obj4, "videoSteps");
        n.f(obj5, "locale");
        n.f(obj6, "variations");
        super();
        obj.id = string;
        obj.name = string2;
        obj.image = string3;
        obj.trickSteps = list4;
        obj.category = obj2;
        obj.examInstructions = string6;
        obj.examTimeLimit = integer7;
        obj.isExam = z8;
        obj.sortOrder = integer9;
        obj.tags = obj3;
        obj.hasProgress = z11;
        obj.videoId = string12;
        obj.videoThumbnail = string13;
        obj.videoSteps = obj4;
        obj.description = string15;
        obj.updatedAt = l16;
        obj.locale = obj5;
        obj.variations = obj6;
    }

    public TrickModel(String string, String string2, String string3, List list4, app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickModel$TrickCategory5, String string6, Integer integer7, boolean z8, Integer integer9, List list10, boolean z11, String string12, String string13, List list14, String string15, long l16, String string17, List list18, int i19, g g20) {
        List list5;
        String str3;
        int i3;
        String str;
        String str4;
        List list2;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickCategory2;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickCategory;
        int i6;
        int i7;
        List list;
        int i13;
        int i15;
        int i8;
        int i9;
        int i2;
        int i4;
        int i10;
        int i;
        List list3;
        int i12;
        int i11;
        int i5;
        int i14;
        String str2;
        int i16 = g20;
        String str5 = "";
        str3 = i16 & 1 != 0 ? str5 : string;
        str = i16 & 2 != 0 ? str5 : string2;
        str4 = i16 & 4 != 0 ? str5 : string3;
        if (i16 & 8 != 0) {
            list2 = p.g();
        } else {
            list2 = list4;
        }
        if (i16 & 16 != 0) {
            super(0, 0, 0, obj11, 0, 15, 0);
        } else {
            trickCategory2 = trickCategory5;
        }
        i6 = i16 & 32 != 0 ? 0 : string6;
        i15 = i16 & 64 != 0 ? 0 : integer7;
        i9 = i16 & 128 != 0 ? i2 : z8;
        i10 = i16 & 256 != 0 ? 0 : integer9;
        if (i16 & 512 != 0) {
            list3 = p.g();
        } else {
            list3 = list10;
        }
        if (i16 & 1024 != 0) {
        } else {
            i2 = z11;
        }
        i11 = i16 & 2048 != 0 ? 0 : string12;
        i5 = i16 & 4096 != 0 ? 0 : string13;
        if (i16 & 8192 != 0) {
            list = p.g();
        } else {
            list = list14;
        }
        i3 = i16 & 16384 != 0 ? 0 : string15;
        i14 = i16 & i34 != 0 ? 0 : l16;
        str2 = i16 & i36 != 0 ? obj41 : list18;
        if (i16 &= i38 != 0) {
            list5 = p.g();
        } else {
            list5 = i19;
        }
        super(str3, str, str4, list2, trickCategory2, i6, i15, i9, i10, list3, i2, i11, i5, list, i3, i14, list18, str2, list5);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.TrickModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.TrickModel trickModel, String string2, String string3, String string4, List list5, app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickModel$TrickCategory6, String string7, Integer integer8, boolean z9, Integer integer10, List list11, boolean z12, String string13, String string14, List list15, String string16, long l17, String string18, List list19, int i20, Object object21) {
        List variations;
        String str;
        String name;
        String image;
        List trickSteps;
        app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory category;
        String examInstructions;
        Integer examTimeLimit;
        boolean isExam;
        Integer sortOrder;
        List tags;
        boolean hasProgress;
        String videoId;
        String videoThumbnail;
        long updatedAt;
        String locale;
        List videoSteps;
        String description;
        Object obj = trickModel;
        int i = object21;
        str = i & 1 != 0 ? obj.id : string2;
        name = i & 2 != 0 ? obj.name : string3;
        image = i & 4 != 0 ? obj.image : string4;
        trickSteps = i & 8 != 0 ? obj.trickSteps : list5;
        category = i & 16 != 0 ? obj.category : trickCategory6;
        examInstructions = i & 32 != 0 ? obj.examInstructions : string7;
        examTimeLimit = i & 64 != 0 ? obj.examTimeLimit : integer8;
        isExam = i & 128 != 0 ? obj.isExam : z9;
        sortOrder = i & 256 != 0 ? obj.sortOrder : integer10;
        tags = i & 512 != 0 ? obj.tags : list11;
        hasProgress = i & 1024 != 0 ? obj.hasProgress : z12;
        videoId = i & 2048 != 0 ? obj.videoId : string13;
        videoThumbnail = i & 4096 != 0 ? obj.videoThumbnail : string14;
        videoSteps = i & 8192 != 0 ? obj.videoSteps : list15;
        description = i & 16384 != 0 ? obj.description : string16;
        updatedAt = i & i19 != 0 ? obj.updatedAt : l17;
        locale = i & i22 != 0 ? obj.locale : list19;
        variations = i &= i18 != 0 ? obj.variations : i20;
        return trickModel.copy(str, name, image, trickSteps, category, examInstructions, examTimeLimit, isExam, sortOrder, tags, hasProgress, videoId, videoThumbnail, videoSteps, description, updatedAt, string18, locale);
    }

    public final String component1() {
        return this.id;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag> component10() {
        return this.tags;
    }

    public final boolean component11() {
        return this.hasProgress;
    }

    public final String component12() {
        return this.videoId;
    }

    public final String component13() {
        return this.videoThumbnail;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep> component14() {
        return this.videoSteps;
    }

    public final String component15() {
        return this.description;
    }

    public final long component16() {
        return this.updatedAt;
    }

    public final String component17() {
        return this.locale;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation> component18() {
        return this.variations;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep> component4() {
        return this.trickSteps;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory component5() {
        return this.category;
    }

    public final String component6() {
        return this.examInstructions;
    }

    public final Integer component7() {
        return this.examTimeLimit;
    }

    public final boolean component8() {
        return this.isExam;
    }

    public final Integer component9() {
        return this.sortOrder;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel copy(String string, String string2, String string3, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep> list4, app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory trickModel$TrickCategory5, String string6, Integer integer7, boolean z8, Integer integer9, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag> list10, boolean z11, String string12, String string13, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep> list14, String string15, long l16, String string17, List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation> list18) {
        Object obj = string;
        n.f(obj, "id");
        n.f(string2, "name");
        n.f(string3, "image");
        n.f(list4, "trickSteps");
        n.f(trickCategory5, "category");
        n.f(list10, "tags");
        n.f(list14, "videoSteps");
        n.f(list18, "locale");
        n.f(obj41, "variations");
        super(obj, string2, string3, list4, trickCategory5, string6, integer7, z8, integer9, list10, z11, string12, string13, list14, string15, l16, obj17, list18, obj41);
        return trickModel2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.trickSteps, object.trickSteps)) {
            return i2;
        }
        if (!n.b(this.category, object.category)) {
            return i2;
        }
        if (!n.b(this.examInstructions, object.examInstructions)) {
            return i2;
        }
        if (!n.b(this.examTimeLimit, object.examTimeLimit)) {
            return i2;
        }
        if (this.isExam != object.isExam) {
            return i2;
        }
        if (!n.b(this.sortOrder, object.sortOrder)) {
            return i2;
        }
        if (!n.b(this.tags, object.tags)) {
            return i2;
        }
        if (this.hasProgress != object.hasProgress) {
            return i2;
        }
        if (!n.b(this.videoId, object.videoId)) {
            return i2;
        }
        if (!n.b(this.videoThumbnail, object.videoThumbnail)) {
            return i2;
        }
        if (!n.b(this.videoSteps, object.videoSteps)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.variations, object.variations)) {
            return i2;
        }
        return i;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory getCategory() {
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

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag> getTags() {
        return this.tags;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep> getTrickSteps() {
        return this.trickSteps;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVariation> getVariations() {
        return this.variations;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep> getVideoSteps() {
        return this.videoSteps;
    }

    public final String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public int hashCode() {
        int i6;
        int i7;
        boolean isExam;
        int i5;
        int i;
        int i4;
        int i3;
        int i2;
        String examInstructions = this.examInstructions;
        i3 = 0;
        if (examInstructions == null) {
            i6 = i3;
        } else {
            i6 = examInstructions.hashCode();
        }
        Integer examTimeLimit = this.examTimeLimit;
        if (examTimeLimit == null) {
            i7 = i3;
        } else {
            i7 = examTimeLimit.hashCode();
        }
        if (this.isExam) {
            isExam = i2;
        }
        Integer sortOrder = this.sortOrder;
        if (sortOrder == null) {
            i5 = i3;
        } else {
            i5 = sortOrder.hashCode();
        }
        boolean hasProgress = this.hasProgress;
        if (hasProgress) {
        } else {
            i2 = hasProgress;
        }
        String videoId = this.videoId;
        if (videoId == null) {
            i = i3;
        } else {
            i = videoId.hashCode();
        }
        String videoThumbnail = this.videoThumbnail;
        if (videoThumbnail == null) {
            i4 = i3;
        } else {
            i4 = videoThumbnail.hashCode();
        }
        String description = this.description;
        if (description == null) {
        } else {
            i3 = description.hashCode();
        }
        return i41 += i51;
    }

    public final boolean isExam() {
        return this.isExam;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", trickSteps=");
        stringBuilder.append(this.trickSteps);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", examInstructions=");
        stringBuilder.append(this.examInstructions);
        stringBuilder.append(", examTimeLimit=");
        stringBuilder.append(this.examTimeLimit);
        stringBuilder.append(", isExam=");
        stringBuilder.append(this.isExam);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append(", hasProgress=");
        stringBuilder.append(this.hasProgress);
        stringBuilder.append(", videoId=");
        stringBuilder.append(this.videoId);
        stringBuilder.append(", videoThumbnail=");
        stringBuilder.append(this.videoThumbnail);
        stringBuilder.append(", videoSteps=");
        stringBuilder.append(this.videoSteps);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", variations=");
        stringBuilder.append(this.variations);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
