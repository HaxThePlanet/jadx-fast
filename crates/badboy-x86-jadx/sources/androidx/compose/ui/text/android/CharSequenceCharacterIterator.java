package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000c\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0008\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\rH\u0016J\u0008\u0010\u000f\u001a\u00020\u0006H\u0016J\u0008\u0010\u0010\u001a\u00020\u0006H\u0016J\u0008\u0010\u0011\u001a\u00020\u0006H\u0016J\u0008\u0010\u0012\u001a\u00020\rH\u0016J\t\u0010\u0013\u001a\u00020\rH\u0096\u0002J\u0008\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/lang/Object;", "Ljava/text/CharacterIterator;", "charSequence", "", "start", "", "end", "(Ljava/lang/CharSequence;II)V", "index", "clone", "", "current", "", "first", "getBeginIndex", "getEndIndex", "getIndex", "last", "next", "previous", "setIndex", "position", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CharSequenceCharacterIterator implements CharacterIterator {

    public static final int $stable = 8;
    private final java.lang.CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;
    static {
        final int i = 8;
    }

    public CharSequenceCharacterIterator(java.lang.CharSequence charSequence, int start, int end) {
        super();
        this.charSequence = charSequence;
        this.start = start;
        this.end = end;
        this.index = this.start;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        return super.clone();
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int charAt;
        int index;
        if (this.index == this.end) {
            charAt = 65535;
        } else {
            charAt = this.charSequence.charAt(this.index);
        }
        return charAt;
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int charAt;
        int index;
        if (this.start == this.end) {
            this.index = this.end;
            charAt = 65535;
        } else {
            this.index = end2--;
            charAt = this.charSequence.charAt(this.index);
        }
        return charAt;
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int charAt;
        int index;
        this.index = index2++;
        if (this.index >= this.end) {
            this.index = this.end;
            charAt = 65535;
        } else {
            charAt = this.charSequence.charAt(this.index);
        }
        return charAt;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int charAt;
        int start;
        if (this.index <= this.start) {
            charAt = 65535;
        } else {
            this.index = index2--;
            charAt = this.charSequence.charAt(this.index);
        }
        return charAt;
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int position) {
        int i;
        i = 0;
        if (position <= this.end && this.start <= position) {
            if (this.start <= position) {
                i = 1;
            }
        }
        if (i == 0) {
        } else {
            this.index = position;
            return current();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid position");
        throw illegalArgumentException;
    }
}
