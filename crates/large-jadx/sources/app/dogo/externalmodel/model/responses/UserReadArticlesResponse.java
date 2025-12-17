package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "Landroid/os/Parcelable;", "articles", "", "", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "(Ljava/util/Map;)V", "getArticles", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ArticleStatus", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UserReadArticlesResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserReadArticlesResponse> CREATOR;
    private final Map<String, app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> articles;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\r¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "Landroid/os/Parcelable;", "articleId", "", "isRead", "", "readTimeMs", "", "(Ljava/lang/String;ZLjava/lang/Long;)V", "getArticleId", "()Ljava/lang/String;", "()Z", "getReadTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ZLjava/lang/Long;)Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArticleStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> CREATOR;
        private final String articleId;
        private final boolean isRead;
        private final Long readTimeMs;
        static {
            UserReadArticlesResponse.ArticleStatus.Creator creator = new UserReadArticlesResponse.ArticleStatus.Creator();
            UserReadArticlesResponse.ArticleStatus.CREATOR = creator;
        }

        public ArticleStatus() {
            super(0, 0, 0, 7, 0);
        }

        public ArticleStatus(String string, boolean z2, Long long3) {
            super();
            this.articleId = string;
            this.isRead = z2;
            this.readTimeMs = long3;
        }

        public ArticleStatus(String string, boolean z2, Long long3, int i4, g g5) {
            int obj2;
            int obj3;
            int obj4;
            final int i = 0;
            obj2 = i4 & 1 != 0 ? i : obj2;
            obj3 = i4 & 2 != 0 ? 0 : obj3;
            obj4 = i4 &= 4 != 0 ? i : obj4;
            super(obj2, obj3, obj4);
        }

        public static app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus copy$default(app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus userReadArticlesResponse$ArticleStatus, String string2, boolean z3, Long long4, int i5, Object object6) {
            String obj1;
            boolean obj2;
            Long obj3;
            if (i5 & 1 != 0) {
                obj1 = articleStatus.articleId;
            }
            if (i5 & 2 != 0) {
                obj2 = articleStatus.isRead;
            }
            if (i5 &= 4 != 0) {
                obj3 = articleStatus.readTimeMs;
            }
            return articleStatus.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.articleId;
        }

        @Override // android.os.Parcelable
        public final boolean component2() {
            return this.isRead;
        }

        @Override // android.os.Parcelable
        public final Long component3() {
            return this.readTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus copy(String string, boolean z2, Long long3) {
            UserReadArticlesResponse.ArticleStatus articleStatus = new UserReadArticlesResponse.ArticleStatus(string, z2, long3);
            return articleStatus;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof UserReadArticlesResponse.ArticleStatus) {
                return i2;
            }
            if (!n.b(this.articleId, object.articleId)) {
                return i2;
            }
            if (this.isRead != object.isRead) {
                return i2;
            }
            if (!n.b(this.readTimeMs, object.readTimeMs)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getArticleId() {
            return this.articleId;
        }

        @Override // android.os.Parcelable
        public final Long getReadTimeMs() {
            return this.readTimeMs;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i2;
            boolean isRead;
            String articleId = this.articleId;
            if (articleId == null) {
                i = i2;
            } else {
                i = articleId.hashCode();
            }
            if (this.isRead) {
                isRead = 1;
            }
            Long readTimeMs = this.readTimeMs;
            if (readTimeMs == null) {
            } else {
                i2 = readTimeMs.hashCode();
            }
            return i5 += i2;
        }

        @Override // android.os.Parcelable
        public final boolean isRead() {
            return this.isRead;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ArticleStatus(articleId=");
            stringBuilder.append(this.articleId);
            stringBuilder.append(", isRead=");
            stringBuilder.append(this.isRead);
            stringBuilder.append(", readTimeMs=");
            stringBuilder.append(this.readTimeMs);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            int obj4;
            n.f(parcel, "out");
            parcel.writeString(this.articleId);
            parcel.writeInt(this.isRead);
            obj4 = this.readTimeMs;
            if (obj4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(obj4.longValue());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.UserReadArticlesResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.UserReadArticlesResponse createFromParcel(Parcel parcel) {
            int i;
            String string;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), UserReadArticlesResponse.ArticleStatus.CREATOR.createFromParcel(parcel));
                i++;
            }
            UserReadArticlesResponse obj6 = new UserReadArticlesResponse(linkedHashMap);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.UserReadArticlesResponse[] newArray(int i) {
            return new UserReadArticlesResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        UserReadArticlesResponse.Creator creator = new UserReadArticlesResponse.Creator();
        UserReadArticlesResponse.CREATOR = creator;
    }

    public UserReadArticlesResponse() {
        final int i = 0;
        super(i, 1, i);
    }

    public UserReadArticlesResponse(Map<String, app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> map) {
        n.f(map, "articles");
        super();
        this.articles = map;
    }

    public UserReadArticlesResponse(Map map, int i2, g g3) {
        Map obj1;
        if (i2 &= 1 != 0) {
            obj1 = j0.h();
        }
        super(obj1);
    }

    public static app.dogo.externalmodel.model.responses.UserReadArticlesResponse copy$default(app.dogo.externalmodel.model.responses.UserReadArticlesResponse userReadArticlesResponse, Map map2, int i3, Object object4) {
        Map obj1;
        if (i3 &= 1 != 0) {
            obj1 = userReadArticlesResponse.articles;
        }
        return userReadArticlesResponse.copy(obj1);
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> component1() {
        return this.articles;
    }

    public final app.dogo.externalmodel.model.responses.UserReadArticlesResponse copy(Map<String, app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> map) {
        n.f(map, "articles");
        UserReadArticlesResponse userReadArticlesResponse = new UserReadArticlesResponse(map);
        return userReadArticlesResponse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof UserReadArticlesResponse == null) {
            return i2;
        }
        if (!n.b(this.articles, object.articles)) {
            return i2;
        }
        return i;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.UserReadArticlesResponse.ArticleStatus> getArticles() {
        return this.articles;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.articles.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserReadArticlesResponse(articles=");
        stringBuilder.append(this.articles);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        Object key;
        n.f(parcel, "out");
        Map articles = this.articles;
        parcel.writeInt(articles.size());
        Iterator iterator = articles.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            parcel.writeString((String)next2.getKey());
            (UserReadArticlesResponse.ArticleStatus)next2.getValue().writeToParcel(parcel, i2);
        }
    }
}
