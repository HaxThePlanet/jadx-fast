package com.bumptech.glide.r;

/* loaded from: classes.dex */
public interface e {

    public static enum a {

        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);

        private final boolean isComplete;
        @Override // java.lang.Enum
        boolean isComplete() {
            return this.isComplete;
        }
    }
    public abstract void a(com.bumptech.glide.r.d d);

    public abstract boolean b();

    public abstract com.bumptech.glide.r.e c();

    public abstract boolean f(com.bumptech.glide.r.d d);

    public abstract boolean h(com.bumptech.glide.r.d d);

    public abstract void j(com.bumptech.glide.r.d d);

    public abstract boolean l(com.bumptech.glide.r.d d);
}
