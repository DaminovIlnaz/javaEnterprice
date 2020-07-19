package ru.itis.kpfu.hateoasrest.supermarket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.kpfu.hateoasrest.supermarket.models.Supermarket;
import ru.itis.kpfu.hateoasrest.supermarket.services.SupermarketsService;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class SupermarketsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupermarketsService supermarketsService;

    @BeforeEach
    public void setUp(){
        when(supermarketsService.publish(1L)).thenReturn(openedSupermarket());
    }

    @Test
    public void supermarketOpenTest()throws Exception{
        mockMvc.perform(put("/supermarkets/1/open")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value(openedSupermarket().getTitle()))
        .andExpect(jsonPath("$.description").value(openedSupermarket().getDescription()))
        .andExpect(jsonPath("$.state").value(openedSupermarket().getState()))
        .andDo(document("open_supermarket", responseFields(
                fieldWithPath("title").description("Название магазина"),
                fieldWithPath("description").description("Описание супермаркета"),
                fieldWithPath("state").description("Состояние магазина")
        )));
    }

    private Supermarket openedSupermarket(){


        return Supermarket.builder()
                .id(1L)
                .description("Продуктовый магазин для нищебродов. Сам там затариваюсь.")
                .title("5ochka")
                .state("open")
                .build();
    }

}


            /*Не смог записать нормальный
            скринкаст, жестко тормозил ноут*/
