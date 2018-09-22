package eu.deeper.task.payload.response;

public class CheckIntersectionResponse {
    private boolean intersect;

    public CheckIntersectionResponse(boolean intersect) {
        this.intersect = intersect;
    }

    public boolean isIntersect() {
        return intersect;
    }
}
