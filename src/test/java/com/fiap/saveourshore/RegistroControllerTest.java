package com.fiap.saveourshore;

import com.fiap.saveourshore.controller.RegistroController;
import com.fiap.saveourshore.model.Registro;
import com.fiap.saveourshore.service.RegistroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RegistroControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RegistroService registroService;

    @InjectMocks
    private RegistroController registroController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registroController).build();
    }

    @Test
    void testGetAllRegistros() throws Exception {
        List<Registro> registros = new ArrayList<>();
        when(registroService.getAllRegistros()).thenReturn(registros);

        mockMvc.perform(get("/registro"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(registroService, times(1)).getAllRegistros();
    }

    @Test
    void testGetRegistroById() throws Exception {
        Registro registro = new Registro();
        when(registroService.findById(1L)).thenReturn(registro);

        mockMvc.perform(get("/registro/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(registroService, times(1)).findById(1L);
    }

    @Test
    void testCreateRegistro() throws Exception {
        String jsonRegistro = "{ \"nomePessoa\": \"Josue\", \"cpf\": \"51280660880\", \"descricao\": \"Descrição válida\", \"dataReport\": \"2024-06-25\", \"praia\": { \"id\": 1 },}";

        mockMvc.perform(post("/registro/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRegistro))
                .andExpect(status().isCreated());

        verify(registroService, times(1)).save(any(Registro.class));
    }

    @Test
    void testCreateInvalidRegistro() throws Exception {
        String jsonRegistro = "{ \"nomePessoa\": \"\", \"cpf\": \"\", \"statusPendente\": true, \"descricao\": \"\", \"dataReport\": \"\", \"praia\": { \"id\": 1 }, \"ong\": { \"id\": 1 } }";

        mockMvc.perform(post("/registro/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRegistro))
                .andExpect(status().isBadRequest());

        verify(registroService, never()).save(any(Registro.class));
    }

    @Test
    void testUpdateRegistro() throws Exception {
        String jsonRegistro = "{ \"nomePessoa\": \"Josue\", \"cpf\": \"55243432032\", \"statusPendente\": true, \"descricao\": \"Descrição válida\", \"dataReport\": \"2024-06-25\", \"praia\": { \"id\": 1 }, \"ong\": { \"id\": 1 } }";

        mockMvc.perform(put("/registro/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRegistro))
                .andExpect(status().isOk());

        verify(registroService, times(1)).update(any(Registro.class));
    }

    @Test
    void testDeleteRegistro() throws Exception {
        doNothing().when(registroService).delete(1L);

        mockMvc.perform(delete("/registro/1"))
                .andExpect(status().isOk());

        verify(registroService, times(1)).delete(1L);
    }
}

