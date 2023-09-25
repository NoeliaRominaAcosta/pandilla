package com.api.pandilla.controllers;

import com.api.pandilla.services.FamiliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FamilyController {
    @Autowired
    FamiliesService service;
}
