package eu.deeper.task.service;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public interface TaskService {
    Point2D[] findIntersectionPoints(Line2D.Double line, Rectangle2D.Double rectangle);
}
