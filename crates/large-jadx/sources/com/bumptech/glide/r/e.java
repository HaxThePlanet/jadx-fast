package com.bumptech.glide.r;

/* compiled from: RequestCoordinator.java */
/* loaded from: classes.dex */
public interface e {

    public enum a {

        CLEARED,
        FAILED,
        PAUSED,
        RUNNING,
        SUCCESS;

        private final boolean isComplete;
        @Override // java.lang.Enum
        boolean isComplete() {
            return this.isComplete;
        }
    }
    void a(d dVar);

    boolean b();

    e c();

    boolean f(d dVar);

    boolean h(d dVar);

    void j(d dVar);

    boolean l(d dVar);
}
