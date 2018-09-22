package eu.deeper.task.controller;

import eu.deeper.task.payload.request.CheckIntersectionRequest;
import eu.deeper.task.payload.response.CheckIntersectionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskApi {

    @PostMapping("/intersection")
    public ResponseEntity<CheckIntersectionResponse> checkIntersection(@RequestBody CheckIntersectionRequest request){

        return ResponseEntity.ok(new CheckIntersectionResponse(request.getLine().intersects(request.getSquare())));
    }
}
