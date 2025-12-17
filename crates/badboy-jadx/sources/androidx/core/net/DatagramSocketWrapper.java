package androidx.core.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;

/* loaded from: classes5.dex */
class DatagramSocketWrapper extends Socket {

    private static class DatagramSocketImplWrapper extends SocketImpl {
        DatagramSocketImplWrapper(DatagramSocket socket, FileDescriptor fd) {
            super();
            this.localport = socket.getLocalPort();
            this.fd = fd;
        }

        protected void accept(SocketImpl newSocket) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected int available() throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void bind(InetAddress address, int port) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void close() throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void connect(String host, int port) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void connect(InetAddress address, int port) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void create(boolean isStreaming) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected InputStream getInputStream() throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public Object getOption(int optID) throws SocketException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected OutputStream getOutputStream() throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void listen(int backlog) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        protected void sendUrgentData(int value) throws IOException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }

        public void setOption(int optID, Object val) throws SocketException {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
    DatagramSocketWrapper(DatagramSocket socket, FileDescriptor fd) throws SocketException {
        DatagramSocketWrapper.DatagramSocketImplWrapper datagramSocketImplWrapper = new DatagramSocketWrapper.DatagramSocketImplWrapper(socket, fd);
        super(datagramSocketImplWrapper);
    }
}
