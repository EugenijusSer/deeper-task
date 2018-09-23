package eu.deeper.task;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TaskApiIT {

    @Autowired
    private MockMvc mockMvc;

    private JSONObject intersectionRequest;

    @Before
    public void initialize() throws JSONException {
        intersectionRequest = new JSONObject();
        JSONObject square = new JSONObject();
        square.put("side", 5);
        square.put("x", 1);
        square.put("y", 1);
        intersectionRequest.put("square",square);

        JSONObject line = new JSONObject();
        line.put("x1", 3);
        line.put("y1", 0);
        line.put("x2", 3);
        line.put("y2", 3);
        intersectionRequest.put("line",line);
    }

    @Test
    public void checkIntersection() throws Exception {
        this.mockMvc.perform(post("/api/intersection")
                .contentType(MediaType.APPLICATION_JSON)
                .content(intersectionRequest.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{'intersect': true, 'intersectionPoints' : [{'x':3,'y':1},null,null,null]}"));
    }

    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get("/api/requests"))
                .andExpect(unauthenticated())
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void invalidUser() throws Exception {
        this.mockMvc.perform(get("/api/requests")
                .with(httpBasic("user", "secret")))
                .andExpect(unauthenticated())
                .andExpect(status().isUnauthorized());
    }
}
