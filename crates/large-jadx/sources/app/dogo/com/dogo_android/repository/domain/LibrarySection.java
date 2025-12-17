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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u00010Bc\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\u000f\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003Jm\u0010\"\u001a\u00020\u00002\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020$HÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0012R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0012R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a¨\u00061", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "Landroid/os/Parcelable;", "articles", "", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "programDescriptions", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "id", "", "name", "type", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "tags", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;Ljava/util/List;)V", "getArticles", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getName", "getProgramDescriptions", "getTags", "getTricks", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SectionType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LibrarySection implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibrarySection> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.Article> articles;
    private final String id;
    private final String name;
    private final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> programDescriptions;
    private final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> tags;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> tricks;
    private final app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibrarySection> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibrarySection createFromParcel(Parcel parcel) {
            int int2;
            int int;
            int int3;
            int fromParcel3;
            int i;
            ArrayList arrayList;
            int fromParcel;
            Object fromParcel2;
            int i3;
            int i2;
            n.f(parcel, "parcel");
            fromParcel3 = 0;
            i = 0;
            if (parcel.readInt() == 0) {
                i3 = fromParcel3;
            } else {
                int2 = parcel.readInt();
                arrayList = new ArrayList(int2);
                fromParcel = i;
                while (fromParcel != int2) {
                    arrayList.add(Article.CREATOR.createFromParcel(parcel));
                    fromParcel++;
                }
                i3 = arrayList;
            }
            if (parcel.readInt() == 0) {
                i2 = fromParcel3;
            } else {
                int = parcel.readInt();
                arrayList = new ArrayList(int);
                fromParcel = i;
                while (fromParcel != int) {
                    arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                    fromParcel++;
                }
                i2 = arrayList;
            }
            if (parcel.readInt() != 0) {
                int3 = parcel.readInt();
                fromParcel3 = new ArrayList(int3);
                arrayList = i;
                while (arrayList != int3) {
                    fromParcel3.add(ProgramDescriptionItem.CREATOR.createFromParcel(parcel));
                    arrayList++;
                }
            }
            int int4 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int4);
            while (i != int4) {
                arrayList2.add(LibraryTag.CREATOR.createFromParcel(parcel));
                i++;
            }
            super(i3, i2, fromParcel3, parcel.readString(), parcel.readString(), LibrarySection.SectionType.valueOf(parcel.readString()), arrayList2);
            return obj14;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibrarySection[] newArray(int i) {
            return new LibrarySection[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibrarySection$SectionType;", "", "(Ljava/lang/String;I)V", "ARTICLE", "TRICK", "PROGRAM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum SectionType {

        ARTICLE,
        TRICK,
        PROGRAM;
        private static final app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType[] $values() {
            app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType[] arr = new LibrarySection.SectionType[3];
            return arr;
        }
    }
    static {
        LibrarySection.Creator creator = new LibrarySection.Creator();
        LibrarySection.CREATOR = creator;
    }

    public LibrarySection(List<app.dogo.com.dogo_android.repository.domain.Article> list, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType librarySection$SectionType6, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list7) {
        n.f(string4, "id");
        n.f(string5, "name");
        n.f(sectionType6, "type");
        n.f(list7, "tags");
        super();
        this.articles = list;
        this.tricks = list2;
        this.programDescriptions = list3;
        this.id = string4;
        this.name = string5;
        this.type = sectionType6;
        this.tags = list7;
    }

    public LibrarySection(List list, List list2, List list3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType librarySection$SectionType6, List list7, int i8, g g9) {
        int i;
        int i2;
        int i4;
        int i3;
        List list4;
        final int i9 = 0;
        i2 = i8 & 1 != 0 ? i9 : list;
        i4 = i8 & 2 != 0 ? i9 : list2;
        i3 = i8 & 4 != 0 ? i9 : list3;
        if (i8 & 64 != 0) {
            list4 = i;
        } else {
            list4 = list7;
        }
        super(i2, i4, i3, string4, string5, sectionType6, list4);
    }

    public static app.dogo.com.dogo_android.repository.domain.LibrarySection copy$default(app.dogo.com.dogo_android.repository.domain.LibrarySection librarySection, List list2, List list3, List list4, String string5, String string6, app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType librarySection$SectionType7, List list8, int i9, Object object10) {
        List obj6;
        List obj7;
        List obj8;
        String obj9;
        String obj10;
        app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType obj11;
        List obj12;
        if (i9 & 1 != 0) {
            obj6 = librarySection.articles;
        }
        if (i9 & 2 != 0) {
            obj7 = librarySection.tricks;
        }
        if (i9 & 4 != 0) {
            obj8 = librarySection.programDescriptions;
        }
        if (i9 & 8 != 0) {
            obj9 = librarySection.id;
        }
        if (i9 & 16 != 0) {
            obj10 = librarySection.name;
        }
        if (i9 & 32 != 0) {
            obj11 = librarySection.type;
        }
        if (i9 & 64 != 0) {
            obj12 = librarySection.tags;
        }
        return librarySection.copy(obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Article> component1() {
        return this.articles;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component2() {
        return this.tricks;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> component3() {
        return this.programDescriptions;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component5() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType component6() {
        return this.type;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> component7() {
        return this.tags;
    }

    public final app.dogo.com.dogo_android.repository.domain.LibrarySection copy(List<app.dogo.com.dogo_android.repository.domain.Article> list, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2, List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> list3, String string4, String string5, app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType librarySection$SectionType6, List<app.dogo.com.dogo_android.repository.domain.LibraryTag> list7) {
        n.f(string4, "id");
        n.f(string5, "name");
        n.f(sectionType6, "type");
        final Object obj = list7;
        n.f(obj, "tags");
        super(list, list2, list3, string4, string5, sectionType6, obj);
        return librarySection;
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
        if (!object instanceof LibrarySection) {
            return i2;
        }
        if (!n.b(this.articles, object.articles)) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        if (!n.b(this.programDescriptions, object.programDescriptions)) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        if (!n.b(this.tags, object.tags)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.Article> getArticles() {
        return this.articles;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> getProgramDescriptions() {
        return this.programDescriptions;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.LibraryTag> getTags() {
        return this.tags;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i2;
        int i3;
        int i;
        List articles = this.articles;
        i3 = 0;
        if (articles == null) {
            i2 = i3;
        } else {
            i2 = articles.hashCode();
        }
        List tricks = this.tricks;
        if (tricks == null) {
            i = i3;
        } else {
            i = tricks.hashCode();
        }
        List programDescriptions = this.programDescriptions;
        if (programDescriptions == null) {
        } else {
            i3 = programDescriptions.hashCode();
        }
        return i14 += i19;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LibrarySection(articles=");
        stringBuilder.append(this.articles);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(", programDescriptions=");
        stringBuilder.append(this.programDescriptions);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Object articles;
        Object iterator;
        Object programDescriptions;
        int size4;
        int next;
        int size3;
        int size2;
        boolean next2;
        int size;
        n.f(parcel, "out");
        articles = this.articles;
        next = 0;
        final int i = 1;
        if (articles == null) {
            parcel.writeInt(next);
        } else {
            parcel.writeInt(i);
            parcel.writeInt(articles.size());
            articles = articles.iterator();
            for (Article size2 : articles) {
                size2.writeToParcel(parcel, i2);
            }
        }
        iterator = this.tricks;
        if (iterator == null) {
            parcel.writeInt(next);
        } else {
            parcel.writeInt(i);
            parcel.writeInt(iterator.size());
            iterator = iterator.iterator();
            for (TrickItem size : iterator) {
                size.writeToParcel(parcel, i2);
            }
        }
        programDescriptions = this.programDescriptions;
        if (programDescriptions == null) {
            parcel.writeInt(next);
        } else {
            parcel.writeInt(i);
            parcel.writeInt(programDescriptions.size());
            programDescriptions = programDescriptions.iterator();
            for (ProgramDescriptionItem size4 : programDescriptions) {
                size4.writeToParcel(parcel, i2);
            }
        }
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.type.name());
        List tags = this.tags;
        parcel.writeInt(tags.size());
        Iterator iterator2 = tags.iterator();
        for (LibraryTag size3 : iterator2) {
            size3.writeToParcel(parcel, i2);
        }
    }
}
