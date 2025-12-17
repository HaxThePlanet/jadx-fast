package com.google.firebase.inappmessaging.display.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.j;
import com.bumptech.glide.k;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.m.g;
import com.bumptech.glide.load.m.j.a;
import com.bumptech.glide.r.a;
import com.bumptech.glide.r.k.c;
import com.bumptech.glide.r.l.d;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class FiamImageLoader {

    private final k requestManager;
    private final Map<String, Set<c>> tags;

    public class FiamImageRequestCreator {

        private final j<Drawable> requestBuilder;
        private String tag;
        private com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback target;
        final com.google.firebase.inappmessaging.display.internal.FiamImageLoader this$0;
        public FiamImageRequestCreator(com.google.firebase.inappmessaging.display.internal.FiamImageLoader fiamImageLoader, j j2) {
            this.this$0 = fiamImageLoader;
            super();
            this.requestBuilder = j2;
        }

        private void checkAndTag() {
            com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback target;
            Object hashSet;
            Object tag;
            boolean contains;
            String tag2;
            if (this.target != null) {
                if (TextUtils.isEmpty(this.tag)) {
                } else {
                    Map map = FiamImageLoader.access$000(this.this$0);
                    synchronized (map) {
                        hashSet = FiamImageLoader.access$000(this.this$0).get(this.tag);
                        if (!hashSet.contains(this.target)) {
                            hashSet.add(this.target);
                        }
                    }
                }
            }
        }

        public void into(ImageView imageView, com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback fiamImageLoader$Callback2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downloading Image Callback : ");
            stringBuilder.append(callback2);
            Logging.logd(stringBuilder.toString());
            callback2.setImageView(imageView);
            this.requestBuilder.z0(callback2);
            this.target = callback2;
            checkAndTag();
        }

        public com.google.firebase.inappmessaging.display.internal.FiamImageLoader.FiamImageRequestCreator placeholder(int i) {
            this.requestBuilder.Z(i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downloading Image Placeholder : ");
            stringBuilder.append(i);
            Logging.logd(stringBuilder.toString());
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.FiamImageLoader.FiamImageRequestCreator tag(Class class) {
            this.tag = class.getSimpleName();
            checkAndTag();
            return this;
        }
    }

    public static abstract class Callback extends c<Drawable> {

        private ImageView imageView;
        private void setImage(Drawable drawable) {
            final ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // com.bumptech.glide.r.k.c
        public abstract void onError(Exception exception);

        @Override // com.bumptech.glide.r.k.c
        public void onLoadCleared(Drawable drawable) {
            Logging.logd("Downloading Image Cleared");
            setImage(drawable);
            onSuccess();
        }

        @Override // com.bumptech.glide.r.k.c
        public void onLoadFailed(Drawable drawable) {
            Logging.logd("Downloading Image Failed");
            setImage(drawable);
            Exception obj2 = new Exception("Image loading failed!");
            onError(obj2);
        }

        public void onResourceReady(Drawable drawable, d<? super Drawable> d2) {
            Logging.logd("Downloading Image Success!!!");
            setImage(drawable);
            onSuccess();
        }

        @Override // com.bumptech.glide.r.k.c
        public void onResourceReady(Object object, d d2) {
            onResourceReady((Drawable)object, d2);
        }

        @Override // com.bumptech.glide.r.k.c
        public abstract void onSuccess();

        @Override // com.bumptech.glide.r.k.c
        void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }
    public FiamImageLoader(k k) {
        super();
        HashMap hashMap = new HashMap();
        this.tags = hashMap;
        this.requestManager = k;
    }

    static Map access$000(com.google.firebase.inappmessaging.display.internal.FiamImageLoader fiamImageLoader) {
        return fiamImageLoader.tags;
    }

    public void cancelTag(Class class) {
        boolean iterator;
        boolean next;
        k requestManager;
        final String obj4 = class.getSimpleName();
        synchronized (obj4) {
            iterator = (Set)this.tags.get(obj4).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((c)next != null) {
                }
                this.requestManager.e((c)next);
            }
            try {
                throw th;
            }
        }
    }

    boolean containsTag(String string) {
        Map tags;
        Object obj2;
        tags = this.tags;
        if (tags != null && tags.containsKey(string) && this.tags.get(string) != null && (Set)this.tags.get(string).size() > 0) {
            if (tags.containsKey(string)) {
                if (this.tags.get(string) != null) {
                    obj2 = (Set)this.tags.get(string).size() > 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public com.google.firebase.inappmessaging.display.internal.FiamImageLoader.FiamImageRequestCreator load(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Starting Downloading Image : ");
        stringBuilder.append(string);
        Logging.logd(stringBuilder.toString());
        j.a aVar = new j.a();
        aVar.b("Accept", "image/*");
        g gVar = new g(string, aVar.c());
        FiamImageLoader.FiamImageRequestCreator fiamImageRequestCreator = new FiamImageLoader.FiamImageRequestCreator(this, (j)this.requestManager.l(gVar).n(b.PREFER_ARGB_8888));
        return fiamImageRequestCreator;
    }
}
