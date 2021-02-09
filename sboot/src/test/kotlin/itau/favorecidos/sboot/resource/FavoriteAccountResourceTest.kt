package itau.favorecidos.sboot.resource

import com.fasterxml.jackson.databind.ObjectMapper
import itau.favorecidos.application.request.CreateRequest
import itau.favorecidos.application.request.UpdateRequest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@Tag("integration")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class FavoriteAccountResourceTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    companion object {
        const val FAVORITE_URL = "/favorite"
    }

    @Test
    fun `when document is not valid then return BAD REQUEST`() {
        val request = CreateRequest(1, "123", 1, "12345678900", "Teste")

        mockMvc.perform(
            MockMvcRequestBuilders.post(FAVORITE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

    @Test
    fun `when document is valid then return CREATED`() {
        val request = CreateRequest(1, "123", 1, "74.063.458/0001-26", "Teste")

        mockMvc.perform(
            MockMvcRequestBuilders.post(FAVORITE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isCreated)
    }

    @Test
    fun `when searching favorite not exists then return NOT FOUND` () {
        mockMvc.perform(
            MockMvcRequestBuilders.get("$FAVORITE_URL/{id}" ,1)
        ).andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `when searching favorite exists then return OK` () {
        val request = CreateRequest(1, "123", 1, "74.063.458/0001-26", "Teste")

        mockMvc.perform(
            MockMvcRequestBuilders.post(FAVORITE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isCreated)

        mockMvc.perform(
            MockMvcRequestBuilders.get("$FAVORITE_URL/{id}" ,1)
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `when deleting favorite not exists then return NOT FOUND` () {
        mockMvc.perform(
            MockMvcRequestBuilders.delete("$FAVORITE_URL/{id}" ,1)
        ).andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `when deleting favorite exists then return NO CONTENT` () {
        val request = CreateRequest(1, "123", 1, "74.063.458/0001-26", "Teste")

        mockMvc.perform(
            MockMvcRequestBuilders.post(FAVORITE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isCreated)

        mockMvc.perform(
            MockMvcRequestBuilders.delete("$FAVORITE_URL/{id}" ,1)
        ).andExpect(MockMvcResultMatchers.status().isNoContent)
    }

    @Test
    fun `when updating favorite not exists then return NOT FOUND` () {
        val updateRequest = UpdateRequest("1234", 2)
        mockMvc.perform(
            MockMvcRequestBuilders.put("$FAVORITE_URL/{id}" ,1)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(updateRequest))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isNotFound)
    }

    @Test
    fun `when updating favorite exists then return OK` () {
        val createRequest = CreateRequest(1, "123", 1, "74.063.458/0001-26", "Teste")
        val updateRequest = UpdateRequest("1234", 2)

        mockMvc.perform(
            MockMvcRequestBuilders.post(FAVORITE_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(createRequest))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isCreated)

        mockMvc.perform(
            MockMvcRequestBuilders.put("$FAVORITE_URL/{id}" ,1)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(updateRequest))
                .accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }

}