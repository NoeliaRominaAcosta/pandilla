package com.api.pandilla.services;

import com.api.pandilla.repositories.IFamiliesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliesService {
    @Autowired
    IFamiliesRepository familiesRepository;
}
