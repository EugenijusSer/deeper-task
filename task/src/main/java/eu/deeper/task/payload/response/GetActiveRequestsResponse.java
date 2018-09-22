package eu.deeper.task.payload.response;

public class GetActiveRequestsResponse {
    private int activeRequests;

    public GetActiveRequestsResponse(int activeRequests) {
        this.activeRequests = activeRequests;
    }

    public int getActiveRequests() {
        return activeRequests;
    }
}
