package app.dogo.com.dogo_android.model.trainingprogram;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ArticleModel.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u000267B\u007f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0088\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\u0008\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "", "id", "", "locale", "updatedAt", "", "title", "text", "readingTime", "", "sortOrder", "category", "image", "tags", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "textHtml", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getId", "getImage", "getLocale", "getReadingTime", "()I", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTags", "()Ljava/util/List;", "getText", "getTextHtml", "getTitle", "getUpdatedAt", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "equals", "", "other", "hashCode", "toString", "ArticleCategory", "ArticleTag", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ArticleModel {

    private final String category;
    private final String id;
    private final String image;
    private final String locale;
    private final int readingTime;
    private final Integer sortOrder;
    private final List<ArticleModel.ArticleTag> tags;
    private final String text;
    private final String textHtml;
    private final String title;
    private final long updatedAt;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleCategory;", "", "category", "", "(Ljava/lang/String;ILjava/lang/String;)V", "ARTICLE", "FAQ", "HIDDEN", "UNKNOWN", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ArticleCategory {

        ARTICLE,
        FAQ,
        HIDDEN,
        UNKNOWN;
        private static final /* synthetic */ ArticleModel.ArticleCategory[] $values() {
            app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleCategory[] arr = new ArticleModel.ArticleCategory[4];
            return new ArticleModel.ArticleCategory[] { ArticleModel_ArticleCategory.ARTICLE, ArticleModel_ArticleCategory.FAQ, ArticleModel_ArticleCategory.HIDDEN, ArticleModel_ArticleCategory.UNKNOWN };
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "", "id", "", "locale", "updatedAt", "", "name", "hidden", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getHidden", "()Z", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArticleTag {

        private final boolean hidden;
        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public ArticleTag(String str, String str2, long j, String str3, boolean z) {
            n.f(str, "id");
            n.f(str2, "locale");
            n.f(str3, "name");
            super();
            this.id = str;
            this.locale = str2;
            this.updatedAt = j;
            this.name = str3;
            this.hidden = z;
        }

        public final boolean getHidden() {
            return this.hidden;
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

        public /* synthetic */ ArticleTag(String str, String str2, long j, String str3, boolean z, int i, g gVar) {
            String z52;
            int j32 = 0;
            int i62 = 0;
            z52 = "";
            gVar = i & 1 != 0 ? z52 : str;
            String r1 = i & 2 != 0 ? z52 : str2;
            j32 = i & 4 != 0 ? 0 : j32;
            if (i & 8 == 0) {
                z52 = str3;
            }
            i62 = i & 16 != 0 ? 0 : i62;
            this(z52, z52, j32, str3, z52, i62);
        }

        public ArticleTag() {
            this(null, null, 0L, str, false, 0, 31, 0);
        }

        public static /* synthetic */ ArticleModel.ArticleTag copy$default(ArticleModel.ArticleTag articleTag, String str, String str2, long j, String str3, boolean z, int i, Object object) {
            String str22;
            String str32;
            long j42;
            String z62;
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
            return articleTag.copy(str22, str32, j42, z62, i72);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.locale;
        }

        /* operator */ public final long component3() {
            return this.updatedAt;
        }

        /* operator */ public final String component4() {
            return this.name;
        }

        /* operator */ public final boolean component5() {
            return this.hidden;
        }

        public final ArticleModel.ArticleTag copy(String id, String locale, long updatedAt, String name, boolean hidden) {
            n.f(id, "id");
            n.f(locale, "locale");
            n.f(name, "name");
            ArticleModel_ArticleTag articleModel_ArticleTag = new ArticleModel_ArticleTag(id, locale, updatedAt, str4, name, hidden);
            return articleModel_ArticleTag;
        }

        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z6 = false;
            if (!(other instanceof ArticleModel_ArticleTag)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.locale, other.locale)) {
                return false;
            }
            if (this.updatedAt != other.updatedAt) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            return this.hidden != other.hidden ? z6 : z;
        }

        public int hashCode() {
            boolean hidden2 = true;
            if (this.hidden) {
                int i13 = 1;
            }
            return (this.id.hashCode() * 31) + this.locale.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.name.hashCode() * 31 + hidden2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ArticleTag(id=";
            String str3 = ", locale=";
            String str4 = ", updatedAt=";
            String str5 = ", name=";
            String str6 = ", hidden=";
            str = str2 + this.id + str3 + this.locale + str4 + this.updatedAt + str5 + this.name + str6 + this.hidden + 41;
            return str;
        }
    }
    public ArticleModel(String str, String str2, long j, String str3, String str4, int i, Integer integer, String str5, String str6, List<ArticleModel.ArticleTag> list, String str7) {
        n.f(str, "id");
        n.f(str2, "locale");
        n.f(str3, "title");
        n.f(str4, "text");
        n.f(str5, "category");
        n.f(list, "tags");
        super();
        this.id = str;
        this.locale = str2;
        this.updatedAt = j;
        this.title = str3;
        this.text = str4;
        this.readingTime = i;
        this.sortOrder = integer;
        this.category = str5;
        this.image = str6;
        this.tags = list;
        this.textHtml = str7;
    }

    public final String getCategory() {
        return this.category;
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

    public final int getReadingTime() {
        return this.readingTime;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final List<ArticleModel.ArticleTag> getTags() {
        return this.tags;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextHtml() {
        return this.textHtml;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public /* synthetic */ ArticleModel(String str, String str2, long j, String str3, String str4, int i, Integer integer, String str5, String str6, List list, String str7, int i2, g gVar) {
        int j32 = 0;
        int integer72 = 0;
        int str82;
        List str112;
        int gVar132 = i2;
        str3 = "";
        String r1 = gVar132 & 1 != 0 ? str3 : str;
        String r3 = gVar132 & 2 != 0 ? str3 : str2;
        int r4 = gVar132 & 4 != 0 ? 0 : j;
        String r6 = str3;
        String r7 = gVar132 & 16 != 0 ? str3 : str4;
        int r8 = gVar132 & 32 != 0 ? 0 : i;
        str82 = 0;
        int r9 = gVar132 & 64 != 0 ? 0 : integer;
        String r11 = gVar132 & 128 != 0 ? str3 : str5;
        if (gVar132 & 256 == 0) {
            str82 = str6;
        }
        if (gVar132 & 512 != 0) {
            str112 = p.g();
        } else {
            str112 = list;
        }
        if (gVar132 & 1024 == 0) {
            str3 = str7;
        }
        this(str3, str3, j32, str3, str3, str3, integer72, str82, str3, str82, str112, str3);
    }

    public ArticleModel() {
        this(null, null, 0L, str, null, 0, null, null, null, null, null, 0, 2047, 0);
    }

    public static /* synthetic */ ArticleModel copy$default(ArticleModel articleModel, String str, String str2, long j, String str3, String str4, int i, Integer integer, String str5, String str6, List list, String str7, int i2, Object object) {
        String i132;
        String str22;
        String str32;
        long j42;
        String str62;
        String i72;
        int integer82;
        Integer str92;
        String str102;
        String list112;
        List str122;
        Object articleModel2 = articleModel;
        int object142 = i2;
        String r2 = object142 & 1 != 0 ? articleModel2.id : str;
        String r3 = object142 & 2 != 0 ? articleModel2.locale : str2;
        long r4 = object142 & 4 != 0 ? articleModel2.updatedAt : j;
        String r6 = object142 & 8 != 0 ? articleModel2.title : str3;
        String r7 = object142 & 16 != 0 ? articleModel2.text : str4;
        int r8 = object142 & 32 != 0 ? articleModel2.readingTime : i;
        Integer r9 = object142 & 64 != 0 ? articleModel2.sortOrder : integer;
        String r10 = object142 & 128 != 0 ? articleModel2.category : str5;
        String r11 = object142 & 256 != 0 ? articleModel2.image : str6;
        List r12 = object142 & 512 != 0 ? articleModel2.tags : list;
        String r1 = object142 & 1024 != 0 ? articleModel2.textHtml : str7;
        return articleModel.copy(str22, str32, j42, r17, str62, i72, integer82, str92, str102, list112, str122, (object142 & 1024 != 0 ? articleModel2.textHtml : str7));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final List<ArticleModel.ArticleTag> component10() {
        return this.tags;
    }

    /* operator */ public final String component11() {
        return this.textHtml;
    }

    /* operator */ public final String component2() {
        return this.locale;
    }

    /* operator */ public final long component3() {
        return this.updatedAt;
    }

    /* operator */ public final String component4() {
        return this.title;
    }

    /* operator */ public final String component5() {
        return this.text;
    }

    /* operator */ public final int component6() {
        return this.readingTime;
    }

    /* operator */ public final Integer component7() {
        return this.sortOrder;
    }

    /* operator */ public final String component8() {
        return this.category;
    }

    /* operator */ public final String component9() {
        return this.image;
    }

    public final ArticleModel copy(String id, String locale, long updatedAt, String title, String text, int readingTime, Integer sortOrder, String category, String image, List<ArticleModel.ArticleTag> tags, String textHtml) {
        n.f(id, "id");
        final Object locale2 = locale;
        n.f(locale2, "locale");
        final Object text2 = title;
        n.f(text2, "title");
        final Object readingTime2 = text;
        n.f(readingTime2, "text");
        final Object image2 = category;
        n.f(image2, "category");
        final Object textHtml2 = tags;
        n.f(textHtml2, "tags");
        ArticleModel articleModel = new ArticleModel(id, locale2, updatedAt, str7, text2, readingTime2, readingTime, sortOrder, image2, image, textHtml2, textHtml);
        return articleModel;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z11 = false;
        if (!(other instanceof ArticleModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.title, other.title)) {
            return false;
        }
        if (!n.b(this.text, other.text)) {
            return false;
        }
        if (this.readingTime != other.readingTime) {
            return false;
        }
        if (!n.b(this.sortOrder, other.sortOrder)) {
            return false;
        }
        if (!n.b(this.category, other.category)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.tags, other.tags)) {
            return false;
        }
        return !n.b(this.textHtml, other.textHtml) ? z11 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.sortOrder == null) {
        } else {
            i = this.sortOrder.hashCode();
        }
        if (this.image == null) {
        } else {
            i = this.image.hashCode();
        }
        if (this.textHtml != null) {
            i = this.textHtml.hashCode();
        }
        return (this.id.hashCode() * 31) + this.locale.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.title.hashCode() * 31 + this.text.hashCode() * 31 + Integer.hashCode(this.readingTime) * 31 + i * 31 + this.category.hashCode() * 31 + i * 31 + this.tags.hashCode() * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ArticleModel(id=";
        String str3 = ", locale=";
        String str4 = ", updatedAt=";
        String str5 = ", title=";
        String str6 = ", text=";
        String str7 = ", readingTime=";
        String str8 = ", sortOrder=";
        String str9 = ", category=";
        String str10 = ", image=";
        String str11 = ", tags=";
        String str12 = ", textHtml=";
        str = str2 + this.id + str3 + this.locale + str4 + this.updatedAt + str5 + this.title + str6 + this.text + str7 + this.readingTime + str8 + this.sortOrder + str9 + this.category + str10 + this.image + str11 + this.tags + str12 + this.textHtml + 41;
        return str;
    }
}
