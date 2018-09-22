package eu.deeper.task.service;

import org.springframework.stereotype.Service;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Service
public class DefaultTaskService implements TaskService {

    @Override
    public Point2D[] findIntersectionPoints(Line2D.Double line, Rectangle2D.Double rectangle) {
        Point2D[] intersectionPoints = new Point2D[4];

        // Top line
        intersectionPoints[0] = getIntersectionPoint(line,
                new Line2D.Double(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getX() + rectangle.getWidth(),
                        rectangle.getY()));
        // Bottom line
        intersectionPoints[1] = getIntersectionPoint(line,
                new Line2D.Double(
                        rectangle.getX(),
                        rectangle.getY() + rectangle.getHeight(),
                        rectangle.getX() + rectangle.getWidth(),
                        rectangle.getY() + rectangle.getHeight()));
        // Left side
        intersectionPoints[2] = getIntersectionPoint(line,
                new Line2D.Double(
                        rectangle.getX(),
                        rectangle.getY(),
                        rectangle.getX(),
                        rectangle.getY() + rectangle.getHeight()));
        // Right side
        intersectionPoints[3] = getIntersectionPoint(line,
                new Line2D.Double(
                        rectangle.getX() + rectangle.getWidth(),
                        rectangle.getY(),
                        rectangle.getX() + rectangle.getWidth(),
                        rectangle.getY() + rectangle.getHeight()));

        return intersectionPoints;
    }

    private Point2D.Double getIntersectionPoint(Line2D.Double pLine1, Line2D.Double pLine2)
    {
        Point2D.Double result = null;

        double
                s1_x = pLine1.x2 - pLine1.x1,
                s1_y = pLine1.y2 - pLine1.y1,

                s2_x = pLine2.x2 - pLine2.x1,
                s2_y = pLine2.y2 - pLine2.y1,

                s = (-s1_y * (pLine1.x1 - pLine2.x1) + s1_x * (pLine1.y1 - pLine2.y1)) / (-s2_x * s1_y + s1_x * s2_y),
                t = ( s2_x * (pLine1.y1 - pLine2.y1) - s2_y * (pLine1.x1 - pLine2.x1)) / (-s2_x * s1_y + s1_x * s2_y);

        if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
            // Collision detected
            result = new Point2D.Double((pLine1.x1 + (t * s1_x)), (pLine1.y1 + (t * s1_y)));
        }

        return result;
    }
}
