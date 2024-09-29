package com.theaudio.springSecurityAuth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefautlMessage() throws Exception {
        mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void userLoginTest() throws Exception {
        mockMvc.perform(formLogin("/login").user("dbuser").password("user")).andExpect(authenticated());
    }
    @Test
    public void userLoginFailed() throws Exception {
        mockMvc.perform(formLogin("/login").user("dbuser").password("wrong password")).andExpect(authenticated());
    }
    @Test
    public void  shouldReturnUserPage() throws Exception {
        mockMvc.perform(get("/user")).andDo(print()).andExpect(status().isOk());
    }
}
