package com.another.product.service.item.create;

import com.another.product.client.request.CreateItemRestRequest;
import com.another.product.core.item.create.CreateItem;
import com.another.product.service.common.Randomizer;
import com.another.product.service.constant.Routes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(CreateItemController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@MockBean(CreateItem.class)
class CreateItemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void givenRequest_whenCreate_shouldReturnOk() {
        CreateItemRestRequest request = Randomizer.get(CreateItemRestRequest.class);
        String requestBody = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post(Routes.ITEM)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().is(201));
    }
}
