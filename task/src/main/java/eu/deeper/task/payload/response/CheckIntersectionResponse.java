package eu.deeper.task.payload.response;

import java.awt.geom.Point2D;

public class CheckIntersectionResponse {
    private boolean intersect;
    private Point2D[] intersectionPoints;

    public CheckIntersectionResponse(boolean intersect, Point2D[] intersectionPoints) {
        this.intersect = intersect;
        this.intersectionPoints = intersectionPoints;
    }

    public boolean isIntersect() {
        return intersect;
    }

    public Point2D[] getIntersectionPoints() {
        return intersectionPoints;
    }
}
