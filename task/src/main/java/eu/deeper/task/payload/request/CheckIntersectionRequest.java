package eu.deeper.task.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import eu.deeper.task.payload.model.Square;

import java.awt.geom.Line2D;

public class CheckIntersectionRequest {
    private Square square;
    private Line2D.Double line;

    @JsonCreator
    public CheckIntersectionRequest(@JsonProperty(value = "square", required = true) Square square,
                                    @JsonProperty(value = "line", required = true) Line2D.Double line){
        this.square = square;
        this.line = line;
    }

    public Square getSquare() {
        return square;
    }

    public Line2D getLine() {
        return line;
    }
}
