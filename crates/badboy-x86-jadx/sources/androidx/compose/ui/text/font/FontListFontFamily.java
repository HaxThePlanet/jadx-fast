package androidx.compose.ui.text.font;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002B\u0015\u0008\u0000\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0003J\u0017\u0010\u000f\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001J\u0013\u0010\u0012\u001a\u00020\r2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\tH\u0096\u0003J\u0008\u0010\u0017\u001a\u00020\tH\u0016J\u0011\u0010\u0018\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0019\u001a\u00020\rH\u0096\u0001J\u000f\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001bH\u0096\u0003J\u0011\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096\u0001J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001eH\u0096\u0001J\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u0016\u001a\u00020\tH\u0096\u0001J\u001f\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0096\u0001J\u0008\u0010\"\u001a\u00020#H\u0016R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006$", d2 = {"Landroidx/compose/ui/text/font/FontListFontFamily;", "Landroidx/compose/ui/text/font/FileBasedFontFamily;", "", "Landroidx/compose/ui/text/font/Font;", "fonts", "(Ljava/util/List;)V", "getFonts", "()Ljava/util/List;", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "get", "index", "hashCode", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontListFontFamily extends androidx.compose.ui.text.font.FileBasedFontFamily implements List<androidx.compose.ui.text.font.Font>, KMappedMarker {

    public static final int $stable;
    private final List<androidx.compose.ui.text.font.Font> fonts;
    static {
    }

    public FontListFontFamily(List<? extends androidx.compose.ui.text.font.Font> fonts) {
        super(0);
        this.fonts = fonts;
        if ((Collection)this.fonts.isEmpty()) {
        } else {
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("At least one font should be passed to FontFamily".toString());
        throw illegalStateException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public void add(int i, androidx.compose.ui.text.font.Font font2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public void add(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean add(androidx.compose.ui.text.font.Font font) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends androidx.compose.ui.text.font.Font> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends androidx.compose.ui.text.font.Font> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean contains(androidx.compose.ui.text.font.Font font) {
        return this.fonts.contains(font);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public final boolean contains(Object element) {
        if (!element instanceof Font) {
            return 0;
        }
        return contains((Font)element);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.fonts.containsAll(collection);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof FontListFontFamily) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.fonts, obj.fonts)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public androidx.compose.ui.text.font.Font get(int i) {
        return (Font)this.fonts.get(i);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public Object get(int index) {
        return get(index);
    }

    public final List<androidx.compose.ui.text.font.Font> getFonts() {
        return this.fonts;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public int getSize() {
        return this.fonts.size();
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public int hashCode() {
        return this.fonts.hashCode();
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public int indexOf(androidx.compose.ui.text.font.Font font) {
        return this.fonts.indexOf(font);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public final int indexOf(Object element) {
        if (!element instanceof Font) {
            return -1;
        }
        return indexOf((Font)element);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean isEmpty() {
        return this.fonts.isEmpty();
    }

    public Iterator<androidx.compose.ui.text.font.Font> iterator() {
        return this.fonts.iterator();
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public int lastIndexOf(androidx.compose.ui.text.font.Font font) {
        return this.fonts.lastIndexOf(font);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public final int lastIndexOf(Object element) {
        if (!element instanceof Font) {
            return -1;
        }
        return lastIndexOf((Font)element);
    }

    public ListIterator<androidx.compose.ui.text.font.Font> listIterator() {
        return this.fonts.listIterator();
    }

    public ListIterator<androidx.compose.ui.text.font.Font> listIterator(int i) {
        return this.fonts.listIterator(i);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public androidx.compose.ui.text.font.Font remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public Object remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public boolean remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void replaceAll(UnaryOperator<androidx.compose.ui.text.font.Font> unaryOperator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public androidx.compose.ui.text.font.Font set(int i, androidx.compose.ui.text.font.Font font2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public Object set(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public final int size() {
        return getSize();
    }

    public void sort(Comparator<? super androidx.compose.ui.text.font.Font> comparator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List<androidx.compose.ui.text.font.Font> subList(int i, int i2) {
        return this.fonts.subList(i, i2);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }

    @Override // androidx.compose.ui.text.font.FileBasedFontFamily
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FontListFontFamily(fonts=").append(this.fonts).append(')').toString();
    }
}
