package com.example.stay_mate.controller.page;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.service.partner.PartnerAdminService;
import com.example.stay_mate.service.partner.PartnerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PageControllerTest {

    @Mock
    private PartnerService partnerService;

    @Mock
    private PartnerAdminService partnerAdminService;

    @InjectMocks
    private PageController pageController;

    @Test
    void testGetHomeRedirect() {
        Partner mockPartner = new Partner(22,"Mock","mockdress","22","mochmail@mail.com","password","22","22","static/logo.png");
        String result = pageController.getHome(mockPartner);
        assertEquals("redirect:/partner/current", result);
    }

    @Test
    void testGetHomeNoRedirect() {
        String result = pageController.getHome(null);
        assertEquals("home", result);
    }
}

