package app.dogo.com.dogo_android.model.trainingprogram;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0008\u0018\u00002\u00020\u0001:\u000267B\u007f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000f\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0088\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\u0008\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\nHÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\u0008\u001a\u0010\u001bR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0014R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u00068", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "", "id", "", "locale", "updatedAt", "", "title", "text", "readingTime", "", "sortOrder", "category", "image", "tags", "", "Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "textHtml", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getId", "getImage", "getLocale", "getReadingTime", "()I", "getSortOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTags", "()Ljava/util/List;", "getText", "getTextHtml", "getTitle", "getUpdatedAt", "()J", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel;", "equals", "", "other", "hashCode", "toString", "ArticleCategory", "ArticleTag", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ArticleModel {

    private final String category;
    private final String id;
    private final String image;
    private final String locale;
    private final int readingTime;
    private final Integer sortOrder;
    private final List<app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag> tags;
    private final String text;
    private final String textHtml;
    private final String title;
    private final long updatedAt;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleCategory;", "", "category", "", "(Ljava/lang/String;ILjava/lang/String;)V", "ARTICLE", "FAQ", "HIDDEN", "UNKNOWN", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum ArticleCategory {

        ARTICLE("article"),
        FAQ("article"),
        HIDDEN("article"),
        UNKNOWN("article");
        private static final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleCategory[] $values() {
            app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleCategory[] arr = new ArticleModel.ArticleCategory[4];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ArticleModel$ArticleTag;", "", "id", "", "locale", "updatedAt", "", "name", "hidden", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Z)V", "getHidden", "()Z", "getId", "()Ljava/lang/String;", "getLocale", "getName", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ArticleTag {

        private final boolean hidden;
        private final String id;
        private final String locale;
        private final String name;
        private final long updatedAt;
        public ArticleTag() {
            super(0, 0, 0, obj4, 0, 0, 31, 0);
        }

        public ArticleTag(String string, String string2, long l3, String string4, boolean z5) {
            n.f(string, "id");
            n.f(string2, "locale");
            n.f(z5, "name");
            super();
            this.id = string;
            this.locale = string2;
            this.updatedAt = l3;
            this.name = z5;
            this.hidden = obj7;
        }

        public ArticleTag(String string, String string2, long l3, String string4, boolean z5, int i6, g g7) {
            String str2;
            String str;
            int obj7;
            int obj10;
            String obj12;
            str2 = "";
            obj12 = g7 & 1 != 0 ? str2 : string;
            str = g7 & 2 != 0 ? str2 : string2;
            obj7 = g7 & 4 != 0 ? 0 : obj7;
            if (g7 & 8 != 0) {
            } else {
                str2 = z5;
            }
            obj10 = g7 & 16 != 0 ? 0 : obj10;
            super(obj12, str, obj7, z5, str2, obj10);
        }

        public static app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag copy$default(app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag articleModel$ArticleTag, String string2, String string3, long l4, String string5, boolean z6, int i7, Object object8) {
            String obj5;
            String obj6;
            long obj7;
            String obj9;
            boolean obj10;
            if (object8 & 1 != 0) {
                obj5 = articleTag.id;
            }
            if (object8 & 2 != 0) {
                obj6 = articleTag.locale;
            }
            if (object8 & 4 != 0) {
                obj7 = articleTag.updatedAt;
            }
            if (object8 & 8 != 0) {
                obj9 = articleTag.name;
            }
            if (object8 & 16 != 0) {
                obj10 = articleTag.hidden;
            }
            return articleTag.copy(obj5, obj6, obj7, obj10, obj9);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.locale;
        }

        public final long component3() {
            return this.updatedAt;
        }

        public final String component4() {
            return this.name;
        }

        public final boolean component5() {
            return this.hidden;
        }

        public final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag copy(String string, String string2, long l3, String string4, boolean z5) {
            n.f(string, "id");
            n.f(string2, "locale");
            n.f(z5, "name");
            super(string, string2, l3, obj5, z5, obj14);
            return articleTag;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof ArticleModel.ArticleTag) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.locale, object.locale)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (this.hidden != object.hidden) {
                return i2;
            }
            return i;
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

        public int hashCode() {
            boolean hidden;
            if (this.hidden) {
                hidden = 1;
            }
            return i8 += hidden;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ArticleTag(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", locale=");
            stringBuilder.append(this.locale);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", hidden=");
            stringBuilder.append(this.hidden);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public ArticleModel() {
        super(0, 0, 0, obj4, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
    }

    public ArticleModel(String string, String string2, long l3, String string4, String string5, int i6, Integer integer7, String string8, String string9, List<app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag> list10, String string11) {
        n.f(string, "id");
        n.f(string2, "locale");
        n.f(string5, "title");
        n.f(i6, "text");
        n.f(string9, "category");
        n.f(string11, "tags");
        super();
        this.id = string;
        this.locale = string2;
        this.updatedAt = l3;
        this.title = string5;
        this.text = i6;
        this.readingTime = integer7;
        this.sortOrder = string8;
        this.category = string9;
        this.image = list10;
        this.tags = string11;
        this.textHtml = obj13;
    }

    public ArticleModel(String string, String string2, long l3, String string4, String string5, int i6, Integer integer7, String string8, String string9, List list10, String string11, int i12, g g13) {
        String str;
        String str6;
        String str3;
        int i;
        String str4;
        String str5;
        int i4;
        int i2;
        int i3;
        String str2;
        List list;
        int i5 = g13;
        str6 = "";
        str = i5 & 1 != 0 ? str6 : string;
        str3 = i5 & 2 != 0 ? str6 : string2;
        i = i5 & 4 != 0 ? 0 : l3;
        str4 = i5 & 8 != 0 ? str6 : string5;
        str5 = i5 & 16 != 0 ? str6 : i6;
        i4 = i5 & 32 != 0 ? 0 : integer7;
        i2 = i5 & 64 != 0 ? i3 : string8;
        str2 = i5 & 128 != 0 ? str6 : string9;
        if (i5 & 256 != 0) {
        } else {
            i3 = list10;
        }
        if (i5 & 512 != 0) {
            list = p.g();
        } else {
            list = string11;
        }
        if (i5 &= 1024 != 0) {
        } else {
            str6 = i12;
        }
        super(str, str3, i, string5, str4, str5, i4, i2, str2, i3, list, str6);
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.ArticleModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.ArticleModel articleModel, String string2, String string3, long l4, String string5, String string6, int i7, Integer integer8, String string9, String string10, List list11, String string12, int i13, Object object14) {
        String textHtml;
        String str;
        String locale;
        long updatedAt;
        String title;
        String text;
        int readingTime;
        Integer sortOrder;
        String category;
        String image;
        List tags;
        Object obj = articleModel;
        int i = object14;
        str = i & 1 != 0 ? obj.id : string2;
        locale = i & 2 != 0 ? obj.locale : string3;
        updatedAt = i & 4 != 0 ? obj.updatedAt : l4;
        title = i & 8 != 0 ? obj.title : string6;
        text = i & 16 != 0 ? obj.text : i7;
        readingTime = i & 32 != 0 ? obj.readingTime : integer8;
        sortOrder = i & 64 != 0 ? obj.sortOrder : string9;
        category = i & 128 != 0 ? obj.category : string10;
        image = i & 256 != 0 ? obj.image : list11;
        tags = i & 512 != 0 ? obj.tags : string12;
        textHtml = i &= 1024 != 0 ? obj.textHtml : i13;
        return articleModel.copy(str, locale, updatedAt, string5, title, text, readingTime, sortOrder, category, image, tags);
    }

    public final String component1() {
        return this.id;
    }

    public final List<app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag> component10() {
        return this.tags;
    }

    public final String component11() {
        return this.textHtml;
    }

    public final String component2() {
        return this.locale;
    }

    public final long component3() {
        return this.updatedAt;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.text;
    }

    public final int component6() {
        return this.readingTime;
    }

    public final Integer component7() {
        return this.sortOrder;
    }

    public final String component8() {
        return this.category;
    }

    public final String component9() {
        return this.image;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ArticleModel copy(String string, String string2, long l3, String string4, String string5, int i6, Integer integer7, String string8, String string9, List<app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag> list10, String string11) {
        n.f(string, "id");
        final Object obj = string2;
        n.f(obj, "locale");
        final Object obj2 = string5;
        n.f(obj2, "title");
        final Object obj3 = i6;
        n.f(obj3, "text");
        final Object obj4 = string9;
        n.f(obj4, "category");
        final Object obj5 = string11;
        n.f(obj5, "tags");
        super(string, obj, l3, obj5, obj2, obj3, integer7, string8, obj4, list10, obj5, obj26);
        return articleModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ArticleModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.title, object.title)) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        if (this.readingTime != object.readingTime) {
            return i2;
        }
        if (!n.b(this.sortOrder, object.sortOrder)) {
            return i2;
        }
        if (!n.b(this.category, object.category)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.tags, object.tags)) {
            return i2;
        }
        if (!n.b(this.textHtml, object.textHtml)) {
            return i2;
        }
        return i;
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

    public final List<app.dogo.com.dogo_android.model.trainingprogram.ArticleModel.ArticleTag> getTags() {
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

    public int hashCode() {
        int i;
        int i2;
        int i3;
        Integer sortOrder = this.sortOrder;
        i3 = 0;
        if (sortOrder == null) {
            i = i3;
        } else {
            i = sortOrder.hashCode();
        }
        String image = this.image;
        if (image == null) {
            i2 = i3;
        } else {
            i2 = image.hashCode();
        }
        String textHtml = this.textHtml;
        if (textHtml == null) {
        } else {
            i3 = textHtml.hashCode();
        }
        return i23 += i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ArticleModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", title=");
        stringBuilder.append(this.title);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(", readingTime=");
        stringBuilder.append(this.readingTime);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", category=");
        stringBuilder.append(this.category);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append(", textHtml=");
        stringBuilder.append(this.textHtml);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
