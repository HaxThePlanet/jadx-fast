package com.bumptech.glide.load.engine.z;

/* loaded from: classes.dex */
public final class i implements com.bumptech.glide.load.engine.z.a<int[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int b(Object object) {
        return c((int[])object);
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int c(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int[] d(int i) {
        return new int[i];
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public Object newArray(int i) {
        return d(i);
    }
}
