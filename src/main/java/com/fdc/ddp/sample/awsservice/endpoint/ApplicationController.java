package com.fdc.ddp.sample.awsservice.endpoint;

import com.fdc.ddp.sample.awsservice.model.Merchant;
import com.fdc.ddp.sample.awsservice.service.MerchantService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class ApplicationController {

    @Autowired
    private MerchantService merchantService;

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @PostMapping(path = "/merchants", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Merchant> createMerchant(@RequestBody final Merchant request,HttpServletResponse response) {
        if(logger.isDebugEnabled()) {
            logger.debug("Request received @ createMerchant {}", request);
        }
        return new ResponseEntity<>(merchantService.saveMerchant(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/merchants/{merchantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Merchant> getMerchant(HttpServletRequest request, @PathVariable(value = "merchantId", required = true) final String merchantId,
                                                HttpServletResponse response) {
        if(logger.isDebugEnabled()) {
            logger.debug("Request received @ getMerchant, merchant Id {}", merchantId);
        }
        return new ResponseEntity<>(merchantService.getMerchant(merchantId), HttpStatus.OK);
    }
}
