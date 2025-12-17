package retrofit2;

import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
final class SkipCallbackExecutorImpl implements retrofit2.SkipCallbackExecutor {

    private static final retrofit2.SkipCallbackExecutor INSTANCE;
    static {
        SkipCallbackExecutorImpl skipCallbackExecutorImpl = new SkipCallbackExecutorImpl();
        SkipCallbackExecutorImpl.INSTANCE = skipCallbackExecutorImpl;
    }

    static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        final int i2 = 1;
        Annotation[] arr = new Annotation[length += i2];
        final int i3 = 0;
        arr[i3] = SkipCallbackExecutorImpl.INSTANCE;
        System.arraycopy(annotationArr, i3, arr, i2, annotationArr.length);
        return arr;
    }

    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // retrofit2.SkipCallbackExecutor
    public boolean equals(Object object) {
        return object instanceof SkipCallbackExecutor;
    }

    @Override // retrofit2.SkipCallbackExecutor
    public int hashCode() {
        return 0;
    }

    @Override // retrofit2.SkipCallbackExecutor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@");
        stringBuilder.append(SkipCallbackExecutor.class.getName());
        stringBuilder.append("()");
        return stringBuilder.toString();
    }
}
