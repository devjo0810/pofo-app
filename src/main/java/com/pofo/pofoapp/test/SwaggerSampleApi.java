package com.pofo.pofoapp.test;

/**
 * packageName    : com.pofo.pofoapp.test
 * fileName       : SwaggerSampleApi
 * author         : joyousang
 * date           : 2023/05/27
 * description    :
 */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SwaggerSampleApi {

    @Operation(summary = "get sample", description = "샘플")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<String> sample(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "index", required = false) String index
    ) {
        return ResponseEntity.ok("OK");
    }
}
