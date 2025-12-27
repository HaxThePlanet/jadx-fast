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

/* compiled from: UserReadArticlesResponse.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "Landroid/os/Parcelable;", "articles", "", "", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "(Ljava/util/Map;)V", "getArticles", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ArticleStatus", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UserReadArticlesResponse implements Parcelable {

    public static final Parcelable.Creator<UserReadArticlesResponse> CREATOR = new UserReadArticlesResponse$Creator<>();
    private final Map<String, UserReadArticlesResponse.ArticleStatus> articles;

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\r¨\u0006 ", d2 = {"Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "Landroid/os/Parcelable;", "articleId", "", "isRead", "", "readTimeMs", "", "(Ljava/lang/String;ZLjava/lang/Long;)V", "getArticleId", "()Ljava/lang/String;", "()Z", "getReadTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;ZLjava/lang/Long;)Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse$ArticleStatus;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArticleStatus implements Parcelable {

        public static final Parcelable.Creator<UserReadArticlesResponse.ArticleStatus> CREATOR = new UserReadArticlesResponse$ArticleStatus$Creator<>();
        private final String articleId;
        private final boolean isRead;
        private final Long readTimeMs;
        public ArticleStatus(String str, boolean z, Long long) {
            super();
            this.articleId = str;
            this.isRead = z;
            this.readTimeMs = long;
        }

        public final String getArticleId() {
            return this.articleId;
        }

        public final Long getReadTimeMs() {
            return this.readTimeMs;
        }

        public final boolean isRead() {
            return this.isRead;
        }

        public /* synthetic */ ArticleStatus(String str, boolean z, Long long, int i, g gVar) {
            String str2;
            Long l;
            i = 0;
            i = i & 1 != 0 ? i : i;
            int i2 = i & 2 != 0 ? 0 : i2;
            i = i & 4 != 0 ? i : i;
            this(str2, z, l);
        }


        public ArticleStatus() {
            this(null, false, null, 7, null);
        }

        public static /* synthetic */ UserReadArticlesResponse.ArticleStatus copy$default(UserReadArticlesResponse.ArticleStatus articleStatus, String str, boolean z, Long long, int i, Object object) {
            String articleId2;
            boolean isRead2;
            Long readTimeMs2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return articleStatus.copy(articleId2, isRead2, readTimeMs2);
        }

        /* operator */ public final String component1() {
            return this.articleId;
        }

        /* operator */ public final boolean component2() {
            return this.isRead;
        }

        /* operator */ public final Long component3() {
            return this.readTimeMs;
        }

        public final UserReadArticlesResponse.ArticleStatus copy(String articleId, boolean isRead, Long readTimeMs) {
            return new UserReadArticlesResponse_ArticleStatus(articleId, isRead, readTimeMs);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z4 = false;
            if (!(other instanceof UserReadArticlesResponse_ArticleStatus)) {
                return false;
            }
            if (!n.b(this.articleId, other.articleId)) {
                return false;
            }
            if (this.isRead != other.isRead) {
                return false;
            }
            return !n.b(this.readTimeMs, other.readTimeMs) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            boolean isRead2 = true;
            i = 0;
            if (this.articleId == null) {
            } else {
                i = this.articleId.hashCode();
            }
            if (this.isRead) {
                int i6 = 1;
            }
            if (this.readTimeMs != null) {
                i = this.readTimeMs.hashCode();
            }
            return (i * 31) + isRead2 * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ArticleStatus(articleId=";
            String str3 = ", isRead=";
            String str4 = ", readTimeMs=";
            str = str2 + this.articleId + str3 + this.isRead + str4 + this.readTimeMs + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.articleId);
            parcel.writeInt(this.isRead);
            if (this.readTimeMs == null) {
                int i = 0;
                parcel.writeInt(i);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(this.readTimeMs.longValue());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserReadArticlesResponse> {
        @Override // android.os.Parcelable$Creator
        public final UserReadArticlesResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), UserReadArticlesResponse_ArticleStatus.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new UserReadArticlesResponse(linkedHashMap);
        }

        @Override // android.os.Parcelable$Creator
        public final UserReadArticlesResponse[] newArray(int i) {
            return new UserReadArticlesResponse[i];
        }
    }
    public UserReadArticlesResponse(Map<String, UserReadArticlesResponse.ArticleStatus> map) {
        n.f(map, "articles");
        super();
        this.articles = map;
    }

    public final Map<String, UserReadArticlesResponse.ArticleStatus> getArticles() {
        return this.articles;
    }

    public /* synthetic */ UserReadArticlesResponse(Map map, int i, g gVar) {
        Map map2;
        if (i & 1 != 0) {
            map2 = j0.h();
        }
        this(map2);
    }


    public UserReadArticlesResponse() {
        final Map map = null;
        this(map, 1, map);
    }

    public static /* synthetic */ UserReadArticlesResponse copy$default(UserReadArticlesResponse userReadArticlesResponse, Map map, int i, Object object) {
        Map articles2;
        if (i & 1 != 0) {
        }
        return userReadArticlesResponse.copy(articles2);
    }

    /* operator */ public final Map<String, UserReadArticlesResponse.ArticleStatus> component1() {
        return this.articles;
    }

    public final UserReadArticlesResponse copy(Map<String, UserReadArticlesResponse.ArticleStatus> articles) {
        n.f(articles, "articles");
        return new UserReadArticlesResponse(articles);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof UserReadArticlesResponse)) {
            return false;
        }
        return !n.b(this.articles, other.articles) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.articles.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "UserReadArticlesResponse(articles=";
        str = str2 + this.articles + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.articles.size());
        Iterator it = this.articles.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            (UserReadArticlesResponse_ArticleStatus)item.getValue().writeToParcel(parcel, flags);
        }
    }
}
