package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B}\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c\u0012\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000c¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000cHÆ\u0003J\u0086\u0001\u0010%\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000cHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00032\u0008\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0002\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0004\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Library;", "", "isDogPremiumContentLocked", "", "isUserPremiumContentLocked", "trickSection", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "gamesSection", "skillsSection", "articleSection", "programSection", "articles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Ljava/util/List;)V", "getArticleSection", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getArticles", "()Ljava/util/List;", "getGamesSection", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProgramSection", "getSkillsSection", "getTrickSection", "getTricks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Ljava/util/List;)Lapp/dogo/com/dogo_android/repository/domain/Library;", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Library {

    private final app.dogo.com.dogo_android.repository.domain.LibrarySection articleSection;
    private final List<app.dogo.com.dogo_android.repository.domain.Article> articles;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection gamesSection;
    private final Boolean isDogPremiumContentLocked;
    private final Boolean isUserPremiumContentLocked;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection programSection;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection skillsSection;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection trickSection;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> tricks;
    public Library() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, 0);
    }

    public Library(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection3, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection4, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection5, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection6, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection7, List<app.dogo.com.dogo_android.repository.domain.Article> list8, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list9) {
        super();
        this.isDogPremiumContentLocked = boolean;
        this.isUserPremiumContentLocked = boolean2;
        this.trickSection = librarySection3;
        this.gamesSection = librarySection4;
        this.skillsSection = librarySection5;
        this.articleSection = librarySection6;
        this.programSection = librarySection7;
        this.articles = list8;
        this.tricks = list9;
    }

    public Library(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection3, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection4, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection5, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection6, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection7, List list8, List list9, int i10, g g11) {
        Boolean fALSE;
        Boolean fALSE2;
        int i;
        int i5;
        int i2;
        int i3;
        int i6;
        int i7;
        int i4;
        int i8 = i10;
        fALSE = i8 & 1 != 0 ? Boolean.FALSE : boolean;
        fALSE2 = i8 & 2 != 0 ? Boolean.FALSE : boolean2;
        i5 = 0;
        i = i8 & 4 != 0 ? i5 : librarySection3;
        i2 = i8 & 8 != 0 ? i5 : librarySection4;
        i3 = i8 & 16 != 0 ? i5 : librarySection5;
        i6 = i8 & 32 != 0 ? i5 : librarySection6;
        i7 = i8 & 64 != 0 ? i5 : librarySection7;
        i4 = i8 & 128 != 0 ? i5 : list8;
        if (i8 &= 256 != 0) {
        } else {
            i5 = list9;
        }
        super(fALSE, fALSE2, i, i2, i3, i6, i7, i4, i5);
    }

    public static app.dogo.com.dogo_android.repository.domain.Library copy$default(app.dogo.com.dogo_android.repository.domain.Library library, Boolean boolean2, Boolean boolean3, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection4, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection5, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection6, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection7, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection8, List list9, List list10, int i11, Object object12) {
        List tricks;
        Boolean isDogPremiumContentLocked;
        Boolean isUserPremiumContentLocked;
        app.dogo.com.dogo_android.repository.domain.LibrarySection trickSection;
        app.dogo.com.dogo_android.repository.domain.LibrarySection gamesSection;
        app.dogo.com.dogo_android.repository.domain.LibrarySection skillsSection;
        app.dogo.com.dogo_android.repository.domain.LibrarySection articleSection;
        app.dogo.com.dogo_android.repository.domain.LibrarySection programSection;
        List articles;
        Object obj = library;
        int i = i11;
        isDogPremiumContentLocked = i & 1 != 0 ? obj.isDogPremiumContentLocked : boolean2;
        isUserPremiumContentLocked = i & 2 != 0 ? obj.isUserPremiumContentLocked : boolean3;
        trickSection = i & 4 != 0 ? obj.trickSection : librarySection4;
        gamesSection = i & 8 != 0 ? obj.gamesSection : librarySection5;
        skillsSection = i & 16 != 0 ? obj.skillsSection : librarySection6;
        articleSection = i & 32 != 0 ? obj.articleSection : librarySection7;
        programSection = i & 64 != 0 ? obj.programSection : librarySection8;
        articles = i & 128 != 0 ? obj.articles : list9;
        tricks = i &= 256 != 0 ? obj.tricks : list10;
        return library.copy(isDogPremiumContentLocked, isUserPremiumContentLocked, trickSection, gamesSection, skillsSection, articleSection, programSection, articles, tricks);
    }

    public final Boolean component1() {
        return this.isDogPremiumContentLocked;
    }

    public final Boolean component2() {
        return this.isUserPremiumContentLocked;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component3() {
        return this.trickSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component4() {
        return this.gamesSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component5() {
        return this.skillsSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component6() {
        return this.articleSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection component7() {
        return this.programSection;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Article> component8() {
        return this.articles;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component9() {
        return this.tricks;
    }

    public final app.dogo.com.dogo_android.repository.domain.Library copy(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection3, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection4, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection5, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection6, app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection7, List<app.dogo.com.dogo_android.repository.domain.Article> list8, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list9) {
        super(boolean, boolean2, librarySection3, librarySection4, librarySection5, librarySection6, librarySection7, list8, list9);
        return library2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Library) {
            return i2;
        }
        if (!n.b(this.isDogPremiumContentLocked, object.isDogPremiumContentLocked)) {
            return i2;
        }
        if (!n.b(this.isUserPremiumContentLocked, object.isUserPremiumContentLocked)) {
            return i2;
        }
        if (!n.b(this.trickSection, object.trickSection)) {
            return i2;
        }
        if (!n.b(this.gamesSection, object.gamesSection)) {
            return i2;
        }
        if (!n.b(this.skillsSection, object.skillsSection)) {
            return i2;
        }
        if (!n.b(this.articleSection, object.articleSection)) {
            return i2;
        }
        if (!n.b(this.programSection, object.programSection)) {
            return i2;
        }
        if (!n.b(this.articles, object.articles)) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        return i;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getArticleSection() {
        return this.articleSection;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Article> getArticles() {
        return this.articles;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getGamesSection() {
        return this.gamesSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getProgramSection() {
        return this.programSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getSkillsSection() {
        return this.skillsSection;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection getTrickSection() {
        return this.trickSection;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTricks() {
        return this.tricks;
    }

    public int hashCode() {
        int i5;
        int i8;
        int i9;
        int i3;
        int i;
        int i7;
        int i2;
        int i6;
        int i4;
        Boolean isDogPremiumContentLocked = this.isDogPremiumContentLocked;
        i8 = 0;
        if (isDogPremiumContentLocked == null) {
            i5 = i8;
        } else {
            i5 = isDogPremiumContentLocked.hashCode();
        }
        Boolean isUserPremiumContentLocked = this.isUserPremiumContentLocked;
        if (isUserPremiumContentLocked == null) {
            i9 = i8;
        } else {
            i9 = isUserPremiumContentLocked.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.LibrarySection trickSection = this.trickSection;
        if (trickSection == null) {
            i3 = i8;
        } else {
            i3 = trickSection.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.LibrarySection gamesSection = this.gamesSection;
        if (gamesSection == null) {
            i = i8;
        } else {
            i = gamesSection.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.LibrarySection skillsSection = this.skillsSection;
        if (skillsSection == null) {
            i7 = i8;
        } else {
            i7 = skillsSection.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.LibrarySection articleSection = this.articleSection;
        if (articleSection == null) {
            i2 = i8;
        } else {
            i2 = articleSection.hashCode();
        }
        app.dogo.com.dogo_android.repository.domain.LibrarySection programSection = this.programSection;
        if (programSection == null) {
            i6 = i8;
        } else {
            i6 = programSection.hashCode();
        }
        List articles = this.articles;
        if (articles == null) {
            i4 = i8;
        } else {
            i4 = articles.hashCode();
        }
        List tricks = this.tricks;
        if (tricks == null) {
        } else {
            i8 = tricks.hashCode();
        }
        return i24 += i8;
    }

    public final Boolean isDogPremiumContentLocked() {
        return this.isDogPremiumContentLocked;
    }

    public final Boolean isUserPremiumContentLocked() {
        return this.isUserPremiumContentLocked;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Library(isDogPremiumContentLocked=");
        stringBuilder.append(this.isDogPremiumContentLocked);
        stringBuilder.append(", isUserPremiumContentLocked=");
        stringBuilder.append(this.isUserPremiumContentLocked);
        stringBuilder.append(", trickSection=");
        stringBuilder.append(this.trickSection);
        stringBuilder.append(", gamesSection=");
        stringBuilder.append(this.gamesSection);
        stringBuilder.append(", skillsSection=");
        stringBuilder.append(this.skillsSection);
        stringBuilder.append(", articleSection=");
        stringBuilder.append(this.articleSection);
        stringBuilder.append(", programSection=");
        stringBuilder.append(this.programSection);
        stringBuilder.append(", articles=");
        stringBuilder.append(this.articles);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
