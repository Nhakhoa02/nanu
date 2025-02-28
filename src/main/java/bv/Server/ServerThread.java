package bv.Server;

/**
 * 
 * The ServerThread class implements the Runnable interface and allows the
 * Server to run on a separate thread.
 * 
 */
public class ServerThread implements Runnable {

    public synchronized void requestStop() {
        server.closeServerSocket();
    }

    private Server server;

    public ServerThread(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        server.startServer();
    }
}
