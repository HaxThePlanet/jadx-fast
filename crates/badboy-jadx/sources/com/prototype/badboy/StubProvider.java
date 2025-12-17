package com.prototype.badboy;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016JK\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0008\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000b2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000b2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000cH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J/\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0017J9\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0010\r\u001a\u0004\u0018\u00010\u000c2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001a", d2 = {"Lcom/prototype/badboy/StubProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "u", "Landroid/net/Uri;", "p", "", "", "s", "a", "o", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "v", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class StubProvider extends ContentProvider {

    public static final int $stable;
    static {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri u, String s, String[] a) {
        Intrinsics.checkNotNullParameter(u, "u");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri u) {
        Intrinsics.checkNotNullParameter(u, "u");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri u, ContentValues v) {
        Intrinsics.checkNotNullParameter(u, "u");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return 1;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri u, String[] p, String s, String[] a, String o) {
        Intrinsics.checkNotNullParameter(u, "u");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri u, ContentValues v, String s, String[] a) {
        Intrinsics.checkNotNullParameter(u, "u");
        return 0;
    }
}
