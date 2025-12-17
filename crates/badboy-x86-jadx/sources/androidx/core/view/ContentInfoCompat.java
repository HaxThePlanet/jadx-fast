package androidx.core.view;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import android.view.ContentInfo.Builder;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: classes5.dex */
public final class ContentInfoCompat {

    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_AUTOFILL = 4;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public static final int SOURCE_PROCESS_TEXT = 5;
    private final androidx.core.view.ContentInfoCompat.Compat mCompat;

    private static final class Api31Impl {
        public static Pair<ContentInfo, ContentInfo> partition(ContentInfo payload, Predicate<ClipData.Item> predicate2) {
            int i;
            int i2;
            final ClipData clip = payload.getClip();
            i2 = 0;
            if (clip.getItemCount() == 1) {
                boolean test = predicate2.test(clip.getItemAt(0));
                i = test ? payload : i2;
                if (test) {
                } else {
                    i2 = payload;
                }
                return Pair.create(i, i2);
            }
            Objects.requireNonNull(predicate2);
            ContentInfoCompat.Api31Impl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ContentInfoCompat.Api31Impl$$ExternalSyntheticLambda0(predicate2);
            Pair partition = ContentInfoCompat.partition(clip, externalSyntheticLambda0);
            if (partition.first == null) {
                return Pair.create(i2, payload);
            }
            if (partition.second == null) {
                return Pair.create(payload, i2);
            }
            ContentInfo.Builder builder = new ContentInfo.Builder(payload);
            ContentInfo.Builder builder2 = new ContentInfo.Builder(payload);
            return Pair.create(builder.setClip((ClipData)partition.first).build(), builder2.setClip((ClipData)partition.second).build());
        }
    }

    public static final class Builder {

        private final androidx.core.view.ContentInfoCompat.BuilderCompat mBuilderCompat;
        public Builder(ClipData clip, int source) {
            Object builderCompat31Impl;
            super();
            if (Build.VERSION.SDK_INT >= 31) {
                builderCompat31Impl = new ContentInfoCompat.BuilderCompat31Impl(clip, source);
                this.mBuilderCompat = builderCompat31Impl;
            } else {
                builderCompat31Impl = new ContentInfoCompat.BuilderCompatImpl(clip, source);
                this.mBuilderCompat = builderCompat31Impl;
            }
        }

        public Builder(androidx.core.view.ContentInfoCompat other) {
            Object builderCompat31Impl;
            super();
            if (Build.VERSION.SDK_INT >= 31) {
                builderCompat31Impl = new ContentInfoCompat.BuilderCompat31Impl(other);
                this.mBuilderCompat = builderCompat31Impl;
            } else {
                builderCompat31Impl = new ContentInfoCompat.BuilderCompatImpl(other);
                this.mBuilderCompat = builderCompat31Impl;
            }
        }

        public androidx.core.view.ContentInfoCompat build() {
            return this.mBuilderCompat.build();
        }

        public androidx.core.view.ContentInfoCompat.Builder setClip(ClipData clip) {
            this.mBuilderCompat.setClip(clip);
            return this;
        }

        public androidx.core.view.ContentInfoCompat.Builder setExtras(Bundle extras) {
            this.mBuilderCompat.setExtras(extras);
            return this;
        }

        public androidx.core.view.ContentInfoCompat.Builder setFlags(int flags) {
            this.mBuilderCompat.setFlags(flags);
            return this;
        }

        public androidx.core.view.ContentInfoCompat.Builder setLinkUri(Uri linkUri) {
            this.mBuilderCompat.setLinkUri(linkUri);
            return this;
        }

        public androidx.core.view.ContentInfoCompat.Builder setSource(int source) {
            this.mBuilderCompat.setSource(source);
            return this;
        }
    }

    private interface BuilderCompat {
        public abstract androidx.core.view.ContentInfoCompat build();

        public abstract void setClip(ClipData clipData);

        public abstract void setExtras(Bundle bundle);

        public abstract void setFlags(int i);

        public abstract void setLinkUri(Uri uri);

        public abstract void setSource(int i);
    }

    private static final class BuilderCompat31Impl implements androidx.core.view.ContentInfoCompat.BuilderCompat {

        private final ContentInfo.Builder mPlatformBuilder;
        BuilderCompat31Impl(ClipData clip, int source) {
            super();
            ContentInfo.Builder builder = new ContentInfo.Builder(clip, source);
            this.mPlatformBuilder = builder;
        }

        BuilderCompat31Impl(androidx.core.view.ContentInfoCompat other) {
            super();
            ContentInfo.Builder builder = new ContentInfo.Builder(other.toContentInfo());
            this.mPlatformBuilder = builder;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public androidx.core.view.ContentInfoCompat build() {
            ContentInfoCompat.Compat31Impl compat31Impl = new ContentInfoCompat.Compat31Impl(this.mPlatformBuilder.build());
            ContentInfoCompat contentInfoCompat = new ContentInfoCompat(compat31Impl);
            return contentInfoCompat;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setClip(ClipData clip) {
            this.mPlatformBuilder.setClip(clip);
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setExtras(Bundle extras) {
            this.mPlatformBuilder.setExtras(extras);
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setFlags(int flags) {
            this.mPlatformBuilder.setFlags(flags);
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setLinkUri(Uri linkUri) {
            this.mPlatformBuilder.setLinkUri(linkUri);
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setSource(int source) {
            this.mPlatformBuilder.setSource(source);
        }
    }

    private static final class BuilderCompatImpl implements androidx.core.view.ContentInfoCompat.BuilderCompat {

        ClipData mClip;
        Bundle mExtras;
        int mFlags;
        Uri mLinkUri;
        int mSource;
        BuilderCompatImpl(ClipData clip, int source) {
            super();
            this.mClip = clip;
            this.mSource = source;
        }

        BuilderCompatImpl(androidx.core.view.ContentInfoCompat other) {
            super();
            this.mClip = other.getClip();
            this.mSource = other.getSource();
            this.mFlags = other.getFlags();
            this.mLinkUri = other.getLinkUri();
            this.mExtras = other.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public androidx.core.view.ContentInfoCompat build() {
            ContentInfoCompat.CompatImpl compatImpl = new ContentInfoCompat.CompatImpl(this);
            ContentInfoCompat contentInfoCompat = new ContentInfoCompat(compatImpl);
            return contentInfoCompat;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setClip(ClipData clip) {
            this.mClip = clip;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setExtras(Bundle extras) {
            this.mExtras = extras;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setFlags(int flags) {
            this.mFlags = flags;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setLinkUri(Uri linkUri) {
            this.mLinkUri = linkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat$BuilderCompat
        public void setSource(int source) {
            this.mSource = source;
        }
    }

    private interface Compat {
        public abstract ClipData getClip();

        public abstract Bundle getExtras();

        public abstract int getFlags();

        public abstract Uri getLinkUri();

        public abstract int getSource();

        public abstract ContentInfo getWrapped();
    }

    private static final class Compat31Impl implements androidx.core.view.ContentInfoCompat.Compat {

        private final ContentInfo mWrapped;
        Compat31Impl(ContentInfo wrapped) {
            super();
            this.mWrapped = (ContentInfo)Preconditions.checkNotNull(wrapped);
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public ClipData getClip() {
            return this.mWrapped.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public Bundle getExtras() {
            return this.mWrapped.getExtras();
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public int getFlags() {
            return this.mWrapped.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public Uri getLinkUri() {
            return this.mWrapped.getLinkUri();
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public int getSource() {
            return this.mWrapped.getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public ContentInfo getWrapped() {
            return this.mWrapped;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ContentInfoCompat{").append(this.mWrapped).append("}").toString();
        }
    }

    private static final class CompatImpl implements androidx.core.view.ContentInfoCompat.Compat {

        private final ClipData mClip;
        private final Bundle mExtras;
        private final int mFlags;
        private final Uri mLinkUri;
        private final int mSource;
        CompatImpl(androidx.core.view.ContentInfoCompat.BuilderCompatImpl b) {
            super();
            this.mClip = (ClipData)Preconditions.checkNotNull(b.mClip);
            this.mSource = Preconditions.checkArgumentInRange(b.mSource, 0, 5, "source");
            this.mFlags = Preconditions.checkFlagsArgument(b.mFlags, 1);
            this.mLinkUri = b.mLinkUri;
            this.mExtras = b.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public Bundle getExtras() {
            return this.mExtras;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public ContentInfo getWrapped() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat$Compat
        public String toString() {
            String string;
            String str;
            String str2;
            StringBuilder stringBuilder = new StringBuilder();
            if (this.mLinkUri == null) {
                string = str;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                string = stringBuilder2.append(", hasLinkUri(").append(this.mLinkUri.toString().length()).append(")").toString();
            }
            if (this.mExtras == null) {
            } else {
                str = ", hasExtras";
            }
            return stringBuilder.append("ContentInfoCompat{clip=").append(this.mClip.getDescription()).append(", source=").append(ContentInfoCompat.sourceToString(this.mSource)).append(", flags=").append(ContentInfoCompat.flagsToString(this.mFlags)).append(string).append(str).append("}").toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }
    ContentInfoCompat(androidx.core.view.ContentInfoCompat.Compat compat) {
        super();
        this.mCompat = compat;
    }

    static ClipData buildClipData(ClipDescription description, List<ClipData.Item> list2) {
        int i;
        Object obj;
        ClipDescription clipDescription = new ClipDescription(description);
        ClipData clipData = new ClipData(clipDescription, (ClipData.Item)list2.get(0));
        i = 1;
        while (i < list2.size()) {
            clipData.addItem((ClipData.Item)list2.get(i));
            i++;
        }
        return clipData;
    }

    static String flagsToString(int flags) {
        if (flags & 1 != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(flags);
    }

    static Pair<ClipData, ClipData> partition(ClipData clip, Predicate<ClipData.Item> predicate2) {
        int i3;
        int i;
        int i2;
        ClipData.Item itemAt;
        ArrayList arrayList;
        i3 = 0;
        i = 0;
        i2 = 0;
        while (i2 < clip.getItemCount()) {
            itemAt = clip.getItemAt(i2);
            if (predicate2.test(itemAt)) {
            } else {
            }
            if (i == 0) {
            } else {
            }
            arrayList = i;
            arrayList.add(itemAt);
            i = arrayList;
            i2++;
            arrayList = new ArrayList();
            if (i3 == 0) {
            } else {
            }
            arrayList = i3;
            arrayList.add(itemAt);
            i3 = arrayList;
            arrayList = new ArrayList();
        }
        int i4 = 0;
        if (i3 == 0) {
            return Pair.create(i4, clip);
        }
        if (i == 0) {
            return Pair.create(clip, i4);
        }
        return Pair.create(ContentInfoCompat.buildClipData(clip.getDescription(), i3), ContentInfoCompat.buildClipData(clip.getDescription(), i));
    }

    public static Pair<ContentInfo, ContentInfo> partition(ContentInfo payload, Predicate<ClipData.Item> predicate2) {
        return ContentInfoCompat.Api31Impl.partition(payload, predicate2);
    }

    static String sourceToString(int source) {
        switch (source) {
            case 0:
                return "SOURCE_APP";
            case 1:
                return "SOURCE_CLIPBOARD";
            case 2:
                return "SOURCE_INPUT_METHOD";
            case 3:
                return "SOURCE_DRAG_AND_DROP";
            case 4:
                return "SOURCE_AUTOFILL";
            case 5:
                return "SOURCE_PROCESS_TEXT";
            default:
                return String.valueOf(source);
        }
    }

    public static androidx.core.view.ContentInfoCompat toContentInfoCompat(ContentInfo platContentInfo) {
        ContentInfoCompat.Compat31Impl compat31Impl = new ContentInfoCompat.Compat31Impl(platContentInfo);
        ContentInfoCompat contentInfoCompat = new ContentInfoCompat(compat31Impl);
        return contentInfoCompat;
    }

    public ClipData getClip() {
        return this.mCompat.getClip();
    }

    public Bundle getExtras() {
        return this.mCompat.getExtras();
    }

    public int getFlags() {
        return this.mCompat.getFlags();
    }

    public Uri getLinkUri() {
        return this.mCompat.getLinkUri();
    }

    public int getSource() {
        return this.mCompat.getSource();
    }

    public Pair<androidx.core.view.ContentInfoCompat, androidx.core.view.ContentInfoCompat> partition(Predicate<ClipData.Item> predicate) {
        int i2;
        Object i;
        ClipData clip = this.mCompat.getClip();
        i = 0;
        if (clip.getItemCount() == 1) {
            boolean test = predicate.test(clip.getItemAt(0));
            i2 = test ? this : i;
            if (test) {
            } else {
                i = this;
            }
            return Pair.create(i2, i);
        }
        Pair partition = ContentInfoCompat.partition(clip, predicate);
        if (partition.first == null) {
            return Pair.create(i, this);
        }
        if (partition.second == null) {
            return Pair.create(this, i);
        }
        ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(this);
        ContentInfoCompat.Builder builder2 = new ContentInfoCompat.Builder(this);
        return Pair.create(builder.setClip((ClipData)partition.first).build(), builder2.setClip((ClipData)partition.second).build());
    }

    public ContentInfo toContentInfo() {
        return (ContentInfo)Objects.requireNonNull(this.mCompat.getWrapped());
    }

    public String toString() {
        return this.mCompat.toString();
    }
}
