package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultCompressionCodecResolver implements CompressionCodecResolver {

    private static final String MISSING_COMPRESSION_MESSAGE = "Unable to find an implementation for compression algorithm [%s] using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.";
    private final Map<String, CompressionCodec> codecs;
    public DefaultCompressionCodecResolver() {
        Object next;
        String upperCase;
        super();
        HashMap hashMap = new HashMap();
        Iterator iterator = Services.loadAll(CompressionCodec.class).iterator();
        for (CompressionCodec next : iterator) {
            hashMap.put(next.getAlgorithmName().toUpperCase(), next);
        }
        CompressionCodec dEFLATE = CompressionCodecs.DEFLATE;
        hashMap.put(dEFLATE.getAlgorithmName().toUpperCase(), dEFLATE);
        CompressionCodec gZIP = CompressionCodecs.GZIP;
        hashMap.put(gZIP.getAlgorithmName().toUpperCase(), gZIP);
        this.codecs = Collections.unmodifiableMap(hashMap);
    }

    private CompressionCodec byName(String string) {
        Assert.hasText(string, "'name' must not be empty");
        Object obj = this.codecs.get(string.toUpperCase());
        if ((CompressionCodec)obj == null) {
        } else {
            return (CompressionCodec)obj;
        }
        Object[] arr = new Object[1];
        CompressionException compressionException = new CompressionException(String.format("Unable to find an implementation for compression algorithm [%s] using java.util.ServiceLoader. Ensure you include a backing implementation .jar in the classpath, for example jjwt-impl.jar, or your own .jar for custom implementations.", string));
        throw compressionException;
    }

    private String getAlgorithmFromHeader(Header header) {
        Assert.notNull(header, "header cannot be null.");
        return header.getCompressionAlgorithm();
    }

    @Override // io.jsonwebtoken.CompressionCodecResolver
    public CompressionCodec resolveCompressionCodec(Header header) {
        String obj2 = getAlgorithmFromHeader(header);
        if (!Strings.hasText(obj2)) {
            return null;
        }
        return byName(obj2);
    }
}
