package br.com.lucasmancan.math;

import br.com.lucasmancan.math.models.Operation;
import br.com.lucasmancan.math.models.OperationType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OperatorController.class)
public class OperatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();


    @Test
    public void shouldSumValues() throws Exception {

        Integer[] values = new Integer[]{1,2,3,4,5};
        Operation operation = new Operation(OperationType.soma,Arrays.asList(values) );

        mockMvc.perform(post("/api/v1")
                .content(mapper.writeValueAsString(operation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(15));

    }

    @Test
    public void shouldSubtractValues() throws Exception {

        Integer[] values = new Integer[]{1,2,3,4,5};
        Operation operation = new Operation(OperationType.subtrai,Arrays.asList(values) );

        mockMvc.perform(post("/api/v1")
                .content(mapper.writeValueAsString(operation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(-13));

    }

    @Test
    public void shouldCalculateAverageOfValues() throws Exception {

        Integer[] values = new Integer[]{1,2,3,4,5};
        Operation operation = new Operation(OperationType.media,Arrays.asList(values) );

        mockMvc.perform(post("/api/v1")
                .content(mapper.writeValueAsString(operation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(3));

    }

    @Test
    public void shouldCountValues() throws Exception {

        Integer[] values = new Integer[]{1,2,3,4,5};
        Operation operation = new Operation(OperationType.total,Arrays.asList(values) );

        mockMvc.perform(post("/api/v1")
                .content(mapper.writeValueAsString(operation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(5));

    }


}
