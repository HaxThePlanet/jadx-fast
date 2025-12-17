package com.google.firebase.database.tubesock;

import android.util.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
class WebSocketHandshake {

    private static final String WEBSOCKET_VERSION = "13";
    private Map<String, String> extraHeaders = null;
    private String nonce = null;
    private String protocol = null;
    private URI url = null;
    public WebSocketHandshake(URI uRI, String string2, Map<String, String> map3) {
        super();
        final int i = 0;
        this.url = uRI;
        this.protocol = string2;
        this.extraHeaders = map3;
        this.nonce = createNonce();
    }

    private String createNonce() {
        int i;
        byte b;
        int i2 = 16;
        final byte[] bArr = new byte[i2];
        final int i4 = 0;
        i = i4;
        while (i < i2) {
            bArr[i] = (byte)rand;
            i++;
        }
        return Base64.encodeToString(bArr, 2);
    }

    private String generateHeader(LinkedHashMap<String, String> linkedHashMap) {
        String string;
        Object next;
        StringBuilder stringBuilder;
        string = new String();
        Iterator iterator = linkedHashMap.keySet().iterator();
        for (String next : iterator) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(next);
            stringBuilder.append(": ");
            stringBuilder.append((String)linkedHashMap.get(next));
            stringBuilder.append("\r\n");
            string = stringBuilder.toString();
        }
        return string;
    }

    private int rand(int i, int i2) {
        return (int)i4;
    }

    public byte[] getHandshake() {
        String string2;
        String string;
        Object extraHeaders;
        int stringBuilder;
        String str;
        String next;
        boolean key;
        String query = this.url.getQuery();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(this.url.getPath());
        if (query == null) {
            string2 = "";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("?");
            stringBuilder2.append(query);
            string2 = stringBuilder2.toString();
        }
        stringBuilder6.append(string2);
        if (this.url.getPort() != -1) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.url.getHost());
            stringBuilder.append(":");
            stringBuilder.append(this.url.getPort());
            string = stringBuilder.toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", string);
        String str4 = "Upgrade";
        linkedHashMap.put(str4, "websocket");
        linkedHashMap.put("Connection", str4);
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.nonce);
        String protocol = this.protocol;
        if (protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", protocol);
        }
        extraHeaders = this.extraHeaders;
        if (extraHeaders != null) {
            extraHeaders = extraHeaders.keySet().iterator();
            while (extraHeaders.hasNext()) {
                next = extraHeaders.next();
                if (!linkedHashMap.containsKey((String)next)) {
                }
                linkedHashMap.put(next, (String)this.extraHeaders.get(next));
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("GET ");
        stringBuilder3.append(stringBuilder6.toString());
        stringBuilder3.append(" HTTP/1.1\r\n");
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder3.toString());
        stringBuilder4.append(generateHeader(linkedHashMap));
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(stringBuilder4.toString());
        stringBuilder5.append("\r\n");
        byte[] bytes = stringBuilder5.toString().getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        int i2 = 0;
        System.arraycopy(bytes, i2, bArr, i2, bytes.length);
        return bArr;
    }

    public void verifyServerHandshakeHeaders(HashMap<String, String> hashMap) {
        String str = "upgrade";
        if (!"websocket".equals(hashMap.get(str))) {
        } else {
            if (!str.equals(hashMap.get("connection"))) {
            } else {
            }
            WebSocketException obj4 = new WebSocketException("connection failed: missing header field in server handshake: Connection");
            throw obj4;
        }
        obj4 = new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
        throw obj4;
    }

    public void verifyServerStatusLine(String string) {
        int obj4 = Integer.parseInt(string.substring(9, 12));
        if (obj4 == 407) {
        } else {
            if (obj4 == 404) {
            } else {
                if (obj4 != 101) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("connection failed: unknown status code ");
                stringBuilder.append(obj4);
                WebSocketException webSocketException = new WebSocketException(stringBuilder.toString());
                throw webSocketException;
            }
            obj4 = new WebSocketException("connection failed: 404 not found");
            throw obj4;
        }
        obj4 = new WebSocketException("connection failed: proxy authentication not supported");
        throw obj4;
    }
}
