package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;
import l.q;

/* loaded from: classes2.dex */
class f extends com.squareup.picasso.y {

    private static final UriMatcher b;
    private final Context a;
    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f.b = uriMatcher;
        String str = "com.android.contacts";
        int i2 = 1;
        uriMatcher.addURI(str, "contacts/lookup/*/#", i2);
        uriMatcher.addURI(str, "contacts/lookup/*", i2);
        uriMatcher.addURI(str, "contacts/#/photo", 2);
        uriMatcher.addURI(str, "contacts/#", 3);
        uriMatcher.addURI(str, "display_photo/#", 4);
    }

    f(Context context) {
        super();
        this.a = context;
    }

    private InputStream j(com.squareup.picasso.w w) {
        int i2;
        int i;
        Uri obj5;
        ContentResolver contentResolver = this.a.getContentResolver();
        obj5 = w.d;
        int match = f.b.match(obj5);
        i2 = 1;
        if (match != i2 && match != 2 && match != 3) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid uri: ");
                    stringBuilder.append(obj5);
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
                }
                return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, obj5, i2);
            }
            return contentResolver.openInputStream(obj5);
        }
        if (ContactsContract.Contacts.lookupContact(contentResolver, obj5) == null) {
            return null;
        }
    }

    @Override // com.squareup.picasso.y
    public boolean c(com.squareup.picasso.w w) {
        int equals;
        String equals2;
        int obj4;
        equals = w.d;
        if ("content".equals(equals.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(equals.getHost()) && f.b.match(w.d) != -1) {
            if (ContactsContract.Contacts.CONTENT_URI.getHost().equals(equals.getHost())) {
                obj4 = f.b.match(w.d) != -1 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj4;
    }

    @Override // com.squareup.picasso.y
    public com.squareup.picasso.y.a f(com.squareup.picasso.w w, int i2) {
        InputStream obj2 = j(w);
        if (obj2 == null) {
            return null;
        }
        y.a obj3 = new y.a(q.l(obj2), t.e.DISK);
        return obj3;
    }
}
