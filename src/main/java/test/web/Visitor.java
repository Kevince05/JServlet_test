package test.web;

public class Visitor {
	private String ip;
    private int port;
    private String timestamp;
    private long id;
    private String url;
    public static long nextId = 0;
    
    public Visitor(String ip, int port, String timestamp, String url) {
        this.ip = ip;
        this.port = port;
        this.timestamp = timestamp;
        this.id = Visitor.nextId;
        Visitor.nextId++;
        this.url = url;
    }

	public long getId() {
		return id;
	}
    public String getIp() {
        return ip;
    }
    public int getPort() {
        return port;
    }
    public String getTimestamp() {
        return timestamp;
    }
	public String getUrl() {
		return url;
	}
}
