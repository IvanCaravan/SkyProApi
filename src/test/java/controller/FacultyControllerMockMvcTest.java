package controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.hogwarts.controller.FacultyController;
import ru.hogwarts.model.Faculty;
import ru.hogwarts.repository.FacultyRepository;
import ru.hogwarts.service.FacultyServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FacultyController.class)
public class FacultyControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;
    @SpyBean
    private FacultyServiceImpl facultyService;
    @MockBean
    private FacultyRepository facultyRepository;

    @Test
    public void testGetFacultyById() throws Exception {

        when(facultyRepository.findById(1L)).thenReturn(Optional.of(new Faculty("new faculty", "red")));

        mockMvc.perform(MockMvcRequestBuilders.get("/faculty/1"))
                .andExpect(status().isOk());
        verify(facultyRepository, times(1)).findById(1L);
        verify(facultyService, times(1)).getFaculty(1L);
    }
}
