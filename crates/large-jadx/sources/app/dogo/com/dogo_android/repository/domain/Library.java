package app.dogo.com.dogo_android.repository.domain;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: Library.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B}\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c\u0012\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000c¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000cHÆ\u0003J\u0086\u0001\u0010%\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c2\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000cHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u00032\u0008\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0002\u0010\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0004\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0014¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/Library;", "", "isDogPremiumContentLocked", "", "isUserPremiumContentLocked", "trickSection", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "gamesSection", "skillsSection", "articleSection", "programSection", "articles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Ljava/util/List;)V", "getArticleSection", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getArticles", "()Ljava/util/List;", "getGamesSection", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProgramSection", "getSkillsSection", "getTrickSection", "getTricks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;Ljava/util/List;Ljava/util/List;)Lapp/dogo/com/dogo_android/repository/domain/Library;", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class Library {

    private final LibrarySection articleSection;
    private final List<Article> articles;
    private final LibrarySection gamesSection;
    private final Boolean isDogPremiumContentLocked;
    private final Boolean isUserPremiumContentLocked;
    private final LibrarySection programSection;
    private final LibrarySection skillsSection;
    private final LibrarySection trickSection;
    private final List<TrickItem> tricks;
    public Library(Boolean boolean, Boolean boolean2, LibrarySection librarySection, LibrarySection librarySection2, LibrarySection librarySection3, LibrarySection librarySection4, LibrarySection librarySection5, List<Article> list, List<TrickItem> list2) {
        super();
        this.isDogPremiumContentLocked = boolean;
        this.isUserPremiumContentLocked = boolean2;
        this.trickSection = librarySection;
        this.gamesSection = librarySection2;
        this.skillsSection = librarySection3;
        this.articleSection = librarySection4;
        this.programSection = librarySection5;
        this.articles = list;
        this.tricks = list2;
    }

    public final LibrarySection getArticleSection() {
        return this.articleSection;
    }

    public final List<Article> getArticles() {
        return this.articles;
    }

    public final LibrarySection getGamesSection() {
        return this.gamesSection;
    }

    public final LibrarySection getProgramSection() {
        return this.programSection;
    }

    public final LibrarySection getSkillsSection() {
        return this.skillsSection;
    }

    public final LibrarySection getTrickSection() {
        return this.trickSection;
    }

    public final List<TrickItem> getTricks() {
        return this.tricks;
    }

    public final Boolean isDogPremiumContentLocked() {
        return this.isDogPremiumContentLocked;
    }

    public final Boolean isUserPremiumContentLocked() {
        return this.isUserPremiumContentLocked;
    }

    public /* synthetic */ Library(Boolean boolean, Boolean boolean2, LibrarySection librarySection, LibrarySection librarySection2, LibrarySection librarySection3, LibrarySection librarySection4, LibrarySection librarySection5, List list, List list2, int i, g gVar) {
        Boolean boolean3;
        Boolean boolean22;
        int librarySection32;
        int i102 = i;
        Boolean r1 = i102 & 1 != 0 ? Boolean.FALSE : boolean;
        Boolean r2 = i102 & 2 != 0 ? Boolean.FALSE : boolean2;
        librarySection32 = 0;
        int r3 = i102 & 4 != 0 ? librarySection32 : librarySection;
        int r5 = i102 & 8 != 0 ? librarySection32 : librarySection2;
        int r6 = i102 & 16 != 0 ? librarySection32 : librarySection3;
        int r7 = i102 & 32 != 0 ? librarySection32 : librarySection4;
        int r8 = i102 & 64 != 0 ? librarySection32 : librarySection5;
        int r9 = i102 & 128 != 0 ? librarySection32 : list;
        if (i102 & 256 == 0) {
            librarySection32 = list2;
        }
        this(boolean3, boolean22, librarySection32, librarySection32, librarySection32, librarySection32, librarySection32, librarySection32, librarySection32);
    }

    public Library() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ Library copy$default(Library library, Boolean boolean, Boolean boolean2, LibrarySection librarySection, LibrarySection librarySection2, LibrarySection librarySection3, LibrarySection librarySection4, LibrarySection librarySection5, List list, List list2, int i, Object object) {
        List list102;
        Boolean boolean22;
        Boolean boolean32;
        app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection42;
        app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection52;
        app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection62;
        app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection72;
        app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection82;
        List list92;
        Object library2 = library;
        int i112 = i;
        Boolean r2 = i112 & 1 != 0 ? library2.isDogPremiumContentLocked : boolean;
        Boolean r3 = i112 & 2 != 0 ? library2.isUserPremiumContentLocked : boolean2;
        app.dogo.com.dogo_android.repository.domain.LibrarySection r4 = i112 & 4 != 0 ? library2.trickSection : librarySection;
        app.dogo.com.dogo_android.repository.domain.LibrarySection r5 = i112 & 8 != 0 ? library2.gamesSection : librarySection2;
        app.dogo.com.dogo_android.repository.domain.LibrarySection r6 = i112 & 16 != 0 ? library2.skillsSection : librarySection3;
        app.dogo.com.dogo_android.repository.domain.LibrarySection r7 = i112 & 32 != 0 ? library2.articleSection : librarySection4;
        app.dogo.com.dogo_android.repository.domain.LibrarySection r8 = i112 & 64 != 0 ? library2.programSection : librarySection5;
        List r9 = i112 & 128 != 0 ? library2.articles : list;
        List r1 = i112 & 256 != 0 ? library2.tricks : list2;
        return library.copy(boolean22, boolean32, librarySection42, librarySection52, librarySection62, librarySection72, librarySection82, list92, (i112 & 256 != 0 ? library2.tricks : list2));
    }

    /* operator */ public final Boolean component1() {
        return this.isDogPremiumContentLocked;
    }

    /* operator */ public final Boolean component2() {
        return this.isUserPremiumContentLocked;
    }

    /* operator */ public final LibrarySection component3() {
        return this.trickSection;
    }

    /* operator */ public final LibrarySection component4() {
        return this.gamesSection;
    }

    /* operator */ public final LibrarySection component5() {
        return this.skillsSection;
    }

    /* operator */ public final LibrarySection component6() {
        return this.articleSection;
    }

    /* operator */ public final LibrarySection component7() {
        return this.programSection;
    }

    /* operator */ public final List<Article> component8() {
        return this.articles;
    }

    /* operator */ public final List<TrickItem> component9() {
        return this.tricks;
    }

    public final Library copy(Boolean isDogPremiumContentLocked, Boolean isUserPremiumContentLocked, LibrarySection trickSection, LibrarySection gamesSection, LibrarySection skillsSection, LibrarySection articleSection, LibrarySection programSection, List<Article> articles, List<TrickItem> tricks) {
        Library library = new Library(isDogPremiumContentLocked, isUserPremiumContentLocked, trickSection, gamesSection, skillsSection, articleSection, programSection, articles, tricks);
        return library;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z11 = false;
        if (!(other instanceof Library)) {
            return false;
        }
        if (!n.b(this.isDogPremiumContentLocked, other.isDogPremiumContentLocked)) {
            return false;
        }
        if (!n.b(this.isUserPremiumContentLocked, other.isUserPremiumContentLocked)) {
            return false;
        }
        if (!n.b(this.trickSection, other.trickSection)) {
            return false;
        }
        if (!n.b(this.gamesSection, other.gamesSection)) {
            return false;
        }
        if (!n.b(this.skillsSection, other.skillsSection)) {
            return false;
        }
        if (!n.b(this.articleSection, other.articleSection)) {
            return false;
        }
        if (!n.b(this.programSection, other.programSection)) {
            return false;
        }
        if (!n.b(this.articles, other.articles)) {
            return false;
        }
        return !n.b(this.tricks, other.tricks) ? z11 : z;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.isDogPremiumContentLocked == null) {
        } else {
            i = this.isDogPremiumContentLocked.hashCode();
        }
        if (this.isUserPremiumContentLocked == null) {
        } else {
            i = this.isUserPremiumContentLocked.hashCode();
        }
        if (this.trickSection == null) {
        } else {
            i = this.trickSection.hashCode();
        }
        if (this.gamesSection == null) {
        } else {
            i = this.gamesSection.hashCode();
        }
        if (this.skillsSection == null) {
        } else {
            i = this.skillsSection.hashCode();
        }
        if (this.articleSection == null) {
        } else {
            i = this.articleSection.hashCode();
        }
        if (this.programSection == null) {
        } else {
            i = this.programSection.hashCode();
        }
        if (this.articles == null) {
        } else {
            i = this.articles.hashCode();
        }
        if (this.tricks != null) {
            i = this.tricks.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Library(isDogPremiumContentLocked=";
        String str3 = ", isUserPremiumContentLocked=";
        String str4 = ", trickSection=";
        String str5 = ", gamesSection=";
        String str6 = ", skillsSection=";
        String str7 = ", articleSection=";
        String str8 = ", programSection=";
        String str9 = ", articles=";
        String str10 = ", tricks=";
        str = str2 + this.isDogPremiumContentLocked + str3 + this.isUserPremiumContentLocked + str4 + this.trickSection + str5 + this.gamesSection + str6 + this.skillsSection + str7 + this.articleSection + str8 + this.programSection + str9 + this.articles + str10 + this.tricks + 41;
        return str;
    }
}
