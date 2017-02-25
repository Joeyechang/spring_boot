package com.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.github.swagger2markup.Swagger2MarkupConverter;
import io.swagger.config.SwaggerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: mike
 * @since: 2017/2/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringFoxSwagger2MarkupApplication.class, SwaggerConfig.class})
@AutoConfigureMockMvc
@WebAppConfiguration
public class Swagger2MarkupTests {

    private static final Logger LOG = LoggerFactory.getLogger(Swagger2MarkupTests.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createSpringFoxSwaggerJson() throws Exception {
        //String designFirstSwaggerLocation = Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();

        String outputDir = System.getProperty("io.springfox.staticdocs.outputDir"); // mvn test
//        String outputDir = "D:\\workspace\\springfox-swagger2-demo\\target\\swagger"; // run as

        LOG.info("--------------------outputDir: {}--------------------", outputDir);
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                                          .andExpect(status().isOk())
                                          .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
            writer.write(swaggerJson);
        }
        LOG.info("--------------------swaggerJson create --------------------");
    }

}
