package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public final class SpannableBuilder extends SpannableStringBuilder {

    private final Class<?> mWatcherClass;
    private final List<androidx.emoji2.text.SpannableBuilder.WatcherWrapper> mWatchers;

    private static class WatcherWrapper implements TextWatcher, SpanWatcher {

        private final AtomicInteger mBlockCalls;
        final Object mObject;
        WatcherWrapper(Object object) {
            super();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            this.mBlockCalls = atomicInteger;
            this.mObject = object;
        }

        private boolean isEmojiSpan(Object span) {
            return span instanceof EmojiSpan;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            (TextWatcher)this.mObject.afterTextChanged(s);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) {
            (TextWatcher)this.mObject.beforeTextChanged(s, start, count, after);
        }

        @Override // android.text.TextWatcher
        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void onSpanAdded(Spannable text, Object what, int start, int end) {
            int emojiSpan;
            if (this.mBlockCalls.get() > 0 && isEmojiSpan(what)) {
                if (isEmojiSpan(what)) {
                }
            }
            (SpanWatcher)this.mObject.onSpanAdded(text, what, start, end);
        }

        @Override // android.text.TextWatcher
        public void onSpanChanged(Spannable text, Object what, int ostart, int oend, int nstart, int nend) {
            int emojiSpan;
            if (this.mBlockCalls.get() > 0 && isEmojiSpan(what)) {
                if (isEmojiSpan(what)) {
                }
            }
            (SpanWatcher)this.mObject.onSpanChanged(text, what, ostart, oend, nstart, nend);
        }

        @Override // android.text.TextWatcher
        public void onSpanRemoved(Spannable text, Object what, int start, int end) {
            int emojiSpan;
            if (this.mBlockCalls.get() > 0 && isEmojiSpan(what)) {
                if (isEmojiSpan(what)) {
                }
            }
            (SpanWatcher)this.mObject.onSpanRemoved(text, what, start, end);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) {
            (TextWatcher)this.mObject.onTextChanged(s, start, before, count);
        }

        @Override // android.text.TextWatcher
        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }
    SpannableBuilder(Class<?> class) {
        super();
        ArrayList arrayList = new ArrayList();
        this.mWatchers = arrayList;
        Preconditions.checkNotNull(class, "watcherClass cannot be null");
        this.mWatcherClass = class;
    }

    SpannableBuilder(Class<?> class, java.lang.CharSequence text) {
        super(text);
        ArrayList arrayList = new ArrayList();
        this.mWatchers = arrayList;
        Preconditions.checkNotNull(class, "watcherClass cannot be null");
        this.mWatcherClass = class;
    }

    SpannableBuilder(Class<?> class, java.lang.CharSequence text, int start, int end) {
        super(text, start, end);
        ArrayList arrayList = new ArrayList();
        this.mWatchers = arrayList;
        Preconditions.checkNotNull(class, "watcherClass cannot be null");
        this.mWatcherClass = class;
    }

    private void blockWatchers() {
        int i;
        Object obj;
        i = 0;
        while (i < this.mWatchers.size()) {
            (SpannableBuilder.WatcherWrapper)this.mWatchers.get(i).blockCalls();
            i++;
        }
    }

    public static androidx.emoji2.text.SpannableBuilder create(Class<?> class, java.lang.CharSequence text) {
        SpannableBuilder spannableBuilder = new SpannableBuilder(class, text);
        return spannableBuilder;
    }

    private void fireWatchers() {
        int i;
        Object obj;
        int length;
        int length2;
        int i2;
        i = 0;
        while (i < this.mWatchers.size()) {
            (SpannableBuilder.WatcherWrapper)this.mWatchers.get(i).onTextChanged(this, 0, length(), length());
            i++;
        }
    }

    private androidx.emoji2.text.SpannableBuilder.WatcherWrapper getWatcherFor(Object object) {
        int i;
        Object obj;
        Object mObject;
        i = 0;
        while (i < this.mWatchers.size()) {
            obj = this.mWatchers.get(i);
            i++;
        }
        return null;
    }

    private boolean isWatcher(Class<?> class) {
        int i;
        i = this.mWatcherClass == class ? 1 : 0;
        return i;
    }

    private boolean isWatcher(Object object) {
        boolean watcher;
        int i;
        if (object != null && isWatcher(object.getClass())) {
            i = isWatcher(object.getClass()) ? 1 : 0;
        } else {
        }
        return i;
    }

    private void unblockwatchers() {
        int i;
        Object obj;
        i = 0;
        while (i < this.mWatchers.size()) {
            (SpannableBuilder.WatcherWrapper)this.mWatchers.get(i).unblockCalls();
            i++;
        }
    }

    @Override // android.text.SpannableStringBuilder
    public Editable append(char c) {
        return append(c);
    }

    @Override // android.text.SpannableStringBuilder
    public Editable append(java.lang.CharSequence charSequence) {
        return append(charSequence);
    }

    @Override // android.text.SpannableStringBuilder
    public Editable append(java.lang.CharSequence charSequence, int i2, int i3) {
        return append(charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(char text) {
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(java.lang.CharSequence text) {
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(java.lang.CharSequence text, int start, int end) {
        super.append(text, start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(java.lang.CharSequence text, Object what, int flags) {
        super.append(text, what, flags);
        return this;
    }

    public java.lang.Appendable append(char c) throws IOException {
        return append(c);
    }

    public java.lang.Appendable append(java.lang.CharSequence charSequence) throws IOException {
        return append(charSequence);
    }

    public java.lang.Appendable append(java.lang.CharSequence charSequence, int i2, int i3) throws IOException {
        return append(charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder
    public void beginBatchEdit() {
        blockWatchers();
    }

    @Override // android.text.SpannableStringBuilder
    public Editable delete(int i, int i2) {
        return delete(i, i2);
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    @Override // android.text.SpannableStringBuilder
    public int getSpanEnd(Object tag) {
        boolean watcherFor;
        Object obj2;
        watcherFor = getWatcherFor(tag);
        if (isWatcher(tag) && watcherFor != null) {
            watcherFor = getWatcherFor(tag);
            if (watcherFor != null) {
                obj2 = watcherFor;
            }
        }
        return super.getSpanEnd(obj2);
    }

    @Override // android.text.SpannableStringBuilder
    public int getSpanFlags(Object tag) {
        boolean watcherFor;
        Object obj2;
        watcherFor = getWatcherFor(tag);
        if (isWatcher(tag) && watcherFor != null) {
            watcherFor = getWatcherFor(tag);
            if (watcherFor != null) {
                obj2 = watcherFor;
            }
        }
        return super.getSpanFlags(obj2);
    }

    @Override // android.text.SpannableStringBuilder
    public int getSpanStart(Object tag) {
        boolean watcherFor;
        Object obj2;
        watcherFor = getWatcherFor(tag);
        if (isWatcher(tag) && watcherFor != null) {
            watcherFor = getWatcherFor(tag);
            if (watcherFor != null) {
                obj2 = watcherFor;
            }
        }
        return super.getSpanStart(obj2);
    }

    public <T> T[] getSpans(int queryStart, int queryEnd, Class<T> class3) {
        int i;
        Object mObject;
        if (isWatcher(class3)) {
            Object[] spans2 = super.getSpans(queryStart, queryEnd, SpannableBuilder.WatcherWrapper.class);
            Object instance = Array.newInstance(class3, spans2.length);
            i = 0;
            for (Object obj2 : obj0) {
                (Object[])instance[i] = obj2.mObject;
            }
            return instance;
        }
        return super.getSpans(queryStart, queryEnd, class3);
    }

    @Override // android.text.SpannableStringBuilder
    public Editable insert(int i, java.lang.CharSequence charSequence2) {
        return insert(i, charSequence2);
    }

    @Override // android.text.SpannableStringBuilder
    public Editable insert(int i, java.lang.CharSequence charSequence2, int i3, int i4) {
        return insert(i, charSequence2, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder insert(int where, java.lang.CharSequence tb) {
        super.insert(where, tb);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder insert(int where, java.lang.CharSequence tb, int start, int end) {
        super.insert(where, tb, start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public int nextSpanTransition(int start, int limit, Class type) {
        boolean watcher;
        Class obj4;
        if (type != null) {
            if (isWatcher(type)) {
                obj4 = SpannableBuilder.WatcherWrapper.class;
            }
        } else {
        }
        return super.nextSpanTransition(start, limit, obj4);
    }

    @Override // android.text.SpannableStringBuilder
    public void removeSpan(Object what) {
        int watcher;
        List mWatchers;
        Object obj3;
        if (isWatcher(what)) {
            watcher = getWatcherFor(what);
            if (watcher != null) {
                obj3 = watcher;
            }
        } else {
            watcher = 0;
        }
        super.removeSpan(obj3);
        if (watcher != 0) {
            this.mWatchers.remove(watcher);
        }
    }

    @Override // android.text.SpannableStringBuilder
    public Editable replace(int i, int i2, java.lang.CharSequence charSequence3) {
        return replace(i, i2, charSequence3);
    }

    @Override // android.text.SpannableStringBuilder
    public Editable replace(int i, int i2, java.lang.CharSequence charSequence3, int i4, int i5) {
        return replace(i, i2, charSequence3, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb) {
        blockWatchers();
        super.replace(start, end, tb);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb, int tbstart, int tbend) {
        blockWatchers();
        super.replace(start, end, tb, tbstart, tbend);
        final int i = tbend;
        final int obj6 = tbstart;
        final java.lang.CharSequence obj5 = tb;
        final int obj4 = end;
        final int obj3 = start;
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public void setSpan(Object what, int start, int end, int flags) {
        boolean watcherWrapper;
        List mWatchers;
        Object obj3;
        if (isWatcher(what)) {
            watcherWrapper = new SpannableBuilder.WatcherWrapper(what);
            this.mWatchers.add(watcherWrapper);
            obj3 = watcherWrapper;
        }
        super.setSpan(obj3, start, end, flags);
    }

    @Override // android.text.SpannableStringBuilder
    public java.lang.CharSequence subSequence(int start, int end) {
        SpannableBuilder spannableBuilder = new SpannableBuilder(this.mWatcherClass, this, start, end);
        return spannableBuilder;
    }
}
