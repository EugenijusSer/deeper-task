package eu.deeper.task.controller;

import eu.deeper.task.payload.request.CheckIntersectionRequest;
import eu.deeper.task.payload.response.CheckIntersectionResponse;
import eu.deeper.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@RestController
@RequestMapping("/api")
public class TaskApi {

    private final TaskService taskService;

    @Autowired
    public TaskApi(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/intersection")
    public ResponseEntity<CheckIntersectionResponse> checkIntersection(@RequestBody CheckIntersectionRequest request){
        Line2D.Double line = request.getLine();
        Rectangle2D.Double square = request.getSquare();
        boolean intersect = line.intersects(square);
        Point2D[] intersectionPoints = taskService.findIntersectionPoints(line,square);

        return ResponseEntity.ok(new CheckIntersectionResponse(intersect,intersectionPoints));
    }
}
