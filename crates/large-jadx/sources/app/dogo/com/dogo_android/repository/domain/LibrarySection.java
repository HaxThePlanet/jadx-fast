package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: LibrarySection.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00010Bc\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\u000f\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003Jm\u0010\"\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020$HÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "Landroid/os/Parcelable;", "articles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programDescriptions", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "id", "", "name", "type", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;Ljava/util/List;)V", "getArticles", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getName", "getProgramDescriptions", "getTags", "getTricks", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SectionType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LibrarySection implements Parcelable {

    public static final Parcelable.Creator<LibrarySection> CREATOR = new LibrarySection$Creator<>();
    private final List<Article> articles;
    private final String id;
    private final String name;
    private final List<ProgramDescriptionItem> programDescriptions;
    private final List<LibraryTag> tags;
    private final List<TrickItem> tricks;
    private final LibrarySection.SectionType type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibrarySection> {
        @Override // android.os.Parcelable$Creator
        public final LibrarySection createFromParcel(Parcel parcel) {
            int i = 0;
            int i2 = 0;
            ArrayList arrayList;
            Object fromParcel;
            n.f(parcel, "parcel");
            i = 0;
            i2 = 0;
            if (parcel.readInt() == 0) {
            } else {
                int _int = parcel.readInt();
                arrayList = new ArrayList(_int);
                while (i2 != _int) {
                    arrayList.add(Article.CREATOR.createFromParcel(parcel));
                    i2 = i2 + 1;
                }
            }
            if (parcel.readInt() == 0) {
            } else {
                int _int2 = parcel.readInt();
                arrayList = new ArrayList(_int2);
                while (i2 != _int2) {
                    arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                    i2 = i2 + 1;
                }
            }
            if (parcel.readInt() != 0) {
                int _int3 = parcel.readInt();
                while (arrayList != _int3) {
                    new ArrayList(_int3).add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                    arrayList = arrayList + 1;
                }
            }
            int _int4 = parcel.readInt();
            final ArrayList arrayList3 = new ArrayList(_int4);
            while (i2 != _int4) {
                arrayList3.add(LibraryTag.CREATOR.createFromParcel(parcel));
                i2 = i2 + 1;
            }
            LibrarySection parcel2 = new LibrarySection(arrayList, arrayList, i, parcel.readString(), parcel.readString(), LibrarySection_SectionType.valueOf(parcel.readString()), arrayList3);
            return parcel2;
        }

        @Override // android.os.Parcelable$Creator
        public final LibrarySection[] newArray(int i) {
            return new LibrarySection[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "", "(Ljava/lang/String;I)V", "ARTICLE", "TRICK", "PROGRAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum SectionType {

        ARTICLE,
        PROGRAM,
        TRICK;
        private static final /* synthetic */ LibrarySection.SectionType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType[] arr = new LibrarySection.SectionType[3];
            return new LibrarySection.SectionType[] { LibrarySection_SectionType.ARTICLE, LibrarySection_SectionType.TRICK, LibrarySection_SectionType.PROGRAM };
        }
    }
    public LibrarySection(List<Article> list, List<TrickItem> list2, List<ProgramDescriptionItem> list3, String str, String str2, LibrarySection.SectionType sectionType, List<LibraryTag> list4) {
        n.f(str, "id");
        n.f(str2, "name");
        n.f(sectionType, "type");
        n.f(list4, "tags");
        super();
        this.articles = list;
        this.tricks = list2;
        this.programDescriptions = list3;
        this.id = str;
        this.name = str2;
        this.type = sectionType;
        this.tags = list4;
    }

    public final List<Article> getArticles() {
        return this.articles;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ProgramDescriptionItem> getProgramDescriptions() {
        return this.programDescriptions;
    }

    public final List<LibraryTag> getTags() {
        return this.tags;
    }

    public final List<TrickItem> getTricks() {
        return this.tricks;
    }

    public final LibrarySection.SectionType getType() {
        return this.type;
    }

    public /* synthetic */ LibrarySection(List list, List list2, List list3, String str, String str2, LibrarySection.SectionType sectionType, List list4, int i, g gVar) {
        List list22;
        List list32;
        List list72;
        final int i2 = 0;
        int r3 = i & 1 != 0 ? i2 : list;
        int r4 = i & 2 != 0 ? i2 : list2;
        int r5 = i & 4 != 0 ? i2 : list3;
        i = i & 64;
        list72 = i & 64 != 0 ? list72 : list4;
        this(list4, list22, list32, str, str2, sectionType, list72);
    }


    public static /* synthetic */ LibrarySection copy$default(LibrarySection librarySection, List list, List list2, List list3, String str, String str2, LibrarySection.SectionType sectionType, List list4, int i, Object object) {
        List list22;
        List object102;
        List list42;
        String str52;
        String str62;
        app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType sectionType72;
        List list82;
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
        if (i & 32 != 0) {
        }
        if (i & 64 != 0) {
        }
        return librarySection.copy(list22, object102, list42, str52, str62, sectionType72, list82);
    }

    /* operator */ public final List<Article> component1() {
        return this.articles;
    }

    /* operator */ public final List<TrickItem> component2() {
        return this.tricks;
    }

    /* operator */ public final List<ProgramDescriptionItem> component3() {
        return this.programDescriptions;
    }

    /* operator */ public final String component4() {
        return this.id;
    }

    /* operator */ public final String component5() {
        return this.name;
    }

    /* operator */ public final LibrarySection.SectionType component6() {
        return this.type;
    }

    /* operator */ public final List<LibraryTag> component7() {
        return this.tags;
    }

    public final LibrarySection copy(List<Article> articles, List<TrickItem> tricks, List<ProgramDescriptionItem> programDescriptions, String id, String name, LibrarySection.SectionType type, List<LibraryTag> tags) {
        n.f(id, "id");
        n.f(name, "name");
        n.f(type, "type");
        final Object tags2 = tags;
        n.f(tags2, "tags");
        LibrarySection librarySection = new LibrarySection(articles, tricks, programDescriptions, id, name, type, tags2);
        return librarySection;
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
        final boolean z8 = false;
        if (!(other instanceof LibrarySection)) {
            return false;
        }
        if (!n.b(this.articles, other.articles)) {
            return false;
        }
        if (!n.b(this.tricks, other.tricks)) {
            return false;
        }
        if (!n.b(this.programDescriptions, other.programDescriptions)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return !n.b(this.tags, other.tags) ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = 0;
        if (this.articles == null) {
        } else {
            i = this.articles.hashCode();
        }
        if (this.tricks == null) {
        } else {
            i = this.tricks.hashCode();
        }
        if (this.programDescriptions != null) {
            i = this.programDescriptions.hashCode();
        }
        return (i * 31) + i * 31 + i * 31 + this.id.hashCode() * 31 + this.name.hashCode() * 31 + this.type.hashCode() * 31 + this.tags.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LibrarySection(articles=";
        String str3 = ", tricks=";
        String str4 = ", programDescriptions=";
        String str5 = ", id=";
        String str6 = ", name=";
        String str7 = ", type=";
        String str8 = ", tags=";
        str = str2 + this.articles + str3 + this.tricks + str4 + this.programDescriptions + str5 + this.id + str6 + this.name + str7 + this.type + str8 + this.tags + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        boolean hasNext;
        n.f(parcel, "out");
        int i = 0;
        final int i2 = 1;
        if (this.articles == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.articles.size());
            Iterator it = this.articles.iterator();
            while (it.hasNext()) {
                (Article)it.next().writeToParcel(parcel, flags);
            }
        }
        if (this.tricks == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.tricks.size());
            Iterator it2 = this.tricks.iterator();
            while (it2.hasNext()) {
                (TrickItem)it2.next().writeToParcel(parcel, flags);
            }
        }
        if (this.programDescriptions == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i2);
            parcel.writeInt(this.programDescriptions.size());
            Iterator it3 = this.programDescriptions.iterator();
            while (it3.hasNext()) {
                (ProgramDescriptionItem)it3.next().writeToParcel(parcel, flags);
            }
        }
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.type.name());
        parcel.writeInt(this.tags.size());
        Iterator it4 = this.tags.iterator();
        while (it4.hasNext()) {
            (LibraryTag)it4.next().writeToParcel(parcel, flags);
        }
    }
}
