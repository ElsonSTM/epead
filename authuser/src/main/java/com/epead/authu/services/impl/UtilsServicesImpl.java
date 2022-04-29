package com.epead.authu.services.impl;

import com.epead.authu.services.UtilsService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilsServicesImpl implements UtilsService {

    String REQUEST_URI = "http://localhost:8082";

    public String createUrl(UUID userId, Pageable pageable) {
        return REQUEST_URI + "/courses?userId=" + userId + "&page=" + pageable.getPageNumber() + "&size="
                + pageable.getPageSize() + "&sort=" + pageable.getSort().toString().replaceAll(": ", ",");

    }
}