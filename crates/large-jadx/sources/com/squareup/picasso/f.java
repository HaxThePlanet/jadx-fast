package com.squareup.picasso;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;
import l.q;

/* compiled from: ContactsPhotoRequestHandler.java */
/* loaded from: classes2.dex */
class f extends y {

    private static final UriMatcher b = new UriMatcher(-1);
    private final Context a;
    static {
        String str = "com.android.contacts";
        int i2 = 1;
        obj.addURI(str, "contacts/lookup/*/#", i2);
        obj.addURI(str, "contacts/lookup/*", i2);
        obj.addURI(str, "contacts/#/photo", 2);
        obj.addURI(str, "contacts/#", 3);
        obj.addURI(str, "display_photo/#", 4);
    }

    f(Context context) {
        super();
        this.a = context;
    }

    private InputStream j(w wVar) throws java.io.FileNotFoundException {
        Uri contact;
        ContentResolver contentResolver = this.a.getContentResolver();
        int match = f.b.match(wVar.d);
        int i = 1;
        if (match != i) {
            int i2 = 2;
            i2 = 3;
            i = 4;
            if (!(match == 2 || match != 3 || match == 4)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid uri: ";
                wVar = str + wVar.d;
                throw new IllegalStateException(wVar);
            }
            return contentResolver.openInputStream(wVar.d);
        }
        if (ContactsContract.Contacts.lookupContact(contentResolver, wVar.d) == null) {
            return null;
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, contact, true);
    }

    @Override // com.squareup.picasso.y
    public boolean c(w wVar) {
        Uri uri;
        boolean equals;
        boolean z = true;
        if ("content".equals(wVar.d.getScheme())) {
            if (ContactsContract.Contacts.CONTENT_URI.getHost().equals(wVar.d.getHost())) {
                int i = -1;
                wVar = f.b.match(wVar.d) != -1 ? 1 : 0;
            }
        }
        return (f.b.match(wVar.d) != -1 ? 1 : 0);
    }

    @Override // com.squareup.picasso.y
    public y.a f(w wVar, int i) {
        InputStream inputStream = j(wVar);
        if (inputStream == null) {
            return null;
        }
        return new y.a(q.l(inputStream), t.e.DISK);
    }
}
