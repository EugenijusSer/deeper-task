package eu.deeper.task.payload.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.awt.geom.Rectangle2D;

public class Square extends Rectangle2D.Double {
    @JsonCreator
    public Square(@JsonProperty("x") double x, @JsonProperty("y") double y, @JsonProperty("side") double side){
        super(x,y,side,side);
    }
}
