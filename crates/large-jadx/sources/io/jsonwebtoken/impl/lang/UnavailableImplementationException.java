package io.jsonwebtoken.impl.lang;

/* compiled from: UnavailableImplementationException.java */
/* loaded from: classes3.dex */
public final class UnavailableImplementationException extends RuntimeException {

    private static final String DEFAULT_NOT_FOUND_MESSAGE = "Unable to find an implementation for %s using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.";
    UnavailableImplementationException(Class cls) {
        Object[] arr = new Object[1];
        super(String.format("Unable to find an implementation for %s using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.", new Object[] { cls }));
    }
}
