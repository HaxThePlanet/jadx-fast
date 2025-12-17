package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* loaded from: classes5.dex */
public final class InputContentInfoCompat {

    private final androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl mImpl;

    private interface InputContentInfoCompatImpl {
        public abstract Uri getContentUri();

        public abstract ClipDescription getDescription();

        public abstract Object getInputContentInfo();

        public abstract Uri getLinkUri();

        public abstract void releasePermission();

        public abstract void requestPermission();
    }

    private static final class InputContentInfoCompatApi25Impl implements androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl {

        final InputContentInfo mObject;
        InputContentInfoCompatApi25Impl(Uri contentUri, ClipDescription description, Uri linkUri) {
            super();
            InputContentInfo inputContentInfo = new InputContentInfo(contentUri, description, linkUri);
            this.mObject = inputContentInfo;
        }

        InputContentInfoCompatApi25Impl(Object inputContentInfo) {
            super();
            this.mObject = (InputContentInfo)inputContentInfo;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mObject.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mObject.getDescription();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return this.mObject;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mObject.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public void releasePermission() {
            this.mObject.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public void requestPermission() {
            this.mObject.requestPermission();
        }
    }

    private static final class InputContentInfoCompatBaseImpl implements androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl {

        private final Uri mContentUri;
        private final ClipDescription mDescription;
        private final Uri mLinkUri;
        InputContentInfoCompatBaseImpl(Uri contentUri, ClipDescription description, Uri linkUri) {
            super();
            this.mContentUri = contentUri;
            this.mDescription = description;
            this.mLinkUri = linkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Uri getContentUri() {
            return this.mContentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.mDescription;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Object getInputContentInfo() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public void releasePermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatImpl
        public void requestPermission() {
        }
    }
    public InputContentInfoCompat(Uri contentUri, ClipDescription description, Uri linkUri) {
        super();
        InputContentInfoCompat.InputContentInfoCompatApi25Impl inputContentInfoCompatApi25Impl = new InputContentInfoCompat.InputContentInfoCompatApi25Impl(contentUri, description, linkUri);
        this.mImpl = inputContentInfoCompatApi25Impl;
    }

    private InputContentInfoCompat(androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl impl) {
        super();
        this.mImpl = impl;
    }

    public static androidx.core.view.inputmethod.InputContentInfoCompat wrap(Object inputContentInfo) {
        if (inputContentInfo == null) {
            return null;
        }
        InputContentInfoCompat.InputContentInfoCompatApi25Impl inputContentInfoCompatApi25Impl = new InputContentInfoCompat.InputContentInfoCompatApi25Impl(inputContentInfo);
        InputContentInfoCompat inputContentInfoCompat = new InputContentInfoCompat(inputContentInfoCompatApi25Impl);
        return inputContentInfoCompat;
    }

    public Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    public Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }
}
